package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtils eleUtil;

	public ProductInfoPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}

}
