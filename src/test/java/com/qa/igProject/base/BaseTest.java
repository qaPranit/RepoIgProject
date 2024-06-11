package com.qa.igProject.base;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.igProject.factory.DriverFactory;
import com.qa.igProject.pages.HomePage;
import com.qa.igProject.pages.MainTopFundraiserPage;

public class BaseTest {
	public WebDriver driver;

	public DriverFactory df;
	public HomePage hp;
    public Properties prop;
    public MainTopFundraiserPage mtfp;

    
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		 prop = df.initProp();
		driver = df.initDriver(prop);
		hp = new HomePage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
