package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearch();
		
	}
	
public static void googleSearch() {
		
		//Setup WebDriver Automatically
		WebDriverManager.chromedriver().setup();
		
		// Initialize WebDriver with the configured options
		driver = new ChromeDriver();
		
		//Go to url
		driver.get("https://google.com");
		driver.manage().window().maximize();

		//Enter text in search button
		GoogleSearchPage.texbox_search(driver).sendKeys("Automation Step by Step");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Click search button
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		//Close the browser
		driver.close();
		
		System.out.println("Test completed successfully");
	}

}
