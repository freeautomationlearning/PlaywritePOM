package com.freeautomationlearning.api.pages;

import java.util.HashMap;
import java.util.Map;

import com.freeautomationlearning.base.api.APIFactoryPageHelperImplementation;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.freeautomationlearning.utlis.APIConstants;
import com.freeautomationlearning.utlis.Constants;
import com.freeautomationlearning.utlis.UtilClass;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.options.RequestOptions;

public class Users extends APIFactoryPageHelperImplementation{

	APIRequestContext request;
	UtilClass utilClass;
	ExtentReportManager reporter;
	
	public Users(APIRequestContext request)
	{
		this.request = request;
		utilClass = new UtilClass();
		reporter = new ExtentReportManager();
	}
	
	public Map<String, String> verifyUserNameDetails(String page)
	{
		String uri = "/api/users";
		RequestOptions requestOptions =  createRequestOptions();
		setQueryParameter("page", page);
		setHeader("content-type", APIConstants.CONTENT_TYPE_APPLICATION_JSON);	
		httpsMethod(request, uri, "get", requestOptions);
		Map<String, String> userDetails = new HashMap<String, String>();
		userDetails.put("firstName", getResponseValue(utilClass.getNodeValue("request","user", "first_name")));
		userDetails.put("lastName", getResponseValue(utilClass.getNodeValue("request","user", "last_name")));
		return userDetails;
	}
	
	public int createUser()
	{
		String uri = "/api/users";
		String userBody = utilClass.readFileAsString(Constants.REQUEST_PATH+"CreateUser.json");
		userBody = replaceOldValueVithNewValueforGivenPath(userBody, utilClass.getNodeValue("response","user", "job"), "Enginer");
		System.out.println(userBody);
		RequestOptions requestOptions =  createRequestOptions();
		setBody(userBody);
		httpsMethod(request, uri, "post", requestOptions);
		System.out.println(getResonseInstance().text());
		return getResonseInstance().status();
	}
	
}
