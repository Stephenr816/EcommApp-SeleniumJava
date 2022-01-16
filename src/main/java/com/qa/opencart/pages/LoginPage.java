package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtils elementUtil;
	//1. Private By Locators
	
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPasswordLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	
	//2. Constructors
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtils(driver);
	}
	
	//3. Public page actions
	
	public String getLoginPageTitle() {
		return elementUtil.doGetTitle();
	}
	
	public String getLoginPageUrl() {
		
		return elementUtil.getCurrentUrl();
	}
	
	public boolean isForgotPasswordLinkExist() {
		
		return elementUtil.doIsDisplayed(forgotPasswordLink);
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	
	}
}
