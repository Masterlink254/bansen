package br.com.bansen.menus;

<<<<<<< HEAD
=======
import br.com.bansen.dao.PessoaDAO;
>>>>>>> design
import br.com.bansen.operacoes.OperacaoBanco;
import br.com.bansen.utils.Leitura;

public class PrimeiroMenu {

	public static void main(String[] args) {
<<<<<<< HEAD

		Menus.menuCriaPopulaBanco();

		int operacaoInicial = 0;

		switch (operacaoInicial = Leitura.leInteiro()) {
		case 1:
			System.out.println("iniciando a criação e população do banco de dados...");
			OperacaoBanco operacao = new OperacaoBanco();
			try {
				operacao.criaPopulaBanco();
=======
		
		int operacaoInicial;
		Menus.menuCriaPopulaBanco();
		
		switch (operacaoInicial = Leitura.leInteiro()) {
		case 1:
			
			System.out.println("Criando e populando Banco de Dados...");
			
			try {
				PessoaDAO.criaTabela();
				OperacaoBanco.criaPopulaBanco();
//				try {
//					//Tenta login 
//				}catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
>>>>>>> design
				Menus.menuBanco();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
<<<<<<< HEAD
			
			break;
		case 2:
=======
			break;
		case 2:
			
>>>>>>> design
			System.out.println("Volte sempre! Saindo do sistema...");
			break;
		}
	}
}
