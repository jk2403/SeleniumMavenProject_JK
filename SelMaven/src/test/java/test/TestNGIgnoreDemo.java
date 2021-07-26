package test;
import org.testng.annotations.Test;
import org.testng.annotations.Ignore;

//@Ignore
public class TestNGIgnoreDemo {

	@Test
	public void test1()
	{
		System.out.println("I am Insie Test1");
	}
	@Ignore
	@Test
	public void test2()
	{
		System.out.println("I am Insie Test2");
	}
}
