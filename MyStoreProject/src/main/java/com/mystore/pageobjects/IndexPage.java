/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

/**
 * @author bommi
 *
 */
public class IndexPage extends BaseClass {
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//	Locators
	@FindBy(linkText = "Sign in")
	WebElement signInbtn;
	
	@FindBy(xpath = "//img[@alt='My Shop']")
	WebElement logo;
	
	@FindBy(id = "search_query_top")
	WebElement search;
	
	@FindBy(name = "submit_search")
	WebElement searchBtn;
	
	String ExpectedTitle = "My Shop";
	
//	Declare Action class instance
	Action action;
	
	public LoginPage clickOnSignIn() {
		Action.click(getDriver(), signInbtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), logo);
	}
	
	public String validatePageTitle() {
		String actual=getDriver().getTitle();
		return actual;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(search, productName);
		Action.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}

}
