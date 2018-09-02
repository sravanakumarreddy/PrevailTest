package com.prevail.profile;


import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.prevail.projectspec.GlobalFunctions;
import com.prevail.projectspec.ProfileFunctions;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.GetDriver;
import com.prevail.utilgeneric.TestData;

public class Address extends BaseTest{
	
	
	@Test(groups="{Regression}",description="288240_124764_124763_124761_124767_124766")
	public void TC01_AddressOverlayUI() throws Exception
	{
		log.info("Login");
		p.loginToAppliction();
		System.out.println("app logged in");
		//Navigate to Address page
		log.info("Click on Address link");
		l1.getWebElement("Address_Link_AccountLandingPage","Profile\\Addresses.properties").click();
		log.info("Delete address");
		p.DeleteAddress();
		//Address title
		sa.assertTrue(gVar.assertVisible("Address_heading", "Profile\\Addresses.properties"),"Address Heading");
		//Breadcrumb elements
		sa.assertTrue(gVar.assertVisible("Address_breadcrumb", "Profile\\Addresses.properties"),"Address page breadcrumb");
		sa.assertTrue(gVar.assertVisible("Address_breadcrumb", "Profile\\Addresses.properties",0),"MyAccount breadcrumb element");
		sa.assertTrue(gVar.assertVisible("Address_breadcrumb", "Profile\\Addresses.properties",1),"Address breadcrumb element");
		//Left nav panel
		sa.assertTrue(gVar.assertVisible("LeftNav_Panel", "Profile\\Addresses.properties"),"Left Navigation panel");
		//Create Address buttons
		sa.assertTrue(gVar.assertVisible("Address_CreateNew_Button", "Profile\\Addresses.properties"),"Create Address button");
		
		//Breadcrumb Address not clickable 
		if(l1.getWebElement("Address_breadcrumb_Element", "Profile\\Addresses.properties").getAttribute("href")==null)
		{
			System.out.println("Address breadcrumb is not a a link");
		}
		else
		{
			System.out.println("Address is a link and a clickable");
		}
		//Navigation to MyAccount page 
		log.info("Click on MyAcct Breadcrumb");
		l1.getWebElements("Address_breadcrumb", "Profile\\Addresses.properties").get(0).click();
		sa.assertTrue(gVar.assertVisible("MyAccount_options", "Profile\\MyAccountHome.properties"),"My Account page with options");
		//Navigate to Address page
		log.info("Click on Address link");
		l1.getWebElement("Address_Link_AccountLandingPage","Profile\\Addresses.properties").click();
		//Create New Address
		log.info("Click on Create New Address button ");
		l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
		//p.AddressOverlay_UI();	
		//To check elements are visible or not 
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_Close", "Profile\\Addresses.properties"),"Address overlay close icon");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_Heading", "Profile\\Addresses.properties"),"Address_Overlay_Heading");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_RequiredText", "Profile\\Addresses.properties"),"Address_Overlay_RequiredText");
		 sa.assertTrue(gVar.assertVisible("AddressName_Label", "Profile\\Addresses.properties"),"AddressName_Label");
		 sa.assertTrue(gVar.assertVisible("Address_AddressName", "Profile\\Addresses.properties"),"Address_AddressName textbox");
		 sa.assertTrue(gVar.assertVisible("Address_FirstName_Label", "Profile\\Addresses.properties"),"Address_FirstName_Label");
		 sa.assertTrue(gVar.assertVisible("Address_FirstName", "Profile\\Addresses.properties"),"Address_FirstName");
		 sa.assertTrue(gVar.assertVisible("Address_LastName_Label", "Profile\\Addresses.properties"),"Address_LastName_Label");
		 sa.assertTrue(gVar.assertVisible("Address_LastName", "Profile\\Addresses.properties"),"Address_LastName");
		 sa.assertTrue(gVar.assertVisible("Address_Address1_Label", "Profile\\Addresses.properties"),"Address_Address1_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Address1", "Profile\\Addresses.properties"),"Address_Address1 textbox");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_Address1StaticText", "Profile\\Addresses.properties"));
		 sa.assertTrue(gVar.assertVisible("Address_Address2_Label", "Profile\\Addresses.properties"),"Address_Address2_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Address2", "Profile\\Addresses.properties"),"Address_Address2 textbox");
		 sa.assertTrue(gVar.assertVisible("Address_City_Label", "Profile\\Addresses.properties"),"Address_City_Label");
		 sa.assertTrue(gVar.assertVisible("Address_City", "Profile\\Addresses.properties"),"Address_City textbox");
		 sa.assertTrue(gVar.assertVisible("Address_State_Label", "Profile\\Addresses.properties"),"Address_State_Label");
		 sa.assertTrue(gVar.assertVisible("Address_State", "Profile\\Addresses.properties"),"Address_State dropdown");
		 sa.assertTrue(gVar.assertVisible("Address_Postal_Label", "Profile\\Addresses.properties"),"Address_Postal_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Postal", "Profile\\Addresses.properties"),"Address_Postal textbox");
		 sa.assertTrue(gVar.assertVisible("Address_Country_Label", "Profile\\Addresses.properties"),"Address_Country_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Country", "Profile\\Addresses.properties"),"Address_Country dropdown");
		 sa.assertTrue(gVar.assertVisible("Address_Phone_Label", "Profile\\Addresses.properties"),"Address_Phone_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_WhyThisRequired", "Profile\\Addresses.properties"),"Address_Overlay_WhyThisRequired");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_PhoneEx", "Profile\\Addresses.properties"),"Address_Overlay_PhoneEx");
		 sa.assertTrue(gVar.assertVisible("Address_phone", "Profile\\Addresses.properties"),"Address_phone Textbox");
		 sa.assertTrue(gVar.assertVisible("Address_ApplyButton", "Profile\\Addresses.properties"),"Address_ApplyButton");
		 sa.assertTrue(gVar.assertVisible("Address_CancelButton", "Profile\\Addresses.properties"),"Address_CancelButton");
		//Close
		 log.info("Close Address_Overlay");
		l1.getWebElement("Address_Overlay_Close", "Profile\\Addresses.properties").click();
		if(l1.getWebElement("Address_Overlay", "Profile\\Addresses.properties").isDisplayed())
		{
			System.out.println("Address Overlay is not closed");
		}
		else
		{
			System.out.println("Address Overlay closed");
		}
		//Create New Address
		log.info("Click Create Address");
		l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
		log.info("Clear fiels");
		p.ClearAddressFiles();
		//Enter address
		log.info("Enter Address 2");
		p.EnterAddressValues("\\data\\ProfileData.xls","Address",2);
		//cancel
		log.info("Click on Cancel");
		l1.getWebElement("Address_CancelButton", "Profile\\Addresses.properties").click();
		//Address list
		sa.assertFalse(gVar.assertVisible("Address_List", "Profile\\Addresses.properties"));

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124770_288239_124775_148670_124775_124777_124757_148672")
	public void TC02_EnterAddress_EditAddress_link() throws Exception
	{	
		log.info("Login");
		p.loginToAppliction();
		System.out.println("app logged in");
		//Navigate to Address page
		log.info("Click on Address link");
		l1.getWebElement("Address_Link_AccountLandingPage","Profile\\Addresses.properties").click();
		log.info("Delete address");
		p.DeleteAddress();
		
		//Create New Address
		log.info("Click Create Address");
		l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
		Thread.sleep(2000);
		log.info("Enter address1");
		p.EnterAddressValues("\\data\\ProfileData.xls","Address",1);
		log.info("Click on Apply button");
		l1.getWebElement("Address_ApplyButton","Profile\\Addresses.properties").click();
		Thread.sleep(2000);
		//Default Address heading
		sa.assertTrue(gVar.assertVisible("Address_DefaultAddress_Heading", "Profile\\Addresses.properties"),"Address_DefaultAddress_Heading");
		//Address Title
		sa.assertEquals(gVar.assertEqual("Addsress_Default_Title", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,10));
		//FN LN
		sa.assertEquals(gVar.assertEqual("Addsress_Fname_Lname", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,11));
		//Mini-address
		sa.assertEquals(gVar.assertEqual("Address_DefaultAddress", "Profile\\Addresses.properties").toString(), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,12));
		//Delete link
		sa.assertTrue(gVar.assertVisible("Address_Delete_Link", "Profile\\Addresses.properties"),"Delete Address link");
		//Edit link
		sa.assertTrue(gVar.assertVisible("Address_Edit_Link", "Profile\\Addresses.properties"),"Edit Address link");
		log.info("Click on Edit link");
		l1.getWebElement("Address_Edit_Link", "Profile\\Addresses.properties").click();
		Thread.sleep(1000);
		//Edit address overlay
		//To check elements are visible or not 
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_Close", "Profile\\Addresses.properties"),"Address overlay close icon");
		 sa.assertTrue(gVar.assertVisible("Address_Edit_Overlay_Heading", "Profile\\Addresses.properties"),"Address_Overlay_Heading");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_RequiredText", "Profile\\Addresses.properties"),"Address_Overlay_RequiredText");
		 sa.assertTrue(gVar.assertVisible("AddressName_Label", "Profile\\Addresses.properties"),"AddressName_Label");
		 sa.assertTrue(gVar.assertVisible("Address_AddressName", "Profile\\Addresses.properties"),"Address_AddressName textbox");
		 sa.assertTrue(gVar.assertVisible("Address_FirstName_Label", "Profile\\Addresses.properties"),"Address_FirstName_Label");
		 sa.assertTrue(gVar.assertVisible("Address_FirstName", "Profile\\Addresses.properties"),"Address_FirstName");
		 sa.assertTrue(gVar.assertVisible("Address_LastName_Label", "Profile\\Addresses.properties"),"Address_LastName_Label");
		 sa.assertTrue(gVar.assertVisible("Address_LastName", "Profile\\Addresses.properties"),"Address_LastName");
		 sa.assertTrue(gVar.assertVisible("Address_Address1_Label", "Profile\\Addresses.properties"),"Address_Address1_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Address1", "Profile\\Addresses.properties"),"Address_Address1 textbox");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_Address1StaticText", "Profile\\Addresses.properties"));
		 sa.assertTrue(gVar.assertVisible("Address_Address2_Label", "Profile\\Addresses.properties"),"Address_Address2_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Address2", "Profile\\Addresses.properties"),"Address_Address2 textbox");
		 sa.assertTrue(gVar.assertVisible("Address_City_Label", "Profile\\Addresses.properties"),"Address_City_Label");
		 sa.assertTrue(gVar.assertVisible("Address_City", "Profile\\Addresses.properties"),"Address_City textbox");
		 sa.assertTrue(gVar.assertVisible("Address_State_Label", "Profile\\Addresses.properties"),"Address_State_Label");
		 sa.assertTrue(gVar.assertVisible("Address_State", "Profile\\Addresses.properties"),"Address_State dropdown");
		 sa.assertTrue(gVar.assertVisible("Address_Postal_Label", "Profile\\Addresses.properties"),"Address_Postal_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Postal", "Profile\\Addresses.properties"),"Address_Postal textbox");
		 sa.assertTrue(gVar.assertVisible("Address_Country_Label", "Profile\\Addresses.properties"),"Address_Country_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Country", "Profile\\Addresses.properties"),"Address_Country dropdown");
		 sa.assertTrue(gVar.assertVisible("Address_Phone_Label", "Profile\\Addresses.properties"),"Address_Phone_Label");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_WhyThisRequired", "Profile\\Addresses.properties"),"Address_Overlay_WhyThisRequired");
		 sa.assertTrue(gVar.assertVisible("Address_Overlay_PhoneEx", "Profile\\Addresses.properties"),"Address_Overlay_PhoneEx");
		 sa.assertTrue(gVar.assertVisible("Address_phone", "Profile\\Addresses.properties"),"Address_phone Textbox");
		 sa.assertTrue(gVar.assertVisible("Address_ApplyButton", "Profile\\Addresses.properties"),"Address_ApplyButton");
		 sa.assertTrue(gVar.assertVisible("Address_CancelButton", "Profile\\Addresses.properties"),"Address_CancelButton");
		 //Address name
		sa.assertEquals(gVar.assertEqual("Address_AddressName", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,0));
		//Firstname
		sa.assertEquals(gVar.assertEqual("Address_FirstName", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,1));
		//lastname
		sa.assertEquals(gVar.assertEqual("Address_LastName", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,2));
		//Address1
		sa.assertEquals(gVar.assertEqual("Address_Address1", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,3));
		//Address2
		sa.assertEquals(gVar.assertEqual("Address_Address2", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,4));
		//City
		sa.assertEquals(gVar.assertEqual("Address_City", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,5));
		//State
		sa.assertEquals((new Select(l1.getWebElement("Address_State", "Profile\\Addresses.properties"))).getFirstSelectedOption().getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,6));
		//Postal
		sa.assertEquals(gVar.assertEqual("Address_Postal", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,7));
		//Country
		sa.assertEquals((new Select(l1.getWebElement("Address_Country", "Profile\\Addresses.properties"))).getFirstSelectedOption().getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,8));
		//Phone
		sa.assertEquals(gVar.assertEqual("Address_phone", "Profile\\Addresses.properties", "value"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",1,9));
		//Close
		log.info("Click on Address overlay close");
		l1.getWebElement("Address_Overlay_Close", "Profile\\Addresses.properties").click();		
		//sa.assertFalse(gVar.assertVisible("Address_Overlay", "Profile\\Addresses.properties"),"");
		sa.assertTrue(gVar.assertNotVisible("Address_Overlay", "Profile\\Addresses.properties"),"Address overlay should close");
		//Edit address
		log.info("Click Address Edit link");
		l1.getWebElement("Address_Edit_Link", "Profile\\Addresses.properties").click();
      	log.info("Clear Fields");
        p.ClearAddressFiles();
		//Address 2
		log.info("Enter Address 2");
		p.EnterAddressValues("\\data\\ProfileData.xls","Address",2);
		//cancel
		log.info("click on Cancel");
		l1.getWebElement("Address_CancelButton", "Profile\\Addresses.properties").click();
		Thread.sleep(1000);
		//Address Title
		sa.assertNotEquals(gVar.assertEqual("Addsress_Default_Title", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",2,10));
		//FN LN
		sa.assertNotEquals(gVar.assertEqual("Addsress_Fname_Lname", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",2,11));
		//Mini-address
		sa.assertNotEquals(gVar.assertEqual("Address_DefaultAddress", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",2,12));
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124778")
	public void TC03_EditAddress() throws Exception
	{
		//Edit address
		log.info("Click on Edit Address");
		l1.getWebElement("Address_Edit_Link", "Profile\\Addresses.properties").click();
		Thread.sleep(2000);
      	log.info("Clear Fields");
        p.ClearAddressFiles();
		//Address 2
		log.info("Enter Address 2");
		p.EnterAddressValues("\\data\\ProfileData.xls","Address",2);
		//Apply
		log.info("Click on Apply button");
		l1.getWebElement("Address_ApplyButton","Profile\\Addresses.properties").click();
		Thread.sleep(5000);
		//Default Address heading
		sa.assertTrue(gVar.assertVisible("Address_DefaultAddress_Heading", "Profile\\Addresses.properties"),"Address_DefaultAddress_Heading");
		//Address Title
		sa.assertEquals(gVar.assertEqual("Addsress_Default_Title", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",2,10));
		//FN LN
		sa.assertEquals(gVar.assertEqual("Addsress_Fname_Lname", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",2,11));
		//Mini-address
		sa.assertEquals(gVar.assertEqual("Address_DefaultAddress", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","Address",2,12));
		//Delete link
		sa.assertTrue(gVar.assertVisible("Address_Delete_Link", "Profile\\Addresses.properties"),"Address_Delete_Link");
		//Edit link
		sa.assertTrue(gVar.assertVisible("Address_Edit_Link", "Profile\\Addresses.properties"),"Address_Edit_Link");
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(dataProvider="AddressDataValidation",dataProviderClass=Data.class, description="128532/148661/148662/148663/148664/148667/148668/148669/148666")
	public void TC04_AddAddress_Validations(TestData t) throws Exception
	{
		
		//navigate to Address page
		//p.NavigateToAddressPage();
        log.info("Add address overlay validations");
        //Create New Address
        log.info("Click on Address_CreateNew_Button");
      	l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
      	Thread.sleep(2000);
      	log.info("Clear Fields");
        p.ClearAddressFiles();
      	//Enter address
      	log.info("Enter Address name");
        l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").sendKeys(t.get(0));
        log.info("Enter Firstname");
        l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").sendKeys(t.get(1));
        log.info("Enter Lastname");
        l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").sendKeys(t.get(2));
        log.info("Enter Address1");
        l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").sendKeys(t.get(3));
        log.info("Enter Address2");
        l1.getWebElement("Address_Address2", "Profile\\Addresses.properties").sendKeys(t.get(4));
        log.info("Enter City");
        l1.getWebElement("Address_City", "Profile\\Addresses.properties").sendKeys(t.get(5));
        log.info("Select state ");
        gVar.handlingDropdown("Address_State", "Profile\\Addresses.properties",t.get(6));
        log.info("Enter Postal");
        l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").sendKeys(t.get(7));
        log.info("Enter Phone");
        l1.getWebElement("Address_phone", "Profile\\Addresses.properties").sendKeys(t.get(8));

        log.info("Click on Apply Button");
        l1.getWebElement("Address_ApplyButton", "Profile\\Addresses.properties").click();    
        Thread.sleep(2000);
        //Validation and error messages
        if(i==0)
        {
        	log.info("Blank validation");
        //AddressNameError message
        sa.assertEquals(gVar.assertEqual("Address_AddressName_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","AddressName_ErrorMessage"));
    	//sa.assertEquals(gVar.assertEqual("Address_AddressName_Error", "Profile\\Addresses.properties")).getText(), l1.getWebElement("AddressName_ErrorMessage", "ErrorMessages\\ErrorMessages.properties").getText());
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_AddressName_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//FNError message
    	sa.assertEquals(gVar.assertEqual("Address_Firstname_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","FirstName_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Firstname_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        
    	//LNError message
    	sa.assertEquals(gVar.assertEqual("Address_Lastname_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","LastName_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Lastname_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        
    	//Address1 Error message
    	sa.assertEquals(gVar.assertEqual("Address_Address1_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Address1_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Address1_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//City Error message
    	sa.assertEquals(gVar.assertEqual("Address_City_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","City_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_City_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_City", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//State Error message
    	sa.assertEquals(gVar.assertEqual("Address_State_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","State_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_State_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_State", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//Zipcode Error message
    	sa.assertEquals(gVar.assertEqual("Address_Postal_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Zipcode_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Postal_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//Phone Error message
    	sa.assertEquals(gVar.assertEqual("Address_Phone_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Phone_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Phone_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_phone", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
	
        }
        
        else if(i==1 || i==2 || i==3 || i==4 || i==5)
        {
        	//Zipcode Error message
        	sa.assertEquals(gVar.assertEqual("Address_Postal_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Zipcode_ErrorMessage1"));
        	//Text color FN
        	sa.assertEquals(l1.getWebElement("Address_Postal_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
        	//Box color
        	sa.assertEquals(l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        	
        	//Phone Error message
        	sa.assertEquals(gVar.assertEqual("Address_Phone_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Phone_ErrorMessage1"));
        	//Text color FN
        	sa.assertEquals(l1.getWebElement("Address_Phone_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
        	//Box color
        	sa.assertEquals(l1.getWebElement("Address_phone", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        
       	 if(i==4)
        	 {	
        	 	log.info("Max characters");
        	 	log.info("AddressName");
        		sa.assertEquals(l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").getText().length(),20);
        	 	log.info("Firstname");
        		sa.assertEquals(l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Lastname");
        		sa.assertEquals(l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Address1");
        		sa.assertEquals(l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Address2");
        		sa.assertEquals(l1.getWebElement("Address_Address2", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("City");
        		sa.assertEquals(l1.getWebElement("Address_City", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Zipcode");
        		sa.assertEquals(l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").getText().length(),10);
        		log.info("Phone");
        		sa.assertEquals(l1.getWebElement("Address_phone", "Profile\\Addresses.properties").getText().length(),20);      
        	 }
        	 
        	 else if(i==5)
        	 {
        		//Single character
        		//City Error message
            	sa.assertEquals(gVar.assertEqual("Address_City_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","City_ErrorMessage1"));
            	//Text color FN
            	sa.assertEquals(l1.getWebElement("Address_City_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
            	//Box color
            	sa.assertEquals(l1.getWebElement("Address_City", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        	 }	
        }
        
        else if(i==6)
        {
        	//Existing Address Error Message
        	//sa.assertFalse(false,"Error message is not displayed instead blank pop-up is displayed");
        	System.out.println("Error message is not displayed");
        }
        i++;
      //Close
		log.info("Click on Address overlay close");
		l1.getWebElement("Address_Overlay_Close", "Profile\\Addresses.properties").click();	
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="124769")
	public void TC05_Add_Address_Overlay_Tolltip() throws Exception
	{
		p.NavigateToAddressPage();
        //Create New Address
		log.info("Click Create Address");
		l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
		Thread.sleep(2000);
        gVar.MouseHover("Address_Overlay_WhyThisRequired", "Profile\\Addresses.properties");
        sa.assertTrue(gVar.assertVisible("Address_Overlay_ToolTip", "Profile\\Addresses.properties"));      
        log.info("Click on Close icon");
        l1.getWebElement("Address_Overlay_Close", "Profile\\Addresses.properties").click();
	}
	
	@Test(groups="{Regression}",description="148671")
	public void TC06_Edit_Address_Overlay_Tolltip() throws Exception
	{			
		//Edit address
      	log.info("Click on Edit Address");
      	l1.getWebElement("Address_Edit_Link", "Profile\\Addresses.properties").click();
      	gVar.MouseHover("Address_Overlay_WhyThisRequired", "Profile\\Addresses.properties");
        sa.assertTrue(gVar.assertVisible("Address_Overlay_ToolTip", "Profile\\Addresses.properties"));
      	log.info("Click on Close icon");
        l1.getWebElement("Address_Overlay_Close", "Profile\\Addresses.properties").click();
        Thread.sleep(3000);
	}

	@Test(groups="{Regression}",description="124774")
	public void TC07_Make_Address_Default() throws Exception
	{
		log.info("Login");
		p.loginToAppliction();
		System.out.println("app logged in");
		//Navigate to Address page
		log.info("Click on Address link");
		l1.getWebElement("Address_Link_AccountLandingPage","Profile\\Addresses.properties").click();
		log.info("Delete address");
		//p.DeleteAddress();
		
		log.info("Delete Address");
		p.DeleteAddress();
		Thread.sleep(2000);
		log.info("Enter 2 Addresses");
		for(int i=2;i>=1;i--)
		{
			//Create New Address
			log.info("Click Create Address");
			l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
			Thread.sleep(2000);
			log.info("Enter address"+i);
			p.EnterAddressValues("\\data\\ProfileData.xls","Address",i);
	        log.info("Click on Apply Button");
	        l1.getWebElement("Address_ApplyButton", "Profile\\Addresses.properties").click();
			Thread.sleep(5000);
		}
		
		String DefaultAddress=l1.getWebElement("Address_DefaultAddress", "Profile\\Addresses.properties").getText();
		String MakeDefaultAddress=l1.getWebElement("Address_MakeDefault_MiniAddress", "Profile\\Addresses.properties").getText();
		log.info("Make Address Default");
		l1.getWebElement("Address_MakeDefault_link", "Profile\\Addresses.properties").click();
		Thread.sleep(3000);
		String DefaultAddress1=l1.getWebElement("Address_DefaultAddress", "Profile\\Addresses.properties").getText();
		String MakeDefaultAddress1=l1.getWebElement("Address_MakeDefault_MiniAddress", "Profile\\Addresses.properties").getText();
		sa.assertEquals(MakeDefaultAddress, DefaultAddress1);
		sa.assertEquals(DefaultAddress, MakeDefaultAddress1);
		//Need to verify Make default link present o no: The Make default anchor tag/href is included in Address_MakeDefault_MiniAddress		
		i=0;
	}	
	
	@Test(dataProvider="AddressDataValidation",dataProviderClass=Data.class, description="148681/148682/148673/148674/148675/148676/148677/148679/148680")
	public void TC08_EditAddress_Validations(TestData t) throws Exception
	{
		
		//navigate to Address page
		//p.NavigateToAddressPage();
		
        log.info("Edit address overlay validations");
        //Edit address
      	log.info("Click on Edit Address");
      	l1.getWebElement("Address_Edit_Link", "Profile\\Addresses.properties").click();
      	Thread.sleep(2000);
        log.info("Clear Fields"+i);
        p.ClearAddressFiles();
      	
        //Enter address
        log.info("Loop : "+i);
      	log.info("Enter Address name"+i);
        l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").sendKeys(t.get(0));
        log.info("Enter Firstname");
        l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").sendKeys(t.get(1));
        log.info("Enter Lastname");
        l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").sendKeys(t.get(2));
        log.info("Enter Address1");
        l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").sendKeys(t.get(3));
        log.info("Enter Address2");
        l1.getWebElement("Address_Address2", "Profile\\Addresses.properties").sendKeys(t.get(4));
        log.info("Enter City");
        l1.getWebElement("Address_City", "Profile\\Addresses.properties").sendKeys(t.get(5));
        log.info("Select state ");
        gVar.handlingDropdown("Address_State", "Profile\\Addresses.properties",t.get(6));
        log.info("Enter Postal");
        l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").sendKeys(t.get(7));
        log.info("Enter Phone");
        l1.getWebElement("Address_phone", "Profile\\Addresses.properties").sendKeys(t.get(8));

        log.info("Click on Apply Button");
        l1.getWebElement("Address_EditApply_Button", "Profile\\Addresses.properties").click();
        Thread.sleep(4000);
        
        //Validation and error messages
        if(i==0)
        {
        log.info("Blank validation");
        //AddressNameError message
        sa.assertEquals(gVar.assertEqual("Address_AddressName_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","AddressName_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_AddressName_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//FNError message
    	sa.assertEquals(gVar.assertEqual("Address_Firstname_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","FirstName_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Firstname_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        
    	//LNError message
    	sa.assertEquals(gVar.assertEqual("Address_Lastname_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","LastName_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Lastname_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        
    	//Address1 Error message
    	sa.assertEquals(gVar.assertEqual("Address_Address1_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Address1_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Address1_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//City Error message
    	sa.assertEquals(gVar.assertEqual("Address_City_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","City_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_City_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_City", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//State Error message
    	sa.assertEquals(gVar.assertEqual("Address_State_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","State_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_State_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_State", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//Zipcode Error message
    	sa.assertEquals(gVar.assertEqual("Address_Postal_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Zipcode_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Postal_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
    	
    	//Phone Error message
    	sa.assertEquals(gVar.assertEqual("Address_Phone_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Phone_ErrorMessage"));
    	//Text color FN
    	sa.assertEquals(l1.getWebElement("Address_Phone_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
    	//Box color
    	sa.assertEquals(l1.getWebElement("Address_phone", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        
        }
        
        else if(i==1 || i==2 || i==3 || i==4 || i==5)
        {
        	//Zipcode Error message
        	sa.assertEquals(gVar.assertEqual("Address_Postal_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Zipcode_ErrorMessage1"));
        	//Text color FN
        	sa.assertEquals(l1.getWebElement("Address_Postal_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
        	//Box color
        	sa.assertEquals(l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        	
        	//Phone Error message
        	sa.assertEquals(gVar.assertEqual("Address_Phone_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Phone_ErrorMessage1"));
        	//Text color FN
        	sa.assertEquals(l1.getWebElement("Address_Phone_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
        	//Box color
        	sa.assertEquals(l1.getWebElement("Address_phone", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        
        	 if(i==4)
        	 {	
        	 	log.info("Max characters");
        	 	log.info("AddressName");
        		sa.assertEquals(l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").getText().length(),20);
        	 	log.info("Firstname");
        		sa.assertEquals(l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Lastname");
        		sa.assertEquals(l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Address1");
        		sa.assertEquals(l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Address2");
        		sa.assertEquals(l1.getWebElement("Address_Address2", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("City");
        		sa.assertEquals(l1.getWebElement("Address_City", "Profile\\Addresses.properties").getText().length(),50);
        		log.info("Zipcode");
        		sa.assertEquals(l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").getText().length(),10);
        		log.info("Phone");
        		sa.assertEquals(l1.getWebElement("Address_phone", "Profile\\Addresses.properties").getText().length(),20);      
        	 }
        	 
        	else if(i==5)
        	{
        		//Single character
        		//City Error message
            	sa.assertEquals(gVar.assertEqual("Address_City_Error", "Profile\\Addresses.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","City_ErrorMessage1"));
            	//Text color FN
            	sa.assertEquals(l1.getWebElement("Address_City_Error", "Profile\\Addresses.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
            	//Box color
            	sa.assertEquals(l1.getWebElement("Address_City", "Profile\\Addresses.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
        	}	      
        }
        
        else if(i==6)
        {
        	//Existing Address Error Message
        	//sa.assertFalse(false,"Error message is not displayed instead blank pop-up is displayed");
        	System.out.println("Error message is not displayed");	
          	//Handling alert popup
          	Alert alert = GetDriver.driver.switchTo().alert();
          	alert.accept();
        }   
        i++; 
		//Close
		log.info("Click on Address overlay close");
		l1.getWebElement("Address_Overlay_Close", "Profile\\Addresses.properties").click();		
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124776")
	public void TC09_Delete_EditAddressOverlay_Default() throws Exception
	{
		//Deleting one among Saved address
		log.info("Edit address overlay validations");
        //Edit address
      	log.info("Click on Edit Address");
      	l1.getWebElement("Address_Edit_Link", "Profile\\Addresses.properties").click();
      	log.info("Click on Delete button");
      	l1.getWebElement("Address_EditOverlay_Delete_Button", "Profile\\Addresses.properties").click();
      	//Handling alert popup
      	Alert alert = GetDriver.driver.switchTo().alert();
      	alert.accept();
      	Thread.sleep(3000);
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124773")
	public void TC10_Cancel_Functionality_DeleteOverlay() throws Exception
	{
		//Cancel functionality one among saved address
		log.info("Click on Delete Link");
		l1.getWebElement("Address_Delete_Buttons","Profile\\Addresses.properties").click();
      	//Handling alert pop-up
      	Alert alert = GetDriver.driver.switchTo().alert();
      	//Click on Cancel
      	alert.dismiss();
      	Thread.sleep(3000);
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124772")
	public void TC11_Delete_link_Default_Address() throws Exception
	{
		log.info("Delete all the saved address");
		p.DeleteAddress();
		for(int i=1;i<3;i++)
		{
			//Enter 2 New Address
			log.info("Click Create Address");
			l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
			log.info("Enter address1");
			log.info("Clear fiels");
			p.ClearAddressFiles();
			p.EnterAddressValues("\\data\\ProfileData.xls","Address",i);
			log.info("Click on Apply button");
			l1.getWebElement("Address_ApplyButton","Profile\\Addresses.properties").click();
			Thread.sleep(5000);
		}	
		log.info("Delete the Default address");
		l1.getWebElement("Address_DefaultAddress_Delete_link", "Profile\\Addresses.properties").click();
		//Handling alert popup
		Alert alert = GetDriver.driver.switchTo().alert();
      	//Click on Delete
      	alert.accept();
      	Thread.sleep(5000);
      	//Default address should not display
      	sa.assertFalse(gVar.assertVisible("Address_DefaultAddress_Delete_link", "Profile\\Addresses.properties"),"Default address delete link not displayed");
      	sa.assertFalse(gVar.assertVisible("Address_DefaultAddress", "Profile\\Addresses.properties"),"Default Address not displayed");
		
		//It will return all the assertions
		sa.assertAll();
	}	
	
	@Test(groups="{Regression}",description="288241/124771")
	public void TC12_Deleting_Saved_Address_Address() throws Exception
	{
		log.info("Delete Saved address");
		p.DeleteAddress();
		sa.assertTrue(gVar.assertNotVisible("Address_List", "Profile\\Addresses.properties"),"No Addresses should display");
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124553")
	public void TC13_LeftNavLinks_288270_148639_148640() throws Exception
	{
		//navigate to Address page
		p.NavigateToAddressPage();
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{
			//navigate to Address page
			p.NavigateToAddressPage();			
			//Link Display verification
			sa.assertTrue(gVar.assertVisible("LeftNav_Links","Profile\\login.properties",i),"LeftNav links display");
			String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
			sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,6));
			
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 3).toString();
			//String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 4);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
			//sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties",1), Expected_LeftnavBreadcrumb);
		}
		//navigate to Address page
		p.NavigateToAddressPage();
		
		log.info("Take Count of left nav Headings");				
		int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
		for (int i=1;i<=LeftNavHeadings;i++)
		{
			log.info("Left nav headings");
			String leftNavHeading=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i-1).getText();
			sa.assertEquals(leftNavHeading,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i,5));
		}
		
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(0).getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		//It will return all the assertions
		sa.assertAll();
	}
	
}