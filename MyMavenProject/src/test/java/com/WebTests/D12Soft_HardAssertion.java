package com.WebTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D12Soft_HardAssertion {
	@Test
	public void hardAssertion() {
		System.out.println("Test started!!!");
		Assert.assertTrue(false);
		System.out.println("Test ends!!!");
		
	}
	@Test
	public void softAssertion() {
		System.out.println("---------------------------");
		System.out.println("Test started!!!");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(false);
		System.out.println("Test ends!!!");
		sa.assertAll();
	}
}
