package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D10LocateByLinkText {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		WebElement aboutLink = driver.findElement(By.linkText("About"));
		String text = aboutLink.getText();
		System.out.println("Text on the Hyperlink: " + text);
		
		//String href = aboutLink.getAttribute("href");
		//String href = aboutLink.getDomAttribute("href");
		//System.out.println("HREF: " + href);
		System.out.println("HREF: " + aboutLink.getDomAttribute("href"));
		
		aboutLink.click();
		
		String url = driver.getCurrentUrl();
		
		if(url.contains("about"))
			System.out.println("Test case pass");
		else
			System.out.println("Test case fail");
		
	}

}
