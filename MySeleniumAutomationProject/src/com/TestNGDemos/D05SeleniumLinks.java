package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D05SeleniumLinks {
	WebDriver driver;
	
	@Test(priority = 1, groups = "SeleniumCore")
	public void downloadsLink() {
		driver.findElement(By.linkText("Downloads")).click();
	}
	
	@Test(priority = 2, groups = "SeleniumCore")
	public void documentationLink() {
		driver.findElement(By.linkText("Documentation")).click();
	}
	
	@Test(priority = 3, groups = "SeleniumMisc")
	public void projectsLink() {
		driver.findElement(By.linkText("Projects")).click();
	}
	
	@Test(priority = 4, groups = "SeleniumMisc")
	public void supportLink() {
		driver.findElement(By.linkText("Support")).click();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver.get("https://www.selenium.dev/");
		System.out.println("Title: " + driver.getTitle());
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("Title: " + driver.getTitle());
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.close();
	}

}
