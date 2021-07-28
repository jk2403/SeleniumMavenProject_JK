package test;

//Sample test in Java to run Automate session.
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserStackDemo 
{
	
public static final String AUTOMATE_USERNAME = "jayakumar_ZTxhr7";
public static final String AUTOMATE_ACCESS_KEY = "TdPt2gvK11AhQ8SqQkyr";
public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

public static void main(String[] args) throws Exception 
{
 DesiredCapabilities capabilities = new DesiredCapabilities();
 capabilities.setCapability("browserName", "Chrome");
 capabilities.setCapability("browserVersion", "latest");
 HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
 browserstackOptions.put("os", "Windows");
 browserstackOptions.put("osVersion", "10");
 browserstackOptions.put("projectName", "Test");
 browserstackOptions.put("buildName", "Build 2.2.3");
 browserstackOptions.put("sessionName", "GooGle_Search");
 //browserstackOptions.put("local", "true");
 browserstackOptions.put("debug", "true");
 browserstackOptions.put("networkLogs", "true");
 browserstackOptions.put("seleniumVersion", "3.7.0");
 capabilities.setCapability("bstack:options", browserstackOptions);
 
 
 
 WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
 
 driver.get("https://www.google.com");
 WebElement element = driver.findElement(By.name("q"));
 element.sendKeys("BrowserStack");
 element.submit();

 
 
// Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
 WebDriverWait wait = new WebDriverWait(driver, 5);
 try {
 	wait.until(ExpectedConditions.titleContains("BrowserStack"));
 	markTestStatus("passed","Yaay title contains 'BrowserStack'!",driver);
 }
 catch(Exception e) {
 	markTestStatus("failed","Naay title does not contain 'BrowserStack'!",driver);
 }
 System.out.println(driver.getTitle());
 driver.quit();
 
}
// This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
public static void markTestStatus(String status, String reason, WebDriver driver) {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
}
} 