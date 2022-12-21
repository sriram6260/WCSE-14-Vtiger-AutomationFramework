package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sri Ram
 *
 */
public class LoginPage { //rule 1
	
	// rule 2 :declaration
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	// rule 3 : initialization
	
	public LoginPage (WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	// rule 4 : utilization

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	// rule 4 : business library
	/**
	 * This method will perform login application
	 * @param username
	 * @param password
	 */
	
	public void LoginApp(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}
	
	
	

}
