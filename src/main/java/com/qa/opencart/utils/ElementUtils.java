package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//Get Element Method
	public WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}
	
	//Get Elements Method
	public List<WebElement> getElements(By locator) {
		
		return driver.findElements(locator);
	}
	
	//Send Keys Method
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	//Click Method
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	//Get Text Method
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	//Get Title Method
	public String doGetTitle() {
		return driver.getTitle();
	}
	
	//Get Url Method
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	//Is Displayed Method
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	//Get Elements Text List Method
	
	public List<String> getElementsTextList(By locator) {
		
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			
			if (!e.getText().isEmpty()) {
				
				eleTextList.add(e.getText());
			}
			
		}
		
		return eleTextList;
	}
	
	//Get Elements Attribute List Method
	
	public List<String> getElementAttrList(By locator, String attrName) {
		
		List<String> attrList = new ArrayList<String>();
		
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			
			attrList.add(e.getAttribute(attrName));
		}
		
		return attrList;
	}

}
