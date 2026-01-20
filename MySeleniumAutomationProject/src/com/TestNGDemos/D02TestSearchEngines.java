package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class D02TestSearchEngines {
	@Test(priority = 4)
	public void testGoogle() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://google.com");
		System.out.println("Title: " + driver.getTitle());

		driver.close();
	}

	@Test(priority = 2)
	public void testBing() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.bing.com/");
		System.out.println("Title: " + driver.getTitle());

		driver.close();
	}

	@Test(priority = 3)
	public void testYahoo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.yahoo.com/?guccounter=1");
		System.out.println("Title: " + driver.getTitle());

		driver.close();
	}

	@Test(priority = 1)
	public void testRediff() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.rediff.com/");
		System.out.println("Title: " + driver.getTitle());

		driver.close();
	}
}
