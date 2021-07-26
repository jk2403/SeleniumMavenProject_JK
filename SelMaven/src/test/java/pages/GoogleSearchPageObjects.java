package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPageObjects {
	
	 WebDriver driver = null;
	By text_searchbox = By.name("q");
	By button_search = By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void setTextSearchBox(String text)
	{
		driver.findElement(text_searchbox).sendKeys(text);
	}

	public void clickButtonSearch()
	{
		WebElement ele = driver.findElement(button_search);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		//driver.findElement(button_search).sendKeys(Keys.RETURN);
	}
}
