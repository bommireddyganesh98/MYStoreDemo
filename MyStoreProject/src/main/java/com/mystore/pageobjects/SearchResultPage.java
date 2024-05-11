package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
//	Locators
	@FindBy(xpath = "//img[@itemprop='image']")
	WebElement searchResult;
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), searchResult);
	}
	
	public AddToCartPage clickOnSearchProduct() {
		Action.click(getDriver(), searchResult);
		return new AddToCartPage();
	}

}
