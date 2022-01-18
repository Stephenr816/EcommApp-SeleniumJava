package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails li img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By productQuantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By successMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
	

	public ProductInfoPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	
	}
	
	public String getProductHeader() {
		
		return eleUtil.doGetText(productHeader);
	}
	
	public int getProductImagesCount() {
		
		return eleUtil.getElements(productImages).size();
	}
	
	public Map<String, String> getProductInfoMap() {
		
		Map<String, String> productInfoMap = new HashMap<String, String>();
		
		productInfoMap.put("name", getProductHeader());
		
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
		
		System.out.println("total product meta data is " + metaDataList.size());
		
		//MetaData
		for(WebElement e : metaDataList) {
			
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
		
		//price:
		
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String price = priceList.get(0).getText().trim();
		String Exprice = priceList.get(1).getText().trim();
		
		productInfoMap.put("price", price);
		productInfoMap.put("Exprice", Exprice);
		
		return productInfoMap;
		
		
	}
	
	public void selectQuantity(String qty) {
		
		eleUtil.doSendKeys(productQuantity, qty);
	}
	
	public void addToCart() {
		
		eleUtil.doClick(addToCartButton);
	}
	
	public String getSuccessMessage() {
		
		return eleUtil.doGetText(successMessage);
	}
	
	
	
	

}
