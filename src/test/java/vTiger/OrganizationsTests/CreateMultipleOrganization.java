package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateMultipleOrganization {
	
	ExcelFileUtility eutil=new ExcelFileUtility();
	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	JavaUtility jutil= new JavaUtility();
	
	
	@Test(dataProvider = "Orgname")
	public void createMultipleOrg(String Org,String INDUSTRY) throws IOException
	{
		
		/* property file - common data */
		
		String URL = putil.readDataFromPropertyFile("url");
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		String Orgname = Org+jutil.getRandomNumber();
				
		       
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
		       
		       // login to app
		       LoginPage lp = new LoginPage(driver);
		        lp.LoginApp(USERNAME, PASSWORD);
		    		
				//click on organization link
		        HomePage hp = new HomePage(driver);
				hp.ClickonOrganizationLnk();
				
				// click on create organization lookup image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.ClickOnOrganizationLookupImg();
				
				//create new organization with mandatory fields and click on save button
				CreateNewOrganizationPage cnop =new CreateNewOrganizationPage(driver);
				cnop.CreateNewOrganization(Orgname, INDUSTRY);
		       
				//validation
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrganizationHeaderText();
				Assert.assertTrue(OrgHeader.contains(Orgname));
				
				
				//logout
				hp.LogoutofApp(driver);
		
	}
	
	@DataProvider(name="Orgname")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eutil.readMultipleDataIntoDataProvider("MultipleOrganizations");
		 
	}
	

}
