package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_SelectingItems {

	WebDriver Driver;

	public Amazon_SelectingItems(WebDriver driver) {
		this.Driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[contains(@class,'a-size-medium a-color-base')])[1]")
	WebElement OnePlus;  
	
	@FindBy(xpath = "//div[@id='buyBackAccordionRow']")
	WebElement withExchangePanel;

	public WebElement OnepPlus() {
		return OnePlus;
	}
	
	public WebElement withExchangePanel() {
		return withExchangePanel;
	}
}
