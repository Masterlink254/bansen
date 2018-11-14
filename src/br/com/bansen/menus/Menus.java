package br.com.bansen.menus;

public class Menus {
	public static void menuCriaPopulaBanco() {
		System.out.println("\n*******************************");
		System.out.println("\n   BANSEN - Agência Bancária\n");
		System.out.println("*******************************");
		System.out.println();
		System.out.println("Digite 1 e tecle Enter para criar e popular o banco de dados de testes.");
		System.out.println();
	}
	
	public static void menuBanco() {
		System.out.println("*** MENU BANSEN ***");
		System.out.println("0 - Listar Clientes:");
		System.out.println("1 - Criar banco");
		System.out.println("2 - Entrar no banco");
		System.out.println("9 - Finalizar sistema");
		System.out.print("Digite o número e tecle Enter para realizar a operação: ");
	}
}
