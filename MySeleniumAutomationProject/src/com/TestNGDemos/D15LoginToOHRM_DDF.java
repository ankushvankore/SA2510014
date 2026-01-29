package com.TestNGDemos;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

/*
 * 1. Read the data from Excel file
 * 2. Pass the data to Test Case for login
 * 3. Update result & message columns
 */

public class D15LoginToOHRM_DDF {
	String fPath = "ExcelFiles\\OHRM_LoginData.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index = 1;
	
	WebDriver driver;
	
	@Test(dataProvider = "getLoginData")
	public void login(String un, String ps) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

	}

	@DataProvider
	public Object[][] getLoginData() {
		int rows = sheet.getPhysicalNumberOfRows();
		String[][]loginData = new String[rows-1][2];
		
		for(int i = 1; i < rows; i++){
			row = sheet.getRow(i);
			for(int j = 0; j < 2; j++) {
				cell = row.getCell(j);
				loginData[i-1][j] = cell.getStringCellValue();
			}
		}
		
		return loginData;
	}
	
	@AfterMethod
	public void logout() {
		String message;
		row = sheet.getRow(index);
		cell = row.getCell(2);
		if (driver.getCurrentUrl().contains("dashboard")) {
			System.out.println("Login successful\nTest case pass");
			
			message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")).getText();
			
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			driver.findElement(By.linkText("Logout")).click();
			
			cell.setCellValue("Pass");
		} 
		else {
			System.out.println("Invalid data\nLogin Fail");
			
			message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
			
			cell.setCellValue("Fail");
		}
		cell = row.getCell(3);
		cell.setCellValue(message);
		index++;
	}
	
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		fos = new FileOutputStream(file);
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();
		
		driver.close();
	}

}
