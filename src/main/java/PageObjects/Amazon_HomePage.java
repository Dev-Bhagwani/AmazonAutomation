package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_HomePage {
	
	WebDriver Driver;
	public Amazon_HomePage(WebDriver driver)   {
		this.Driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#nav-global-location-popover-link")
	WebElement accountPage;
	
	public WebElement accountPage() {
		return accountPage;
	}
}
