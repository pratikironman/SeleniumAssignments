package frameWorkParameterozation_Assertions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperty {
	WebDriver driver;
	static Properties prop = new Properties();

	@Before
	public void beforeMethod() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void f() throws InterruptedException, IOException {

		InputStream input = new FileInputStream(
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\config.properties");
		prop.load(input);
		String out = prop.getProperty("url");
		System.out.println(out);

		driver.get(out);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys("Infosys");
		Thread.sleep(5000);

	}

	@Test
	public void login() throws InterruptedException, IOException {
		InputStream input = new FileInputStream(
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\config.properties");
		prop.load(input);
		String out1 = prop.getProperty("url1");
		System.out.println(out1);
		driver.get(out1);
		driver.manage().window().maximize();
		Thread.sleep(5000);

		String userId = prop.getProperty("Username");
		System.out.println(userId);

		String password = prop.getProperty("password");
		System.out.println(password);

		driver.findElement(By.id("email")).sendKeys(userId);
		Thread.sleep(5000);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]")).getText();
		System.out.println(msg);

	}

	@After
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}