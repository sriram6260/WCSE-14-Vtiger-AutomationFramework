package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer =vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void retryPractice()
	{
		Assert.fail();
	System.out.println("run");	
	}
	
	@Ignore
	@Test(retryAnalyzer = vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void retryPractice1()
	{
	System.out.println("run1");	
	}
	

}
