package vTiger.ContactsTests;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganization {

       @Test
       public void createContactWithOrg() throws IOException
        {
		
		WebDriver driver=null;
		//create necessary objects of all the utilities
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil= new JavaUtility();
		
		//read the required data
		
		String URL = putil.readDataFromPropertyFile("url");
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		String LASTNAME = eutil.readDataFromExcel("contacts", 4, 2);
		String ORGNAME = eutil.readDataFromExcel("contacts", 4, 3)+jutil.getRandomNumber();
		
		//launch the browser
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else {
			System.err.println("invalid browser");
		}

		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		
		// login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 6 : click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		// create organization with mandatory details and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// validate the organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		
		// navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		// create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		// create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		// step 12 navigate organization look up image
		driver.findElement(By.xpath(" //input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		// switch the control to organization window
		wutil.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		
		// step 14 : switch the control back to parent window
		
		wutil.switchToWindow(driver, "Contacts");
		
		// step 15 : save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// step 16 : validate for contacts
		
		String ContaHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertEquals(ContaHeader.contains(LASTNAME), true);
		
		// step 17 : logout
		
		WebElement adminimaz = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.mouseOverAction(driver, adminimaz);
		driver.findElement(By.linkText("Sign Out")).click();
		
	
		
	}

}
