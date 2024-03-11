package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utils.Utility;

public class LoginPage extends Base {
	
	@FindBy (xpath = "//*[contains(@class, 'VJZDxU')]")
	private WebElement usernameTextbox;
	
	
	Utility util;
	
	public LoginPage() {
		PageFactory.initElements(getWebDriver(), this);
	}
	
	public void login(String user, String pass) {
		util.waitUntilClickable(usernameTextbox);
		usernameTextbox.sendKeys(user);
	}
	
}
