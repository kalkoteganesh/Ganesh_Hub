package org.tditsolutions.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tditsolutions.qa.utils.ElementUtils;

public class LoginPage {
	ElementUtils elementUtils;
	
	
	
	
	//Page Elements

	By username = By.name("username");
	
	By password = By.name("password");
	
	By loginButton = By.className("login_button");
	
	By header = By.tagName("h1");
	
	
	
	//WebDriver
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
	}
	
	
	//Page Actions
	
	public HomePage doLogin(String user, String pass)
	{
		
		elementUtils.enterText(user, username);
		elementUtils.enterText(pass, password);
		elementUtils.click(loginButton);
		return new HomePage(driver);
	}
	
	
	public String getLoginPageHeader()
	{
		return elementUtils.getText(header);
	}

	public boolean isAlertPresent()
	{
		return elementUtils.waitforalert(5);
	}
	
	public String getAlertMessage()
	{
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		alert.accept();
		return msg;
	}

	public String Blankmessage() {
		return elementUtils.ValidationMessage(username);
	}
}
