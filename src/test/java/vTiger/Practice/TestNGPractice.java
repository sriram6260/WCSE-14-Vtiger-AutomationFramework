package vTiger.Practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount = 2,priority = 1)
	public void createCustomerTest()
	{
		System.out.println("create customer");
	}
	
	@Test(priority = -1)
	public void modifyCustomerTest()
	{
		System.out.println("modify customer");
	}
	@Test(priority = -2)
	public void deleteCustomerTest()
	{
		System.out.println("delete customer");
	}

}
