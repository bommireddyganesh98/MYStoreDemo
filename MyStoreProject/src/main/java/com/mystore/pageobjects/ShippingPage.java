package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy (xpath = "//label[text()='I agree to the terms of service and will adhere to them unconditionally.']/preceding-sibling::div")
	WebElement termsCheckbox;
	
	@FindBy (xpath = "//button[@name=\"processCarrier\"]")
	WebElement checkoutBtn;
	
	public void checkboxTerms() {
		Action.fluentWait(getDriver(), termsCheckbox, 10);
		Action.JSClick(getDriver(), termsCheckbox);
	}
	
	public PaymentPage clickOnCheckOut() {
		Action.click(getDriver(), checkoutBtn);
		return new PaymentPage();
	}

}
