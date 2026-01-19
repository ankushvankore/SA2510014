package com.WebDriverDemos;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class D36Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/");

		driver.findElement(By.linkText("Slider")).click();

		Actions act = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
		int x = slider.getLocation().x;
		int y = slider.getLocation().y;
		
		act.dragAndDropBy(slider, x+100, y).perform();
		
		//File object is used to handle / store any kind of file in java
		//Operations like read / write can be performed only via this File object
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//This will take a screenshot and will store in screenShot object.
		FileHandler.copy(screenShot, new File("Screenshots\\JQueryScreenshot.jpeg"));
		
		System.out.println("Screenshot captured!!!");
		driver.close();
	}

}
