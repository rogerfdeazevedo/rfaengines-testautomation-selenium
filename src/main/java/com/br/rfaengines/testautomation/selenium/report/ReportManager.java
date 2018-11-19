package com.br.rfaengines.testautomation.selenium.report;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportManager {

	private static ExtentReports report = null;

	private ReportManager() {
	}

	/**
	 * Gerencia instância do report, criando uma nova caso ainda não exista.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @return Retorna instância de um report.
	 */
	public static ExtentReports getInstance() {
		if (report == null) {
			report = ReportFactory.novoReport();
		}
		return report;
	}

}
