package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
//	Locators
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	@FindBy (xpath = "//span[text()='My credit slips']")
	WebElement myCreditSlips;
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), myCreditSlips); 
	}
	
	public boolean validateMyCreditSlips() {
		return Action.isDisplayed(getDriver(), myCreditSlips);
	}

}
