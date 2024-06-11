package com.qa.igProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.igProject.constants.MainTopFundraiserConstants;
import com.qa.igProject.util.ElementUtil;

public class MainTopFundraiserPage {
	private By mainDonateButton = By.xpath("//a[@id='cmp-nfr-top-side-donate ']");
	//Donate SPC locators

	private By fullNameMainDonateSPC = By.xpath("//input[@id='full_name']");
	private By emailMainDonateSPC = By.xpath("//input[@id='email_receipt']");
	private By mobileMainDonateSPC = By.xpath("//input[@id='mobile']");
	private By citizenRadioButtonMainDonateSPC = By.xpath("//label[@class = 'radio-label d-flex align-items-center']");
	private By donateNowButtonOnMainSPC = By.xpath("//button[@id='story-popup-donate-button']");
	private By sendAmountOnMainSPC = By.xpath("//input[@id='story_popup_donation_amount']");

	//Second step spc locators
	private By contributeButtonOnMainSPC = By.xpath("//button[@id='donate-card-contribute']");


	private WebDriver driver;
	private ElementUtil eleUtil;
	public MainTopFundraiserPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public boolean verifyUrlUtms() {
		String mainTopFundraiserPageUrl = driver.getCurrentUrl();
		System.out.println(mainTopFundraiserPageUrl);
		boolean value = false;
		if(mainTopFundraiserPageUrl.contains(MainTopFundraiserConstants.URL_FRACTION_UTMS)) { // constant must be static and hence can be called by the classname
			value = true;   //otherwise we need to create the object to call it
		}
		return value;
	}

	public boolean mainDonateSpc(String fullName , String email , String mobile ) {
		eleUtil.doClickWithXpathByWaitAndActionsClass(mainDonateButton);
		eleUtil.getElementByXpath(sendAmountOnMainSPC).clear();
		eleUtil.doSendKeysWithXpath(sendAmountOnMainSPC, MainTopFundraiserConstants.DONATION_AMOUNT);
		eleUtil.doSendKeysWithXpath(fullNameMainDonateSPC, fullName);
		eleUtil.doSendKeysWithXpath(emailMainDonateSPC, email);
		eleUtil.doSendKeysWithXpath(mobileMainDonateSPC, mobile);
		eleUtil.doClickWithXpath(citizenRadioButtonMainDonateSPC);
		eleUtil.doClickWithXpathByWait(donateNowButtonOnMainSPC);
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return eleUtil.getElementWithPresenceOfElementLocated(contributeButtonOnMainSPC)	.isDisplayed();


	}

}







