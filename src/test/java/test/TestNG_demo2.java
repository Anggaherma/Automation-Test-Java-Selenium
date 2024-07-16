package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_demo2 {

	static WebDriver driver = null;

	@BeforeTest
	public void setupTest() {

		// Setup WebDriver Automatically
		WebDriverManager.chromedriver().setup();

		// Initialize WebDriver with the configured options
		driver = new ChromeDriver();

	}

	@Test
	public static void googleSearch2() {

		// Go to url
		driver.get("https://google.com");
		driver.manage().window().maximize();

		// Enter text in search button
		WebElement textBox = driver.findElement(By.id("APjFqb"));
		textBox.sendKeys("Automation Step by Step");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click search button
		driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);

	}

	@AfterTest
	public void tearDownTest() {

		// Close the browser
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}

}
