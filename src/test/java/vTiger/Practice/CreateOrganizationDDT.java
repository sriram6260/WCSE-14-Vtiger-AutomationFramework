package vTiger.Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationDDT {

      @Test
      public void createOrganizationDDT() throws IOException, InterruptedException
       {
		
		//read the data
		//common data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pr = new Properties();
		pr.load(fis);
		 String BROWSER = pr.getProperty("browser");
		 String URL = pr.getProperty("url");
		 String USERNAME = pr.getProperty("username");
		 String PASSWORD = pr.getProperty("password");
		 
		//test data
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\DataDriven.xlsx.");
       Workbook wb = WorkbookFactory.create(fis1);
       Sheet sh = wb.getSheet("Oranizations");
       Row r = sh.getRow(1);
       Cell c = r.getCell(2);
       String ORGNAME = c.getStringCellValue();
       
       WebDriver driver=null;
       if(BROWSER.equalsIgnoreCase("chrome"))
       {
    	   WebDriverManager.chromedriver().setup();
    	   driver=new ChromeDriver();
    	   
       }
       
       else if(BROWSER.equalsIgnoreCase("firefox"))
       {
    	   WebDriverManager.firefoxdriver().setup();
    	   driver=new FirefoxDriver();
       }
       
       else {
		System.out.println("browser not found");
	}
       
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get(URL);
       
       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(10);
		//click on organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//click on create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(10);
		//create new organization with mandatory fields and click on save button
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
            
  
	}

}
