package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D28HandlingFileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/automation-practice-form");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//js.executeScript("window.scrollBy(0,200)", "");
		
		driver.findElement(By.id("firstName")).sendKeys("Priya");
		driver.findElement(By.id("lastName")).sendKeys("Singh");
		driver.findElement(By.id("userEmail")).sendKeys("priya@gmail.com");
		WebElement gnFemale = driver.findElement(By.id("gender-radio-2"));
		
		js.executeScript("arguments[0].click()", gnFemale);
		
		driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "A");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys("12 Dec 2000");
		
		//driver.findElement(By.id("uploadPicture")).sendKeys("D:\\StarAgile\\Demos\\SA2510014\\Assignments_SA2510014.docx");
		//WebElement fileUpload = driver.findElement(By.id("uploadPicture"));
		//js.executeScript("arguments[0].scrollIntoView(true)", fileUpload);
		//fileUpload.sendKeys("D:\\StarAgile\\Demos\\SA2510014\\Assignments_SA2510014.docx");
		
		
	}

}
