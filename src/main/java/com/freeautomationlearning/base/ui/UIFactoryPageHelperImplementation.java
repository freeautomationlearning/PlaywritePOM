package com.freeautomationlearning.base.ui;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.freeautomationlearning.base.ui.UIFactoryPageHelper;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;

/**
 * @author chirag.s
 *
 */
public class UIFactoryPageHelperImplementation implements UIFactoryPageHelper{

	@Override
	public void click(Locator locator,String locatorName) {
		// TODO Auto-generated method stub
		locator.click();
		ExtentReportManager.logMessage(Status.PASS, "Clicked on "+locatorName+" sucessfully.");
		
	}

	@Override
	public void type(Locator locator, String text,String locatorName) {
		// TODO Auto-generated method stub
		locator.type(text);
		ExtentReportManager.logMessage(Status.PASS, "Enter "+text+" on "+locatorName+" sucessfully.");
	}

	@Override
	public void selectTextDropdown(Locator locator,String dropdownText,String locatorName) {
		// TODO Auto-generated method stub
		locator.selectOption(dropdownText);
		ExtentReportManager.logMessage(Status.PASS, "Select the "+dropdownText+" on "+locatorName+" dropdown sucessfully.");
	}

	@Override
	public Locator findLocator(Page page,String loctor,Integer timeoutSecond) {
		// TODO Auto-generated method stub
//		page.waitForSelector(loctor); // Wait for 30 miliseconds to wait the element
		try {
			page.waitForSelector(loctor,new WaitForSelectorOptions().setTimeout(timeoutSecond*1000));
		} catch (Exception e) {
			// TODO: handle exception
			ExtentReportManager.logMessage(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		return page.locator(loctor);
	}

	@Override
	public boolean isLocatorDisplayed(Locator locator,String locatorName) {
		try {
		
			boolean flag = locator.isVisible();
			if (flag) {
				ExtentReportManager.logMessage(Status.PASS, locatorName+" is displayed on the page sucessfully.");
			}else {
				ExtentReportManager.logMessage(Status.FAIL, locatorName+" is not displayed on the page sucessfully.");
			}
			
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
