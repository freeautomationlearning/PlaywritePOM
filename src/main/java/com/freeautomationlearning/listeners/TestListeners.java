package com.freeautomationlearning.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.freeautomationlearning.reports.ExtentReportManager;

/**
 * @author chirag.s
 *
 */
public class TestListeners implements ITestListener, ISuiteListener, IInvokedMethodListener{

	public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Before every method in the Test Class
        //System.out.println(method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // After every method in the Test Class
        //System.out.println(method.getTestMethod().getMethodName());
    	if(testResult.getStatus()==ITestResult.FAILURE)
    	{
//    		ExtentReportManager.addScreenshot();
    	}
    }

    @Override
    public void onStart(ISuite iSuite) {
        ExtentReportManager.initReports();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        
        //End Suite and execute Extents Report
        ExtentReportManager.flushReports();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        
    	ExtentReportManager.createTest(iTestResult.getName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //ExtentReports log operation for passed tests.
    //	ExtentReportManager.addScreenshot();
     //   ExtentReportManager.logMessage(Status.PASS, "Test case: " + getTestName(iTestResult) + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
      
        //Extent report screenshot file and log
    //    ExtentReportManager.addScreenshot();
       // ExtentReportManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());

    }
}
