package br.com.bansen.operacoes;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import br.com.bansen.banco.Pessoa;
import br.com.bansen.utils.Arquivo;

public abstract class OperacaoBanco {

	private static Connection conn = null;
	
	public static boolean criaPopulaBanco() throws Exception {
		try {
			PopulaBanco populador = new PopulaBanco();
			Pessoa pessoa;
			List<String> objetos = (List<String>) Arquivo.leArquivo(System.getProperty("user.dir") + "/dados/populadorTxt.txt");
			List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
			for (String p : objetos) {
				String[] dados = p.split(";");
//				objetos.add(new Pessoa(dados[0], Integer.valueOf(dados[1]), dados[2], Date.valueOf(dados[3]), dados[4], dados[5], dados[6], Integer.valueOf(dados[7]), dados[8], dados[9], dados[10], Integer.valueOf(dados[11])));
				listaPessoas.add(new Pessoa(dados[0], dados[1], dados[2], dados[3], dados[4], Integer.valueOf(dados[5]), Date.valueOf(dados[6]), dados[7], dados[8], Boolean.valueOf(dados[9])));				
			}
			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}