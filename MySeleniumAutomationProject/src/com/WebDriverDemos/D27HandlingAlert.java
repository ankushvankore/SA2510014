package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D27HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/alerts");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Alert alt;
		
		js.executeScript("window.scrollBy(0, 400)", "");
		
		driver.findElement(By.id("alertButton")).click();
		alt = driver.switchTo().alert();
		//Switch to alert and store the alert in alt object
		System.out.println(alt.getText());
		Thread.sleep(2000);
		alt.accept();			//Will click on Ok button
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.id("timerAlertButton")).click();
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.alertIsPresent());
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(2000);
		alt.accept();
		
		driver.findElement(By.id("confirmButton")).click();
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(2000);
		alt.dismiss();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		
		driver.findElement(By.id("promtButton")).click();
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.sendKeys("Madhan");
		alt.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		driver.close();
	}

}
