package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "mobiles")
	public void dataProviderPractice(String name, String model,int price,int quan)
	{
		System.out.println("test name"+" "+name+" "+model+" "+price+" "+quan);
	}
	
	@DataProvider(name="mobiles")
	public Object[][] getData()
	{
	Object[][] data = new Object[3][4];
	data[0][0]="samsung";
	data[0][1]="s10";
	data[0][2]=14000;
	data[0][3]=12;
	
	
	data[1][0]="iphone";
	data[1][1]="i12";
	data[1][2]=30000;
	data[1][3]=30;
	
	data[2][0]="nokia";
	data[2][1]="n13";
	data[2][2]=17000;
	data[2][3]=19;
	
	return data;
	
	}

}
