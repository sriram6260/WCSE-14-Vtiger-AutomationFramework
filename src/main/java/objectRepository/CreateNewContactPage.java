package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	
	//declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath=" // input[@name='account_name']/following-sibling:: img[@src='themes/softed/images/select.gif']")
	private WebElement organizationImg;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "// input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}



	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}



	public WebElement getOrganizationImg() {
		return organizationImg;
	}



	public WebElement getSearchEdt() {
		return SearchEdt;
	}



	public WebElement getSearchBtn() {
		return SearchBtn;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}

/**
 * This method will create new contact with last name
 * @param lastname
 */

	//business logic
	public void CreateNewContact(String lastname)
	{
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	
	/**
	 * This method will create contact with lastname and organization
	 * @param lastname
	 * @param Orgname
	 * @param driver
	 */
	public void CreateNewContact(String lastname,String Orgname,WebDriver driver)
	{
		lastNameEdt.sendKeys(lastname);
		organizationImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(Orgname);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
}
