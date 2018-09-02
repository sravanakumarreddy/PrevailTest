package com.prevail.shopnav;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.pom.PDP_BundlePOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;



public class PDP_ProductBundles extends BaseTest
{

    @Test(groups="{Regression}",description="287972")
	public void TC00_Bundle_ProdNameNavigation() throws Exception
	{
		log.info("Search For Bundle Product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
        int sizeName=l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundles).size();
        System.out.println(sizeName);
        for(i=0; i<sizeName; i++)
        {
        	log.info("fetching the product names");
        	String ProdName=l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundleProNames).get(i).getText();
        	System.out.println(ProdName);
        	log.info("Clickng on each of the bundle product name links");
        	l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundleProNames).get(i).click();
        	
        	sa.assertEquals(ProdName,gVar.assertEqual(PDP_BundlePOM.BundleProd_ProductName));
           
            log.info("Search For Bundle Product");
    		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
        	sa.assertAll();
        }
	}


	@Test(groups="{Regression}",description="287824")
	public void TC01_Bundle_AddToWishList() throws Exception
	{
		
		log.info("Search For Bundle Product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
		log.info("CLick on wishlist");
		l1.getWebElement(PDP_BundlePOM.Bundle_WishListLink).click();
		log.info("My account login' as page title");
		sa.assertTrue(l1.getWebElement("Login_Heading","Profile\\login.properties").isDisplayed());
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="287827")
	public void TC02_Bundle_AddToGiftRegistry() throws Exception
	{
		
		log.info("Search For Bundle Product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
		log.info("Click on Gift Registry Link");
		l1.getWebElement(PDP_BundlePOM.Bundle_AddToGiftregistry).click();
		
		log.info("Gift registry page heading");
		sa.assertEquals(gVar.assertEqual(PDP_BundlePOM.Bundle_giftRegistry_Heading),GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 5));
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124856")
	public void TC03_Bundle_AddAllToCart() throws Exception
	{
		
		log.info("Search For Bundle Product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
		
		log.info("Product Name");
		String BundleProdName=l1.getWebElement(PDP_BundlePOM.BundleProd_ProductName).getText();
		
		List<String> productsInBundle=new ArrayList<>();
	
		  int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundles).size();
		  System.out.println(totalProductsInSet);
		 
		for(i=0; i<totalProductsInSet;i++)
			{	
			
			   productsInBundle.add(l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundleProNames).get(i).getText().toString());
			
			}
		
		System.out.println(productsInBundle);
		log.info("Click on Add to cart Button");
		
		l1.getWebElement("PDP_AddToCart", "ShopNav\\PDP.properties").click();
		//verify the cart quantity
		String expQuantity=GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1,1);
		System.out.println(expQuantity);
		String actQuantity=l1.getWebElement("Minicart_Quantity", "ShopNav\\Minicart.properties").getText();
		System.out.println(actQuantity);
		sa.assertEquals(expQuantity, actQuantity);
		
		
		
		log.info("CLick on view cart link in the Minicart");
		l1.getWebElement("MiniCart_ViewCart", "ShopNav\\Minicart.properties").click();
		
		log.info("Product Name verification");
		
		sa.assertEquals(BundleProdName, GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
		
		log.info("Bundle Prod count in Cart page");
		int ProdCountinCart=l1.getWebElements(PDP_BundlePOM.Bundle_CartProdName).size();
		
		List<String> ProdNamesInCart=new ArrayList<>();
		System.out.println(ProdCountinCart);
		int k;
		for(k=0; k<ProdCountinCart;k++)
		{
			ProdNamesInCart.add(l1.getWebElements(PDP_BundlePOM.Bundle_CartProdName).get(k).getText());
		}
		
		System.out.println(ProdNamesInCart);
		
		log.info("Products added verification");
		sa.assertEquals(ProdNamesInCart, productsInBundle);
        
		sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="124841")
	public void TC04_Bundle_UI() throws Exception
	{
		
		
		
		s.NavigateToBundleProduct();
		sa.assertTrue(gVar.assertVisible("Login_Breadcrumb", "Profile\\login.properties"),"Product bundleBreadCrumb");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.BundleProd_ProductName),"Bundle product name");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_MainBundleImage),"Bundle product Main Image");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AlternateImages),"Bundle product Alternate Images section");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_MainProduct_ItemId),"Bundle product Main Item ID");
		int ProdNames=l1.getWebElements(PDP_BundlePOM.BundleProd_ProductName).size();
         for(i=0; i<ProdNames; i++)
         {
        	 System.out.println(i);
        	 sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.BundleProd_ProductName, i),"Bundle Product names");
        	 sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ProductNumber, i),"Bundle Product Numbers");
        	 sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_BundleQty, i),"Bundle Product Qty");
        	 sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AvailabilityMsgLabel, i),"Bundle Availability mesg");
        	 sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ProdSetImages, i),"Bundle Product Images");
          }
         int ProdPrice=l1.getWebElements(PDP_BundlePOM.Bundle_BundleProdPrice).size();
		 for(i=0; i<ProdPrice; i++)
         {System.out.println(i);
        	 sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_BundleProdPrice, i),"Bundle Product Prices");
        	 
         }
		 
		 log.info("Add to cart button");
		 sa.assertTrue(gVar.assertVisible("PDP_AddToCart", "ShopNav\\PDP.properties"),"Add to cart button");
		 int FBShareIcons=l1.getWebElements(PDP_BundlePOM.Bundle_ShareIcons).size();
		 for(i=0; i<FBShareIcons; i++)
         {
			 System.out.println(i);
        	 sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ShareIcons, i),"Bundle Product Socila Share icons");
         }
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AddToGiftregistry),"Add to gift registry link text");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_WishListLink),"WishList link text");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_PreviousLink),"Previous link");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_PreviousLink),"Next link");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_NextLink),"Next link");

      sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="124858")
	public void TC05_Bundle_AddToWishList(XmlTest xmlTest) throws Exception
	{
		
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link");
		l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
		log.info("Login to the application");
		p.loginToAppliction(xmlTest);
		
		log.info("Myaccount section page verificatrion");
        sa.assertTrue(gVar.assertVisible("MyAccount_options", "Profile\\MyAccountHome.properties"),"MyAccount landing page");

        p.clearWishList();
        
		log.info("Search For Bundle Product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
		
		log.info("Product Name");
		String BundleProdName=l1.getWebElement(PDP_BundlePOM.BundleProd_ProductName).getText();
		
		log.info("Click on add to wish list link");
		l1.getWebElement(PDP_BundlePOM.Bundle_WishListLink).click();
		
		sa.assertTrue(gVar.assertVisible("Wishlist_ContactUS_Heading", "Profile\\Wishlist.properties"),"Wish List Heading");
		
		String WishListProdName=l1.getWebElement("Wishlist_ProductName", "Profile\\Wishlist.properties").getText();
		log.info("Bundle Product name verification");
		sa.assertEquals(BundleProdName, WishListProdName);
		sa.assertAll();
		
	}
	
	@Test(groups="{Regression}",description="124859")
	public void TC06_Bundle_AddToGiftRegistry() throws Exception
	{
		
		log.info("Search For Bundle Product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 0));
		log.info("Click on Add to Gift Regisrty link");
		l1.getWebElement(PDP_BundlePOM.Bundle_AddToGiftregistry).click();
		log.info("Page heading verification");
		sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 2));
		sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="124859")
	public void TC07_Bundle_ExtendedwarrantyDropDown() throws Exception
	{
		Select sel; 
         s.NavigateToBundleProduct();
		log.info("Click on extended waranty dropdown");
	
		
		Select se = new Select(l1.getWebElement("Bundle_ExtendedWarrantyDropDown", "ShopNav\\PDP.properties"));
		List<WebElement> DropDownCount = se.getOptions();
		DropDownCount.size();
		log.info("Size of drodown"+DropDownCount);
		
		
		
		for(i=0; i<DropDownCount.size(); i++)
		{
				log.info("Entered in to for loop");
			    gVar.handlingDropdown("Bundle_ExtendedWarrantyDropDown", "ShopNav\\PDP.properties",i);
		}
		
		sa.assertAll();
	}
		
		
		@Test(groups="{Regression}",description="124846")
		public void TC08_Bundle_BreadCrumb() throws Exception
		{
			
			log.info("Navigate to Product Page");
			s.NavigateToBundleProduct();
			log.info("Click On Sub Sub category breadcrumb element");
			l1.getWebElements(PDP_BundlePOM.Bundle_BreadCrumbElements).get(2).click();
            sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_BreadCrumbElements, 2),"Game Console Breadcrumb verification");
            log.info("Navigate to Product Page");
			s.NavigateToBundleProduct();
			l1.getWebElements(PDP_BundlePOM.Bundle_BreadCrumbElements).get(1).click();
            sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_BreadCrumbElements, 1),"Game Console Breadcrumb verification");
            log.info("Navigate to Product Page");
			s.NavigateToBundleProduct();
			l1.getWebElements(PDP_BundlePOM.Bundle_BreadCrumbElements).get(0).click();
            sa.assertTrue(gVar.assertVisible("CLP_RefinementHeader", "ShopNav\\CategoryLanding.properties"),"ShopElectronics");
            sa.assertAll();
		}
		
		
			@Test(groups="{Regression}",description="124848_287821")
		public void TC09_Bundle_PreviousNext_LinkNavigation() throws Exception
		{
			
			log.info("CLick on Electronics Category");
			
			act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(2)).perform();
			
			log.info("Click on Gaming Sub sub category");
			l1.getWebElement(PDP_BundlePOM.Bundle_SubCategory).click();
			l1.getWebElement(PDP_BundlePOM.Bundle_gamingConsoleFilter).click();
			log.info("CLick on product name");
			
			log.info("Total Product count in CLP");
			 List<WebElement>  ProdNames=new ArrayList<>();
			 
				int totalProdCount=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").size();
                System.out.println(totalProdCount);
				for(i=0; i<totalProdCount; i++)
				{
					String prodNames=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(i).getText();
                    System.out.println(prodNames);
				}
				log.info("Click on Product name");
				l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(3).click();
				for(i=0; i<totalProdCount-4;i++)
				{
					String Name=l1.getWebElement(PDP_BundlePOM.BundleProd_ProductName).getText();
					System.out.println(Name);
					//sa.assertEquals(Name, ProdNames.get(i));
					log.info("Click on next link");
					l1.getWebElement(PDP_BundlePOM.Bundle_NextLink).click();
					log.info("verifying the presence of previous link");
					if(i!=totalProdCount-2)
					{
						sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_PreviousLink),"Previous link is dispalyin");
					}
					
					
				}
				for(i=totalProdCount-2; i>0; i--)
				{
					if(i==totalProdCount-2)
					{
						l1.getWebElement(PDP_BundlePOM.Bundle_PreviousLink).click();
					}
					else
					{
						l1.getWebElement(PDP_BundlePOM.Bundle_PreviousLink).click();
					}
					if(i!=totalProdCount-2)
					{
						
					sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_NextLink),"Next link is visible");
				}
			
			
		}
				String Name=l1.getWebElement(PDP_BundlePOM.BundleProd_ProductName).getText();	
				sa.assertEquals(ProdNames.get(i), Name);
		}
		
	
	
	
	
	
	
}
