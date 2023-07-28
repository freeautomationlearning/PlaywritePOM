package com.freeautomationlearning.base.api;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

/**
 * @author chirag.s
 *
 */
public interface APIFactoryPageHelper {

	public void httpsMethod(APIRequestContext request,String uri,String methodName,RequestOptions requestOptions);
	
	public APIResponse getResonseInstance();

	public void setResonseInstance(APIResponse response);
	
	public String getResponseValue(String jsonPath);
	
	public RequestOptions createRequestOptions();
	
	public String replaceOldValueVithNewValueforGivenPath(String jsonBody, String path, String newValue);
	
	public int responseStatusCode();
	
	public RequestOptions getRequestOptionsInstance();
	
	public void setgetRequestOptionsInstance(RequestOptions requestOptions);
	
	public void setBody(String body);
	
	public void setHeader(String headerName,String headerValue);
	
	public void setQueryParameter(String headerName,String headerValue);
}
