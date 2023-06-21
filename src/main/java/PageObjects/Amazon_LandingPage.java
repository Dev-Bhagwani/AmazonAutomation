package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_LandingPage {
	
	WebDriver Driver;
	
	public Amazon_LandingPage(WebDriver driver) {
		this.Driver = driver;
		
		PageFactory.initElements(driver, this);  // this means initialize the objects in this class 	
	}
	
	@FindBy(css = "#nav-link-accountList-nav-line-1")     // sign in button 
	WebElement myAccountDropdown;
	
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}

}
