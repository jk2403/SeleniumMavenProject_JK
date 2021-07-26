package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.EnterCredentials;


public class TestWebToursLogin2 {

	private static WebDriver driver = null;
	public static void main(String[] args) {
		WebToursLogin();
	}
	@Test
	public static void WebToursLogin()
	{
		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path is: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		 driver = new ChromeDriver();
		 driver.get("http://localhost:1080/WebTours/index.htm");
		 driver.manage().window().maximize();
		 System.out.println("Title of the login page is "+driver.getTitle());
		 EnterCredentials.switchFrame(driver);
		 EnterCredentials.textbox_username(driver).sendKeys("jaya");
		 EnterCredentials.textbox_password(driver).sendKeys("jaya");
		 System.out.println("Entered Credentials Successfully");
		 
		 EnterCredentials.button_login(driver).sendKeys(Keys.RETURN);
		 System.out.println("Title of the home page is "+driver.getTitle());
		 System.out.println("Test Completed Successfully");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver.close();
		 driver.quit();
		
	}
}
