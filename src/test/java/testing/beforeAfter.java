package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class beforeAfter {
	
	static WebDriver driver;
	
	@BeforeSuite
	public void before() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\jar_files\\geckodriver-v0.24.0-win64\\chromedriver.exe");		
		 driver = new ChromeDriver();
		
	}

	
	
}
