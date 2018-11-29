package com.br.rfaengines.testautomation.selenium.google;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {

	private static final Logger LOGGER = Logger.getLogger(LoggerTest.class);

	@Test
	public void f() {

		LOGGER.info("TESTE INFO");
		
	}
}
