package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffUtility {
	WebDriver driver;
	@FindBy (xpath = "//input[@placeholder='Enter your full name']") private WebElement fullName;
	@FindBy (css = "input[name^=\"login\"]")WebElement rediffId;
	public RediffUtility(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
		//Will initialize all the WebElements which are located by @FindBy (Page Factory)
	}
	
	public void setFullName(String fn) {
		//driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(fn);
		fullName.sendKeys(fn);
	}
	
	public void setRediffId(String rid) {
		//driver.findElement(By.xpath("//input[starts-with(@name, \"login\")]")).sendKeys(rid);
		rediffId.sendKeys(rid);
	}
	
	public void setPassword(String ps) {
		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(ps);
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(ps);
	}
	
	public void setBirthDate(String day, String month, String year) {
		Select dayDD = new Select(driver.findElement(By.className("day")));
		dayDD.selectByVisibleText(day);
		//new Select(driver.findElement(By.className("day"))).selectByVisibleText(day);
		new Select(driver.findElement(By.className("middle"))).selectByVisibleText(month);
		new Select(driver.findElement(By.className("year"))).selectByVisibleText(year);
	}
	
	public String checkAvailablity() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@type=\"button\"])[1]")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.id("check_availability")).getText();
		System.out.println(msg);
		return msg;
	}
}
