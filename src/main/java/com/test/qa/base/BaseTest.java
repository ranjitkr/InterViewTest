package com.test.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties OR=new Properties();
	public static Properties config=new Properties();
	public String browser;
	
	
	@BeforeSuite
	public void setUp() {
		
		if(driver==null) {
			
			try {
				OR.load(new FileInputStream("./src/test/resources/OR.properties"));
				config.load(new FileInputStream("./src/test/resources/config.properties"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			browser=config.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(config.getProperty("url"));
	}
	
	public void click(String locator) {
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();;
		}else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();;
		}
		else if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();;
		}
	}
	public void type(String text, String locator) {
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(text);
		}else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(text);
		}
		else if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(text);
		}
	}
	
	public void mouseHover(String locator) {
		
	
		Actions action=new Actions(driver);
		if(locator.endsWith("_XPATH")) {
			WebElement we = driver.findElement(By.xpath(OR.getProperty(locator)));
			action.moveToElement(we).perform();
		}
		
	}
	

	
	@AfterSuite(enabled = false)
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
		
	}

}
