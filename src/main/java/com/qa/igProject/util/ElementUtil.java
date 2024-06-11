package com.qa.igProject.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.igProject.constants.StartFr3Constants;

public class ElementUtil {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver , Duration.ofSeconds(20) );
		act = new Actions(this.driver);
	}

	//do normal methods

	public WebElement getElementByXpath(By locator) {
		return driver.findElement(locator);
	}

	// getElement with the wait
	public WebElement getElementWithPresenceOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator) );
	}

	public void doClickWithXpath(By locator) {
		getElementByXpath(locator).click();
	}

	public void doSendKeysWithXpath(By locator , String value) {
		getElementByXpath(locator).sendKeys(value);
	}

	// do wait methods

	public void doClickWithXpathByWait(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}

	public void doSendKeysWithXpathByWait(By locator , String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);		
	}

	public Boolean doUrlToBePresent(String url) {
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	//do Actions method

	public void doClickWithXpathByActionsClass(By locator) {
		act.click(getElementByXpath(locator));
	}

	public void doSendKeysWithXpathByActionsClass(By locator , String value) {
		act.sendKeys(getElementByXpath(locator),value);
	}

	//do with wait and Actions class

	public void doClickWithXpathByWaitAndActionsClass(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		act.moveToElement(element).click().build().perform();
	}

	public void doSendkeysWithXpathByWaitAndActionsClass(By locator , String value) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		act.moveToElement(element).sendKeys(value).build().perform();
	}
}























