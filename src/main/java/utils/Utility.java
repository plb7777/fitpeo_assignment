package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Base;

public class Utility extends Base {
	
	private String configFile = System.getProperty("user.dir") + "//src//main//resources//properties//config.properties";
	
	public String getValue(String key) {
		Properties pObj = new Properties();
		try {
			FileInputStream fis = new FileInputStream(configFile);
			pObj.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pObj.getProperty(key);
	}
	
	public void sleep(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void print(Object obj) {
		System.out.println(obj);
	}
	
	public void waitUntilVisible(WebElement element) {
		try {
			getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			
		}
	}
	
	public void waitUntilClickable(WebElement element) {
		try {
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			
		}
	}
	
	public void waitUntilAllVisible(List<WebElement> elements) {
		try {
			getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			
		}
	}
	
	public void moveToElement(WebElement element) {
		try {
			getActions().moveToElement(element).perform();
		} catch (Exception e) {
			
		}
	}
	
}
