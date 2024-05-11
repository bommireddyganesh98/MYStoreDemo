package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartTest extends BaseClass {
	IndexPage indexpage;
	AddToCartPage addtocart;
	SearchResultPage searchresult;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}
	@Test(groups={"Sanity","Regression"})
	public void addtoCartTest() {
		indexpage=new IndexPage();
		searchresult=indexpage.searchProduct("Sleeveless knee-length chiffon dress. V-neckline with elastic under the bust lining.");
		addtocart=searchresult.clickOnSearchProduct();
		addtocart.ValidateWarning();
		addtocart.enterQuantity("2");
		addtocart.selectSize("M");
		addtocart.clickOnAddtoCart();
		boolean result=addtocart.ValidateProductAddedToCart();
		assertTrue(result);
		
		
	}

}
