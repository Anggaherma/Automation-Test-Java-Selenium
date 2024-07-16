package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {

	ExtentSparkReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver = null;

	@BeforeSuite
	public void setup() {

		// create ExtentReports and attach reporter
		htmlReporter = new ExtentSparkReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeTest
	public void setupTest() {

		// Setup WebDriver Automatically
		WebDriverManager.chromedriver().setup();

		// Initialize WebDriver with the configured options
		driver = new ChromeDriver();

	}

	@Test
	public void test1() {

		// create toggle for the given test
		ExtentTest test = extent.createTest("Google Search Test1", "This is a test to validate for Google search");
		test.info("");

		driver.get("https://google.com/");
		test.pass("Navigated to Google.com");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");

	}

	@Test
	public void test2() {

		// create toggle for the given test
		ExtentTest test = extent.createTest("Google Search Test1", "This is a test to validate for Google search");
		test.info("");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");

	}

	@AfterTest
	public void tearDownTest() {

		// Close the browser
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}

	@AfterSuite
	public void teardown() {
		extent.flush();
	}
}
