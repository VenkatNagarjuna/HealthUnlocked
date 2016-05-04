package com.helthunlocked.webdriver.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.healthunlocked.webdriver.pages.loginpage.LoginPage;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void verifyTitleLogoOnHomePage(){
		
		LoginPage loginPage = new LoginPage(webDriver);
		boolean isLogoImanageDisplayed = loginPage.titleImageIsPresent();
		Assert.assertTrue(isLogoImanageDisplayed);
		}
	
	@Test
	public void verifyWeAreInHomePage(){
		
		
		LoginPage loginPage = new LoginPage(webDriver);
		
		loginPage.clickOnLoginButton();
		
		loginPage.login();
		
	}

}
