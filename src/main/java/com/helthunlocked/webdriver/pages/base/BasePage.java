package com.helthunlocked.webdriver.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.healthunlocked.webdriver.util.PropertyUtil;

public class BasePage {
	
	PropertyUtil property;
	WebDriver driver;

	public BasePage(){
		property = new PropertyUtil();
	}
	
	
	public boolean isDisplayed(final WebElement webElement){
        boolean isDisplayed = false;
        try {
            isDisplayed = webElement.isDisplayed();
        } catch (Exception e) {
        }
        return isDisplayed;
	}
	
	public String getEmail(String username){
		return property.getProperty(username);
	}
	
	public String getPassword(String password){
		return property.getProperty(password);
	}
}
