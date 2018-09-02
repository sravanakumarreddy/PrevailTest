package com.prevail.shopnav;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.pom.CategoryLandingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class RootCategory extends BaseTest
{
	@Test(groups="{Regression}",description="124286")
	public void TC01_RootCategory_UI() throws Exception
	{
		log.info("Navigate to Root category");
		String RootCatName=l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).getText();
		l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		Thread.sleep(2000);
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.RootCategory_ShopLinks),"Category links");
		//Root category header name
		sa.assertEquals(gVar.assertEqual("CLP_RefinementHeader", "ShopNav\\CategoryLanding.properties"), "Shop "+RootCatName);
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.RootCategory_Slots),"Category slots displayed");	
		sa.assertEquals(l1.getWebElements(CategoryLandingPOM.RootCategory_Slots).size(), 4);
		
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124287")
	public void TC02_RootCategory_ContentSlot_Navigation() throws Exception
	{
		log.info("Navigate to Root category");
		l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		Thread.sleep(2000);
		String ContentSlotName=l1.getWebElements(CategoryLandingPOM.RootCategory_Slots).get(1).getAttribute("title");
		log.info("Click on 1st content slot");
		l1.getWebElements(CategoryLandingPOM.RootCategory_Slots).get(1).click();
		Thread.sleep(3000);
		sa.assertEquals(gVar.assertEqual("CLP_Heading", "ShopNav\\CategoryLanding.properties"), ContentSlotName);
	
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124288/148574")
	public void TC03_Category_Navigation_UI() throws Exception
	{
		log.info("Navigate to Root category");
		l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		Thread.sleep(2000);
		List<WebElement> Links=l1.getWebElements(CategoryLandingPOM.RootCategory_ShopLinks);
		
		for(int i=0;i<Links.size();i++)
		{
			log.info("Click on Link: "+i);
			//String Categoryname=Links.get(i).getText();
			//System.out.println(Categoryname);
			//Links.get(i).click();
			String Categoryname=l1.getWebElements(CategoryLandingPOM.RootCategory_ShopLinks).get(i).getText();
			l1.getWebElements(CategoryLandingPOM.RootCategory_ShopLinks).get(i).click();
			Thread.sleep(3000);
			sa.assertEquals(gVar.assertEqual("CLP_Heading", "ShopNav\\CategoryLanding.properties"), Categoryname);
			log.info("Navigate to Root category");
			l1.getWebElement("Header_Logo","ShopNav\\HomePage.properties").click();
			l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
			Thread.sleep(2000);
			
			//It will return all the assertions
			sa.assertAll();
		}
	}
}