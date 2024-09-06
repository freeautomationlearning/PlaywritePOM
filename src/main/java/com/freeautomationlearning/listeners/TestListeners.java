package com.freeautomationlearning.listeners;

import org.testng.*;

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

/*    	if(testResult.getStatus()==ITestResult.FAILURE)
    	{
    		ExtentReportManager.addScreenshot();
    	} */
    }

    @Override
    public void onStart(ISuite iSuite) {
        //Start Suite and create Extents Report instance
        ExtentReportManager.initReports();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        
        //End Suite and generate Extents Report
        ExtentReportManager.flushReports();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // You want to invoke browser for before Class then for Extent log uncomment below code
        // 	ExtentReportManager.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //ExtentReports log operation for passed tests. Uncomment if required
    /*	ExtentReportManager.addScreenshot();
        ExtentReportManager.logMessage(Status.PASS, "Test case: " + getTestName(iTestResult) + " is passed.");
    */
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentReportManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());
        ExtentReportManager.addScreenshot();
        // Uncomment below code if you want to add category by error
   //     ExtentReportManager.getExtentTestInstance().assignCategory(iTestResult.getThrowable().toString());

    }
}
