package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage indexpage;
	AddToCartPage addtocart;
	SearchResultPage searchresult;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummaryPage ordersummarypage;
	OrderConfirmationPage orderconfirm;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}

	@Test(groups="Regression")
	public void endToEnd() {
		indexpage = new IndexPage();
		searchresult = indexpage
				.searchProduct("Sleeveless knee-length chiffon dress. V-neckline with elastic under the bust lining.");
		addtocart = searchresult.clickOnSearchProduct();
		addtocart.ValidateWarning();
		addtocart.enterQuantity("2");
		addtocart.selectSize("M");
		addtocart.clickOnAddtoCart();
		orderpage = addtocart.proceedToCheckout();
		loginpage = orderpage.clickOnCheckout();
		addresspage = loginpage.Login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage = addresspage.clickOnCheckout();
		shippingpage.checkboxTerms();
		paymentpage = shippingpage.clickOnCheckOut();
		paymentpage.validatePaymentsMethod();
		ordersummarypage=paymentpage.selectPaymentMethod();
		orderconfirm=ordersummarypage.confirmOrder();
		orderconfirm.validateConfirmationMeassage();

	}
}
