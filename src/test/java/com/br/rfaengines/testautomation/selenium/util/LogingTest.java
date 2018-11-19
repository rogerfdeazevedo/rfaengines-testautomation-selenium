package com.br.rfaengines.testautomation.selenium.util;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LogingTest {

	private static final Logger LOGGER = Logger.getLogger(LogingTest.class);

	@Test
	public void f() {

		LOGGER.fatal("FATAL");
		LOGGER.error("ERRROR");
		LOGGER.warn("WARN");
		LOGGER.info("INFO");
		LOGGER.debug("DEBUG");
		LOGGER.trace("TRACE");

	}

}
