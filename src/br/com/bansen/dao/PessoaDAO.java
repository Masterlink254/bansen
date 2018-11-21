package br.com.bansen.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bansen.conexao.Conexao;

public class PessoaDAO {

	public static boolean criaTabela() throws Exception {
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
			st.executeUpdate(sql);
			System.out.println("Tabela pessoa criada com sucesso!");
			return true;
		} catch (Exception e) {
			throw new SQLException("SQL!!!" + e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
}

