package com.br.rfaengines.testautomation.selenium.pageobject;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.br.rfaengines.testautomation.selenium.driver.DriverManager;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;

/**
 * PageFactory do selenium.
 * 
 * @author roger_azevedo
 * @since 17/05/2018
 * 
 */
public class AbstractPageObject {

	protected AbstractPageObject() {
		String timeOutStr = PropertiesUtil.getValue("timeout");
		int timeout = Integer.parseInt(timeOutStr);
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), timeout), this);
	}

}
