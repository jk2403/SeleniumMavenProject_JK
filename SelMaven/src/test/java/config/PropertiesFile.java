package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String projectpath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
getProperties();
setProperties();
getProperties();
	}
	public static void getProperties()
	{
		try {
			Properties prop = new Properties();
			String projectpath = System.getProperty("user.dir");
			System.out.println(projectpath);
			InputStream input = new FileInputStream(projectpath+"\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			PropertiesDemo.browserName= browser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Message is : "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		} 
	}
	public static void setProperties()
	{
		try {
		OutputStream output = new FileOutputStream(projectpath+"\\src\\test\\java\\config\\config.properties");
		prop.setProperty("browser", "chrome");
		prop.setProperty("result", "passed");
		//prop.
		prop.store(output, null);
		}
		catch(Exception e)
		{
			System.out.println("message is : "+e.getMessage());
			System.out.println("cause is: "+e.getCause());
			e.printStackTrace();
		}
	}

}
