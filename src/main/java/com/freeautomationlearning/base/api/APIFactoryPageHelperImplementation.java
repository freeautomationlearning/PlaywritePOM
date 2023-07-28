package com.freeautomationlearning.base.api;

import com.aventstack.extentreports.Status;
import com.freeautomationlearning.base.api.APIFactoryPageHelper;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

/**
 * @author chirag.s
 *
 */
public class APIFactoryPageHelperImplementation implements APIFactoryPageHelper{

	public static ThreadLocal<APIResponse> response = new InheritableThreadLocal<APIResponse>();
	public static ThreadLocal<RequestOptions> requestOptions = new InheritableThreadLocal<RequestOptions>();
	
	@Override
	public void httpsMethod(APIRequestContext request,String uri,String methodName, RequestOptions requestOptions) {
		
		APIResponse response = null;
		switch (methodName.toLowerCase()) {
		case "get":
			response = request.get(uri, requestOptions);
			ExtentReportManager.logMessage(Status.PASS, "HTTP GET REQUEST : "+uri);
			break;
		case "post":
			response = request.post(uri, requestOptions);
			ExtentReportManager.logMessage(Status.PASS, "HTTP POST REQUEST : "+uri);
			break;
		default:
			ExtentReportManager.logMessage(Status.INFO, "HTTPS METHOD DOES NOT HAVE CORRECT METHOD NAME");
			break;
		}
		
		setResonseInstance(response);
	}

	@Override
	public APIResponse getResonseInstance() {
		// TODO Auto-generated method stub
		return response.get();
	}

	@Override
	public void setResonseInstance(APIResponse response) {
		// TODO Auto-generated method stub
		this.response.set(response);
		//ExtentReportManager.logMessage(Status.INFO, "RESPONSE : "+response.text());
	}

	@Override
	public String getResponseValue(String jsonPath) {
		// TODO Auto-generated method stub
		DocumentContext jsonObject = JsonPath.parse(getResonseInstance().text());
		String textResult = jsonObject.read(jsonPath).toString();
		//System.out.println(textResult);
		return textResult;
	}
	
	@Override
	public String replaceOldValueVithNewValueforGivenPath(String jsonBody, String path, String newValue)
	{
	    try {
	        return JsonPath.parse(jsonBody).set(path,newValue).jsonString();
	    } catch (PathNotFoundException var3) {
	        throw new RuntimeException("No results for path: " + path);
	    }
	}

	@Override
	public RequestOptions createRequestOptions() {
		// TODO Auto-generated method stub
		this.requestOptions.set(RequestOptions.create());
		return getRequestOptionsInstance();
	}

	@Override
	public int responseStatusCode() {
		// TODO Auto-generated method stub
		ExtentReportManager.logMessage(Status.INFO, "RESPONSE STATUS : "+getResonseInstance().status());
		return getResonseInstance().status();
	}

	@Override
	public RequestOptions getRequestOptionsInstance() {
		// TODO Auto-generated method stub
		return requestOptions.get();
	}

	@Override
	public void setgetRequestOptionsInstance(RequestOptions requestOptions) {
		// TODO Auto-generated method stub
		this.requestOptions.set(requestOptions);
	}
	
	@Override
	public void setBody(String body)
	{
		getRequestOptionsInstance().setData(body);
		ExtentReportManager.logMessage(Status.INFO, "BODY : "+body);
	}
	
	@Override
	public void setHeader(String headerName,String headerValue)
	{
		getRequestOptionsInstance().setHeader(headerName, headerValue);
		ExtentReportManager.logMessage(Status.INFO, "SET HEADER : "+headerName+" : "+headerValue);
	}
	
	@Override
	public void setQueryParameter(String headerName,String headerValue)
	{
		getRequestOptionsInstance().setQueryParam(headerName, headerValue);
		ExtentReportManager.logMessage(Status.INFO, "SET QUERY PARAM : "+headerName+" : "+headerValue);
	}
}
