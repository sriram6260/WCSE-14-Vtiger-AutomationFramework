package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationAndSelectHealthcateInIndustryDropDown {

	
	
	@Test
	public void createOrganizationAndSelectHealthcateInIndustryDropDown() throws InterruptedException
       {
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(10);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(10);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("create organization");
		
		WebElement element=driver.findElement(By.xpath("//select[@name='industry']"));
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element1=driver.findElement(By.xpath("//option[@value='Chemicals']"));
		element1.click();
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
}
}