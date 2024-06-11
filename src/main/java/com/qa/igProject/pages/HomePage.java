package com.qa.igProject.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.igProject.constants.HomePageConstants;
import com.qa.igProject.constants.MainTopFundraiserConstants;
import com.qa.igProject.constants.StartFr3Constants;
import com.qa.igProject.util.ElementUtil;

public class HomePage {
	WebDriver driver ;
	//Locators HomePage
	private By startFRMainButton = By.xpath("//button[@id='btn-new_banner2']");

	//MainTopFundraiserPage
	private By mainTopFundraiserButton = By.xpath("(//a[@id='donateLink'])[2]");

	private ElementUtil eleUtil;

	//Constructor to initialize the driver.

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	//Business logics
	public String getHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean isStartFRMainButtonDisplayed() {
		return eleUtil.getElementByXpath(startFRMainButton).isDisplayed();
	}

	public boolean clickStartFr3Button() {
		boolean value = false;
		String mainWindowId = driver.getWindowHandle();
		eleUtil.doClickWithXpathByWait(startFRMainButton);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(HomePageConstants.LARGE_DEFAULT_TIMEOUT));
		try {
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Set<String> mainAndChildWindowId = driver.getWindowHandles();
		for(String childId : mainAndChildWindowId  ) {
			if(!childId.equals(mainWindowId)) {
				driver.switchTo().window(childId);
				value = eleUtil.doUrlToBePresent(StartFr3Constants.START_FR3_URL);
			}
		}
		//driver.switchTo().window(mainWindowId);
		return value;
	}

	//MainTopFundraiserButton click
	public MainTopFundraiserPage doClickOnMainTopFundraiserButton() {
		eleUtil.doClickWithXpathByWaitAndActionsClass(mainTopFundraiserButton);
		return new MainTopFundraiserPage(driver);

	}














}
