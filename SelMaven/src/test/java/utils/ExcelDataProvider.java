package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.EnterCredentials;

public class ExcelDataProvider {
WebDriver driver;
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * String excelPath =
	 * "C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\excel\\data.xlsx"
	 * ; testData(excelPath, "sheet1"); }
	 */
	@BeforeTest
	public void setUpTest()
	{
		String projectpath= System.getProperty("user.dir");
		//System.out.println("Project Path: "+projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"//Drivers//ChromeDriver//chromedriver3.exe");
		driver = new ChromeDriver();
		System.out.println("setUpTest executed successfully");
	}
	@Test(dataProvider="testdata")
	public void test1(String username, String password)
	{
		System.out.println(username+ " | "+password);
		
		driver.get("http://localhost:1080/WebTours/index.htm");
		 driver.manage().window().maximize();
		 System.out.println("Title of the login page is "+driver.getTitle());
		 EnterCredentials.switchFrame(driver);
		 EnterCredentials.textbox_username(driver).sendKeys(username);
		 EnterCredentials.textbox_password(driver).sendKeys(password);
		 System.out.println("Entered Credentials Successfully");
		 
		 EnterCredentials.button_login(driver).sendKeys(Keys.RETURN);
		 System.out.println("Title of the home page is "+driver.getTitle());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@DataProvider(name="testdata")
	public Object[][] getData()
	{
		String excelPath = "C:\\Users\\jrayala\\OneDrive - Infor\\Desktop\\Java\\SelMaven\\excel\\data.xlsx";
		Object data[][]= testData(excelPath, "sheet1");	
		return data;
	}
	public  Object[][] testData(String excelPath, String sheetName) {
		// TODO Auto-generated method stub
		ExcelUtilsFunction excel = new ExcelUtilsFunction(excelPath, sheetName);
		int rowcount = excel.getRowCount();
		int cellcount= ExcelUtilsFunction.getColCount();
		
		Object data[][] = new Object[rowcount-1][cellcount];
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				String celldata= excel.getStringCellData(i, j);
				//System.out.print(celldata+ " | ");
				data[i-1][j] =celldata;
			}
			//System.out.println();
		}
		return data;
	}
	
@AfterTest
public void tearDown()
{
	 driver.close();
	 System.out.println("Test Completed Successfully");
}
}
