package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D14CreateLoginFile {
	String fPath = "ExcelFiles\\OHRM_LoginData.xlsx";
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index = 0;

	@Test(dataProvider = "getLoginData")
	public void writeToFile(String un, String ps, String rs, String ms) {
		row = sheet.createRow(index);
		cell = row.createCell(0);
		cell.setCellValue(un);
		
		cell = row.createCell(1);
		cell.setCellValue(ps);
		
		cell = row.createCell(2);
		cell.setCellValue(rs);
		
		cell = row.createCell(3);
		cell.setCellValue(ms);
		
		index++;
	}

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			new Object[] { "User Name", "Password", "Result", "Message" },
			new Object[] { "priya", "priya123", "NotRun", "NULL"},
			new Object[] { "ankit", "ankit123", "NotRun", "NULL"},
			new Object[] { "admin", "admin123", "NotRun", "NULL" },
			new Object[] { "abhinav", "abhinav123", "NotRun", "NULL" },
			new Object[] { "admin", "admin123", "NotRun", "NULL" },
		};
	}
	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		file = new File(fPath);
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("Login Data");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
