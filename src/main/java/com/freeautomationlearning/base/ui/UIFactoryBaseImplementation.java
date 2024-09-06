package com.freeautomationlearning.base.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.aventstack.extentreports.Status;
import com.freeautomationlearning.reports.ExtentReportManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.freeautomationlearning.base.ui.UIFactoryBase;

/**
 * @author chirag.s
 *
 */
public class UIFactoryBaseImplementation implements UIFactoryBase{

	private Playwright playwright;
	private Browser browser;
	private BrowserContext browserContext;
	public static ThreadLocal<Page> page = new InheritableThreadLocal<Page>();
	
	@Override
	public void invokeBrowser(String browserType, String url) {
		try{
			playwright = Playwright.create();
			switch (browserType.toLowerCase()) {
				case "firefox":
					browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
					break;
				case "chrome":
					browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
					break;
				default:
					ExtentReportManager.logMessage(Status.INFO,"INVALID BROWSER TYPE");
					break;
			}
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Integer width = Integer.valueOf(screenSize.width);
			Integer height = Integer.valueOf(screenSize.height);

			browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
			Page page = browserContext.newPage();
			setPageInstance(page);
			getPageInstance().navigate(url);
			ExtentReportManager.logMessage(Status.PASS,"Open the "+browserType.toUpperCase()+" is launched successfully");
			ExtentReportManager.getExtentTestInstance().assignCategory(browserType.toUpperCase());
		}catch (Exception e)
		{
			ExtentReportManager.logMessage(Status.FAIL,"Open the "+browserType.toUpperCase()+" is not launched successfully "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public Page getPageInstance() {
		return page.get();
	}
	
	@Override
	public void setPageInstance(Page pageValue) {
		page.set(pageValue);
	}

	@Override
	public void closeBrowser() {
		if(getPageInstance()!=null)
		{
			getPageInstance().context().browser().close();
			browserContext.close();
			browser.close();
			playwright.close();
		}

    }
}
