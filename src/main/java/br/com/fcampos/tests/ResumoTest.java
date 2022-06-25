package br.com.fcampos.tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.fcampos.core.BaseTest;
import br.com.fcampos.core.DriverFactory;
import br.com.fcampos.pages.MenuPage;
import br.com.fcampos.pages.ResumoPage;
import junit.framework.Assert;

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1_testExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluiMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}
	
	//@Test(expected = NoSuchElementException.class)
	@Test
	public void test2_testResumoMensal() {
		menuPage.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
		
		/*try {
			DriverFactory.getDriver().findElement(By.xpath("//table[@id='tabelaExtrato']//tbody/tr"));
			Assert.fail();
		} catch (NoSuchElementException e) {
			
		}*/
		
		resumoPage.selecionarAno("2016");
		resumoPage.clicarBotaoBuscar();
		List<WebElement> elementosEncontratos = DriverFactory.getDriver().findElements(By.xpath("//table[@id='tabelaExtrato']//tbody/tr"));
		Assert.assertEquals(0, elementosEncontratos.size());
	}
	
}
