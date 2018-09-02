package com.prevail.shopnav;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.pom.CategoryLandingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetDriver;

public class Compare extends BaseTest
{
	
	@Test(groups="{Regression}",description="125458/125459")
	public void TC01_Compare_UI() throws Exception
	{
		log.info("Navigate to category page");
		s.NavigateToCategoryPage();
		log.info("Add 2 items to compare");
		for(int i=0;i<2;i++)
		{
			l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
			Thread.sleep(1000);
		}
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare bucket Items");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.Compare_Items_Static_Text),"Compare up to 6 products static text");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.Compare_Item_Button),"Compare item button");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareClearButton),"Compare clear item button");
		sa.assertEquals(l1.getWebElements(CategoryLandingPOM.Compare_Widget_Boxes).size(),6,"Total 6 compare widget boxes");
		
		int CompareItems=l1.getWebElements(CategoryLandingPOM.Comapre_Active_Items).size();
		for(int i=0;i<CompareItems;i++)
		{
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.Compare_Items_RemoveLink, i),"Compare_Items_RemoveLink: "+i);
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.Compare_Items_Images, i),"Compare_Items_Images: "+i);

		}
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125462")
	public void TC02_Compare_Clear_Button_Functionality() throws Exception
	{
		log.info("Click on compare clear button");
		l1.getWebElement(CategoryLandingPOM.CLP_CompareClearButton).click();
		Thread.sleep(2000);
		
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare bucket Items");
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.Compare_Items_Static_Text),"Compare up to 6 products static text");
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.Compare_Item_Button),"Compare item button");
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.CLP_CompareClearButton),"Compare clear item button");
		
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="125458/125459")
	public void TC03_Compare_More_Than_6Items_Functionality() throws Exception
	{
		//add 6 items for compare
		for(int i=0;i<8;i++)
			{
				l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
				Thread.sleep(1000);
				
				if(i==6)
					{
						log.info("Click on cancel");
						Alert alert = GetDriver.driver.switchTo().alert();
						alert.dismiss();
						Thread.sleep(3000);
						//should remain in same page
						sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare bucket Items");
					}
				else if(i==7)
					{
						log.info("Click on Ok");
						Alert alert = GetDriver.driver.switchTo().alert();
						alert.accept();
						Thread.sleep(3000);
						//first item should replace 
						 sa.assertEquals(l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(0).getAttribute("checked"),null);
					}
			}
		log.info("Click on compare clear button");
		l1.getWebElement(CategoryLandingPOM.CLP_CompareClearButton).click();
		Thread.sleep(2000);
		
		
		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="125460")
	public void TC04_Compare_Items_RemoveLink_Functionlaity() throws Exception
	{
		log.info("Navigate to category page");
		s.NavigateToCategoryPage();
		log.info("Add 2 items to compare");
		for(int i=0;i<2;i++)
		{
			l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
			Thread.sleep(2000);
		}
		log.info("Click on compare clear button");
		l1.getWebElement(CategoryLandingPOM.CLP_CompareClearButton).click();
		Thread.sleep(2000);
		log.info("Remove 2 items from compare bucket");
		int CompareItems=l1.getWebElements(CategoryLandingPOM.Comapre_Active_Items).size();
		int temp=CompareItems-1;
		for(int i=0;i<CompareItems;i++)
		{
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.Comapre_Active_Items, i),"Comapre_Active_Item displayed : "+i);
			log.info("Click on Compare remove link");
			l1.getWebElements(CategoryLandingPOM.Compare_Items_RemoveLink).get(i).click();
			Thread.sleep(2000);
			sa.assertFalse(gVar.assertVisible(CategoryLandingPOM.Comapre_Active_Items, temp-i),"Comapre_Active_Item not displayed : "+i);
			//first item should replace 
			 sa.assertEquals(l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).getAttribute("checked"),null);
		}
		
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare bucket Items");
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.Compare_Items_Static_Text),"Compare up to 6 products static text");
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.Compare_Item_Button),"Compare item button");
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.CLP_CompareClearButton),"Compare clear item button");
		
		
		//It will return all the assertions
		sa.assertAll();
	}
		
	@Test(groups="{Regression}",description="125461/125464/125465/148597/287337")
	public void TC05_ComparePage_UI() throws Exception
	{
		log.info("Navigate to category page");
		s.NavigateToCategoryPage();
		
		log.info("Add 2 items to compare");
		for(int i=0; i<2; i++)
		{
			l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
			Thread.sleep(1000);		
		}
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare bucket Items");
		log.info("Fetch total active compare items");
		int CompareItems=l1.getWebElements(CategoryLandingPOM.Comapre_Active_Items).size();
		
		log.info("click on compare items button");
		l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		Thread.sleep(3000);
		log.info("Verify UI");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Heading),"Compare page Heading");
		//back to results links
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_BackToResults_link, 0),"ComparePage_BackToResults Top link");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_BackToResults_link, 1),"ComparePage_BackToResults Bottom link");
		System.out.println("============="+CompareItems);
		//remove,name,images links
		for(int i=0;i<CompareItems;i++)
			{
			System.out.println("Verify UI : "+i);
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Remove_link, i),"ComparePage_BackToResults Top link");
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Product_Image, i),"ComparePage_BackToResults Top link");
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Product_Name, i),"ComparePage_BackToResults Top link");
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Product_Price, i),"ComparePage_BackToResults Top link");
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Product_rating, i),"ComparePage_BackToResults Top link");
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_AddToCart_Button, i),"ComparePage_BackToResults Top link");
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_AddToWishlist_Button, i),"ComparePage_BackToResults Top link");
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_AddToGiftRegister_Button, i),"ComparePage_BackToResults Top link");
			}
		//Other compare items should not be visible
		sa.assertFalse(gVar.assertVisible(CategoryLandingPOM.ComparePage_Categorylist_Dropdown),"ComparePage_BackToResults Top link");
		sa.assertFalse(gVar.assertVisible(CategoryLandingPOM.ComparePage_OtherItems_StaticText),"ComparePage_BackToResults Top link");
				
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125467/287293")
	public void TC06_Compare_Products_Page_RemoveLink_Functionality() throws Exception
	{
		//products in compare page
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		int ProductInCompareBefore=ProductInCompare;
		int ExpectedProducts=0;
		for(int i=ProductInCompare-1;i>=0;i--)
			{
			System.out.println("=========="+i);
				if(i!=0)
					{
						//click on remove link
						log.info("Click on remove link");
						 ExpectedProducts=ProductInCompareBefore-1;
					}					
				else if(i==0 || ExpectedProducts==1)
					{
						//should navigate back to sub category
						sa.assertTrue(gVar.assertVisible("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties"),"Breadcrumb display");
						sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties", 1), s.SubCatName);
					}
				else
					{					
						Thread.sleep(5000);
						 ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
						sa.assertEquals(ProductInCompare, ExpectedProducts);
					
						ProductInCompareBefore=ProductInCompareBefore-1;
					}
			}
		//Should navigate back to PLP page
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare items bucket");
		sa.assertTrue(gVar.assertVisible("CLP_Page_Content", "ShopNav\\CategoryLanding.properties"),"Search result content");
		
		log.info("Clear all compare items");
		l1.getWebElement(CategoryLandingPOM.CLP_CompareClearButton).click();
		Thread.sleep(2000);
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125466")
	public void TC07_Compare_BackToResults_Link_Navigation() throws Exception
	{
		//navigate to subcat page	
		s.NavigateToCategoryPage();
		//add two items to items to compare
		log.info("Add 2 items to compare");
		for(int i=0;i<2;i++)
		{
			l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
			Thread.sleep(1000);		
		}
			
		//fetching page bread crumb
		String Pagebreadcrumb=l1.getWebElements("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties").get(1).getText();
		//click on compare items button
		log.info("click on compare items button");
		l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		Thread.sleep(3000);
		//click on back to results link
		log.info("Click on Back to results link");
		l1.getWebElements(CategoryLandingPOM.ComparePage_BackToResults_link).get(0).click();
		//verify the navigation back to PLP
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties", 1), Pagebreadcrumb);
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare items bucket");
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148590")
	public void TC08_ComparePage_QuickView_Functionality() throws Exception
	{
		//navigate to subcat page	
		s.NavigateToCategoryPage();
		log.info("Add 2 items to compare");
		for(int i=0;i<2;i++)
		{
			l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
			Thread.sleep(1000);		
		}
		//click on compare items button
		log.info("click on compare items button");
		l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		//verify the quick view functionality
		for(int i=0;i<ProductInCompare;i++)
			{			
				String ProductName=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Name).get(i).getText();
				act.moveToElement(l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).get(i)).perform();
				Thread.sleep(1000);
				//click on quick view overlay
				log.info("Click on Quickview button");
				l1.getWebElement(CategoryLandingPOM.ComparePage_QuickView_Button).click();
				Thread.sleep(4000);
				//verification
				//quickview overlay
				sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Quickview_Dialog),"Quickview dialog");
				//Product name
				sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Quickview_Dialog_Productname),"Quickview dialog Product name");
				sa.assertEquals(gVar.assertEqual(CategoryLandingPOM.ComparePage_Quickview_Dialog_Productname), ProductName);
				//close button
				sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Quickview_CloseButton),"Quickview close button display");
				//close the overlay
				log.info("Click on close button");
				l1.getWebElement(CategoryLandingPOM.ComparePage_Quickview_CloseButton).click();
				Thread.sleep(3000);
			}
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148591")
	public void TC09_ComparePage_ProductName_Image_Functionality() throws Exception
	{
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		for(int i=0;i<ProductInCompare;i++)
		{
			String ProductName=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Name).get(i).getText();
			//click on name link
			log.info("Click on Product name");
			l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Name).get(i).click();
			Thread.sleep(3000);
			
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PDP_ProductName_Breadcrumb", "ShopNav\\PDP.properties"), ProductName);			
			sa.assertTrue(gVar.assertVisible("PDP_ProductName", "ShopNav\\PDP.properties"),"PDP productname heading");
			sa.assertEquals(l1.getWebElement("PDP_ProductName", "ShopNav\\PDP.properties"), ProductName);
		
			//navigate to subcat page	
			s.NavigateToCategoryPage();	
			log.info("click on compare items button");
			l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
			
			//click on product image link			
			log.info("click on Product image");
			l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).get(i).click();
			Thread.sleep(3000);
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("PDP_ProductName_Breadcrumb", "ShopNav\\PDP.properties"), ProductName);
			sa.assertTrue(gVar.assertVisible("PDP_ProductName", "ShopNav\\PDP.properties"),"PDP productname heading");
			sa.assertEquals(l1.getWebElement("PDP_ProductName", "ShopNav\\PDP.properties"), ProductName);
			
			//navigate to subcat page	
			s.NavigateToCategoryPage();	
			//click on compare items button
			log.info("click on compare items button");
			l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		}
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148593")
	public void TC10_ComparePage_AddToCart_Functionality() throws Exception
	{
		//navigate to subcat page	
/*		s.NavigateToCategoryPage();
		//add two items to items to compare
		for(var $i=0;$i<2;$i++)
			{
				_check(_checkbox("compare-check["+$i+"]"));
			}
		//click on compare items button
		_click($COMPARE_ITEMS_BUTTON);*/
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		//verify the add to cart functionality
		for(int i=0;i<ProductInCompare;i++)
			{
				String ProductName=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Name).get(i).getText();
				log.info("Click on Add to Cart");
				l1.getWebElements(CategoryLandingPOM.ComparePage_AddToCart_Button).get(i).click();
				Thread.sleep(3000);
				//verify whether overlay opened or not 
				//quickview overlay
				sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Quickview_Dialog),"Quickview dialog");
				//Product name
				sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Quickview_Dialog_Productname),"Quickview dialog Product name");
				sa.assertEquals(gVar.assertEqual(CategoryLandingPOM.ComparePage_Quickview_Dialog_Productname), ProductName);
				//close button
				sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Quickview_CloseButton),"Quickview close button display");
				//close the overlay
				log.info("Click on close button");
				l1.getWebElement(CategoryLandingPOM.ComparePage_Quickview_CloseButton).click();
				Thread.sleep(3000);
			} 
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="148595")
	public void TC11_ComparePage_AddToWishlist_Functionality() throws Exception
	{
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		for(int i=0;i<ProductInCompare;i++)
		{	
			log.info("click on add to wish list link");
			l1.getWebElements(CategoryLandingPOM.ComparePage_AddToWishlist_Button).get(i).click();
			//verify the navigation
			sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement",  "ShopNav\\CategoryLanding.properties",1), "Wish List");
			sa.assertTrue(gVar.assertVisible("Login_Heading_Text", "ShopNav\\login.properties"));
			//navigate to subcat page	
			s.NavigateToCategoryPage();
			//click on compare items button
			log.info("click on compare items button");
			l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		}
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="287340")
	public void TC12_ComparePage_AddToGiftRegistry_Functionality() throws Exception
	{
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		for(int i=0;i<ProductInCompare;i++)
		{
		log.info("click on add to wish list link");
		l1.getWebElements(CategoryLandingPOM.ComparePage_AddToGiftRegister_Button).get(i).click();
		//verify the navigation
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement",  "ShopNav\\CategoryLanding.properties",1), "Gift Registry");
		sa.assertTrue(gVar.assertVisible("Login_GiftRegistry_Heading", "ShopNav\\login.properties"));
		//navigate to subcat page	
		s.NavigateToCategoryPage();
		//click on compare items button
		log.info("click on compare items button");
		l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		}
		
		//It will return all the assertions
		sa.assertAll();
	}
	@Test(groups="{Regression}",description="287338/148596")
	public void TC13_ComparePage_AddToGiftRegistry_Functionality() throws Exception
	{
		int ProductsCategory1=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		//navigate to subcat page	
		s.NavigateToCategoryPage(2);
		log.info("Add 2 items to compare");
		for(int i=0;i<2;i++)
		{
			l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
			Thread.sleep(1000);		
		}
		log.info("click on compare items button");
		l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		int ProductsCategory2=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		//'Other Compare Items'
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Product_Image),"Other items static text");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.ComparePage_Categorylist_Dropdown),"Category list dropdown");
		//select the category1 from drop down
		gVar.handlingDropdown(CategoryLandingPOM.ComparePage_Categorylist_Dropdown,s.CatName);
		int Category1ProductsDisplayed=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		sa.assertEquals(Category1ProductsDisplayed, ProductsCategory1);
		gVar.handlingDropdown(CategoryLandingPOM.ComparePage_Categorylist_Dropdown,s.CatName1);	
		int Category2ProductsDisplayed=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		sa.assertEquals(Category2ProductsDisplayed, ProductsCategory2);
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}")
	public void TC14_Clear_Compared_Products(XmlTest XmlTest) throws Exception
	{
		s.NavigateToCategoryPage();
		log.info("Click on compare clear button");
		l1.getWebElement(CategoryLandingPOM.CLP_CompareClearButton).click();
		Thread.sleep(2000);
		//compare section shouln't visible
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare bucket Items");		
		s.NavigateToCategoryPage(2);
		log.info("Click on compare clear button");
		l1.getWebElement(CategoryLandingPOM.CLP_CompareClearButton).click();
		Thread.sleep(2000);
		//compare section shouln't visible
		sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.CLP_CompareItems_Div),"Compare bucket Items");	
	
		log.info("login to the application");
		p.loginToAppliction(xmlTest);
		//navigate to wish list and delete all added items 
		log.info("Clear wishlist");
		p.clearWishList();
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}", description="148594")
	public void TC15_Compare_Reg_AddToWishlist_Functionality() throws Exception
	{
		//navigate to subcat page	
		s.NavigateToCategoryPage();
		log.info("Add 2 items to compare");
		for(int i=0;i<2;i++)
		{
			l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(i).click();
			Thread.sleep(1000);		
		}
		log.info("click on compare items button");
		l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		Thread.sleep(2000);
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		for(int i=0;i<ProductInCompare;i++)
			{	
				String ProductName=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Name).get(i).getText();
				log.info("click on add to wish list link");
				l1.getWebElements(CategoryLandingPOM.ComparePage_AddToWishlist_Button).get(i).click();
				Thread.sleep(3000);
				//verification
				String WishlistPname=l1.getWebElement("Wishlist_ProductName_Link", "Profile\\Wishlist.properties").getText();
				sa.assertEquals(WishlistPname, ProductName);
				log.info("Remove product from wish list");
				l1.getWebElement("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties").click();
				//navigate to subcat page	
				s.NavigateToCategoryPage();
				//click on compare items button
				log.info("click on compare items button");
				l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
			}
	}
	
	@Test(groups="{Regression}", description="287339")
	public void TC16_Compare_Reg_AddToGiftRegistry_Functionality() throws Exception
	{
		//navigate to subcat page	
		s.NavigateToCategoryPage();
		//click on compare items button
		log.info("click on compare items button");
		l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
		int ProductInCompare=l1.getWebElements(CategoryLandingPOM.ComparePage_Product_Image).size();
		for(int i=0;i<ProductInCompare;i++)
			{	
			log.info("click on add to wish list link");
			l1.getWebElements(CategoryLandingPOM.ComparePage_AddToGiftRegister_Button).get(i).click();
			Thread.sleep(3000);
			//verify the navigation
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.GiftRegistry_Heading),"Gift Registry Heading");
			//navigate to subcat page	
			s.NavigateToCategoryPage();;
			log.info("click on compare items button");
			l1.getWebElement(CategoryLandingPOM.Compare_Item_Button).click();
			Thread.sleep(2000);
			}
	}
	
}
