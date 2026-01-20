package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D03BeforeTest_AfterTest {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@Test(priority = 4)
	public void testGoogle() {
		driver.get("https://google.com");
		System.out.println("Title: " + driver.getTitle());
	}

	@Test(priority = 2)
	public void testBing() {
		driver.get("https://www.bing.com/");
		System.out.println("Title: " + driver.getTitle());
	}

	@Test(priority = 3)
	public void testYahoo() {
		driver.get("https://www.yahoo.com/?guccounter=1");
		System.out.println("Title: " + driver.getTitle());
	}

	@Test(priority = 1)
	public void testRediff() {
		driver.get("https://www.rediff.com/");
		System.out.println("Title: " + driver.getTitle());
	}

}
