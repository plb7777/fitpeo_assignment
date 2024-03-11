package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utils.Utility;

public class CheckoutPage extends Base {

	@FindBy (xpath = "//*[contains(@class, '_17N0em')]")
	private WebElement usernameTextbox;
	
	@FindBy (xpath = "//*[contains(@class, '_3AWRsL')]")
	private WebElement continueButton;
	
	@FindBy (xpath = "(//*[contains(@class, '_17N0em')])[2]")
	private WebElement otpTextbox;
	
	@FindBy (xpath = "//*[contains(@class, '_3AWRsL')]")
	private WebElement loginButton;
	
	@FindBy (xpath = "//*[contains(@class, '_1XFPmK')]")
	private List<WebElement> deliveryAddresses;
	
	@FindBy (xpath = "//*[contains(@class, '_3AWRsL')]")
	private WebElement deliverHereButton;
	
	@FindBy (xpath = "//*[contains(@class, '_2Kn22P')]")
	private List<WebElement> orderTitles;
	
	Utility util;
	
	public CheckoutPage() {
		PageFactory.initElements(getWebDriver(), this);
		util = new Utility();
	}
	
	public void login(String username, String password) {
		util.waitUntilVisible(usernameTextbox);
		usernameTextbox.sendKeys(username);
		continueButton.click();
		otpTextbox.sendKeys(password);
		loginButton.click();
	}
	
	public void chooseDeliveryAddress() {
		util.waitUntilAllVisible(deliveryAddresses);
		deliveryAddresses.get(0).click();
		deliverHereButton.click();
	}
	
	public List<String> orderSummaryTitles() {
		util.waitUntilAllVisible(orderTitles);
		List<String> titles = new ArrayList<>();
		for (WebElement orderTitle: orderTitles) {
			titles.add(orderTitle.getText());
		}
		return titles;
	}
	
	public void continueOrder() {
		continueButton.click();
	}
	
}
