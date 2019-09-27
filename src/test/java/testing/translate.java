package testing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class translate {

	DesiredCapabilities cap = null;
	RemoteWebDriver driver = null;

	@BeforeTest
	@Parameters({ "browser" })
	public void beforeTest(String browser) throws MalformedURLException {

		if (browser.equals("chrome")) {

			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);

		}

		else if (browser.equals("firefox")) {

			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);

		}

	}

	@Test(dataProviderClass = dataProviders.class, dataProvider = "dataprovider")
	public void change(String text) throws IOException {

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

		driver.get("https://translate.google.co.in");

		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"tl_list-search-box\"]")).sendKeys("portuguese");
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[3]/div[73]")).click();

		driver.findElement(By.xpath("//*[@id=\"source\"]")).sendKeys(text);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String changed = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div"))
				.getText();
		System.out.println("changed from " + text + " to " + changed);

		driver.findElement(By.xpath("//*[@id=\"source\"]")).clear();
driver.quit();
	}

	

}
