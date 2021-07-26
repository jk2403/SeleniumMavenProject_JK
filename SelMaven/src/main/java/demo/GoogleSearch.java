package demo;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {

	static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {

		test();
	}

	public static void test() throws InterruptedException {
		System.out.println("Project Path is: " + projectPath);
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\jrayala\\OneDrive -
		// Infor\\Desktop\\Java\\SelMaven\\Drivers\\ChromeDriver\\chromedriver3.exe");
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
		//ele.sendKeys("");
		System.out.println("element text is: " + ele.getAttribute("name"));
		//@SuppressWarnings("deprecation")
		WebDriverWait wait2 = new WebDriverWait(driver, 10, 1000);



		Boolean searchbutton0= ele.isEnabled();
		System.out.println("SearchButton is Enabled: "+searchbutton0);

		Boolean searchbutton1= ele.isDisplayed();
		System.out.println("SearchButton is Displayed: "+searchbutton1);

		Boolean searchbutton2= ele.isSelected();
		System.out.println("SearchButton is Selected: "+searchbutton2);

		Boolean searchbutton = wait2.until(ExpectedConditions.invisibilityOf(ele));
		System.out.println("SearchButton InVisibility is: "+searchbutton);

		WebElement searchelement3 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));

		/*WebElement FirstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(ele));*/
		
		System.out.println("Search Element is present: "+searchelement3);

		System.out.println("Before Click");

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.


		//  Wait<WebDriver> wait2 = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class); 
		// wait2.until(ExpectedConditions.visibilityOf(ele));


		//click on the selenium link clickseleniumlink.click();


		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click();", ele);
		//JavascriptExecutor executor = 	((JavascriptExecutor)driver);
		//executor.executeScript("arguments[0].focus();", ele);
		
		
		  if(ele.equals(driver.switchTo().activeElement()))
		         System.out.println("Element is focused");
		      else
		         System.out.println("Element is not focused");
		
		// Actions build = new Actions(driver); // heare you state ActionBuider
		 //build.moveToElement(ele).click(ele); // Here you perform hover mouseover the needed elemnt to triger the visibility of the hidden 
		 //build.perform();
		  
		 // JavascriptExecutor executor = (JavascriptExecutor)driver;
		  //executor.executeScript("document.getElementByXPath('//input[@name='btnK']').style.display='block';");

	

		System.out.println("After Click");
Thread.sleep(4000);
		driver.close();
		System.out.println("Test Completed Successfully");
	}
	
}
