package frameWorkParameterozation_Assertions;

import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScreenshot {

	WebDriver driver;
	String url = "https://www.facebook.com";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}

	@Test
	public void takeShot() throws Exception {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("window.scrollTo(0,500)");
		Thread.sleep(400);
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\TakeSS\\screen.jpg");
		Files.copy(source, target);
		
	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(4000);
		driver.close();
	}

}