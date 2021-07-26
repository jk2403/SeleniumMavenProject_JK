package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SnapFish4 
{

	static String ChildwindowInstagram = "Login • Instagram";
	static String ChildwindowInstagram2 = "Select photos for importing.";
	static WebDriver driver = null;
	@SuppressWarnings("deprecation")
	static WebDriverWait wait = null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException 
	{
		String projectpath= System.getProperty("user.dir");
		//System.out.println("Project Path: "+projectpath);
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		 driver = new ChromeDriver();
		driver.get("https://us.sf-beta.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("EmailAddress")).sendKeys("Gmalotu");
		driver.findElement(By.id("Password")).sendKeys("Happy@444");
		driver.findElement(By.name("log in")).click();

		Thread.sleep(10000);
		driver.manage().addCookie(new Cookie("disableForseePopup", "false"));
		driver.findElement(By.xpath("//*[@id='globalHeaderSignInRegister']")).click();

		driver.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys("usbeta0410@yopmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("sfqatest");
		driver.findElement(By.xpath("//*[@id='login_submit']")).click();
		System.out.println("SnapFish Home Page title is: "+driver.getTitle());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='globalHeaderMyPhotos']")).click();
		Thread.sleep(5000);
		
		WebElement storyCaption = driver.findElement(By.xpath("//p[@class='storyCaption']"));
		if(storyCaption == null )
		{
			driver.findElement(By.xpath("//*[@id='guest-uploadphotssec']")).click();
		}
		else
		{
		driver.findElement(By.xpath("//Li[@class='icon-icon_upload_photo']")).click();
		}
		Thread.sleep(2000);

		WebElement Instagram = driver.findElement(By.xpath("//ul[@id='po-fdropdown']//li[@name='instagram_ingestion']//a[@aria-label='import photos from instagram, opens dialog']//span//span[@class='upload-link'][normalize-space()='Instagram']"));
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
		while (iterator.hasNext()) 
		{
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow))
			{
				driver.switchTo().window(ChildWindow);
				System.out.println("1st window page title is: "+driver.getTitle());
				System.out.println("1st ChildWindow name is: "+ChildWindow);
				Thread.sleep(5000);
				if( ChildwindowInstagram.equalsIgnoreCase(driver.getTitle()))
				{
					System.out.println("Entered to If Condition");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("snapfishtesting2999@gmail.com");
					System.out.println("Entered User Name Successfully in Instagram page");
					driver.findElement(By.name("password")).sendKeys("sfqatest12");
					System.out.println("Entered Password Successfully in Instagram page");
					driver.findElement(By.xpath("//*[@id='loginForm']/div/div[3]/button/div")).click();
					System.out.println("Submitted Click Successfully in Instagram page");
					Thread.sleep(5000);
					driver.findElement(By.cssSelector("button.sqdOP.yWX7d.y3zKF")).click();
					System.out.println("After click on Not Now Page Title is: "+driver.getTitle());
					System.out.println("Clicked Not Now");
					Thread.sleep(3000);
					driver.findElement(By.cssSelector("button.sqdOP.L3NKy.y3zKF.cB_4K")).click();
					System.out.println("Allow Clicked Successfully");
					System.out.println("After clicked allow page title is: "+driver.getTitle());
					Thread.sleep(3000);
					while (iterator.hasNext()) 
					{
						String ChildWindow1 = iterator.next();
						if (!mainWindowHandle.equalsIgnoreCase(ChildWindow1)) 
						{
							driver.switchTo().window(ChildWindow1);
							System.out.println("ChildWindow1 name is: "+ChildWindow1);
							System.out.println("Childwindow1 page title is: "+driver.getTitle());
							//Upload Images
							Thread.sleep(4000);
							Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(30))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);

							WebElement foo = wait2.until(new Function<WebDriver, WebElement>(){

								public WebElement apply(WebDriver driver) 
								{
									WebElement element = driver.findElement(By.id("assetSelection_17892725257996025"));
									if(element.isEnabled())
									{
										System.out.println("Element Found and Button element is "+element);
									}
									return element;
									//return driver.findElement(By.name("btnK"));
								} 
							});

							foo.click();
							//driver.findElement(By.xpath("//a[@aria-label='select entire album photos']")).click();
							//driver.findElement(By.id("assetSelection_17892725257996025")).click();
							System.out.println("Image 1 selected");
							driver.findElement(By.id("17878547843167308")).click();
							System.out.println("Image 2 selected");
							driver.findElement(By.xpath("//img[@name='17910303670697304']")).click();
							System.out.println("Image 3 selected");
							driver.findElement(By.id("18103559656236696")).click();
							System.out.println("Image 4 selected");
							Thread.sleep(4000);
							driver.findElement(By.xpath("//a[@class='import_ing ingestion_upload_btn_enabled import_ingestion']")).click();
							System.out.println("Uload Image Page title is:"+driver.getTitle());
							System.out.println("Uploaded images successfully");
							//driver.close(); // close child window
							Thread.sleep(15000);
						}
							
					}
			        // Switching to Parent window i.e Main Window.
		            driver.switchTo().window(mainWindowHandle);	
							System.out.println("Order Prints: "+driver.getTitle());
							//driver.switchTo().alert();
							String mainWindowHandle2 = driver.getWindowHandle();
							System.out.println("mainWindowHandle2 name is: "+mainWindowHandle2);
							Set<String> allWindowHandles2 = driver.getWindowHandles();
							System.out.println("allWindowHandles2 name is: "+allWindowHandles2);
							
							System.out.println("Order Prints1: "+driver.getTitle());

							driver.findElement(By.xpath("//a[@tracktext='Prints']//span[@class='link-btn']")).click();
							System.out.println("Order Prints CLicked Successfully");
							System.out.println("Order Prints2: "+driver.getTitle());
							// Switching to Parent window i.e Main Window.
							//String mainWindowHandle3 = driver.getWindowHandle();
							//System.out.println("mainWindowHandle3 name is: "+mainWindowHandle3);
				            //driver.switchTo().window(mainWindowHandle3);	
				            //System.out.println("Order Prints3: "+driver.getTitle());
							Thread.sleep(8000);

							
							//Qucik Order expanded
							
							//driver.findElement(By.xpath("//span[@id='quick-order-toggles' or @class='icon create-icon-right-dir']")).click();
							
							WebElement element2 = driver.findElement(By.xpath("//span[@id='quick-order-toggles' or @class='icon create-icon-right-dir']"));
							JavascriptExecutor executor = (JavascriptExecutor) driver;
							executor.executeScript("arguments[0].scrollIntoView()", element2);
							executor.executeScript("arguments[0].click();",element2);
							//Enter options to your entire order.
							driver.findElement(By.xpath("//input[@id='globalQty_4.0x6.0']")).clear();
							driver.findElement(By.xpath("//input[@id='globalQty_4.0x6.0']")).sendKeys("1");
							
							driver.findElement(By.xpath("//input[@id='globalQty_4.0x5.3']")).clear();
							driver.findElement(By.xpath("//input[@id='globalQty_4.0x5.3']")).sendKeys("1");

							driver.findElement(By.xpath("//input[@id='globalQty_5.0x7.0']")).clear();
							driver.findElement(By.xpath("//input[@id='globalQty_5.0x7.0']")).sendKeys("1");

							driver.findElement(By.xpath("//input[@id='globalQty_8.0x10.0']")).clear();
							driver.findElement(By.xpath("//input[@id='globalQty_8.0x10.0']")).sendKeys("1");

							driver.findElement(By.xpath("//input[@id='globalQty_4.0x4.0']")).clear();
							driver.findElement(By.xpath("//input[@id='globalQty_4.0x4.0']")).sendKeys("1");

							driver.findElement(By.xpath("//input[@id='globalQty_Wallet']")).clear();
							driver.findElement(By.xpath("//input[@id='globalQty_Wallet']")).sendKeys("1");

							driver.findElement(By.xpath("//input[@id='globalQty_8.0x8.0']")).clear();
							driver.findElement(By.xpath("//input[@id='globalQty_8.0x8.0']")).sendKeys("1");

							//Read Total Quantity and Price

String Quantity1 = driver.findElement(By.xpath("//span[@class='totalPrintsCount']")).getText();
System.out.println("Total Prints Count is: "+Quantity1);

String Price1 = driver.findElement(By.xpath("//span[@class='totalPrintsPrice']")).getText();
System.out.println("Total Prints Price is: "+Price1);

							//Edit Photo
							//driver.findElement(By.xpath("//body[1]/div[5]/div[1]/section[1]/div[2]/div[6]/ul[1]/li[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
							driver.findElement(By.linkText("Edit")).click();
							System.out.println("Click on Photo Edit successfully");
							Thread.sleep(8000);
							//WE should click on rotate button in another page
							driver.findElement(By.xpath("//*[@id='editOperations']/div[1]/div[1]/a[4]/figure")).click();  //to click on rotate button
							//driver.findElement(By.xpath("//body[1]/div[5]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/a[4]/figure[1]")).click();
							System.out.println("Click on Rotate icon successfully");
							Thread.sleep(5000);
							driver.findElement(By.xpath("//*[@id='rotate']/a[2]/figure")).click();
							System.out.println("Click on RIght Rotate image");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//*[@id='editOperations']/div[4]/a[3]")).click();//Done button click

							Thread.sleep(5000);

							//driver.findElement(By.xpath("//*[@id='finish_type_Matte']")).click();  // finish type matte selected
							
							driver.findElement(By.xpath("//label[@for='finish_type_Matte']")).click();
							
							
							
							driver.findElement(By.xpath("//button[@id='add-to-cart-butn']")).click();  //Proceed to cart button
							System.out.println("Click on Proceed to cart button successfully");
							Thread.sleep(15000);
							
							/*String NoThanks = driver.findElement(By.xpath("//button[@id='no-thanks' or @class='cancel button-secondary']")).getText();
							String mainWindowHandle21;
							System.out.println("No Thanks Popupn"+NoThanks);
							if(NoThanks==null)
							{
								mainWindowHandle21 = driver.getWindowHandle();
								driver.switchTo().window("mainWindowHandle21");
								Thread.sleep(2000);
								driver.findElement(By.xpath("//button[@id='no-thanks' or @class='cancel button-secondary']")).click();
							}
							else
							{
							System.out.println("NoThanks window popup appear and continue the below code");
							}*/
							//Check Add another set of prints
							WebElement element12 = driver.findElement(By.xpath("//input[@id='double_or_add_check_20738946060' or @type='checkbox']"));
							
							//wait = new WebDriverWait(driver, 60, 1000);
							//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='double_or_add_check_20738946060' or @type='checkbox']")));
							
							/*JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. JavaScriptExecutor provides two methods "executescript" 
							& "executeAsyncScript" to run javascript on the selected window or current page.*/
							//System.out.println("wait for WebDriverWait 60 seconds");
							 JavascriptExecutor js12 = (JavascriptExecutor) driver;
						        //This will scroll the page till the element is found		
						        js12.executeScript("arguments[0].scrollIntoView();", element12);
						        js12.executeScript("arguments[0].click();", element12);
							// element.click();
							 System.out.println("Able click Checkbox");
							 Thread.sleep(3000);
							String Quantity2 = driver.findElement(By.xpath("//th[@id='total_cart_items']")).getText();
							System.out.println("Total Prints Count is: "+Quantity2);

							String Price2 = driver.findElement(By.xpath("//td[@id='total_to_pay_now']")).getText();
							System.out.println("Total Prints Price is: "+Price2);
							
							if(Price1== Price2 && Quantity1==Quantity2)
							{
							System.out.println("compare the product price and quantity with persisted price value and quantity values");
							System.out.println("Both Price and Quantity are equal after selecting the Add another set of prints");
							}
							else
							{
								System.out.println("Both Price and Quantity are not equal after selecting the Add another set of prints");
							}
							Thread.sleep(6000);
							
							WebElement checkbox= driver.findElement(By.xpath("//*[@id='double_or_add_check_20738946060' or @type='checkbox']"));
							
							//JavascriptExecutor executor2 = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();", checkbox);
							//checkbox.click();
							System.out.println("Remove newly added extra prints set");
							
							//element.click();
							Thread.sleep(3000);
							//After uncheck capture the quantity and Price
							String Quantity3 = driver.findElement(By.xpath("//th[@id='total_cart_items']")).getText();
							System.out.println("Total Prints Count is: "+Quantity3);

							String Price3 = driver.findElement(By.xpath("//td[@id='total_to_pay_now']")).getText();
							System.out.println("Total Prints Price is: "+Price3);
							
							if(Price1== Price2 && Quantity1==Quantity2)
							{
							System.out.println("compare the product price and quantity with persisted price value and quantity values");
							System.out.println("Both Price and Quantity are equal after selecting the Add another set of prints");
							}
							else
							{
								System.out.println("Both Price and Quantity are not equal after selecting the Add another set of prints");
							}

							
							WebElement LowShipping = driver.findElement(By.xpath("//input[@id='Economy' or @value='Economy']"));
							JavascriptExecutor jse2 = (JavascriptExecutor)driver;
							jse2.executeScript("arguments[0].scrollIntoView()",LowShipping); 
							jse2.executeScript("arguments[0].click();", LowShipping);
							
							System.out.println("Select Low Shipping Method Successfully");
							
							WebElement RushShipping = driver.findElement(By.xpath("//input[@id='Overnight' or @value='Overnight']"));
							JavascriptExecutor jse3 = (JavascriptExecutor)driver;
							jse3.executeScript("arguments[0].scrollIntoView()", RushShipping);
							jse3.executeScript("arguments[0].click();", RushShipping);
							System.out.println("Select Rush Shipping Method Successfully");
							Thread.sleep(4000);
							//CheckOut
							WebElement CheckOut= driver.findElement(By.xpath("//a[@id='cart_checkout_top' or @class='primary-button button-padding']"));
							JavascriptExecutor jse4 = (JavascriptExecutor)driver;
							jse4.executeScript("arguments[0].scrollIntoView()", CheckOut); 
							jse4.executeScript("arguments[0].click();", CheckOut);
							
							Thread.sleep(8000);
							driver.findElement(By.xpath("//a[@id='change_payment_method_link' or @class='pushtop-2']")).click();
							
							System.out.println("Change Payment method sucessfully");
							
							driver.findElement(By.id("display_cc_edit_link")).click();
							System.out.println("Click on Edit link sucessfully");
							
							 int size0 = driver.findElements(By.tagName("iframe")).size();
							    System.out.println("Total Frames --" + size0);
							    
							    
							
							driver.findElement(By.xpath("//input[@name='b_ccholdername' or @id='b_ccholdername']")).clear();
							driver.findElement(By.xpath("//input[@name='b_ccholdername' or @id='b_ccholdername']")).sendKeys("Test");
							System.out.println("Enter CardHolder Name Successfully");
							 int size = driver.findElements(By.tagName("iframe")).size();
							    System.out.println("Total Frames --" + size);
							    
							driver.switchTo().frame("braintree-hosted-field-number");
							driver.findElement(By.xpath("//*[@id='credit-card-number' or @name='credit-card-number']")).sendKeys("4012000033330026");
											
							  driver.switchTo().defaultContent();
							  System.out.println("Switch to Default COntent1");
							  driver.switchTo().parentFrame();
							  System.out.println("Switch to Parent Frame1");
							  
							System.out.println("Enter Credit Card Number Successfully");
							//driver.switchTo().defaultContent();
							 int size1 = driver.findElements(By.tagName("iframe")).size();
							    System.out.println("Total Frames --" + size1);
							    
							 List<WebElement> frames=  driver.findElements(By.tagName("iframe"));
							  System.out.println("frames List is: "+frames);
							  try {
								  driver.switchTo().defaultContent();
								  System.out.println("Switch to Default COntent");
								  driver.switchTo().parentFrame();
								  System.out.println("Switch to Parent Frame");
								  driver.switchTo().frame("braintree-hosted-field-expirationDate");
								  System.out.println("Switch to child frame");
							  }
							  catch(Exception e)
							  {
								  e.printStackTrace();
								  System.out.println("Exception is: "+e);
							  }
							  
							    //driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='exp_month_field']//iframe[1]")));
							    WebElement frameElement = driver.findElement(By.xpath("//input[@id='expiration' or @name='expiration']"));
							    System.out.println("Frame Element is: "+frameElement);

							  //  driver.switchTo().frame(frameElement);
							    frameElement.sendKeys("072021");
							    
							/*for(int i=0;i<=size;i++)
							{
								if(driver.switchTo().frame(i)==driver.switchTo().frame("braintree-hosted-field-expirationDate"))
								{
								driver.switchTo().frame(i);
								driver.findElement(By.xpath("//input[@id='expiration' or @name='expiration']")).sendKeys("07 / 2021");
								count++;
								}
								else
								{
									System.out.println("Frame not exist: "+count);
								}
							}*/
							//driver.switchTo().frame("braintree-hosted-field-expirationDate");
							//driver.switchTo().frame(0);
						/*WebElement FrameHeading1=	driver.findElement(By.xpath("//input[@id='expiration' or @name='expiration']"));
						String FrameText1 = FrameHeading1.getText();
						System.out.println("Expiration field frame is: "+FrameText1);
						FrameHeading1.sendKeys("07 / 2021");*/
							System.out.println("Enter Month/YYYY Successfully");
							driver.switchTo().parentFrame();
							driver.switchTo().frame("braintree-hosted-field-cvv");
							
							driver.findElement(By.xpath("//input[@id='cvv' or @name='cvv']")).sendKeys("132");
							System.out.println("Enter CVV Number Successfully");
							 int size2 = driver.findElements(By.tagName("iframe")).size();
							    System.out.println("Total Frames --" + size2);
							    
							    driver.switchTo().parentFrame();
							WebElement PlaceOrder= driver.findElement(By.xpath("//div[@class='span7 pushright hide-mobile pushtop-2 pushdown-2']//a[@id='buynow_top']"));
							    //WebElement PlaceOrder= driver.findElement(By.linkText("Place order"));
							  /*  JavascriptExecutor jse5 = (JavascriptExecutor)driver;
							jse5.executeScript("arguments[0].scrollIntoView()", PlaceOrder);
							jse5.executeAsyncScript("arguments[0].click();", PlaceOrder);*/
							PlaceOrder.click();
							System.out.println("Enter Place Order Successfully");
							System.out.println("After the payment page title is: "+driver.getTitle());
							
							String Receipt = driver.findElement(By.xpath("//*[@id='page_heading' or @class='sub-heading1']")).getText();
									System.out.println(Receipt);
							//driver.close();

							System.out.println("Test Completed Successfully");
						}
				}
			}
			

			//Final Code
			Thread.sleep(3000);
			

		//	driver.close();
			//driver.quit();


		}


	}