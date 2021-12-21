package testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart of ITestListener");
     }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess of ITestListener");
   }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure of ITestListener");

     }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped of ITestListener");
  }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("onTestFailedButWithinSuccessPercentage of ITestListener");

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart of ITestListener");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
       System.out.println("onFinish of ITestListener");
    }
}
