package com.prevail.shopnav;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class HomePage extends BaseTest
{

	@Test(groups="{Regression}",description="124682")
	public void TC00_HomePage_CategoryNavigation() throws Exception
	{
		
		int CategoryLinks=l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").size();
		for(i=0; i<CategoryLinks; i++)
		{
			log.info("click on category links");
			l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(i).click();
			log.info("category link navigation heading verification");
			if(i==0 || i<=3)
			{
				sa.assertTrue(gVar.assertVisible("Category_Refinement_Header", "ShopNav\\CategoryLanding.properties"),"Category refinement headers");
                sa.assertEquals(gVar.assertEqual("Category_Refinement_Header", "ShopNav\\CategoryLanding.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", i+1, 2));
			}
			
			else if(i==4)
			{
                sa.assertEquals(gVar.assertEqual("Category_Refinement_Header", "ShopNav\\CategoryLanding.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 6, 2));

			}
		}
		sa.assertAll();
		
		
	}
	
	@Test(groups="{Regression}",description="124683")
	public void TC01_HomePage_SubCategoryNavigation() throws Exception
	{
		
		log.info("Mouse hover on womens category");
		act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(1)).perform();
		log.info("Click on Sub category");
		l1.getWebElement("Header_Jewellary_SubCategory", "ShopNav\\HomePage.properties").click();
		log.info("BreadCrumb verification");
		sa.assertEquals(gVar.assertEqual("Login_Breadcrumb", "Profile\\login.properties"), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 3));
		sa.assertAll();
		
	}
	
	
	@Test(groups="{Regression}",description="124680")
	public void TC02_HomePage_UIonmousehoverofrootcategories() throws Exception
	{
		log.info("click on category links");
		int CategoryLinks=l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").size();
		log.info("Mouse hover on each of the root categories");
		
		for(i=0; i<CategoryLinks; i++)
		{
			act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(i)).perform();
			log.info("Category flyout verifications");
			sa.assertTrue(gVar.assertVisible("Header_Category_Links", "ShopNav\\HomePage.properties", i));
		}
	}
		
		
		@Test(groups="{Regression}",description="124684")
		public void TC03_HomePage_HomePageSlideNavigation() throws Exception
		{
			log.info("click on Logo of the application");
			l1.getWebElement("Header_Logo", "ShopNav\\HomePage.properties").click();
			log.info("Click on Homepage slides");
			l1.getWebElement("HomePage_Slides", "ShopNav\\HomePage.properties").click();
			log.info("verify the slide navigation page verification");
			sa.assertTrue(gVar.assertVisible("Login_Breadcrumb", "Profile\\login.properties"),GetData.getDataFromExcel("//data//ShopNavData.xls","Header",2, 3));
			sa.assertAll();
			
		}
		
		
		@Test(groups="{Regression}",description="124684")
		public void TC04_HomePage_UI() throws Exception
		{
			log.info("click on Logo of the application");
			l1.getWebElement("Header_Logo", "ShopNav\\HomePage.properties").click();
			log.info("UI of HomePage");
			sa.assertTrue(gVar.assertVisible("Header_Category_Links", "ShopNav\\HomePage.properties"),"Category list");
			sa.assertTrue(gVar.assertVisible("HomePage_SliderImage", "ShopNav\\HomePage.properties"),"HomePage Slider Images");
			sa.assertTrue(gVar.assertVisible("HomePage_promotionalSlot1", "ShopNav\\HomePage.properties"),"Promotional slot1");
			sa.assertTrue(gVar.assertVisible("HomePage_promotionalSlot2", "ShopNav\\HomePage.properties"),"Promotional slot2");
			sa.assertTrue(gVar.assertVisible("HomePage_promotionalSlot3", "ShopNav\\HomePage.properties"),"Promotional slot3");
			sa.assertTrue(gVar.assertVisible("Footer_Section", "ShopNav\\HomePage.properties"),"Footer scetion");
			sa.assertAll();
		}
		
		
		
}
		
	
	
	
	
	

