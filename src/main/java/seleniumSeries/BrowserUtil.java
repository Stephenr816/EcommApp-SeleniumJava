package seleniumSeries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	WebDriver driver;
	
	/**
	 * This method is used to initialize the WebDriver on the basis of given browsername
	 * @param browserName
	 * @return This method returns the driver
	 */
	public WebDriver init_driver(String browserName) {
		
		System.out.println("Browser name is  " + browserName);
		
		switch (browserName) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
		
		default:
			
			System.out.println("Please pass the correct browsername : " + browserName);
			break;
		}
		
		return driver;
	}
	
	public void launchUrl(String url) {
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
