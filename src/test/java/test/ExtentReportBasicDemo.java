package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class ExtentReportBasicDemo {
	
	private static WebDriver driver = null;


	public static void main(String[] args) {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("");
		
		// create ExtentReports and attach reporter
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		// create toggle for the given test
		ExtentTest test1 = extent.createTest("Google Search Test1", "This is a test to validate for Google search");
		
		
		//Setup WebDriver Automatically
				WebDriverManager.chromedriver().setup();
				
				// Initialize WebDriver with the configured options
				driver = new ChromeDriver();
				
				// log(Status, detail)
				test1.log(Status.INFO, "Starting Test Case");
				
				// Go to url
				driver.get("https://google.com");
				driver.manage().window().maximize();
				test1.pass("Navigated to Google.com");

				// Enter text in search button
				GoogleSearchPage.texbox_search(driver).sendKeys("Automation Step by Step");
				test1.pass("Enter text in searcbox");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Click search button
				GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
				test1.pass("Press keyboard Enter key");
				
				// Close browser
				driver.close();
				test1.pass("Close the browser");
				
				System.out.println("Test run successfully");
				
				// log(Status, detail)
				test1.info("Test completed");
				
				// Flush all reports
				extent.flush();
	}

}
