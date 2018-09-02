package com.prevail.profile;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class MyAcc_Home extends BaseTest
{
	
	@Test(groups="{Regression}",description="148653")
	public void TC00_MyAcc_ordersLink(XmlTest xmlTest) throws Exception
	{
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link");
		l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
		log.info("Login to the application");
		p.loginToAppliction(xmlTest);
		log.info("Myaccount section page verificatrion");
        sa.assertTrue(gVar.assertVisible("MyAccount_options", "Profile\\MyAccountHome.properties"),"MyAccount landing page");
		log.info("Click on orders");
		l1.getWebElement("MyAccount_Orders", "Profile\\MyAccountHome.properties").click();
		log.info("Order history page heading");
		sa.assertTrue(gVar.assertVisible("OrderHistory_Heading", "Profile\\OrderHistory.properties"),"Order History heading");
		log.info("Click on MyAccunt link in breadcrumb");
		l1.getWebElements("CheckOrderStatus_OrderHistory_Breadcrumb", "Profile\\OrderHistory.properties").get(0).click();
		sa.assertAll();
      }
	
   @Test(groups="{Regression}",description="288531")
	public void TC01_MyAcc_UI() throws Exception
	{
	
		sa.assertTrue(gVar.assertVisible("MyAccount_LogonFileds", "Profile\\MyAccountHome.properties"),"Login field verification");
		sa.assertTrue(gVar.assertVisible("MyAccount_LogoutLink", "Profile\\MyAccountHome.properties"),"Logout linke in myaccount page");
		sa.assertTrue(gVar.assertVisible("MyAccount_PersonalDataOption", "Profile\\MyAccountHome.properties"),"PersonalDataOption in myaccount page");
		sa.assertTrue(gVar.assertVisible("MyAccount_AddressOption", "Profile\\MyAccountHome.properties"),"AddressOption in myaccount page");
		sa.assertTrue(gVar.assertVisible("MyAccount_WishListOption", "Profile\\MyAccountHome.properties"),"WishListOption in myaccount page");
		sa.assertTrue(gVar.assertVisible("MyAccount_PaymentSettingOption", "Profile\\MyAccountHome.properties"),"PaymentSettingOption in myaccount page");
		sa.assertTrue(gVar.assertVisible("MyAccount_GiftRegistryOption", "Profile\\MyAccountHome.properties"),"GiftRegistryOptione in myaccount page");
	
		log.info("LeftNavigation Headings");
		
		int LeftNavHeading=l1.getWebElements("MyAccount_LeftNavHeadings", "Profile\\MyAccountHome.properties").size();
		
		for(i=0; i<LeftNavHeading; i++)
		{
			System.out.println("Coming inside the loop");
		    sa.assertTrue(gVar.assertVisible("LeftNav_Headings", "Profile\\login.properties", i),"LeftNavHeadings"+i);
		
		}
		
		log.info("LeftNavigation Links Verification");
		
	
		int LeftNavLinksNames=l1.getWebElements("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties").size();
		for(i=0; i<LeftNavLinksNames; i++)
		{
			 
			    sa.assertTrue(gVar.assertVisible("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties",i),"LeftNavLiks"+i);
			    

		}
		
		log.info("Need help text");
		sa.assertTrue(l1.getWebElement("LeftNav_NeedHelpTxt","Profile\\login.properties").isDisplayed());
		log.info("Contact us link text");
		sa.assertTrue(l1.getWebElement("LeftNav_ContactUs","Profile\\login.properties").isDisplayed());
		int LeftnavNeedhelpCotent=l1.getWebElements("LeftNav_NeedhelpContentAsset", "Profile\\login.properties").size();
		for(i=0; i<LeftnavNeedhelpCotent; i++)
		{
			
			 sa.assertTrue(gVar.assertVisible("LeftNav_NeedhelpContentAsset", "Profile\\login.properties",i),"LeftnavNeedhelpCotent"+i);
		}
		sa.assertAll();
		
		
	}

	
	@Test(groups="{Regression}",description="148655")
	public void TC02_MyAcc_GiftregistryLink() throws Exception
	{
		
		log.info("Click on GiftRegistry option");
		l1.getWebElement("MyAccount_GiftRegistryOption", "Profile\\MyAccountHome.properties").click();
		log.info("GiftRegistry page heading");
		sa.assertTrue(gVar.assertVisible("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"),"GiftRegistry page heading");
		l1.getWebElements("CheckOrderStatus_OrderHistory_Breadcrumb",  "Profile\\OrderHistory.properties").get(0).click();
		
	}
	
    @Test(groups="{Regression}",description="148655")
	public void TC03_MyAcc_WishListLink() throws Exception
	{
		
		log.info("Click on Wishlist option");
		l1.getWebElement("MyAccount_WishListOption", "Profile\\MyAccountHome.properties").click();
		log.info("Wishlist page heading");
		sa.assertTrue(gVar.assertVisible("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"),"WishList page heading");

		l1.getWebElements("CheckOrderStatus_OrderHistory_Breadcrumb",  "Profile\\OrderHistory.properties").get(0).click();
		sa.assertAll();
	}
	
	
		
    @Test(groups="{Regression}",description="148651")
	public void TC04_MyAcc_PersonalDataLink() throws Exception
	{
		log.info("Click on Personal data option");
		l1.getWebElement("MyAccount_PersonalDataOption", "Profile\\MyAccountHome.properties").click();
		log.info("EditAccount page heading");
		sa.assertTrue(gVar.assertVisible("EditAccount_Heading", "Profile\\EditAccount.properties"),"EditAccount page heading");
		l1.getWebElements("CheckOrderStatus_OrderHistory_Breadcrumb",  "Profile\\OrderHistory.properties").get(0).click();
	sa.assertAll();
	
	}
	
	
		
    @Test(groups="{Regression}",description="148652")
	public void TC05_MyAcc_AddressLink() throws Exception
	{
		log.info("Click on Address option");
		l1.getWebElement("MyAccount_AddressOption", "Profile\\MyAccountHome.properties").click();
		log.info("Address page heading");
		sa.assertTrue(gVar.assertVisible("Address_heading", "Profile\\Addresses.properties"),"Address page heading");

		l1.getWebElements("CheckOrderStatus_OrderHistory_Breadcrumb",  "Profile\\OrderHistory.properties").get(0).click();
	sa.assertAll();
	
	}
	
	
    @Test(groups="{Regression}",description="148646")
	public void TC06_MyAcc_LeftNavLink_Navigation() throws Exception
	{
	int LeftNavLinksNames=l1.getWebElements("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties").size();
		
		for(i=0; i<LeftNavLinksNames; i++)
		{
			if(i<=0 || i<=8)
			{
				l1.getWebElements("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties").get(i).click();
				log.info("Page heading verification");
				sa.assertEquals(gVar.assertEqual("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties"), GetData.getDataFromExcel("//data//ProfileData.xls","LeftNav", i+1, 3));
				log.info("Click on Myaccount in breadcrumb");
				l1.getWebElements("CheckOrderStatus_OrderHistory_Breadcrumb", "Profile\\OrderHistory.properties").get(0).click();
				
			}
			
			else if(i==9)
			{
				l1.getWebElements("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties").get(i).click();
				log.info("Page heading verification");
			
				sa.assertEquals(gVar.assertEqual("PrivacyPolich_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("//data//ProfileData.xls","LeftNav",i+1, 3));
				 log.info("Click on User account icon");
	        	l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
                log.info("Click on my account link from the user account flyout");
                l1.getWebElement("MyAccount_LinkinFlyout", "Profile\\MyAccountHome.properties").click();
			}
			
			else if(i==10)
			{
				l1.getWebElements("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties").get(i).click();
				log.info("Page heading verification");
				sa.assertEquals(gVar.assertEqual("SecurityPage_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("//data//ProfileData.xls","LeftNav",i+1, 3));
				 log.info("Click on User account icon");
	        	l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
                log.info("Click on my account link from the user account flyout");
                l1.getWebElement("MyAccount_LinkinFlyout", "Profile\\MyAccountHome.properties").click();
			}
			else
			{
				l1.getWebElements("MyAccount_LeftNavLinksName", "Profile\\MyAccountHome.properties").get(i).click();
				log.info("Page heading verification");
				sa.assertEquals(gVar.assertEqual("ContactUs_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("//data//ProfileData.xls","LeftNav",i+1, 3));
               
			}
			
		}
		
		sa.assertAll();
		
		
	}
	
	
	
    @Test(groups="{Regression}",description="124648")
	public void TC07_MyAcc_Logout() throws Exception
	{
    	 log.info("click on user account");
         log.info("Click on User account icon");
 		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
         log.info("Click on my account link from the user account flyout");
         l1.getWebElement("MyAccount_LinkinFlyout", "Profile\\MyAccountHome.properties").click();
		log.info("Click on Logout link");
		l1.getWebElement("MyAccount_LogoutLink", "Profile\\MyAccountHome.properties").click();
		log.info("Login page verification");
		sa.assertTrue(gVar.assertVisible("Login_Heading","Profile\\login.properties"),"Login Page verification");
		sa.assertAll();
	}
	
	
}
