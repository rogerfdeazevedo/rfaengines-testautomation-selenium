package com.br.rfaengines.testautomation.selenium.report;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportFactoryTest {
	@Test
	public void f() {
		ExtentReports report = ReportFactory.novoReport();
		assertTrue((report != null));
		report.flush();
		report.close();
	}

}
