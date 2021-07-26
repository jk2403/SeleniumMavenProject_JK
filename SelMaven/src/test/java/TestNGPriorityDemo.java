import org.testng.annotations.Test;

public class TestNGPriorityDemo {
	
	@Test
	public static void one()
	{
		System.out.println("I am inside test1");
	}
	@Test(priority=-1)
	public static void two()
	{
		System.out.println("I am inside test2");
	}
	@Test(priority=2)
	public static void three()
	{
		System.out.println("I am inside test3");
	}

}
