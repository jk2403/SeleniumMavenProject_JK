package test;

import org.apache.cassandra.thrift.Cassandra.system_add_column_family_args;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		
		//DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("ignoreZoomSetting", true);
		
		//InternetExplorerDriver capabilities = new InternetExplorerDriver();
		InternetExplorerOptions caps = new InternetExplorerOptions();
		caps.ignoreZoomSettings();
		caps.introduceFlakinessByIgnoringSecurityDomains();
		
		System.setProperty("webdriver.ie.driver", projectpath+"\\Drivers\\IEDriver\\IEDriverServer2.exe");
		//WebDriver driver = new InternetExplorerDriver(caps);
		
		WebDriverManager.firefoxdriver().driverVersion("0.29.0").setup();
				WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:1080/WebTours/index.htm");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.close();
	}

}
