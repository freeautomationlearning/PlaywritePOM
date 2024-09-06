package com.freeautomationlearning.reports;

import java.io.File;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.freeautomationlearning.base.ui.UIFactoryBaseImplementation;
import com.freeautomationlearning.base.utilty.UtilityBaseImplementation;
import com.microsoft.playwright.Page;

/**
 * @author chirag.s
 *
 */
public class ExtentReportManager{

	public static ThreadLocal<ExtentTest> extentTest = new InheritableThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentReports> extent = new InheritableThreadLocal<ExtentReports>();
	
	public static void initReports() {
		// TODO Auto-generated method stub
		if(getExtentInstance()==null)
		{
			ExtentReports extent = new ExtentReports();
			String reportName = new UtilityBaseImplementation().generateCurrentDateandTime("dd_MM_yyyy_HH_mm_ss");
			ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark_"+reportName+".html");
			spark.config().setReportName("Automation Report");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation Report");

			extent.attachReporter(spark);
			extent.setSystemInfo("OS NAME", System.getProperty("os.name"));
			extent.setSystemInfo("OS VERSION", System.getProperty("os.version"));
			extent.setSystemInfo("User Name",System.getProperty("user.name"));
			extent.setSystemInfo("Java Version",System.getProperty("java.version"));
			setExtentInstance(extent);
		}
	}

	public static ExtentTest getExtentTestInstance() {
		// TODO Auto-generated method stub
		return extentTest.get();
	}


	public static void setExtentTestInstance(ExtentTest extent) {
		// TODO Auto-generated method stub
		extentTest.set(extent);
	}
	
	public static void setExtentInstance(ExtentReports extentObject) {
		// TODO Auto-generated method stub
		extent.set(extentObject);
	}
	
	public static ExtentReports getExtentInstance() {
		// TODO Auto-generated method stub
		return extent.get();
	}

	public static void createTest(String testName)
	{
		ExtentTest test = getExtentInstance().createTest(testName);
		setExtentTestInstance(test);
	}
	
	public static void logMessage(Status status,String testStepDescription)
	{
		getExtentTestInstance().log(status, testStepDescription);
	}
	
	public static void addScreenshot()
	{
		try {
			String screenshotName = new UtilityBaseImplementation().generateCurrentDateandTime("dd_MM_yyyy_HH_mm_ss");
			//File file = new File("target/screenshot/Screenshot"+screenshotName+".png");
			File file = new File("target/Spark/");
			UIFactoryBaseImplementation obj = new UIFactoryBaseImplementation();
//			obj.getPageInstance().screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshot/Screenshot"+screenshotName+".png")));
			obj.getPageInstance().screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/Spark/Screenshot"+screenshotName+".png")));
			String path = file.getAbsolutePath();
			getExtentTestInstance().info(MediaEntityBuilder.createScreenCaptureFromPath("Screenshot"+screenshotName+".png").build());
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public static void flushReports()
	{
		getExtentInstance().flush();
	}
	
	public static void logJSONMessage(Status status,String testName)
	{
		getExtentTestInstance().log(status, MarkupHelper.createCodeBlock(testName, CodeLanguage.JSON));
	}
	
}
