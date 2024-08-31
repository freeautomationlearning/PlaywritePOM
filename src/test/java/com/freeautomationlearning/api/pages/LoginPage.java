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

public class LoginPage extends APIFactoryPageHelperImplementation {

    APIRequestContext request;
    UtilClass utilClass;

    public LoginPage(APIRequestContext request) {
        this.request = request;
        utilClass = new UtilClass();
    }

    public int loginUser() {
        String uri = "/api/login";
        String requestBody = utilClass.readFileAsString(Constants.REQUEST_PATH + "Login.json");

        RequestOptions requestOptions = createRequestOptions();
        setBody(requestBody);
        setHeader("Content-Type", APIConstants.CONTENT_TYPE_APPLICATION_JSON);
        httpsMethod(request, uri, "post", requestOptions);

        return getResonseInstance().status();
    }

    public String getToken() {
        // return the token if the request is successful
        return getResponseValue(utilClass.getNodeValue("response", "login","token"));
    }
}