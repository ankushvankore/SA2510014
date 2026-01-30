package com.WebTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D04NormalExtentReport {

	public static void main(String[] args) {
		WebDriver driver;
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("Reports\\MyFirstReport.html");
		//This object represents the file in which we are storing the report
		ExtentReports report = new ExtentReports();
		//This object represents the report that will be stored in the above file
		ExtentTest test;
		//This reference represents the test of which we are generating the report.
		
		report.attachReporter(htmlReport);
		//Please store this report in the html file
		
		
		//Set environment details
		report.setSystemInfo("User Name: ", "Ankit");
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Company", "Star Agile");
		report.setSystemInfo("Location", "Banglore");
		
		//Configuration for look and feel of report
		htmlReport.config().setDocumentTitle("My First Extent Report");
		htmlReport.config().setReportName("Google Tests");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("dd-MMM-yyyy");
		
		test = report.createTest("Google Title Test");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
		
		test.log(Status.PASS, MarkupHelper.createLabel("Google Title", ExtentColor.GREEN));
		
		//------------------- Add One more Test ----------------
		
		test = report.createTest("Google Search Test");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Maven", Keys.ENTER);
		
		driver.close();
		
		test.log(Status.FAIL, MarkupHelper.createLabel("Google Search", ExtentColor.RED));
		
		report.flush();	
		//Will create the report file
	}

}
