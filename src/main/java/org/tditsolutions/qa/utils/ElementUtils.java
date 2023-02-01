package org.tditsolutions.qa.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void enterText(String text, By locator) {
		driver.findElement(locator).sendKeys(text);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public String getText(By locator)
	{
		System.out.println("Inside getText ");
		System.out.println("Locator: " + locator);
		String text = driver.findElement(locator).getText();
		
		System.out.println("Text Present for Element : " + text);
		return text;
	}

	public boolean waitforalert(int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String WaitForPresenceofElement(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return driver.findElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public List<String> getAllElementsTexts(By locator) {
		List<WebElement> list = driver.findElements(locator);

		List<String> headerList = new ArrayList<String>();

		for (WebElement e : list) {
			headerList.add(e.getText());
		}

		return headerList;
	}
	
	public String ValidationMessage(By locator) {
		return driver.findElement(locator).getAttribute("validationMessage");
	}

}
