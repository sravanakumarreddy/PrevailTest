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

public class PaymentSettings extends BaseTest{
	
	//125897,128535,128723
	

	@Test(groups="{Regression}",description="124782,125897")
	public void TC00_PaymentSettingsUI(XmlTest xmlTest) throws Exception
	{
		
		p.loginToAppliction(xmlTest);
		log.info("Click on add credit card button");
		l1.getWebElement("PaymentSettings_Link_MyaccountLandingPage","Profile\\PaymentSettings.properties").click();
		p.DeleteCreditCard();
		sa.assertTrue(gVar.assertVisible("PaymentSettings_Heading","Profile\\PaymentSettings.properties"),"Payment settings heading");
		sa.assertTrue(gVar.assertVisible("PaymentSettings_AddCreditCard_Button","Profile\\PaymentSettings.properties"),"Add credit card button");
		sa.assertTrue(gVar.assertVisible("PaymentSettings_LeftNav","Profile\\PaymentSettings.properties"),"Payment settings LeftNav");
		sa.assertTrue(gVar.assertVisible("PaymentSettings_breadcrumb","Profile\\PaymentSettings.properties"),"Payment settings breadcrumb");
		log.info("Click on add credit card button");
		l1.getWebElement("PaymentSettings_AddCreditCard_Button","Profile\\PaymentSettings.properties").click();
		log.info("Add credit card UI");
		sa.assertTrue(l1.getWebElement("PaymentSettings_AddCreditCardOverlay_Heading", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card Overlay Heading");
		sa.assertTrue(l1.getWebElement("PaymentSettings_NameOnCard", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card Name on card");
		sa.assertTrue(l1.getWebElement("PaymentSettings_type", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card payment type");
		sa.assertTrue(l1.getWebElement("PaymentSettings_Number", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card payment NUmber");
		sa.assertTrue(l1.getWebElement("PaymentSettings_ExpiresMonth", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card Expires month");
		sa.assertTrue(l1.getWebElement("PaymentSettings_ExpiresYear", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card Expires Year");
		sa.assertTrue(l1.getWebElement("PaymentSettings_FirstName", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card First Name");
		sa.assertTrue(l1.getWebElement("PaymentSettings_Address1", "Profile\\PaymentSettings.properties").isDisplayed(),"Credit Card Firsr Name");
		sa.assertTrue(l1.getWebElement("PaymentSettings_Address2", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Country", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_State", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_City", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Zipcode", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Phone", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Email", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_ApplyButton", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_CancelButton", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_AddCreditCardOverlay_Heading", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_NameOnCard_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Type_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Number_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Expires_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_FN_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_LN_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Address1_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Address2_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Country_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_State_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_City_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Zipcode_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Phone_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Email_Label", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_Payment_List", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(l1.getWebElement("PaymentSettings_DeleteCard_Link", "Profile\\PaymentSettings.properties").isDisplayed());
		
	}
	
	@Test(groups="{Regression}",description="124784,124785,124781,124783,128535,128723")
	public void TC01_CancelCard_and_AddCreditCard() throws Exception
	{
		log.info("Entering values");
		p.CreateCreditCard("data\\ProfileData.xls","CreditCard",1);
		log.info("Click on cancel button in overlay");
		l1.getWebElement("PaymentSettings_CancelButton","Profile\\PaymentSettings.properties").click();
		sa.assertTrue(gVar.assertNotVisible("PaymentSettings_Overlay","Profile\\PaymentSettings.properties"),"Credit Card Overlay Not Visible");
		log.info("Click on add credit card button");
		l1.getWebElement("PaymentSettings_AddCreditCard_Button","Profile\\PaymentSettings.properties").click();
		log.info("Click on close button in overlay");
		l1.getWebElement("PaymentSettings_Overlay_CloseButton","Profile\\PaymentSettings.properties").click();
		sa.assertTrue(gVar.assertNotVisible("PaymentSettings_Overlay","Profile\\PaymentSettings.properties"),"Credit Card Overlay Not Visible");
		log.info("Click on add credit card button");
		l1.getWebElement("PaymentSettings_AddCreditCard_Button","Profile\\PaymentSettings.properties").click();
		sa.assertTrue(gVar.assertVisible("PaymentSettings_Overlay","Profile\\PaymentSettings.properties"),"Credit Card Overlay");
		p.CreateCreditCard("data\\ProfileData.xls","CreditCard",1);
		l1.getWebElement("PaymentSettings_ApplyButton","Profile\\PaymentSettings.properties").click();
		sa.assertTrue(l1.getWebElement("PaymentSettings_Payment_List", "Profile\\PaymentSettings.properties").isDisplayed());
		sa.assertTrue(gVar.assertVisible("PaymentSettings_CardHolderName","Profile\\PaymentSettings.properties"),"Card holder name");
		sa.assertTrue(gVar.assertVisible("PaymentSettings_ccType","Profile\\PaymentSettings.properties"),"cc type");
		sa.assertTrue(gVar.assertVisible("PaymentSettings_ccNumber","Profile\\PaymentSettings.properties"),"cc Number");
		sa.assertTrue(gVar.assertVisible("PaymentSettings_ccExpire","Profile\\PaymentSettings.properties"),"cc Expire");
		sa.assertTrue(gVar.assertVisible("PaymentSettings_DeleteCard","Profile\\PaymentSettings.properties"),"Delete card");
		sa.assertEquals(gVar.assertEqual("PaymentSettings_CardHolderName","Profile\\PaymentSettings.properties"),GetData.getDataFromExcel("\\data\\ProfileData.xls","CreditCard",4,0),"Comparing card holder name");
		sa.assertEquals(gVar.assertEqual("PaymentSettings_ccType","Profile\\PaymentSettings.properties"),GetData.getDataFromExcel("\\data\\ProfileData.xls","CreditCard",4,1),"Comparing card name");
		sa.assertEquals(gVar.assertEqual("PaymentSettings_ccExpire","Profile\\PaymentSettings.properties"),GetData.getDataFromExcel("\\data\\ProfileData.xls","CreditCard",4,2),"Comparing Expire name");
	}
	
	@Test(groups="{Regression}",description="124787")
	public void TC02_BreadcrumbLinks() throws Exception
	{
		if (l1.getWebElements("PaymentSettings_Breadcrumb_Elements","Profile\\PaymentSettings.properties").get(1).getAttribute("href")==null){
			log.info("Payment Settings breadcrumb is not a a link and it is static text");	
		}
		else{
			log.info("Payment Settings breadcrumb is a link and it is Not a static text");	
		}
		log.info("Verifying bread crumb Payment Settings");
		l1.getWebElements("PaymentSettings_Breadcrumb_Elements","Profile\\PaymentSettings.properties").get(0).click();
		log.info("My account heading");
		sa.assertTrue(l1.getWebElement("MyAccount_Heading", "Profile\\MyAccountHome.properties").isDisplayed());
	}
	
	@Test(groups="{Regression}",description="289004,289020,125899,148683,148684,148685,148686,148687,148688,148689,148690,148691,148692,148693,148694,288243",dataProvider="register",dataProviderClass=Data.class)
	public void TC05_PaymentValidations(TestData t) throws Exception
	{
		
		log.info("Clear fielsd after every entry");
		l1.getWebElement("PaymentSettings_NameOnCard", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_Number", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_FirstName", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_LastName", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_Address1", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_Address2", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_City", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_Zipcode", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_Phone", "Profile\\PaymentSettings.properties").clear();
		l1.getWebElement("PaymentSettings_Email", "Profile\\PaymentSettings.properties").clear();
		
		log.info("fetching data from data providers");
		l1.getWebElement("PaymentSettings_NameOnCard", "Profile\\PaymentSettings.properties").sendKeys(t.get(0));
		gVar.handlingDropdown("PaymentSettings_type", "Profile\\PaymentSettings.properties",t.get(1));
		l1.getWebElement("PaymentSettings_Number", "Profile\\PaymentSettings.properties").sendKeys(t.get(2));
		gVar.handlingDropdown("PaymentSettings_ExpiresMonth", "Profile\\PaymentSettings.properties",t.get(3));
		gVar.handlingDropdown("PaymentSettings_ExpiresYear", "Profile\\PaymentSettings.properties",t.get(4));
		l1.getWebElement("PaymentSettings_FirstName", "Profile\\PaymentSettings.properties").sendKeys(t.get(5));
		l1.getWebElement("PaymentSettings_LastName", "Profile\\PaymentSettings.properties").sendKeys(t.get(6));
		l1.getWebElement("PaymentSettings_Address1", "Profile\\PaymentSettings.properties").sendKeys(t.get(7));
		l1.getWebElement("PaymentSettings_Address2", "Profile\\PaymentSettings.properties").sendKeys(t.get(8));
		gVar.handlingDropdown("PaymentSettings_Country", "Profile\\PaymentSettings.properties",t.get(9));
		gVar.handlingDropdown("PaymentSettings_State", "Profile\\PaymentSettings.properties",t.get(10));
		l1.getWebElement("PaymentSettings_City", "Profile\\PaymentSettings.properties").sendKeys(t.get(11));
		l1.getWebElement("PaymentSettings_Zipcode", "Profile\\PaymentSettings.properties").sendKeys(t.get(12));
		l1.getWebElement("PaymentSettings_Phone", "Profile\\PaymentSettings.properties").sendKeys(t.get(13));
		l1.getWebElement("PaymentSettings_Email", "Profile\\PaymentSettings.properties").sendKeys(t.get(14));
		
		if (i==0){
			sa.assertEquals(l1.getWebElement("PaymentSettings_Nameoncard_error", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Number", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_FirstName", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_LastName", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Address1", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_City", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Zipcode", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Phone", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Email", "Profile\\PaymentSettings.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,7));

			sa.assertEquals(l1.getWebElement("PaymentSettings_Nameoncard_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentNameOnCard_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Number_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentNumber_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_FirstName_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentFirstName_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_LastName_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentLastName_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Address1_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentAddress1_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_City_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentCity_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Zipcode_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentZipcode_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Phone_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentPhone_Blank_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Email_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentEmail_Blank_ErrorMessage"));

		}
		else if (i==1 || i==2 || i==3){
			sa.assertEquals(l1.getWebElement("PaymentSettings_Zipcode_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentZipcode_Specialcharacter_Errormessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Phone_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentPhone_Specialcharacter_Errormessage"));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Email_error","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","PaymentEmail_Specialcharacter_Errormessage"));

		}
		
		else if(i==4)
		{
			sa.assertEquals(l1.getWebElement("PaymentSettings_Nameoncard_error", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",2,6));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Number", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",2,7));
			sa.assertEquals(l1.getWebElement("PaymentSettings_FirstName", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",2,8));
			sa.assertEquals(l1.getWebElement("PaymentSettings_LastName", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",2,9));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Address1", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",2,10));
			sa.assertEquals(l1.getWebElement("PaymentSettings_City", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",2,11));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Zipcode", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",2,12));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Phone", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",2,13));
			sa.assertEquals(l1.getWebElement("PaymentSettings_Email", "Profile\\PaymentSettings.properties").getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",2,14));
			
		}
	

}
	
	@Test(groups="{Regression}",description="124790,128534")
	public void TC03_DeleteCard() throws Exception
	{
		log.info("Deleting the added card");
		p.DeleteCreditCard();
	}
	
	@Test(groups="{Regression}",description="124779")
	public void TC04_PaymentSettings_LeftNav_navigation() throws Exception
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
			l1.getWebElement("MyAccount_PaymentSettings","Profile\\MyAccountHome.properties").click();
			
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
			l1.getWebElement("MyAccount_PaymentSettings","Profile\\MyAccountHome.properties").click();
		
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
	

