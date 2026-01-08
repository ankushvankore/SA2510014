package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D14LocateByTagName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		List<WebElement>allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + allLinks.size());
		
		//System.out.println(allLinks.get(0).getText());
		//System.out.println(allLinks.get(1).getText());
		
		//for(int i = 0; i < allLinks.size(); i++)
			//System.out.println(allLinks.get(i).getText());
		
		for(WebElement l : allLinks)
			System.out.println(l.getText());
		
		driver.close();		
	}

}
