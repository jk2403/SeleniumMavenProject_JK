package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {

	static WebDriver driver = null;
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
	public static void googleSearch2() 
	{
	
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		System.out.println("Title of the page is: "+driver.getTitle());
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("JayaKumar Rayala");
		

		WebElement ele = driver.findElement(By.xpath("//input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		System.out.println("Test Executed Successfully");
	}	
	@Test
	public static void googleSearch3() 
	{
	
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		System.out.println("Title of the page is: "+driver.getTitle());
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("JayaKumar Rayala");
		

		WebElement ele = driver.findElement(By.xpath("//input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		System.out.println("Test Executed Successfully");
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
