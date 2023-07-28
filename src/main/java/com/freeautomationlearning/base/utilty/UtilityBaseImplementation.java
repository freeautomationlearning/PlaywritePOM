package com.freeautomationlearning.base.utilty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

/**
 * @author chirag.s
 *
 */
public class UtilityBaseImplementation implements UtilityBase{

	@Override
	public String readJSON(String filePath,String jsonPath,String text) {
		// TODO Auto-generated method stub
		
		DocumentContext jsonObject = JsonPath.parse(text);
		String textResult = jsonObject.read(jsonPath).toString();
		return textResult;
		
	}

	@Override
	public String readFileAsString(String fileName) {
		// TODO Auto-generated method stub
		String data = "";
	    try {
			data = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return data;
	}

	@Override
	public String getJSONValue(String filePath, String jsonPath) {
		// TODO Auto-generated method stub
		String text = readFileAsString(filePath);
		return readJSON(filePath, jsonPath, text);
	}

	public String generateCurrentDateandTime(String format)
	{
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}
}
