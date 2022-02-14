package Selenium_Framework_Assignments;

import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearchWebPage {

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

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Automation Tools for Testing");
		element.submit();
		Thread.sleep(8000);
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id=\"rso\"]//div[1]/div/a"));

		// Get the url of third link and navigate to it
		for (int i = 0; i < findElements.size(); i++) {
			String value = findElements.get(i).getAttribute("href");
			System.out.println(value);
			Thread.sleep(400);
		}
		String third_link = findElements.get(2).getAttribute("href");
		System.out.println(third_link);
		driver.navigate().to(third_link);
		Thread.sleep(4000);
	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(4000);
		driver.quit();
	}

}