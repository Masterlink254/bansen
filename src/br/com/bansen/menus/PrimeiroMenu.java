package br.com.bansen.menus;


import br.com.bansen.dao.PessoaDAO;
import br.com.bansen.operacoes.OperacaoBanco;
import br.com.bansen.utils.Leitura;

public class PrimeiroMenu {

	public static void main(String[] args) {
		int leitura;
		Menus.menuCriaPopulaBanco();
		
		switch (leitura = Leitura.leInteiro()) {
		case 1:
			System.out.println("Criando e populando Banco de Dados...");
			try {
				PessoaDAO.criaTabela();
				OperacaoBanco.criaPopulaBanco();
				Menus.menuClienteBansen();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		case 2:
			System.out.println("Volte sempre! Saindo do sistema...");
			break;
		}
	}
}
