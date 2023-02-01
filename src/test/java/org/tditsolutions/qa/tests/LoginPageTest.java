package org.tditsolutions.qa.tests;

import org.tditsolutions.qa.testbase.TestBase;
import org.tditsolutions.qa.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	
	
	@Test
	public void verify_loginPage_Header()
	{
		String actual = loginPage.getLoginPageHeader();
		Assert.assertEquals(actual, Constants.LOGIN_PAGE_HEADER);
	}


	@Test
	public void verify_Incorrect_Login() 
	{
		//Enter incorrect credentials
		homePage =loginPage.doLogin("test", "test");
		//verify if alert popup is displayed
		boolean actual = loginPage.isAlertPresent();
		Assert.assertEquals(actual, true,"Incorrect Credentials Popup is not displayed");
	
		//Verify the message displayed on popup
		String alertMsg = loginPage.getAlertMessage();
		Assert.assertEquals(alertMsg, Constants.INCORRECT_LOGIN_MESSAGE);
	}
	
	
	@Test
	public void verify_Correct_Login()
	{
		//Enter correct credentials
	     homePage = loginPage.doLogin("sump1", "techfin@12");
		
		//Verify HomePage Header
		String actualHeader = homePage.getTitle();
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_TITLE);
		
		//Verify Welcome Message; 
		String actualMsg = homePage.getWelcomeMessage();
		String expectedMsg = "Welcome " + "sump1";
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test 
	public void Verify_With_Blank() {
		homePage=loginPage.doLogin("", "");
		String actualmessage = loginPage.Blankmessage();
		Assert.assertEquals(actualmessage, Constants.BLANK_MESSAGE);
	}
}
