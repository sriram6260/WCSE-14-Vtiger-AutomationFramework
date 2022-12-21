package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility { // rule 1
	
	//rule 2 : declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	 
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutLnk;
	
	// rule 3 : initialization
	 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// rule 4 : utilization
	
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignoutLnk() {
		return SignoutLnk;
	}
	
	
	// business logic
	/**
	 * This method will click on organization link in home page
	 */
	public void ClickonOrganizationLnk()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This method will click on contact link in home page
	 */
	public void ClickonContactsLnk()
	{
		ContactsLnk.click();

	}
	
	/**
	 * This method will sign out of App
	 * @param driver
	 */
	public void LogoutofApp(WebDriver driver)
	{
		mouseOverAction(driver,AdministratorImg);
		SignoutLnk.click();
	}
}

