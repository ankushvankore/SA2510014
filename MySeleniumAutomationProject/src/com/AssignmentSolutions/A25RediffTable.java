package com.AssignmentSolutions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A25RediffTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		List<WebElement>currentPrice = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
		double[]cpArray = new double[currentPrice.size()];
		
		for(int i = 0; i < cpArray.length; i++)
		{
			//String s = currentPrice.get(i).getText();
			//s = s.replace(",", "");	//Will remove , from the value
			//cpArray[i] = Double.parseDouble(s);
			cpArray[i] = Double.parseDouble(currentPrice.get(i).getText().replace(",", ""));
		}
		
		Arrays.sort(cpArray);
		//Display Last element from array after sorting
		System.out.println("Highest Price: " + cpArray[cpArray.length-1]);	
		
		driver.close();
	}

}
