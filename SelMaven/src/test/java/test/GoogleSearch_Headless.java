package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GoogleSearch_Headless {

	//static WebDriver driver;
	//static ChromeOptions options;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\Drivers\\ChromeDriver\\chromedriver3.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		//ChromeDriver driver = new ChromeDriver(options);

		/*//set the path of the Gecko driver as per the location on local machine
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\Drivers\\GeckoDriver\\geckodriver.exe");

		//Set Firefox Headless mode as TRUE
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		//pass the options parameter in the Firefox driver declaration
		WebDriver driver = new FirefoxDriver(options);*/

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("JayaKumar"); 
		try 
		{
			Thread.sleep(2000); 
		} 
		catch(InterruptedException ie) 
		{
			System.out.println("Catch Exception name is: "+ie); 
		}

		//driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

		WebElement ele = driver.findElement(By.xpath("//input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);

		driver.close(); 
		System.out.println("Test Completed Successfully");


		/*
		 * System.setProperty(
		 * "webdriver.chrome.driver","C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\Drivers\\ChromeDriver\\chromedriver3.exe"
		 * ); ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless"); DesiredCapabilities capabilities = new
		 * DesiredCapabilities(); capabilities.setCapability(ChromeOptions.CAPABILITY,
		 * options); options.merge(capabilities); ChromeDriver driver = new
		 * ChromeDriver(options); driver.get("http://demo.guru99.com/");
		 * driver.manage().window().maximize(); String title = driver.getTitle();
		 * System.out.println("Page Title: " +title); driver.quit();
		 */

	}

}
