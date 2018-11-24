package br.com.bansen.populador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bansen.conexao.Conexao;

public class CriaBanco {

	public static boolean criarTabelas() throws Exception {
		
		Connection conexao = Conexao.abreConexao();
		Statement create = conexao.createStatement();
		
		String pessoa = "CREATE TABLE pessoa ("
				+ "id_pessoa INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "nome VARCHAR(50) NOT NULL,"
				+ "sobrenome VARCHAR(50) NOT NULL,"
				+ "email VARCHAR(50),"
				+ "sexo VARCHAR(50) NOT NULL,"
				+ "cpf VARCHAR(50) NOT NULL,"
				+ "rg VARCHAR(20) NOT NULL,"
				+ "dataNasc DATE NOT NULL,"
				+ "telefone1 VARCHAR(50) NOT NULL,"
				+ "telefone2 VARCHAR(50),"
				+ "ativo CHAR(1) NOT NULL);";
		
		String endereco = "CREATE TABLE endereco ("
				+ "cep VARCHAR(45) NOT NULL PRIMARY KEY,"
				+ "rua VARCHAR(45) NOT NULL,"
				+ "numero INT NOT NULL," + "bairro VARCHAR(45) NOT NULL,"
				+ "municipio VARCHAR(45) NOT NULL,"
				+ "uf VARCHAR(45) NOT NULL);";
		
		String usuario = "CREATE TABLE usuario (" 
				+ "id_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "usuario VARCHAR(45) NOT NULL,"
				+ "senha VARCHAR(45) NOT NULL,"
				+ "tipo_usuario INT NOT NULL,"
				+ "fk_id_pessoa INT NOT NULL);";
		
		String conta = "CREATE TABLE conta (" 
				+ "id_conta INT NOT NULL PRIMARY KEY AUTO_INCREMENT," 
				+ "numero VARCHAR(45) NOT NULL,"
				+ "tipo_conta VARCHAR(2) NOT NULL," 
				+ "saldo DECIMAL(10,2) NOT NULL," 
				+ "titular VARCHAR(45) NOT NULL,"
				+ "senha VARCHAR(45) NOT NULL,"
				+ "fk_id_usuario INT);";
		
		String movimentacao = "CREATE TABLE movimentacao ("
				+ "id_movimentacao INT NOT NULL PRIMARY KEY AUTO_INCREMENT," 
				+ "conta_origem INT NOT NULL,"
				+ "conta_destino INT NOT NULL," 
				+ "valor DECIMAL(10,2) NOT NULL,"
				+ "data DATE NOT NULL,"
				+ "fk_id_conta INT NOT NULL);";
		
		String tipo_operacao = "CREATE TABLE tipo_operacao ("
				+ "id_operacao INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "descricao VARCHAR(100) NOT NULL,"
				+ "fk_id_movimentacao INT NOT NULL);";
		try {			
			create.executeUpdate(pessoa);
			create.executeUpdate(endereco);
			create.executeUpdate(usuario);
			create.executeUpdate(conta);
			create.executeUpdate(movimentacao);
			create.executeUpdate(tipo_operacao);
		} catch (Exception e) {
			throw new SQLException("Erro criação tabelas! " + e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
		
		System.out.println("Tabelas criadas com sucesso!");
		return true;
	}
	
	public static boolean relacionaTabelasFK() throws Exception {
		Connection conexao = Conexao.abreConexao();
		Statement st = conexao.createStatement();
		
		String fk_id_pessoa = "ALTER TABLE usuario "
				+ "ADD FOREIGN KEY (fk_id_pessoa) REFERENCES pessoa(id_pessoa);";
		
		String fk_id_conta = "ALTER TABLE movimentacao "
				+ "ADD FOREIGN KEY (fk_id_conta) REFERENCES conta(id_conta);";
		try {
			st.executeUpdate(fk_id_pessoa);
			st.executeUpdate(fk_id_conta);
		}catch (Exception e) {
			throw new SQLException("Erro criação FKs! " + e.getMessage());
		}finally {
			Conexao.fechaConexao();
		}
		
		System.out.println("Chaves criadas com sucesso!");
		return true;
	}	
}
