package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A04EchotrakLogin_ClassName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		WebElement userName = driver.findElement(By.className("form-control"));
		userName.sendKeys("priya");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("priya@123");
		WebElement loginBtn = driver.findElement(By.className("btn-lg"));
		loginBtn.click();
		
		WebElement errMessage = driver.findElement(By.id("lblMsg"));
		String msg = errMessage.getText();
		System.out.println("Error Message: " + msg);
	}

}
