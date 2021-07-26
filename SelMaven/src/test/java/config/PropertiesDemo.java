package config;
//import java.util.logging.LogManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;
public class PropertiesDemo {

	static WebDriver driver= null;
	public static String browserName = null;

	private static Logger logger = LogManager.getLogger(PropertiesDemo.class);

	@BeforeTest
	public void setUpTest()
	{
		PropertiesFile.getProperties();
		String projectpath = System.getProperty("user.dir");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",projectpath+"\\Drivers\\ChromeDriver\\chromedriver3.exe"); //chromedriver3 supports version:89 and chromedriver2 supports version:90
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", projectpath+"\\Drivers\\GeckoDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().driverVersion("0.29.0").setup();
			 driver = new FirefoxDriver();	
		}

	}

	@Test
	public void test() throws InterruptedException
	{
		driver.get("http://localhost:1080/WebTours/index.htm");

		driver.manage().window().maximize();
		String title= driver.getTitle();
		System.out.println("Title of the google page is : "+title);
	
		driver.switchTo().frame("body");
		//Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		//Thread.sleep(3000);
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		//username.clear();
		username.sendKeys("jaya");
		WebElement password = driver.findElement(By.name("password"));
		//password.clear();
		password.sendKeys("jaya");
		//Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown()
	{
		System.out.println("Tear Down Test Started");
driver.quit();
		//driver.close();

//driver.quit();
System.out.println("Test ended succesfully");
PropertiesFile.setProperties();
	}
}
