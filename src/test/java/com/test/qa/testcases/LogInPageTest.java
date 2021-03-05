package com.test.qa.testcases;

import org.testng.annotations.Test;

import com.test.qa.base.BaseTest;

public class LogInPageTest extends BaseTest{
	
	
	@Test
	public void loginPageTest() {
		click("clickSignInBtn_XPATH");
	}

}
