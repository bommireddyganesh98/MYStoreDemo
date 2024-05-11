package com.mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actions.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

//	Locators
	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//a[contains(@class,\"color_pick\")]")
	WebElement colorPick;

	@FindBy(xpath = "//span[@class='label label-warning']")
	WebElement Warning;

	@FindBy(xpath = "//h2[text()[normalize-space()='Product successfully added to your shopping cart']]")
	WebElement successMessage;

	@FindBy(xpath = "//span[text()[normalize-space()='Proceed to checkout']]")
	WebElement ProceedToCheckoutBtn;

	public void ValidateWarning() {
		boolean ele = Action.isDisplayed(getDriver(), Warning);
		if (ele == true) {
			Action.click(getDriver(), colorPick);
		}

	}

	public void enterQuantity(String Qty) {
		Action.type(quantity, Qty);

	}

	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}

	public void clickOnAddtoCart() {
		Action.click(getDriver(), addToCartBtn);
	}

	public boolean ValidateProductAddedToCart() {
		Action.fluentWait(getDriver(), successMessage, 5);
		return Action.isDisplayed(getDriver(), successMessage);

	}

	public OrderPage proceedToCheckout() {
		Action.fluentWait(getDriver(), ProceedToCheckoutBtn, 10);
		Action.JSClick(getDriver(), ProceedToCheckoutBtn);
		return new OrderPage();

	}

}
