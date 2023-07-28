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

/**
 * @author chirag.s
 *
 */
public class UIFactoryBaseImplementation implements com.freeautomationlearning.base.ui.UIFactoryBase{

	private Playwright playwright;
	private Browser browser;
	private BrowserContext browserContext;
	public static ThreadLocal<Page> page = new InheritableThreadLocal<Page>();
	
	@Override
	public void invokeBrowser(String browserType, String url) {
		// TODO Auto-generated method stub
		playwright = Playwright.create();
		switch (browserType.toLowerCase()) {
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("INVALID BROWSER TYPE");
			break;
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Integer width = Integer.valueOf(screenSize.width);
        Integer height = Integer.valueOf(screenSize.height);
        
		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = browserContext.newPage();
		setPageInstance(page);
		getPageInstance().navigate(url);
	}
	
	@Override
	public Page getPageInstance() {
		return page.get();
	}
	
	@Override
	public void setPageInstance(Page pageValue) {
		page.set(pageValue);
	}
}
