package Amazon_TestPack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import PageObjects.Amazon_HomePage;
import PageObjects.Amazon_LandingPage;
import PageObjects.Amazon_LoginPage;
import PageObjects.Amazon_SearchPage;
import PageObjects.Amazon_SelectingItems;
import ResourcePack.Amazon_Base;

public class Amazon_LoginTest extends Amazon_Base {

	WebDriver driver;
	
	@Test  
	public void Login() throws IOException, InterruptedException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		
		Amazon_LandingPage landingPage = new Amazon_LandingPage(driver);    
		Amazon_LoginPage loginPage = new Amazon_LoginPage(driver);    
		Amazon_HomePage homePage = new Amazon_HomePage(driver);    
		Amazon_SearchPage  searchPage = new Amazon_SearchPage(driver);
		Amazon_SelectingItems selectingItems = new Amazon_SelectingItems(driver);

		landingPage.myAccountDropdown().click();
		
		loginPage.emailBox().sendKeys(prop.getProperty("email"));
		loginPage.continueButton();
		loginPage.passwordBox().sendKeys(prop.getProperty("password"));
		loginPage.signInButton();
		
		Thread.sleep(5000);
		Assert.assertTrue(homePage.accountPage().isDisplayed());   
		
		searchPage.searchBox().click();
		Thread.sleep(2000);
		searchPage.searchBox().sendKeys(prop.getProperty("searchText"));
		searchPage.searchButton().click();
			
		selectingItems.OnepPlus().click();
		Assert.assertTrue(selectingItems.withExchangePanel().isDisplayed());
		System.out.println("passed");
	}
	
	@AfterMethod
	public void closure() {
		driver.quit();
	}
}
