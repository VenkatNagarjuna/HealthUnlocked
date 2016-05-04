package com.healthunlocked.webdriver.util;

import java.io.IOException;
import java.util.Properties;


public class PropertyUtil {
	
	
	Properties properties = new Properties();

	
	public PropertyUtil() {

		try {
			this.properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			this.properties.load(getClass().getClassLoader().getResourceAsStream("default.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to get property.
	 * 
	 * @param property
	 * @return property
	 */
	public String getProperty(final String property){
	  return	this.properties.getProperty(property);
	}
}
