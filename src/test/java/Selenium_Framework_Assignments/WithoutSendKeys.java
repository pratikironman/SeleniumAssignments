package Selenium_Framework_Assignments;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithoutSendKeys {

	WebDriver driver;
	String url = "https://www.google.com";

	@BeforeMethod
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);

	}

	@Test
	public void testSearchWebpage() throws Exception {
		WebElement search=driver.findElement(By.name("q"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Linkedin'", search); // passing search keys
		System.out.println("Entering text without sendkeys successful"); // success message

	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(4000);
		driver.quit();
	}
}