package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A21RedBusAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.redbus.in/");
		
		//From
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[2]/search/div/div/div[1]/div[1]/div[1]/div[1]")).click();
		driver.findElement(By.id("srcinput")).sendKeys("Nagp");
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[2]/search/div/div/div[2]/div/div[3]/div[1]/div[1]/div/div/div")).click();
		
		//To
		
		
		//Calender
		
		
		//Date
		
		
		//Search Bus
		
		
		//Display Result
	}

}
