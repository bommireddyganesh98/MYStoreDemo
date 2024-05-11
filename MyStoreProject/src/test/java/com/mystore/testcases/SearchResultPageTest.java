package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}
	@Test(groups="Smoke")
	public void productAvailabilityTest() {
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProduct("Sleeveless knee-length chiffon dress. V-neckline with elastic under the bust lining.");
		boolean result=searchresultpage.isProductAvailable();
		assertTrue(result);
	}
}
