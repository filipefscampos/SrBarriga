package br.com.fcampos.tests;

import org.junit.Test;

import br.com.fcampos.core.BaseTest;
import br.com.fcampos.pages.ContasPage;
import br.com.fcampos.pages.MenuPage;
import junit.framework.Assert;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void excluiContaComMovimentcao() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta com movimentacao");
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
	
}
