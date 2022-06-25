package br.com.fcampos.suites;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.fcampos.core.DriverFactory;
import br.com.fcampos.pages.LoginPage;
import br.com.fcampos.tests.ContaTest;
import br.com.fcampos.tests.MovimentacaoTest;
import br.com.fcampos.tests.RemoverMovimentacaoContaTest;
import br.com.fcampos.tests.ResumoTest;
import br.com.fcampos.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {

	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("filipe.campos@sankhya.com.br");
		page.setSenha("123456");
		page.entrar();
		page.resetar();
		
		DriverFactory.KillDriver();
	}
	
}
