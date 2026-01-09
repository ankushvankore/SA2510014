package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A13EchoEchoCheckbox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://echoecho.com/htmlforms09.htm");
		
		//List<WebElement>products = driver.findElements(By.cssSelector("input[name^=\"option\"]"));
		//List<WebElement>products = driver.findElements(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input"));
		List<WebElement>products = driver.findElements(By.xpath("//input[starts-with(@name, \"option\")]"));
		
		for(WebElement chkBox : products) {
			System.out.println("---------- Before Clicking -----------");
			System.out.println("Checkbox: " + chkBox.getAttribute("value"));
			System.out.println("Selected: " + chkBox.isSelected());
			System.out.println("Enabled : " + chkBox.isEnabled());
			System.out.println("Visible : " + chkBox.isDisplayed());
			
			//if(!chkBox.isSelected())
			if(chkBox.isSelected() == false && chkBox.isEnabled())
				chkBox.click();
			
			System.out.println("----------- After Clicking ------------");
			System.out.println("Selected: " + chkBox.isSelected());
			System.out.println("Enabled : " + chkBox.isEnabled());
			System.out.println("Visible : " + chkBox.isDisplayed());
		}
	}

}
