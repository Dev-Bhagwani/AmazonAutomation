package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_LoginPage {
	
	WebDriver Driver;
	
	public Amazon_LoginPage(WebDriver driver)  {
		this.Driver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css = "#ap_email")
	WebElement emailBox;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(css = "#ap_password")
	WebElement passwordBox;
	
	@FindBy(css = "#auth-signin-button")
	WebElement signInButton;

	public WebElement emailBox()  {
		return emailBox;
	}
	
	public void continueButton() {
		 continueButton.click();
	}
	
	public WebElement passwordBox() {
		return passwordBox;	
	}
	
	public void signInButton() {
		 signInButton.click();
	}
}
