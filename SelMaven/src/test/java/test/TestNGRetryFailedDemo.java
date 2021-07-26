package test;
import org.junit.Assert;
import org.testng.annotations.*;

public class TestNGRetryFailedDemo {

	@Test
	public void test1()
	{
		System.out.println("I am inside test1");
	}
	@Test
	public void test2()
	{
		System.out.println("I am inside test2");
		//int i=1/0;
	}
	@Test(retryAnalyzer = listeners.TestNGRetryListener.class)
	public void test3()
	{
		System.out.println("I am inside test3");
		//Assert.assertTrue(false);
	}
}
