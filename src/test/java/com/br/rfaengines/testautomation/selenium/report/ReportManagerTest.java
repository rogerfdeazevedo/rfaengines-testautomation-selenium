package com.br.rfaengines.testautomation.selenium.report;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportManagerTest {

	private ExtentReports report;
	private String reportIdA;
	private String reportIdB;

	@BeforeTest
	public void preCondition() {
		report = ReportManager.getInstance();
	}

	@Test
	public void f() {
		reportIdA = report.getReportId().toString();
		report = ReportManager.getInstance();
		reportIdB = report.getReportId().toString();
		assertEquals(reportIdA, reportIdB);
	}	

	@AfterTest
	public void posCondition() {
		report.flush();
		report.close();
	}

}
