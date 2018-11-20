package br.com.bansen.conexao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static Connection conn = null;

	public static Connection abreConexao() throws ConnectException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bansen?useSSL=true&serverTimezone=America/Sao_Paulo", "root", ""); 
			return conn;
		} catch (Exception e) {
			throw new ConnectException(e.getMessage()); // Implementar ENUM para mensagens de erro, próprias exceptions
														// construtor conexaoException(enum tipoerro, getmessage);
		}

	}

	public static void fechaConexao() throws ConnectException {
		try {
			if (conn instanceof Connection) {
				conn.close();
			}
			conn = null;
		} catch (Exception e) {
			throw new ConnectException(e.getMessage());
		}
	}

}
