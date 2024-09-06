package com.freeautomationlearning.ui.testscripts;

import com.freeautomationlearning.reports.ExtentReportManager;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.freeautomationlearning.base.BaseUITest;
import com.freeautomationlearning.ui.pages.DashboardPage;
import com.freeautomationlearning.ui.pages.HomePage;
import com.freeautomationlearning.ui.pages.ResetPassword;

/**
 * @author chirag.s
 *
 */
@Listeners(com.freeautomationlearning.listeners.TestListeners.class)
public class LoginTestScript extends BaseUITest{

	@Test(priority = 1)
	public void loginTest()
	{
		ExtentReportManager.getExtentTestInstance().assignCategory("UI");
		HomePage homePage = new HomePage(getPageInstance());
		String username = utilClass.getTestDataValue("username");
		String password = utilClass.getTestDataValue("password");
		
		homePage.enterUserName(username);
		homePage.enterPassword(password);
		DashboardPage dashboardPage =  homePage.clickLogin();
		homePage = dashboardPage.clickOnLogout();
		Assert.assertEquals(homePage.verifyUserLogout(), true);
		
	}
	
	@Test(priority = 2)
	public void forgetPassword()
	{
		ExtentReportManager.getExtentTestInstance().assignCategory("UI");
		HomePage homePage = new HomePage(getPageInstance());
		ResetPassword resetPassword = homePage.clickForgotPassword();
		homePage =  resetPassword.clickCancel();
		Assert.assertEquals(homePage.verifyUserLogout(), false); //Forcefully Failed
	}

	@Test(priority = 3)
	public void forgetPasswordWithoutUsername()
	{
		ExtentReportManager.getExtentTestInstance().assignCategory("UI");
		HomePage homePage = new HomePage(getPageInstance());
		ResetPassword resetPassword = homePage.clickForgotPassword();
		resetPassword.clickResetPassword();
		boolean isUsernameValidation = resetPassword.verifyUserNameValidationMessage();
		if(isUsernameValidation)
		{
			throw new SkipException("Forcefully Skip");
		}
	}
}
