package com.br.rfaengines.testautomation.selenium.report;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportManager {

	private static ExtentReports report = null;

	private ReportManager() {
	}

	/**
	 * Gerencia inst�ncia do report, criando uma nova caso ainda n�o exista.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @return Retorna inst�ncia de um report.
	 */
	public static ExtentReports getInstance() {
		if (report == null) {
			report = ReportFactory.novoReport();
		}
		return report;
	}

}
