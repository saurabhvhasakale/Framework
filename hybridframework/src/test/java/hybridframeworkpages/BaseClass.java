package hybridframeworkpages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import hybridframeworkutilities.Browserfactory;
import hybridframeworkutilities.ConfigDataProvider;
import hybridframeworkutilities.ExcelDataProvider;
import hybridframeworkutilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		reports=new ExtentReports();
		reports.attachReporter(extent);
	}
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void loginApp(String browser,String url)
	{
		//driver=Browserfactory.StartBrowser(driver,config.getBrowser(), config.getURL());
		  driver=Browserfactory.StartBrowser(driver,browser, url);

	}
	@AfterClass
	public void TearDown()
	{
		Browserfactory.quitBrowser(driver);
	}
	
	//ITest result will have as soon as test complete the status got stored
	@AfterMethod
	public void tearDownMethod(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShots(driver)).build());
		}
		else if(Result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed",  MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShots(driver)).build());
		}
		reports.flush();
	}

}
