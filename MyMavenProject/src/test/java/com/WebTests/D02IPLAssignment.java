package com.WebTests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D02IPLAssignment {
	WebDriver driver;
	
	@Test
	public void iplTableTest() {
		List<WebElement>allTeams = driver.findElements(By.xpath("//*[@id=\"pointsdata\"]/tr/td[3]/div/h2"));
	
		for(int i = 0; i < allTeams.size(); i++) {
			int n = 0, l = 0, w = 0;
			System.out.print(allTeams.get(i).getText());
			List<WebElement>recentForm = driver.findElements(By.xpath("//*[@id=\"pointsdata\"]/tr["+(i+1)+"]/td[12]/div/span"));
			for(WebElement rf : recentForm)	{
				System.out.print("\t" + rf.getText());
				if(rf.getText().equals("W"))
					w++;
				else if(rf.getText().equals("N"))
					n++;
				else if(rf.getText().equals("L"))
					l++;
			}
			System.out.print("\t" + "N: " + n + " L: " + l + " W: " + w);
			System.out.println();
		}
	}
	
	/*
	 * //*[@id="pointsdata"]/tr/td[3]/div/h2
	 */

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.iplt20.com/points-table/men/2024");
		
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
