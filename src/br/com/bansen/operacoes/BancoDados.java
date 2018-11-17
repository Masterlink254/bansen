package br.com.bansen.operacoes;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BancoDados {
    public static Connection getConn(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");    
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Sentinela", "root", "");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em encontrar a classe. Erro 2: " + ex);
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em acessar o banco de dados. Erro 3: " + erro);
        }
        return con;
    }
    protected static void Inserir(Map map, String Tabela){
        Set<String> chaves = map.keySet();
        Iterator it = chaves.iterator();
        String query = "INSERT INTO " + Tabela +" (";
        while(it.hasNext()){
            Object chave = it.next();
            query += chave+", ";
        }
        query = query.substring(0, query.length()-2);
        query += ") VALUES (";
        it = chaves.iterator();
        while(it.hasNext()){
             Object chave = it.next();
             query += "?, ";
        }
        query = query.substring(0, query.length()-2);
        query += ")";

        try{
            Connection con = BancoDados.getConn();

            PreparedStatement Stmt = con.prepareStatement(query);
            it = chaves.iterator();
            Integer i = 1;
            while(it.hasNext()){
                Object chave = it.next();
                String valor = (String) map.get(chave);
                Stmt.setString(i, valor.toUpperCase());
                i++;
           }
           try{                
                Stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
           } catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro em salvar os dados. Erro 1: " + erro);
           }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em acessar o banco de dados. Erro 3: " + erro);
        }
    }
    protected static void Atualizar(Map map, String Tabela){
        Set<String> chaves = map.keySet();
        Iterator it = chaves.iterator();

        String query = "UPDATE "+Tabela+" SET ";
        while(it.hasNext()){
            Object chave = it.next();
            if(!chave.equals("id")){
                query += chave+" = ? , ";
            }
        }
        query = query.substring(0, query.length()-2);
        query += " WHERE id = ?";

        try{
            Connection con = BancoDados.getConn();

            PreparedStatement Stmt = con.prepareStatement(query);
            it = chaves.iterator();
            Integer i = 1;
            while(it.hasNext()){
                Object chave = it.next();
                String valor = (String) map.get(chave);
                if(!chave.equals("id")){
                    Stmt.setString(i, valor.toUpperCase());
                    i++;
                }
           }
           Stmt.setString(i, (String) map.get("id"));
           try{                
                Stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
           } catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro em salvar os dados. Erro : " + erro);
           }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em acessar o banco de dados!");
        }

    }
    public static void Salvar(Map map, String Tabela, String Tipo){
        if(map.containsKey("id") && !map.get("id").equals("")){
            BancoDados.Atualizar(map, Tabela);
        } else {
            map.remove("id");
            if(Tipo.equals("Muitos")){
                BancoDados.InserirMuitos(map, Tabela);
            }else{
                BancoDados.Inserir(map, Tabela);
            }

        }
    }
    public static void Deletar(String Tabela, String ID){
            try {//procura a classe Driver
            Connection con = BancoDados.getConn();

            //Excluindo dados no banco de dados
            String query = "Delete FROM "+ Tabela +" WHERE  Id = (?)";

            //Cria comando Statement
            PreparedStatement Stmt = con.prepareStatement(query);

            //seta o valor em interregoação da variavel SQL query
            Stmt.setString(1, ID);

            try{                
            //aqui salva os dados no BD
            Stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
            }
            catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro em salvar os dados. Erro : " + erro);
            }

            //fecha o BD e o comando
            Stmt.close();
            con.close();

        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em acessar o banco de dados!");
        }
    }
    public static void Localizar(Map campos, String Tabela, JTable jtable){

        Set<String> chaves = campos.keySet();
        Iterator it = chaves.iterator();
        String query = "SELECT * FROM "+ Tabela +" WHERE ";
        int contador = 0;
        while(it.hasNext()){
            Object chave = it.next();
            if(campos.get(chave) != null ){
                String operador = ( ((String)campos.get(chave)).contains("%") ) ? "LIKE" : "=";
                query += chave+" "+operador+" ? OR ";
                contador++;
            }
        }
        query = query.substring(0, query.length()-4);
        try{
            Connection con = BancoDados.getConn();

            PreparedStatement Stmt = con.prepareStatement(query);
            it = chaves.iterator();
            Integer i = 1;
            while(it.hasNext()){
                Object chave = it.next();
                if(campos.get(chave) != null){
                    Stmt.setString(i, ((String) campos.get(chave)).toUpperCase());
                    i++;
                }
           }

           try{                
                ResultSet rs = Stmt.executeQuery();
                //JOptionPane.showMessageDialog(null,"Localizado com sucesso!");

                DefaultTableModel model = (DefaultTableModel)jtable.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    Object[] linha = new Object[campos.size()];
                    it = chaves.iterator();
                    i = 0;
                    while(it.hasNext()){
                        Object chave = it.next();
                        linha[i] = rs.getString((String)chave);
                        i++;
                    }
                    model.addRow(linha);
                }
           } catch (SQLException erro){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro ao localizar dados. Erro : " + erro);
           }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em acessar o banco de dados!");
        }
    }

    public static void AtualizarTabela(String Tabela, JTable jtable){
        try {
             //Conectar ao BD
            Connection con = BancoDados.getConn();
            //---------------FIM
            String query = "SELECT * FROM "+ Tabela;

            PreparedStatement cmd;
            cmd = con.prepareStatement(query);
            ResultSet rs = cmd.executeQuery();
            //JOptionPane.showMessageDialog(null, "Ate aqui tudo ok");

            DefaultTableModel model = (DefaultTableModel)jtable.getModel();
            model.setRowCount(0);//esse numero serve para especificar com quantas linhas a tabela ira iniciar

            int colCount = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] row = new Object[colCount];
                for ( int i = 0; i < colCount; i++ ){
                    row[i] = rs.getString(i+1);
                }

                model.addRow(row);
            }



        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em acessar o BD pelo SQL . Erro: " + ex);
        }                
    }

    //este metodo serve para verificar se ha um registro igual ao tentado
    //ser salvo
    public static boolean verificaRegistros(String Tabela, String Campo, String Valor){
        System.out.println(Tabela);
        System.out.println(Campo);

        if( !Tabela.equals("") && !Campo.equals("") ){
            try{                
                Connection con = BancoDados.getConn();
                String query = "SELECT *, COUNT(id) as count FROM "+ Tabela +" WHERE " + Campo + "= ?  LIMIT 1";
                PreparedStatement Stmt = con.prepareStatement(query);
                Stmt.setString(1, Valor);
                ResultSet rs = Stmt.executeQuery();
                rs.next();
                if(rs.getInt("count") == 1){
                    return false;    
                }else {
                    return true;
                }
            } catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro em recuperar os dados. Erro : " + erro);
            } 
        }
        return false;
    }
    //==========================================================================
    protected static void InserirMuitos(Map map, String Tabela){
        Set<String> chaves = map.keySet();
        Iterator it = chaves.iterator();
        String query = "INSERT INTO " + Tabela +" (";
        while(it.hasNext()){
            Object chave = it.next();
            query += chave+", ";
        }
        query = query.substring(0, query.length()-2);
        query += ") VALUES (";
        it = chaves.iterator();
        while(it.hasNext()){
             Object chave = it.next();
             query += "?, ";
        }
        query = query.substring(0, query.length()-2);
        query += ")";

        try{
            Connection con = BancoDados.getConn();

            PreparedStatement Stmt = con.prepareStatement(query);
            it = chaves.iterator();
            Integer i = 1;
            while(it.hasNext()){
                Object chave = it.next();
                String valor = (String) map.get(chave);
                Stmt.setString(i, valor.toUpperCase());
                i++;
           }
           try{                
                Stmt.executeUpdate();
                //JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
           } catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro em salvar os dados. Erro 1: " + erro);
           }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em acessar o banco de dados. Erro 3: " + erro);
        }
    }}