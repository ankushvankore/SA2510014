package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D15LocatingMultipleControls {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		List<WebElement>textBoxes = driver.findElements(By.cssSelector("input[class=\"form-control\"]"));
		
		for(WebElement t : textBoxes)
			System.out.println(t.getAttribute("Placeholder"));
		
		driver.close();
	}

}
