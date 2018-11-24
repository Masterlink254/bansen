package br.com.bansen.populador;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bansen.conexao.Conexao;
import br.com.bansen.contas.Conta;
import br.com.bansen.usuarios.Pessoa;
import br.com.bansen.utils.Arquivo;
//verificar a possibilidade de logar diretamente com a conta ao invés de uma classe usuario usuário
//verificar a passagem de parâmetros tipo Pessoa na leitura de contas
public class PopulaBanco {
	
	public static boolean listarPessoas() throws Exception {
		PopulaBanco populador = new PopulaBanco();
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		try {	
			List<String> objetos = (List<String>) Arquivo.leArquivo(System.getProperty("user.dir") + "/dados/pessoas");
			for (String p : objetos) {
				int contador = 0;
				String[] dados = p.split(";");
				Pessoa pes = new Pessoa(dados[0], dados[1], dados[2], dados[3], dados[4], Integer.valueOf(dados[5]), Date.valueOf(dados[6]), dados[7], dados[8], Boolean.valueOf(dados[9]));
				listaPessoas.add(contador, pes);
				contador++;
			}
			populador.inserePessoa(listaPessoas);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
	public boolean inserePessoa(List<Pessoa> objetos) throws Exception {
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
		} catch (Exception e) {
			throw new SQLException("Erro inserções pessoas!" + e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
		System.out.println("Pessoas inseridas com sucesso!");
		return true;
	}
	
	public static boolean ListarContas() throws Exception {
		List<Conta> listaContas = new ArrayList<>();
		PopulaBanco populador = new PopulaBanco();
		
		try {
			List<String> objetos = (List<String>) Arquivo.leArquivo(System.getProperty("user.dir") + "/dados/contas");
			for (String c : objetos) {
				int contador = 0;
				String[] dados = c.split(";");
				Conta conta = new Conta(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]), Integer.parseInt(dados[3]), dados[4]);
				listaContas.add(contador, conta);
				contador++;
			}
			populador.insereContas(listaContas);
		}catch (Exception e) {
			throw new SQLException("Erro leitura Contas! " + e.getMessage());
		}
		
		return true;
	}
	
	public boolean insereContas(List<Conta> objetos) throws Exception {
		Connection conexao = Conexao.abreConexao();
		
		try {
			PreparedStatement cst = conexao.prepareStatement("INSERT INTO conta (numero, tipo_conta, saldo, titular, senha) VALUES (?, ?, ?, ?, ?);");
			for (Conta conta : objetos) {
				cst.setInt(1, conta.getNumero());
				cst.setString(2, conta.getTipoConta());
				cst.setDouble(3, conta.getSaldo());
				cst.setInt(4, conta.getTitular());
				cst.setString(5, conta.getSenha());
				cst.executeUpdate();
			}
			
		} catch (Exception e) {
			throw new SQLException("Erro inserções contas! " + e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
		System.out.println("Contas inseridas com sucesso!");
		return true;
	}
	
}
