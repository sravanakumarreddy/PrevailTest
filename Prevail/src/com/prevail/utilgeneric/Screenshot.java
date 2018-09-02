package com.prevail.utilgeneric;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Screenshot implements ITestListener{
	
	WebDriver driver;
	Method m;
	XmlTest xmlTest;
	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		 driver=BaseTest.driver;		 
		 xmlTest=BaseTest.xmlTest;
		 
		 if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {
			 BaseTest.extentTestChildIE.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("firefox")) {
			 BaseTest.extentTestChildFF.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("chrome")) {
			 BaseTest.extentTestChildChrome.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Edge")) {
			 BaseTest.extentTestChildEdge.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Safari")) {
			 BaseTest.extentTestChildSafari.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
			 BaseTest.extentTestChildAndroidPhone.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
			 BaseTest.extentTestChildAndroidTab.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
			 BaseTest.extentTestChildiPhone.log(LogStatus.PASS,"");
			
		 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
			 BaseTest.extentTestChildiPad.log(LogStatus.PASS,"");
			
		 }
	}

	public void onTestFailure(ITestResult result) {
		
		try{
			driver=GetDriver.driver;
			xmlTest=BaseTest.xmlTest;
			String imgName=result.getInstanceName()+" "+result.getMethod().getMethodName()+" "+driver.getClass().getSimpleName();
			//write take screen shot code
			 
			System.out.println(driver.getClass().getName());
			System.out.println("on failure");
			//((JavascriptExecutor) driver).executeScript("window.focus();");
			
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			FileUtils.copyFile(scrShot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
			
			if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {
				BaseTest.extentTestChildIE.log(LogStatus.FAIL,"",BaseTest.extentTestChildIE.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("firefox")) {
					BaseTest.extentTestChildFF.log(LogStatus.FAIL, "",BaseTest.extentTestChildFF.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("chrome")) {
					BaseTest.extentTestChildChrome.log(LogStatus.FAIL, "",BaseTest.extentTestChildChrome.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Edge")) {
					BaseTest.extentTestChildEdge.log(LogStatus.FAIL, "",BaseTest.extentTestChildEdge.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Safari")) {
					BaseTest.extentTestChildSafari.log(LogStatus.FAIL, "",BaseTest.extentTestChildSafari.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
					BaseTest.extentTestChildAndroidPhone.log(LogStatus.FAIL, "",BaseTest.extentTestChildAndroidPhone.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
					BaseTest.extentTestChildAndroidTab.log(LogStatus.FAIL, "",BaseTest.extentTestChildAndroidTab.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
					BaseTest.extentTestChildiPhone.log(LogStatus.FAIL, "",BaseTest.extentTestChildiPhone.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
					BaseTest.extentTestChildiPad.log(LogStatus.FAIL, "",BaseTest.extentTestChildiPad.addScreenCapture(System.getProperty("user.dir")+"\\log\\"+imgName+".png"));
				
			 }
			
		}
		catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("error bro here");
			}
	}

	public void onTestSkipped(ITestResult result) {
		
	//	extentTest.log(LogStatus.SKIP, "Its skipped bro please check the reason");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {

	//	extentReport.flush();
		
	}
}
