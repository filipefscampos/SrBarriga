package br.com.fcampos.pages;

import org.openqa.selenium.By;

import br.com.fcampos.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta(String nome) {
		return ObterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
	
}
