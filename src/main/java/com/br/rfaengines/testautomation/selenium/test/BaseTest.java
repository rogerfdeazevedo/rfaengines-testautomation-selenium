package com.br.rfaengines.testautomation.selenium.test;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.br.rfaengines.testautomation.selenium.driver.DriverFactory;
import com.br.rfaengines.testautomation.selenium.driver.DriverManager;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;
import com.github.javafaker.Faker;

@Listeners(TestListener.class)
public abstract class BaseTest {
	
	Faker faker;
	
	@BeforeTest
	public void preCondition() {				
		String browser = PropertiesUtil.getValue("browser.default");
		String url = PropertiesUtil.getValue("url.dafault");
		String fakerLocale = PropertiesUtil.getValue("faker.locale");
		faker = new Faker(new Locale(fakerLocale));
		WebDriver driver = DriverFactory.novaInstancia(browser);
		DriverManager.setDriver(driver);
		DriverManager.getDriver().get(url);
		DriverManager.getDriver().manage().window().maximize();
	}
	
	@AfterTest
	public void posCondition() {
		DriverManager.quit();
	}

}
