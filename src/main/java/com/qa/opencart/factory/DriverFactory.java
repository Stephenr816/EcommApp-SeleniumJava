package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Stephen Raj
 *
 */
public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	private OptionsManager optionsManager;
	
	public static String highlight = null;
	
	/**
	 * 
	 * @param browserName
	 * @return This method returns the WebDriver
	 */
	public WebDriver init_driver(Properties prop) {
		
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);
		
		String browserName = prop.getProperty("browser").trim();
		
		System.out.println("Initializing the browser : " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			
		} else if(browserName.equalsIgnoreCase("safari")) {
			
				driver = new SafariDriver();
			
		} else {
			
			System.out.println("Please passs the correct browser name " + browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());
		
		return driver;
		
	}
		
		/**
		 * 
		 * @return This method will return the Properties object
		 */
		public Properties init_properties() {
			
			prop = new Properties();
			FileInputStream ip;
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				System.out.println("File not found exception");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IO exception");
				e.printStackTrace();
				
			}
			
		return prop;
		
		}
		
		
	}


