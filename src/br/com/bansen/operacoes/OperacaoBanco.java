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
		try {
			PopulaBanco populador = new PopulaBanco();
			List<String> objetos = (List<String>) Arquivo.leArquivo(System.getProperty("user.dir") + "/dados/populadorTxt.txt");
			List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
			for (String p : objetos) {
				String[] dados = p.split(";");
				listaPessoas.add(new Pessoa(dados[0], dados[1], dados[2], dados[3], dados[4], Integer.valueOf(dados[5]), Date.valueOf(dados[6]), dados[7], dados[8], Boolean.valueOf(dados[9])));
			}
			populador.inserePessoa(listaPessoas);
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}

