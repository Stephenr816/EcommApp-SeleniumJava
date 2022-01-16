package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	private By searchItemResult = By.cssSelector("div.product-thumb");
	private By resultsItems = By.cssSelector("div.product-thumb h4 a");
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}
	
	public int getProductResultsCount() {
		
		return eleUtil.getElements(searchItemResult).size();
		
	}
	
	public ProductInfoPage selectProductFromResults(String ProductName) {
		List<WebElement> resultItemsList = eleUtil.getElements(resultsItems);
		
		for(WebElement e : resultItemsList) {
			
			if (e.getText().equals(ProductName)) {
				
				e.click();
				break;
				
			}
		}
		
		return new ProductInfoPage(driver);
	}

}
