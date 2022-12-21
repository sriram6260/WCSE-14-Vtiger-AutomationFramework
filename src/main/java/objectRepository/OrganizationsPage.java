package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImage;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpImage() {
		return CreateOrgLookUpImage;
	}
	
	// business logic
	/**
	 * This method click on create organization look up image
	 */
	public void ClickOnOrganizationLookupImg()
	{
	CreateOrgLookUpImage.click();	
	}
	
	

}
