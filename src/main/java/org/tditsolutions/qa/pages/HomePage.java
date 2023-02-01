package org.tditsolutions.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tditsolutions.qa.utils.ElementUtils;

public class HomePage extends Page {

	By sideBarHeaders = By.xpath("//div[@class='sidenav']/center/h3");
	By viewTrade = By.xpath("//a[text()='View Trade']");
	By buyTrade = By.xpath("//a[text()='Buy Trade']");
	By sellTrade = By.xpath("//a[text()='Sell Trade']");
	By addAccount = By.xpath("//a[text()='Add Account']");
	By updateAccount = By.xpath("//a[text()='Update Account']");
	By deleteAccount = By.xpath("//a[text()='Delete Account']");
	By addSecurity = By.xpath("//a[text()='Add Security']");
	By updateSecurity = By.xpath("//a[text()='Update security']");
	By deleteSecurity = By.xpath("//a[text()='Delete security']");
	
	By welcomeMsg = By.xpath("//h3[contains(text(),'Welcome')]");
	
	By headerTitle = By.tagName("h2");

	WebDriver driver;
	ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
	}
	
	public String getWelcomeMessage()
	{
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		try
//		{
//			wait.until(ExpectedConditions.presenceOfElementLocated(welcomeMsg));
//			return driver.findElement(welcomeMsg).getText();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return "";
//		}
		return elementUtils.WaitForPresenceofElement(welcomeMsg, 5);
		}
	
	public String getTitle()
	{
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		try
//		{
//			wait.until(ExpectedConditions.presenceOfElementLocated(headerTitle));
//			return driver.findElement(headerTitle).getText();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return "";
//		}
		return elementUtils.WaitForPresenceofElement(headerTitle, 5);
	}
	
	
	public List<String> getSideBarHeaders()
	{
//		List<WebElement> list =driver.findElements(sideBarHeaders);
//		
//		List<String> headerList = new ArrayList<String>();
//		
//		for(WebElement e : list)
//		{
//			headerList.add(e.getText());
//		}
//		
//		return headerList;
		
		return elementUtils.getAllElementsTexts(sideBarHeaders);

	}

	public AddAccountPage openAddAccount()
	{
		elementUtils.click(addAccount);
		return new AddAccountPage(driver);
	}
	 public UpdateAccountPage openUpdateAccount() {
		 elementUtils.click(updateAccount);
		 return new UpdateAccountPage(driver);
		
	 }
	
	
}
