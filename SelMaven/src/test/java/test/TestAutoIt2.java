package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAutoIt2 {

	static WebDriver driver=null;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\Drivers\\ChromeDriver\\chromedriver4.exe");
		
		driver=new ChromeDriver();
		driver.get("https://www.monsterindia.com/seeker/registration");
		driver.manage().window().maximize();
		
		WebElement choosepath= driver.findElement(By.xpath("//span[@class='browse-text']"));
		choosepath.click();
		

		
		Runtime.getRuntime().exec("C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\ChoosePath.exe");
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Test Completed Successfully");
		
	}

}
