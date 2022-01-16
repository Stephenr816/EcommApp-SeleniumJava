package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	private By accountsSections = By.cssSelector("div#content h2");
	private By accountHeader = By.cssSelector("div#logo a");
	private By logout = By.linkText("Logout");
	private By searchField = By.name("search"); 
	private By searchButton = By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}
	
	public String getAccountPageTitle() {
		
		return eleUtil.doGetTitle();
	}
	
	public String getAccPageUrl() {
		
		return eleUtil.getCurrentUrl();
	}
	
	public String getAccPageHeader() {
		
		return eleUtil.doGetText(accountHeader);
	}
	
	public List<String> getAccSectionList() {
		
		List<String> accSecTextList = new ArrayList<String>();
		List<WebElement> accSecList = eleUtil.getElements(accountsSections);
		
		for(WebElement e : accSecList ) {
			
			accSecTextList.add(e.getText());
		
		}
		
		Collections.sort(accSecTextList);
		
		return accSecTextList;

}
	
	public boolean isLogoutExist() {
		
		return eleUtil.doIsDisplayed(logout);
	}
	
	//Search method
	public SearchPage doSearch(String productName) {
		
		eleUtil.doSendKeys(searchField, productName);
		eleUtil.doClick(searchButton);
		
		return new SearchPage(driver);
		
	}
	
}
