package test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TestNGMultipleBrowserDemo {

	 WebDriver driver =null;
	 String projectpath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String BrowserName)
	{
		System.out.println("Browser Name is: "+BrowserName);
		System.out.println("Thread Id: "+Thread.currentThread().getId());
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",projectpath+"//Drivers//GeckoDriver//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webriver.ie.driver", projectpath+"//Drivers//IEDriver//IEDriverServer2.exe");
			InternetExplorerOptions capabilities = new InternetExplorerOptions();
			capabilities.ignoreZoomSettings();
			capabilities.introduceFlakinessByIgnoringSecurityDomains();

			driver = new InternetExplorerDriver(capabilities);
			//driver = new InternetExplorerDriver();
		}
	}
	
	@Test
	public void test()
	{
		 driver.get("http://localhost:1080/WebTours/index.htm");
		 driver.manage().window().maximize();
		 System.out.println("Title of the login page is "+driver.getTitle());
	}
	
	@AfterTest
	public void tearDown()
	{
		
		driver.quit();
		//driver.close();
		System.out.println("Test Completed Successfully");
	}
	
	
}
