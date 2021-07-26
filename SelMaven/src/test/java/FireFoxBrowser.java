import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//WebDriver driver = new FirefoxDriver();
		String projectpath= "C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\Drivers\\GeckoDriver";
		System.out.println("Projectpath is: "+projectpath);

		String projectpath2= System.getProperty("user.dir");
		System.out.println("Projectpath2 is: "+projectpath2);

		//System.setProperty("webdriver.gecko.driver", projectpath+"\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://www.google.com");*/

	/*	System.setProperty("webdriver.chrome.driver",projectpath2+"\\Drivers\\ChromeDriver\\chromedriver3.exe"); //chromedriver3 supports version:89 and chromedriver2 supports version:90
		WebDriver driver = new ChromeDriver();*/

		//System.setProperty("webdriver.ie.driver", projectpath2+"\\Drivers\\IEDriver\\IEDriverServer2.exe");

		/* Set desired capabilities to Ignore IEDriver zoom level settings and disable native events.
DesiredCapabilities caps = DesiredCapabilities.internetExplorer(); now it is deprecated
caps.setCapability("EnableNativeEvents", false);
caps.setCapability("ignoreZoomSetting", true);
		 */

		/*InternetExplorerOptions capabilities = new InternetExplorerOptions();
		capabilities.ignoreZoomSettings();
		//capabilities.
		capabilities.introduceFlakinessByIgnoringSecurityDomains();*/

		//WebDriver driver = new InternetExplorerDriver(capabilities);

		//WebDriverManager.chromedriver().setup(); WebDriver Manager is the automatic management of Browser drivers for selenium
		//WebDriverManager.chromedriver().browserVersion("89.0").setup();
		//WebDriver driver = new ChromeDriver();

		//WebDriverManager.firefoxdriver().browserVersion("86.0").setup();
		WebDriverManager.firefoxdriver().driverVersion("0.29.0").setup();
		WebDriver driver = new FirefoxDriver();
		
		//WebDriverManager.iedriver().setup();
		/*InternetExplorerOptions capabilities = new InternetExplorerOptions();
		capabilities.introduceFlakinessByIgnoringSecurityDomains();
		capabilities.ignoreZoomSettings();
		//WebDriverManager.iedriver().browserVersion("2.48").setup();
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(capabilities);*/

		driver.get("http://localhost:1080/WebTours/index.htm");

		driver.manage().window().maximize();
		String title= driver.getTitle();
		System.out.println("Title of the google page is : "+title);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame("body");
		//Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		//Thread.sleep(3000);
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("jaya");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("jaya");
		//Thread.sleep(3000);
		
	List<WebElement> ListOfInputElements= driver.findElements(By.xpath("//input"));
		int count = ListOfInputElements.size();
		System.out.println("size of the input elements is : "+count);
		System.out.println("\n List of Input Elements are: "+ListOfInputElements);
	
		//driver.quit();
		driver.close();
		System.out.println("Test End Completed");
	}

}
