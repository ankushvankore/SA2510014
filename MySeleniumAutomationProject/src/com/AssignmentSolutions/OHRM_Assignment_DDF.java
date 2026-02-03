package com.AssignmentSolutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OHRM_Assignment_DDF {
	String fPath = "ExcelFiles/OHRM Assignment_Data.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	XSSFCellStyle style;
	XSSFFont font;

	WebDriver driver;
	OHRMClass o1;
	String eId, eName;
	boolean result;
	int index = 1;

	@Test(dataProvider = "getData")
	public void test(String fName, String mName, String lName, String un, String ps, String empId, String expMessage,
			String actMessage) throws InterruptedException {
		o1.login("Admin", "admin123");
		o1.openPIM();
		o1.addEmployee(fName, mName, lName, un, ps);
		o1.logOutAdmin();

		o1.login(un, ps);
		eId = o1.getEmpId();
		eName = o1.getEmpName();

		System.out.println(eId);
		System.out.println(eName);
		if (eName.equals(expMessage)) {
			System.out.println("Name matching");
			result = true;
		} else 
		{
			System.out.println("Name not matching");
			result = false;
		}

		o1.logOutEmployee();

		o1.login("admin", "admin123");
		o1.openPIM();
		o1.deleteEmployee(un);
		o1.logOutAdmin();
	}

	@AfterMethod
	public void afterMethod() {
		sheet.getRow(index).getCell(6).setCellValue(eId);
		sheet.getRow(index).getCell(8).setCellValue(eName);

		cell = sheet.getRow(index).getCell(9);

		style = wb.createCellStyle();
		font = wb.createFont();

		// if(result)
		if (sheet.getRow(index).getCell(8).getStringCellValue()
				.equals(sheet.getRow(index).getCell(8).getStringCellValue())) {
			font.setColor(HSSFColorPredefined.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue("Pass");
		} else {
			font.setColor(HSSFColorPredefined.RED.getIndex());
			font.setItalic(true);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue("Fail");
		}

		index++;
	}

	@DataProvider
	public Object[][] getData() {
		int rows = sheet.getPhysicalNumberOfRows();
		String[][] data = new String[rows - 1][8];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < 8; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j + 1).getStringCellValue();
			}
		}

		return data;
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

		o1 = new OHRMClass(driver);
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();

		driver.close();
	}
}
