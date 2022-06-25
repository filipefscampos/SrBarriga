package br.com.fcampos.core;

import static br.com.fcampos.core.DriverFactory.getDriver;
import static br.com.fcampos.core.DriverFactory.KillDriver;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import br.com.fcampos.pages.LoginPage;

public class BaseTest {
	
	@Rule
	public TestName testname = new TestName();
	
	private static LoginPage page = new LoginPage();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("filipe.campos@sankhya.com.br");
		page.setSenha("123456");
		page.entrar();
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(arquivo, new File("target"+ File.separator +"screenshot" + File.separator + testname.getMethodName()+".jpg"));

		if(Propriedades.FECHAR_BROWSER) {
			KillDriver();
		}
	}
	
}
