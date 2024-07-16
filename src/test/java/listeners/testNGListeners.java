package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("******* Test Started : " + result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("******* Test Succesfull : " + result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("******* Test Failed : " + result.getName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("******* Test Skipped : " + result.getName());
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("******* Test Failed But Within Success Percentage : " + result.getName());
		
	}
	
	public void onStart(ITestResult context) {
		
	}
	
	public void onFinish(ITestResult context) {
		System.out.println("******* Test Completed : " + context.getName());
		
	}

}
