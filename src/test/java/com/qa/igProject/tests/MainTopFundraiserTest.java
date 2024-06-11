package com.qa.igProject.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.igProject.base.BaseTest;
import com.qa.igProject.util.ExcelUtil;

public class MainTopFundraiserTest extends BaseTest{

	@BeforeClass
	public void getMainTopFundraiserObject() {
		mtfp = hp.doClickOnMainTopFundraiserButton();
	}

//		@DataProvider
//		public Object[][] getSPCData(){
//			return new Object[][] {
//				{"pranit mahure","pranit.mahure@impactguru.com","9168261197"}};
//		}

	@DataProvider
	Object [] [] getSPCData() {
		Object [] [] getSPCData =  ExcelUtil.getTestData("Sheet1");
		return getSPCData;
	}

	@Test 
	void verifyUrlUtmTest() {
		boolean value = mtfp.verifyUrlUtms();
		Assert.assertEquals(value, true);
	}

	@Test(dataProvider="getSPCData")
	public void mainDonateSpcTest(String fullName , String email , String mobile ) {
		boolean contriButeButtonIsDisplayed = mtfp.mainDonateSpc(fullName, email, mobile);
		Assert.assertEquals(true, contriButeButtonIsDisplayed);
	}

}
