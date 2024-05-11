package com.mystore.testcases;

import static org.testng.Assert.assertTrue;
import com.mystore.dataprovider.DataProviders;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import java.util.Random;


public class AccountCreationTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreation;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider="Email", dataProviderClass=DataProviders.class,groups="sanity")
	public void verifyAccountCreationTest(String Email) {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		
//		Generate random Email
		String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<10;i++) {
        	char randomname=allowedChars.charAt(random.nextInt(allowedChars.length()));
        	System.out.println(randomname);
        	email.append(randomname);
        }
        email.append(Email);
        email.append("gmail.com");
        String randomemail=email.toString();
        System.out.println(randomemail);
		accountcreation=loginpage.createNewAccount(randomemail);
		boolean result=accountcreation.ValidateCreateAnAccountTitle();
		assertTrue(result);
		
	}

}
