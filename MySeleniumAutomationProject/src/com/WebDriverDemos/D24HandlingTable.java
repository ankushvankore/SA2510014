package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D24HandlingTable {

	/*
	 * 1. Read all table headers
	 * 2. Display total no of rows
	 * 3. Display any row
	 */
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		//List<WebElement>headers = driver.findElements(By.tagName("th"));
		List<WebElement>headers = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/thead/tr/th"));
		
		System.out.println("------------ All Headers --------------");
		for(WebElement h : headers)
			System.out.println(h.getText());
		
		List<WebElement>allRows = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr"));
		System.out.println("Total Rows: " + allRows.size());
		
		int i = 0;
		
		System.out.println(allRows.get(i).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class=\"dataTable\"]/tbody/tr["+(i+1)+"]")).getText());
		
		driver.close();
	}

}
