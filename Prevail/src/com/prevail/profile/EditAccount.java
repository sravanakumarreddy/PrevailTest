package com.prevail.profile;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.projectspec.ProfileFunctions;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class EditAccount extends BaseTest {
	
	
	@Test(groups="{Regression}",description="264290_124760,124643")
	public void TC00_EditAccountChangeEmailPasswordandEditAccountUI() throws Exception
	{
		
		log.info("Click on my account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on register link in my account drop down");
		l1.getWebElements("Register_Myaccount_Elements","Profile\\Register.properties").get(1).click();
		log.info("Create account");
		p.CreateAccount("\\data\\ProfileData.xls","RegisterValidations",4);
		log.info("click on create account button");
		l1.getWebElement("Register_ApplyButton","Profile\\Register.properties").click();
		sa.assertTrue(gVar.assertVisible("MyAccount_options","Profile\\MyAccountHome.properties"),"Account Options");
		log.info("Click on personal data link");
		l1.getWebElement("MyAccount_PersonalDataLink","Profile\\MyAccountHome.properties").click();
		log.info("Click on personal data Heading");
		sa.assertTrue(gVar.assertVisible("EditAccount_Heading","Profile\\EditAccount.properties"),"Edit account Heading");
		
		//UI of Edit Account
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
		log.info("Register Register ApplyButton");
		sa.assertTrue(l1.getWebElement("Register_ApplyButton", "Profile\\Register.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("EditAccount_currentpassword_Label", "Profile\\EditAccount.properties").isDisplayed());
		sa.assertTrue(l1.getWebElements("EditAccount_newpassword_Label", "Profile\\EditAccount.properties").get(0).isDisplayed());
		sa.assertTrue(l1.getWebElement("EditAccount_confirmnewpassword_Label", "Profile\\EditAccount.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("EditAccount_CurrentPassword_textbox", "Profile\\EditAccount.properties").isDisplayed());
		sa.assertTrue(l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(0).isDisplayed());
		sa.assertTrue(l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(1).isDisplayed());
		sa.assertTrue(l1.getWebElement("EditAccount_Password_ApplyButton", "Profile\\EditAccount.properties").isDisplayed());
	
		//Clear all the test boxes
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_Password", "Profile\\Register.properties").clear();
		
		//Functionality 
		log.info("Change the email and create account");
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",5,0));
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",5,1));
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",5,2));
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",5,3));
		l1.getWebElements("Register_Password", "Profile\\Register.properties").get(0).sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",5,4));
		log.info("click on Apply button in edit account");
		l1.getWebElement("EditAccount_Email_ApplyButton","Profile\\EditAccount.properties").click();
		log.info("Logout from the application");
		p.Logout();
		log.info("Click on my account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link in my account drop down");
		l1.getWebElements("Register_Myaccount_Elements","Profile\\Register.properties").get(0).click();
		log.info("Login with new email and old password");
		l1.getWebElement("Login_Username","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",5,2));
		l1.getWebElement("Login_Password","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",5,4));
		l1.getWebElement("Login_Login_Button","Profile\\login.properties").click();
		log.info("Login Should Happen Login Heading");
		sa.assertTrue(l1.getWebElement("Register_LoginConfirmation", "Profile\\Register.properties").isDisplayed());
		log.info("Click on personal data link");
		l1.getWebElement("MyAccount_PersonalDataLink","Profile\\MyAccountHome.properties").click();
		
		//Clear all the test boxes
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_Password", "Profile\\Register.properties").clear();
		
		log.info("Reset the email ID");
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,0));
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,1));
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,2));
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,3));
		l1.getWebElements("Register_Password", "Profile\\Register.properties").get(0).sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,4));
		log.info("click on email Apply button in edit account");
		l1.getWebElement("EditAccount_Email_ApplyButton","Profile\\EditAccount.properties").click();
		log.info("Click on personal data link");
		l1.getWebElement("MyAccount_PersonalDataLink","Profile\\MyAccountHome.properties").click();
		
		//Clear all the test boxes
		l1.getWebElement("EditAccount_CurrentPassword_textbox","Profile\\EditAccount.properties").clear();
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(0).clear();
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(1).clear();
		
		log.info("Change the password in edit account");
		l1.getWebElement("EditAccount_CurrentPassword_textbox","Profile\\EditAccount.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,4));
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(0).sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",6,4));
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(1).sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",6,5));
		log.info("Click on apply password button");
		l1.getWebElement("EditAccount_Password_ApplyButton","Profile\\EditAccount.properties").click();
		log.info("Logout from the application");
		p.Logout();
		log.info("Click on my account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link in my account drop down");
		l1.getWebElements("Register_Myaccount_Elements","Profile\\Register.properties").get(0).click();
		log.info("login with old email and new password");
		l1.getWebElement("Login_Username","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",6,2));
		l1.getWebElement("Login_Password","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",6,4));
		l1.getWebElement("Login_Login_Button","Profile\\login.properties").click();
		log.info("Login Should Happen Login Heading");
		sa.assertTrue(l1.getWebElement("Register_LoginConfirmation", "Profile\\Register.properties").isDisplayed());
		log.info("Click on personal data link");
		l1.getWebElement("MyAccount_PersonalDataLink","Profile\\MyAccountHome.properties").click();
		
		//Clear all the test boxes
		l1.getWebElement("EditAccount_CurrentPassword_textbox","Profile\\EditAccount.properties").clear();
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(0).clear();
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(1).clear();
		
		log.info("Resst the email and password");
		l1.getWebElement("EditAccount_CurrentPassword_textbox","Profile\\EditAccount.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",6,4));
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(0).sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,4));
		l1.getWebElements("EditAccount_NewPassword_textboxes","Profile\\EditAccount.properties").get(1).sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",4,5));
		log.info("Click on apply password button");
		l1.getWebElement("EditAccount_Password_ApplyButton","Profile\\EditAccount.properties").click();
		log.info("Password should reset");
		sa.assertTrue(l1.getWebElement("Register_LoginConfirmation", "Profile\\Register.properties").isDisplayed());
		
	}
	
	@Test(groups="{Regression}",description="264291")
	public void TC01_PrivacyPolicyLink() throws Exception
	{
		log.info("Click on personal data link");
		l1.getWebElement("MyAccount_PersonalDataLink","Profile\\MyAccountHome.properties").click();
		
		log.info("click on Privacy Policy Button");
		l1.getWebElement("EditAccount_PrivacyPolicy","Profile\\EditAccount.properties").click();
		log.info("Privacy Policy Overlay");
		sa.assertTrue(l1.getWebElement("EditAccount_PrivacyPolicy_Overlay", "Profile\\EditAccount.properties").isDisplayed());
		log.info("Privacy Policy heading");
		sa.assertTrue(l1.getWebElement("EditAccount_PrivacyPolicy_heading", "Profile\\EditAccount.properties").isDisplayed());
		log.info("Register Privacy Policy overlay close button");
		l1.getWebElement("EditAccount_PrivacyPolicy_CloseButton","Profile\\EditAccount.properties").click();
		log.info("Navigate back to register heading");
		Thread.sleep(3000);
		sa.assertTrue(l1.getWebElement("EditAccount_Heading","Profile\\EditAccount.properties").isDisplayed());
		
	}
	
		
	@Test(groups="{Regression}",description="264291,264287,288371,124639,124641,264284",dataProvider="register",dataProviderClass=Data.class)
	public void TC02_EditAccountValidations(TestData t) throws Exception
	{
			
		log.info("Clear fielsd after every entry");
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").clear();
		l1.getWebElement("Register_Password", "Profile\\Register.properties").clear();
		
		log.info("fetching data from data providers");
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").sendKeys(t.get(0));
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").sendKeys(t.get(1));
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").sendKeys(t.get(2));
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").sendKeys(t.get(3));
		l1.getWebElement("Register_Password", "Profile\\Register.properties").sendKeys(t.get(4));
		
		
		if (i==0){
			log.info("Blank Field Validation"+i);
			l1.getWebElement("Register_ApplyButton","Profile\\Register.properties").click();
			sa.assertEquals(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_LastName", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_Password", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			//Error Messages
			sa.assertEquals(l1.getWebElement("Register_FirstName_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","FN_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_LastName_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","LN_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_Email_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmEmail_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_Password_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Password_BlankField_ErrorMessage"));		
			
			}
		else if (i==1){
			log.info("length Validation"+i);
			sa.assertEquals(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,1));
			sa.assertEquals(l1.getWebElement("Register_LastName", "Profile\\Register.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,2));
			sa.assertEquals(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,3));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,4));
			sa.assertEquals(l1.getWebElement("Register_Password", "Profile\\Register.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,5));
		}
		
		else if(i==2 || i==3 || i==4){
			l1.getWebElement("Register_ApplyButton","Profile\\Register.properties").click();
			log.info("Email and confirm email error fields"+i);
			sa.assertEquals(l1.getWebElement("Register_Email_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmEmail_ErrorMessage"));
		}
		
		i++;
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124646")
	public void TC03_BreadcrumbVerification(TestData t) throws Exception
	{
		if (l1.getWebElements("EditAccount_Breadcrumb_Elements","Profile\\EditAccount.properties").get(1).getAttribute("href")==null){
			log.info("Edit account breadcrumb is not a a link and it is static text");	
		}
		else{
			log.info("Edit account breadcrumb is a link and it is Not a static text");	
		}
		log.info("Verifying bread crumb My Account");
		l1.getWebElements("EditAccount_Breadcrumb_Elements","Profile\\EditAccount.properties").get(0).click();
		log.info("My account heading");
		sa.assertTrue(l1.getWebElement("MyAccount_Heading", "Profile\\MyAccountHome.properties").isDisplayed());
		i=0;
	}

	@Test(groups="{Regression}",description="264287,264288,264289",dataProvider="EditAccount_PasswordFieldValidation",dataProviderClass=Data.class)
	public void TC04_ValidationsPassword(TestData t) throws Exception
	{

		log.info("Click on personal data link");
		l1.getWebElement("MyAccount_PersonalDataLink","Profile\\MyAccountHome.properties").click();
		log.info("Clearing all the values");
		l1.getWebElement("EditAccount_CurrentPassword_textbox", "Profile\\EditAccount.properties").clear();
		Thread.sleep(5000);
		l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(0).clear();
		Thread.sleep(5000);
		l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(1).clear();
		Thread.sleep(5000);
		
		//EditAccount_CurrentPassword_textbox		
		log.info("value entering in current password field");
		l1.getWebElement("EditAccount_CurrentPassword_textbox", "Profile\\EditAccount.properties").sendKeys(t.get(0));
		Thread.sleep(5000);
		log.info("value entering in New password field");
		l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(0).sendKeys(t.get(1));
		Thread.sleep(5000);
		log.info("value entering in New password confirm field");
		l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(1).sendKeys(t.get(2));
		Thread.sleep(5000);
		log.info("click on apply button in password field");
		l1.getWebElement("EditAccount_Password_ApplyButton","Profile\\EditAccount.properties").click();
		
		if (i==0){
			log.info("Blank Field Validations"+i);
			
			sa.assertEquals(l1.getWebElement("EditAccount_CurrentPassword_textbox", "Profile\\EditAccount.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(0).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(1).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			
			
			sa.assertEquals(l1.getWebElement("EditAccount_CurrentPassword_ErrorMessage", "Profile\\EditAccount.properties"),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","FN_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("EditAccount_NewandConfirm_ErrorMessage", "Profile\\EditAccount.properties").get(0).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","NewPassword_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("EditAccount_NewandConfirm_ErrorMessage", "Profile\\EditAccount.properties").get(1).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmNewPassword_BlankField_ErrorMessage"));
			}
		else if (i==1){
			log.info("Less than 8 char"+i);
			sa.assertEquals(l1.getWebElement("EditAccount_CurrentPassword_ErrorMessage", "Profile\\EditAccount.properties"),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","CurrentPassword_Lessthan8_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("EditAccount_NewandConfirm_ErrorMessage", "Profile\\EditAccount.properties").get(0).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","NewPassword_Lessthan8_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("EditAccount_NewandConfirm_ErrorMessage", "Profile\\EditAccount.properties").get(1).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmNewPassword_Lessthan8_ErrorMessage"));
		}
		else if (i==2){
			log.info("more than 255 char"+i);
			sa.assertEquals(l1.getWebElement("EditAccount_CurrentPassword_textbox", "Profile\\EditAccount.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,7));
			sa.assertEquals(l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(0).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,8));
			sa.assertEquals(l1.getWebElements("EditAccount_NewPassword_textboxes", "Profile\\EditAccount.properties").get(1).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,9));
		}
		
		i++;
	}

	@Test(groups="{Regression}",description="288299,264292")
	public void TC05_EditAccount_LeftNav_navigation() throws Exception
	{
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{	
	        //Navigate to wish list search result page
			log.info("click on my account link");
			l1.getWebElement("Header_MyAccount_Link","Profile\\MyAccountHome.properties").click();
			log.info("Click on personal data link");
			l1.getWebElement("MyAccount_PersonalDataLink","ShopNav\\HomePage.properties").click();
			
			//Link Display verification
			sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).isDisplayed(),"LeftNav links display");
			String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
			sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",i+1,4));
			
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 3);
			//String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 4);
			//verify the navigation
			sa.assertEquals(l1.getWebElement("PageHeadings", "Profile\\Wishlist.properties").getText(), Expected_LeftnavHeading);
			//sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(1).getText(), Expected_LeftnavBreadcrumb);
		}
		
	       //Navigate to wish list search result page
			log.info("click on my account link");
			l1.getWebElement("Header_MyAccount_Link","Profile\\MyAccountHome.properties").click();
			log.info("Click on personal data link");
			l1.getWebElement("MyAccount_PersonalDataLink","ShopNav\\HomePage.properties").click();
		
			log.info("Take Count of left nav Headings");				
			int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
			for (int i=0;i<=LeftNavHeadings;i++)
			{
				log.info("Left nav headings");
				sa.assertEquals(l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i).getText(),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",i+1,5));
			}
			
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(l1.getWebElement("PageHeadings", "Profile\\Wishlist.properties").getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(1).getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		//It will return all the assertions
		sa.assertAll();
	}
	
}
