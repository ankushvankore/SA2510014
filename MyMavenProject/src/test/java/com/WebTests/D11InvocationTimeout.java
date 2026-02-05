package com.WebTests;

import org.testng.annotations.Test;

public class D11InvocationTimeout {
  @Test(invocationTimeOut = 4000)
  public void myTest() throws InterruptedException {
	  System.out.println("Test started");
	  
	  Thread.sleep(5000);
	  
	  System.out.println("Test ends");
  }
}
