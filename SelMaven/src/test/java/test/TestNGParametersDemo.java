package test;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

public class TestNGParametersDemo {
	
	@Test
	@Parameters({"MyName"})
	public void test(@Optional("Geethu") String name)
	{
		System.out.println("Test Name1 is : "+name);
	}

	@Test
	@Parameters({"MyName"})
	public void test2(@Optional("Geethu") String name)
	{
		System.out.println("Test Name2 is : "+name);
	}
	
	@Test
	@Parameters({"MyName3"})
	public void test3(@Optional("Geethu") String name)
	{
		System.out.println("Test Name3 is : "+name);
	}
}
