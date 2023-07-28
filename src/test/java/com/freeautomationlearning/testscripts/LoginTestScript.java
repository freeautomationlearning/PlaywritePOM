package com.freeautomationlearning.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.freeautomationlearning.base.BaseUITest;
import com.freeautomationlearning.pages.DashboardPage;
import com.freeautomationlearning.pages.HomePage;
import com.freeautomationlearning.pages.ResetPassword;

/**
 * @author chirag.s
 *
 */
@Listeners(com.freeautomationlearning.listeners.TestListeners.class)
public class LoginTestScript extends BaseUITest{

	
	@Test(priority = 1)
	public void loginTest()
	{
		String username = utilClass.getTestDataValue("username");
		String password = utilClass.getTestDataValue("password");
		
		homePage.enterUserName(username);
		homePage.enterPassword(password);
		DashboardPage dashboardPage =  homePage.clickLogin();
		HomePage homePage = dashboardPage.clickOnLogout();
		Assert.assertEquals(homePage.verifyUserLogout(), true);
		
	}
	
	@Test(priority = 2)
	public void forgetPassword()
	{
		ResetPassword resetPassword = homePage.clickForgotPassword();
		HomePage homePage =  resetPassword.clickCancel();
		Assert.assertEquals(homePage.verifyUserLogout(), true);
	}
}
