package com.prevail.profile;


import static org.testng.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;












import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.projectspec.ProfileFunctions;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.GetDriver;
import com.prevail.utilgeneric.TestData;

public class Register extends BaseTest{
	
	
@Test(groups="{Regression}",description="124584_124585_148638")
public void TC00_RegisterUI() throws Exception
{
	
	log.info("Click on my account icon");
	l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
	log.info("click on register link in my account drop down");
	l1.getWebElements("Register_Myaccount_Elements","Profile\\Register.properties").get(0).click();
	log.info("click  on create account in left nav");
	l1.getWebElement("Register_CreateAccount_LeftNav","Profile\\Register.properties").click();
	log.info("UI of create account page");
	log.info("Register Heading");
	sa.assertTrue(l1.getWebElement("Register_Heading", "Profile\\Register.properties").isDisplayed());
	log.info("Register FN Label");
	sa.assertTrue(l1.getWebElement("Register_FN_Label", "Profile\\Register.properties").isDisplayed());
	log.info("Register LN Label");
	sa.assertTrue(l1.getWebElement("Register_LN_Label", "Profile\\Register.properties").isDisplayed());
	log.info("Register Email Label");
	sa.assertTrue(l1.getWebElement("Register_Email_Label", "Profile\\Register.properties").isDisplayed());
	log.info("Register ConfirmEmail Label");
	sa.assertTrue(l1.getWebElement("Register_ConfirmEmail_Label", "Profile\\Register.properties").isDisplayed());
	log.info("Register Password Label");
	sa.assertTrue(l1.getWebElement("Register_Password_Label", "Profile\\Register.properties").isDisplayed());
	log.info("Register ConfirmPassword Label");
	sa.assertTrue(l1.getWebElement("Register_ConfirmPassword_Label", "Profile\\Register.properties").isDisplayed());
	log.info("Register FirstName textbox");
	sa.assertTrue(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").isDisplayed());
	log.info("Register LastName textbox");
	sa.assertTrue(l1.getWebElement("Register_LastName", "Profile\\Register.properties").isDisplayed());
	log.info("Register EmailID textbox");
	sa.assertTrue(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").isDisplayed());
	log.info("Register RegisterConfirmEmail textbox");
	sa.assertTrue(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").isDisplayed());
	log.info("Register Register Password textbox");
	sa.assertTrue(l1.getWebElement("Register_Password", "Profile\\Register.properties").isDisplayed());
	log.info("Register Register ConfirmPassword textbox");
	sa.assertTrue(l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").isDisplayed());
	log.info("Register Register ApplyButton");
	sa.assertTrue(l1.getWebElement("Register_ApplyButton", "Profile\\Register.properties").isDisplayed());
	//Bread crumb Verification
	String breadcrumbElementName=l1.getWebElement("Register_Breadcrumb_Element","Profile\\Register.properties").getText();
	assertEquals(breadcrumbElementName,"My Account");
	//It will return all the assertions
	sa.assertAll();
	
}
	
@Test(groups="{Regression}",description="124592")
public void TC01_PrivacyPolicyLink() throws Exception
{
	
	log.info("click on Privacy Policy Button");
	l1.getWebElement("Register_PrivacyPolicy","Profile\\Register.properties").click();
	log.info("Privacy Policy Overlay");
	sa.assertTrue(l1.getWebElement("Register_PrivacyPolicy_Overlay", "Profile\\Register.properties").isDisplayed());
	log.info("Privacy Policy heading");
	sa.assertTrue(l1.getWebElement("Register_PrivacyPolicy_heading", "Profile\\Register.properties").isDisplayed());
	log.info("Register Privacy Policy overlay close button");
	l1.getWebElement("Register_PrivacyPolicy_CloseButton","Profile\\Register.properties").click();
	log.info("Navigate back to register heading");
	Thread.sleep(3000);
	sa.assertTrue(l1.getWebElement("Register_Heading", "Profile\\Register.properties").isDisplayed());
	
}
	
@Test(groups="{Regression}",description="288270_148639_148640")
public void TC02_LeftNavLinks() throws Exception
{
	
	log.info("Fectching all LeftNav Links");
	int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
	for (int i=0;i<LeftNavLinksCount;i++)
	{
		log.info("Displaying LeftNav Links");
		sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).isDisplayed());
		log.info("Fetching LeftNav Links");
		//String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
		log.info("Comparing LeftNav Links");
		//sa.assertEquals(leftNavLinks,(GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i,0)).toString());
		log.info("Clicking all LeftNav Links");
		l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
		log.info("Comparing Navigation headings");
		sa.assertEquals(l1.getWebElement("LeftNav_Headings","Profile\\Register.properties").getText(),GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i,0));
		log.info("Click on home page logo");
		l1.getWebElement("HomePage_Logo","Profile\\login.properties").click();
		log.info("Click on account Icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("My Account Elements");
		l1.getWebElements("Register_Myaccount_Elements","Profile\\Register.properties").get(0).click();
	}
	
	log.info("Fetching all LeftNav Headings");
	int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
	for (int i=0;i<LeftNavHeadings;i++)
	{
		log.info("Display of LeftNav Headings");
		l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i).click();
	}
	
	log.info("Left Nav Help Text");
	sa.assertTrue(l1.getWebElement("LeftNav_Needhelp_Text","Profile\\Register.properties").isDisplayed());
	log.info("assert all");
	sa.assertAll();
	
}

@Test(groups="{Regression}",description="11")
public void TC03_ContactUsLink() throws Exception
{
	
	log.info("contact us link");
	sa.assertTrue(l1.getWebElement("LeftNav_ContactUs_Link","Profile\\Register.properties").isDisplayed());
	log.info("click on contact us link");
	l1.getWebElement("LeftNav_ContactUs_Link","Profile\\Register.properties").click();
	log.info("verify the navigation");
	sa.assertTrue(l1.getWebElement("LeftNav_ContactUs_heading","Profile\\Register.properties").isDisplayed());
	
}
	
@Test(groups="{Regression}",description="124599")
public void TC04_Register_CreateAccount(XmlTest xmlTest) throws Exception
{

	
	log.info("Calling create account method from profile functions");
	int rowNum=new Integer(xmlTest.getParameter("dynamicNum"));
	p.CreateAccount("\\data\\GenericData.xls","CreateAccount",rowNum);
	log.info("Click on apply button");
	l1.getWebElement("Register_ApplyButton","Profile\\Register.properties").click();
	log.info("to check whether account is created or not");
	sa.assertTrue(l1.getWebElement("Register_LoginConfirmation", "Profile\\Register.properties").isDisplayed());
	log.info("assert all");
	sa.assertAll();
	log.info("Calling Logout Function");
	p.Logout();
	log.info("Click on my account icon");
	l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
	log.info("click on register link in my account drop down");
	l1.getWebElements("Register_Myaccount_Elements","Profile\\Register.properties").get(0).click();
	
}

@Test(groups="{Regression}",description="124588_124589_124601_125240_288242",dataProvider="register",dataProviderClass=Data.class)
public void Register_Validations(TestData t) throws Exception
{
	
		log.info("Clear fielsd after every entry");
		p.ClearFieldsRegister();
		
		log.info("fetching data from data providers");
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").sendKeys(t.get(0));
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").sendKeys(t.get(1));
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").sendKeys(t.get(2));
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").sendKeys(t.get(3));
		l1.getWebElement("Register_Password", "Profile\\Register.properties").sendKeys(t.get(4));
		l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").sendKeys(t.get(5));
		l1.getWebElement("Register_ApplyButton","Profile\\Register.properties").click();
		
		
		if (i==0){
			log.info("Blank Field Validation"+i);
			sa.assertEquals(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_LastName", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_Password", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			//Error Messages
			sa.assertEquals(l1.getWebElement("Register_FirstName_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","FN_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_LastName_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","LN_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_Email_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmEmail_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("Register_Password_Errormessage", "Profile\\Register.properties").get(0).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Password_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("Register_Password_Errormessage", "Profile\\Register.properties").get(1).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmPassword_BlankField_ErrorMessage"));
		}
		
		else if (i==1){
			log.info("length Validation"+i);
			sa.assertEquals(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,1));
			sa.assertEquals(l1.getWebElement("Register_LastName", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,2));
			sa.assertEquals(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,3));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,4));
			sa.assertEquals(l1.getWebElement("Register_Password", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,5));
			sa.assertEquals(l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,6));
		}
		
		else if(i==2 || i==3 || i==4){
			log.info("Email and confirm email error fields"+i);
			sa.assertEquals(l1.getWebElement("Register_Email_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmEmail_BlankField_ErrorMessage"));
		}
		else{
			
			log.info("Create account with valid data"+i);
			sa.assertTrue(l1.getWebElement("Register_LoginConfirmation", "Profile\\Register.properties").isDisplayed());
		}
	}
	
	
}

