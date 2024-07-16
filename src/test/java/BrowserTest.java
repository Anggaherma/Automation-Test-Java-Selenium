import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		//Setup webdriver automatically
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open the Url
		driver.get("https://google.com/");
		
		//Close the Browser
		driver.close();
		
	}

}
