package frameWorkParameterozation_Assertions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchTab {

	WebDriver driver;
	String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";

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
	public void testTabSwitch() throws Exception {

		Keys.chord(Keys.CONTROL,Keys.ENTER);
		// click button
		driver.findElement(By.xpath("/html/body/div/div[1]/div/ul/li[2]/a")).click();

		// click on About option and showing sub-options
		driver.findElement(By.xpath("/html/body/div/div[2]/div/h2[1]/a")).click();
		Thread.sleep(4000);

		// for clicking sub-menus and click on Events option
		WebElement webElement = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/div/table/tbody/tr[1]/td/select"));
		Thread.sleep(4000);
		Select selectfrm = new Select(webElement);
		selectfrm.selectByVisibleText("First Name");

		driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/div/table/tbody/tr[2]/td/input[1]"))
				.sendKeys("Sumit");
		Thread.sleep(400);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/div/table/tbody/tr[2]/td/input[2]")).click();

		Thread.sleep(4000);
		String output = driver.findElement(By.xpath("/html/body/div/div[2]/div/p[2]")).getText();
		System.out.println(output);
		String urlNew = driver.getTitle();
		Assert.assertTrue(!url.equals(urlNew)); // Assertion used for validation
		System.out.println(urlNew);
	}

	@AfterMethod
	public void tearDown() throws Exception {

		driver.quit();
	}

}