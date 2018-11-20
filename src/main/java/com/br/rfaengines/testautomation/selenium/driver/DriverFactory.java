package com.br.rfaengines.testautomation.selenium.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;

public enum DriverFactory {

	CHROME {
		public WebDriver getDriver() {
			WebDriver driver = null;
			try {
				StringBuilder driverLocation = new StringBuilder();
				driverLocation.append(PropertiesUtil.getValue("browser.exe.dir")).append("/chrome/")
						.append(PropertiesUtil.getValue("browser.version.chrome")).append("/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", driverLocation.toString());
				driver = new ChromeDriver();
			} catch (Exception e) {
				LOGGER.error(e);
			}
			return driver;
		}
	},

	FIREFOX {
		public WebDriver getDriver() {
			WebDriver driver = null;
			try {
				StringBuilder driverLocation = new StringBuilder();
				driverLocation.append(PropertiesUtil.getValue("browser.exe.dir")).append("/firefox/")
						.append(PropertiesUtil.getValue("browser.version.chrome")).append("/geckodriver.exe");
				System.setProperty("webdriver.firefox.driver", driverLocation.toString());
				driver = new ChromeDriver();
			} catch (Exception e) {
				LOGGER.error(e);
			}
			return driver;
		}
	},

	IE {
		@SuppressWarnings("deprecation")
		public WebDriver getDriver() {
			WebDriver driver = null;
			try {
				StringBuilder driverLocation = new StringBuilder();
				driverLocation.append(PropertiesUtil.getValue("browser.exe.dir")).append("/ie/")
						.append(PropertiesUtil.getValue("browser.version.ie")).append("/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", driverLocation.toString());
				driver = new InternetExplorerDriver(CapabilitiesManager.getIE());
			} catch (Exception e) {
				LOGGER.error(e);
			}
			return driver;
		}
	}

	;

	private static final Logger LOGGER = Logger.getLogger(DriverFactory.class);

	public abstract WebDriver getDriver();

	/**
	 * Cria uma nova instância do browser selecionado.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param browser
	 *            Nome do browser.
	 * @return Retorna nova instância do browser selecionado.
	 */
	public static WebDriver novaInstancia(String browser) {
		WebDriver driver = null;
		try {
			driver = valueOf(browser.toUpperCase()).getDriver();
		} catch (Exception e) {
			LOGGER.error("Browser: " + browser, e);
		}
		return driver;
	}

}
