package com.AssignmentSolutions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class A33IRCTC_Registration {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.irctc.co.in/nget/profile/user-registration");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.id("userName")).sendKeys("ankushvankore");
		driver.findElement(By.id("usrPwd")).sendKeys("Ankush@12345");
		driver.findElement(By.id("cnfUsrPwd")).sendKeys("Ankush@12345");
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[7]/input")).sendKeys("Murphy");
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button")).click();

		driver.findElement(By.id("firstName")).sendKeys("Ankush");
		driver.findElement(By.id("middleName")).sendKeys("Ramdas");
		driver.findElement(By.id("lastname")).sendKeys("Vankore");
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[3]/li/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/input")).sendKeys("29-01-1979");
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//*[@id=\"married\"]/div/div[2]/span")).click();
		new Select(driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-1\"]/div/div[8]/select"))).selectByVisibleText("India");
		driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-1\"]/div/div[9]/p-selectbutton/div/div[1]/span")).click();
		driver.findElement(By.id("email")).sendKeys("ankush.vankore@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("9890742718");
		new Select(driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-1\"]/div/div[13]/select"))).selectByVisibleText("India");
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button")).click();

		driver.findElement(By.id("resAddress1")).sendKeys("1128");
		driver.findElement(By.id("resAddress2")).sendKeys("Hupare Nagar Lane 9");
		driver.findElement(By.id("resAddress3")).sendKeys("Near Water Tank");
		driver.findElement(By.name("resPinCode")).sendKeys("416202");
		Thread.sleep(2000);
		driver.findElement(By.name("resPinCode")).sendKeys(Keys.TAB);
		new Select(driver.findElement(By.xpath("/html/body/app-root/app-home/div[3]/div/app-user-registration/div/div/form/div/div[2]/div[1]/div[2]/p-tabview/div/div/p-tabpanel[3]/div/div/div[5]/select"))).selectByVisibleText("Kolhapur");
		new Select(driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-2\"]/div/div[7]/select"))).selectByVisibleText("Pattankodoli S.O");
		driver.findElement(By.id("resPhone")).sendKeys("9890742718");
		driver.findElement(By.xpath("//*[@id=\"yes\"]/div/div[2]/span")).click();
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-2\"]/div/div[12]/span[1]/input")));
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button")).click();

		System.out.println(driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/p-dialog/div/div/div[2]/app-registration-confirmation/div/div[1]/ol/li")).getText());

		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/p-dialog/div/div/div[2]/app-registration-confirmation/div/div[3]/button[1]")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[1]/div[3]/small")).getText());
		
		driver.close();

	}

}
