package com.freeautomationlearning.base.api;

import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

/**
 * @author chirag.s
 *
 */
public interface APIFactoryBase {

	public APIRequestContext invokeAPI(NewContextOptions baseURI);
	
	public APIRequestContext invokeAPI();

	public APIRequestContext getRequestInstance();

	public void setRequestInstance(APIRequestContext request);
	
	public Playwright getPlayWrightInstance();

	public void setPlayWrightInstance(Playwright playWright);
	
	public NewContextOptions createContextOptions();
	
}
