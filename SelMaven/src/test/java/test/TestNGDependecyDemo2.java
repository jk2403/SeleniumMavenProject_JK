package test;
import org.testng.annotations.Test;

public class TestNGDependecyDemo2 {
	
	@Test(dependsOnGroups = {"sanity.*"})
	public void test()
	{
		System.out.println("I am inside test1");
	}

	@Test(groups= {"sanity1"})
	public void test2()
	{
		System.out.println("I am inside test2");
	}
	
	@Test(groups= {"sanity2"})
	public void test3()
	{
		System.out.println("I am inside test3");
	}
}
