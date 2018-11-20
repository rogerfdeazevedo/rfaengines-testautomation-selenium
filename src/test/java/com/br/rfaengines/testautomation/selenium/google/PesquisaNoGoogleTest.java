package com.br.rfaengines.testautomation.selenium.google;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.pageobject.PesquisaGoogle;
import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;


public class PesquisaNoGoogleTest extends BaseTest {

	@Test (groups = { "Main"} , description = "Realizar uma pesquisa no google com sucesso.")
	public void f() {

		String pesquisa = "test automation";
		
		PesquisaGoogle google = new PesquisaGoogle();
		
		google.preencherCampoDePesquisaEpressionarEnter(pesquisa);
		
		assertTrue(google.carregouResultadoDaPesquisa());
		
		ReportTestManager.adicionarEvidencia("Pesquisa sobre '" + pesquisa + "' realizada com sucesso.");

	}

}
