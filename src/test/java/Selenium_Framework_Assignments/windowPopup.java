package Selenium_Framework_Assignments;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopup {
		
	WebDriver driver;
	String url = "C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\TestPop-up.html";

	
	@BeforeMethod
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(4000);


	}

	@Test
	public void testPopup()throws Exception{
		driver.get(url);
			
		String alert=driver.switchTo().alert().getText();
		System.out.println(alert);
		Thread.sleep(400);
		driver.switchTo().alert().sendKeys("20");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(400);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(400);
		
		
	}
	
	@AfterMethod
	public void tearDown()throws Exception{
			
			Thread.sleep(4000);
			driver.quit();
		}
	

}
