package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class D09KeywordDrivenFrameword {
	File file;
	FileInputStream fis;
	Properties prop;
	
	WebDriver driver;
	
	@Test
	public void automobileTest() {
		driver.findElement(By.linkText(prop.getProperty("autoLink"))).click();
		Select makeDD = new Select(driver.findElement(By.id(prop.getProperty("makeId"))));
		makeDD.selectByIndex(2);
		driver.findElement(By.name(prop.getProperty("epName"))).sendKeys("1000");
		driver.findElement(By.xpath(prop.getProperty("domXP"))).sendKeys(prop.getProperty("DOM"));
		new Select(driver.findElement(By.cssSelector(prop.getProperty("seatsCSS")))).selectByIndex(2);
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("src/com/TestNGDemos/TricentisLocators.properties");
		fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		//Will load / copy all properties in this object

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void afterTest() {
	}

}
