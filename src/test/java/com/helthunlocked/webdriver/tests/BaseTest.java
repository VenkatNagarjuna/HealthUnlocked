package com.helthunlocked.webdriver.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.healthunlocked.webdriver.pages.loginpage.LoginPage;
import com.healthunlocked.webdriver.util.PropertyUtil;

public class BaseTest {

	WebDriver webDriver;
	
	PropertyUtil propertyUtil = new PropertyUtil();
	
	
	public WebDriver getWebDriver(){
		
	 String driver	= propertyUtil.getProperty("driver");
	 this.webDriver = getWebDriver(driver);
	  return this.webDriver;
	}
	
	public WebDriver getWebDriver(final String driverType){
		
		if( (driverType != null) && (driverType.equalsIgnoreCase("firefox"))){
			
			this.webDriver = new FirefoxDriver();
			this.webDriver.manage().window().maximize();
			this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		return this.webDriver;
	}
	
	/**
	 * Method to launch the home page .
	 */
	@BeforeMethod(alwaysRun = true)
	public void lanuchHomePageUrl(){
	 this.webDriver	= getWebDriver();
	 this.webDriver.get(this.propertyUtil.getProperty("url"));
	}
	
	/**
	 * Method to close the session.
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		this.webDriver.close();
	}
	
	public void loginToHealthUnlocked(){
		LoginPage loginPage = new LoginPage(webDriver);
		
		loginPage.clickOnLoginButton();
	}
	
	public void loginAndGoToProfilePage(){
		
	}
}
