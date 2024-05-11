package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexpage;
	AddToCartPage addtocart;
	SearchResultPage searchresult;
	OrderPage orderpage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}
	@Test
	public void validatePrice() {
		indexpage=new IndexPage();
		searchresult=indexpage.searchProduct("Sleeveless knee-length chiffon dress. V-neckline with elastic under the bust lining.");
		addtocart=searchresult.clickOnSearchProduct();
		addtocart.ValidateWarning();
		addtocart.enterQuantity("2");
		addtocart.selectSize("M");
		addtocart.clickOnAddtoCart();
		orderpage=addtocart.proceedToCheckout();
		double unitprice=orderpage.getUnitPrice();
		double totalprice=orderpage.getTotalPrice();
		double exceptedprice=(unitprice*2)+7;
		assertEquals(exceptedprice, totalprice);
	}
}
