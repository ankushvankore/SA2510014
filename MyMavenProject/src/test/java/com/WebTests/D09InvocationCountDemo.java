package com.WebTests;

import org.testng.annotations.Test;

public class D09InvocationCountDemo {
	@Test(invocationCount = 5)
	public void test() {
		System.out.println("My Test");
	}
}
