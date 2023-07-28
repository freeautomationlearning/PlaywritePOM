package com.freeautomationlearning.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.freeautomationlearning.base.ui.UIFactoryBaseImplementation;
import com.freeautomationlearning.pages.HomePage;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.freeautomationlearning.utlis.UtilClass;


/**
 * @author chirag.s
 *
 */
public class BaseUITest extends UIFactoryBaseImplementation{
	
	public HomePage homePage;
	public UtilClass utilClass;
	
	@BeforeClass
	@Parameters({"browserType" })
	public void openBrowser(@Optional("chrome") String browsername)
	{
		utilClass = new UtilClass();
		invokeBrowser(browsername, utilClass.getConfigValue("url"));
		homePage = new HomePage(getPageInstance());
	}
	
	@AfterClass
	public void closeBrowser()
	{
		getPageInstance().context().browser().close();
	}
	
}
