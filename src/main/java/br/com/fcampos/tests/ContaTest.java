package br.com.fcampos.tests;

import org.junit.Test;

import br.com.fcampos.core.BaseTest;
import br.com.fcampos.pages.ContasPage;
import br.com.fcampos.pages.MenuPage;
import junit.framework.Assert;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_testInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterarConta("Conta para alterar");
		contasPage.setNome("Conta Alterada");
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());	
	}
	
	@Test
	public void test3_testInserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
	
}
