package com.prevail.utilgeneric;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class Test extends BaseTest{

	
	public void ExtentTest000() throws Exception
	{
		//l1.getWebElement("signIn", "login.properties").click();
		SoftAssert sa=new SoftAssert();
		//sa.assertTrue(l1.getWebElement("loginReturnHeading", "login.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("Login_Heading", "Profile\\login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("emailLabel", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("emailTextBox", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("pwdLabel", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("pwdTextBox", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("submitBtn", "login.properties").isDisplayed());
		sa.assertAll();
	}
	
	public void ExtentTest001() throws Exception
	{
		//l1.getWebElement("signIn", "login.properties").click();
		SoftAssert sa=new SoftAssert();
		//sa.assertTrue(l1.getWebElement("loginReturnHeading", "login.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("Login_Heading", "Profile\\login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("emailLabel", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("emailTextBox", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("pwdLabel", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("pwdTextBox", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("submitBtn", "login.properties").isDisplayed());
		sa.assertAll();
	}
	
	public void ExtentTest002() throws Exception
	{
		//l1.getWebElement("signIn", "login.properties").click();
		SoftAssert sa=new SoftAssert();
		//sa.assertTrue(l1.getWebElement("loginReturnHeading", "login.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("Login_Heading", "Profile\\login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("emailLabel", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("emailTextBox", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("pwdLabel", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("pwdTextBox", "login.properties").isDisplayed());
		//sa.assertTrue(l1.getWebElement("submitBtn", "login.properties").isDisplayed());
		sa.assertAll();
	}

}
