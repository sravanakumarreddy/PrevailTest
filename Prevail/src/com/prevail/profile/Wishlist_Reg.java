package com.prevail.profile;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class Wishlist_Reg extends BaseTest {
	
	@Test(groups="{Regression}",description="Clear_Wishlist_Address__And_Products")
	public void TC_001_Clear_Wishlist_Address_And_Products(XmlTest XmlTest) throws Exception
	{
		//login to the application
		p.loginToAppliction(XmlTest);
		
		//navigate to wish list page
		log.info("Click on Wishlist Heading in MyAcct page");
		l1.getWebElement("MyAccount_Wishlist_link", "Profile\\MyAccountHome.properties").click();
		try
		{
			log.info("Select New address from address dropdown");
			new Select(l1.getWebElement("Wishlist_Address_dropdown", "Profile\\Wishlist.properties")).selectByIndex(0);
			//deleting if any addresses are present
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println("No Address Displayed in Wishlist page");
		}
		p.clearWishList();
		log.info("Add items to wishlist");
		p.AddItemsToWishlist();
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="289648")
	public void TC_002_Wishlist_ShippingAddress_NoDropdown() throws Exception
	{
		log.info("Click on LeftNav Address link");
		l1.getWebElement("LeftNav_Address_link", "Profile\\MyAccountHome.properties").click();
		log.info("Delete Address");
		p.DeleteAddress();
		log.info("Click on Myaccount Header");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("Click on Header Wishlist");
		l1.getWebElement("Header_Wishlist_link", "ShopNav\\HomePage.properties").click();

			sa.assertFalse(gVar.assertVisible("Wishlist_Address_dropdown", "Profile\\Wishlist.properties"),"Wishlist Shipping Address dropdown not displayed");

		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="Clear_Wishlist_Address__And_Products")
	public void TC_003_AddAddress_To_Wishlist_And_ClearWishlist() throws Exception
	{
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Click on LeftNav Address link");
		l1.getWebElement("LeftNav_Address_link", "Profile\\MyAccountHome.properties").click();
		Thread.sleep(8000);
		
		for(i=1;i<=2;i++)
		{	
			log.info("Click on create new address");
			l1.getWebElement("Address_CreateNew_Button", "Profile\\Addresses.properties").click();
			log.info("Enter Address");
			Thread.sleep(4000);
			p.EnterAddressValues("\\data\\ProfileData.xls", "Address", i);	
			log.info("Click on Apply button");
			l1.getWebElement("Address_ApplyButton","Profile\\Addresses.properties").click();
			Thread.sleep(8000);
		}
		
		log.info("Clear WishList");
		p.clearWishList();
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148714")
	public void TC_004_UI_Empty_Search_Page_Wishlist() throws Exception
	{
		log.info("Navigate to Some others wishlist");
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//Enter Keys
		log.info("Enter valid Email address not associated with wishlist");
		l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,8));
		//click on find button
		log.info("Click on Find button");
		l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
		Thread.sleep(4000);
		
		//verify the UI of empty Wish List search
		sa.assertTrue(gVar.assertVisible("Wishlist_Breadcrumb", "Profile\\Wishlist.properties"), "Wishlist page breadcrumb display");
		//fields
		sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));			
		sa.assertTrue(gVar.assertVisible("Wishlist_LastName_Label", "Profile\\Wishlist.properties"),"Lastname label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_FirstName_Label", "Profile\\Wishlist.properties"),"Firstname label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Email_Label", "Profile\\Wishlist.properties"),"Email label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_LastName", "Profile\\Wishlist.properties"),"Lastname textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_FirstName", "Profile\\Wishlist.properties"),"Firstname textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_Email", "Profile\\Wishlist.properties"),"Login Email Textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_login_Find", "Profile\\Wishlist.properties"),"Find button display");
		sa.assertTrue(gVar.assertVisible("Find_Wishlist_Page_Text", "Profile\\Wishlist.properties"),"No Wishlist found Text");
		sa.assertEquals(gVar.assertEqual("Wishlist_Login_LastName", "Profile\\Wishlist.properties"), "");
		sa.assertEquals(gVar.assertEqual("Wishlist_Login_FirstName", "Profile\\Wishlist.properties"), "");
		sa.assertEquals(gVar.assertEqual("Wishlist_Login_Email", "Profile\\Wishlist.properties"), "");
		   	
		//left nav section
		log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		for (int j=0;j<LeftNavLinksCount;j++)
		{
			sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(j).isDisplayed(),"LeftNav links display");
			String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(j).getText();
			sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",j+1,6));
		}
		
		int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
		for (int j=0;j<LeftNavHeadings;j++)
		{
			log.info("Left nav headings");
			String leftNavHeading=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(j).getText();
			sa.assertEquals(leftNavHeading,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",j+1,5));
		}
				
		//LeftNav_Needhelp_Text
		sa.assertTrue(gVar.assertVisible("LeftNav_NeedHelp_Heading","Profile\\Register.properties"),"Need help? Heading");
		sa.assertTrue(gVar.assertVisible("LeftNav_Needhelp_Text","Profile\\Register.properties"),"Need help Text");
		//Customer service
		sa.assertTrue(gVar.assertVisible("LeftNav_CustomerService", "Profile\\Register.properties"), "Customer service");
		String NoSearchFound="No wish list has been found for "+GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,8)+". Please try again.";
		sa.assertEquals(gVar.assertEqual("Wishlist_NoSearchFound", "Profile\\Wishlist.properties"), NoSearchFound);
		
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="289204")
	public void TC_005_UI_WishlistPage_With_SavedAddress() throws Exception
	{
		log.info("Navigate to Some others wishlist");
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		Thread.sleep(3000);
		//verify the UI of empty Wish List search
		sa.assertTrue(gVar.assertVisible("Wishlist_Breadcrumb", "Profile\\Wishlist.properties"), "Wishlist page breadcrumb display");
		//fields
		sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));			
		sa.assertTrue(gVar.assertVisible("Wishlist_LastName_Label", "Profile\\Wishlist.properties"),"Lastname label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_FirstName_Label", "Profile\\Wishlist.properties"),"Firstname label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Email_Label", "Profile\\Wishlist.properties"),"Email label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_LastName", "Profile\\Wishlist.properties"),"Lastname textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_FirstName", "Profile\\Wishlist.properties"),"Firstname textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_Email", "Profile\\Wishlist.properties"),"Login Email Textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_login_Find", "Profile\\Wishlist.properties"),"Find button display");
	
		//Address Dropdown	
		sa.assertTrue(gVar.assertVisible("Wishlist_Address_dropdown", "Profile\\Wishlist.properties"),"Wishlist Address Dropdown");		
		sa.assertTrue(gVar.assertVisible("Wishlist_GiftCertificate_Button", "Profile\\Wishlist.properties"),"Wishlist Gift certificate button");
		sa.assertTrue(gVar.assertVisible("Wishlist_GiftCertificate_StaticText", "Profile\\Wishlist.properties"),"Wishlist Gift certificate Static Text");
		sa.assertTrue(gVar.assertVisible("Wishlist_NoItems_StaticText", "Profile\\Wishlist.properties"),"Wishlist No Items static text ");
		sa.assertTrue(gVar.assertVisible("Wishlist_Additems_link", "Profile\\Wishlist.properties"),"Add items to Wishlist link");	
		
		//left nav section
		log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		for (int i=0;i<LeftNavLinksCount;i++)
		{
			sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).isDisplayed(),"LeftNav links display");
			String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
			sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,6));
		}
		
		int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
		for (int i=0;i<LeftNavHeadings;i++)
		{
			log.info("Left nav headings");
			String leftNavHeading=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i).getText();
			sa.assertEquals(leftNavHeading,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,5));
		}
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="124545_128724")
	public void TC_006_WishlistPage_Click_To_Start_AddingItems() throws Exception
	{

		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		p.clearWishList();
		//add products to wish list by clicking on link Click here to start adding items.
		log.info("Click on Click here to start adding items. link");
		l1.getWebElement("Wishlist_Additems_link", "Profile\\Wishlist.properties").click();
		Thread.sleep(2000);
		//verify the navigation to home page
		sa.assertTrue(gVar.assertVisible("Homepage_Slides", "ShopNav\\HomePage.properties"),"Homepage Home slides");
		sa.assertTrue(gVar.assertVisible("Homepage_Slots", "ShopNav\\HomePage.properties"),"Homepage Home slots");
		
		//navigate to sub category
		s.NavigateToPDP();
		s.SelectSwatch();
		log.info("Click on Add to wishlist");
		l1.getWebElement("PDP_AddToWishList", "ShopNav\\PDP.properties").click();
		sa.assertEquals(gVar.assertEqual("Wishlist_ProductName", "Profile\\Wishlist.properties"), s.PDP_Pname);
		//It will return all the assertions
		sa.assertAll();
	}
	
		
	@Test(groups="{Regression}",description="289203_289166_289689_148713")
	public void TC_007_UI_Wishlist_With_Product_Added(XmlTest XmlTest) throws Exception
	{		
			int rowNum=new Integer(XmlTest.getParameter("dynamicNum"));
			//navigate to wish list page
			log.info("Click on Footer wishlist");
			l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
			log.info("Enter Lastname");
			l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,1));
			log.info("Enter Firstname");
			l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,0));
			log.info("Enter Email");
			l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,2));
			//click on find button
			log.info("Click on Find Button");
			l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
			log.info("Click on View");
			l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();
			//verify the UI of Wish List search
			sa.assertTrue(gVar.assertVisible("Wishlist_Breadcrumb", "Profile\\Wishlist.properties"), "Wishlist page breadcrumb display");
			//fields
			sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));			
			sa.assertTrue(gVar.assertVisible("Wishlist_LastName_Label", "Profile\\Wishlist.properties"),"Lastname label display");
			sa.assertTrue(gVar.assertVisible("Wishlist_FirstName_Label", "Profile\\Wishlist.properties"),"Firstname label display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Email_Label", "Profile\\Wishlist.properties"),"Email label display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Login_LastName", "Profile\\Wishlist.properties"),"Lastname textbox display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Login_FirstName", "Profile\\Wishlist.properties"),"Firstname textbox display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Login_Email", "Profile\\Wishlist.properties"),"Login Email Textbox display");
			sa.assertTrue(gVar.assertVisible("Wishlist_login_Find", "Profile\\Wishlist.properties"),"Find button display");
			
			//left nav section
			log.info("Take Count of left nav links");
			int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
			for (int i=0;i<LeftNavLinksCount;i++)
			{
				sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).isDisplayed(),"LeftNav links display");
				String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
				sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,6));
			}
					
				int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
				for (int i=0;i<LeftNavHeadings;i++)
				{
					log.info("Left nav headings");
					String leftNavHeading=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i).getText();
					sa.assertEquals(leftNavHeading,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,5));
				}
					
			//LeftNav_Needhelp_Text
			sa.assertTrue(gVar.assertVisible("LeftNav_NeedHelp_Heading","Profile\\Register.properties"),"Need help? Heading");
			sa.assertTrue(gVar.assertVisible("LeftNav_Needhelp_Text","Profile\\Register.properties"),"Need help Text");
			//Customer service
			sa.assertTrue(gVar.assertVisible("LeftNav_CustomerService", "Profile\\Register.properties"), "Customer service");
			
			log.info("Wishlist name: FirstName Lastname 's Wish List");
			String WishListName= GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,0)+" "+GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,1)+" 's Wish List";
			sa.assertEquals(gVar.assertEqual("WishlistName", "Profile\\Wishlist.properties"), WishListName);
			
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductImage", "Profile\\Wishlist.properties"),"Wishlist_ProductImage display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductName", "Profile\\Wishlist.properties"),"Wishlist_ProductName display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductItemNo", "Profile\\Wishlist.properties"),"Wishlist_ProductItemNo display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductSize", "Profile\\Wishlist.properties"),"Wishlist_ProductSize display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductColor", "Profile\\Wishlist.properties"),"Wishlist_ProductColor display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductPrice", "Profile\\Wishlist.properties"),"Wishlist_ProductPrice display");
			sa.assertTrue(gVar.assertVisible("Wishlist_EditDetails_link", "Profile\\Wishlist.properties"),"Wishlist_EditDetails_Link");
			sa.assertTrue(gVar.assertVisible("Wishlist_Availability_Status", "Profile\\Wishlist.properties"),"Wishlist_Availability_Status display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Product_DateAdded", "Profile\\Wishlist.properties"),"Wishlist_Product_DateAdded display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Product_Qty_Desired", "Profile\\Wishlist.properties"),"Wishlist_Product_Qty_Desired display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Product_Priority", "Profile\\Wishlist.properties"),"Wishlist_Product_Priority display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Product_Qty", "Profile\\Wishlist.properties"),"Wishlist_Product_Qty display");
			sa.assertTrue(gVar.assertVisible("Wishlist_AddtoCart_Button", "Profile\\Wishlist.properties"),"Wishlist_AddtoCart_Button display");
			sa.assertTrue(gVar.assertVisible("Wishlist_Qty_Label", "Profile\\Wishlist.properties"),"Wishlist_AddtoCart_Button display");
			//It will return all the assertions
			sa.assertAll();
	}

	@Test(groups="{Regression}",description="124523")
	public void TC_008_Wishlist_ShippingAddress_Dropdown_Functionality() throws Exception
	{	
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//Shipping address dropdown
		int Count=l1.getWebElements("Wishlist_Address_dropdown", "Profile\\Wishlist.properties").size();
		log.info("Count:"+Count );
		for(int j=0;j<Count;j++)
		{
			//l1.getWebElements("Wishlist_Address_dropdown", "Profile\\Wishlist.properties").get(j).click();
			gVar.handlingDropdown("Wishlist_Address_dropdown", "Profile\\Wishlist.properties", j);
			Thread.sleep(3000);
			//Verify Shipping address 
			sa.assertEquals(l1.getWebElements("Wishlist_Address_dropdown", "Profile\\Wishlist.properties").get(0).getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",j+1,9));
		}
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="124507_124527")
	public void TC_009_Functionality_Wishlist_Productname() throws Exception
	{
		log.info("Click on header login icon");
		l1.getWebElement("Header_Login_icon", "ShopNav\\HomePage.properties").click();
		//navigating to wish list login page
		log.info("Click on Header Wishlist");
		l1.getWebElement("Header_Wishlist_link",  "ShopNav\\HomePage.properties").click();	
		Thread.sleep(3000);
		//fetch product name
		String Pname=l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").getText();
		log.info("Click on Product name");
		l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").click();
		Thread.sleep(4000);
		sa.assertTrue(gVar.assertVisible("PDP_Main_Page", "ShopNav\\PDP.properties"),"PDP main display");
		sa.assertEquals(gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"), Pname);
		//It will return all the assertions
		sa.assertAll();
	}
		
	@Test(groups="{Regression}",description="148709")
	public void TC_010_Functionality_Breadcrumb() throws Exception
	{
		log.info("Naviagte to Find someones Wishlist page");
		p.NavigateToFindSomeOneWishlist();
		sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));
		//Breadcrumb Address not clickable 
		sa.assertEquals(gVar.assertEqual("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties","href",1), null);
/*		if(l1.getWebElements("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties").get(1).getAttribute("href")==null)
			{
				System.out.println("Wislist_Breadcrumb_element is not a a link");
			}
			else
			{
				System.out.println("Wislist_Breadcrumb_element is a link and a clickable");
			}*/
		//click on my account link present in the bread crumb
		log.info("Click on MyAccount breadcumb");
		l1.getWebElements("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties").get(0).click();
		//verify the navigation
		sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,2));
		sa.assertTrue(gVar.assertVisible("Login_Breadcrumb", "Profile\\login.properties"),"My account Breadcrumb display");	
		//It will return all the assertions
		sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="124547_289649")
	public void TC_011_Functionality_Wishlist_EditDetails() throws Exception
	{
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		Thread.sleep(4000);
		log.info("Click on Edit link");
		l1.getWebElement("Wishlist_EditDetails_link", "Profile\\Wishlist.properties").click();
		Thread.sleep(3000);
		sa.assertTrue(gVar.assertVisible("Wishlist_QuickView_Dialog", "Profile\\Wishlist.properties"),"Quick view dialog displayed");
		//Need to write for Attribute as currently nly single attribute is there 
		log.info("Enter Qty 2");
		//l1.getWebElement("Wishlist_QuickView_Qty", "Profile\\Wishlist.properties").clear();
		Thread.sleep(3000);
		l1.getWebElement("Wishlist_QuickView_Qty", "Profile\\Wishlist.properties").sendKeys("2");
		l1.getWebElement("Wishlist_QuickView_Update", "Profile\\Wishlist.properties").click();
		Thread.sleep(3000);
		sa.assertFalse(gVar.assertVisible("Wishlist_QuickView_Dialog", "Profile\\Wishlist.properties"),"Quick view Dialog closed");
		sa.assertNotEquals(gVar.assertEqual("Wishlist_DetailPage_Qty_InputField", "Profile\\Wishlist.properties"), "1");
		i=0;
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="_289205_289209")
	public void TC_012_Wishlist_Page_LeftNav_navigation() throws Exception
	{
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{
			//navigate to wish list page
			l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
			Thread.sleep(3000);
			//Link Display verification
			sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).isDisplayed(),"LeftNav links display");
			//String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
			sa.assertEquals(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText(),GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,6));
			
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 3);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
		}
		//navigate to wish list page
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		
		log.info("Take Count of left nav Headings");				
		int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
		for (int i=1;i<=LeftNavHeadings;i++)
		{
			log.info("Left nav headings");
			String leftNavHeading=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i-1).getText();
			sa.assertEquals(leftNavHeading,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i,5));
		}
		//navigate to wish list page
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		Thread.sleep(3000);
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(0).getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		i=0;
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="289122_148717")
	public void TC_013_Wishlist_SearchPage_LeftNav_navigation() throws Exception
	{
        //Navigate to wish list search result page
		log.info("Navigate to someones wishlist page");
		p.NavigateToFindSomeOneWishlist();
		Thread.sleep(5000);
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{
	        //Navigate to wish list search result page
			log.info("Navigate to someones wishlist page");
			p.NavigateToFindSomeOneWishlist();
			Thread.sleep(5000);
			
			//Link Display verification
			sa.assertTrue(gVar.assertVisible("LeftNav_Links","Profile\\login.properties",i),"LeftNav links display");
			String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
			sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,6));
			
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			Thread.sleep(3000);
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav",i+1,3);
			//String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 4);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
			//sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(1).getText(), Expected_LeftnavBreadcrumb);
		}
        //Navigate to wish list search result page
		log.info("Navigate to someones wishlist page");
		p.NavigateToFindSomeOneWishlist();
		Thread.sleep(4000);
		
		log.info("Take Count of left nav Headings");				
		int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
		for (int i=0;i<LeftNavHeadings;i++)
		{
			log.info("Left nav headings");
			String leftNavHeading=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i).getText();
			sa.assertEquals(leftNavHeading,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,5));
		}
		
		//Navigate to wish list search result page
		log.info("Navigate to someones wishlist page");
		p.NavigateToFindSomeOneWishlist();
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(1).getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="289168_289772")
	public void TC_014_Wishlist_Search_DetailPage_LeftNav_navigation() throws Exception
	{
        //Navigate to wish list search result page
		log.info("Navigate to someones wishlist page");
		p.NavigateToFindSomeOneWishlist();
		Thread.sleep(5000);
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{	
	        //Navigate to wish list search result page
			log.info("Navigate to someones wishlist page");
			p.NavigateToFindSomeOneWishlist();
			Thread.sleep(2000);
			log.info("Click on View");
			l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();
			Thread.sleep(4000);
			//Link Display verification
			sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).isDisplayed(),"LeftNav links display");
			String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
			sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,6));
			
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 3);
		//	String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "LeftNav", i+1, 4);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
			//sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(1).getText(), Expected_LeftnavBreadcrumb);
		}
		
		//Navigate to wish list search result page
		log.info("Navigate to someones wishlist page");
		p.NavigateToFindSomeOneWishlist();
		Thread.sleep(2000);
		log.info("Click on View");
		l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();
		Thread.sleep(3000);
			log.info("Take Count of left nav Headings");				
			int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
			for (int i=0;i<=LeftNavHeadings;i++)
			{
				log.info("Left nav headings");
				String leftNavHeading=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i).getText();
				sa.assertEquals(leftNavHeading,GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i+1,5));
			}
	        //Navigate to wish list search result page
			log.info("Navigate to someones wishlist page");
			p.NavigateToFindSomeOneWishlist();
			log.info("Click on View");
			l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();	
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(l1.getWebElements("PageBreadcrumb", "Profile\\Wishlist.properties").get(1).getText(), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		i=0;
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(dataProvider="Find_Wishlist_Reg_Validation",dataProviderClass=Data.class, description="148722/148723/148724/148725")
	public void TC_015_Find_Wishlist_Validations(TestData t) throws Exception
	{
		//navigating to wish list login  page
		log.info("Click on Footer Wishlist:"+i);
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//validating the fields last name,first name,email 
		
		log.info("Enter FN, LN, Email");
		 log.info("Enter Lastname:"+i);
		l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").sendKeys(t.get(0));
		 log.info("Enter Firstname:"+i);
		l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").sendKeys(t.get(1));
		 log.info("Enter Email:"+i);
		l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys(t.get(2));	
		Thread.sleep(2000);
		//click on find button
		log.info("Click on Find Button:"+i);
		l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
		Thread.sleep(5000);
		//Blank
			if(i==0 || i==1 || i==6 || i==7)
			{
				//user should be in same page
				sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));
				
			//verify the text message
			if(i==7)
				{
				//String ExpText="Marihal"+" "+"Shashidhar"+" - "+"View";
				//Need to write 
				//Lastname
				sa.assertEquals(l1.getWebElement("Wishlist_Lastname_Text",  "Profile\\Wishlist.properties"), t.get(0));
				//Firstname
				sa.assertEquals(l1.getWebElement("Wishlist_Firstname_Text",  "Profile\\Wishlist.properties"), t.get(1));
				//View Table
				sa.assertTrue(gVar.assertVisible("Find_Wishlist_Page_Table", "Profile\\Wishlist.properties"),"Wishlist Table displayed");
				//Find_Wishlist_Page_View_link
				sa.assertTrue(gVar.assertVisible("Find_Wishlist_Page_View", "Profile\\Wishlist.properties"));
				//verify the UI of empty Wish List search
				sa.assertTrue(gVar.assertVisible("Wishlist_Breadcrumb", "Profile\\Wishlist.properties"), "Wishlist page breadcrumb display");
				//fields
				sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));			
				
				}
			else if(i==6)
				{
				//No wish list has been found
				sa.assertEquals(gVar.assertEqual("Wishlist_Reg_No_Found_Wishlist_Text", "Profile\\Wishlist.properties"),"No wish list has been found for "+t.get(2)+". Please try again.");
				}
			}
			else if(i==4 || i==5 || i==2 || i==3)
			{
				//Please enter a valid email address.
		    	sa.assertEquals(gVar.assertEqual("Wishlist_Email_ErrorMsg", "Profile\\Wishlist.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_ErrorMessage"));
		    	//Text color Email
		    	sa.assertEquals(l1.getWebElement("Wishlist_Email_ErrorMsg", "Profile\\Wishlist.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,2));
		    	//EmailBox color
		    	sa.assertEquals(l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,3));

			}
			
			//max characters
			else if(i==5)
				{
				//More than 50 characters
				sa.assertEquals(l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").getText().length(),50);
				sa.assertEquals(l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").getText().length(),50);
				sa.assertEquals(l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").getText().length(),50);
				Thread.sleep(3000);
				}
			i++;
			//It will return all the assertions
			sa.assertAll();
		}
	
	@Test(groups="{Regression}",description="148719")
	public void TC_016_Functionality_Make_List_Private() throws Exception
	{	
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//verify the 'Make This List Private' functionality
		//click on make this as public if it is not having public visibility
		try
		{
			log.info("Make the list private");
			BaseTest.l1.getWebElement("Make_Wishlist_Private", "Profile\\Wishlist.properties").click();	
			Thread.sleep(3000);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("Wishlist is already Private");
		}
		//'Make This List public' link should be there
		sa.assertFalse(gVar.assertVisible("Make_Wishlist_Private", "Profile\\Wishlist.properties"),"Make_Wishlist_Private should not display");
		sa.assertTrue(gVar.assertVisible("Make_Wishlist_Public", "Profile\\Wishlist.properties"),"Make_Wishlist_Public should display");
		sa.assertFalse(gVar.assertVisible("Wishlist_DetailPage_ShareOptions", "Profile\\Wishlist.properties"),"Wishlist_DetailPage_ShareOptions should not display");
		sa.assertFalse(gVar.assertVisible("Wishlist_Item_Public_Checkbox", "Profile\\Wishlist.properties"),"Wishlist_Item_Public_Checkbox should not display");

		//items should not be visible
		log.info("Enter EmailID");
		l1.getWebElement("Wishlist_Login_Email",  "Profile\\Wishlist.properties").sendKeys("Shashidhar@gmail.com");
		log.info("Click on Find");
		l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
		Thread.sleep(2000);
		//wish list results table should not display for invalid credentials
		sa.assertFalse(gVar.assertVisible("Find_Wishlist_Page_ExpRow", "Profile\\Wishlist.properties"),"Wislist Account row Should not display");
		sa.assertFalse(gVar.assertVisible("Find_Wishlist_Page_View", "Profile\\Wishlist.properties"),"Wislist Account view link Should not display");
		sa.assertEquals(gVar.assertEqual("Wishlist_Reg_No_Found_Wishlist_Text", "Profile\\Wishlist.properties"),"No wish list has been found for Shashidhar@gmail.com. Please try again.");
		i=0;
	}
	
	@Test(dataProvider="Wishlist_Quantity_Validation",dataProviderClass=Data.class, description="289208/148721")
	public void TC_017_Wishlist_Quantity_Field_Validation(TestData t) throws Exception
	{
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Enter value in Qty:" +i);
		l1.getWebElement("Wishlist_Product_Qty", "Profile\\Wishlist.properties").sendKeys(t.get(0));
		log.info("Click on Add to cart");
		l1.getWebElement("Wishlist_AddtoCart_Button", "Profile\\Wishlist.properties").click();
		Thread.sleep(2000);
		
		if (i==0 || i==1 || i==2)
			{
			log.info("Qty error Message" +i);
			sa.assertEquals(gVar.assertEqual("Wishlist_Qty_Error", "Profile\\Wishlist.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties", "Wishlist_Qty_Error_Message"));
			}
		else
			{
				log.info("Wishlist Product adding to cart");
				String Pname=l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").getText();
				
				gVar.MouseHover("MiniCart_FlyOut", "ShopNav\\Minicart.properties");
				Thread.sleep(1000);
				//ProductName
				sa.assertEquals(gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"), Pname);
				//Product Quantity
				sa.assertEquals(gVar.assertEqual("Minicart_Quantity", "ShopNav\\Minicart.properties"),"2");
			}
		i++;
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="_148720")
	public void TC_018_Functionality_Make_List_Public() throws Exception
	{
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//click on make this as public if it is not having public visibility
		try
		{
			log.info("Make the list public");
			l1.getWebElement("Make_Wishlist_Public", "Profile\\Wishlist.properties").click();		
			Thread.sleep(3000);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("Wishlist is already public");
		}
		sa.assertFalse(gVar.assertNotVisible("Make_Wishlist_Public", "Profile\\Wishlist.properties"),"Make_Wishlist_Public should not display");
		sa.assertTrue(gVar.assertVisible("Make_Wishlist_Private", "Profile\\Wishlist.properties"),"Make_Wishlist_Private should display");
		sa.assertTrue(gVar.assertVisible("Wishlist_DetailPage_ShareOptions", "Profile\\Wishlist.properties"),"Wishlist_DetailPage_ShareOptions should display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Item_Public_Checkbox", "Profile\\Wishlist.properties"),"Wishlist_Item_Public_Checkbox should display");		
		sa.assertEquals(gVar.assertEqual("Wishlist_Item_Public_Checkbox", "Profile\\Wishlist.properties","checked"),true);
	}
	
	@Test(groups="{Regression}",description="_289657")
	public void TC_019_Functionality_Wishlist_Product_Update_link() throws Exception
	{
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Uncheck the checkbox");
		gVar.UnSelectCheckbox("Wishlist_Item_Public_Checkbox", "Profile\\Wishlist.properties");		
		log.info("Click on Update link");
		l1.getWebElement("Wishlist_DetailPage_Update", "Profile\\Wishlist.properties").click();
	
		log.info("Logout from Application");
		p.Logout();
		
		log.info("Navigate to find Someones Wishlist page");
		p.NavigateToFindSomeOneWishlist();
		log.info("Click on View");
		l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();
		Thread.sleep(3000);
		sa.assertEquals(gVar.assertEqual("Wishlist_FindSomeones_User_Heading", "Profile\\Wishlist.properties"), "Shashidhar Marihal 's Wish List");
		sa.assertFalse(gVar.assertVisible("Wishlist_Item_Details", "Profile\\Wishlist.properties"),"Product should not be displayed");
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124549")
	public void TC_020_Functionality_Wishlist_Product_Update_link(XmlTest XmlTest) throws Exception
	{
		log.info("Login");
		p.loginToAppliction(XmlTest);
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		Thread.sleep(2000);
		log.info("Enter Qty 4");
		l1.getWebElement("Wishlist_DetailPage_Qty_InputField", "Profile\\Wishlist.properties").sendKeys("4");
		log.info("Set Priority to Highest");
		new Select(l1.getWebElement("Wishlist_Product_Priority_Dropdown", "Profile\\Wishlist.properties")).selectByVisibleText("High");
		log.info("Click on Update link");
		l1.getWebElement("Wishlist_DetailPage_Update", "Profile\\Wishlist.properties").click();
		Thread.sleep(4000);
		sa.assertEquals(gVar.assertEqual("Wishlist_DetailPage_Qty_InputField", "Profile\\Wishlist.properties","value"), 4, "Quantity should be updated in Qty desired");
		sa.assertEquals(gVar.assertEqual("Wishlist_Product_Qty", "Profile\\Wishlist.properties","value"), 4, "Quantity should be updated in Qty desired");
		sa.assertEquals(gVar.assertEqual("Wishlist_Product_Priority_Selected", "Profile\\Wishlist.properties"), "High");
		//It will return all the assertions
				sa.assertAll();
	}
		
	@Test(groups="{Regression}",description="124550")
	public void TC_021_Functionality_Wishlist_Product_Remove() throws Exception
	{
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Clear wishlist");		
		//fetch the total no.of products	
		int count=l1.getWebElements("Wishlist_ProductDetail_Div", "Profile\\Wishlist.properties").size();
		if(count==0)
			{
			log.info("Click on remove");
			l1.getWebElement("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties").click();
			Thread.sleep(3000);
			//no products should be present 
			sa.assertTrue(gVar.assertVisible("Wishlist_NoItems_StaticText", "Profile\\Wishlist.properties"),"No products found");
			sa.assertFalse(gVar.assertNotVisible("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties"),"Remove link display");
			}
		else
			{
			for(int i=1;i<=count;i++)
				{	
				String productName=l1.getWebElements("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").get(0).getText();
				log.info("Click on remove");
				l1.getWebElement("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties").click();
				Thread.sleep(3000);
				//verify whether first item is removed or not
				sa.assertNotEquals(gVar.assertEqual("Wishlist_ProductName_Link", "Profile\\Wishlist.properties"), productName);
				}
			}
		//It will return all the assertions
				sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="124525")
	public void TC_022_Functionality_Add_GiftCertificate() throws Exception
	{	
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Clear wishlist");
		p.clearWishList();
		//click on add gift certificate link
		log.info("Click on Add Gift certificate button");
		l1.getWebElement("Wishlist_GiftCertificate_Button", "Profile\\Wishlist.properties").click();
		Thread.sleep(2000);
		//after clicking 'add gift certificate' button should not visible
		sa.assertFalse(gVar.assertNotVisible("Wishlist_GiftCertificate_Button", "Profile\\Wishlist.properties"),"Gift Certificate Button");
		//verify the added gift certificate
		//image
		sa.assertTrue(gVar.assertVisible("Wishlist_GiftCertificate_Img", "Profile\\Wishlist.properties"),"Gift Certificate Link");
		//link
		sa.assertTrue(gVar.assertVisible("Wishlist_GiftCertificate_link", "Profile\\Wishlist.properties"),"Gift Certificate link");
		//date added
		sa.assertTrue(gVar.assertVisible("Wishlist_Product_DateAdded", "Profile\\Wishlist.properties"),"Wishlist_Product_DateAdded display");
		//Update
		sa.assertTrue(gVar.assertVisible("Wishlist_DetailPage_Update", "Profile\\Wishlist.properties"),"Wishlist_Product Update link");
		//remove link
		sa.assertTrue(gVar.assertVisible("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties"),"Wishlist_Product Remove link");
		//remove the added gift certificate
		log.info("Click on remove link");
		l1.getWebElement("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties").click();
		sa.assertFalse(gVar.assertVisible("Wishlist_GiftCertificate_link", "Profile\\Wishlist.properties"),"Wishlist GC link should not display");
		sa.assertFalse(gVar.assertVisible("Wishlist_Item_Table", "Profile\\Wishlist.properties"),"GC should be removed");
		//It will return all the assertions
		sa.assertAll();
	}
	
}
