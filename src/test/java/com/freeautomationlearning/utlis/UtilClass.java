package com.freeautomationlearning.utlis;

import com.freeautomationlearning.base.api.APIFactoryPageHelperImplementation;
import com.freeautomationlearning.base.utilty.UtilityBaseImplementation;

/**
 * @author chirag.s
 *
 */
public class UtilClass extends UtilityBaseImplementation{

	APIFactoryPageHelperImplementation helperObject;
	
	public UtilClass() {
		// TODO Auto-generated constructor stub
		helperObject = new APIFactoryPageHelperImplementation();
	}
	
	public String getConfigValue(String jsonPath)
	{
		return getJSONValue(Constants.CONFIG_PATH, jsonPath);
	}
	
	public String getLocatorValue(String pageName,String jsonPath)
	{
		return getJSONValue(Constants.LOCATORS_PATH+pageName+".json", jsonPath);
	}
	
	public String getTestDataValue(String jsonPath)
	{
		return getJSONValue(Constants.TEST_DATA_PATH, jsonPath);
	}
	
	public String getNodeValue(String fileName,String pageName,String jsonPath)
	{
		if(fileName.equalsIgnoreCase("request")) {
			String value = getJSONValue(Constants.REQUEST_NODE_LOCATORS_PATH+pageName+".json", jsonPath);
			return value;
		}else { 
		return getJSONValue(Constants.RESPONSE_NODE_LOCATORS_PATH+pageName+".json", jsonPath);
		}
	}
	
	public int getResponseStatus()
	{
		return helperObject.responseStatusCode();
	}
}
