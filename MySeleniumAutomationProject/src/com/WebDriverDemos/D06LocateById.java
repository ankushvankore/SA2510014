package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D06LocateById {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("test@gmail.com");
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("12345");
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
	}

}
