package com.br.rfaengines.testautomation.selenium.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PesquisaGoogle extends AbstractPageObject {

	@FindBy (css = "input[title='Pesquisar']")
	WebElement campoPesquisar;
	
	@FindBy (css = "div[id='resultStats']")
	WebElement statusResutaldo;
	
	
	public PesquisaGoogle preencherCampoDePesquisaEpressionarEnter(String texto) {
		campoPesquisar.sendKeys(texto + Keys.ENTER);
		return this;
	}
	
	public boolean carregouResultadoDaPesquisa() {
		return statusResutaldo.isDisplayed();
	}
	
}
