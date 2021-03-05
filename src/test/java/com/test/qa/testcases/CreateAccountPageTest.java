package com.test.qa.testcases;

import org.testng.annotations.Test;

import com.test.qa.base.BaseTest;

public class CreateAccountPageTest extends BaseTest{
	
	
	@Test
	public void createAccountPageTest() {
		click("clickSignInBtn_XPATH");
		type("test544@yopmail.com", "emailAddress_ID");
		click("createAccountBtn_XPATH");
	}

}
