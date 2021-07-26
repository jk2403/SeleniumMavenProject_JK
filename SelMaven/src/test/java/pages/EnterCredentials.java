package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterCredentials {

	private static WebElement element=null;
	
	public static void switchFrame(WebDriver driver)
	{
		driver.switchTo().frame("body");
		driver.switchTo().frame("navbar");
	}
	
	public static WebElement textbox_username(WebDriver driver)
	{
		
		element = driver.findElement(By.name("username"));
		return element;
		
	}
	
	public static WebElement textbox_password(WebDriver driver)
	{
		 element = driver.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement button_login(WebDriver driver)
	{
		element = driver.findElement(By.name("login"));
		return element;
	}
}
