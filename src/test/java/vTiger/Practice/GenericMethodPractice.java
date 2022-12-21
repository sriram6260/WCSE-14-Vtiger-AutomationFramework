package vTiger.Practice;

import org.testng.annotations.Test;

public class GenericMethodPractice {

	@Test
	public void genericMethodPractice()
	
	{
		int d=add(2, 7);
		System.out.println(d);
	}
	
	public static int add(int a, int b)
	{
	int c=a+b;
	return c;

	}

}
