package com.AssignmentSolutions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertPresent {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.id("login1")).sendKeys("Ankush");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// try waiting for alert
			Alert alt = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert exists: " + alt.getText());
			alt.accept();

		} catch (TimeoutException e) {
			System.out.println("No alert found (TimeoutException caught).");
		} catch (NoAlertPresentException e) {
			System.out.println("No alert found (NoAlertPresentException caught).");
		} catch (Exception e) {
			System.out.println("Some other exception: " + e);
		} finally {
			System.out.println("Program executed successfully — no crash.");
			driver.quit();

		}
	}
}
