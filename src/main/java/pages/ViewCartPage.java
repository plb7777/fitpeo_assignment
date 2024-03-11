package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utils.Utility;

public class ViewCartPage extends Base {

	@FindBy (xpath = "//*[contains(@class, 'gBNbID')]")
	private WebElement productTitle;
	
	@FindBy (xpath = "//*[text()='Place Order']")
	private WebElement placeOrderButton;
	
	Utility util;
	
	public ViewCartPage() {
		PageFactory.initElements(getWebDriver(), this);
		util = new Utility();
	}
	
	public String getProductTitle() {
		util.waitUntilVisible(productTitle);
		return productTitle.getText();
	}
	
	public CheckoutPage placeOrder() {
		placeOrderButton.click();
		return new CheckoutPage();
	}
	
	
	
}
