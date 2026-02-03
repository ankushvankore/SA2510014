package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S04SeleniumTest {
	WebDriver driver;
	
	@Given("Open Selenium Home Page")
	public void open_selenium_home_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.selenium.dev/");
	}

	@When("Click on Downloads link")
	public void click_on_downloads_link() {
	    driver.findElement(By.linkText("Downloads")).click();
	}

	@Then("Downloads page should display")
	public void downloads_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("download"));
	}

	@When("Click on Documentation Link")
	public void click_on_documentation_link() {
	    driver.findElement(By.linkText("Documentation")).click();
	}

	@Then("Documentation page should display")
	public void documentation_page_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("documentation"));
	}

	@When("Click on Projects link")
	public void click_on_projects_link() {
		driver.findElement(By.linkText("Projects")).click();
	}

	@Then("Projects page should display")
	public void projects_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("projects"));
	}

	@When("Click on Support link")
	public void click_on_support_link() {
	    driver.findElement(By.linkText("Support")).click();
	}

	@Then("Supports page should display")
	public void supports_page_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("support"));
	}
}
