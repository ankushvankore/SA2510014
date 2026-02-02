package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S02GoogleSearch {
	WebDriver driver;
	@Given("Open Google in browser")
	public void open_google_in_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https:www.google.com");
	}

	@When("Enter text to search")
	public void enter_text_to_search() {
	    driver.findElement(By.name("q")).sendKeys("Smriti Mandhana");
	}

	@When("Hit enter")
	public void hit_enter() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("A valid search result should display")
	public void a_valid_search_result_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("Smriti"));
	}

}
