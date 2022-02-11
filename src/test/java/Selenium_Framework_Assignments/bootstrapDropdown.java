package Selenium_Framework_Assignments;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class bootstrapDropdown {

	WebDriver driver;
	String url = "C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\TestBootStrapDropDown.html";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // implicit
		// wait 5sec
	}

	@Test
	public void testBootStrap() throws Exception {
		int c = 0;

		driver.findElement(By.xpath("/html/body/div/ul/li[4]/a/label/input")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("/html/body/div/ul/li[5]/a/label/input")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("/html/body/div/ul/li[8]/a/label/input")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("/html/body/div/ul/li[10]/a/label/input")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("/html/body/div/ul/li[12]/a/label/input")).click();
		Thread.sleep(200);
		File source1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target1 = new File(
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\DropDownTestScreenshots\\"
						+ (c++) + "screen.jpg");
		Files.copy(source1, target1);
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("/html/body/div/ul/li[10]/a/label/input")).isEnabled())
			driver.findElement(By.xpath("/html/body/div/ul/li[10]/a/label/input")).click();
		if (driver.findElement(By.xpath("/html/body/div/ul/li[5]/a/label/input")).isEnabled())
			driver.findElement(By.xpath("/html/body/div/ul/li[5]/a/label/input")).click();// unchecking element
		Thread.sleep(4000);
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File(
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\DropDownTestScreenshots\\"
						+ (c++) + "screen.jpg");
		Files.copy(source, target);
		Thread.sleep(200);

	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(400);
		driver.quit();
	}
}