package com.prevail.shopnav;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.prevail.pom.PDP_BundlePOM;
import com.prevail.pom.Quickview_POM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class QuickView extends BaseTest
{
   
	@Test(groups="{Regression}",description="148583")
	public void TC00_QuickView_ButtonVerification() throws Exception
	{
		
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties"),"Quick view button display");
		sa.assertAll();
		
	}
	

	@Test(groups="{Regression}",description="128529")
	public void TC01_QuickView_AddToCart() throws Exception
	{
		
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		log.info("Select swatches");
		s.SelectSwatch();
		String Quickviewprodname=l1.getWebElement("PDP_Product_Name", "ShopNav\\PDP.properties").getText();
		log.info("Click on add to cart");
		l1.getWebElement("PDP_AddToCart", "ShopNav\\PDP.properties").click();
		Thread.sleep(1000);
		log.info("Click on view cart");
		l1.getWebElement("MiniCart_ViewCart", "ShopNav\\Minicart.properties").click();
		log.info("Prod Name verification");
		sa.assertEquals(l1.getWebElement(PDP_BundlePOM.Standared_CartProdName).getText(), Quickviewprodname);
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148585")
	public void TC02_QuickView_ViewFullDetails() throws Exception
	{
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		log.info("Click on view full details link");
		l1.getWebElement(Quickview_POM.ViewFullDetails).click();
		log.info("PDP Main Page");
		sa.assertTrue(gVar.assertVisible("PDP_Main_Page", "ShopNav\\PDP.properties"),"PDP main Page");
		sa.assertAll();

	}

	@Test(groups="{Regression}",description="148587")
	public void TC03_QuickView_ColorSelection() throws Exception
	{
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		int Colors=l1.getWebElements("pdp_ColorSwatch_Selected", "ShopNav\\PDP.properties").size();
		System.out.println(Colors);
		if(Colors==1)
		{
			
			System.out.println(Colors==1);
			if(l1.getWebElement("pdp_ColorSwatch_Selected", "ShopNav\\PDP.properties").isDisplayed())
			{
				  String[] Title=l1.getWebElement("pdp_colorAttributeName", "ShopNav\\PDP.properties").getAttribute("title").split(" ");
				  System.out.println(Title[2].toUpperCase());
				  //verify whether selected value is displaying or not
				 sa.assertTrue(gVar.assertVisible("PDP_Product_Color", "ShopNav\\PDP.properties"),"Color selected value");
				  sa.assertEquals(Title[2].toUpperCase(),l1.getWebElement("PDP_Product_Color", "ShopNav\\PDP.properties").getText());
			}
			
			else
			  {
			  //click on swatch anchor
				l1.getWebElement("pdp_color_SwatchesValues",  "ShopNav\\PDP.properties").click();
				String Title=l1.getWebElement("pdp_color_SwatchesValues",  "ShopNav\\PDP.properties").getAttribute("title");
				System.out.println(Title);
			  //verify whether selected value is displaying or not
				 sa.assertTrue(gVar.assertVisible("PDP_Product_Color", "ShopNav\\PDP.properties"),"Color selected value");
			  sa.assertEquals(Title,l1.getWebElement("PDP_Product_Color", "ShopNav\\PDP.properties").getText());
			  }
			
		}
		else
		{
			
			for(i=0; i<Colors; i++)
			{
				
				System.out.println(i);
				l1.getWebElements("pdp_color_SwatchesValues", "ShopNav\\PDP.properties").get(i).click();
				Thread.sleep(4000);
				String SelectedWidth=l1.getWebElement("pdp_ColorSwatch_Selected", "ShopNav\\PDP.properties").getText();
				System.out.println(SelectedWidth);
				log.info("selected width verification");
				sa.assertEquals(SelectedWidth, l1.getWebElement("PDP_Product_Color", "ShopNav\\PDP.properties").getText());
		}
			
	}
		log.info("Click on close link");
		l1.getWebElement("CLP_QuickView_Close", "ShopNav\\CategoryLanding.properties").click();
		sa.assertAll();
		
}
	
	
	@Test(groups="{Regression}",description="148588")
	public void TC04_QuickView_WishList(XmlTest xmlTest) throws Exception
	{
		
		
		
		log.info("Login to the application");
	    //p.loginToAppliction(xmlTest);
	    p.loginToAppliction(xmlTest);
	    
	    Thread.sleep(1000);
		log.info("remove the products if any are in wishlist");
        p.clearWishList();
	    Thread.sleep(1000);

        s.NavigateToVariationSubCategory();
	    Thread.sleep(1000);

		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		log.info("Product Name");
		String VariationProdName=l1.getWebElement(PDP_BundlePOM.BundleProd_ProductName).getText();
		s.SelectSwatch();
		log.info("CLick on add to wish list link");
		l1.getWebElement(PDP_BundlePOM.Bundle_WishListLink).click();
		Thread.sleep(1000);
       sa.assertTrue(gVar.assertVisible("Wishlist_ContactUS_Heading", "Profile\\Wishlist.properties"),"Wish List Heading");
		
		String WishListProdName=l1.getWebElement("Wishlist_ProductName", "Profile\\Wishlist.properties").getText();
		log.info("Bundle Product name verification");
		sa.assertEquals(VariationProdName, WishListProdName);
		
		sa.assertAll();

		
	}
	
	
@Test(groups="{Regression}",description="287805")
	public void TC05_QuickView_GiftRegistry() throws Exception
	{
		
		
		
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		log.info("Product Name");
		String VariationProdName=l1.getWebElement(PDP_BundlePOM.BundleProd_ProductName).getText();
		s.SelectSwatch();
		log.info("Click on Add to Gift Regisrty link");
		l1.getWebElement(PDP_BundlePOM.Bundle_AddToGiftregistry).click();
		log.info("Gift registry page heading");
		sa.assertEquals(gVar.assertEqual(PDP_BundlePOM.Bundle_GiftRegistryLoggedInHeading),GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductBundle", 1, 2));
		sa.assertAll();

		
		
	}

	
@Test(groups="{Regression}",description="125620")
	public void TC06_QuickView_UI() throws Exception
	{
	
	s.NavigateToVariationSubCategory();
	log.info("Mouse hover on product image");
	act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
	log.info("Click on quick view button");
	l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
	log.info("Quick view dialog verification");
	sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		log.info("UI verification of Quickview Dialog");
		sa.assertTrue(gVar.assertVisible(Quickview_POM.Quickview_PreviousButton),"Previous button");
		sa.assertTrue(gVar.assertVisible(Quickview_POM.Quickview_NextButton),"Previous button");
		sa.assertTrue(gVar.assertVisible("PDP_Product_Name", "ShopNav\\PDP.properties"));	
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ProductNumber),"Item number");
		sa.assertTrue(gVar.assertVisible(Quickview_POM.ViewFullDetails),"View full details link");
        try
        {
        	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_StrikeoutPrice),"Strike out price");
        }
        catch(Exception e)
        {
        	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_BundleProdPrice),"Prod price");
        }
        try
        {
    	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_ActualPrice),"Actual price");
        }
        catch(Exception e)
        {
        	log.info("No Strike out price is displayed");
        }
		sa.assertTrue(gVar.assertVisible("pdp_Color_Label", "ShopNav\\PDP.properties"),"Select color label");	
		sa.assertTrue(gVar.assertVisible("pdp_Size_Label", "ShopNav\\PDP.properties"),"Select Size label");	
		sa.assertTrue(gVar.assertVisible("pdp_Size_Label", "ShopNav\\PDP.properties"),"Select Size label");	

    	sa.assertTrue(gVar.assertVisible("pdp_Color_Swatches", "ShopNav\\PDP.properties"),"Color swatches section");
    	sa.assertTrue(gVar.assertVisible("pdp_Size_Swatches", "ShopNav\\PDP.properties"),"Size swatches section");
    	sa.assertTrue(gVar.assertVisible("pdp_Width_Label", "ShopNav\\PDP.properties"),"Width swatches section");
        sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Stnadred_AvailabilitySection),"Availability section");
        try
        {
        	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_AvailabilityCheck),"Available for pickup store");
        }
        catch(Exception e)
        {
        	log.info("Available for pick up store is not present for this product");
        }
    	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_BundleQty),"QTY LAbel");
    	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_QtyTextbox),"QTY LAbel");
    	sa.assertTrue(gVar.assertVisible("PDP_AddToCart","ShopNav\\PDP.properties"),"QTY LAbel");
    	 int SocialIcons=l1.getWebElements(PDP_BundlePOM.Bundle_ShareIcons).size();
         for(i=0; i<SocialIcons; i++)
         {
      	   System.out.println(i);
      	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ShareIcons, i),"Share icons");
      	   
         }
         s.SelectSwatch();
  	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AddToGiftregistry),"Add to gift registry button");
  	   sa.assertTrue(gVar.assertVisible("PDP_AddToWishList","ShopNav\\PDP.properties"),"Add to gift registry button");
        
  	 log.info("Click on close link");
		l1.getWebElement("CLP_QuickView_Close", "ShopNav\\CategoryLanding.properties").click();
		
  	    log.info("Logout from the application");
	    p.Logout();
		sa.assertAll();

        
	}
	
	@Test(groups="{Regression}",description="287805")
	public void TC07_QuickView_CloseIcon() throws Exception
	{
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		log.info("Click on close link");
		l1.getWebElement("CLP_QuickView_Close", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quickview dialog should cloase");
		sa.assertTrue(gVar.assertNotVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog should be closed");
		sa.assertAll();

	}
	
	

	@Test(groups="{Regression}",description="125622")
	public void TC08_QuickView_Gift() throws Exception
	{
		
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		s.SelectSwatch();
		log.info("click on add to Gift Registry link");
		l1.getWebElement(PDP_BundlePOM.Bundle_AddToGiftregistry).click();
		log.info("Gift registry page heading");
		sa.assertEquals(gVar.assertEqual(PDP_BundlePOM.Bundle_giftRegistry_Heading),GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 5));
		sa.assertAll();

	}
	
	
	@Test(groups="{Regression}",description="125621")
	public void TC09_QuickView_AddToWishlist() throws Exception
	{
		
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		s.SelectSwatch();
		log.info("click on add to wishlist link");
		l1.getWebElement(PDP_BundlePOM.Bundle_WishListLink).click();
		log.info("Login Page");
		sa.assertTrue(gVar.assertVisible("Login_Heading", "Profile\\login.properties"),"login heading");
		sa.assertAll();

		
	}
	
   @Test(groups="{Regression}",description="125621")
	public void TC10_QuickView_SlectSize() throws Exception
	{
		
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		int Size=l1.getWebElements("Pdp_Size_Swatch_Selectable", "ShopNav\\PDP.properties").size();
		System.out.println(Size);
		if(Size==1)
		{
			System.out.println(Size==1);
			if(l1.getWebElement("pdp_SizeSwatch_Selected", "ShopNav\\PDP.properties").isDisplayed())
			{
				  String[] Title=driver.findElement(By.xpath("//ul[@class='swatches size']//li[@class='selectable selected']")).getAttribute("title").split(" ");
				  System.out.println(Title[2]);
				  //verify whether selected value is displaying or not
				 sa.assertTrue(gVar.assertVisible("PDP_Product_Size", "ShopNav\\PDP.properties"),"Color selected value");
				  sa.assertEquals(Title,driver.findElement(By.xpath("//ul[@class='swatches size']/li[@class='selected-value']")).getText());
				  
			}
			
			else
			  {
			  //click on swatch anchor
				driver.findElement(By.xpath("//ul[@class='swatches size']//li[@class='selectable selected']")).click();
				String[] Title=driver.findElement(By.xpath("//ul[@class='swatches size']//li[@class='selectable selected']")).getAttribute("title").split(" ");
				
				System.out.println(Title[2]);
				
			  //verify whether selected value is displaying or not
				 sa.assertTrue(gVar.assertVisible("PDP_Product_Size", "ShopNav\\PDP.properties"),"Color selected value");
				 
			  sa.assertEquals(Title,driver.findElement(By.xpath("//ul[@class='swatches size']/li[@class='selected-value']")).getText());
		
			  }
			
		}
		else
		{
			
			for(int j=0; j<Size; j++)
			{
				
	        	System.out.println("Coming here selection operation"+j);

				log.info("Click on all the sizes of first set product");
				driver.findElements(By.xpath("//ul[@class='swatches size']//li")).get(j).click();	
				Thread.sleep(4000);
				String SelectedSize=driver.findElement(By.xpath("//ul[@class='swatches size']//li[@class='selectable selected']/a")).getText();
				System.out.println(SelectedSize);
				sa.assertEquals(driver.findElement(By.xpath("//ul[@class='swatches size']/li[@class='selected-value']")).getText(),SelectedSize);
	            System.out.println(driver.findElement(By.xpath("//ul[@class='swatches size']/li[@class='selected-value']")).getText());
	            //j++;
	            System.out.println("Domne with the iteration"+j);
		}
	}
		 log.info("Click on close link");
			l1.getWebElement("CLP_QuickView_Close", "ShopNav\\CategoryLanding.properties").click();
		sa.assertAll();

    	
    }
		

   
	
	
	@Test(groups="{Regression}",description="287810")
	public void TC11_QuickView_SetProdUI_Guest() throws Exception
	{
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 0));
		//log.info("Click on product name");
		//s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		log.info("Quick view dialog verification");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
		log.info("UI of Product Set");
		 sa.assertTrue(gVar.assertVisible("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties"),"PDP BreadCrumb Element verification");
		
			int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();
            for(i=0; i<totalProductsInSet;i++)
            {
            	
            	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.BundleProd_TotalBundleProNames, i),"Set Prod Names");
            	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ProductNumber, i),"ProdNumber");
            	try
            	{
                	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_StrikeoutPrice, i),"ProdNumber");

            	}
            	catch(Exception e)
            	{
            		System.out.println("Strike out is not displaying");
            	}
            	try
            	{
                	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_ActualPrice, i),"ProdNumber");

            	}
            	catch(Exception e)
            	{
            		System.out.println("Actual Price");
            	}
            	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standare_PromotionSection, i));
      		    sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PromotionTitke, i));
      		    sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PromotionCallout, i));
      		    sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_ActualPrice),"Actual Price of the product");
      		    sa.assertTrue(gVar.assertVisible("pdp_Color_Label", "ShopNav\\PDP.properties",i),"Select color label");
      		    sa.assertTrue(gVar.assertVisible("pdp_Color_Swatches", "ShopNav\\PDP.properties",i),"Colour swatches section");
      		    sa.assertTrue(gVar.assertVisible("pdp_Size_Label", "ShopNav\\PDP.properties",i),"select size label");
      		    sa.assertTrue(gVar.assertVisible("pdp_Size_Swatches", "ShopNav\\PDP.properties",i),"size swatches section");
      		    sa.assertTrue(gVar.assertVisible("pdp_Width_Label", "ShopNav\\PDP.properties",i),"select width label");
      		    sa.assertTrue(gVar.assertVisible("pdp_Width_Swatches", "ShopNav\\PDP.properties",i),"width swatches section");
      		    sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AvailabilityMsgLabel,i),"Actual Price of the product");
      		    sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Prodset_QtyBox,i),"Actual Price of the product");
      		    sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.ProdSet_AddtoCartButton,i),"Actual Price of the product");
  
      		  
            }
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.ProdSet_BuyAllText),"buy all text");
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Prodset_SalePrice),"Sell price");
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.ProdSet_AddAllToCart),"Add all to cart");
		   int SocialIcons=l1.getWebElements(PDP_BundlePOM.Bundle_ShareIcons).size();
	       for(i=0; i<SocialIcons; i++)
	       {
	    	   System.out.println(i);
	    	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ShareIcons, i),"Share icons");
	    	   
	       }
	       log.info("Click on close link");
			l1.getWebElement("CLP_QuickView_Close", "ShopNav\\CategoryLanding.properties").click();
			sa.assertAll();

	}
	

	@Test(groups="{Regression}",description="287815")
	public void TC12_QuickView_BundleProdUI_Guest() throws Exception
	{
		log.info("CLick on Electronics Category");
		act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(2)).perform();
		log.info("Click on Gaming Sub sub category");
		BaseTest.l1.getWebElement(PDP_BundlePOM.Bundle_SubCategory).click();
		BaseTest.l1.getWebElement(PDP_BundlePOM.Bundle_gamingConsoleFilter).click();
		log.info("Total Product count in CLP");
		int totalProdCount=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").size();
		log.info("Mouse hover on bundle prod name");
		act.moveToElement(l1.getWebElements("CLP_ProductImage","ShopNav\\CategoryLanding.properties").get(3)).perform();
		log.info("Click on bundle product quickview");
	    l1.getWebElement("CLP_QuickView_Button","ShopNav\\CategoryLanding.properties").click();
	    log.info("UI of Product Set");
	    sa.assertTrue(gVar.assertVisible(Quickview_POM.Quickview_PreviousButton),"Previous button");
		sa.assertTrue(gVar.assertVisible(Quickview_POM.Quickview_NextButton),"Next button");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AlternateImages),"Alternate Image");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_MainProduct_ItemId),"Main Image");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_MainProduct_ItemId),"main prod item id");
		sa.assertTrue(gVar.assertVisible(Quickview_POM.ViewFullDetails),"View full details Link");
		int BundleProdNames=l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundleProNames).size();
		 for(i=0; i<BundleProdNames; i++)
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
         {
			System.out.println(i);
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
		log.info("Click on close link");
			l1.getWebElement("CLP_QuickView_Close", "ShopNav\\CategoryLanding.properties").click();
		sa.assertAll();

}
	
	
	@Test(groups="{Regression}",description="287815")
	public void TC13_QuickView_NextPrevious() throws Exception
	{
		
		//navigate to sub category
		s.NavigateToVariationSubCategory();
		log.info("Mouse hover on product image");
		act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		
		List<WebElement> prodNames = new ArrayList<>();
		int numberOfProducts=l1.getWebElements("Category_NameLinks", "ShopNav\\CategoryLanding.properties").size();
		
		System.out.println(numberOfProducts);
		
		for(i=0;i<numberOfProducts; i++)
		{
			String ProdNames=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(i).getText();
			System.out.println(ProdNames);
		}
		String name=l1.getWebElement("CLP_ProductName", "ShopNav\\CategoryLanding.properties").getText();
		System.out.println(name);
		
		//navigate to PD page on click of name link
		l1.getWebElement("CLP_ProductName", "ShopNav\\CategoryLanding.properties").click();

		  for (i=0; i<numberOfProducts-1; i++)
		  {
			  System.out.println(i);
		    name = l1.getWebElement("PDP_Product_Name", "ShopNav\\PDP.properties").getText();
		 l1.getWebElement(Quickview_POM.Quickview_NextButton).click();
            //verify the presence of previous link
		    if(i!=numberOfProducts-2)
		    	{
		    	sa.assertTrue(gVar.assertVisible(Quickview_POM.Quickview_PreviousButton),"Previous button");
		    	}
		  }
		  for(i=numberOfProducts-2; i>0; i--)
		  {
			  if(i==numberOfProducts-2)
				{
				l1.getWebElement(Quickview_POM.Quickview_PreviousButton).click();
			  	}
			
			//verify the presence of next link
			    if(i!=numberOfProducts-2)
		    	{
			    	sa.assertTrue(gVar.assertVisible(Quickview_POM.Quickview_NextButton),"Next button");
		    	}
		    name =l1.getWebElement("CLP_ProductName","ShopNav\\CategoryLanding.properties").getText();
		  }	
		
		sa.assertAll();
		
	}

			@Test(groups="{Regression}",description="148589",dataProvider="QTYvalidation",dataProviderClass=Data.class)
	public void TC14_QuickView_QTYdropdown(TestData l) throws Exception
	{
		
		
		for(i=0; i<5;i++)
		{
			
			s.NavigateToVariationSubCategory();
			log.info("Mouse hover on product image");
			act.moveToElement(l1.getWebElement("CLP_ProductImage", "ShopNav\\CategoryLanding.properties")).perform();
			log.info("Click on quick view button");
			l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
			log.info("Quick view dialog verification");
			sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialog verification");
			log.info("Select swatches");
			s.SelectSwatch();
			
			log.info("Clear quantity box values");
			
			
			driver.findElement(By.xpath("//input[@id='Quantity']")).clear();
			
			log.info("accept the alret popup");
			driver.switchTo().alert().accept();
			
			
			
			log.info("QTY validation");
			l1.getWebElement(PDP_BundlePOM.Standared_QtyTextbox).sendKeys(l.get(0));
			
			System.out.println(l.get(0));
			
			
			log.info("Click on add to cart");
			l1.getWebElement("PDP_AddToCart", "ShopNav\\PDP.properties").click();
			log.info("CLick on view cart");
			
			
			if(i==0 || i==1 || i==3)
			{
				sa.assertEquals("1", l1.getWebElement("MiniCart_QtyValue", "ShopNav\\Minicart.properties").getText());
			}
			
			else if(i==2)
			{
				String AddToCartStatus=l1.getWebElement("PDP_AddToCart", "ShopNav\\PDP.properties").getAttribute("disabled");
				assertEquals("disabled", AddToCartStatus);

			}
			log.info("Remove item from cart");
			l1.getWebElement("Cart_removeLink", "ShopNav\\Minicart.properties").click();
		}
		
		sa.assertAll();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
