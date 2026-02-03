package com.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class S05InsuranceProject {
	WebDriver driver;
	
	//@Before
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://sampleapp.tricentis.com/101/index.php");
	}
	
	//@After
	public void closeBrowser() {
		driver.close();
	}
	
	@Given("Open Insurance project")
	public void open_insurance_project() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://sampleapp.tricentis.com/101/index.php");
	}

	@When("Click on Automobile Link")
	public void click_on_automobile_link() {
		driver.findElement(By.partialLinkText("Auto")).click();
	}

	@When("Select make as {string}")
	public void select_make_as(String make) {
		new Select(driver.findElement(By.id("make"))).selectByVisibleText(make);
	}

	@When("Enter engine performance as {string}")
	public void enter_engine_performance_as(String ep) {
		driver.findElement(By.id("engineperformance")).sendKeys(ep);
	}

	@When("Enter DOM as {string}")
	public void enter_dom_as(String dom) {
		driver.findElement(By.id("dateofmanufacture")).sendKeys(dom);
	}

	@When("Select no of seats as {string}")
	public void select_no_of_seats_as(String no) {
		new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText(no);
	}

	@When("Select Fuel Type as {string}")
	public void select_fuel_type_as(String ft) {
		new Select(driver.findElement(By.id("fuel"))).selectByVisibleText(ft);
	}

	@When("Enter list price as {string}")
	public void enter_list_price_as(String lp) {
		driver.findElement(By.id("listprice")).sendKeys(lp);
	}

	@When("Enter Licence plate no as {string}")
	public void enter_licence_plate_no_as(String lno) {
		driver.findElement(By.id("licenseplatenumber")).sendKeys(lno);
	}

	@When("Enter annual milage as {string}")
	public void enter_annual_milage_as(String milage) {
		driver.findElement(By.id("annualmileage")).sendKeys(milage);
	}

	@Then("Data enterd successful")
	public void data_enterd_successful() {
		System.out.println("Thank you!!!");
	}
}
