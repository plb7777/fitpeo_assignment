package testcases;

import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductDescriptionPage;
import pages.ProductListPage;
import pages.ViewCartPage;
import utils.Utility;
import utils.WindowManager;

public class ProductPurchaseTest {

	Base base;
	Utility util;

	@BeforeTest
	public void init() {
		base = new Base();
		util = new Utility();
		base.initWebDriver();
		String url = util.getValue("url");
		base.getWebDriver().get(url);
	}
	
	@Test
	public void addToCartAndValidateTest() {
		HomePage homePage = new HomePage();
		String actualTitle = homePage.getPageTitle();
		util.print(actualTitle);
		String expectedTitle = util.getValue("homePageTitle");
		Assert.assertTrue(actualTitle.contains(expectedTitle), "Homepage title does not match");
		homePage.enterTextToSearch("laptop");
		ProductListPage productList = homePage.searchProduct();
		String expectedProductName = productList.getProductTitle().replace("...", "");
		util.print("Expected: " + expectedProductName);
		ProductDescriptionPage productDesc = productList.searchProduct();
		Set<String> ids = base.getWebDriver().getWindowHandles();
		String mainId = WindowManager.getInstance().getMainId();
		for (String id: ids) {
			if (!mainId.equalsIgnoreCase(id)) {
				base.getWebDriver().switchTo().window(id);
				break;
			}
		}
		String actualProductName = productDesc.getProductTitle();
		util.print("Actual: " + actualProductName);
		Assert.assertTrue(actualProductName.contains(expectedProductName), "Product name mismatch");
		String amount = productDesc.getAmount();
		util.print(amount);
		productDesc.enterPinCode(util.getValue("pinCode"));
		ViewCartPage viewCart = productDesc.addToCart();
		viewCart.getProductTitle();
		CheckoutPage checkout = viewCart.placeOrder();
		String username = util.getValue("username");
		String password = util.getValue("password");
		checkout.login(username, password);
		checkout.chooseDeliveryAddress();
		List<String> titles = checkout.orderSummaryTitles();
		Assert.assertTrue(titles.contains(expectedProductName), "Product name mismatch");
	}

	@AfterTest
	public void quit() {
		base.quitWebDriver();
	}

}
