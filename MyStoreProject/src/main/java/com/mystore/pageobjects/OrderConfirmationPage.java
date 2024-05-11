package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy (xpath="//p[@class='alert alert-success']")
	WebElement orderSuccessMessage;
	
	public String validateConfirmationMeassage() {
		Action.fluentWait(getDriver(), orderSuccessMessage, 6);
		String msg=orderSuccessMessage.getText();
		return msg;
	}

}
