package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	public WebDriver driver;
	public LoginPage lp;
	public Properties prop;
	public AccountsPage accpage;
	
	@BeforeTest
	public void setup() {
		
		df= new DriverFactory();
		prop = df.init_properties();
		driver = df.init_driver(prop);
		lp = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
