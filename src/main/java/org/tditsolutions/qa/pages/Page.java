package org.tditsolutions.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.tditsolutions.qa.utils.ElementUtils;

public class Page {
	WebDriver driver;
	ElementUtils elementUtils;
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
	}
	public String getAlertMessage()
	{
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		alert.accept();
		return msg;
	}
	public boolean isAlertPresent()
	{
		return elementUtils.waitforalert(5);
	}
}
