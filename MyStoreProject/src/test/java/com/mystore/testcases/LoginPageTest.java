package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

//	 @DataProvider(name = "Credentials")
//	    public Object[][] getCredentials() {
//	        return DataProviders.getcredentials();
//	    }

	@Test(dataProvider = "Credentials", dataProviderClass = DataProviders.class, groups = { "Smoke", "Sanity" })
	public void loginTest(String usname, String pasword) {
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("User is going to click on sign in button");
		loginpage = indexpage.clickOnSignIn();
		Log.info("enter username and password");
		homepage = loginpage.Login(usname, pasword);
		String actualURL = getDriver().getCurrentUrl();
		Log.info("Validating the url");
		System.out.println("=========Git access New password======");
		System.out.println("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");
		System.out.println("=====Git access End===========");
		assertEquals(actualURL, "http://www.automationpractice.pl/index.php?controller=my-account");
		Log.endTestCase("End Test");
	}

}
