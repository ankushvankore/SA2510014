package com.WebTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D05DetailedExtentReport {
	WebDriver driver;
	ExtentSparkReporter htmlReport;
	// Report file
	ExtentReports report;
	// Actual report
	ExtentTest test;
	
	@Test(priority = 1)
	public void loginToOHRM_Success() throws InterruptedException {
		test = report.createTest("OHRM Login Success");

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);

		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.partialLinkText("Log")).click();
	}
	@Test(priority = 2)
	public void loginToOHRM_Fail() {
		test = report.createTest("OHRM Login Fail");

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Abhinav");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("abhinav123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);

		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}

	@Test(priority = 3)
	public void loginToOHRM_Skip() {
		test = report.createTest("OHRM Login Skip");

		throw new SkipException("Skipping the test for reporting purpose");
		//This will purposely skip the test
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) 
	//ITestResult is an interface which will give you detailed information about the @Test 
	{
		if(result.getStatus() == ITestResult.SUCCESS)	//Test case pass
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		}
		else if(result.getStatus() == ITestResult.FAILURE)	//Test case Fail
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.fail(result.getThrowable());		//getThrowable() will get the failure log
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}
	
	@BeforeTest
	public void beforeTest() {
		htmlReport = new ExtentSparkReporter("Reports\\MyDetailedReport.html");	//Report File
		report = new ExtentReports();
		
		//Attach report to file
		report.attachReporter(htmlReport);

		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("User", "Lavanya");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("Processor", "I5");

		htmlReport.config().setDocumentTitle("OHRM Login Report");
		htmlReport.config().setReportName("My Detailed Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@AfterTest
	public void afterTest() {
		report.flush();
		driver.close();
	}
}
