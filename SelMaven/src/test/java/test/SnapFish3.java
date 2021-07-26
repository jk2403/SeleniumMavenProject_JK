package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapFish3 {

	static String ChildwindowInstagram = "Login • Instagram";
	static String ChildwindowInstagram2 = "Select photos for importing."; 
	
	public static void main(String[] args) throws InterruptedException {
		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://us.sf-beta.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("EmailAddress")).sendKeys("Gmalotu");
		driver.findElement(By.id("Password")).sendKeys("Happy@444");
		driver.findElement(By.name("log in")).click();
		//System.out.println("Snapfish Application Launch Title page is: "+driver.getTitle());
		Thread.sleep(10000);
		//driver.manage().addCookie(new Cookie("disableForseePopup", "false")); 
		driver.findElement(By.xpath("//*[@id='globalHeaderSignInRegister']")).click();
		//driver.findElement(By.id("globalHeaderMyPhotos")).click();
		//System.out.println("My Photos title page is: "+driver.getTitle());
		driver.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys("usbeta0410@yopmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("sfqatest");
		driver.findElement(By.xpath("//*[@id='login_submit']")).click();
		System.out.println("SnapFish Home Page title is: "+driver.getTitle());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='globalHeaderMyPhotos']")).click();
		Thread.sleep(10000);

		WebElement storyCaption = driver.findElement(By.xpath("//p[@class='storyCaption']"));
		if(storyCaption == null )
		{
			driver.findElement(By.xpath("//*[@id='guest-uploadphotssec']")).click();
			/*WebElement UploadPhotos= driver.findElement(By.xpath("//li[@class='icon-icon_upload_photo']"));
System.out.println("UploadPhotos Text is: "+UploadPhotos.getText());
UploadPhotos.click();
System.out.println("Successfully click on 'Upload Photos' menu");*/
			Thread.sleep(2000);
			//driver.switchTo().frame("qualaroo_dnt_frame");
			WebElement Instagram = driver.findElement(By.xpath("//ul[@id='po-fdropdown']//li[@name='instagram_ingestion']//a[@aria-label='import photos from instagram, opens dialog']//span//span[@class='upload-link'][normalize-space()='Instagram']"));

			//WebElement Instagram = driver.findElement(By.xpath("//span[@class='menuicon instagram-data-icon instagram-ic']"));
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
						driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("snapfishtesting2999@gmail.com");
						System.out.println("Entered User Name Successfully in Instagram page");
						driver.findElement(By.name("password")).sendKeys("sfqatest12");
						System.out.println("Entered Password Successfully in Instagram page");
						System.out.println("Before Submitted Instagram: "+driver.getTitle());
						driver.findElement(By.xpath("//div[contains(text(),'Log In')]")).click();
						System.out.println("Submitted Click Successfully in Instagram page");
						Thread.sleep(3000);
						System.out.println("Before click on Not Now: "+driver.getTitle());

						//Thread.sleep(3000);
						//driver.findElement(By.xpath("//body[1]/div[2]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
						//driver.findElement(By.linkText("Not Now")).click();
						//driver.findElement(By.xpath("//button[]"))
						driver.findElement(By.cssSelector("button.sqdOP.yWX7d.y3zKF")).click();
						//driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
						System.out.println("After click on Not Now: "+driver.getTitle());
						System.out.println("Clicked Not Now");
						Thread.sleep(3000);

						//driver.findElement(By.xpath("//body[1]/div[2]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/button[1]")).click();
						//driver.findElement(By.cssSelector("button.sqdOP.L3NKy.y3zKF.cB_4K")).click();
						driver.findElement(By.cssSelector("section._9eogI.E3X2T main.SCxLW.o64aR:nth-child(2) div.bS3Ax div.cJvag div.oLBan div.dqGwD div.yijoQ div.Igw0E.IwRSH.YBx95.ybXk5._4EzTm div.eqjGP:nth-child(2) > button.sqdOP.L3NKy.y3zKF.cB_4K")).click();
						//driver.findElement(By.xpath("//button[contains(text(),'Allow')]")).click();
						System.out.println("Allow Clicked Successfully");
						
						driver.findElement(By.name("17892725257996025")).click();
						System.out.println("Image 1 selected");
						driver.findElement(By.id("17878547843167308")).click();
						System.out.println("Image 2 selected");
						driver.findElement(By.xpath("//img[@name='17910303670697304']")).click();
						System.out.println("Image 3 selected");
						driver.findElement(By.id("18103559656236696")).click();
						System.out.println("Image 4 selected");

						String mainWindowHandle2 = driver.getWindowHandle();
						System.out.println("mainWindowHandle2 name is: "+mainWindowHandle2);

						driver.findElement(By.xpath("//a[@class='import_ing ingestion_upload_btn_enabled import_ingestion']")).click();

						Thread.sleep(10000);
						String mainWindowHandle3 = driver.getWindowHandle();
						System.out.println("mainWindowHandle3 name is: "+mainWindowHandle3);

						driver.findElement(By.xpath("//span[@class='link-btn']//span[contains(text(),'Order Prints')]")).click();

						String mainWindowHandle4 = driver.getWindowHandle();
						System.out.println("mainWindowHandle4 name is: "+mainWindowHandle4);
						
					}

					else
					{
						System.out.println("If block skips and else block executed");
					}

					break; //It breaks, after switch to Instagram Childwindow.
				}

			}
		}
		else
		{
			WebElement UploadPhotos= driver.findElement(By.xpath("//li[@class='icon-icon_upload_photo']"));
			System.out.println("UploadPhotos Text is: "+UploadPhotos.getText());
			UploadPhotos.click();
			System.out.println("Successfully click on 'Upload Photos' menu");
			Thread.sleep(2000);
			WebElement Instagram = driver.findElement(By.xpath("//body[1]/ul[1]/li[5]/a[1]/span[1]/span[3]"));
			Instagram.click();
			System.out.println("Successfully click on Instagram option from 'Upload Photos' menu");

			Thread.sleep(2000);
			String mainWindowHandle = driver.getWindowHandle();
			System.out.println("mainWindowHandle name is: "+mainWindowHandle);
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("allWindowHandles name is: "+allWindowHandles);
			Iterator<String> iterator = allWindowHandles.iterator();

			// Here we will check the each child windows and will fetch the heading of the child window
			while (iterator.hasNext()) 
			{
				String ChildWindow = iterator.next();
				if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
				{
					driver.switchTo().window(ChildWindow);
					System.out.println("1st window page title is: "+driver.getTitle());
					System.out.println("1st ChildWindow name is: "+ChildWindow);
					Thread.sleep(3000);
					if( ChildwindowInstagram.equalsIgnoreCase(driver.getTitle()))
					{
						System.out.println("Entered to If Condition");
						Thread.sleep(3000);
						driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("snapfishtesting2999@gmail.com");
						System.out.println("Entered User Name Successfully in Instagram page");
						driver.findElement(By.name("password")).sendKeys("sfqatest12");
						System.out.println("Entered Password Successfully in Instagram page");
						System.out.println("Before Submitted Instagram: "+driver.getTitle());
						driver.findElement(By.xpath("//div[contains(text(),'Log In')]")).click();
						System.out.println("Submitted Click Successfully in Instagram page");
						Thread.sleep(3000);
						System.out.println("Before click on Not Now: "+driver.getTitle());

						//Thread.sleep(3000);
						//driver.findElement(By.xpath("//body[1]/div[2]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
						//driver.findElement(By.linkText("Not Now")).click();
						//driver.findElement(By.xpath("//button[]"))
						driver.findElement(By.cssSelector("button.sqdOP.yWX7d.y3zKF")).click();
						//driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
						System.out.println("After click on Not Now: "+driver.getTitle());
						System.out.println("Clicked Not Now");
						Thread.sleep(3000);

						//driver.findElement(By.xpath("//body[1]/div[2]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/button[1]")).click();
						//driver.findElement(By.cssSelector("button.sqdOP.L3NKy.y3zKF.cB_4K")).click();
						driver.findElement(By.cssSelector("section._9eogI.E3X2T main.SCxLW.o64aR:nth-child(2) div.bS3Ax div.cJvag div.oLBan div.dqGwD div.yijoQ div.Igw0E.IwRSH.YBx95.ybXk5._4EzTm div.eqjGP:nth-child(2) > button.sqdOP.L3NKy.y3zKF.cB_4K")).click();
						//driver.findElement(By.xpath("//button[contains(text(),'Allow')]")).click();
						System.out.println("Allow Clicked Successfully");
						
						// It will return the parent window name as a String
						String parent=driver.getWindowHandle();
						 
						// This will return the number of windows opened by Webdriver and will return Set of St//rings
						Set<String>s1=driver.getWindowHandles();
						 
						// Now we will iterate using Iterator
						Iterator<String> I1= s1.iterator();
						 
						while(I1.hasNext())
						{
						 
						   String child_window=I1.next();
						 
						// Here we will compare if parent window is not equal to child window then we            will close
						 
						if(!parent.equals(child_window))
						{
						driver.switchTo().window(child_window);
						 
						System.out.println("Child WIndow Name is: "+child_window);
						System.out.println("Child WIndow title is: "+driver.switchTo().window(child_window).getTitle());
						if( ChildwindowInstagram2.equalsIgnoreCase(driver.getTitle()))
						{
						
							System.out.println("Child window  macthing with the ChildwindowInstagram2 title");
				//driver.findElement(By.xpath("//div[@id='assetSelection_17892725257996025']")).click();
				System.out.println("Image 1 selected");
				//driver.findElement(By.id("assetSelection_17878547843167308")).click();
				driver.findElement(By.cssSelector("#assetSelection_17878547843167308")).click();
				System.out.println("Image 2 selected");
				driver.findElement(By.id("assetSelection_17910303670697304']")).click();
				System.out.println("Image 3 selected");
				driver.findElement(By.id("18103559656236696")).click();
				System.out.println("Image 4 selected");

						driver.close();
						}
						else
						{
							System.out.println("Child window not macthing with ChildwindowInstagram2 title");
						}
						}	 
						}
						
						/*String mainWindowHandle1 = driver.getWindowHandle();
						System.out.println("mainWindowHandle1 name is: "+mainWindowHandle1);
						Set<String> allWindowHandles2 = driver.getWindowHandles();
						System.out.println("allWindowHandles2 name is: "+allWindowHandles2);
						Iterator<String> iterator2 = allWindowHandles2.iterator();
						while (iterator2.hasNext()) 
						{
							String ChildWindow2 = iterator2.next();
							if (!mainWindowHandle.equalsIgnoreCase(ChildWindow2)) 
							{
								driver.switchTo().window(ChildWindow2);
								System.out.println("1st window page title is: "+driver.getTitle());
								System.out.println("1st ChildWindow name is: "+ChildWindow2);
								driver.close();
								
							}*/
								Thread.sleep(3000);
								/*if( ChildwindowInstagram2.equalsIgnoreCase(driver.getTitle()))
								{
								
						//System.out.println("uPload photos selection is: "+driver.getTitle());
					//driver.findElement(By.name("17892725257996025")).click(); ingestionImg lazy imageAbvLmt
						driver.findElement(By.xpath("//div[@id='assetSelection_17892725257996025']")).click();
						System.out.println("Image 1 selected");
						//driver.findElement(By.id("assetSelection_17878547843167308")).click();
						driver.findElement(By.cssSelector("#assetSelection_17878547843167308")).click();
						System.out.println("Image 2 selected");
						driver.findElement(By.id("assetSelection_17910303670697304']")).click();
						System.out.println("Image 3 selected");
						driver.findElement(By.id("18103559656236696")).click();
						System.out.println("Image 4 selected");

						String mainWindowHandle2 = driver.getWindowHandle();
						System.out.println("mainWindowHandle2 name is: "+mainWindowHandle2);

						driver.findElement(By.xpath("//a[@class='import_ing ingestion_upload_btn_enabled import_ingestion']")).click();

						Thread.sleep(10000);
						String mainWindowHandle3 = driver.getWindowHandle();
						System.out.println("mainWindowHandle3 name is: "+mainWindowHandle3);

						driver.findElement(By.xpath("//span[@class='link-btn']//span[contains(text(),'Order Prints')]")).click();

						String mainWindowHandle4 = driver.getWindowHandle();
						System.out.println("mainWindowHandle4 name is: "+mainWindowHandle4);*/
								}
							//}
						//}
					}
					System.out.println("Test Completed Successfully");

					//driver.close();
					//driver.quit();
				}

			}
		}
	}



