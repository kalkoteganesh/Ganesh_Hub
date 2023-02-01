package org.tditsolutions.qa.tests;

import java.util.List;

import org.tditsolutions.qa.testbase.TestBase;
import org.tditsolutions.qa.utils.Constants;
import org.tditsolutions.qa.utils.Utils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends TestBase{

	@Test
	public void verify_Sidebar_Headers()
	{
		
		//go to homePage
          homePage = loginPage.doLogin("sump1", "techfin@12");
		//get the actual headers list
		List<String> actualList = homePage.getSideBarHeaders();
		//verify the headers list
		
		List<String> expectedList = Constants.EXPECTED_SIDE_BAR_HEADERS_HOME_PAGE;
		SoftAssert softAssert = Utils.compareList(actualList, expectedList);
		
		softAssert.assertAll();
	}
		
}
