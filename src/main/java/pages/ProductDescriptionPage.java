package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utils.Utility;

public class ProductDescriptionPage extends Base {
	
	@FindBy (xpath = "//*[contains(@class, 'B_NuCI')]")
	private WebElement productTitle;
	
	@FindBy (xpath = "//*[contains(@class, '_16Jk6d')]")
	private WebElement amount;
	
	@FindBy (xpath = "//*[contains(@class, '_3v1-ww')]")
	private WebElement addToCardButton;
	
	@FindBy (id = "pincodeInputId")
	private WebElement pincodeTextbox;
	
	
	Utility util;
	
	public ProductDescriptionPage() {
		PageFactory.initElements(getWebDriver(), this);
		util = new Utility();
	}
	
	public String getProductTitle() {
		util.waitUntilVisible(productTitle);
		return productTitle.getText();
	}
	
	public String getAmount() {
		util.waitUntilVisible(amount);
		return amount.getText();
	}
	
	public ViewCartPage addToCart() {
		util.waitUntilClickable(addToCardButton);
		addToCardButton.click();
		return new ViewCartPage();
	}
	
	public void enterPinCode(String pinCode) {
		util.waitUntilVisible(pincodeTextbox);
		if (pincodeTextbox.getAttribute("value").length() < 1) {
			pincodeTextbox.sendKeys(pinCode, Keys.ENTER);
		}
		util.sleep(2);
	}
	
}
