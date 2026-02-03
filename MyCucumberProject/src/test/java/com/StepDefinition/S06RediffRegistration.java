package com.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S06RediffRegistration {
	WebDriver driver;
	@Given("Launch {string}")
	public void launch(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
	}

	@When("Enter following data")
	public void enter_following_data(io.cucumber.datatable.DataTable dataTable) {
	    System.out.println(dataTable);
	    
	    List<List<String>>data = dataTable.asLists();
	    System.out.println(data);
	    
	    System.out.println(data.get(0).get(0));
	    
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/input")).sendKeys(data.get(0).get(0));
	}

	@Then("Registration done")
	public void registration_done() {
	    
	}
}
