package com.AssignmentSolutions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A35JOT_Registration {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://www.jotform.com/form-templates/exam-registration-form");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"formPreviewArea\"]")));
		
		driver.findElement(By.id("first_9")).sendKeys("Ankush");
		driver.findElement(By.id("last_9")).sendKeys("Vankore");
		driver.findElement(By.id("input_10")).sendKeys("9890742718");
		driver.findElement(By.id("input_3")).sendKeys("Testing");
		
		driver.findElement(By.id("lite_mode_11")).sendKeys("11-08-2024");
		driver.findElement(By.id("lite_mode_12")).sendKeys("11-08-2024");
		driver.findElement(By.id("input_8")).sendKeys("No Comments");
		
		js.executeScript("arguments[0].click()", driver.findElement(By.id("input_16")));
		
		System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText());
		
		driver.close();

	}

}
