package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S03LoginToExpandTesting {
	WebDriver driver;
	@Given("Open Expand Testing")
	public void open_expand_testing() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://practice.expandtesting.com/login");
	}

	@When("Enter valid user name")
	public void enter_valid_user_name() {
	    driver.findElement(By.id("username")).sendKeys("practice");
	}

	@When("Enter valid password")
	public void enter_valid_password() {
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	}

	@When("Click on Sumbit button")
	public void click_on_sumbit_button() {
		driver.findElement(By.id("submit-login")).submit();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
	}

	@When("Enter invalid user name")
	public void enter_invalid_user_name() {
		driver.findElement(By.id("username")).sendKeys("madhan");
	}

	@When("Enter invalid password")
	public void enter_invalid_password() {
		driver.findElement(By.id("password")).sendKeys("SecretPassword!");
	}

	@When("Click on Submit")
	public void click_on_submit() {
		driver.findElement(By.id("submit-login")).submit();
	}

	@Then("Error message should display")
	public void error_message_should_display() {
	    Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("invalid"));
	}
}
