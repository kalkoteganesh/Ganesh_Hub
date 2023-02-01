package org.tditsolutions.qa.tests;

import org.tditsolution.qa.dataprovider.DataProviderclass;
import org.tditsolutions.qa.pages.AddAccountPage;
import org.tditsolutions.qa.testbase.TestBase;
import org.tditsolutions.qa.utils.Constants;
import org.tditsolutions.qa.utils.NumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAccountTest extends TestBase {
	
	@Test
	public void Verify_title() {
    homePage = loginPage.doLogin("sump1", "techfin@12");
	AddAccountPage addAccPage = homePage.openAddAccount();
	String actual =addAccPage.getTitle();
	Assert.assertEquals(actual,Constants.ADD_ACCOUNT_TITLE);
	
	}
	@Test(dataProvider = "createAccount", dataProviderClass = DataProviderclass.class)
	public void Verify_Add_Account_Valid_Credentials(String name, String number, String fund) {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		addAccPage = homePage.openAddAccount();
		addAccPage.addaccount(name, NumUtils.stringDoubleToInt(number), NumUtils.stringDoubleToInt(fund));
		boolean actual =addAccPage.isAlertPresent();
		Assert.assertEquals(actual, true);
		String actualm = addAccPage.getAlertMessage();
		Assert.assertEquals(actualm, Constants.ADD_ACCOUNT_SUCCESSFULL_MESSAGE);
	}
	
	
	@Test
	public void Verify_Add_Account_Invalid_Credentials() {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		addAccPage = homePage.openAddAccount();
		addAccPage.addaccount("ganesh",-2000,-2000);
		String actual =addAccPage.DecimalValidationMessage();
		Assert.assertEquals(actual, Constants.DECIMAL_VALIDATION_MESSAGE);
		
	}
	@Test
	public void Verify_Homepage_Button() {
		homePage= loginPage.doLogin("sump1", "techfin@12");
		addAccPage=homePage.openAddAccount();
		homePage=addAccPage.Clickonhomebutton();
		
		String actual= homePage.getTitle();

		Assert.assertEquals(actual, Constants.HOME_PAGE_TITLE);
	}
	
	@Test 
	public void Verify_Add_Acccount_with_already_registered_Account() {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		addAccPage=homePage.openAddAccount();
		addAccPage.addaccount("TataMotors", 885522, 5000);
		boolean actual = addAccPage.isAlertPresent();
		Assert.assertEquals(actual, true);
		String actual1 =addAccPage.getAlertMessage();
		Assert.assertEquals(actual1, Constants.DUPLICATE_ACCOUNT_MESSAGE);
	}
	  
	@Test
	public void Verify_Add_Account_With_Allfields_Blank() {
		homePage=loginPage.doLogin("sump1", "techfin@12");
		addAccPage=homePage.openAddAccount();
		addAccPage.clickonAddAccBtn();
		String Actual=addAccPage.BlankValidationMessage();
		Assert.assertEquals(Actual,Constants.BLANK_MESSAGE );
		
	}
}
