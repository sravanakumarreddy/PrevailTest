package com.prevail.shopnav;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class Header extends BaseTest
{

	
	@Test(groups="{Regression}",description="148555")
	public void TC00_Header_LoginLink_navigation() throws Exception
	{
		
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link");
		l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
		sa.assertTrue(gVar.assertVisible("Login_Heading", "Profile\\login.properties"),"My Account Login Heading");
		sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="212936_215396")
	public void TC01_Header_MyAccDropdown_UI() throws Exception
	{
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		sa.assertTrue(gVar.assertVisible("Header_MyAccount_LoginRegister_Text", "ShopNav\\HomePage.properties"),"Login and register text in user account flyout");
		sa.assertTrue(gVar.assertVisible("Login_Icon", "Profile\\Register.properties"),"Login Link text in user account flyout");
		sa.assertTrue(gVar.assertVisible("Register_Icon", "Profile\\Register.properties"),"register text in user account flyout");
        sa.assertAll();
		
	}
	
	@Test(groups="{Regression}",description="124676")
	public void TC02_Header_UI() throws Exception
	{
		
		try
		{
			if(l1.getWebElement("Header_PromotionText", "ShopNav\\HomePage.properties").isDisplayed())
			{
				sa.assertTrue(gVar.assertVisible("Header_PromotionText", "ShopNav\\HomePage.properties"),"Promotion text is configured and it is displayed");
			}
		}
		catch(Exception e)
		{
			log.info("Promition text is not configured");
		}
		
		sa.assertTrue(gVar.assertVisible("Header_Logo", "ShopNav\\HomePage.properties"),"Logo of the is displayed");
		sa.assertTrue(gVar.assertVisible("Header_StoreLocator", "ShopNav\\HomePage.properties"),"StoreLocator of the is displayed");
		sa.assertTrue(gVar.assertVisible("Header_CartIcon", "ShopNav\\HomePage.properties"),"Cart Icon of the is displayed");
		sa.assertTrue(gVar.assertVisible("MyAccountIcon", "Profile\\Register.properties"),"User Account Icon of the is displayed");
		sa.assertTrue(gVar.assertVisible("Header_SearchTextBox","ShopNav\\HomePage.properties"),"Search TextBox is displayed");
		sa.assertTrue(gVar.assertVisible("Header_SearchIcon","ShopNav\\HomePage.properties"),"Search TextBox is displayed");
		sa.assertTrue(gVar.assertVisible("Header_CountryDropDown","ShopNav\\HomePage.properties"),"Search TextBox is displayed");

		log.info("Root Category Links");
        int CategoryLinks=l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").size();
        for(i=0; i<CategoryLinks; i++)
        {
        	sa.assertTrue(gVar.assertVisible("Header_Category_Links", "ShopNav\\HomePage.properties",i),"All Category links are displying");
        }
        
        log.info("Place Holder text verification");
        
        String SearchTextBoxPlaceholderText=l1.getWebElement("Header_SearchTextBox", "ShopNav\\HomePage.properties").getAttribute("placeholder");
        System.out.println(SearchTextBoxPlaceholderText);
        sa.assertEquals(SearchTextBoxPlaceholderText, GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 4));
		//sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\Login.properties", i),GetData.getDataFromExcel("//data//ShopNavData.xls","Footer", 1, 0));
        sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124681")
	public void TC03_Minicart_Navigation() throws Exception
	{
		
		log.info("Click on Minicart Icon");
		l1.getWebElement("Header_CartIcon", "ShopNav\\HomePage.properties").click();
		log.info("Empty cart page verification");
		sa.assertTrue(gVar.assertVisible("EmptyCart_PageText", "ShopNav\\HomePage.properties"),"Empty cart is displayed");
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="212389")
	public void TC04_StoreLocator_Navigation() throws Exception
	{
		
		log.info("Click on Minicart Icon");
		l1.getWebElement("Header_StoreLocator", "ShopNav\\HomePage.properties").click();
		log.info("Empty cart page verification");
		sa.assertTrue(gVar.assertVisible("StoreLocator_Heading", "ShopNav\\HomePage.properties"),"Store locator heading is displayed");
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148556 ")
	public void TC05_RegisterLink_Navigation() throws Exception
	{
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("Click on Register text link in user account flyout");
		l1.getWebElement("Register_Icon", "Profile\\Register.properties").click();
		log.info("Empty cart page verification");
		sa.assertTrue(gVar.assertVisible("StoreLocator_Heading", "ShopNav\\HomePage.properties"),"Create Account heading");
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="212934")
	public void TC06_TopSellerCategory_Navigation() throws Exception
	{
		
		log.info("Click on top seller category link in the header");
		l1.getWebElement("Header_TopSeller_Category", "ShopNav\\HomePage.properties").click();
		sa.assertTrue(gVar.assertVisible("Category_TopsellerBreadcrumb", "ShopNav\\CategoryLanding.properties"),"TopSellerCategory Breadcrumb");
		sa.assertEquals(gVar.assertEqual("Category_TopsellerBreadcrumb", "ShopNav\\CategoryLanding.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 5, 2));
		sa.assertAll();
		log.info("Click on Logo of the application");
		l1.getWebElement("Header_Logo", "ShopNav\\HomePage.properties").click();
		sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="212390_148558")
	public void TC07_MyAccountDroDownNavigation(XmlTest xmlTest) throws Exception
	{
		
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link");
		l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
		log.info("Login to the application");
		p.loginToAppliction(xmlTest);
		
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		
		int RegisteredFlyoutLinks=l1.getWebElements("Header_Registered_MyAccLinks", "ShopNav\\HomePage.properties").size();
		
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		
		for(i=0; i<RegisteredFlyoutLinks; i++)
		{
			
			log.info("Click on User account icon");
			l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
			l1.getWebElements("Header_Registered_MyAccLinks", "ShopNav\\HomePage.properties").get(i).click();
			if(i==0)
			{
		        sa.assertTrue(gVar.assertVisible("MyAccount_options", "Profile\\MyAccountHome.properties"),"MyAccount landing page");
		        System.out.println("MyAccount landing page");
			}
			
			else if(i==1 || i==2)
			{
			
			
				sa.assertEquals(gVar.assertEqual("Login_Heading", "Profile\\login.properties"),GetData.getDataFromExcel("//data//ShopNavData.xls","Header", i+1, 1));
				System.out.println("MyAccount landing page second loop");
			}
			
			else if(i==3)
			{
				l1.getWebElement("Login_Heading", "Profile\\login.properties").getText();
			}
			
			else if(i==4)
			{
				log.info("My account login' as page title");
				sa.assertTrue(l1.getWebElement("Login_Heading","Profile\\login.properties").isDisplayed());
			}
			
			
		}
		sa.assertAll();
		log.info("Click on Logo of the application");
		l1.getWebElement("Header_Logo", "ShopNav\\HomePage.properties").click();
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="212390_148558")
	public void TC08_MyAccountDroDownUI_Verification(XmlTest xmlTest) throws Exception
	{
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link");
		l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
		log.info("Login to the application");
		p.loginToAppliction(xmlTest);
		
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		
		int registeredMyAccLinks=l1.getWebElements("Header_Registered_MyAccLinks", "ShopNav\\HomePage.properties").size();
		for(i=0; i<registeredMyAccLinks; i++)
		{
			sa.assertTrue(gVar.assertVisible("Header_Registered_MyAccLinks", "ShopNav\\HomePage.properties", i),"Each link in MyAccount user flyout is diaplayings");
		}
		
		log.info("Logout from the application");
		l1.getWebElements("Header_Registered_MyAccLinks", "ShopNav\\HomePage.properties").get(4).click();
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="215394")
	public void TC09_Header_TooltipText() throws Exception
	{
		
		log.info("Click on Logo of the application");
		l1.getWebElement("Header_Logo", "ShopNav\\HomePage.properties").click();
		log.info("Mouse hover on logo");
		//act.moveToElement(l1.getWebElement("Header_Logo", "ShopNav\\HomePage.properties")).perform();
		String ToolTipText=l1.getWebElement("Hedaer_ToolTip_Text", "ShopNav\\HomePage.properties").getAttribute("title");
		System.out.println(ToolTipText);
		log.info("Click on logo");
		l1.getWebElement("Header_Logo", "ShopNav\\HomePage.properties").click();
		log.info("Home Page Should be loaded");
		sa.assertTrue(gVar.assertVisible("HomePage_SliderImage", "ShopNav\\HomePage.properties"),"HomePage Slider Images");
        sa.assertAll();
	}
	
		@Test(groups="{Regression}",description="215395")
		public void TC10_CountryDropDown_Navigation() throws Exception
		{
		
			int CountryCounts=l1.getWebElements("Header_CountryNames", "ShopNav\\HomePage.properties").size();
			for(i=0; i<CountryCounts; i++)
			{
				
				log.info("Click on country dropdown");
				l1.getWebElement("Header_CountryDropDown", "ShopNav\\HomePage.properties").click();
                 
				l1.getWebElements("Header_CountryNames", "ShopNav\\HomePage.properties").get(i).click();
				String HomePage_SelectedCountryName=l1.getWebElement("HomePage_SelectedCountryName_VerificaionText", "ShopNav\\HomePage.properties").getText();
			    System.out.println(HomePage_SelectedCountryName);
			    sa.assertEquals(HomePage_SelectedCountryName, GetData.getDataFromExcel("//data//ShopNavData.xls","Header", i+1, 0));
			    
			    
                gVar.handlingDropdown("Header_CountryNames", "ShopNav\\HomePage.properties", i);
                sa.assertEquals(gVar.assertEqual("Header_SearchTextBox", "ShopNav\\HomePage.properties", "placeholder", i), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", i+1, 0));
                sa.assertAll();
                
			}
			
		
	    }
	
	
	
	
	
	
	
	
	
}
