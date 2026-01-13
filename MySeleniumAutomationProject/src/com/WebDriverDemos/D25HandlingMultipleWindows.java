package com.WebDriverDemos;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D25HandlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.naukri.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
		js.executeScript("window.scrollBy(0, 200)", "");
		driver.findElement(By.xpath("(//span[contains(text(), \"Remote\")])[2]")).click();
		
		System.out.println("Title: " + driver.getTitle());
		
		Set<String>windows = driver.getWindowHandles();
		System.out.println(windows);
		
		Object[]winArray = windows.toArray();
		//Convert the Set<> into array
		String win1 = winArray[0].toString();		//1st element / id of 1st window
		String win2 = winArray[1].toString();		//2nd element / id of 2nd window
		
		//Switch to 2nd page
		driver.switchTo().window(win2);
		Thread.sleep(5000);
		System.out.println("Title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"search-result-container\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/label/i")).click();
		
		Thread.sleep(5000);
		
		//Switch to 1st page
		driver.switchTo().window(win1);
		
		driver.findElement(By.linkText("Login")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
