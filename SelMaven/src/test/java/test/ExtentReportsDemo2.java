package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo2 {

	static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create ExtentReports and Attach Reporters
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtentSparkReport.html");
		extent.attachReporter(spark);

		//ExtentTest test1 = extent.createTest("Google Search Test One","This is a test to validate Google Search Functionality");
		
		ExtentTest test1= extent.createTest("Google Search Test","This is a test to validate Google Search Functionality");
       /*  .addScreenCaptureFromPath("extent.png")
         .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());*/

		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case");
		//test1.addScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\Chromebrowser1.png").pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\Chromebrowser1.png").build());
		driver.get("https://www.google.co.in/");
		test1.pass("Navigated to ggole.com");
		//test1.addScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.png").pass(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.png").build());
		//test1.addScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics", "GooglePage1.png");
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.jpeg").build());
		test1.addScreenCaptureFromPath("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\ExtenetReportsPics\\GooglePage1.jpeg");
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

		driver.close();
		driver.quit();
		//test1.warning("Should closed the browser after test copleted");
		//calling flush everything writes to the log file, it's not generate report until calling the flush()
		extent.flush();
	}

}
