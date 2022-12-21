package vtiger.GenericUtilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class porvides implementation to the ItestListener interface of TestNG
 * @author Sri Ram
 *
 */

public class ListenerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
        test = report.createTest(methodname);

		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+" success");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		String methodname = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodname+" -> fail");
		test.log(Status.FAIL, result.getThrowable());
		
		String takethescreenshot = methodname+" "+jutil.getSystemDateInFormat();
		try {
			String path = wutil.takeTheScreenShot(BaseClass.sdriver, takethescreenshot);
			test.addScreenCaptureFromPath(path);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+ " skipped");
		test.log(Status.SKIP, result.getThrowable());
		


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub


	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(" execution started");
		
		//create object of extent spark reporter class
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\report - "+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("execution report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("vtiger execution report");
		
		//attach html report to extent report
	     report = new ExtentReports();
	    report.attachReporter(htmlreport);
	    report.setSystemInfo("base platform", "windows");
	    report.setSystemInfo("base browser", "chrome");
	    report.setSystemInfo("base environment", "testing");
	    report.setSystemInfo("base URL", "http://localhost:8888");
	    report.setSystemInfo("author", "sriram");
	    
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("execution finished");
		
		//flush the report - consolidate the status of every test script and generate the 
		//report
		report.flush();
		
	}
	
	

}
