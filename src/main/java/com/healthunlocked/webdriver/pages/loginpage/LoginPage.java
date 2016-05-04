package com.healthunlocked.webdriver.pages.loginpage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthunlocked.webdriver.pages.profilepage.ProfilePage;
import com.healthunlocked.webdriver.util.PropertyUtil;
import com.helthunlocked.webdriver.pages.base.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	PropertyUtil propertyUtil = new PropertyUtil();
	
	/**
	 * Web element for logo.
	 */
	@FindBy(xpath = "//img[@class='logo']")
	private WebElement headerLogo;
	
	@FindBy(xpath = "//div[@class='container']//a[@href='/login']")
	private WebElement loginButton;
	
	@FindBy(id ="login-email-input")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(id = "login-submit-button")
	private WebElement loginSumbit;
	
	@FindBy(xpath = "//span[@data-reactid='.0.0.0.1.0.4.0.1']")
	private WebElement userName;
	
	public LoginPage(final WebDriver webDriver){
		
		this.driver = webDriver;
		PageFactory.initElements(this.driver, this);
	}

	
	public boolean titleImageIsPresent(){
		boolean isDisplayed = false;
		try{
		isDisplayed	= this.headerLogo.isDisplayed();
		}catch(Exception e){
			System.out.println("Element not found");
		}
		return isDisplayed;
	}
	
	/**
	 * Method use to click login button.
	 */
	public void clickOnLoginButton(){
		this.loginButton.click();
	}
	
	public void login(){
		
	String username	= propertyUtil.getProperty("email");
	String password =propertyUtil.getProperty("password");
	String profileName = propertyUtil.getProperty("profile.name");
	
	this.email.sendKeys(username);
	this.password.sendKeys(password);
	this.loginSumbit.click();
	
	Assert.assertTrue(this.userName.getText().contains(profileName));
	
	}

}
