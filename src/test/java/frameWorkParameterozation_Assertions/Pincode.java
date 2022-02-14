package frameWorkParameterozation_Assertions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Pincode {

	WebDriver driver;
	String url = "https://chennaiiq.com/india/pincode/index.asp";

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
	public void testPincode() throws Exception {
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[3]/td[2]/input[1]"))
				.sendKeys("277001");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[4]/td[2]/input[1]")).click();
		WebElement ele = driver
				.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[5]/td[2]/select"));
		Select sle = new Select(ele);
		sle.selectByVisibleText("Uttar Pradesh");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[7]/td/div/input")).click();
		Thread.sleep(4000);
		String pinACity = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr[4]/td[2]"))
				.getText();
		Thread.sleep(4000);
		driver.get(url);
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[3]/td[2]/input[1]"))
				.sendKeys("228132");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[4]/td[2]/input[1]")).click();
		WebElement le = driver
				.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[5]/td[2]/select"));
		Select sle2 = new Select(le);
		sle2.selectByVisibleText("Uttar Pradesh");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[7]/td/div/input")).click();
		Thread.sleep(4000);
		String pinBCity = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td[2]"))
				.getText();
		Thread.sleep(4000);
		System.out.println(pinACity==pinBCity);
		Assert.assertFalse(pinACity == pinBCity);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		driver.close();
	}

}
