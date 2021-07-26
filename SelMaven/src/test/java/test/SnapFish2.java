package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class SnapFish2 {

	static String ChildwindowInstagram = "Login • Instagram";
	public static void main(String[] args) throws InterruptedException {
		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.snapfish.com");
		driver.manage().window().maximize();
		System.out.println("Snapfish Application Launch Title page is: "+driver.getTitle());
		//Thread.sleep(3000);
		driver.findElement(By.id("globalHeaderMyPhotos")).click();
		System.out.println("My Photos title page is: "+driver.getTitle());
		driver.findElement(By.name("EmailAddress")).sendKeys("snapfish.testorders111+223@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("sfqatest");
		driver.findElement(By.id("login_submit")).click();
		System.out.println("SnapFish Home Page title is: "+driver.getTitle());
		Thread.sleep(5000);
		
		WebElement UploadPhotos= driver.findElement(By.xpath("//li[@class='icon-icon_upload_photo']"));
		System.out.println("UploadPhotos Text is: "+UploadPhotos.getText());
		UploadPhotos.click();
		System.out.println("Successfully click on 'Upload Photos' menu");
		Thread.sleep(2000);
		WebElement Instagram = driver.findElement(By.xpath("//body[1]/ul[1]/li[5]/a[1]/span[1]/span[3]"));
		Instagram.click();
		System.out.println("Successfully click on Instagram option from 'Upload Photos' menu");

		Thread.sleep(2000);

		//Get the main window name by using getWindowhandle
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("mainWindowHandle name is: "+mainWindowHandle);
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("allWindowHandles name is: "+allWindowHandles);
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check the each child windows and will fetch the heading of the child window
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println("1st window page title is: "+driver.getTitle());
				System.out.println("1st ChildWindow name is: "+ChildWindow);
				Thread.sleep(3000);
				if( ChildwindowInstagram.equalsIgnoreCase(driver.getTitle()))
				{
					System.out.println("Entered to If Condition");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("JayaKumar");
					System.out.println("Entered User Name Successfully in Instagram page");
					driver.findElement(By.name("password")).sendKeys("JayaKumarRayala");
					System.out.println("Entered Password Successfully in Instagram page");

					driver.findElement(By.xpath("//div[contains(text(),'Log In')]")).click();
					System.out.println("Submitted Click Successfully in Instagram page");
				}

				else
				{
					System.out.println("If block skips and else block executed");
				}

				break; //It breaks, after switch to Instagram Childwindow.
			}
		}
		System.out.println("Test Completed Successfully");

		//driver.close();
		//driver.quit();

	}

}
