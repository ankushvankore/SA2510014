package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D29NavigationMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://google.com");
		driver.navigate().to("https://google.com");
		
		driver.findElement(By.partialLinkText("How")).click();
		System.out.println("Title: " + driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		System.out.println("Title: " + driver.getTitle());
		
		Thread.sleep(2000);
		driver.navigate().forward();
		System.out.println("Title: " + driver.getTitle());
		
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

}
