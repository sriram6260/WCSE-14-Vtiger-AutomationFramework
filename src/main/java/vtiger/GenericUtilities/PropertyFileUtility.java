package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods related to property file
 * @author Sri Ram
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This generic method will read the key from property file and return the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties pr= new Properties();
		pr.load(fis);
		String value=pr.getProperty(key);
		return value;
	}

}
