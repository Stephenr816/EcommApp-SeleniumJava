package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	
	@Test(priority = 1)
	public void getLoginPageTitleTest() {
		
		String title = lp.getLoginPageTitle();
		System.out.println("Login Page Title is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void getLoginPageUrlTest() {
		
		String url = lp.getLoginPageUrl();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	
	}
	
	
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		
		Assert.assertTrue(lp.isForgotPasswordLinkExist());
	
	}
	
	@Test(priority = 4)
	public void doLoginTest() {
		
		lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	

}
