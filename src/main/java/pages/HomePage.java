package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utils.Utility;

public class HomePage extends Base {

	@FindBy (xpath = "//*[@name='q']")
	private WebElement searchProductTextbox;
	
	@FindBy (xpath = "//*[contains(@class, 'header-form-search')]/ul/li")
	private List<WebElement> searchSuggestions;
	
	@FindBy (xpath = "//span[text()= 'Login']")
	private WebElement loginLink;
	
	Utility util;
	
	public HomePage() {
		PageFactory.initElements(getWebDriver(), this);
		util = new Utility();
	}
	
	public String getPageTitle() {
		return getWebDriver().getTitle();
	}
	
	public void enterTextToSearch(String text) {
		util.waitUntilVisible(searchProductTextbox);
		searchProductTextbox.sendKeys(text);
	}
	
	public ProductListPage searchProduct() {
		searchProductTextbox.sendKeys(Keys.ENTER);
		return new ProductListPage();
	}
	
	public LoginPage initLogin() {
		loginLink.click();
		return new LoginPage();
	}
	
}
