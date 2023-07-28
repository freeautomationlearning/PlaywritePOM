package com.freeautomationlearning.pages;


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
}
