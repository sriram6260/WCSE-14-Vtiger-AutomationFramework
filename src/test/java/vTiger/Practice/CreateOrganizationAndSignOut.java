package vTiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrganizationAndSignOut {

@Test
public void createOrganizationAndSignOut() throws InterruptedException
        {
		// launch the browser
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		//login to application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(10);
		//click on organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//click on create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(10);
		
		//create new organization with mandatory fields and click on save button
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("create");
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions m=new Actions(driver);
		m.moveToElement(ele).perform();
		Thread.sleep(10);
		driver.findElement(By.linkText("Sign Out")).click();
		
		}

	}


