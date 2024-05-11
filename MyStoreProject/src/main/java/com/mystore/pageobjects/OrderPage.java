package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath = "//li[text()='$31']")
	WebElement unitPrice;
	
	@FindBy(xpath = "//span[text()='$69']/parent::td")
	WebElement totalPrice;
	
	@FindBy(xpath ="//td[text()='Total shipping']/following-sibling::td")
	WebElement shippingCharges;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement checkoutBtn;
	
	public double getUnitPrice() {
		System.out.println("gettingPrice");
		Action.fluentWait(getDriver(), unitPrice, 5);
		String unitPrice1=unitPrice.getText();
		System.out.println("Pricegot");
		unitPrice1=unitPrice1.replace("$", "");
		double finalUnitPrice=Double.parseDouble(unitPrice1);
		System.out.println(finalUnitPrice);
		return finalUnitPrice;

	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		totalPrice1=totalPrice1.replace("$", "");
		double finalTotalPrice=Double.parseDouble(totalPrice1);
		System.out.println(finalTotalPrice);
		return finalTotalPrice;
	}
	
	public LoginPage clickOnCheckout() {
		Action.click(getDriver(), checkoutBtn);
		return new LoginPage();
		
		
	}
	
	

}
