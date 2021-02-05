package hybridframeworkpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	//creating page object for locators
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="email") WebElement uname; //For locting elements
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginButton;

	//take parameters uname and pass and feed data to script
	public void LoginToCRM(String usernameApplication,String passwordApplication)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
	}
	
	
}

