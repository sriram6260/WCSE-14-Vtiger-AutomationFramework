package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice1 {
	
	@Test()
	public void createCustomerTest()
	{
		Assert.fail();
		System.out.println("create customer");
		
	}
	
	@Test(dependsOnMethods ="createCustomerTest" )
	public void modifyCustomerTest()
	{
		System.out.println("modify customer");
	}
	@Test(enabled = false)
	public void deleteCustomerTest()
	{
		System.out.println("delete customer");
	}
}
