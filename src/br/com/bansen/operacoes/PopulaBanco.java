package br.com.bansen.operacoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.com.bansen.conexao.Conexao;
import br.com.bansen.usuarios.Pessoa;

public class PopulaBanco {

	public boolean inserePessoa(List<Pessoa> objetos) throws Exception {
		System.out.println("Abriu conexão para inserir...");
		Connection conexao = Conexao.abreConexao();
		try {
			PreparedStatement pstPessoa = conexao.prepareStatement("INSERT INTO pessoa (nome, sobrenome, email, sexo, cpf, rg, dataNasc, telefone1, telefone2, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			for (Pessoa pessoa : objetos) {
				pstPessoa.setString(1, pessoa.getNome());
				pstPessoa.setString(2, pessoa.getSobrenome());
				pstPessoa.setString(3, pessoa.getEmail());
				pstPessoa.setString(4, pessoa.getSexo());
				pstPessoa.setString(5, pessoa.getCpf());
				pstPessoa.setInt(6, pessoa.getRg());
				pstPessoa.setDate(7, (java.sql.Date) pessoa.getDataNasc());
				pstPessoa.setString(8, pessoa.getTelefone1());
				pstPessoa.setString(9, pessoa.getTelefone2());
				pstPessoa.setBoolean(10, pessoa.getAtivo());
				pstPessoa.executeUpdate();
			}
			System.out.println("inseriu!!!");
			return true;
		} catch (Exception e) {
			throw new SQLException("Não inseriu!" + e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
}
