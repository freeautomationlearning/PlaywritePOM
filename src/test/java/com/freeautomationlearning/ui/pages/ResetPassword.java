package com.freeautomationlearning.ui.pages;


import com.freeautomationlearning.base.ui.UIFactoryPageHelperImplementation;
import com.freeautomationlearning.utlis.UtilClass;
import com.microsoft.playwright.Page;

/**
 * @author chirag.s
 *
 */
public class ResetPassword extends UIFactoryPageHelperImplementation{

	Page page; 
	UtilClass utilClass;
	
	public ResetPassword(Page page) {
		// TODO Auto-generated constructor stub
		this.page = page;
		utilClass = new UtilClass();
	}
	
	public HomePage clickCancel()
	{
		click(findLocator(page,utilClass.getLocatorValue("ResetPassword", "cancel"),2),"cancel button");
		return new HomePage(page);
	}
	public void clickResetPassword()
	{
		click(findLocator(page,utilClass.getLocatorValue("ResetPassword", "resetButton"),2),"reset button");
	}
	public Boolean verifyUserNameValidationMessage()
	{
		return isLocatorDisplayed(findLocator(page,utilClass.getLocatorValue("ResetPassword", "usernameValidationMessage"),1),"required message");
	}
}
