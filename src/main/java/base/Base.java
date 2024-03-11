package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utility;

public class Base {

	
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	public void initWebDriver() {
		Utility util = new Utility();
		String browserName = util.getValue("browserName");
		int timeOut = Integer.parseInt(util.getValue("timeOut"));
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie") || browserName.equalsIgnoreCase("internet explorer")) {
			driver = new InternetExplorerDriver();
		} else {
			util.print(browserName + " not supported yet");
			return;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		action = new Actions(driver);
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public WebDriverWait getWebDriverWait() {
		return wait;
	}

	public Actions getActions() {
		return action;
	}
	
	public void closeWebDriver() {
		if (driver != null) {
			driver.close();
		}
	}
	
	public void quitWebDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
