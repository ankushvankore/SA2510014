package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class D23Synchronization_FluentWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		FluentWait<WebDriver>wait = new FluentWait<WebDriver>(driver);
		
		//Login
		wait.withTimeout(Duration.ofSeconds(10))
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofMillis(1))
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		if(driver.getCurrentUrl().contains("dashboard")) {
			System.out.println("Login successful");
			
			//Logout
			driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
		else {
			System.out.println("Login fail");
		}
		
		driver.close();
	}

}
