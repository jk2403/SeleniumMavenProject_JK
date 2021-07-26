package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtentReportTestNGDemo {

	ExtentTest test1;
	ExtentReports extent;
	ExtentSparkReporter spark;
	WebDriver driver;
	@BeforeSuite
	public void setUp()
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtentHtmlReport.html");
		//ExtentHtmlReporter spark = new ExtentHtmlReporter("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtentSparkReport.html");
		extent.attachReporter(spark);
	}

	@BeforeTest
	public void setUpTest()
	{
		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		driver = new ChromeDriver();
		System.out.println("setUpTest executed successfully");
	}
	@Test
	public void test()
	{
		test1= extent.createTest("Extent Test","Sample Extent Test");
		test1.log(Status.PASS, "This step shows usage of Log(status, details)");
		test1.info("This step shows the usage of Info details");
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.jpeg").build());
		test1.addScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.jpeg");
	
		driver.get("https://www.google.co.in/");
		test1.pass("Navigated to google.com");
		//test1.addScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.png").pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.png").build());
		//test1.addScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics", "GooglePage1.png");
		driver.manage().window().maximize();
		System.out.println("Title of the page is: "+driver.getTitle());
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("JayaKumar Rayala");
		test1.pass("Entered test in search box");

		WebElement ele = driver.findElement(By.xpath("//input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		test1.pass("Search functionality succesfully after click on enter key");
		System.out.println("Test Executed Successfully");
	}

	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
	@AfterTest
	public void tearDownTest()
	{
	System.out.println("Test Completed Successfully");
	driver.close();
	driver.quit();
	System.out.println("tearDownTest executed successfully");
	}
}
