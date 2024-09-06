package com.freeautomationlearning.base;

import com.aventstack.extentreports.Status;
import com.freeautomationlearning.reports.ExtentReportManager;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.freeautomationlearning.base.ui.UIFactoryBaseImplementation;
import com.freeautomationlearning.ui.pages.HomePage;
import com.freeautomationlearning.utlis.UtilClass;

import java.lang.reflect.Method;


/**
 * @author chirag.s
 *
 */
public class BaseUITest extends UIFactoryBaseImplementation{

	public UtilClass utilClass;

	@BeforeMethod
	@Parameters({"browserType" })
	public void openBrowser(@Optional("chrome") String browsername, ITestResult result)
	{
		ExtentReportManager.createTest(result.getMethod().getMethodName());
		utilClass = new UtilClass();
		invokeBrowser(browsername, utilClass.getConfigValue("url"));
	}
	
	@AfterMethod
	public void closeBrowserWindow()
	{
		try{
			closeBrowser();
			ExtentReportManager.logMessage(Status.PASS,"Browser is closed sucessfully");
		}catch (Exception e)
		{
			ExtentReportManager.logMessage(Status.FAIL,"Browser is not closed sucessfully Exception ::"+e.getMessage());
		}
	}
}
