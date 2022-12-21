package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgnameEdtElement() {
		return orgnameEdt;
	}


	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	// business logic
	/**
	 * This method will create organization with mandatory details
	 * @param orgname
	 */
	
	public void CreateNewOrganization(String orgname)
	{
		orgnameEdt.sendKeys(orgname);
		SaveBtn.click();	
	}
	
	/**
	 * This method will create new organization with industry drop down
	 * @param orgname
	 * @param IndustryType
	 */
	
	public void CreateNewOrganization(String orgname, String IndustryType)
	{
		orgnameEdt.sendKeys(orgname);
		handleDropDown(IndustryDropDown, IndustryType);
		SaveBtn.click();	
	}
	

}
