package br.com.bansen.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bansen.conexao.Conexao;

public class PessoaDAO { //implements IInstalaDAO, ICRUDPadraoDAO<Pessoa> 

	//@Override
	public static boolean criaTabela() throws Exception { //ConexaoException, DAOException
		Connection conexao = Conexao.abreConexao();
		try {
			Statement st = conexao.createStatement();
			String sql = "CREATE TABLE pessoa (" +
					"id_pessoa INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
					"nome VARCHAR(50) NOT NULL," +
					"sobrenome VARCHAR(50) NOT NULL," +
					"email VARCHAR(50)," +
					"sexo VARCHAR(50) NOT NULL," +
					"cpf VARCHAR(50) NOT NULL," +
					"rg VARCHAR(20) NOT NULL," +
					"dataNasc DATE NOT NULL," +
					"telefone1 VARCHAR(50) NOT NULL," +
					"telefone2 VARCHAR(50)," +
					"ativo CHAR(1) NOT NULL);";
//					"CREATE TABLE endereco (" +
//					"id_endereco INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
//					"cep VARCHAR(10) NOT NULL," +
//					"rua VARCHAR(255) NOT NULL," +
//					"numero VARCHAR(13) NOT NULL," +
//					"bairro varchar(255) NOT NULL," +
//					"municipio varchar(255) NOT NULL," +
//					"uf varchar(50) NOT NULL" +
//					");" + 
//				"CREATE TABLE usuario (" +
//					"id_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
//					"usuario varchar(255) NOT NULL," +
//					"senha varchar(255) NOT NULL," +
//					"tipoUsuario varchar(255) NOT NULL" +
//					");" + 
//				"CREATE TABLE conta (" +
//					"id_conta INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
//					"agencia varchar(255) NOT NULL," +
//					"numero varchar(255) NOT NULL," +
//					"tipo_conta varchar(255) NOT NULL," +
//					"saldo varchar(100) NOT NULL," +
//					"titular varchar(255) NOT NULL" +
//					");" +
//				"CREATE TABLE agencia (" +
//					"id_agencia INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
//					"numero mediumint NOT NULL," +
//					"endereco varchar(255) NOT NULL" +
//					");" +
//				"CREATE TABLE movimentacao (" +
//					"id_movimentacao INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
//					"conta_origem varchar(255) NOT NULL," +
//					"conta_destino varchar(255) NOT NULL," +
//					"valor varchar(100) NOT NULL," +
//					"data varchar(255) NOT NULL" +
//					");" +
//				"CREATE TABLE tipo_operacao (" +
//					"id_tipo_operacao INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
//					"descricao varchar(255) NOT NULL" +
//				");";
			st.executeUpdate(sql);
			System.out.println("Tabela pessoa criada com sucesso!");
			return true;
		} catch (Exception e) {
//			throw new DAOException(EErrosDAO.CRIA_TABELA, e.getMessage(), this.getClass());
			throw new SQLException("SQL!!!" + e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
/*
	@Override
	public boolean excluiTabela() throws ConexaoException, DAOException {
		Connection conexao = Conexao.abreConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE pessoas;");
			return true;
		} catch (Exception e) {
			throw new DAOException(EErrosDAO.EXCLUI_TABELA, e.getMessage(), this.getClass());
		} finally {
			Conexao.fechaConexao();
		}
	}

	@Override
	public Pessoa consulta(int codigo) throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Pessoa> consultaTodos() throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> consultaFaixa(int... faixa) throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insere(Pessoa objeto) throws ConexaoException, DAOException {
		Connection conexao = Conexao.abreConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO Pessoas (Codigo, Nome, DataNascimento, Sexo, Salario, ATIVO) VALUES (?, ?, ?, ?, ?, ?);");
			pst.setInt(1, objeto.getCodigo());
			pst.setString(2, objeto.getNome());
			pst.setDate(3, new java.sql.Date(objeto.getDataNascimento().getTime()));
			pst.setInt(4, objeto.getSexo().ordinal());
			pst.setDouble(5, objeto.getSalario());
			pst.setString(6, objeto.isAtivo() ? "S" : "N");
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new DAOException(EErrosDAO.INSERE_DADO, e.getMessage(), this.getClass());
		} finally {
			Conexao.fechaConexao();
		}
	}

	@Override
	public boolean insereVarios(Map<Integer, Pessoa> objetos) throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pessoa> insereVarios(List<Pessoa> objetos) throws ConexaoException {
		List<Pessoa> falhados = new ArrayList<Pessoa>();
		Connection conexao = Conexao.abreConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO Pessoas (Codigo, Nome, DataNascimento, Sexo, Salario, ATIVO) VALUES (?, ?, ?, ?, ?, ?);");
			for (Pessoa pessoa : objetos) {
				pst.setInt(1, pessoa.getCodigo());
				pst.setInt(2, pessoa.getCodigo());
				pst.setString(2, pessoa.getNome());
				pst.setDate(3, new java.sql.Date(pessoa.getDataNascimento().getTime()));
				pst.setInt(4, pessoa.getSexo().ordinal());
				pst.setDouble(5, pessoa.getSalario());
				pst.setString(6, pessoa.isAtivo() ? "S" : "N");
				try {
					pst.executeUpdate();
				} catch (SQLException e) {
					new DAOException(EErrosDAO.INSERE_DADO, e.getMessage(), this.getClass());
					falhados.add(pessoa);
				}
			}
		} catch (Exception e) {

		} finally {
			Conexao.fechaConexao();
		}
		return falhados;
	}

	@Override
	public boolean insereVariosTransacao(List<Pessoa> objetos) throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altera(Pessoa objeto) throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exclui(int codigo) throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exclui(Pessoa objeto) throws ConexaoException, DAOException {
		// TODO Auto-generated method stub
		return false;
	}
*/
}

