package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelSheetPractice {

	@Test
	public void excelSheetPractice() throws EncryptedDocumentException, IOException
	{
		
		//load file location into file input stream
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\DataDriven.xlsx");
		
		// create a work book
	
		  Workbook wb = WorkbookFactory.create(fis);
		
		// navigate to required sheet
		  
		Sheet sh=wb.getSheet("organizations");
		
		//navigate to required row
		
		Row r=sh.getRow(3);
		
		//navigate to required cell
		
		Cell c=r.getCell(3);
		
		//capture the data in that particular cell
		
	String str=	c.getStringCellValue();
	
	System.out.println(str);

	}
}




