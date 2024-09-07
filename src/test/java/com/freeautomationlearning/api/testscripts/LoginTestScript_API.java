package com.freeautomationlearning.api.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.freeautomationlearning.base.BaseAPITest;
import com.freeautomationlearning.api.pages.LoginPage;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.freeautomationlearning.utlis.APIConstants;

@Listeners(com.freeautomationlearning.listeners.TestListeners.class)
public class LoginTestScript_API extends BaseAPITest {

    LoginPage loginPage;

    @Test
    public void verifyLogin() {
        ExtentReportManager.getExtentTestInstance().assignCategory("API");
        loginPage = new LoginPage(getRequestInstance());
        int loginStatus = loginPage.loginUser();

        // Assert for response status code and token presence
        Assert.assertEquals(loginStatus, APIConstants.OK, "Login request failed with status: " + loginStatus);
        String token = loginPage.getToken();
        Assert.assertNotNull(token, "Token should be present in the response");
        ExtentReportManager.logMessage(Status.INFO, "Token received: " + token);
    }
}