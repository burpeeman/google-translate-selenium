package testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class seleniumgrid {
	
	Date D = new Date();
	
    @Parameters({"browser"})
	@Test()
	public void selenium(String borwser) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = null;
		
		if(borwser.equals("chrome")) {
			
			System.out.println(D);

		cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

		//System.setProperty("webdriver.chrome.driver", "C:\\jar_files\\geckodriver-v0.24.0-win64\\chromedriver.exe");

		//WebDriver driver1 = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Mandir udhr hi banega");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);

		driver.quit();
		
		}
		
		if(borwser.equals("firefox")) {
			
			System.out.println(D);

			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);

			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

			//System.setProperty("webdriver.chrome.driver", "C:\\jar_files\\geckodriver-v0.24.0-win64\\chromedriver.exe");

			//WebDriver driver1 = new ChromeDriver();


			driver.get("https://www.google.com");
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Mandir udhr hi banega");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);

			driver.quit();
			
			}

	}

	
}
