package com.prevail.utilgeneric;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Locators{

	WebDriver driver;
	By by;
	public WebElement wb;
	Logger log;
	ExtentTest extentTestChildIE;
	ExtentTest extentTestChildFF;
	ExtentTest extentTestChildChrome;
	ExtentTest extentTestChildEdge;
	ExtentTest extentTestChildSafari;
	ExtentTest extentTestChildAndroidPhone;
	ExtentTest extentTestChildAndroidTab;
	ExtentTest extentTestChildiPhone;
	ExtentTest extentTestChildiPad;
	XmlTest xmlTest;
	Select sel; 
	
	public Locators(WebDriver driver,ExtentTest extentTest,XmlTest xmlTest)
	{
		this.driver=driver;
		this.xmlTest=xmlTest;
		
		if(driver.getClass().getSimpleName().equalsIgnoreCase("InternetExplorerDriver")) {
			extentTestChildIE=extentTest;
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("FirefoxDriver")) {
			extentTestChildFF=extentTest;
		
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("ChromeDriver")) {
			extentTestChildChrome=extentTest;	
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("MicrosoftWebDriver")) {
			extentTestChildEdge=extentTest;	
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("SafariDriver")) {
			extentTestChildSafari=extentTest;	
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
			extentTestChildAndroidPhone=extentTest;
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
			extentTestChildAndroidTab=extentTest;
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
			extentTestChildiPhone=extentTest;
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
			extentTestChildiPad=extentTest;
		}
	}
	
	public By getLocators(String loc1,String filename) throws Exception
	{
		
		String str=GetData.getDataFromProperties("//POM//"+filename, loc1);
		String[] loc=str.split(";");
		
		if(loc[0].equalsIgnoreCase("id"))
		{
			by=By.id(loc[1]);
		}
		else if(loc[0].equalsIgnoreCase("csslocator"))
		{
			by=By.cssSelector(loc[1]);
		}
		else if(loc[0].equalsIgnoreCase("name"))
		{
			by=By.name(loc[1]);
		}
		else if(loc[0].equalsIgnoreCase("class"))
		{
			by=By.className(loc[1]);
		}
		else if(loc[0].equalsIgnoreCase("xpath"))
		{
			by=By.xpath(loc[1]);
		}
		else if(loc[0].equalsIgnoreCase("linktext"))
		{
			by=By.linkText(loc[1]);
			System.out.println(loc[1]);
		}
		else if(loc[0].equalsIgnoreCase("partiallinktext"))
		{
			by=By.partialLinkText(loc[1]);
		}
		else if(loc[0].equalsIgnoreCase("tagname"))
		{
			by=By.tagName(loc[1]);
		}
		
		System.out.println(by);
		
		try
		{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		Thread.sleep(100);
		
		if(driver.getClass().getSimpleName().equalsIgnoreCase("InternetExplorerDriver")) {
			extentTestChildIE.log(LogStatus.PASS, ""+by);
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("Firefoxdriver")) {
			extentTestChildFF.log(LogStatus.PASS, ""+by);
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("Chromedriver")) {
			extentTestChildChrome.log(LogStatus.PASS, ""+by);
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("MicrosoftWebDriver")) {
			extentTestChildEdge.log(LogStatus.PASS, ""+by);
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("SafariDriver")) {
			extentTestChildSafari.log(LogStatus.PASS, ""+by);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
			extentTestChildAndroidPhone.log(LogStatus.PASS, ""+by);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
			extentTestChildAndroidTab.log(LogStatus.PASS, ""+by);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
			extentTestChildiPhone.log(LogStatus.PASS, ""+by);
			
		} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
			extentTestChildiPad.log(LogStatus.PASS, ""+by);
		}
		
		} catch(Exception e) {
			
			if(driver.getClass().getSimpleName().equalsIgnoreCase("InternetExplorerDriver")) {
				extentTestChildIE.log(LogStatus.FAIL, ""+by);
				
			} else if(driver.getClass().getSimpleName().equalsIgnoreCase("Firefoxdriver")) {
				extentTestChildFF.log(LogStatus.FAIL, ""+by);
				
			} else if(driver.getClass().getSimpleName().equalsIgnoreCase("Chromedriver")) {
				extentTestChildChrome.log(LogStatus.FAIL, ""+by);
				
			} else if(driver.getClass().getSimpleName().equalsIgnoreCase("MicrosoftWebDriver")) {
				extentTestChildEdge.log(LogStatus.FAIL, ""+by);
				
			} else if(driver.getClass().getSimpleName().equalsIgnoreCase("SafariDriver")) {
				extentTestChildSafari.log(LogStatus.FAIL, ""+by);
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
				extentTestChildAndroidPhone.log(LogStatus.FAIL, ""+by);
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
				extentTestChildAndroidTab.log(LogStatus.FAIL, ""+by);
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
				extentTestChildiPhone.log(LogStatus.FAIL, ""+by);
				
			} else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
				extentTestChildiPad.log(LogStatus.FAIL, ""+by);
			}
			
		}
		
		return by;
	}
	
	public WebElement getWebElement(String loc1,String filename) throws Exception 
	{
		wb=driver.findElement(getLocators(loc1, filename));
		if(driver.getClass().getSimpleName().equalsIgnoreCase("ChromeDriver") || driver.getClass().getSimpleName().equalsIgnoreCase("SafariDriver"))
		{
			try
			{
			if(!isElementInViewPort(wb))
			{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wb);
			Thread.sleep(500); 
			}
			else
			{
				System.out.println("not here");
			}
			}
			catch(Exception e)
			{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wb);
			Thread.sleep(500); 
			}
		}
		return wb;
	}
	
	public WebElement getWebElement(By by) throws Exception 
    {
           //wb=driver.findElement(getLocators(loc1, filename));
           
           try
           {
           
           if(xmlTest.getParameter("broName").equalsIgnoreCase("ie"))
           {
                  WebDriverWait wait=new WebDriverWait(driver, 20);
                  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                  wait.until(ExpectedConditions.elementToBeClickable(by));
                  Thread.sleep(1000);
                  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           }else {
                  WebDriverWait wait=new WebDriverWait(driver, 10);
                  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                  wait.until(ExpectedConditions.elementToBeClickable(by));
                  Thread.sleep(100);
           }
           
           if(driver.getClass().getSimpleName().equalsIgnoreCase("InternetExplorerDriver")) {
                  extentTestChildIE.log(LogStatus.PASS, ""+by);
                  
           } else if(driver.getClass().getSimpleName().equalsIgnoreCase("Firefoxdriver")) {
                  extentTestChildFF.log(LogStatus.PASS, ""+by);
                  
           } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
                  extentTestChildAndroidPhone.log(LogStatus.PASS, ""+by);
                  
           } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
                  extentTestChildAndroidTab.log(LogStatus.PASS, ""+by);
                  
           } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
                  extentTestChildiPhone.log(LogStatus.PASS, ""+by);
                  
           } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
                  extentTestChildiPad.log(LogStatus.PASS, ""+by);
           }
           
           } catch(Exception e) {
                  
                  if(driver.getClass().getSimpleName().equalsIgnoreCase("InternetExplorerDriver")) {
                        extentTestChildIE.log(LogStatus.FAIL, ""+by);
                        
                  } else if(driver.getClass().getSimpleName().equalsIgnoreCase("Firefoxdriver")) {
                        extentTestChildFF.log(LogStatus.FAIL, ""+by);
                        
                  } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Phone")) {
                        extentTestChildAndroidPhone.log(LogStatus.FAIL, ""+by);
                        
                  } else if(xmlTest.getParameter("broName").equalsIgnoreCase("Android Tab")) {
                        extentTestChildAndroidTab.log(LogStatus.FAIL, ""+by);
                        
                  } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPhone")) {
                        extentTestChildiPhone.log(LogStatus.FAIL, ""+by);
                        
                  } else if(xmlTest.getParameter("broName").equalsIgnoreCase("iPad")) {
                        extentTestChildiPad.log(LogStatus.FAIL, ""+by);
                  }
                  
           }
           
           wb=driver.findElement(by);
           if(driver.getClass().getSimpleName().equalsIgnoreCase("ChromeDriver") || driver.getClass().getSimpleName().equalsIgnoreCase("SafariDriver"))
           {
                  try
                  {
                  if(!isElementInViewPort(wb))
                  {
                  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wb);
                  Thread.sleep(500); 
                  }
                  else
                  {
                        System.out.println("not here");
                  }
                  }
                  catch(Exception e)
                  {
                  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wb);
                  Thread.sleep(500); 
                  }
           }
           return wb;
    }

	
	public List<WebElement> getWebElements(String loc1,String filename) throws Exception
	{
		return driver.findElements(getLocators(loc1, filename));
	}
	
	public List<WebElement> getWebElements(By by) throws Exception
	{
		return driver.findElements(by);
	}
	
	private boolean isElementInViewPort(WebElement ele)
	{
		Dimension weD =ele.getSize(); //to get the element Dimensions
		Point weP = ele.getLocation(); // getting the location of the element in the page.
		Dimension d = driver.manage().window().getSize(); // To get the browser dimensions
		int x = d.getWidth(); //browser width
		int y = d.getHeight(); //browser height
		int x2 = weD.getWidth() + weP.getX();
		int y2 = weD.getHeight() + weP.getY();
		System.out.println(x2 <= x && y2 <= y);
		return x2 <= x && y2 <= y;
	}
	
}
