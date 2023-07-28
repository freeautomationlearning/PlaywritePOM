package com.freeautomationlearning.base.api;

import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.freeautomationlearning.base.api.APIFactoryBase;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

/**
 * @author chirag.s
 *
 */
public class APIFactoryBaseImplementation implements APIFactoryBase{

	public static ThreadLocal<APIRequestContext> request = new InheritableThreadLocal<APIRequestContext>();
	public static ThreadLocal<Playwright> playWright = new InheritableThreadLocal<Playwright>();
	
	@Override
	public APIRequestContext invokeAPI(NewContextOptions contextOptions) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		APIRequestContext request = playwright.request().newContext(contextOptions);
		setRequestInstance(request);
		setPlayWrightInstance(playwright);
		return request;
	}

	@Override
	public APIRequestContext invokeAPI() {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		APIRequestContext request = playwright.request().newContext();
		setRequestInstance(request);
		setPlayWrightInstance(playwright);
		return request;
	}
	
	@Override
	public APIRequestContext getRequestInstance() {
		// TODO Auto-generated method stub
		return this.request.get();
	}

	@Override
	public void setRequestInstance(APIRequestContext request) {
		// TODO Auto-generated method stub
		this.request.set(request);
		
	}

	@Override
	public Playwright getPlayWrightInstance() {
		// TODO Auto-generated method stub
		return playWright.get();
	}

	@Override
	public void setPlayWrightInstance(Playwright playWright) {
		// TODO Auto-generated method stub
		this.playWright.set(playWright);
	}

	@Override
	public NewContextOptions createContextOptions() {
		// TODO Auto-generated method stub
		return new APIRequest.NewContextOptions();
	}
	
}
