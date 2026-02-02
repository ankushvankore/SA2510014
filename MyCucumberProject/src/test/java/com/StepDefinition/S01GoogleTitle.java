package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S01GoogleTitle {
	WebDriver driver;
	String title;
	@Given("Open Google")
	public void open_google() {
		System.out.println("Launching google");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https:www.google.com");
	}

	@When("Capture the title")
	public void capture_the_title() {
		System.out.println("Capturing the title");
		title = driver.getTitle();
	}

	@Then("Title should be Google")
	public void title_should_be_google() {
		System.out.println("Validating the title");
		Assert.assertTrue(title.equals("Google"));
	}
}
