package demo;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchDemo {

	static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");
	public static void main(String[] args) {
		System.out.println("Main Method starts");
		try {
			test();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Method ends");
	}

	public static void test() throws InterruptedException
	{

		System.out.println("Project Path is: "+projectPath);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\Drivers\\ChromeDriver\\chromedriver3.exe");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver3.exe");
		driver = new ChromeDriver();


		//driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // -- Implicitly Wait for entire browser session
		driver.get("https://www.google.co.in");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		
		driver.findElement(By.name("q")).sendKeys("Jayakumar586@gmail.com"); 
		//Thread.sleep(2000);
		//driver.findElement(By.name("btnK")).click();

		//driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

		
		WebElement ele = driver.findElement(By.name("btnK"));
		//wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.name("btnK"))));
	
		System.out.println("Before Click");
		
		
		//WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		// Print the first result
		//System.out.println(ele.getText());

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", driver.findElement(By.name("btnK")));
		executor.executeScript("arguments[0].click();", ele);
		System.out.println("After Click");

		driver.close();
	}
}
