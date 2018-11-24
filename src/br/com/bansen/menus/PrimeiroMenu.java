package br.com.bansen.menus;

import br.com.bansen.operacoes.OperacaoBanco;
import br.com.bansen.populador.CriaBanco;
import br.com.bansen.populador.PopulaBanco;
import br.com.bansen.utils.Leitura;

public class PrimeiroMenu {

	public static void main(String[] args) {
		
		Menus.menuCriaPopulaBanco();

		switch (Leitura.leInteiro()) {
		case 1:
			System.out.println("Iniciando a criação e população do banco de dados...");
			try {
				CriaBanco.criarTabelas();
				CriaBanco.relacionaTabelasFK();
				PopulaBanco.listarPessoas();
				PopulaBanco.ListarContas();
			}catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
			break;
		case 2:
			System.out.println("Saindo... Volte sempre!");
			break;
		}
		
		System.out.println("Finalizado!");
	}
}
