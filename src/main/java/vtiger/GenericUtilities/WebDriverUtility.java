package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains generic methods related to webdriver actions
 * @author Sri Ram
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method is used for maximize the window 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used for minimize the window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for entire page to load for 20 seconds
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver)
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method is used to wait for a element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * This is a custom wait for a second to wait for element to become clickable
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void customWaitForSecond(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<5)
		{
			try {
				
				element.click();
				break;
				
			} 
			catch (Exception e) {
				
				Thread.sleep(1000);
				count++;
				
			}
		}
	}
	
	/**
	 * This method will handle drop down based on index value
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element, int index)
	{
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down based on value
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element, String value)
	{
		Select sel =new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down based on visible text
	 * @param visibleText
	 * @param element
	 */
	
	public void handleDropDown(String visibleText, WebElement element)
	{
		Select sel =new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will perform mouse over action
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform mouse over action based on offset
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	
	public void mouseOverAction(WebDriver driver, WebElement element,int x,int y)
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform right click randomly on web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will drag and drop from source element to target element
	 * @param driver
	 * @param srcElement
	 * @param tarElement
	 */
	
	public void dragAndDropAction(WebDriver driver, WebElement srcElement,WebElement tarElement)
	{
		Actions act =new Actions(driver);
		act.dragAndDrop(srcElement,tarElement).perform();
	}
	
	/**
	 * This method will press and release the enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	
	public void swithToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame based on name or ID
	 * @param driver
	 * @param nameOrID
	 */
	
	public void swithToFrame(WebDriver driver,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param element
	 */
	
	public void swithToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	
	public void swithToFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	
	public void scrollAction (WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	/**
	 * This method will scroll until a particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction (WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	/**
	 * This method will take the screenshot and save it in screenshot folder
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	
	public String takeTheScreenShot(WebDriver driver, String screenshotname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\"+screenshotname+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath(); // used for extend reports
		
	}
	
	/**
	 * This method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String indWindow:allWindows)
		{
			String currentWinTitle=driver.switchTo().window(indWindow).getTitle();
			if(partialWinTitle.contains(currentWinTitle))
			{
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
}
