package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {

@Test
public void propertyFilePractice() throws IOException
  {
		
		//load the file location into file input stream
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//create object of properties from java.util package
		Properties prop = new Properties();
		
		//load file input stream into properties
		prop.load(fis);
		
		//read the value using key
		String keyvalue=prop.getProperty("browser");
		
		//print the keyvalue
		System.out.println(keyvalue);
 
	}

}
