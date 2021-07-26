package listeners;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
//@Listeners(listeners.TestNGListeneres.class)
public class TestNGListenerDemo2 {

@Test	
public void test4()
{
	System.out.println("I am inside Test4");
	String projectpath= System.getProperty("user.dir");
	System.out.println("Project Path: "+projectpath);
	System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.co.in/");
	driver.manage().window().maximize();
	System.out.println("Title of the page is: "+driver.getTitle());
	WebElement searchbox = driver.findElement(By.name("q"));
	driver.close();
}
@Test
public void test5()
{
	System.out.println("I am inside Test5");
	//Assert.assertTrue(false);
}
@Test
public void test6()
{
	System.out.println("I am inside Test6");
	//throw new SkipException("This Test is Skipped Successfully");
}
}
