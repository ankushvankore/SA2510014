package com.WebTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class D08DependsOnDemo {
	@Test
	public void login() {
		System.out.println("Login test started!!!");
		Assert.assertTrue(false);
		System.out.println("Login successful!!!");
	}

	@Test(dependsOnMethods = "login")
	public void logout() {
		System.out.println("This is logout test!!!");
	}
}
