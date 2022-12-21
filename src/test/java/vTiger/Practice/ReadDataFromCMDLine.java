package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCMDLine {
	
	@Test
	public void ReadData()
	{
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		//System.out.println();
	}

}
