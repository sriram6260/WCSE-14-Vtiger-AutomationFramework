package vTiger.OrganizationsTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepository.LoginPage;

public class POMPractice {

	public static void main(String[] args) {
		
		//launch the browser
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		//login to application
		LoginPage ip = new LoginPage(driver);
		/*
		 * ip.getUsernameEdt().sendKeys("admin"); ip.getPasswordEdt().sendKeys("admin");
		 * ip.getSubmitBtn().click();
		 */
		ip.LoginApp("admin", "admin");

	}

}
