package demo;

import java.time.Duration;
import java.util.NoSuchElementException;
//import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class GoogleSearch1 {

	static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {

		test();
	}

	public static void test() throws InterruptedException {
		System.out.println("Project Path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\Drivers\\ChromeDriver\\chromedriver3.exe");
		driver = new ChromeDriver();

		driver.get("https://www.google.co.in");

		WebElement ele2 = driver.findElement(By.name("q"));

		WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		System.out.println(ele2.getText());
		ele2.sendKeys("Jayakumar586@gmail.com");
		// System.out.println(ele2.getText());

		// driver.findElement(By.name("btnK")).click();

		// driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

		WebElement ele = driver.findElement(By.name("btnK"));

		Boolean searchbutton0= ele.isEnabled();
		System.out.println("SearchButton is Enabled: "+searchbutton0);

		Boolean searchbutton1= ele.isDisplayed();
		System.out.println("SearchButton is Displayed: "+searchbutton1);

		Boolean searchbutton2= ele.isSelected();
		System.out.println("SearchButton is Selected: "+searchbutton2);

		Boolean searchbutton = wait.until(ExpectedConditions.invisibilityOf(ele));
		System.out.println("SearchButton InVisibility is: "+searchbutton);

		WebElement searchelement3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));

		if(ele.equals(driver.switchTo().activeElement()))
			System.out.println("Element is focused");
		else
			System.out.println("Element is not focused");

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait2.until(new Function<WebDriver, WebElement>(){

			public WebElement apply(WebDriver driver) 
			{
				WebElement element = driver.findElement(By.name("btnK"));
				if(element.isEnabled())
				{
					System.out.println("Element Found and Button element is "+element);
				}
				return element;
				//return driver.findElement(By.name("btnK"));
			} 
		});


		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",foo);

		driver.close();
		System.out.println("Test Completed Successfully");
	}

}
