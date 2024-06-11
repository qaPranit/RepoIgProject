package com.qa.igProject.pages;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeClass {
	static WebDriver driver;
	public PracticeClass()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		this.driver=driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public static void main(String [] args) {
		PracticeClass pc = new PracticeClass();
		driver.get("https://www.impactguru.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println(title);
//		By mainStartFRButton	= By.xpath("//button[@id='btn-new_banner2']");
//
//		WebElement startFrButton =  pc.getElement(mainStartFRButton);
//		String mainWindowId = driver.getWindowHandle();
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		startFrButton.click();
//		Set<String>bothWindowId = driver.getWindowHandles();
//		for(String id : bothWindowId)
//		{
//			if(!id.equals(mainWindowId)) {
//				driver.switchTo().window(id);
//				String startFRV3Url = driver.getCurrentUrl();
//				System.out.print(startFRV3Url);
//			}
//		}
//
//		try {
//			Thread.sleep(5);
//		}
//		catch(InterruptedException e)
//		{
//			e.printStackTrace();
//		}
		driver.close();
	//	driver.switchTo().window(mainWindowId);
		//driver.quit();

	}







}

