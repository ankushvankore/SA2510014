package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D04ReadTheURL {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		String url = driver.getCurrentUrl();
		System.out.println("URL: " + url);
		
		if(url.contains("success"))
			System.out.println("Login successful. Test case pass");
		else
			System.out.println("Login fail. Test case fail");
		
		driver.close();
	}

}
