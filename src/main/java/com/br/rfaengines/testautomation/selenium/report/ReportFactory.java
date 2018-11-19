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
			reportDir.append(PropertiesUtil.getValue("report.dir"));
			ArquivosUtil.criarDir(reportDir.toString());

			StringBuilder evidencesDir = new StringBuilder();
			evidencesDir.append(PropertiesUtil.getValue("report.dir")).append("/evidencias");
			ArquivosUtil.criarDir(evidencesDir.toString());

			StringBuilder imgsDir = new StringBuilder();
			imgsDir.append(PropertiesUtil.getValue("report.dir")).append("/imgs");
			ArquivosUtil.criarDir(imgsDir.toString());

			StringBuilder logoDir = new StringBuilder();
			logoDir.append(System.getProperty("user.dir")).append("/src/main/resources/imgs/logo-sicredi.png");

			ImagensUtil.copiarImagem(logoDir.toString(), imgsDir.append("/logo-sicredi.png").toString());

			StringBuilder reportName = new StringBuilder();
			reportName.append(PropertiesUtil.getValue("report.dir")).append("/")
					.append(PropertiesUtil.getValue("report.name")).append("-").append(DataHoraUtil.getData("yyyyMMdd"))
					.append(".html");

			StringBuilder reportXmlConfig = new StringBuilder();
			reportXmlConfig.append(System.getProperty("user.dir")).append(PropertiesUtil.getValue("report.xmlconfig"));

			boolean replaceExist = false;

			extent = new ExtentReports(reportName.toString(), replaceExist, DisplayOrder.OLDEST_FIRST,
					NetworkMode.ONLINE);

			extent.loadConfig(new File(reportXmlConfig.toString()));
			
		} catch (Exception e) {
			LOGGER.error("Falha ao criar novo report ", e);
		}
		return extent;
	}

}
