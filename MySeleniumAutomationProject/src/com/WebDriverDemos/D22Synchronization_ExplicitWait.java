package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D22Synchronization_ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://omayo.blogspot.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement chkBox = driver.findElement(By.id("dte"));
		
		System.out.println("----------- Before Clicking --------------");
		System.out.println("Selected: " + chkBox.isSelected());
		System.out.println("Enabled : " + chkBox.isEnabled());
		
		driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(chkBox));
		//chkBox.click();
		
		//OR
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("dte")));
		//chkBox.click();
		
		//OR
		
		wait.until(ExpectedConditions.elementToBeClickable(chkBox)).click();
		
		System.out.println("----------- After Clicking --------------");
		System.out.println("Selected: " + chkBox.isSelected());
		System.out.println("Enabled : " + chkBox.isEnabled());
	}

}
