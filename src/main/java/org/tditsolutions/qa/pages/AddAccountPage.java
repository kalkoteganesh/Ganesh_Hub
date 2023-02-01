package org.tditsolutions.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddAccountPage extends Page{

	By title = By.tagName("h2");
	By accountname = By.name("aname");
	By accountnumber = By.name("anumber");
	By accountfund = By.name("afund");
	By addaccountbutton = By.xpath("//button[contains(text(),'Add Account')]");
	By homepage = By.tagName("a");
	
	
	WebDriver driver;
	
	public AddAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	public String getTitle()
	{
		String actual=elementUtils.getText(title);
		return actual;
	}
	
	public void addaccount(String accname,int accno, int accfund) {
		elementUtils.enterText(accname, accountname);
		elementUtils.enterText(String.valueOf(accfund), accountfund);
		elementUtils.enterText(String.valueOf(accno), accountnumber);
		elementUtils.click(addaccountbutton);
	}
	public String DecimalValidationMessage() {
		return elementUtils.ValidationMessage(accountnumber);
	}
	
	public HomePage Clickonhomebutton() {
		Actions a= new Actions (driver);
		WebElement hlogo = driver.findElement(homepage);
		a.click(hlogo).build().perform();
   	return new HomePage(driver);
	}
	
	public void clickonAddAccBtn() {
		elementUtils.click(addaccountbutton);
	}
	public String BlankValidationMessage() {
		return elementUtils.ValidationMessage(accountname);
	}
	
	
	
	
	
	
	
	
}
