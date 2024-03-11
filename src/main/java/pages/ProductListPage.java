package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utils.Utility;
import utils.WindowManager;

public class ProductListPage extends Base {
	
	
	@FindBy (xpath = "//*[@class='_4rR01T']")
	private List<WebElement> productList;
	
	Utility util;
	int productIndex = 10;
	
	public ProductListPage() {
		PageFactory.initElements(getWebDriver(), this);
		util = new Utility();
	}
	
	public void productTitles() {
		util.waitUntilAllVisible(productList);
		int i = 1;
		for (WebElement element: productList) {
			util.print("(" + i + ") " + element.getText().replaceAll("\n", " "));
			i++;
		}
	}
	
	public String getProductTitle() {
		util.waitUntilAllVisible(productList);
		return productList.get(productIndex).getText();
	}
	
	public ProductDescriptionPage searchProduct() {
		String id = getWebDriver().getWindowHandle();
		WindowManager.getInstance().setMainId(id);
		util.moveToElement(productList.get(productIndex));
		productList.get(productIndex).click();
		return new ProductDescriptionPage();
	}
	
}
