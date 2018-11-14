package br.com.bansen.menus;

import br.com.bansen.operacoes.OperacaoBanco;
import br.com.bansen.utils.Leitura;

public class PrimeiroMenu {

	public static void main(String[] args) {

		Menus.menuCriaPopulaBanco();

		int operacaoInicial = 0;

		switch (operacaoInicial = Leitura.leInteiro()) {
		case 1:
			System.out.println("iniciando a criação e população do banco de dados...");
			OperacaoBanco operacao = new OperacaoBanco();
			try {
				operacao.criaPopulaBanco();
				Menus.menuBanco();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			break;
		case 2:
			System.out.println("Volte sempre! Saindo do sistema...");
			break;
		}
	}
}
