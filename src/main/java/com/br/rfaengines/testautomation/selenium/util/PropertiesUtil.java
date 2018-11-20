package com.br.rfaengines.testautomation.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {

	private static final Logger LOGGER = Logger.getLogger(PropertiesUtil.class);

	private PropertiesUtil() {
	}

	/**
	 * Recupera o valor de uma propriedade em um arquivo properties.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param propriedade
	 *            Nome da propriedade contida no arquivo.
	 * @return Valor da propriedade contida no arquivo.
	 */
	public static String getValue(String propriedade) {
		String value = "";
		try {
			StringBuilder fileLocation = new StringBuilder();
			fileLocation.append(System.getProperty("user.dir")).append("/src/main/resources/config/config.properties");
			Properties properties = new Properties();
			properties.load(new FileInputStream(fileLocation.toString()));
			value = properties.getProperty(propriedade);
		} catch (IOException e) {
			LOGGER.error("Falha ao carregar properties ", e);
			LOGGER.error(e.getMessage());
		}
		return value;
	}

}
