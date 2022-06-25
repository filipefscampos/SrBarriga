package br.com.fcampos.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.fcampos.core.BaseTest;
import br.com.fcampos.pages.MenuPage;
import br.com.fcampos.pages.MovimentacaoPage;
import br.com.fcampos.utils.DataUtils;
import junit.framework.Assert;

public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento("07/06/2022");
		movPage.setDescricao("Movimenta��o com Junit");	
		movPage.setInteressado("Filipe Campos");
		movPage.setValor("500");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_testCamposObrigatarios() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		
		//Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}	
	
	@Test
	public void test3_testInserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o com Junit");
		movPage.setInteressado("Filipe Campos");
		movPage.setValor("500");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
	}
}
