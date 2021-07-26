package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeneres implements ITestListener, ISuiteListener {

 public void onTestStart(ITestResult result) 
 {
	  System.out.println("***** TEST STARTED ******** "+result.getName());
 }
 
 public void onTestSuccess(ITestResult result)
 {
	 System.out.println("**** Test Success****** "+result.getName());
 }
 public void onTestFailure(ITestResult result)
 {
	 System.out.println("***** Test Failed **********"+result.getName());
 }
 public void onTestSkipped(ITestResult result)
 {
	 System.out.println("*******Test Skipped ******"+result.getName());
 }
 public void onTestFailedButWithinSuccessPercentage(ITestResult result)
 {
	 System.out.println("********** onTestFailed But Within SuccessPercentage ***********"+result.getName());
 }
 public void onStart(ITestContext context)
 {
	  System.out.println("*********** All Test Starts ***********"+context.getName());
 }
 public void onFinish(ITestContext context)
 {
	  System.out.println("*******Test Finished *********"+context.getName());
 }
 
 public void onStart(ISuite suite)
 {
	 System.out.println("************ Test SUite Starts "+suite.getName());
 }
 public void onFinish(ISuite suite)
 {
	 System.out.println("*********** Test Suite Finish "+suite.getName());
 }

}
