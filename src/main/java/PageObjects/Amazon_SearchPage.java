package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_SearchPage {

	WebDriver Driver;

	public Amazon_SearchPage(WebDriver driver) {
		this.Driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(css = "#nav-search-submit-button")
	WebElement searchButton;

	public WebElement searchBox() {
		return searchBox;
	}

	public WebElement searchButton() {
		return searchButton;
	}
}
