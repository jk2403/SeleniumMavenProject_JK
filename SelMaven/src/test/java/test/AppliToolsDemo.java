package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class AppliToolsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String ProjectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jrayala\\git\\SeleniumMavenProject_JK\\SelMaven\\Drivers\\ChromeDriver\\chromedriver4.exe");
		WebDriver driver= new ChromeDriver();
		
		//Initialize the Eyes SDk and set your private API key.
		Eyes eye = new Eyes();
		eye.setApiKey("OIDR101F1030oDreTeUZM99u5jIvQbZRm3BC03PEm1lwybLk110");
		
		try 
		{
			
		
		  // initialize a test session and set the browser view port size to 800,600
	      eye.open(driver, "Hello World ! ", "My first Selenium test in Applitools", new RectangleSize(800, 600));
		
	      driver.get("https://applitools.com/helloworld/?diff2");
	      
	      //visual checkpoint #11
	      eye.checkWindow("Hello");
	      
	      //click the click me! button
	     driver.findElement(By.tagName("button")).click();
		
		//visual checkpoint #2
	     eye.checkWindow("click!");
	     
	   //end the test
	     eye.close();
	     
		}
		
		
	   finally
	   {
		
	     
	    // eye.abort();
	     
		/*driver.findElement(By.name("q")).sendKeys("Jaya Kumar Rayala");
		WebElement ele= driver.findElement(By.name("btnK"));
		ele.submit();
		//ele.sendKeys(Keys.ENTER);
		//ele.sendKeys(Keys.RETURN);*/
		
		Thread.sleep(3000);
		//close the browser
		driver.quit();
		
		//if the test was aborted before eye.close() was called, end the test as aborted.
		eye.abortIfNotClosed();
		
	   }
		System.out.println("Test Completed Successfully");
		
	}

}
