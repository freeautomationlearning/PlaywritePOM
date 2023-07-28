package com.freeautomationlearning.base.utilty;

/**
 * @author chirag.s
 *
 */
public interface UtilityBase {

	public String readJSON(String filePath,String jsonPath,String text);
	
	public String readFileAsString(String fileName);
	
	public String getJSONValue(String filePath,String jsonPath);
	
	
}
