package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
//	Locators
	@FindBy(xpath = "(//input[@name='email'])[1]")
	WebElement username;
	
	@FindBy(name = "passwd")
	WebElement Password;
	
	@FindBy(xpath = "//button[@name=\"SubmitLogin\"]")
	WebElement signInBtn;
	
	@FindBy(name = "email_create")
	WebElement emailForNewAccount;
	
	@FindBy(xpath = "//span[text()[normalize-space()='Create an account']]")
	WebElement createAnAccountBtn;
	
	public HomePage Login(String uname, String pswd) {
		Action.type(username, uname);
		Action.type(Password, pswd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage Login1(String uname, String pswd) {
		Action.type(username, uname);
		Action.type(Password, pswd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String email) {
		Action.type(emailForNewAccount,email);
		Action.click(getDriver(), createAnAccountBtn);
		return new AccountCreationPage();
	}
		

}
