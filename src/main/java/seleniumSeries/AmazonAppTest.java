package seleniumSeries;

public class AmazonAppTest {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		br.init_driver("chrome");
		br.launchUrl("https://www.amazon.in/");
		String title = br.getPageTitle();

	}

}
