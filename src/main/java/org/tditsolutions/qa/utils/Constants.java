package org.tditsolutions.qa.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

	// Expected results
	public static final String LOGIN_PAGE_HEADER = "TDIT Solutions";
	public static final String HOME_PAGE_TITLE = "TDIT Solutions";
	public static final String INCORRECT_LOGIN_MESSAGE="No such User exists. Invalid Credentials";
	public static final List<String> EXPECTED_SIDE_BAR_HEADERS_HOME_PAGE = Arrays.asList(new String[] { "Trade", "Account", "Security" });
    public static final String BLANK_MESSAGE="Please fill out this field.";
    public static final String ADD_ACCOUNT_TITLE="Add Account";
    public static final String ADD_ACCOUNT_SUCCESSFULL_MESSAGE="Account Registered.. ";
    public static final String DECIMAL_VALIDATION_MESSAGE="Value must be greater than or equal to 0.";
    public static final String DUPLICATE_ACCOUNT_MESSAGE="Failed , try again ";
    public static final String UPDATE_ACCOUNT_TITLE ="Update Balance";
    public static final String UPDATE_ACCOUNT_SUCCESSFULL_MESSAGE ="Balance updated.. ";

}
