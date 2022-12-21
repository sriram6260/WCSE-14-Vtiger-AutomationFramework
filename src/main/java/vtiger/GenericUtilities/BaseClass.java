package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();
	
	public static WebDriver sdriver=null;
	
	public WebDriver driver = null;
	
	@BeforeSuite(groups = {"SmokeSuite","RegresssionSuite"})
	public void bsConfig()
	{
		System.err.println("========== data base connection successful===========");
	}
	
	@BeforeClass(groups = {"SmokeSuite","RegresssionSuite"})
	public void bcConfig() throws IOException
	{
	String BROWSER = putil.readDataFromPropertyFile("browser");
	String URL = putil.readDataFromPropertyFile("url");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	System.out.println("========"+BROWSER+"browser is launched successfully");
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println("========"+BROWSER+"browser is launched successfully");	
	}
	else 
	{
		System.out.println("========"+BROWSER+"browser is not launched successfully");
	}
	
	sdriver=driver;
	wutil.maximizeWindow(driver);
	wutil.waitForPageLoad(driver);
	driver.get(URL);
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegresssionSuite"})
	public void bmConfig() throws IOException
	{
	String USERNAME = putil.readDataFromPropertyFile("username");
	String PASSWORD = putil.readDataFromPropertyFile("password");
	LoginPage lp = new LoginPage(driver);
	lp.LoginApp(USERNAME, PASSWORD);
	System.out.println("========= login to app successfull =========");
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegresssionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.LogoutofApp(driver);
		System.out.println("========== logout app is successfull ==========");
		
	}
	
	@AfterTest
	//@AfterClass(groups = {"SmokeSuite","RegresssionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("========== browser is closed successfull ==========");
		
	}
    
	@AfterSuite(groups = {"SmokeSuite","RegresssionSuite"})
	public void asConfig()
	{
		
		System.out.println("========== data base is closed successfull ==========");
		
	}
	
	}
	
	


