package hybridframeworktestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hybridframeworkpages.BaseClass;
import hybridframeworkpages.LoginPage;
import hybridframeworkutilities.Browserfactory;
public class LoginTestCRM extends BaseClass{
	@Test
	public void LoginApp()
	{
	    logger= reports.createTest("Login to CRM");
		//Initialize all locators
	    LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
	    logger.info("Starting application");
	    loginpage.LoginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
	    logger.pass("Login Success");
	
	    
	}
	
	
	

}
