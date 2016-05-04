package com.healthunlocked.webdriver.pages.profilepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	WebDriver driver;
	
	public ProfilePage(final WebDriver webDriver){
		
		this.driver = webDriver;
		
		PageFactory.initElements(this.driver, this);
	}

}
