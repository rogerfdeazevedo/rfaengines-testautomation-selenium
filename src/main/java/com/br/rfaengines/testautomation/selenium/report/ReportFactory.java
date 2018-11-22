package com.br.rfaengines.testautomation.selenium.report;

import java.io.File;

import org.apache.log4j.Logger;

import com.br.rfaengines.testautomation.selenium.util.ArquivosUtil;
import com.br.rfaengines.testautomation.selenium.util.DataHoraUtil;
import com.br.rfaengines.testautomation.selenium.util.ImagensUtil;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ReportFactory {

	private static final Logger LOGGER = Logger.getLogger(ReportFactory.class);
	private static StringBuilder reportDir = new StringBuilder();
	private static StringBuilder logoDir = new StringBuilder();
	private static StringBuilder reportName = new StringBuilder();
	private static String logoName = "";

	private ReportFactory() {
	};

	/**
	 * Cria o report de execução no formato html.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @return Retorna instância de um novo report.
	 */
	public static ExtentReports novoReport() {

		ExtentReports extent = null;

		try {

			criarReportDir();

			criarEvidencesDir();

			carregarLogoDir();

			criarImgsDir();

			carregarReportName();

			boolean replaceExist = false;

			extent = new ExtentReports(reportName.toString(), replaceExist, DisplayOrder.OLDEST_FIRST,
					NetworkMode.ONLINE);

			carregarConfiguracaoDoReport(extent);

		} catch (Exception e) {
			LOGGER.error("Falha ao criar novo report ", e);
		}
		return extent;
	}

	public static String getReportDir() {
		return reportDir.toString();
	}

	private static void criarReportDir() {
		String str = PropertiesUtil.getValue("report.dir");
		if (str.contains("target")) {
			reportDir.append(System.getProperty("user.dir")).append("/").append(PropertiesUtil.getValue("report.dir"));
		} else {
			reportDir.append(System.getProperty("user.dir")).append("-logs");
		}
		ArquivosUtil.criarDir(reportDir.toString());
	}

	private static void criarEvidencesDir() {
		StringBuilder evidencesDir = new StringBuilder();
		evidencesDir.append(reportDir.toString()).append("\\evidencias");
		ArquivosUtil.criarDir(evidencesDir.toString());
	}

	private static void carregarLogoDir() {
		logoName = PropertiesUtil.getValue("report.logoname");
		logoDir.append(System.getProperty("user.dir")).append("\\src\\main\\resources\\imgs\\").append(logoName);
	}

	private static void criarImgsDir() {
		StringBuilder imgsDir = new StringBuilder();
		imgsDir.append(reportDir.toString()).append("\\imgs");
		ArquivosUtil.criarDir(imgsDir.toString());
		imgsDir.append("\\").append(logoName);
		ImagensUtil.salvarImagem(logoDir.toString(), imgsDir.toString());
	}

	private static void carregarReportName() {
		reportName.append(reportDir.toString()).append("/").append(PropertiesUtil.getValue("report.name")).append("-")
				.append(DataHoraUtil.getData("yyyyMMdd")).append(".html");
	}

	private static void carregarConfiguracaoDoReport(ExtentReports extent) {
		StringBuilder reportXmlConfig = new StringBuilder();
		reportXmlConfig.append(System.getProperty("user.dir")).append(PropertiesUtil.getValue("report.xmlconfig"));

		if (ArquivosUtil.arquivoExisteNoDir(reportXmlConfig.toString())) {
			extent.loadConfig(new File(reportXmlConfig.toString()));
		}
	}

}
