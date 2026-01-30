package com.WebTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;

/*
 * While working with Excel file you have to add 2 dependencies
 * 1. Apache POI
 * 2. Apache POI OOXML
 * 
 *  Make Sure that you are adding the same version of both dependencies
 */

public class D03ReadingFromExcel {
	String fPath = "C:\\Users\\Dell\\Desktop\\OHRM Assignment_Data.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@Test
	public void readFromExcel() {
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cells; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);

				switch(cell.getCellType())
				{
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				default:
					break;
				}
			}
		}
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}

	@AfterClass
	public void afterClass() throws IOException {
		wb.close();
		fis.close();
	}

}
