package com.freeautomationlearning.pages;


import com.freeautomationlearning.base.ui.UIFactoryPageHelperImplementation;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.freeautomationlearning.utlis.UtilClass;
import com.microsoft.playwright.Page;

/**
 * @author chirag.s
 *
 */
public class HomePage extends UIFactoryPageHelperImplementation{

	Page page; 
	UtilClass utilClass;
	
	public HomePage(Page page) {
		// TODO Auto-generated constructor stub
		this.page = page;
		utilClass = new UtilClass();
	}
	
	public void enterUserName(String username)
	{
		type(findLocator(page,utilClass.getLocatorValue("HomePage", "username"),1), username,"username field");
	}
	
	public void enterPassword(String password)
	{
		type(findLocator(page,utilClass.getLocatorValue("HomePage", "password"),1), password,"password field");
	}
	
	public DashboardPage clickLogin()
	{
		click(findLocator(page,utilClass.getLocatorValue("HomePage", "login"),1),"Login button");
		return new DashboardPage(page);
	}
	
	public Boolean verifyUserLogout()
	{
		return isLocatorDisplayed(findLocator(page,utilClass.getLocatorValue("HomePage", "password"),0),"password field");
	}
	
	public ResetPassword clickForgotPassword()
	{
		click(findLocator(page,utilClass.getLocatorValue("HomePage", "forgetpassword"),1),"forgot link");
		return new ResetPassword(page);
	}
	
	public DashboardPage loginUser(String username,String password)
	{
		enterUserName(username);
		enterPassword(password);
		return clickLogin();
	}
}
