package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs_Demo1 {

	public static final String USERNAME = "oauth-jayakumar586-40734";
	public static final String ACCESS_KEY = "d40bc7a2-a060-4d02-a759-8e972b5d549d";
	public static final String URL = "https://oauth-jayakumar586-40734:01db04ce-fa86-4656-8f5b-b2ecddcc0df8@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception 
	{		 
		MutableCapabilities sauceOptions = new MutableCapabilities();

		/*ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setExperimentalOption("w3c", true);
		browserOptions.setCapability("browserName", "chrome");
		browserOptions.setCapability("platformName", "Windows 10");
		browserOptions.setCapability("browserVersion", "92");
		browserOptions.setCapability("sauce:options", sauceOptions);*/
	
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		
		//FirefoxProfile profile = new FirefoxProfile();

		//profile.setPreference("intl.accept_languages", "es");
		
		/*firefoxOptions.setCapability("platformName", "Windows 10");
		firefoxOptions.setCapability("browserVersion", "latest");
		firefoxOptions.setCapability("sauce:options", sauceOptions);
		firefoxOptions.setCapability("extendedDebugging", true);
		firefoxOptions.setCapability("autoAcceptAlerts", true);*/
		//firefoxOptions.setProfile(profile);
		
		//DesiredCapabilities capabilities = new DesiredCapabilities(browserOptions);

		//capabilities.setCapability(ChromeOptions.CAPABILITY, browserOptions);

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jrayala\\git\\SeleniumMavenProject_JK\\SelMaven\\Drivers\\ChromeDriver\\chromedriver4.exe");

		//ChromeDriver driver = new ChromeDriver(browserOptions);
		
		InternetExplorerOptions browserOptions = new InternetExplorerOptions();
		browserOptions.setCapability("platformName", "Windows 8");
		browserOptions.setCapability("browserVersion", "10.0");
		browserOptions.setCapability("sauce:options", sauceOptions);
		browserOptions.setCapability("name", "GoogleTest1");
		
	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), browserOptions);

		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jrayala\\git\\SeleniumMavenProject_JK\\SelMaven\\Drivers\\ChromeDriver\\chromedriver4.exe");
	//WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		//driver.switchTo().alert().dismiss();
		
		/*JavascriptExecutor jse4 = (JavascriptExecutor)driver;
		jse4.executeScript("window.scrollBy(0,400)");//Scroll Down to file upload button (+ve)
		   Thread.sleep(3000);
		   

		
		driver.findElement(By.className("jyfHyd")).click();*/
	//	driver.findElement(By.name("q")).sendKeys("JayaKumar Rayala");
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.xpath("//input[@class='gNO89b' or @name='btnK' or @type='submit']")).click();
		
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		//WebElement ele = driver.findElement(By.name("btnK"));
		
	    WebElement element = driver.findElement(By.name("q"));
element.sendKeys("BrowserStack");
Thread.sleep(3000);
element.submit();

	/*WebElement ele = driver.findElement(By.xpath("//input[@name='btnK' or @class='gNO89b' or @type='submit']"));
	 * 
	 
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);*/
		
		
		Thread.sleep(3000);
		driver.close();
		//driver.quit();

		System.out.println("Test Completed Successfully");

	}

}
