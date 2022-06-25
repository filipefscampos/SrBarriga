package br.com.fcampos.tests;

import org.junit.Test;

import br.com.fcampos.core.BaseTest;
import br.com.fcampos.pages.HomePage;
import br.com.fcampos.pages.MenuPage;
import junit.framework.Assert;

public class SaldoTest extends BaseTest {
	
	HomePage page = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menuPage.acessarTelaHome();
		Assert.assertEquals("534.00",page.obterSaldoConta("Conta para saldo"));
	}
	
}
