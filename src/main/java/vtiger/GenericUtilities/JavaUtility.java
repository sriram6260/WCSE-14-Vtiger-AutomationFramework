package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of java specific methods
 * @author Sri Ram
 *
 */


public class JavaUtility {
	
	/**
	 * This method will generate random number
	 * @return
	 */
	public int getRandomNumber()
	{
	Random ran= new Random();
		return ran.nextInt(1000);
	}
	
	/**
	 * This method will generate current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
		
	}
	
	/**
	 * This method will generate current system date in specific format
	 * @return
	 */
	
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] darr = d.toString().split(" ");
		String date=darr[2];
		String month=darr[1];
		String year=darr[5];
		String time=darr[3].replace(":", "-");
		return date+" "+month+" "+year+" "+time;
		
	}
	
	
}
