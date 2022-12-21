package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	// declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookupImg;
	
	//initialization
	public ContactsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	
	//business logic
	/**
	 * This method will click on create contact look up image
	 */
	public void ClickonCreateContactImg()
	{
		createContactLookupImg.click();
		
	}
	
	

}
