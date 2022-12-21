package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to excel file
 * @author Sri Ram
 *
 */

public class ExcelFileUtility {
	
/**
 * This method will take value from excel sheet for respective sheetname,rowno and cellno
 * @param sheetname
 * @param rowno
 * @param colno
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
public String readDataFromExcel(String sheetname, int rowno, int colno) throws EncryptedDocumentException, IOException
{
	FileInputStream fis= new FileInputStream(IConstantsUtility.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	Row r = sh.getRow(rowno);
	Cell c = r.getCell(colno);
	String value=c.getStringCellValue();
	wb.close();
	return value;	
}

/**
 * This method will give the total row count
 * @param sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis= new FileInputStream(IConstantsUtility.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int rowcount = sh.getLastRowNum();
	return rowcount;	
}

/**
 * This method will write data into excel sheet
 * @param sheetname
 * @param rowno
 * @param cellno
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public void writeDataInExcel(String sheetname, int rowno, int cellno, String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis= new FileInputStream(IConstantsUtility.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	Row r = sh.getRow(rowno);
	Cell cc = r.createCell(cellno);
	cc.setCellValue(data);
	
	FileOutputStream fos = new FileOutputStream(IConstantsUtility.excelFilePath);
	wb.write(fos);
	wb.close();
}

/**
 * This method will read multiple data into the data provider
 * @param sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readMultipleDataIntoDataProvider(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantsUtility.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int lastrow=sh.getLastRowNum();
	int lastcell=sh.getRow(0).getLastCellNum();
	
	Object[][] data =new Object[lastrow][lastcell];
	for(int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;
	
}













}
