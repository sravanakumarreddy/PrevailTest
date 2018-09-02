package com.prevail.utilgeneric;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlTest;

import com.prevail.projectspec.CartFunctions;
import com.prevail.projectspec.CheckoutFunctions;
import com.prevail.projectspec.GlobalFunctions;
import com.prevail.projectspec.ProfileFunctions;
import com.prevail.projectspec.ShopnavFunctions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseTest{

	public static WebDriver driver;
	public static Locators l1;
	public static String c;

	public static ExtentReports extentReportIE;
	public static ExtentReports extentReportIE11;
	public static ExtentReports extentReportEdge;
	public static ExtentReports extentReportSafari;
	public static ExtentReports extentReportFF;
	public static ExtentReports extentReportChrome;
	public static ExtentReports extentReportAndroidPhone;
	public static ExtentReports extentReportAndroidTab;
	public static ExtentReports extentReportiPhone;
	public static ExtentReports extentReportiPad;
	public static ExtentTest extentTestIE;
	public static ExtentTest extentTestIE11;
	public static ExtentTest extentTestEdge;
	public static ExtentTest extentTestSafari;
	public static ExtentTest extentTestFF;
	public static ExtentTest extentTestChrome;
	public static ExtentTest extentTestAndroidPhone;
	public static ExtentTest extentTestAndroidTab;
	public static ExtentTest extentTestiPhone;
	public static ExtentTest extentTestiPad;
	public static ExtentTest extentTestChildIE;
	public static ExtentTest extentTestChildIE11;
	public static ExtentTest extentTestChildEdge;
	public static ExtentTest extentTestChildSafari;
	public static ExtentTest extentTestChildFF;
	public static ExtentTest extentTestChildChrome;
	public static ExtentTest extentTestChildAndroidPhone;
	public static ExtentTest extentTestChildAndroidTab;
	public static ExtentTest extentTestChildiPhone;
	public static ExtentTest extentTestChildiPad;
	public static Logger log;
	public static SoftAssert sa;
	public static ProfileFunctions p;
	public static Actions act;
	public int i;
	public static ShopnavFunctions s;
	public static CartFunctions cart;
	public static CheckoutFunctions checkout;
	public static GlobalFunctions gVar;
	public static XmlTest xmlTest;
	
	@BeforeSuite
	public void cleanUp(XmlTest xmlTest)
	{
		//delete log directory
		try
		{
		FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"//log"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Leave it");
		}
		xmlTest=xmlTest;
	}
	
	@BeforeClass
	public void initialize(XmlTest xmlTest) throws Exception
	{
		
		BaseTest.xmlTest=xmlTest;
		if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {
			//Report declaration code 
			extentReportIE = new ExtentReports("\\SelFrameWork\\MyReportIE.html", false);
			extentReportIE.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
			extentTestIE=extentReportIE.startTest(this.getClass().getSimpleName());
			
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("firefox")) {
			extentReportFF = new ExtentReports("\\SelFrameWork\\MyReportFF.html", false);
			extentReportFF.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
			extentTestFF=extentReportFF.startTest(this.getClass().getSimpleName());
			
			}else if(xmlTest.getParameter("broName").equalsIgnoreCase("chrome")) {
				extentReportChrome = new ExtentReports("\\SelFrameWork\\MyReportChrome.html", false);
				extentReportChrome.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
				extentTestChrome=extentReportChrome.startTest(this.getClass().getSimpleName());
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Edge")) {
				extentReportEdge = new ExtentReports("\\SelFrameWork\\MyReportEdge.html", false);
				extentReportEdge.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
				extentTestEdge=extentReportEdge.startTest(this.getClass().getSimpleName());
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Safari")) {
				extentReportSafari = new ExtentReports("\\SelFrameWork\\MyReportSafari.html", false);
				extentReportSafari.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
				extentTestSafari=extentReportSafari.startTest(this.getClass().getSimpleName());
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
				extentReportAndroidPhone = new ExtentReports("\\SelFrameWork\\MyReportAP.html", false);
				extentReportAndroidPhone.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
				extentTestAndroidPhone=extentReportAndroidPhone.startTest(this.getClass().getSimpleName());
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
				extentReportAndroidTab = new ExtentReports("\\SelFrameWork\\MyReportAT.html", false);
				extentReportAndroidTab.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
				extentTestAndroidTab=extentReportAndroidTab.startTest(this.getClass().getSimpleName());
				
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
				extentReportiPhone = new ExtentReports("\\SelFrameWork\\MyReportiPhone.html", false);
				extentReportiPhone.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
				extentTestiPhone=extentReportiPhone.startTest(this.getClass().getSimpleName());
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
				extentReportiPad = new ExtentReports("\\SelFrameWork\\MyReportiPad.html", false);
				extentReportiPad.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml"));
				extentTestiPad=extentReportiPad.startTest(this.getClass().getSimpleName());
			}
		
		System.out.println(driver);
		driver=new GetDriver().getDriver(xmlTest);
		gVar=new GlobalFunctions(driver);
		gVar.navigateToSite(xmlTest);
		
		if (xmlTest.getParameter("broName").equalsIgnoreCase("firefox")){
			Dimension d = new Dimension(1024,768);
			//Resize the current window to the given dimension
			driver.manage().window().setSize(d);
		}
		else{
			driver.manage().window().maximize();	
		}
		log=Logger.getLogger(this.getClass().getName());
		act=new Actions(driver);
	}
	
	@BeforeMethod
	public void extReport(Method m,XmlTest xmlTest)
	{
		if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {			
			extentTestChildIE=extentReportIE.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestIE.appendChild(extentTestChildIE);
			l1=new Locators(driver,extentTestChildIE, xmlTest);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("firefox")) {			
			extentTestChildFF=extentReportFF.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestFF.appendChild(extentTestChildFF);
			l1=new Locators(driver,extentTestChildFF,xmlTest);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("chrome")) {					
			extentTestChildChrome=extentReportChrome.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestChrome.appendChild(extentTestChildChrome);
			l1=new Locators(driver,extentTestChildChrome,xmlTest);
					
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Edge")) {					
			extentTestChildEdge=extentReportEdge.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestEdge.appendChild(extentTestChildEdge);
			l1=new Locators(driver,extentTestChildEdge,xmlTest);
					
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Safari")) {					
			extentTestChildSafari=extentReportSafari.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestSafari.appendChild(extentTestChildSafari);
			l1=new Locators(driver,extentTestChildSafari,xmlTest);
					
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {			
			extentTestChildAndroidPhone=extentReportAndroidPhone.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestAndroidPhone.appendChild(extentTestChildAndroidPhone);
			l1=new Locators(driver, extentTestChildAndroidPhone, xmlTest);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
			extentTestChildAndroidTab=extentReportAndroidTab.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestAndroidTab.appendChild(extentTestChildAndroidTab);
			l1=new Locators(driver, extentTestChildAndroidTab, xmlTest);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
			extentTestChildiPhone=extentReportiPhone.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestiPhone.appendChild(extentTestChildiPhone);
			l1=new Locators(driver, extentTestChildiPhone, xmlTest);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
			extentTestChildiPad=extentReportiPad.startTest(m.getName()+" "+driver.getClass().getSimpleName());
			extentTestiPad.appendChild(extentTestChildiPad);
			l1=new Locators(driver, extentTestChildiPad, xmlTest);
			
		}
		sa=new SoftAssert();
		log.info("Test Case "+m.getName()+"Started in "+driver.getClass().getSimpleName()+"driver");
		log.info("-------------------------------------------");
		p=new ProfileFunctions();
		s=new ShopnavFunctions();
		cart = new CartFunctions();
		checkout=new CheckoutFunctions();

	}
	
	@AfterMethod
	public void endTest(Method m,XmlTest xmlTest)
	{
		log.info("Test Case "+m.getName()+"ended in "+driver.getClass().getSimpleName()+"driver");
		log.info("-------------------------------------------");
/*		if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {
			
			extentReportIE.endTest(extentTestIE);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("firefox")) {
			
			extentReportFF.endTest(extentTestFF);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
			
			extentReportAndroidPhone.endTest(extentTestAndroidPhone);
		}*/
	}
	
	@AfterTest
	public void endTest(XmlTest xmlTest)
	{
		if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {
			//extentTestIE.appendChild(extentTestChildIE);
			extentReportIE.endTest(extentTestIE);
			extentReportIE.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("firefox")) {
			//extentTestFF.appendChild(extentTestChildFF);
			extentReportFF.endTest(extentTestFF);
			extentReportFF.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Chrome")) {
			//extentTestChrome.appendChild(extentTestChildChrome);
			extentReportChrome.endTest(extentTestChrome);
			extentReportChrome.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Edge")) {
			//extentTestEdge.appendChild(extentTestChildEdge);
			extentReportEdge.endTest(extentTestEdge);
			extentReportEdge.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Safari")) {
			//extentTestSafari.appendChild(extentTestChildSafari);
			extentReportSafari.endTest(extentTestSafari);
			extentReportSafari.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
			//extentTestAndroidPhone.appendChild(extentTestChildAndroidPhone);
			extentReportAndroidPhone.endTest(extentTestAndroidPhone);
			extentReportAndroidPhone.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
			//extentTestAndroidPhone.appendChild(extentTestChildAndroidPhone);
			extentReportAndroidTab.endTest(extentTestAndroidTab);
			extentReportAndroidTab.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
			//extentTestAndroidPhone.appendChild(extentTestChildAndroidPhone);
			extentReportiPhone.endTest(extentTestiPhone);
			extentReportiPhone.flush();
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
			//extentTestAndroidPhone.appendChild(extentTestChildAndroidPhone);
			extentReportiPad.endTest(extentTestiPad);
			extentReportiPad.flush();
		}
	}
	
	@AfterSuite
	public void tearDown(XmlTest xmlTest) throws IOException
	{
		new GetDriver().closeDriver();
		
		//move log files
		String str=new Date().getDate()+" "+new Date().getMonth()+" "+new Date().getYear()+" "+new Date().getHours()+" "+new Date().getMinutes()+" "+new Date().getSeconds();
		System.out.println("str"+str);
		new File("C:\\Prevail Reports\\HTML\\Results "+str).mkdirs();
		File source = new File(System.getProperty("user.dir")+"\\log");
		File dest = new File("C:\\Prevail Reports\\HTML\\Results "+str);
		try {
		    FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
/*
		try {
			Process p=Runtime.getRuntime().exec("cmd /c start "+System.getProperty("user.dir")+"\\Sel_Report.bat");
			p.waitFor();
		} catch (IOException e) {
			System.out.println("catch block");
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

	}
	
	@DataProvider
	public Object[][] PassData()
	{
		Object[][] data = new Object[3][2];
		
		return data;
	}
}
