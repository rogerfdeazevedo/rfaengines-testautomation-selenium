package com.br.rfaengines.testautomation.selenium.driver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {

	/**
	 * Capacidades para o navegador IE.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @return DesiredCapabilities Retorna configuração de capacidades para o
	 *         browser IE.
	 */
	public static DesiredCapabilities getIE() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability("allow-blocked-content", true);
		capabilities.setCapability("allowBlockedContent", true);
		capabilities.setCapability("requireWindowFocus", true);
		return capabilities;
	}

}
