package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D13ReadTheDataFromExcel {
	String fPath = "ExcelFiles\\OHRM_LoginData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	@Test(enabled = false)
	public void readData() {
		row = sheet.getRow(0);
		cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());

		cell = row.getCell(1);
		System.out.println(cell.getStringCellValue());
		
		System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
	}
	
	@Test
	public void readAllData() {
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		/*for(int i = 0; i < rows; i++) {
			row = sheet.getRow(i);
			for(int j = 0; j < cells; j++) {
				cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}
		}*/
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cells; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		// As we are not creating a workbook rather we are trying to read the data
		// from existing workbook
		// Thats why we need to pass FileInputStream object to wb
		sheet = wb.getSheet("Sheet1");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}

}
