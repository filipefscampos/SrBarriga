package br.com.fcampos.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browsers = Browsers.FIREFOX;
	
	//public static String NOME_CONTA_ALTERADA = "Conta do Teste Alterada " + System.nanoTime();
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
}
