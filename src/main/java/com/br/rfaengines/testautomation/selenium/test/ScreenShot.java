package com.br.rfaengines.testautomation.selenium.test;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.br.rfaengines.testautomation.selenium.driver.DriverManager;
import com.br.rfaengines.testautomation.selenium.util.DataHoraUtil;

public class ScreenShot {

	private static final Logger LOGGER = Logger.getLogger(ScreenShot.class);

	/**
	 * Captura um printscreen usando o driver do selenium, salvando a imagem
	 * conforme o diretório indicado.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param dirDestino
	 *            Diretório onde será salva a imagem.
	 * @return Retorna o nome da imagem.
	 */
	public static String takeScreenshot(String dirDestino) {	
		StringBuilder nomeImg = new StringBuilder();
		StringBuilder dirSalvo = new StringBuilder();
		try {
			WebDriver driver = DriverManager.getDriver();			
			nomeImg.append("evidencia_").append(DataHoraUtil.getData("yyyyMMddHHmmss")).append(".png");			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);			
			dirSalvo.append(dirDestino).append("/").append(nomeImg);
			BufferedImage fullImg = ImageIO.read(screenshot);
			ImageIO.write(fullImg, "png", new File(dirSalvo.toString()));
		} catch (Exception e) {
			LOGGER.error("Falha ao tentar capturar imagem da tela ", e);
		}				
		return nomeImg.toString();
	}

}
