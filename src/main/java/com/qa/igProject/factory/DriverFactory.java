package com.qa.igProject.factory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver;

	/*
	 * This method is use to configure the config properties from the config(source folder) -> config.properties
	 * this return Properties system's class reference with the config properties data
	 */
	public Properties initProp()
	{
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e ) {
			e.printStackTrace();
		}
		return prop;
	}
	/*
	 * This initDriver method is use to initialize the driver on the basis of the browser provided.
	 * @parameters : BrowserName
	 * @return : Initialized driver
	 */

	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("This is the browserName : " + browserName );

		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please enter the proper driver name : the Entered driver name "+ browserName);
		}
        String homePageUrl = prop.getProperty("homePageUrl");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//use to wait for a browser to load a page before throwing time out exception.	
		driver.manage().deleteAllCookies();
		driver.get(homePageUrl);
		return driver;
	}
	/*
	 * Method to take the screen shot it will be linked to the ExtentReportListener in the on the test failure and skipp method
	 * 
	 */
	
	public static String takeScreenShot() {
		
		File srcFile = ((TakesScreenshot)driver)
        .getScreenshotAs(OutputType.FILE);
		
		String path = "./screeenshot/"+System.currentTimeMillis()+".png";
		
		File destination = new File (path);
		try {
			FileUtils.copyFile(srcFile , destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
		
		
		
	}
}
