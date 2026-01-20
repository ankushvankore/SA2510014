package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D06DataDrivenTesting {
	@Test(dataProvider = "getLoginData")
	public void login(String un, String ps) {
		System.out.println(un);
		System.out.println(ps);
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			new Object[] { "admin", "admin123" },
			new Object[] { "priya", "priya123" },
			new Object[] { "ankit", "ankit123" },
			new Object[] { "admin", "admin123" },
		};
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
