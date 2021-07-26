package test;
import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})
public class TestNGGroupsDemo {

	@Test(groups= {"sanity","regression"})
	public void test1()
	{
		System.out.println("I am inside test1");
	}
	@Test(groups= {"windows.regression"})
	public void test2()
	{
		System.out.println("I am inside test2");
	}
	@Test(groups= {"linux.regression"})
	public void test3()
	{
		System.out.println("I am inside test3");
	}
	@Test(groups= {"smoke"})
	public void test4()
	{
		System.out.println("I am inside test4");
	}
	@Test
	public void test5()
	{
		System.out.println("I am inside test5");
	}
}
