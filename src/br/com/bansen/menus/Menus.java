package br.com.bansen.menus;

public class Menus {
	public static void menuCriaPopulaBanco() {
		System.out.println("\n*******************************");
		System.out.println("\n   BANSEN - Agência Bancária\n");
		System.out.println("*******************************");
		System.out.println();
		System.out.println("Digite 1 e tecle 'Enter' para criar e popular o banco de dados de testes.");
		System.out.println();
	}
	
	public static void menuClienteBansen() {
		System.out.println("*** CLIENTE BANSEN ***");
		System.out.println("0 - Emitir Extrato:");
		System.out.println("1 - Depositar");
		System.out.println("2 - Sacar");
		System.out.println("3 - Transferir");
		System.out.println("9 - Sair do sistema");
		System.out.print("Digite o número e tecle Enter para realizar a operação: ");
	}
}
