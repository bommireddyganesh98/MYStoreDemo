package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexpage;
	
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
	public void validateLogo() {
		indexpage=new IndexPage();
		boolean result=indexpage.validateLogo();
		assert result;
		
	}
	@Test(groups="Smoke")
	public void verifyTitle() {
		String actualTitle=indexpage.validatePageTitle();
		assertEquals(actualTitle, "My Shop");
		
	}

}
