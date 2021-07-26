package test;

public class ExceptionHandlingDemo2 {

public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	demo();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("catch block executes");
}
	}
public static void demo() throws Exception

{
	System.out.println("Exception handling demo starts");
	//int i=1/0;
	//System.out.println("Exception handling demo ends");
	throw new ArithmeticException("Not valid operation");
	}
}
