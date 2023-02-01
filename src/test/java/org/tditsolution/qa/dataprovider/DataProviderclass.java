package org.tditsolution.qa.dataprovider;

import org.tditsolutions.qa.utils.ExcelReader;
import org.testng.annotations.DataProvider;

public class DataProviderclass {

	@DataProvider
	public Object[][] createAccount()
	{
		ExcelReader reader = new ExcelReader("AddAccount");
		return reader.getAllData();
	}

	
	@DataProvider
	public Object[][] updateAccount()
	{
		ExcelReader reader = new ExcelReader("UpdateAccount");
		return reader.getAllData();
	}
	
	
	
	
}
