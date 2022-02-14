package Selenium_Framework_Assignments;

import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
	
	WebDriver driver;
	String url = "https://jqueryui.com/droppable/";

	
	@BeforeMethod
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(4000);


	}

	@Test
	public void testDragdrop()throws Exception{
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
	WebElement src = driver.findElement(By.xpath("/html/body/div[1]"));  //source of element
	WebElement target = driver.findElement(By.xpath("/html/body/div[2]")); //target of element
	
	Actions act = new Actions(driver);
	//act.dragAndDrop(src, target).pause(Duration.ofSeconds(4)).perform();
	
	act.clickAndHold(src).moveToElement(target).pause(Duration.ofSeconds(4)).release().build().perform();
	String msg = driver.findElement(By.xpath("/html/body/div[2]/p")).getText();
	if(msg.equalsIgnoreCase("Dropped!")) {
		
		System.out.println("Dropped Successfully"); //success message
	
		}
	
	}
	
	@AfterMethod
	public void tearDown()throws Exception{

			driver.quit();
		}

	}
