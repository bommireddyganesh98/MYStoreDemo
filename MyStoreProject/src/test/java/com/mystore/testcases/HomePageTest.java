package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

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
	public void validateOrderHistoryTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean orderHistory = homepage.validateOrderHistory();
		assertTrue(orderHistory);

	}

	@Test(groups="Smoke")
	public void validateMyCreditSlipTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean myCreditslips = homepage.validateMyCreditSlips();
		assertTrue(myCreditslips);

	}

}
