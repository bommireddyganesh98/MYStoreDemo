package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath ="//a[contains(.,'Pay by bank wire (order processing will be longer)')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath ="//a[contains(.,'Pay by check (order processing will be longer)')]")
	WebElement payByCheckMethod;
	
	public void validatePaymentsMethod() {
		Action.isDisplayed(getDriver(), bankWireMethod);
		Action.isDisplayed(getDriver(), payByCheckMethod);
	}
	
	public OrderSummaryPage selectPaymentMethod() {
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummaryPage();
	}

	

}
