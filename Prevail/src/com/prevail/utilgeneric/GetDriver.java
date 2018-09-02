package com.prevail.utilgeneric;

//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;


public class GetDriver {
	
	public static WebDriver driver;
	String driverName;
	
	private static Map<String,WebDriver> drivers=new HashMap<String, WebDriver>();
	
	public WebDriver getDriver(XmlTest xmlTest) throws MalformedURLException, InterruptedException
	{
		try
		{
		if(drivers.get(xmlTest.getParameter("broName").toLowerCase())==null)
		{
			if(xmlTest.getParameter("broName").equalsIgnoreCase("Firefox"))
			{
				DesiredCapabilities des=DesiredCapabilities.firefox();
				des.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				des.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
				des.setCapability("acceptInsecureCerts", true);
				des.setCapability("requireWindowFocus", true);
				//des.setPlatform(Platform.WIN8_1);
				if(xmlTest.getParameter("GridExecution").equalsIgnoreCase("false"))
				{
					System.out.println("came here FF");
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
				driver=new FirefoxDriver(des);
				}
				else
				{
					driver=new RemoteWebDriver(new URL(xmlTest.getParameter("GridURL")),des);
				}
				System.out.println("came here FF");
			}
			else if(xmlTest.getParameter("broName").equalsIgnoreCase("Chrome"))
			{
				DesiredCapabilities des=DesiredCapabilities.chrome();
				des.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				des.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
				//des.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR,ElementScrollBehavior.BOTTOM);
				des.setPlatform(Platform.VISTA);
				
				if(xmlTest.getParameter("GridExecution").equalsIgnoreCase("false"))
				{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				driver=new ChromeDriver(des);
   			}
				else
				{
					driver=new RemoteWebDriver(new URL(xmlTest.getParameter("GridURL")),des);
				}
				System.out.println("came here chrome");
			}
			else if(xmlTest.getParameter("broName").equalsIgnoreCase("IE"))
			{
				DesiredCapabilities des=DesiredCapabilities.internetExplorer();
				des.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				des.setCapability("ie.forceCreateProcessApi ",true);
				des.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				des.setCapability("ELEMENT_SCROLL_BEHAVIOR", ElementScrollBehavior.BOTTOM);
				des.setCapability("ENABLE_ELEMENT_CACHE_CLEANUP",true);
				des.setCapability("requireWindowFocus", true);
				des.setCapability("IE_ENSURE_CLEAN_SESSION",true);
				//des.setCapability("requireWindowFocus", true);
				des.setPlatform(Platform.VISTA);
				
				if(xmlTest.getParameter("GridExecution").equalsIgnoreCase("false"))
				{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");	
				driver=new InternetExplorerDriver(des);
				}
				else
				{
					driver=new RemoteWebDriver(new URL(xmlTest.getParameter("GridURL")),des);
				}
				System.out.println("came here ie");
			}
			else if(xmlTest.getParameter("broName").equalsIgnoreCase("Edge"))
			{
				DesiredCapabilities des=DesiredCapabilities.edge();
				des.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				if(xmlTest.getParameter("GridExecution").equalsIgnoreCase("false"))
				{
				System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver.exe");
				driver=new EdgeDriver(des);
				}
				else
				{
					driver=new RemoteWebDriver(new URL(xmlTest.getParameter("GridURL")),des);
				}
				System.out.println("came here edge");
			}
			else if(xmlTest.getParameter("broName").equalsIgnoreCase("Safari"))
			{
				driver=new SafariDriver();
			}
			else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone"))
			{
				Map<String, Object> deviceMetrics = new HashMap<String, Object>();
				deviceMetrics.put("width", 360);
				deviceMetrics.put("height", 640);
				deviceMetrics.put("pixelRatio", 3.0);
				
				Map<String, Object> mobileEmulation = new HashMap<String, Object>();
				mobileEmulation.put("deviceMetrics", deviceMetrics);
				mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 6.0.1; SM-G920V Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
				
				Map<String, Object> chromeOption = new HashMap<String, Object>();
				chromeOption.put("mobileEmulation", mobileEmulation);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOption);
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				driver = new ChromeDriver(capabilities);
			}
			/*else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab"))
			{
				Map<String, Object> deviceMetrics = new HashMap<String, Object>();
				deviceMetrics.put("width", 1024);
				deviceMetrics.put("height", 768);
				deviceMetrics.put("pixelRatio", 3.0);
				
				Map<String, Object> mobileEmulation = new HashMap<String, Object>();
				mobileEmulation.put("deviceMetrics", deviceMetrics);
				mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 6.0.1; SM-T550 Build/MMB29M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 YaBrowser/16.10.2.1487.01 Safari/537.36");
				
				Map<String, Object> chromeOption = new HashMap<String, Object>();
				chromeOption.put("mobileEmulation", mobileEmulation);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOption);
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				driver = new ChromeDriver(capabilities);
			}*/
			
			/*
			else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone"))
			{
				DesiredCapabilities des=new DesiredCapabilities();
				des.setCapability("platfromName","IOS");
				des.setCapability("platformVersion", "11");
				des.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
				des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
				des.setCapability("deviceName", "iPhone");
				driver=new IOSDriver(new URL("http:0.0.0.0:4723/wd/hub"), des);
			}*/
			/*
			else if(xmlTest.getParameter("broName").equalsIgnoreCase("iOSTab"))
			{
				DesiredCapabilities des=new DesiredCapabilities();
				des.setCapability("platfromName","IOS");
				des.setCapability("platformVersion", "11");
				des.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
				des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
				des.setCapability("deviceName", "iPad");
				driver=new IOSDriver(new URL("http:0.0.0.0:4723/wd/hub"), des);
			}*/
		}
		drivers.put(xmlTest.getParameter("broName").toLowerCase(), driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}
	
	
	public void closeDriver()
	{
		System.out.println(drivers.size());
		for(String str:drivers.keySet())
		{
			drivers.get(str).quit();
		}
	}

}
