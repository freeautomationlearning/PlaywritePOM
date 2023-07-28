package com.freeautomationlearning.pages;


import com.freeautomationlearning.base.ui.UIFactoryPageHelperImplementation;
import com.freeautomationlearning.utlis.UtilClass;
import com.microsoft.playwright.Page;

/**
 * @author chirag.s
 *
 */
public class DashboardPage extends UIFactoryPageHelperImplementation{

	Page page;
	UtilClass utilClass;
	
	public DashboardPage(Page page)
	{
		this.page = page;
		utilClass = new UtilClass();
	}
	
	public HomePage clickOnLogout()
	{
		click(findLocator(page,utilClass.getLocatorValue("DashboardPage", "logouttab"),1),"Right Menu Tab");
		click(findLocator(page,utilClass.getLocatorValue("DashboardPage", "logoutlink"),1),"Logout link");
		return new HomePage(page);
	}
}
