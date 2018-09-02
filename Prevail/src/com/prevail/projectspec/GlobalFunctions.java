package com.prevail.projectspec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.xml.XmlTest;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class GlobalFunctions {
	
	WebDriver driver;
	String assertEqual;
	boolean isVisible;
	Select sel;
	public String disabled;
	
	public GlobalFunctions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void navigateToSite(XmlTest xmlTest) throws Exception
	{
		
		driver.get(new GetData().getDataFromProperties("\\data\\sitedata.properties", "URL"));
		//driver.getClass().getName().indexOf("ie")>0
		if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {
			try
			{
				Thread.sleep(5000);
//				driver.navigate ().to ("javascript:document.getElementById('overridelink').click()");
				System.out.println("overrided");
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("not overrided");
			}
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("IOSDriver")) {
			Thread.sleep(15000);
		}
		
	}
	
	public void navigateToBM(XmlTest xmlTest) throws Exception
	{
		
		driver.get(new GetData().getDataFromProperties("\\data\\sitedata.properties","BMURL"));
		//driver.getClass().getName().indexOf("ie")>0
		if(xmlTest.getParameter("broName").equalsIgnoreCase("ie")) {
			try
			{
				Thread.sleep(5000);
				driver.navigate ().to ("javascript:document.getElementById('overridelink').click()");
				System.out.println("overrided");
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("not overrided");
			}
			
		} else if(driver.getClass().getSimpleName().equalsIgnoreCase("IOSDriver")) {
			Thread.sleep(15000);
		}
		
	}
	
	
	public boolean assertNotVisible(String str1,String str2)
	{
		try{
			BaseTest.l1.getWebElement(str1, str2).isDisplayed();
			
		}catch(Exception e){
			isVisible=true;
		}
		return isVisible;
	}
	
	public boolean assertNotVisible(By by)
	{
		try{
			BaseTest.l1.getWebElement(by).isDisplayed();
			
		}catch(Exception e){
			e.printStackTrace();
			isVisible=true;
		}
		return isVisible;
	}
	
	public boolean assertVisible(String str1,String str2)
	{
		try{
			BaseTest.l1.getWebElement(str1, str2).isDisplayed();
			isVisible=true;
			
		}catch(Exception e){
			isVisible=false;
		}
		return isVisible;
	}
	
	public boolean assertVisible(By by)
	{
		try{
			BaseTest.l1.getWebElement(by).isDisplayed();
			isVisible=true;
			
		}catch(Exception e){
			isVisible=false;
		}
		return isVisible;
	}
	
	
	
	public boolean assertVisible(String str1,String str2,int i)
	{
		try{
			BaseTest.l1.getWebElements(str1, str2).get(i).isDisplayed();
			isVisible=true;
			
		}catch(Exception e){
			isVisible=false;
		}
		return isVisible;
	}
	
	public boolean assertVisible(By by,int i)
	{
		try{
			BaseTest.l1.getWebElements(by).get(i).isDisplayed();
			isVisible=true;
			
		}catch(Exception e){
			isVisible=false;
		}
		return isVisible;
	}
	
	
	
	public String assertEqual(String str1,String str2)
	{
		try{
			assertEqual=BaseTest.l1.getWebElement(str1, str2).getText();
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	public String assertEqual(By by)
	{
		try{
			assertEqual=BaseTest.l1.getWebElement(by).getText();
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	
	
	
	public String assertEqual(String str1,String str2,int i)
	{
		try{
			assertEqual=BaseTest.l1.getWebElements(str1, str2).get(i).getText();
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	public String assertEqual(By by,int i)
	{
		try{
			assertEqual=BaseTest.l1.getWebElements(by).get(i).getText();
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	
	public String assertEqual(String str1,String str2,String str3)
	{
		try{
			assertEqual=BaseTest.l1.getWebElement(str1, str2).getAttribute(str3);
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	public String assertEqual(By by,String str3)
	{
		try{
			assertEqual=BaseTest.l1.getWebElement(by).getAttribute(str3);
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	
	
	
	public String assertEqual(String str1,String str2,String str3,int i)
	{
		try{
			assertEqual=BaseTest.l1.getWebElements(str1, str2).get(i).getAttribute(str3);
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	

	public String assertEqual(By by,String str3,int i)
	{
		try{
			assertEqual=BaseTest.l1.getWebElements(by).get(i).getAttribute(str3);
		}catch(Exception e){
			assertEqual="No Such Element";	
		}
		return assertEqual;
	}
	
	public void handlingDropdown(String loc1,String filename,int Value) throws Exception
	{		  
	    sel = new Select(driver.findElement(BaseTest.l1.getLocators(loc1, filename)));
	    sel.selectByIndex(Value);
	}
	
	public void handlingDropdown(String loc1,String filename,String Text) throws Exception
	{
	    sel = new Select(driver.findElement(BaseTest.l1.getLocators(loc1, filename)));
	    sel.selectByVisibleText(Text);
	}
	
	
	public void handlingDropdown(By by,String Text) throws Exception
	{
	    sel = new Select(BaseTest.l1.getWebElement(by));
	    sel.selectByVisibleText(Text);
	}
	
	public void handlingDropdown(By by,int dropdown,int value) throws Exception
	{
		   sel = new Select(BaseTest.l1.getWebElements(by).get(dropdown));
		    sel.selectByIndex(value);
	}
	
	public void handlingDropdown(By by,int Value) throws Exception
	{
	    sel = new Select(BaseTest.l1.getWebElement(by));
	    sel.selectByIndex(Value);
	}
	

	public String fetchingOptionfromDropdown(By by) throws Exception
	{
	    sel=new Select(BaseTest.l1.getWebElement(by));
		WebElement option = sel.getFirstSelectedOption();
		String defaultSelectedOption = option.getText();
		System.out.println(defaultSelectedOption);
		return defaultSelectedOption;
	}
	
	
	public void SelectCheckbox(String loc1,String filename) throws Exception
	{
		boolean isSelected=BaseTest.l1.getWebElement(loc1,filename).isSelected();
		if (isSelected==false)
		{
			BaseTest.l1.getWebElement(loc1,filename).click();	
		}
	}
	
	public void UnSelectCheckbox(String loc1,String filename) throws Exception
	{
		boolean isSelected=BaseTest.l1.getWebElement(loc1,filename).isSelected();
		if (isSelected==true)
		{
			BaseTest.l1.getWebElement(loc1,filename).click();	
		}
	}
	
	public void SelectCheckbox(By by) throws Exception
	{
		boolean isSelected=BaseTest.l1.getWebElement(by).isSelected();
		if (isSelected==false)
		{
			BaseTest.l1.getWebElement(by).click();	
		}
	}
	
	public void UnSelectCheckbox(By by) throws Exception
	{
		boolean isSelected=BaseTest.l1.getWebElement(by).isSelected();
		if (isSelected==true)
		{
			BaseTest.l1.getWebElement(by).click();	
		}
	}
	
	public void MouseHover(String loc1,String filename) throws Exception
	{
		BaseTest.l1.wb = driver.findElements(BaseTest.l1.getLocators(loc1, filename)).get(0);
		 
        Actions action = new Actions(driver);
 
        action.moveToElement(BaseTest.l1.wb).build().perform();
	}

	public void MouseHover(By by) throws Exception
	{
		// TODO Auto-generated method stub
		BaseTest.l1.wb = BaseTest.l1.getWebElements(by).get(0);
		 
        Actions action = new Actions(driver);
 
        action.moveToElement(BaseTest.l1.wb).build().perform();
	}
	
}
