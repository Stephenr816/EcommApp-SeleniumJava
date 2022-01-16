package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ErrorMessages;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		
		accpage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 
	}
	
	@Test(priority = 1)
	public void accountPageTitleTest() {
		
		String title = accpage.getAccountPageTitle();
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE, ErrorMessages.ACC_PAGE_TITLE_ERROR);
		
	}
	
	@Test(priority = 2)
	public void accountPageHeaderTest() {
		
		String header = accpage.getAccPageHeader();
		Assert.assertEquals(header, Constants.ACCOUNT_PAGE_HEADER, ErrorMessages.ACC_PAGE_HEADER_ERROR);
	}
	
	@Test(priority = 3)
	public void accSectionListTest() {
		
		List<String> secList = accpage.getAccSectionList();
		secList.stream().forEach(e -> System.out.println(e));
		Collections.sort(Constants.ACCOUNT_PAGE_SEC_LIST);
		Assert.assertEquals(secList,Constants.ACCOUNT_PAGE_SEC_LIST);
	}
	
	@Test(priority = 4)
	public void logoutLinkTest() {
		
		Assert.assertTrue(accpage.isLogoutExist());
	}
	
	

}
