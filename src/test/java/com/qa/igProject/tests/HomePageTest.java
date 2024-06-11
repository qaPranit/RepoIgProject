package com.qa.igProject.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.igProject.base.BaseTest;
import com.qa.igProject.constants.StartFr3Constants;

public class HomePageTest extends BaseTest
{

	@Test
	public void homePageTitleTest() {
		String actualTitle = hp.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Crowdfunding in India: Best Fundraising Platform Online | ImpactGuru");
	}
	
	@Test
	public void isStartFRMainButtonDisplayedTest() {
		Assert.assertEquals(true, hp.isStartFRMainButtonDisplayed());
	}
	
	@Test
	public void startFr3Test() {
		boolean value = hp.clickStartFr3Button();
		Assert.assertEquals(value,true);
	}
	
}
