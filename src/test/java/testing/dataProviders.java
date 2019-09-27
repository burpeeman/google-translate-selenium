package testing;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

public class dataProviders extends beforeAfter {
	
static ExcelReader excel = null;

static String capture;

@DataProvider()	
public Object[] dataprovider(Method m) {
		
	Object[] getdata = null;
	
	if(m.getName().equals("change")) {
	
		getdata = new Object[6];
		
		getdata[0] = "Hello";
		getdata[1] = "welcome";
		getdata[2] = "piano";
		getdata[3] = "happy birthday";
		getdata[4] = "flowers";
		getdata[5] = "waterbottle";
	
	}
	
	if(m.getName().equals("notchange")) {}
	
	return getdata;
}

public static void screenshot() throws IOException {
	
	Date d = new Date();
	
	 capture = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
	
	 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshotFile, new File("C:\\Users\\bhadaur\\Desktop\\NSI\\"+capture));
	
}

}
