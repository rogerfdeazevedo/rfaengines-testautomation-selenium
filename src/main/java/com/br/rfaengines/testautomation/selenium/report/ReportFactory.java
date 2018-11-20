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

			StringBuilder reportDir = new StringBuilder();
			reportDir.append(System.getProperty("user.dir")).append("-logs");
			ArquivosUtil.criarDir(reportDir.toString());

			StringBuilder evidencesDir = new StringBuilder();
			evidencesDir.append(reportDir.toString()).append("\\evidencias");
			ArquivosUtil.criarDir(evidencesDir.toString());

			String logoName = PropertiesUtil.getValue("report.logoname");

			StringBuilder logoDir = new StringBuilder();
			logoDir.append(System.getProperty("user.dir")).append("\\src\\main\\resources\\imgs\\").append(logoName);

			StringBuilder imgsDir = new StringBuilder();
			imgsDir.append(reportDir.toString()).append("\\imgs");
			ArquivosUtil.criarDir(imgsDir.toString());

			imgsDir.append("\\").append(logoName);

			ImagensUtil.salvarImagem(logoDir.toString(), imgsDir.toString());

			StringBuilder reportName = new StringBuilder();
			reportName.append(reportDir.toString()).append("/").append(PropertiesUtil.getValue("report.name"))
					.append("-").append(DataHoraUtil.getData("yyyyMMdd")).append(".html");

			boolean replaceExist = false;

			extent = new ExtentReports(reportName.toString(), replaceExist, DisplayOrder.OLDEST_FIRST,
					NetworkMode.ONLINE);

			StringBuilder reportXmlConfig = new StringBuilder();
			reportXmlConfig.append(System.getProperty("user.dir")).append(PropertiesUtil.getValue("report.xmlconfig"));

			if (ArquivosUtil.arquivoExisteNoDir(reportXmlConfig.toString())) {
				extent.loadConfig(new File(reportXmlConfig.toString()));
			}

		} catch (Exception e) {
			LOGGER.error("Falha ao criar novo report ", e);
		}
		return extent;
	}

}
