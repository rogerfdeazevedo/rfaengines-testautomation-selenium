package com.br.rfaengines.testautomation.selenium.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static WebDriver driver = null;

	private DriverManager() {
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}

	public static void quit() {
		DriverManager.driver.quit();
	}

}
