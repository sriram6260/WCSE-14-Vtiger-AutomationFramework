package vTiger.OrganizationsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationusingDDT {

	@Test
	public void createOrganization() throws IOException, InterruptedException
	{
		
		//create all the objects
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil= new JavaUtility();
	
		/* property file - common data */
		
		String URL = putil.readDataFromPropertyFile("url");
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		/* excel file - test data */
		String ORGNAME = eutil.readDataFromExcel("organizations", 1, 2);
				
				
		       
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
		       
		       wutil.maximizeWindow(driver);
		       wutil.waitForPageLoad(driver);
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
				driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(ORGNAME+jutil.getRandomNumber());
				driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		       
				//logout
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/layerPopupBg.gif']"));
				wutil.mouseOverAction(driver, element);
				
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
