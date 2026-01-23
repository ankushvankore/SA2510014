package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import graphql.Assert;

public class D10POM_Client {
	WebDriver driver;
	RediffUtility r1;
	
	@Test
	public void rediffRegistration() throws InterruptedException {
		r1.setFullName("Ankit Poswal");
		r1.setRediffId("ankitposwalMay1994");
		r1.setPassword("Ankit@123");
		r1.setBirthDate("20", "MAY", "1994");
		//r1.checkAvailablity();
		Assert.assertTrue(r1.checkAvailablity().contains("Yippie"));
	}
	
	@Test
	public void rediffRegistration2() throws InterruptedException {
		r1.setFullName("Suman Moulekhi");
		r1.setRediffId("suman");
		r1.setPassword("Suman@!23");
		r1.setBirthDate("25", "OCT", "2000");
		r1.checkAvailablity();
		Assert.assertTrue(r1.checkAvailablity().contains("Yippie"));
	}
	
	@BeforeMethod
	public void refreshPage() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		r1 = new RediffUtility(driver);
	}

	@AfterTest
	public void afterTest() {
	}

}
