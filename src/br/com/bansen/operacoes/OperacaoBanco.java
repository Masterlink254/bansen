package br.com.bansen.operacoes;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import br.com.bansen.usuarios.*;
import br.com.bansen.utils.Arquivo;

public abstract class OperacaoBanco {

	private static Connection conn = null;
	
	public static boolean criaPopulaBanco() throws Exception {
		PopulaBanco populador = new PopulaBanco();
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>(5);
		
		try {	
			List<String> objetos = (List<String>) Arquivo.leArquivo(System.getProperty("user.dir") + "/dados/populadorTxt.txt");
			for (String p : objetos) {
				int contador = 0;
				String[] dados = p.split(";");
				Pessoa pes = new Pessoa(dados[0], dados[1], dados[2], dados[3], dados[4], Integer.valueOf(dados[5]), Date.valueOf(dados[6]), dados[7], dados[8], Boolean.valueOf(dados[9]));
				listaPessoas.add(contador, pes);
				contador++;
			}
			System.out.println("inserindo...");
			populador.inserePessoa(listaPessoas);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}

