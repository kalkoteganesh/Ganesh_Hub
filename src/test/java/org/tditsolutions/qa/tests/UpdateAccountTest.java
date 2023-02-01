package org.tditsolutions.qa.tests;

import org.tditsolutions.qa.pages.UpdateAccountPage;
import org.tditsolutions.qa.testbase.TestBase;
import org.tditsolutions.qa.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.org.apache.bcel.internal.Const;

public class UpdateAccountTest extends TestBase {
	UpdateAccountPage updateaccount;
	@Test
	public void Verify_Title() {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		UpdateAccountPage updateaccount = homePage.openUpdateAccount();
		String actual =updateaccount.getTitle();
		Assert.assertEquals(actual,Constants.UPDATE_ACCOUNT_TITLE);
	}
	
	@Test 
	public void Verify_Valid_Credentials() {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		updateaccount = homePage.openUpdateAccount();
		updateaccount.updateaccountfunction("123456789", "5000");
		boolean actual = updateaccount.isAlertPresent();
		Assert.assertTrue(actual);
		String actual1= updateaccount.getAlertMessage();
		Assert.assertEquals(actual1,Constants.UPDATE_ACCOUNT_SUCCESSFULL_MESSAGE );
	}
	@Test 
	public void Verify_Invalid_Credentials() {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		updateaccount =homePage.openUpdateAccount();
		updateaccount.updateaccountfunction("123456789", "-5000");
		String actual =updateaccount.NegativeValidationMessage();
		Assert.assertEquals(actual, Constants.DECIMAL_VALIDATION_MESSAGE);
	}
	@Test 
	public void Verify_With_All_Fields_Blank() {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		updateaccount = homePage.openUpdateAccount();
		updateaccount.updateaccountfunction(" ", " ");
		String actual =updateaccount.BlankValidationMessage();
		Assert.assertEquals(actual, Constants.BLANK_MESSAGE);
		
	}
	
	@Test 
	public void Verify_Homepage_Button_Update_Account() {
		homePage = loginPage.doLogin("sump1", "techfin@12");
		updateaccount = homePage.openUpdateAccount();
		homePage = updateaccount.clickonhomepagebutton();
		String actual =homePage.getTitle();
		Assert.assertEquals(actual, Constants.HOME_PAGE_TITLE);
		
	}
	
}
