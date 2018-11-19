package com.br.rfaengines.testautomation.selenium.pageobject;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.br.rfaengines.testautomation.selenium.driver.DriverManager;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;

public class AbstractPageObject {
	
	protected AbstractPageObject() {
        int timeout = Integer.parseInt(PropertiesUtil.getValue("timeout"));
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), timeout), this);        
    }
}
