package listeners;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
//@Listeners(listeners.TestNGListeneres.class)
public class TestNGListenerDemo {

@Test	
public void test1()
{
	System.out.println("I am inside Test1");
}
@Test
public void test2()
{
	System.out.println("I am inside Test2");
	String projectpath= System.getProperty("user.dir");
	System.out.println("Project Path is: "+projectpath);
	System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://localhost:1080/WebTours/index.htm");
	 driver.manage().window().maximize();
	 System.out.println("Title of the login page is "+driver.getTitle());
	 driver.close();
	 
}
@Test
public void test3()
{
	System.out.println("I am inside Test3");
	throw new SkipException("This Test is Skipped Successfully");
}
}
