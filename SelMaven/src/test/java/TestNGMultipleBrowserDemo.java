import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TestNGMultipleBrowserDemo {

	 WebDriver driver = null;
	 String projectpath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName)
	{
		System.out.println("Browser Name is: "+browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.frefox.driver",projectpath+"\\Drivers\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webriver.ie.driver", projectpath+"\\Drivers\\IEDriver\\IEDriverServer2.exe");
			driver = new InternetExplorerDriver();
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
		System.out.println("Test Completed Successfully");
		driver.quit();
		driver.close();
	}
	
	
}
