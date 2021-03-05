package com.test.qa.testcases;

import org.testng.annotations.Test;

import com.test.qa.base.BaseTest;

public class AddCategoryPageTest extends BaseTest{
	
	
	@Test
	public void addCategoryPageTest() {
		click("clickTshirCat_XPATH");
		mouseHover("selectTShirt_XPATH");
		click("clickOnAddToCart_XPATH");
		click("clickProceedToCheckOut_XPATH");
		
		//payementPage
		click("payPreceedCheckOut_XPATH");
		
		
		
	}
	
}
