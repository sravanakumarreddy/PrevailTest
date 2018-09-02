package com.prevail.profile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class WishList_Guest extends BaseTest {


//---------------------------Wishlist_guest----------------------------------
		@Test(groups="{Regression}",description="Additems_To_Whishlist")
	public void TC_001_Additems_To_Whishlist(XmlTest XmlTest) throws Exception
	{
		log.info("Delete Items from Wishlist");
		p.deleteAddeditemsFromWishlistAccount(XmlTest);
		log.info("Additems to Whishlist : Works till TC_ID 124515");
		p.AdditemsToWishListAccount(XmlTest);
		log.info("Items Added to Wishlist");
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="124818_124426_148695_124427")
	public void TC_002_Wishlist_UI_ReturningCustomers() throws Exception
	{
		log.info("navigating to wish list login  page");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//verify bread crumb
		log.info("Verify bread crumb");
		sa.assertEquals(gVar.assertEqual("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties",1), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,1));
		//Verifying the UI of returning customer section
		//MyAccount login as heading
		sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,2));
		//Returning customer heading
		sa.assertEquals(gVar.assertEqual("Login_ReturningCustomer_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",2,2));
		//Paragraph with static text
		sa.assertTrue(gVar.assertVisible("Login_Static_Pragraph", "Profile\\login.properties"),"Paragraph Static Text display");
		//email Address
		sa.assertTrue(gVar.assertVisible("Login_UN_Label", "Profile\\login.properties"),"Username Label display");
		sa.assertTrue(gVar.assertVisible("Login_Username", "Profile\\login.properties"),"Username Textbox display");
		sa.assertEquals(gVar.assertEqual("Login_Username", "Profile\\Wishlist.properties"), "");
		//password
		sa.assertTrue(gVar.assertVisible("Login_Pwd_Label", "Profile\\login.properties"),"Password Label display");
		sa.assertTrue(gVar.assertVisible("Login_Password", "Profile\\login.properties"),"Password Textbox display");
		sa.assertEquals(gVar.assertEqual("Login_Password", "Profile\\Wishlist.properties"), "");
		//remember me
		sa.assertTrue(gVar.assertVisible("Login_Remember_Label", "Profile\\login.properties"),"Remember me Checkbox display");
		sa.assertTrue(gVar.assertVisible("Login_Remember_Checkbox", "Profile\\login.properties"),"Remember me Checkbox display");
		//Left nav panel
		sa.assertTrue(gVar.assertVisible("LeftNav_Panel", "Profile\\Addresses.properties"),"Left Panel display");
