package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.propertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_demo {

	static WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setupTest() {
		String projectPath = System.getProperty("user.dir");
		propertiesFile.getProperties();

		if (browserName.equalsIgnoreCase("chrome")) {
			// Setup WebDriver Automatically
			System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/java/config/config.properties");
			WebDriverManager.chromedriver().setup();

			// Initialize WebDriver with the configured options
			driver = new ChromeDriver();
		} else {
			System.out.println("browser is not chrome");
		}

	}

	@Test
	public static void googleSearch() {

		// Go to url
		driver.get("https://google.com");
		driver.manage().window().maximize();

		// Enter text in search button
		WebElement textBox = driver.findElement(By.id("APjFqb"));
		textBox.sendKeys("Automation Step by Step");

		try {
			Thread.sleep(3000);
			// Click search button
			driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
		} catch (InterruptedException e) {
			System.out.println("Can't find the element");
			// TODO Auto-generated catch block
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDownTest() throws Exception {

		// Close the browser
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
		propertiesFile.setProperties();

	}

}
