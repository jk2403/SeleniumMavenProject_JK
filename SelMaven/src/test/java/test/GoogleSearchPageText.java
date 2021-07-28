package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageText {

	private static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GoogleSearchPageObjects searchobj = new GoogleSearchPageObjects(driver);
		googleSearchText();
	}
	private static void googleSearchText() {
		// TODO Auto-generated method stub
		String projectpath= System.getProperty("user.dir");
		System.out.println("Project Path is: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver4.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		System.out.println("Title of the google page is "+driver.getTitle());
		
		GoogleSearchPageObjects searchobj = new GoogleSearchPageObjects(driver);
		searchobj.setTextSearchBox("JayaKumar Rayala");
		System.out.println("Entered text in Search Box successfully");
		searchobj.clickButtonSearch();
		System.out.println("Title of the page is "+driver.getTitle());
		System.out.println("Test Completed Successfully");
		
 try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.quit();
	}

}
