package com.br.rfaengines.testautomation.selenium.util;

import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;


public class PesquisaNoGoogleTest extends BaseTest {

	@Test (groups = { "Main"} , description = "Realizar uma pesquisa no google com sucesso.")
	public void f() {

		System.out.println("TESTE");
		ReportTestManager.adicionarEvidencia();		

	}

}
