package seleniumSeries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonAppTest {
	
	

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_driver("chrome");
		br.launchUrl("https://www.amazon.in/");
		String title = br.getPageTitle();
		
		ElementUtil el = new ElementUtil(driver);
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		el.doSendKeys(emailId, "naveen@gmail.com");

	}

}
