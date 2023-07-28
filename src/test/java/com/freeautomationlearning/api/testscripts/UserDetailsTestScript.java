package com.freeautomationlearning.api.testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.freeautomationlearning.base.BaseAPITest;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.freeautomationlearning.utlis.APIConstants;

@Listeners(com.freeautomationlearning.listeners.TestListeners.class)
public class UserDetailsTestScript extends BaseAPITest{

	
	@Test
	public void verifyUserDetails()
	{
		Map<String, String> details = user.verifyUserNameDetails("2");
		Assert.assertEquals(utilClass.getResponseStatus(), APIConstants.OK);
		ExtentReportManager.logMessage(Status.INFO, "Expected Result : Michael"+" || Actual Result : "+details.get("firstName"));
		Assert.assertEquals(details.get("firstName"), "Michael", "First Name is not matching");
		ExtentReportManager.logMessage(Status.INFO, "Expected Result : Lawson"+" || Actual Result : "+details.get("lastName"));
		Assert.assertEquals(details.get("lastName"), "Lawson", "Last Name is not matching");
	}
	
	@Test
	public void verifyUsersDetails()
	{
		Map<String, String> details = user.verifyUserNameDetails("1");
		Assert.assertEquals(utilClass.getResponseStatus(), APIConstants.OK);
		Assert.assertEquals(details.get("firstName"), "George", "First Name is not matching");
		Assert.assertEquals(details.get("lastName"), "Bluth", "Last Name is not matching");
	}
	
	@Test
	public void verifyUserCreate()
	{
		Integer userStatus = user.createUser();
		Assert.assertEquals(utilClass.getResponseStatus(), APIConstants.CREATED);
		Assert.assertEquals(userStatus, APIConstants.CREATED, "User create is not created");
	}
}
