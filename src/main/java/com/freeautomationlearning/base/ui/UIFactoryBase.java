package com.freeautomationlearning.base.ui;

import com.microsoft.playwright.Page;

/**
 * @author chirag.s
 *
 */
public interface UIFactoryBase {

	public void invokeBrowser(String browserType, String url);

	public Page getPageInstance();

	public void setPageInstance(Page pageValue);
}
