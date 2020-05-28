package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Started Test : "+ iTestResult.getMethod().getQualifiedName()+" WITH Invocation count : "+iTestResult.getMethod().getInvocationCount());
     }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Success Test: "+ iTestResult.getMethod().getQualifiedName()+" WITH Invocation count : "+iTestResult.getMethod().getInvocationCount());
   }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Failed Test: "+ iTestResult.getMethod().getQualifiedName()+" WITH Invocation count : "+iTestResult.getMethod().getInvocationCount());

     }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Skipped Test: "+ iTestResult.getMethod().getQualifiedName()+" WITH Invocation count : "+iTestResult.getMethod().getInvocationCount());
  }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Failed with % Test: "+ iTestResult.getMethod().getQualifiedName()+" WITH Invocation count : "+iTestResult.getMethod().getInvocationCount());

    }

    //called twice since this method is implemented by ISuiteListeners
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("on start");

    }

    //called twice since this method is implemented by ISuiteListeners
    @Override
    public void onFinish(ITestContext iTestContext) {
       System.out.println("on finish");
    }
}
