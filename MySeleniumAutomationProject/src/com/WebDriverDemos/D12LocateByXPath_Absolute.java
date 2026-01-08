package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D12LocateByXPath_Absolute {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div/div/form/fieldset/div[2]/fieldset/input[1]")).sendKeys("ramesh");
		driver.findElement(By.xpath("html/body/div/div/div[2]/div/div[2]/div/div/div/div/form/fieldset/div[2]/fieldset/input[2]")).sendKeys("ramesh123");
		driver.findElement(By.xpath("html/body/div/div/div[2]/div/div[2]/div/div/div/div/form/fieldset/div[3]/div/input")).click();
		
		String msg = driver.findElement(By.xpath("html/body/div/div/div[2]/div/div[2]/div/div/div/div/form/fieldset/div/span")).getText();
		System.out.println("Error Message: " + msg);
		
		driver.close();
	}

}
