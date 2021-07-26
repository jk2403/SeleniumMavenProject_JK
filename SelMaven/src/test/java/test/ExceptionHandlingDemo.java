package test;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		System.out.println("Exception Handling Demo");
		int i =1/0;
		System.out.println("Test ENd");
		}
		catch(ArithmeticException exp)
		{
			System.out.println("I am inside catch block");
			System.out.println("Exception Message is: "+exp.getMessage());
			System.out.println("Exception Cause is: "+exp.getCause());
			System.out.println("Catch Block End");
			exp.printStackTrace();
			//System.out.println("print stack trace message is: "+exp.printStackTrace());
		}
		finally
		{
			System.out.println("I am inside finally block whether it has exception or not");
		}
	
	}

}
