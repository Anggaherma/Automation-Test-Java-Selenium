package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		GoogleSearchTest();
		
	}
	
	public static void GoogleSearchTest() {
		
		//Setup WebDriver Automatically
		WebDriverManager.chromedriver().setup();
		
		// Initialize WebDriver with the configured options
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		//Go to url
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		searchPageObj.setTextInSearchBox("A B C D");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchPageObj.clickSearchButton();
		
		driver.close();
		
		System.out.println("Test successfully");
	
		
	}

}
