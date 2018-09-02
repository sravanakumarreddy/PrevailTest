package com.prevail.utilgeneric;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.prevail.projectspec.GlobalFunctions;
import com.prevail.projectspec.ProfileFunctions;
import com.prevail.projectspec.ShopnavFunctions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GlobalVariables {
	
	public WebDriver driver;
	public Locators l1;
	public String c;
	public static ExtentReports extentReportIE;
	public static ExtentReports extentReportFF;
	public static ExtentReports extentReportChrome;
	public static ExtentReports extentReportAndroidPhone;
	public static ExtentTest extentTestIE;
	public static ExtentTest extentTestFF;
	public static ExtentTest extentTestChrome;
	public static ExtentTest extentTestAndroidPhone;
	public static ExtentTest extentTestChildIE;
	public static ExtentTest extentTestChildFF;
	public static ExtentTest extentTestChildChrome;
	public static ExtentTest extentTestChildAndroidPhone;
	public Logger log;
	public SoftAssert sa;
	public ProfileFunctions p;
	public Actions act;
	public int i;
	public ShopnavFunctions s;
	public GlobalFunctions gVar;
}

