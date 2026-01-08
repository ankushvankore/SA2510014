package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D17HandlingRadioButton {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		WebElement gnFemale = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[9]/div/label[2]/input"));
		
		System.out.println("---------- Before Clicking -----------");
		System.out.println("Selected: " + gnFemale.isSelected());
		System.out.println("Enabled : " + gnFemale.isEnabled());
		System.out.println("Visible : " + gnFemale.isDisplayed());
		
		gnFemale.click();
		
		System.out.println("----------- After Clicking ------------");
		System.out.println("Selected: " + gnFemale.isSelected());
		System.out.println("Enabled : " + gnFemale.isEnabled());
		System.out.println("Visible : " + gnFemale.isDisplayed());
	}
}
