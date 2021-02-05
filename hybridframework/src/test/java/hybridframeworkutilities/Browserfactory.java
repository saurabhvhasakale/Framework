package hybridframeworkutilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserfactory {

	public static WebDriver StartBrowser(WebDriver driver,String BrowserName,String appURL)
	{
		driver=new ChromeDriver();
		
		if(BrowserName.equals("Chrome"))
		{
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(appURL);

		}
		return driver;

		
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
