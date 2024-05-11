package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
//	Locators
	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement createAnAccountTitle;
	
	public boolean ValidateCreateAnAccountTitle() {
		return Action.isDisplayed(getDriver(), createAnAccountTitle);
	}
}
