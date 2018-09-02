package com.prevail.shopnav;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.prevail.pom.CategoryLandingPOM;
import com.prevail.projectspec.ProfileFunctions;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class SubCategoryPage extends BaseTest {
	


	@Test(groups="{Regression}",description="287586/125646/125648")
	public void TC01_Category_Navigation_UI() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		System.out.println("Category: "+s.CatName);
		sa.assertTrue(gVar.assertVisible("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties"),"Breadcrumb visible");
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties", 2), s.SubCatName);
		sa.assertEquals(gVar.assertEqual("CLP_Heading","ShopNav\\CategoryLanding.properties", 1), s.CatName);
		sa.assertTrue(gVar.assertVisible("CLP_Refine_Div", "ShopNav\\CategoryLanding.properties"),"Refinement div");
		sa.assertTrue(gVar.assertVisible("CLP_BannerSlot",  "ShopNav\\CategoryLanding.properties"),"Hero slot");
		
		sa.assertTrue(gVar.assertVisible("Category_SortHeader", "ShopNav\\CategoryLanding.properties"),"Category_SortHeader");
		sa.assertTrue(gVar.assertVisible("Category_SortFooter", "ShopNav\\CategoryLanding.properties"),"Category_SortFooter");
		sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Header", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Header");
		sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Footer", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Footer");
		
		sa.assertTrue(gVar.assertVisible("CLP_Pagination_Header", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Header");
		sa.assertTrue(gVar.assertVisible("CLP_Pagination_Footer", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Footer");
		sa.assertTrue(gVar.assertVisible("CLP_Page_Content","ShopNav\\CategoryLanding.properties"),"Search content");
		
		int Pcount=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").size();
		for(int j=0;j<Pcount;j++)
		{
			log.info("Loop: "+j);
			//Product image
			sa.assertTrue(gVar.assertVisible("CLP_ProductImage", "ShopNav\\CategoryLanding.properties", j),"Product Image"+j);
			//Product name
			sa.assertTrue(gVar.assertVisible("CLP_ProductName", "ShopNav\\CategoryLanding.properties", j),"Product Name"+j);
			//Price 
			sa.assertTrue(gVar.assertVisible("CLP_ProductPrice", "ShopNav\\CategoryLanding.properties", j),"Product Price"+j);
			//Product ratings
			sa.assertTrue(gVar.assertVisible("CLP_ProductRating", "ShopNav\\CategoryLanding.properties", j),"Product Rating"+j);
			//Compare checkbox
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_Compare_Checkbox, j), "Compare checkbox"+j);
			//Product color option (IF ANY)
			try 
			{
				sa.assertTrue(l1.getWebElements("CLP_Product_SwatchColor", "ShopNav\\SearchResults.properties").get(j).isDisplayed(),"Product Color"+j);
			}
			catch (Exception e) 
			{
				System.out.println("No color displayed for product: "+j);
				// TODO: handle exception
			}	
	  }

		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="125634")
	public void TC02_Breadcrumb_Functionality() throws Exception
	{
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties", 0), s.RootCat);
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties", 1), s.CatName);
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties", 2), s.SubCatName);
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties","href", 2),null,"SubCatname should not be a link");
		
		log.info("Click on Category Breadcrumb");
		l1.getWebElements("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties").get(1).click();
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties", 0), s.RootCat);
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties","href", 1),null, "Catname breadcrumb should not be a link");
		sa.assertFalse(gVar.assertVisible("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties",2),"SubCatname breadcrumb should not be displayed");
		
		log.info("Click on Root Category Breadcrumb");
		l1.getWebElements("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties").get(0).click();
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties", 0), s.RootCat);
		sa.assertFalse(gVar.assertVisible("CLP_BreadcrumElement","ShopNav\\CategoryLanding.properties", 1),"Catname breadcrumb should not be displayed");
		
		//No Home link is displayed in Breadcrumb

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125637")
	public void TC03_CLP_Breadcrumb_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();

		//the display of category name
		sa.assertTrue(gVar.assertVisible("CLP_Expanded_FilterView", "ShopNav\\CategoryLanding.properties"),"Sub-CLP_Expanded_FilterView display");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_Refinement_Active_Link),"SubCategory refinement active link");
		sa.assertEquals(gVar.assertEqual(CategoryLandingPOM.CLP_Refinement_Active_Link), s.SubCatName);
		
		log.info("Click on Category links");
		int SubCategories=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SubCategory_Link).size();
		
		log.info("CLick on the Subcategory link");
		for(int j=0;j<SubCategories;j++)
			{
			log.info("Click on the Subcategory link:"+j);
			String SubCatName=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SubCategory_Link).get(j).getText();
			l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SubCategory_Link).get(j).click();
			Thread.sleep(3000);
			sa.assertEquals(gVar.assertEqual("CLP_Heading", "ShopNav\\CategoryLanding.properties"), SubCatName);
			sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties", 2), SubCatName);
			log.info("Click on SubCategory Page");
			s.NavigateToSubcategory();
			}

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125649")
	public void TC04_CLP_List_GridView_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		log.info("Click on Wide tile icon");
		l1.getWebElement("CLP_WideTile_Icon", "ShopNav\\CategoryLanding.properties").click();
		Thread.sleep(1000);
		sa.assertTrue(gVar.assertVisible("CLP_WideTile_PageDisplay", "ShopNav\\CategoryLanding.properties"),"WideTile_PageDisplay");
		log.info("Click on Coloumn/Grid tile icon");
		l1.getWebElement("CLP_ColumnTile_Icon", "ShopNav\\CategoryLanding.properties").click();
		Thread.sleep(1000);
		sa.assertTrue(gVar.assertVisible("CLP_ColumnTile_PageDisplay", "ShopNav\\CategoryLanding.properties"),"ColumnTile_PageDisplay");	

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125640")
	public void TC05_CLP_LeftNav_ColorFilter_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		List<WebElement> UnselectableSwatch=l1.getWebElements("CLP_Unselectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
		//System.out.println("UnselectableSwatch: "+UnselectableSwatch);
		List<WebElement> SelectableSwatch=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
		//System.out.println("SelectableSwatch: "+SelectableSwatch.get(0).getText());
	
				for(int i=0; i<UnselectableSwatch.size(); i++)
				{
						System.out.println("UnSelectable Swatch: "+i+" "+UnselectableSwatch.get(i).getText());
				}
				
				for(int k=0; k<SelectableSwatch.size(); k++)
				{
					List<WebElement> SelectableSwatch1=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
						log.info("Click on selectable swatch");
						System.out.println("Selectable Swatch: "+SelectableSwatch1.get(k).getText());
						String Color=SelectableSwatch1.get(k).getText();
						System.out.println(Color);
						//l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(k).click();		
						SelectableSwatch1.get(k).click();
						//clear link
						Thread.sleep(10000);
						sa.assertTrue(gVar.assertVisible("CLP_Color_Refinement_Clear_link", "ShopNav\\CategoryLanding.properties"));
						
						sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Color+" x");
						sa.assertTrue(gVar.assertVisible("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties"));
						sa.assertTrue(gVar.assertVisible("CLP_Refine_Div", "ShopNav\\CategoryLanding.properties"),"Refinement div");
						sa.assertTrue(gVar.assertVisible("CLP_BannerSlot",  "ShopNav\\CategoryLanding.properties"),"Hero slot");
						sa.assertTrue(gVar.assertVisible("Category_SortHeader", "ShopNav\\CategoryLanding.properties"),"Category_SortHeader");
						sa.assertTrue(gVar.assertVisible("Category_SortFooter", "ShopNav\\CategoryLanding.properties"),"Category_SortFooter");
						sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Header", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Header");
						sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Footer", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Footer");
						sa.assertTrue(gVar.assertVisible("CLP_Pagination_Header", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Header");
						sa.assertTrue(gVar.assertVisible("CLP_Pagination_Footer", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Footer");
						sa.assertTrue(gVar.assertVisible("CLP_Page_Content","ShopNav\\CategoryLanding.properties"),"Search content");
						
						log.info("Click on close icon");
						l1.getWebElement("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties").click();
						Thread.sleep(8000); 
			}

				//It will return all the assertions
				sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125643")
	public void TC06_CLP_LeftNav_PriceFilter_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		List<WebElement> PriceFilterNames=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties");
		
		for(int k=0; k<PriceFilterNames.size(); k++)
		{		
			List<WebElement> PriceFilterNames1=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties");
			String Price=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties").get(k).getText();
			log.info("Click on Price link: "+k);	
			PriceFilterNames1.get(k).click();
			Thread.sleep(8000);
			sa.assertTrue(gVar.assertVisible("CLP_Price_Refinement_Clear_Link", "ShopNav\\CategoryLanding.properties"));		
			sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Price+" x");
			//Need to make function for price checking
			log.info("Price Verification: "+Price);
			s.priceCheck(Price);				
			log.info("Click on close icon");
			l1.getWebElement("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties").click();
			Thread.sleep(6000); 
		}

		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="125641")
	public void TC07_CLP_LeftNav_SizeFilter_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		List<WebElement> SizeFilterNames=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SizeRefinement);
		
		for(int k=0; k<SizeFilterNames.size(); k++)
		{		
			log.info("================loop: "+k+"=========================");
			List<WebElement> SizeFilterNames1=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SizeRefinement);
			String Size=SizeFilterNames1.get(k).getText();
			SizeFilterNames1.get(k).click();
			Thread.sleep(8000);
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_SizeRefinement_ClearLink),"Size refinement clear link");		
			sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Size+" x");

			sa.assertTrue(gVar.assertVisible("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties"));
			sa.assertTrue(gVar.assertVisible("CLP_Refine_Div", "ShopNav\\CategoryLanding.properties"),"Refinement div");
			sa.assertTrue(gVar.assertVisible("CLP_BannerSlot",  "ShopNav\\CategoryLanding.properties"),"Hero slot");
			sa.assertTrue(gVar.assertVisible("Category_SortHeader", "ShopNav\\CategoryLanding.properties"),"Category_SortHeader");
			sa.assertTrue(gVar.assertVisible("Category_SortFooter", "ShopNav\\CategoryLanding.properties"),"Category_SortFooter");
			sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Header", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Header");
			sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Footer", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Footer");
			sa.assertTrue(gVar.assertVisible("CLP_Pagination_Header", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Header");
			sa.assertTrue(gVar.assertVisible("CLP_Pagination_Footer", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Footer");
			sa.assertTrue(gVar.assertVisible("CLP_Page_Content","ShopNav\\CategoryLanding.properties"),"Search content");
			
			log.info("Click on close icon");
			l1.getWebElement("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties").click();
			Thread.sleep(8000); 
		}

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="287633")
	public void TC08_CLP_LeftNav_FilterNames_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		
		List<WebElement> LeftNavFilter=l1.getWebElements("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties");
		for(int j=0;j<LeftNavFilter.size();j++)
		{
			//Filter Headings
			sa.assertTrue(gVar.assertVisible("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties", j),"Category Heading");
			log.info("Display Block Displayed");
			sa.assertTrue(gVar.assertVisible("CLP_LeftNav_DisplayBlock", "ShopNav\\CategoryLanding.properties", 0),"Display block: "+j);
			LeftNavFilter.get(j).click();
			Thread.sleep(2000);
			log.info("Display Block Hidden");
			sa.assertTrue(gVar.assertVisible("CLP_LeftNav_DisplayNone", "ShopNav\\CategoryLanding.properties", j),"Hidden block: "+j);
		}

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="287634")
	public void TC09_CLP_Selected_Filter_Click_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		Thread.sleep(5000);
		List<WebElement> Filters=l1.getWebElements("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties");
		System.out.println("|"+Filters.get(0).getText()+"|");
		System.out.println("|"+Filters.get(1).getText()+"|");
		System.out.println("|"+Filters.get(2).getText()+"|");

			
		for(int j=0;j<Filters.size();j++)
		{
			log.info("Loop: "+j+Filters.get(j).getText());
			//String FilterName=Filters.get(j).getText();
			//if(l1.getWebElements("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties").get(j).isDisplayed())
						
			if(Filters.get(j).getText().equals("COLOR"))
				{
					//List<WebElement> ColorFilterNames=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
					//ColorFilterNames.get(0).click();
					log.info("Click on Select the color filter");
					l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(8000);
					String Color=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(0).getText();
					sa.assertTrue(gVar.assertVisible("CLP_Color_Refinement_Clear_link", "ShopNav\\CategoryLanding.properties"),"Color refinement clear link");		
					sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Color+" x");
					log.info("Click to unselect the color filter");
					l1.getWebElements("CLP_Selected_Color_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(8000);
					sa.assertTrue(gVar.assertNotVisible("CLP_Price_Refinement_Clear_Link", "ShopNav\\CategoryLanding.properties"),"Price refinement clear link");		
					sa.assertTrue(gVar.assertNotVisible("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),"Breadcrumb should not be visible");			

				}
			
				else if(Filters.get(j).getText().equals("PRICE"))
				{
					//List<WebElement> PriceFilterNames=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties");
					//PriceFilterNames.get(0).click();
					log.info("Click on Select the Price filter");
					l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(7000);
					String Price=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(0).getText();
					sa.assertTrue(gVar.assertVisible("CLP_Price_Refinement_Clear_Link", "ShopNav\\CategoryLanding.properties"),"Price refinement clear link");		
					sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Price+" x");
					log.info("Click to unselect the Price filter");
					l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(7000);
					sa.assertTrue(gVar.assertNotVisible("CLP_Price_Refinement_Clear_Link", "ShopNav\\CategoryLanding.properties"),"Price refinement clear link");		
					sa.assertTrue(gVar.assertNotVisible("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),"Breadcrumb should not be visible");

				} 
			
				else if(Filters.get(j).getText().equals("SIZE"))
				{
					//List<WebElement> SizeFilterNames=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SizeRefinement);
					//SizeFilterNames.get(0).click();
					log.info("Click on Select the SIZE filter");
					l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SizeRefinement).get(0).click();
					Thread.sleep(7000);
					String Size=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SizeRefinement).get(0).getText();
					sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_SizeRefinement_ClearLink),"Size refinement clear link");		
					sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Size+" x");
					log.info("Click to unselect the Size filter");
					l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_SizeRefinement).get(0).click();
					Thread.sleep(7000);
					sa.assertTrue(gVar.assertNotVisible(CategoryLandingPOM.CLP_SizeRefinement_ClearLink),"Price refinement clear link");		
					sa.assertTrue(gVar.assertNotVisible("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),"Breadcrumb should not be visible");
				}
		}

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125638")
	public void TC10_SearchResult_LeftNav_MultiFilter_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		Thread.sleep(6000);
		
		List<WebElement> Filters=l1.getWebElements("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties");
		
		System.out.println(Filters.get(0).getText());
		List<String> ExpectedApplied=new ArrayList<>();
			
		for(int j=0;j<Filters.size() ;j++)
		{
			log.info("Loop: "+j+Filters.get(j).getText());
						
			 if(Filters.get(j).getText().equals("COLOR"))
				{
					List<WebElement> ColorFilterNames=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
					log.info("Click on Select the Color filter");
					ColorFilterNames.get(0).click();
					//l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(7000);
					//loading text of each element in to array all_elements_text
					ExpectedApplied.add(ColorFilterNames.get(0).getText()+" x");
					
				}
			 
				else if(Filters.get(j).getText().equals("PRICE"))
				{
					List<WebElement> PriceFilterNames=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties");
					log.info("Click on Select the Price filter");
					PriceFilterNames.get(0).click();
					//l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(3000);
					//loading text of each element in to array all_elements_text
					ExpectedApplied.add(PriceFilterNames.get(0).getText()+" x");
				}
			
				else if(Filters.get(j).getText().equals("SIZE"))
				{
					List<WebElement> SizeFilterNames=l1.getWebElements("CLP_LeftNav_SizeRefinement","ShopNav\\CategoryLanding.properties");
					log.info("Click on Select the SIZE filter");
					SizeFilterNames.get(0).click();
					//l1.getWebElements("CLP_LeftNav_SizeRefinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(3000);
					ExpectedApplied.add(SizeFilterNames.get(0).getText()+" x");
				}
		    
		}
		String ActualApplied=l1.getWebElement("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties").getText();
		
		sa.assertEquals(ExpectedApplied, ActualApplied, "Filter Applied Verification");

		log.info("Click on Logo");
		l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();
		Thread.sleep(3000);
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="287632")
	public void TC11_CLP_Products_Link_Click_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		Thread.sleep(8000);
		String Pname=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(0).getText();
		String price=l1.getWebElements("CLP_ProductPrice", "ShopNav\\CategoryLanding.properties").get(0).getText();
		for(int j=0;j<2;j++)
		{
			if(j==0)
			{
				log.info("Mouse hover of 1st product in Search result page");
				gVar.MouseHover("CLP_ProductImage", "ShopNav\\CategoryLanding.properties");
				Thread.sleep(1000);
				sa.assertTrue(gVar.assertVisible("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties"));
				log.info("Click on Product image");
				l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").get(0).click();
			}
			else
			{
				log.info("Click on Product name");
				l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(0).click();
			}
			Thread.sleep(8000);
			//Product Name
			sa.assertEquals(gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"), Pname);
			//Product Price
			sa.assertEquals(gVar.assertEqual("PDP_Product_Price", "ShopNav\\PDP.properties"), price);
			log.info("Click on Category Page");
			s.NavigateToSubcategory();
			Thread.sleep(4000);
		}
		log.info("Click on Compare checkbox");
		l1.getWebElements(CategoryLandingPOM.CLP_Compare_Checkbox).get(0).click();
		Thread.sleep(2000);
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareItems_Div),"CompareItems Div displayed");
		sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_CompareItemsDiv_ActiveProduct),"1st product displayed in Compare div");
		log.info("Click on compare clear button");
		l1.getWebElement(CategoryLandingPOM.CLP_CompareClearButton).click();
		Thread.sleep(2000);
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125644")
	public void TC12_CLP_Pagination() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		Thread.sleep(3000);
		log.info("Pagination Functionality");
		s.Pagination();

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="320009")
	public void TC13_CLP_QuickView_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		Thread.sleep(3000);
		
		String Pname=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(0).getText();
		log.info("Before Mouse hover of 1st product in Search result page");
		sa.assertTrue(gVar.assertNotVisible("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties"));
		log.info("After Mouse hover of 1st product in Search result page");
		gVar.MouseHover("CLP_ProductImage", "ShopNav\\CategoryLanding.properties");
		Thread.sleep(1000);
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties"));
		log.info("Click on quick view button");
		l1.getWebElement("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties").click();
		Thread.sleep(6000);
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialop displayed");
		sa.assertEquals(gVar.assertEqual("CLP_QuickView_Dialog_ProductName", "ShopNav\\CategoryLanding.properties"), Pname);
		log.info("Close quick view dialog");
		l1.getWebElement("CLP_QuickView_Close", "ShopNav\\CategoryLanding.properties").click();
		sa.assertTrue(gVar.assertNotVisible("CLP_QuickView_Dialog", "ShopNav\\CategoryLanding.properties"),"Quick view dialop displayed");

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125641")
	public void TC14_CLP_LeftNav_TypeFilter_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		List<WebElement> TypeFilterNames=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_TypeRefinement);
		
		for(int k=0; k<TypeFilterNames.size(); k++)
		{		
			String Size=TypeFilterNames.get(k).getText();
			TypeFilterNames.get(k).click();
			Thread.sleep(8000);
			sa.assertTrue(gVar.assertVisible(CategoryLandingPOM.CLP_LeftNav_TypeRefinement),"Size refinement clear link");		
			sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Size+" x");

			sa.assertTrue(gVar.assertVisible("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties"));
			sa.assertTrue(gVar.assertVisible("CLP_Refine_Div", "ShopNav\\CategoryLanding.properties"),"Refinement div");
			sa.assertTrue(gVar.assertVisible("CLP_BannerSlot",  "ShopNav\\CategoryLanding.properties"),"Hero slot");
			sa.assertTrue(gVar.assertVisible("Category_SortHeader", "ShopNav\\CategoryLanding.properties"),"Category_SortHeader");
			sa.assertTrue(gVar.assertVisible("Category_SortFooter", "ShopNav\\CategoryLanding.properties"),"Category_SortFooter");
			sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Header", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Header");
			sa.assertTrue(gVar.assertVisible("Category_ItemsPerPageDropdown_Footer", "ShopNav\\CategoryLanding.properties"),"Category_ItemsPerPageDropdown_Footer");
			sa.assertTrue(gVar.assertVisible("CLP_Pagination_Header", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Header");
			sa.assertTrue(gVar.assertVisible("CLP_Pagination_Footer", "ShopNav\\CategoryLanding.properties"),"CLP_Pagination_Footer");
			sa.assertTrue(gVar.assertVisible("CLP_Page_Content","ShopNav\\CategoryLanding.properties"),"Search content");
			
			log.info("Click on close icon");
			l1.getWebElement("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties").click();
			Thread.sleep(8000); 
		}

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125641")
	public void TC15_CLP_LeftNav_Filter_MouseHover() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		
		List<WebElement> Links=l1.getWebElements(CategoryLandingPOM.CLP_LeftNav_Link_Tile);
		
		for(int i=0;i<Links.size();i++)
		{
			gVar.MouseHover("CLP_LeftNav_link_Title", "ShopNav\\CategoryLanding.properties");
			Thread.sleep(1000);
			System.out.println("Filter name: "+Links.get(i).getText());
			sa.assertTrue(true, Links.get(i).getAttribute("title"));
		}
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="287635")
	public void TC16_CLP_SortBy_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToSubcategory();
		
		if(l1.getWebElement("Category_SortHeader","ShopNav\\CategoryLanding.properties").isDisplayed() && l1.getWebElement("Category_SortFooter","ShopNav\\CategoryLanding.properties").isDisplayed())
		{
			List<WebElement> sort=l1.getWebElements(CategoryLandingPOM.CLP_SortBy_Options);
			int j=0;
			for(int i=1;i<sort.size();i++)
			{
				log.info("Select options from dropdown: "+j);
				gVar.handlingDropdown("Category_SortHeader","ShopNav\\CategoryLanding.properties", sort.get(i).getText());
				//Validating the selection
				sa.assertEquals(l1.getWebElement(CategoryLandingPOM.CLP_SortBy_Top_SelectedValue).getText(), sort.get(i).getText());
				sa.assertEquals(l1.getWebElement(CategoryLandingPOM.CLP_SortBy_Bottom_SelectedValue).getText(), sort.get(i).getText());
			
				String Sort1=sort.get(i).getText();
						
				if(Sort1.indexOf(GetData.getDataFromExcel("\\data\\ShopNavData.xls", "SortBy", j, 0))>-1)
				{
					log.info("Select options from dropdown: "+j);
					s.sortBy(GetData.getDataFromExcel("\\data\\ShopNavData.xls", "SortBy", j, 0));
					j++;
				}
			}
		}
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124417")
	public void TC17_CLP_SortBy_Functionality() throws Exception
	{
		log.info("Click on Category Page");
		s.NavigateToCategoryPage();
		String sortoption="Product Name A - Z";
		s.sortBy(sortoption);
		//It will return all the assertions
		sa.assertAll();
	}

}
