package frameWorkParameterozation_Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	WebDriver driver;

	@BeforeMethod
	public void beforeClass() {
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\reports\\extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Let's code It");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void testSucessful() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		extentTest = extent.createTest("Sucessful Test");
		extentTest.log(Status.PASS, "Test Method Sucessful");

	}

	@Test
	public void testFailed() {

		extentTest = extent.createTest("Sucessful Test");
		extentTest.log(Status.FAIL, "Test Method Failed");
		Assert.fail("Excecuting Failed Test Method");
	}

	@Test
	public void testSkipped() {
		driver.get("https://en-gb.facebook.com/");
		extentTest = extent.createTest("Sucessful Test");
		extentTest.log(Status.SKIP, "Test Method Skipped");
		throw new SkipException("Excecuting Skipped Test Method");
	}

	@AfterMethod
	public void afterClass() {
		driver.close();
		driver.quit();
		extent.flush();
	}
}