package com.br.rfaengines.testautomation.selenium.report;

import com.br.rfaengines.testautomation.selenium.test.ScreenShot;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTestManager {

	private static ExtentTest test = null;

	private ReportTestManager() {
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static void setTest(ExtentTest test) {
		ReportTestManager.test = test;
	}

	/**
	 * Adiciona um printscren no report.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 */
	public static void adicionarEvidencia() {
		String dirEvidencias = ReportTestManager.getDirEvidencias();
		String imagePath = "./evidencias/" + ScreenShot.takeScreenshot(dirEvidencias);
		test.log(LogStatus.INFO, test.addScreenCapture(imagePath));
	}

	/**
	 * Adiciona um printscren no report com uma mensagem de texto
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param mensagem
	 *            Mensagem de texto.
	 */
	public static void adicionarEvidencia(String mensagem) {
		String dirEvidencias = ReportTestManager.getDirEvidencias();
		String imagePath = "./evidencias/" + ScreenShot.takeScreenshot(dirEvidencias);
		test.log(LogStatus.INFO, mensagem + "<br>" + test.addScreenCapture(imagePath));
	}

	/**
	 * Recupera o diretório de evidencias configurado no properties.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @return Retorna o caminho do diretório de evidências.
	 */
	public static String getDirEvidencias() {
		StringBuilder dirEvidencias = new StringBuilder();
		dirEvidencias.append(System.getProperty("user.dir")).append("/").append(PropertiesUtil.getValue("report.dir"))
				.append("/evidencias");
		return dirEvidencias.toString();
	}

}
