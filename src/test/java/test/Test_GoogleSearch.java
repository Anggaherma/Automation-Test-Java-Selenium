package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_GoogleSearch {
	
	public static void main(String[] args) {
		
		googleSearch();
		
	}
	
public static void googleSearch() {
		
		//Setup WebDriver Automatically
		WebDriverManager.chromedriver().setup();
		
		// Initialize WebDriver with the configured options
		WebDriver driver = new ChromeDriver();
		
		//Go to url
		driver.get("https://google.com");
		driver.manage().window().maximize();

		//Enter text in search button
		WebElement textBox = driver.findElement(By.id("APjFqb"));
		textBox.sendKeys("Automation Step by Step");

		//Click search button
		driver.findElement(By.className("gNO89b")).click();
		
		//Close the browser
		driver.close();
		
		System.out.println("Test completed successfully");
	}

}
