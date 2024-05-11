package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement checkoutBtn;
	
	public ShippingPage clickOnCheckout() {
		Action.click(getDriver(), checkoutBtn);
		return new ShippingPage();
	}

}
