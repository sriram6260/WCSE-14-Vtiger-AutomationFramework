package vTiger.Practice;

import java.io.IOException;

import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {


     @Test 
     public void genericUtilityPractice() throws IOException
	{
		
		PropertyFileUtility puti=new PropertyFileUtility();
		String s=puti.readDataFromPropertyFile("url");
		System.out.println(s);
		
		ExcelFileUtility Eutil=new ExcelFileUtility();
		String value=Eutil.readDataFromExcel("organizations", 1, 2);
		System.out.println(value);
		 int count = Eutil.getRowCount("organizations");
		 System.out.println(count);
		 
		 Eutil.writeDataInExcel("organizations", 1, 6, "sriram");
		 
		 //getrandomnumber
		 JavaUtility jutil = new JavaUtility();
		 {
			 System.out.println(jutil.getRandomNumber());
		 }
		 
		 //getsystemdate
		
		System.out.println(jutil.getSystemDate());
		 
		 //
		// getsystemdateinformat
		System.out.println(jutil.getSystemDateInFormat());
		
		
	}
			
	
}
