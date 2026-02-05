package com.WebTests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class D10ReporterLog {
	@Test
	public void test() {
		System.out.println("This is my test");
		Reporter.log("This is My Test");
	}
}
