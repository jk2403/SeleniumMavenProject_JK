package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAutoIT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\Drivers\\ChromeDriver\\chromedriver4.exe");
		WebDriver driver = new ChromeDriver();

		
		driver.get("http://demo.guru99.com/test/autoit.html");
		driver.manage().window().maximize();
		System.out.println("Application launched successfully");
		Thread.sleep(2000);
	
		
		driver.switchTo().frame("JotFormIFrame-72320244964454");
		WebElement upload= driver.findElement(By.xpath("//input[@type='file' or @name='input_5']"));
		
		JavascriptExecutor jse4 = (JavascriptExecutor)driver;
		jse4.executeScript("window.scrollBy(0,480)");//Scroll Down to file upload button (+ve)
		   Thread.sleep(3000);
		   driver.findElement(By.id("input_3")).sendKeys("JayaKumar");
		   driver.findElement(By.id("input_4")).sendKeys("jayakumar123@gmail.com");
		   		
		jse4.executeScript("arguments[0].scrollIntoView()", upload); 
		jse4.executeScript("arguments[0].click();", upload);
		
		Runtime.getRuntime().exec("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\ChooseFile.exe");
		driver.findElement(By.id("input_6")).sendKeys("testjk test jk");
		Thread.sleep(5000);
		driver.findElement(By.id("input_2")).click();
		//driver.quit();
		//Thread.sleep(5000);
		System.out.println("Test Completed Successfully");
	}

}
