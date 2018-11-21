package br.com.bansen.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Leitura {

	public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public static int leInteiro() {
		while (true) {
			try {
				return Integer.parseInt(entrada.readLine());
			} catch (Exception e) {
				System.out.println("Entre com uma opção válida!");
			}
		}
	}
}
