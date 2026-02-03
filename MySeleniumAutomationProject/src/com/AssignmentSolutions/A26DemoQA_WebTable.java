package com.AssignmentSolutions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A26DemoQA_WebTable {

	public static void main(String[] args) throws InterruptedException {
		int i;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/webtables");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		
		driver.findElement(By.id("addNewRecordButton")).click();
		
		//Add
		driver.findElement(By.id("firstName")).sendKeys("Ankush");
		driver.findElement(By.id("lastName")).sendKeys("Vankore");
		driver.findElement(By.id("userEmail")).sendKeys("ankush@gmail.com");
		driver.findElement(By.id("age")).sendKeys("46");
		driver.findElement(By.id("salary")).sendKeys("10000");
		driver.findElement(By.id("department")).sendKeys("Testing");
		driver.findElement(By.id("submit")).click();
		
		//Search
		List<WebElement>firstName = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/div[1]"));
		
		for(i = 0; i < firstName.size(); i++)
		{
			if(firstName.get(i).getText().equals("Ankush"))
				break;
		}
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div["+ (i+1) + "]/div/div[7]/div/span[2]")).click();
		
		Thread.sleep(5000);
		driver.close();

	}

}
