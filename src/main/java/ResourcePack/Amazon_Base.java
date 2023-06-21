package ResourcePack;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Base {

	WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {

		prop = new Properties(); // imported java properties
		String propertiesPath = System.getProperty("user.dir") + "\\src\\main\\java\\ResourcePack\\amazon.properties"; // Location of amazon.properties
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	// Window Handel

	public void windowHandle() throws InterruptedException {
		Thread.sleep(2000);
		String mainwindow = driver.getWindowHandle();
		Set<String> allWindowHandle = driver.getWindowHandles();
		System.out.print(allWindowHandle);
		Iterator<String> i1 = allWindowHandle.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
				System.out.println(driver.getTitle());
				driver.close();
				Thread.sleep(1000);
			}

		}
		driver.switchTo().window(mainwindow);
	}
	
}
