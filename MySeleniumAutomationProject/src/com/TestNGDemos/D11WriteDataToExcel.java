package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D11WriteDataToExcel {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test
	public void writeToExcel() {
		row = sheet.createRow(0);		//Will create 1st row
		cell = row.createCell(0);		//Will create 1st cell inside first row
		
		cell.setCellValue("Ramesh");
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		file = new File("MyFirstExcelFile.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("Trial Sheet");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);		//Will write the data physically to the file
		wb.close();
		fos.close();
	}

}
