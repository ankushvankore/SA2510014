package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D37HandlingShadowDOM {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");

		/*
		 * For handling #shadow-root(open) 1. You should use only CSSSelector 2. First
		 * read the parent tag of #shadow-root 3. Store this control / tag in
		 * SearchContext object 4. Call findElement method via SearchContext object
		 */

		SearchContext ss = driver.findElement(By.cssSelector("div[id=\"shadow_host\"]")).getShadowRoot();
		ss.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("Naveen");

	}

}
