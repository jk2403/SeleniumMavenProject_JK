package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create ExtentReports and Attach Reporters
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtentSparkReport.html");
		extent.attachReporter(spark);

		ExtentTest test1 = extent.createTest("Google Search Test One","This is a test to validate Google Search Functionality");

		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.co.in/");
		test1.pass("Navigated to ggole.com");

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
		test1.info("Test Completed");

		ExtentTest test2 = extent.createTest("Google Search Test Two","This is a test to validate Google Search Functionality");

		String projectpath2= System.getProperty("user.dir");
		System.out.println("Project Path: "+projectpath2);
		System.setProperty("webdriver.chrome.driver", projectpath2+"//Drivers//ChromeDriver//chromedriver3.exe");
		driver = new ChromeDriver();

		test2.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.co.in/");
		test2.pass("Navigated to ggole.com");

		driver.manage().window().maximize();
		System.out.println("Title of the page is: "+driver.getTitle());
		WebElement searchbox2 = driver.findElement(By.name("q"));
		searchbox2.sendKeys("JayaKumar Rayala");
		test2.pass("Entered test in search box");

		WebElement ele2 = driver.findElement(By.xpath("//input[@name='btnK']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", ele2);
		test2.pass("Search functionality succesfully after click on enter key");
		System.out.println("Test Executed Successfully");
		test2.info("Test Completed");
		
		//driver.close();
		driver.quit();
		//test1.warning("Should closed the browser after test copleted");
		//calling flush everything writes to the log file, it's not generate report until calling the flush()
		extent.flush();
	}

}
