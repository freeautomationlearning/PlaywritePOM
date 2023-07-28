package com.freeautomationlearning.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.freeautomationlearning.api.pages.Users;
import com.freeautomationlearning.base.api.APIFactoryBaseImplementation;
import com.freeautomationlearning.utlis.UtilClass;
import com.microsoft.playwright.APIRequest.NewContextOptions;

public class BaseAPITest extends APIFactoryBaseImplementation{

	public Users user;
	public UtilClass utilClass;
	
	@BeforeClass
	public void openAPIInstance()
	{
		utilClass = new UtilClass();
		NewContextOptions contextOptions = createContextOptions()
				.setBaseURL(utilClass.getConfigValue("baseuri"));
		invokeAPI(contextOptions);
		user = new Users(getRequestInstance());	
	}
	
	@AfterClass
	public void closeAPIInstance()
	{
		getPlayWrightInstance().close();
	}
}
