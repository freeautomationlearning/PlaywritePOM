package com.freeautomationlearning.base.ui;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author chirag.s
 *
 */
public interface UIFactoryPageHelper {

	public void click(Locator locator,String locatorName);
	
	public void type(Locator locator,String text,String locatorName);
	
	public void selectTextDropdown(Locator locator,String dropdownText,String locatorName);
	
	public Locator findLocator(Page page,String loctor,Integer timeout);
	
	public boolean isLocatorDisplayed(Locator locator,String locatorName);
	
	
}
