package com.br.rfaengines.testautomation.selenium.test;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.br.rfaengines.testautomation.selenium.report.ReportManager;
import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener implements ITestListener {

	private static final Logger LOGGER = Logger.getLogger(TestListener.class);

	private static ExtentReports report = null;
	private static ExtentTest test = null;
	private static String nomeTeste = "";

	@Override
	public void onStart(ITestContext context) {
		nomeTeste = context.getAllTestMethods()[0].getRealClass().getSimpleName();		
		report = ReportManager.getInstance();		
//		String browser = PropertiesUtil.getValue("browser.default");
//		report.addSystemInfo("Browser", browser);
//		report.addSystemInfo("Browser Version", PropertiesUtil.getValue("browser.version." + browser.toLowerCase()));
//		report.addSystemInfo("Environment", PropertiesUtil.getValue("env.default"));
//		report.addSystemInfo("Host", PropertiesUtil.getValue("url.default"));
	}

	@Override
	public void onTestStart(ITestResult result) {
		String nomeMetodo = result.getMethod().getMethodName();
		String[] suites = result.getMethod().getGroups();
		String desc = result.getMethod().getDescription();
		StringBuilder descricao = new StringBuilder();
		descricao.append(nomeMetodo).append(": ").append(desc);
		test = report.startTest(nomeTeste, descricao.toString()).assignCategory(suites)
				.assignAuthor(System.getProperty("user.name"));
		ReportTestManager.setTest(test);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.endTest(test);
		ReportManager.getInstance().flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		failTest(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	private void failTest(ITestResult iTestResult) {
		try {
			test.log(LogStatus.FAIL, iTestResult.getThrowable()
					+ test.addScreenCapture(ScreenShot.takeScreenshot(ReportTestManager.getDirEvidencias())));
			LOGGER.error(iTestResult.getThrowable().getCause());
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			LOGGER.error("Falha ao tentar gravar resultado do teste no report ", e);
		}
	}

}
