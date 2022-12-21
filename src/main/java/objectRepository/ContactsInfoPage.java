package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	//declaration
	@FindBy(xpath = "// span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//business library
	/**
	 * This method will get the header text and return to the caller
	 * @return
	 */
	
	public String getContactHeader()
	{
		return contactHeaderText.getText();
	}
	
	
	
}