//		if(l1.getWebElement("Login_Remember_Checkbox", "Profile\\Addresses.properties").getAttribute("checked").equals("false"))
//		{
//			System.out.println("Checkbox is not checked");
//		}
//		else
//		{
//			System.out.println("Checkbox is checked");
//		}
		//login button
		sa.assertTrue(gVar.assertVisible("Login_Login_Button", "Profile\\login.properties"),"Login button display");
		//forgot password
		sa.assertTrue(gVar.assertVisible("Login_ForgotPasswrd", "Profile\\login.properties"),"Forgot password display");
		sa.assertEquals(gVar.assertEqual("Login_ForgotPasswrd", "Profile\\login.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",3,2));
		//social links
		sa.assertTrue(gVar.assertVisible("Login_LinkedIn_Icon", "Profile\\login.properties"),"LinkedIn_Icon display");
		sa.assertTrue(gVar.assertVisible("Login_Microsoft_Icon", "Profile\\login.properties"),"Login_Microsoft_Icon display");
		sa.assertTrue(gVar.assertVisible("Login_Facebook_Icon", "Profile\\login.properties"),"Login_Facebook_Icon display");
		sa.assertTrue(gVar.assertVisible("Login_GitHub_Icon", "Profile\\login.properties"),"Login_GitHub_Icon display");
		sa.assertTrue(gVar.assertVisible("Login_SinaWeibo_Icon", "Profile\\login.properties"),"Login_SinaWeibo_Icon display");
		sa.assertTrue(gVar.assertVisible("Login_VKontakte_Icon", "Profile\\login.properties"),"Login_VKontakte_Icon display");
		sa.assertTrue(gVar.assertVisible("Login_GooglePlus_Icon", "Profile\\login.properties"),"Login_GooglePlus_Icon display");
		//Find someone's wishlist login section/Wishlist login heading
		sa.assertEquals(gVar.assertEqual("Wishlist_Login_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",4,2));
		sa.assertTrue(gVar.assertVisible("Wishlist_LastName_Label", "Profile\\Wishlist.properties"),"Lastname label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_FirstName_Label", "Profile\\Wishlist.properties"),"Firstname label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Email_Label", "Profile\\Wishlist.properties"),"Email label display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_LastName", "Profile\\Wishlist.properties"),"Lastname textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_FirstName", "Profile\\Wishlist.properties"),"Firstname textbox display");
		sa.assertTrue(gVar.assertVisible("Wishlist_Login_Email", "Profile\\Wishlist.properties"),"Login Email display");
		sa.assertTrue(gVar.assertVisible("Wishlist_login_Find", "Profile\\Wishlist.properties"),"Find button display");
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124806")
	public void TC_003_Wishlist_UI_Create_wishlist() throws Exception
	{
		//Create wishlist heading
		sa.assertTrue(gVar.assertVisible("Create_Wishlist_Heading", "Profile\\Wishlist.properties"),"Create Wishlist Heading display");
		//Content asset
		sa.assertTrue(gVar.assertVisible("Create_Wishlist_ContentAssest", "Profile\\Wishlist.properties"),"Wishlist Content assest display");
		//Create account button
		sa.assertTrue(gVar.assertVisible("Wishlist_CreateAccount_button", "Profile\\Wishlist.properties"),"Create account button display");	
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124428")
	public void TC_004_Breadcrumb_Wishlist_loginPage() throws Exception
	{
		//navigating to wish list login page
		log.info("Navigate to Wishlist page");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		sa.assertEquals(gVar.assertEqual("Wishlist_Login_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",4,2));

		//click on my account link present in the bread crumb
		log.info("Click on MyAccount breadcumb");
		l1.getWebElements("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties").get(0).click();
		//verify the navigation
		sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,2));
		sa.assertTrue(gVar.assertVisible("Login_Breadcrumb", "Profile\\login.properties"),"My account Breadcrumb display");	
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="289770")
	public void TC_005_Wishlist_DetailPage_LeftNavLinks_Navigation() throws Exception
	{
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{
	        //Navigate to wish list search result page
			p.NavigateToFindSomeOneWishlist();
			log.info("Click on View");
			l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 6);
			String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 7);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
			sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), Expected_LeftnavBreadcrumb);
		}
        //Navigate to wish list search result page
		p.NavigateToFindSomeOneWishlist();
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(gVar.assertEqual("Wishlist_ContactUS_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148696_148701_124504")
	public void TC_006_ForgotPwd_Link_Navigation() throws Exception
	{
		//navigating to wish list login page
		log.info("Navigate to Wishlist page");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//Checking Bread crumb
		sa.assertEquals(gVar.assertEqual("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties",1), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,1));
		//wish list page
		sa.assertEquals(gVar.assertEqual("Wishlist_Login_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",4,2));
		
		//click on forgot password link
		log.info("click on forgot password link");
		l1.getWebElement("Login_ForgotPasswrd", "Profile\\login.properties").click();
		Thread.sleep(4000);
		
		//verify the UI of forgot password overlay
		sa.assertTrue(gVar.assertVisible("ForgetPwd_Overlay", "Profile\\Wishlist.properties"),"Forgot Overlay display");
		sa.assertTrue(gVar.assertVisible("ForgetPwd_Overlay_Heading", "Profile\\Wishlist.properties"),"ForgetPwd_Overlay_Heading display");
		sa.assertTrue(gVar.assertVisible("ForgotPwd_Overlay_StaticText1", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_StaticText1 display");

		//email field
		sa.assertTrue(gVar.assertVisible("ForgotPwd_Overlay_EmailLabel", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_EmailLabel display");
		sa.assertTrue(gVar.assertVisible("ForgotPwd_Overlay_Email_Textbox", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_Email_Textbox display");
		log.info("Enter email in Forgotpassword Textbox");
		l1.getWebElement("ForgotPwd_Overlay_Email_Textbox", "Profile\\Wishlist.properties").sendKeys("Shashidhar@yahoo.com");
		//Send
		log.info("Click on Send");
		l1.getWebElement("ForgotPwd_Overlay_Send_button", "Profile\\Wishlist.properties").click();
		sa.assertTrue(gVar.assertVisible("ForgetPwd_Overlay_Heading", "Profile\\Wishlist.properties"), "ForgetPwd_Overlay_Heading display");
		sa.assertTrue(gVar.assertNotVisible("ForgetPwd_Overlay_Heading", "Profile\\Wishlist.properties"),"Email success msg dialog displayed");
		//confirmation text
		sa.assertTrue(gVar.assertVisible("ForgotPwd_Overlay_Confirmation_Text", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_Confirmation_Text display");
		sa.assertTrue(gVar.assertVisible("ForgotPwd_Overlay_StaticText2", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_StaticText2 display");
		sa.assertTrue(gVar.assertVisible("ForgotPwd_Overlay_CloseIcon", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_CloseIcon display");
		sa.assertTrue(gVar.assertVisible("ForgotPwd_Overlay_HomeLink", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_HomeLink display");
		
		//closing the dialog
		log.info("Close the Forgot pwd overlay");
		l1.getWebElement("ForgotPwd_Overlay_CloseIcon", "Profile\\Wishlist.properties").click();
		sa.assertTrue(gVar.assertNotVisible("ForgetPwd_Overlay", "Profile\\Wishlist.properties"),"ForgotPwd_Overlay_closed");
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",dataProvider="Find_Wishlist_Validation",dataProviderClass=Data.class, description="148703_148704_124506_148705_124509")
	public void TC_007_Find_Wishlist_Validations(TestData t) throws Exception
	{
		//navigating to wish list login  page
		log.info("Click on Footer Wishlist:"+i);
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//validating the fields last name,first name,email 
		log.info("ClearFields loop:"+i);
		p.ClearWishlistLoginFields();
				log.info("Enter FN, LN, Email");
				 log.info("Enter Lastname:"+i);
				l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").sendKeys(t.get(0));
				 log.info("Enter Firstname:"+i);
				l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").sendKeys(t.get(1));
				 log.info("Enter Email:"+i);
				l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys(t.get(2));
				//click on find button
				log.info("Click on Find Button:"+i);
				l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
				Thread.sleep(4000);
				
			//Blank
			if(i==0 || i==1 || i==6)
			{
				//user should be in same page
				sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));				
							
			//verify the text message
			 if(i==6)
			{
			//String ExpText="Marihal"+" "+"Shashidhar"+" - "+"View";
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
	    	//Fn
			sa.assertTrue(gVar.assertVisible("Wishlist_Lastname_Block", "Profile\\Wishlist.properties"),"Lastname Block");
			//LN
			sa.assertTrue(gVar.assertVisible("Wishlist_Firstname_Block", "Profile\\Wishlist.properties"),"Firstname Block");
			//Location
			sa.assertTrue(gVar.assertVisible("Wishlist_Location_Block", "Profile\\Wishlist.properties"),"Location Block");
	    	//left nav section
	    	log.info("Take Count of left nav links");
			int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
			for (int j=0;j<LeftNavLinksCount;j++)
			{
				sa.assertTrue(gVar.assertVisible("LeftNav_Links","Profile\\login.properties",j),"LeftNav links display");
				sa.assertEquals(gVar.assertEqual("LeftNav_Links","Profile\\login.properties", j),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",j+1,4));
			}
			
			int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
			for (int j=0;j<LeftNavHeadings;j++)
			{
				log.info("Left nav headings");
				sa.assertEquals(gVar.assertEqual("LeftNav_Headings","Profile\\login.properties", j),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",j+1,5));
			}
			
			//LeftNav_Needhelp_Text
			sa.assertTrue(gVar.assertVisible("LeftNav_NeedHelp_Heading","Profile\\Register.properties"),"Need help? Heading");
			sa.assertTrue(gVar.assertVisible("LeftNav_Needhelp_Text","Profile\\Register.properties"),"Need help Text");
			//Customer service
			sa.assertTrue(gVar.assertVisible("LeftNav_CustomerService", "Profile\\Register.properties"), "Customer service");		
			}
			 else
			 {
				 	System.out.println("No Wishlist found: "+i);;
					//No wish list has been found
					sa.assertTrue(gVar.assertVisible("Find_Wishlist_Page_Text", "Profile\\Wishlist.properties"),"No Wishlist found Text:"+i);
			 }
		}
			
			else if(i==4 || i==5 || i==2 || i==3)
			{
				log.info("Loop: "+ i);
				//Please enter a valid email address.
		    	sa.assertEquals(gVar.assertEqual("Wishlist_Email_ErrorMsg", "Profile\\Wishlist.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_ErrorMessage"));
		    	//Text color Email
		    	sa.assertEquals(l1.getWebElement("Wishlist_Email_ErrorMsg", "Profile\\Wishlist.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,2));
		    	//EmailBox color
		    	sa.assertEquals(l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,3));
				Thread.sleep(3000);
				
				//max characters
				if(i==5)
				{
				log.info("Loop: "+ i);
				//More than 50 characters
				sa.assertEquals(l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").getAttribute("maxlength"),50);
				sa.assertEquals(l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").getAttribute("maxlength"),50);
				sa.assertEquals(l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").getAttribute("maxlength"),50);
				Thread.sleep(3000);
				}
			}
			i++;
			//It will return all the assertions
			sa.assertAll();
		}
		
	@Test(groups="{Regression}",description="124505")
	public void TC_008_Wishlist_CreateAccount_Button() throws Exception
	{
		//navigating to wish list login  page
		log.info("Click on Wishlist Footer link");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Click on Create Account");
		Thread.sleep(3000);
		l1.getWebElement("Wishlist_CreateAccount_button", "Profile\\Wishlist.properties").click();
		Thread.sleep(3000);
		//Navigation to My account Page
		sa.assertTrue(gVar.assertVisible("Register_Heading", "Profile\\Register.properties"),"Register heading");
		sa.assertTrue(gVar.assertVisible("Register_Breadcrumb_Element", "Profile\\Register.properties"),"Register breadcrumb");
		i=0;
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",dataProvider="Wishlist_Login_Validation",dataProviderClass=Data.class, description="124430_124431_148702")
	public void TC_009_Wishlist_Login_Validations(TestData t) throws Exception
	{
		//Navigate to home page
		log.info("Click on Logo");
		l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();
		//navigating to wish list login  page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
			
				//validating the email address and password fields	
				log.info("Loop :"+i);
				p.ClearWishlistLoginFields();
				log.info("Enter Username");
				l1.getWebElement("Login_Username", "Profile\\login.properties").sendKeys(t.get(0));
				log.info("Enter Password");
				l1.getWebElement("Login_Password", "Profile\\login.properties").sendKeys(t.get(1));
				log.info("Click on Login");
				l1.getWebElement("Login_Login_Button", "Profile\\login.properties").click();
				Thread.sleep(3000);

			//blank
			if(i==0)
				{
				log.info("Blank validation:" +i);
				//username
				//This field is required.
		    	sa.assertEquals(gVar.assertEqual("Login_Username_ErrorMsg", "Profile\\login.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Username_Error_Message"));
		    	//Text color Email
		    	sa.assertEquals(l1.getWebElement("Login_Username_ErrorMsg", "Profile\\login.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,4));
		    	//Username EmailBox color
		    	sa.assertEquals(l1.getWebElement("Login_Username", "Profile\\login.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",2,4));
				//password
		    	//This field is required.
		    	sa.assertEquals(gVar.assertEqual("Login_Pwd_ErrorMsg", "Profile\\login.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Password_Error_Message"));
		    	//Text color Email
		    	sa.assertEquals(l1.getWebElement("Login_Pwd_ErrorMsg", "Profile\\login.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,5));
		    	//Pwd EmailBox color
		    	sa.assertEquals(l1.getWebElement("Login_Password", "Profile\\login.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",2,5));
				}
			//valid
			else if(i==5)
				{		
				log.info("Valid credentials:" +i);
				sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));			
				sa.assertTrue(gVar.assertVisible("Wishlist_Page_ItemTable", "Profile\\Wishlist.properties"),"Wishlist Items Table");
				}
			//invalid email id
			else if(i==1||i==2||i==3)
			{
				log.info("InValid Email:" +i);
				//username
				//Please enter a valid email address.
		    	sa.assertEquals(gVar.assertEqual("Login_Username_ErrorMsg", "Profile\\login.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_ErrorMessage"));
		    	//Text color Email
		    	sa.assertEquals(l1.getWebElement("Login_Username_ErrorMsg", "Profile\\login.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,4));
		    	//Username EmailBox color
		    	sa.assertEquals(l1.getWebElement("Login_Username", "Profile\\login.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",2,4));
			}
			//invalid 
			else if(i==4)
				{
				log.info("InValid credentials:" +i);
				sa.assertTrue(gVar.assertVisible("Login_InvalidCredentials_ErrorMsg", "Profile\\login.properties"),"InvalidCredentials_ErrorMsg");
		    	sa.assertEquals(gVar.assertEqual("Login_InvalidCredentials_ErrorMsg", "Profile\\login.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","InvalidCredentials_Error_Message"));
		    	//Text color Email
		    	sa.assertEquals(l1.getWebElement("Login_InvalidCredentials_ErrorMsg", "Profile\\login.properties").getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,6));
				}
			i++;
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="124508")
	public void TC_010_UI_Empty_Wishlist_Search_Results_Page() throws Exception
	{
		//logout from application
		log.info("Logout");
		p.Logout();
		
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Enter Email in Find Wishlist section");
		l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys(GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 1, 3));
		log.info("click on find button");
		l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
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
    	//
		sa.assertEquals(gVar.assertEqual("Wishlist_Login_LastName", "Profile\\Wishlist.properties"), "");
    	sa.assertEquals(gVar.assertEqual("Wishlist_Login_FirstName", "Profile\\Wishlist.properties"), "");
    	sa.assertEquals(gVar.assertEqual("Wishlist_Login_Email", "Profile\\Wishlist.properties"), "");
    	
    	//left nav section
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		for (int i=0;i<LeftNavLinksCount;i++)
		{
			sa.assertTrue(gVar.assertVisible("LeftNav_Links","Profile\\login.properties",i),"LeftNav links display");
			sa.assertEquals(gVar.assertEqual("LeftNav_Links","Profile\\login.properties", i),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",i+1,4));
		}
		
		int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
		for (int i=0;i<LeftNavHeadings;i++)
		{
			log.info("Left nav headings");
			sa.assertEquals(gVar.assertEqual("LeftNav_Headings","Profile\\login.properties", i),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",i+1,5));
		}
		
		//LeftNav_Needhelp_Text
		sa.assertTrue(gVar.assertVisible("LeftNav_NeedHelp_Heading","Profile\\Register.properties"),"Need help? Heading");
		sa.assertTrue(gVar.assertVisible("LeftNav_Needhelp_Text","Profile\\Register.properties"),"Need help Text");
		//Customer service
		sa.assertTrue(gVar.assertVisible("LeftNav_CustomerService", "Profile\\Register.properties"), "Customer service");
		
		//It will return all the assertions
				sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="289164_289688_124512")
	public void TC_011_UI__Wishlist_Detail_Page() throws Exception
	{
		//navigate to wish list page
		log.info("Click on Footer wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Enter Lastname");
		l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").sendKeys("Marihal");
		log.info("Enter Firstname");
		l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").sendKeys("Shashidhar");
		log.info("Enter Email");
		l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys("Shashidhar@gmail.com");
		//click on find button
		log.info("Click on Find Button");
		l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
		Thread.sleep(5000);
		log.info("Click on View");
		l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();
		Thread.sleep(3000);
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
			sa.assertTrue(gVar.assertVisible("LeftNav_Links","Profile\\login.properties",i),"LeftNav links display");
			sa.assertEquals(gVar.assertEqual("LeftNav_Links","Profile\\login.properties", i),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",i+1,4));
		}
				
			int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
			for (int i=0;i<LeftNavHeadings;i++)
			{
				log.info("Left nav headings");
				sa.assertEquals(gVar.assertEqual("LeftNav_Headings","Profile\\login.properties", i),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",i+1,5));
			}
				
			//LeftNav_Needhelp_Text
			sa.assertTrue(gVar.assertVisible("LeftNav_NeedHelp_Heading","Profile\\Register.properties"),"Need help? Heading");
			sa.assertTrue(gVar.assertVisible("LeftNav_Needhelp_Text","Profile\\Register.properties"),"Need help Text");
			//Customer service
			sa.assertTrue(gVar.assertVisible("LeftNav_CustomerService", "Profile\\Register.properties"), "Customer service");
			
			log.info("Wishlist name: FirstName Lastname 's Wish List");
			String WishListName= "Shashidhar"+" "+"Marihal"+" 's Wish List";
			sa.assertEquals(gVar.assertEqual("WishlistName", "Profile\\Wishlist.properties"), WishListName);
			
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductImage", "Profile\\Wishlist.properties"),"Wishlist_ProductImage display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductName", "Profile\\Wishlist.properties"),"Wishlist_ProductName display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductItemNo", "Profile\\Wishlist.properties"),"Wishlist_ProductItemNo display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductSize", "Profile\\Wishlist.properties"),"Wishlist_ProductSize display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductColor", "Profile\\Wishlist.properties"),"Wishlist_ProductColor display");
			sa.assertTrue(gVar.assertVisible("Wishlist_ProductPrice", "Profile\\Wishlist.properties"),"Wishlist_ProductPrice display");
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

	
	@Test(groups="{Regression}",dataProvider="Wishlist_Quantity_Validation",dataProviderClass=Data.class, description="289769_124515")
	public void TC_012_Wishlist_Quantity_Field_Validation(TestData t) throws Exception
	{
		
		log.info("Enter value in Qty:" +i);
		l1.getWebElement("Wishlist_Qty", "Profile\\Wishlist.properties").sendKeys(t.get(0));
		Thread.sleep(2000);
		log.info("Click on Add to cart");
		l1.getWebElement("Wishlist_AddtoCart_Button", "Profile\\Wishlist.properties").click();
		Thread.sleep(5000);
		
		if (i==0 || i==1 || i==2)
			{
			log.info("Qty error Message"+i);
			sa.assertEquals(gVar.assertEqual("Wishlist_Qty_Error", "Profile\\Wishlist.properties"), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties", "Wishlist_Qty_Error_Message"));
			}
		else if(i==3)
			{
				String Pname=l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").getText();
				
				gVar.MouseHover("Minicart_Quantity", "ShopNav\\Minicart.properties");
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
	
//----------------------------------------------Wishlist search result page---------------------------------------------------------
	
	@Test(groups="{Regression}",description="148708")
	public void TC_013_Wishlist_SearchPage_Breadcrumb_Functionality() throws Exception
	{
		log.info("Naviagte to Find someones Wishlist page");
		p.NavigateToFindSomeOneWishlist();
		
		//Navigate to home page
		log.info("Navigate to home page");
		l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();
		//verify the navigation to home page
		sa.assertTrue(gVar.assertVisible("Homepage_Slides", "ShopNav\\HomePage.properties"),"Homepage slides display");	
		sa.assertTrue(gVar.assertVisible("Homepage_Slots", "ShopNav\\HomePage.properties"),"Homepage slots display");
		
		log.info("Naviagte to Find someones Wishlist page");
		p.NavigateToFindSomeOneWishlist();
		sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",4,2));
		//Breadcrumb Address not clickable 
		sa.assertFalse(true, l1.getWebElements("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties").get(1).getAttribute("href"));
		//click on my account link present in the bread crumb
		log.info("Click on MyAccount breadcumb");
		l1.getWebElements("Wislist_Breadcrumb_element", "Profile\\Wishlist.properties").get(0).click();
		//verify the navigation
		sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\login.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",1,2));
		sa.assertTrue(gVar.assertVisible("Login_Breadcrumb", "Profile\\login.properties"),"My account Breadcrumb display");	
		//It will return all the assertions
		sa.assertAll();
				
	}

	@Test(groups="{Regression}",description="124429")
	public void TC_014_Wishlist_Page_LeftNav_navigation() throws Exception
	{
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{
			//navigate to wish list page
			log.info("Click on Footer Wishlist");
			l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
			
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 6);
			//String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 7);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
			//sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties").getText(), Expected_LeftnavBreadcrumb);
		}
		//navigate to wish list page
		log.info("Click on Footer Wishlist");
		l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148710_124429")
	public void TC_015_Wishlist_SearchPage_LeftNav_navigation() throws Exception
	{
		//Navigate to wish list search result page
		log.info("Navigate to someones wishlist page");
		p.NavigateToFindSomeOneWishlist();
		//left nav links	
    	log.info("Take Count of left nav links");
		int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
		
		for(int i=0;i<LeftNavLinksCount;i++)
		{
	        //Navigate to wish list search result page
			log.info("Navigate to someones wishlist page");
			p.NavigateToFindSomeOneWishlist();
			
			//click on left nav links 
			log.info("Click on left nav link: "+i);
			l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
			
			String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 6);
			String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 7);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
			//sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), Expected_LeftnavBreadcrumb);
		}
		//Navigate to wish list search result page
				log.info("Navigate to someones wishlist page");
				p.NavigateToFindSomeOneWishlist();
		log.info("Contact-US link");
		l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
		sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
		sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="124514")
	public void TC_016_Wishlist_DetailPage_ProductName_Click() throws Exception
	{
	        //Navigate to wish list search result page
			log.info("Navigate to someones wishlist page");
			p.NavigateToFindSomeOneWishlist();
			log.info("Click on View");
			l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").click();
			String Pname=l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").getText();
			log.info("Click on Product name");
			l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").click();
			sa.assertEquals(gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"), Pname);
			//It will return all the assertions
			sa.assertAll();
			i=0;
	}
	
	@Test(groups="{Regression}",dataProvider="Find_Wishlist_Validation",dataProviderClass=Data.class, description="124522_148711_148712_124511")
	public void TC_017_Wishlist_SearchResults_Page_Validations(TestData t) throws Exception
	{
		//Navigate to wish list search result page
		log.info("Navigate to someones wishlist page");
		p.NavigateToFindSomeOneWishlist();
		Thread.sleep(3000);	
				
				//validating the fields last name,first name,email 
				p.ClearWishlistLoginFields();
				 log.info("Enter Firstname:"+i);
				l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").sendKeys(t.get(0));
				 log.info("Enter Lastname:"+i);
				l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").sendKeys(t.get(1));
				 log.info("Enter Email:"+i);
				l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys(t.get(2));	
				//click on find button
				log.info("Click on Find Button:"+i);
				l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
				Thread.sleep(3000);
				
				//Blank
			if(i==0 || i==1 || i==6)
			{
				//user should be in same page
				sa.assertEquals(gVar.assertEqual("Find_Wishlist_Page_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",5,2));		
			
				//verify the text message
			if(i==6)
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
				sa.assertEquals(true,l1.getWebElement("Find_Wishlist_Page_View", "Profile\\Wishlist.properties").getAttribute("href"));
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
		    	//Fn
				sa.assertTrue(gVar.assertVisible("Wishlist_Lastname_Block", "Profile\\Wishlist.properties"),"Lastname Block");
				//LN
				sa.assertTrue(gVar.assertVisible("Wishlist_Firstname_Block", "Profile\\Wishlist.properties"),"Firstname Block");
				//Location
				sa.assertTrue(gVar.assertVisible("Wishlist_Location_Block", "Profile\\Wishlist.properties"),"Location Block");
		    	//left nav section
		    	log.info("Take Count of left nav links");
				int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
				for (int j=0;j<LeftNavLinksCount;j++)
				{
					sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(j).isDisplayed(),"LeftNav links display");
					String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(j).getText();
					sa.assertEquals(leftNavLinks,GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",j+1,4));
				}
				
				int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
				for (int j=0;j<=LeftNavHeadings;j++)
				{
					log.info("Left nav headings");
					sa.assertEquals(gVar.assertEqual("LeftNav_Headings","Profile\\login.properties", j),GetData.getDataFromExcel("\\data\\ProfileData.xls","WishList",j+1,5));
				}
				
				//LeftNav_Needhelp_Text
				sa.assertTrue(gVar.assertVisible("LeftNav_NeedHelp_Heading","Profile\\Register.properties"),"Need help? Heading");
				sa.assertTrue(gVar.assertVisible("LeftNav_Needhelp_Text","Profile\\Register.properties"),"Need help Text");
				//Customer service
				sa.assertTrue(gVar.assertVisible("LeftNav_CustomerService", "Profile\\Register.properties"), "Customer service");
				}
			else if(i==0 || i==1)
				{
				//No wish list has been found
				sa.assertTrue(gVar.assertVisible("Find_Wishlist_Page_Text", "Profile\\Wishlist.properties"),"No Wishlist found Text:"+i);
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
			
			//max characters
		    	if(i==5)
				{
				//More than 50 characters
				sa.assertEquals(l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").getAttribute("maxlength"),50);
				sa.assertEquals(l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").getAttribute("maxlength"),50);
				sa.assertEquals(l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").getAttribute("maxlength"),50);
				}
			}
			i++;
			//It will return all the assertions
			sa.assertAll();
		}
	
	@Test(groups="{Regression}",description="124515")
	public void TC_018_Wishlist_SearchResults_Page_AddToCart() throws Exception
	{
		//Fetch Product details
		log.info("Fetch Wishlist Productname");
		String Pname=l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").getText();
		//log.info("Fetch Wishlist Product Sku Id");
		//String Skuid=l1.getWebElement("Wishlist_DetailPage_SkuID", "Profile\\Wishlist.properties").getText();
		log.info("Fetch Wishlist Product Price");
		String Price=l1.getWebElement("Wishlist_DetailPage_ProductPrice", "Profile\\Wishlist.properties").getText();
		log.info("Fetch Wishlist Product Attribute");
		int AttributeCount=l1.getWebElements("Wishlist_DetailPape_Attribute", "Profile\\Wishlist.properties").size();
		log.info("Click on Add to cart");
		l1.getWebElement("Wishlist_AddtoCart_Button", "Profile\\Wishlist.properties").click();
		Thread.sleep(3000);
		log.info("Loop executes for each attribute ex: Color/size/length");
		for(int i=0;i<AttributeCount;i++)
		{
		String Attribute=l1.getWebElements("Wishlist_DetailPape_Attribute", "Profile\\Wishlist.properties").get(i).getText();		
		gVar.MouseHover("MiniCart_FlyOut", "ShopNav\\Minicart.properties");
		Thread.sleep(1000);
		String MiniCartAttribute=l1.getWebElements("Minicart_Product_Attributes", "ShopNav\\Minicart.properties").get(i).getText();		
		//Product price
		sa.assertEquals(gVar.assertEqual("Minicart_Product_ProductPrice", "ShopNav\\Minicart.properties"), Price);
		//Product name
		sa.assertEquals(gVar.assertEqual("Minicart_ProductName", "ShopNav\\Minicart.properties"), Pname);
		//Attributes
		sa.assertEquals(Attribute,MiniCartAttribute);			
		}
			
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="Delete_Items_From_Wishlist")
	public void TC_019_Delete_Items_From_Wishlist(XmlTest XmlTest) throws Exception
	{
		log.info("Delete Added Items from Wishlist");
		p.deleteAddeditemsFromWishlistAccount(XmlTest);
		//It will return all the assertions
		sa.assertAll();
	}
	
}