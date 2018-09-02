package com.prevail.shopnav;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class Footer extends BaseTest
{
	
	@Test(groups="{Regression}",description="148553")
	public void TC00_GlobalFooter_UI() throws Exception
	{
		
		sa.assertTrue(gVar.assertVisible("Footer_FollowText", "ShopNav\\HomePage.properties"),"Follow us text");
		int SocilaLinks=l1.getWebElements("Footer_SocilaLinks", "ShopNav\\HomePage.properties").size();
		for(i=0; i<SocilaLinks; i++)
		{
			sa.assertTrue(gVar.assertVisible("Footer_SocilaLinks", "ShopNav\\HomePage.properties", i),"Social icon links display");
		}
		sa.assertTrue(gVar.assertVisible("Footer_EmailSignUp_Text", "ShopNav\\HomePage.properties"),"Email SignUp text");
		sa.assertTrue(gVar.assertVisible("Footer_EmailSignUp_Textbox", "ShopNav\\HomePage.properties"),"Email SignUp textbox");
		sa.assertTrue(gVar.assertVisible("Footer_EmailSignUp_Icon", "ShopNav\\HomePage.properties"),"Email SignUp icon");
		
		int FooterSectionHeading=l1.getWebElements("Footer_SectionsHeading", "ShopNav\\HomePage.properties").size();
		for(i=0; i<FooterSectionHeading; i++)
		{
			sa.assertTrue(gVar.assertVisible("Footer_SectionsHeading", "ShopNav\\HomePage.properties", i),"Footer Section headings");
		}
		
		int FooterAccountSectionLinks=l1.getWebElements("Footer_AccountSection_Links", "ShopNav\\HomePage.properties").size();
		for(i=0; i<FooterAccountSectionLinks; i++)
		{
			sa.assertTrue(gVar.assertVisible("Footer_AccountSection_Links", "ShopNav\\HomePage.properties", i),"Footer Section headings");
		}
		
		int FooterCustomerServiceSectionLinks=l1.getWebElements("Footer_AccountSection_Links", "ShopNav\\HomePage.properties").size();
		for(i=0; i<FooterCustomerServiceSectionLinks; i++)
		{
			sa.assertTrue(gVar.assertVisible("Footer_CustomerServiceSection_Links", "ShopNav\\HomePage.properties", i),"Footer Section headings");
		}
		
		int FooterAboutSectionLinks=l1.getWebElements("Footer_AccountSection_Links", "ShopNav\\HomePage.properties").size();
		for(i=0; i<FooterAboutSectionLinks; i++)
		{
			sa.assertTrue(gVar.assertVisible("Footer_AboutSection_Links", "ShopNav\\HomePage.properties", i),"Footer Section headings");
		}
		sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="148563_148561_148564_124677")
	public void TC01_Footer_AccountSectionLinks_Navigation() throws Exception
	{
		
		int FooterAccountSectionLinks=l1.getWebElements("Footer_AccountSection_Links", "ShopNav\\HomePage.properties").size();
		
		for(i=0; i<FooterAccountSectionLinks; i++)
		{
			System.out.println(i);
			l1.getWebElements("Footer_AccountSection_Links", "ShopNav\\HomePage.properties").get(i).click();
			if(i==0)
			{
				log.info("MyAccount");
				sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\login.properties", i),GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));
			}
			
			else if(i==1)
			{
				log.info("checkorder");
				String CheckOrderHeading=l1.getWebElements("Login_CheckOrder_Heading", "Profile\\login.properties").get(0).getText().substring(0, 11);
				System.out.println(CheckOrderHeading);
				sa.assertEquals(CheckOrderHeading,GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));

			}
			
			else if(i==2)
			{
				log.info("WishList");

				sa.assertEquals(gVar.assertEqual("Wishlist_Login_Heading", "Profile\\Wishlist.properties", i),GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));

			}
			
			else if(i==3)
			{
				log.info("Gift registry");
                String GiftRegistryHeading=l1.getWebElements("HomePage_GiftRegistry_Heading", "ShopNav\\HomePage.properties").get(3).getText().substring(0, 27);
                System.out.println(GiftRegistryHeading);
				sa.assertEquals(GiftRegistryHeading,GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));

			}
		}
		
		sa.assertAll();
		
		
	}
	
	@Test(groups="{Regression}",description="148566_148570_124685_148565 ")
	public void TC02_Footer_CustomerServiceSection_LinkNavigation() throws Exception
	{
		
        int Footer_CustomerServiceScetion_Links=l1.getWebElements("Footer_CustomerServiceScetion_Links", "ShopNav\\HomePage.properties").size();
		
		for(i=0; i<Footer_CustomerServiceScetion_Links; i++)
		{
			System.out.println(i);
			l1.getWebElements("Footer_CustomerServiceScetion_Links", "ShopNav\\HomePage.properties").get(i).click();
			
			
			if(i==0)
			{
				String ContactUsText=l1.getWebElements("CustoomerService_headings", "ShopNav\\HomePage.properties").get(0).getText().substring(0, 10);
				
				System.out.println(ContactUsText);
				//sa.assertEquals(gVar.assertEqual("CustoomerService_headings", "ShopNav\\HomePage.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 1));
                
				sa.assertEquals(ContactUsText, GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 1));
				
			}
			else if(i==1 || i==2 || i==3)
			{
				sa.assertEquals(gVar.assertEqual("CustoomerService_headings", "ShopNav\\HomePage.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 1));
				sa.assertAll();
			}
		
		}
		
		
	}
	
	@Test(groups="{Regression}",description="148567_148568_148569_148571")
	public void TC03_Footer_CustomerServiceSection_LinkNavigation() throws Exception
	{
		
        int Footer_AboutSection_Links=l1.getWebElements("Footer_AboutSection_Links", "ShopNav\\HomePage.properties").size();
		
		for(i=0; i<Footer_AboutSection_Links; i++)
		{
			System.out.println(i);
			
			l1.getWebElements("Footer_AboutLinks", "ShopNav\\HomePage.properties").get(i).click();
			
			sa.assertEquals(gVar.assertEqual("CustoomerService_headings", "ShopNav\\HomePage.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1,2));
			
		   
		}
		
		 sa.assertAll();
	}
	
	
	
	/*@Test(groups="{Regression}",description="148573")
	public void TC04_Footer_EmailSubScribeButton(XmlTest xmlTest) throws Exception
	{
		
		int rownumber=new Integer(xmlTest.getParameter("dynamicNum"));
		l1.getWebElement("Footer_EmailSignUp_Textbox", "ShopNav\\HomePage.properties").sendKeys(GetData.getDataFromExcel("//data//GenericData.xls","Register", rownumber, 2));
		log.info("Click on Email  SubScription icon");
		l1.getWebElement("Footer_EmailSignUp_Icon", "ShopNav\\HomePage.properties").click();
		sa.assertTrue(gVar.assertVisible("Footer_EmailSignUp_HeaderText", "ShopNav\\HomePage.properties"),"Email Signup header text");
		sa.assertAll();
	}*/
	
	@Test(groups="{Regression}",description="124694_148559_148560_124679")
	public void TC04_Footer_AccountSectionLinks_Navigation_RegisteredUser(XmlTest xmlTest) throws Exception
	{
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link");
		l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
		log.info("Log in to tha application with valid credentials");
		p.loginToAppliction(xmlTest);
		
		log.info("Myaccount section page verificatrion");
        sa.assertTrue(gVar.assertVisible("MyAccount_options", "Profile\\MyAccountHome.properties"),"MyAccount landing page");
       int FooterAccountSectionLinks=l1.getWebElements("Footer_AccountSection_Links", "ShopNav\\HomePage.properties").size();
		
		for(i=0; i<FooterAccountSectionLinks; i++)
		{
			System.out.println(i);
			l1.getWebElements("Footer_AccountSection_Links", "ShopNav\\HomePage.properties").get(i).click();
			if(i==0)
			{
				log.info("MyAccount");
				sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\login.properties", i),GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));
			}
			
			else if(i==1)
			{
				log.info("checkorder");
				String CheckOrderHeading=l1.getWebElements("Login_CheckOrder_Heading", "Profile\\login.properties").get(0).getText().substring(0, 11);
				System.out.println(CheckOrderHeading);
				sa.assertEquals(CheckOrderHeading,GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));

			}
			
			else if(i==2)
			{
				log.info("WishList");

				sa.assertEquals(gVar.assertEqual("Wishlist_Login_Heading", "Profile\\Wishlist.properties", i),GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));

			}
			
			else if(i==3)
			{
				log.info("Gift registry");
                String GiftRegistryHeading=l1.getWebElements("HomePage_GiftRegistry_Heading", "ShopNav\\HomePage.properties").get(3).getText().substring(0, 27);
                System.out.println(GiftRegistryHeading);
				sa.assertEquals(GiftRegistryHeading,GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 0));

			}
		}
		
		sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="148566_148570_124685_148565 ")
	public void TC05_Footer_CustomerServiceSection_LinkNavigation_RegisteredUser() throws Exception
	{
		
		 int Footer_CustomerServiceScetion_Links=l1.getWebElements("Footer_CustomerServiceScetion_Links", "ShopNav\\HomePage.properties").size();
			
			for(i=0; i<Footer_CustomerServiceScetion_Links; i++)
			{
				System.out.println(i);
				l1.getWebElements("Footer_CustomerServiceScetion_Links", "ShopNav\\HomePage.properties").get(i).click();
				
				
				if(i==0)
				{
					String ContactUsText=l1.getWebElements("CustoomerService_headings", "ShopNav\\HomePage.properties").get(0).getText().substring(0, 10);
					
					System.out.println(ContactUsText);
					//sa.assertEquals(gVar.assertEqual("CustoomerService_headings", "ShopNav\\HomePage.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 1));
	                
					sa.assertEquals(ContactUsText, GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 1));
					
				}
				else if(i==1 || i==2 || i==3)
				{
					sa.assertEquals(gVar.assertEqual("CustoomerService_headings", "ShopNav\\HomePage.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1, 1));
					sa.assertAll();
				}
			
			}
		
	}
	
	@Test(groups="{Regression}",description="148567_148568_148569_148571")
	public void TC06_Footer_CustomerServiceSection_LinkNavigation_RegisteredUser() throws Exception
	{
		
		 int Footer_AboutSection_Links=l1.getWebElements("Footer_AboutSection_Links", "ShopNav\\HomePage.properties").size();
			
			for(i=0; i<Footer_AboutSection_Links; i++)
			{
				System.out.println(i);
				
				l1.getWebElements("Footer_AboutLinks", "ShopNav\\HomePage.properties").get(i).click();
				
				sa.assertEquals(gVar.assertEqual("CustoomerService_headings", "ShopNav\\HomePage.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", i+1,2));
				
			   
			}
		sa.assertAll();
	}
	
	
	

}
