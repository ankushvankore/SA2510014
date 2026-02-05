package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class S07DDT_OHRM_Login {
	WebDriver driver;
	@Given("Open Orange HRM application")
	public void open_orange_hrm_application() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@After
	public void closeBrowser() {
		driver.close();
	}

	@When("Enter user name as {string}")
	public void enter_user_name_as(String un) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
	}

	@When("Enter password as {string}")
	public void enter_password_as(String ps) {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Dashboard page should display")
	public void dashboard_page_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}
}
