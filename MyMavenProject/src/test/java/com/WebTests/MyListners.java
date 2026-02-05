package com.WebTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListners implements ITestListener {

	public void onStart(ITestContext result) {
		System.out.println("Started Execution of TestNG Class");
	}

	public void onFinish(ITestContext result) {
		System.out.println("Finished with the execution");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed: " + result.getName());
		System.out.println(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: " + result.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case pass: " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}
}
