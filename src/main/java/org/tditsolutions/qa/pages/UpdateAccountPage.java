package org.tditsolutions.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateAccountPage extends Page {

	By title = By.xpath("//h2[text()='Update Balance']");
	By accnum = By.xpath("//input[@id='myInput']");
	By accfund = By.xpath("//input[@name='afund']");
	By updatebutton = By.xpath("//button[contains(text(),'Update balance')]");
	By homepagebutton = By.xpath("//a[@href=\"homepage.php\"]");
	

	WebDriver driver;

	public UpdateAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getTitle() {
		return elementUtils.getText(title);
	}
	
    public  void updateaccountfunction(String accnumber , String accfunds) {
    	elementUtils.enterText(accnumber,accnum);
    	elementUtils.enterText(accfunds,accfund );
    	elementUtils.click(updatebutton);
    }
	
	public String NegativeValidationMessage()
	{
		return elementUtils.ValidationMessage(accfund);
	}
	public String BlankValidationMessage() 
	{

		return elementUtils.ValidationMessage(accnum);
	}
	public HomePage clickonhomepagebutton() {
		elementUtils.click(homepagebutton);
		return new HomePage(driver);
	}
	
}
