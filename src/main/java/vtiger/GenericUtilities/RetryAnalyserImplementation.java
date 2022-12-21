package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This is implementation class for Iretryanalyser interface of TestNG
 * @author Sri Ram
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	/**
	 * This method will retry the failed test scripts for retrycount
	 */
	int count=0,retrycount=3;
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
		count++;
		return true;
	}
	return false;
}
}