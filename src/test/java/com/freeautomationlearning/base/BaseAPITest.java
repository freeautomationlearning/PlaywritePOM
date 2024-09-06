package com.freeautomationlearning.base;

import com.aventstack.extentreports.Status;
import com.freeautomationlearning.reports.ExtentReportManager;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.freeautomationlearning.api.pages.Users;
import com.freeautomationlearning.base.api.APIFactoryBaseImplementation;
import com.freeautomationlearning.utlis.UtilClass;
import com.microsoft.playwright.APIRequest.NewContextOptions;
import org.testng.annotations.BeforeMethod;

public class BaseAPITest extends APIFactoryBaseImplementation{
	public UtilClass utilClass;
	
	@BeforeMethod
	public void openAPIInstance(ITestResult result)
	{
		ExtentReportManager.createTest(result.getMethod().getMethodName());
		utilClass = new UtilClass();
		NewContextOptions contextOptions = createContextOptions()
				.setBaseURL(utilClass.getConfigValue("baseuri"));
		invokeAPI(contextOptions);
		ExtentReportManager.logMessage(Status.INFO,"API BASE URI : "+contextOptions.baseURL);
	}
	
	@AfterMethod
	public void closeAPIInstance()
	{
		getPlayWrightInstance().close();
	}
}
