package test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FirstSeleniumTest1 {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
    googleSearch();
    
	}
	@SuppressWarnings("deprecation")
	public static void googleSearch() 
	{
		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		System.out.println("Title of the page is: "+driver.getTitle());
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("JayaKumar Rayala");
		//WebElement click = driver.findElement(By.name("btnK"));
		//click.click();
		//click.sendKeys(Keys.RETURN);
		
		/*Using JavaScript click it worked but we bypassed the actual reason which may be a potential bug or a bad UX design. 
		When we enter search keyword then google shows auto suggestions and HIDES THE SEARCH BUTTON. As per Official Selenium Doc – 
		ElementClickInterceptedException Indicates that a click could not be properly executed because the target element was obscured 
		in some way. This exception class extends ElementNotInteractableException class.*/


		WebElement ele = driver.findElement(By.xpath("//input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		//driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.nsg-button"))).click();
	//WebDriverWait wait = new WebDriverWait(driver,20);
//wait.until((ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));

/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//Wait wait = new FluentWait(driver)
.withTimeout(Duration.ofSeconds(10))
.pollingEvery(Duration.ofSeconds(10))
.ignoring(NoSuchElementException.class);*/
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	//Thread.sleep(3000);
		System.out.println("Test Completed Successfully");
		driver.close();
	}
}
