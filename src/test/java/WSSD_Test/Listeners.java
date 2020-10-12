package WSSD_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import WSSD.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
	 test= extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);

	}

	
	public void onTestSuccess(ITestResult arg0) {
		
		extentTest.get().log(Status.PASS, "Test Passed");

	}
	
	public void onTestFailure(ITestResult result) {
		
		
		extentTest.get().fail(result.getThrowable());
		
		// code to capture screenshot		
		WebDriver driver=null;
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			
		}
			
	
			try {
				extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());		
				
				//getScreenShotPath(testMethodName,driver);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		
		
	}

	public void onFinish(ITestContext arg0) {

		extent.flush();

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	
	



}
