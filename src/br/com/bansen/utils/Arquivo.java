package br.com.bansen.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Arquivo {

	public static Collection<String> leArquivo(String nomeArq) throws IOException {
		BufferedReader arquivo = new BufferedReader(new FileReader(new File(nomeArq)));
		Collection<String> linhas = new ArrayList<String>();
		String linha = null;
		while ((linha = arquivo.readLine()) != null) {
			linhas.add(linha);
		}
		arquivo.close();
		return linhas;
	}
}
