package com.prevail.shopnav;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import com.prevail.pom.CategoryLandingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class Search extends BaseTest{
	
	@Test(groups="{Regression}",description="128434/128435/124688/128280")
	public void TC01_SearchSuggestionPage_UI() throws Exception
	{
		log.info("Search");
		s.SearchSuggestion(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "SearchSuggestion_Keyword"));
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_Div", "ShopNav\\SearchResults.properties"),"Serach suggestion overlay");
		//Right panel
		log.info("Product image");
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_OtherPopularSearch_Text", "ShopNav\\SearchResults.properties"),"SearchSuggestion_OtherPopularSearch_Text");
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_ProductImage", "ShopNav\\SearchResults.properties"),"Product image display");
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_ProductName", "ShopNav\\SearchResults.properties"),"Product name display");
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_ProductPrice", "ShopNav\\SearchResults.properties"),"Product price display");
		//Left panel
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_Looking_For_These_Brand", "ShopNav\\SearchResults.properties"),"SearchSuggestion_Looking_For_These_Brand");
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_Pages_Might_Be_Interesting", "ShopNav\\SearchResults.properties"),"SearchSuggestion_Pages_Might_Be_Interesting");
		sa.assertTrue(gVar.assertVisible("SearchSuggestion_Category_Text", "ShopNav\\SearchResults.properties"),"SearchSuggestion_Category_Text");
		sa.assertEquals(gVar.assertEqual("SearchSuggestion_MatchingPhrase", "ShopNav\\SearchResults.properties"), GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "SearchSuggestion_Keyword"));
	
		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="128509")
	public void TC02_SearchSuggestionPage_CategoryLink_Navigation() throws Exception
	{
		log.info("Click on Category link");
		l1.getWebElement("SearchSuggestion_CategoryLink", "ShopNav\\SearchResults.properties").click();
		Thread.sleep(3000);
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement", "ShopNav\\SearchResults.properties", 2),"Ties");
		log.info("Click on Logo");
		l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="128510")
	public void TC03_SearchSuggestion_Brand_Link_And_Suggested_StaticPages() throws Exception
	{
		log.info("Search");
		s.SearchSuggestion(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "SearchSuggestion_Keyword1"));
		log.info("Click under Suggested Brands");
		String BrandName=l1.getWebElement("SearchSuggestion_Looking_For_Brand_Link", "ShopNav\\SearchResults.properties").getText();
		l1.getWebElement("SearchSuggestion_Looking_For_Brand_Link", "ShopNav\\SearchResults.properties").click();
		Thread.sleep(3000);
		sa.assertEquals(gVar.assertEqual("SearchSuggestion_BreadcrumbText", "ShopNav\\SearchResults.properties"), BrandName);
		log.info("Click on Logo");
		l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();
		
		log.info("Search");
		s.SearchSuggestion(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "SearchSuggestion_Keyword"));
		String StaticPageName=l1.getWebElement("SearchSuggestion_Static_Page_link", "ShopNav\\SearchResults.properties").getText();
		log.info("Click on Other suggested Static pages");
		l1.getWebElement("SearchSuggestion_Static_Page_link", "ShopNav\\SearchResults.properties").click();
		Thread.sleep(3000);
		sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties"), StaticPageName);
		log.info("Click on Logo");
		l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="128281")
	public void TC04_SearchSuggestion_OtherPopularSearch_link() throws Exception
	{
		log.info("Search");
		s.SearchSuggestion(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "SearchSuggestion_Shi"));
		String Name=l1.getWebElement("SearchSuggestion_OtherPopularSearch_link", "ShopNav\\SearchResults.properties").getText();
		log.info("click on link");
		l1.getWebElement("SearchSuggestion_OtherPopularSearch_link", "ShopNav\\SearchResults.properties").click();
		Thread.sleep(3000);
		sa.assertEquals(gVar.assertEqual("SearchSuggestion_BreadcrumbText", "ShopNav\\SearchResults.properties"), Name);

		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="128283/128511")
	public void TC05_SearchSuggestionPage_ProductName_Image_Navigation() throws Exception
	{
		log.info("Search");
		s.SearchSuggestion(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "SearchSuggestion_Keyword"));
		String Pname=l1.getWebElements("SearchSuggestion_ProductName", "ShopNav\\SearchResults.properties").get(0).getText();
		String Price=l1.getWebElements("SearchSuggestion_ProductPrice", "ShopNav\\SearchResults.properties").get(0).getText();
		for(int j=0;j<2;j++)
		{
			if(i==0)
			{
				log.info("Click on Product Image");			
				l1.getWebElements("SearchSuggestion_ProductImage", "ShopNav\\SearchResults.properties").get(0).click();
			}
			else
			{
				log.info("Click on Product name");			
				l1.getWebElements("SearchSuggestion_ProductName", "ShopNav\\SearchResults.properties").get(0).click();
			}
			Thread.sleep(4000);
			sa.assertEquals(gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"),Pname );
			sa.assertEquals(gVar.assertEqual("PDP_Product_Price", "ShopNav\\PDP.properties"),Price );

			log.info("Click on Logo");
			l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();

			//It will return all the assertions
			sa.assertAll();
		}
	}

	
	@Test(groups="{Regression}",description="124686/125409/125410")
	public void TC04_SearchResultPage_Navigation() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		//Breadcrumb 
		sa.assertTrue(gVar.assertVisible("SearchResult_Breadcrumb_Element", "ShopNav\\SearchResults.properties"),"Search Result Breadcrumb");
		//Your Search Results for <Keyword> as a title
		sa.assertEquals(gVar.assertEqual("SearchResult_Breadcrum_Title", "ShopNav\\SearchResults.properties"), "tops");
		//Left Nav Refine column
		sa.assertTrue(gVar.assertVisible("CLP_Refine_Div", "ShopNav\\CategoryLanding.properties"),"LeftNav Refine coloumn");
		//Refinement Header
		sa.assertTrue(gVar.assertVisible("CLP_RefinementHeader", "ShopNav\\CategoryLanding.properties"),"Refinement Header");
		//Category
		sa.assertTrue(gVar.assertVisible("CLP_Category_Refinement", "ShopNav\\CategoryLanding.properties"),"Category Refinement");
		//Color
		sa.assertTrue(gVar.assertVisible("CLP_Color_Refinement", "ShopNav\\CategoryLanding.properties"),"Color Refinement");
		//Price
		sa.assertTrue(gVar.assertVisible("CLP_Price_Refinement", "ShopNav\\CategoryLanding.properties"),"Price Refinement");
		//Top Pagination
		sa.assertTrue(gVar.assertVisible("CLP_Pagination", "ShopNav\\CategoryLanding.properties", 0),"Header Pagination");
		//Bottom Pagination
		sa.assertTrue(gVar.assertVisible("CLP_Pagination", "ShopNav\\CategoryLanding.properties", 1),"Footer Pagination");
		sa.assertEquals(gVar.assertEqual("CLP_ProductRow", "ShopNav\\CategoryLanding.properties"), 4);
		int Pcount=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();
		for(int j=0;j<Pcount;j++)
		{
			log.info("Loop: "+j);
			//Product image
			sa.assertTrue(gVar.assertVisible("CLP_ProductImage", "ShopNav\\CategoryLanding.properties", j),"Product Image"+j);
			//Product name
			sa.assertTrue(gVar.assertVisible("CLP_ProductName", "ShopNav\\CategoryLanding.properties", j),"Product Name"+j);
			//Price (Format : $XXX.XX)
			sa.assertTrue(gVar.assertVisible("CLP_ProductPrice", "ShopNav\\CategoryLanding.properties", j),"Product Price"+j);
			//Product ratings
			sa.assertTrue(gVar.assertVisible("CLP_ProductRating", "ShopNav\\CategoryLanding.properties", j),"Product Rating"+j);
			//Product color option (IF ANY)
			try 
			{
				sa.assertTrue(gVar.assertVisible("CLP_Product_SwatchColor", "ShopNav\\SearchResults.properties", j),"Product Color"+j);
			}
			catch (Exception e) 
			{
				System.out.println("No color displayed for product: "+j);
				// TODO: handle exception
			}
		}
		log.info("Click on Keyword title");
		l1.getWebElement("SearchResult_Breadcrum_Title", "ShopNav\\SearchResults.properties").click();
		//Breadcrumb 
		sa.assertTrue(gVar.assertVisible("SearchResult_Breadcrumb_Element", "ShopNav\\SearchResults.properties"),"Search Result Breadcrumb");
		//Your Search Results for <Keyword> as a title
		sa.assertEquals(gVar.assertEqual("SearchResult_Breadcrum_Title", "ShopNav\\SearchResults.properties"), "tops");

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125415")
	public void TC05_SearchResultPage_Keyword_Click() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(3000);
		int LeftNavFilter=l1.getWebElements("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties").size();
		for(int j=0;j<LeftNavFilter;j++)
		{
			//Filter Headings
			sa.assertTrue(gVar.assertVisible("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties", j),"Category Heading");
			log.info("Display Block Displayed");
			sa.assertTrue(gVar.assertVisible("CLP_LeftNav_DisplayBlock", "ShopNav\\CategoryLanding.properties", 0),"Display block: "+j);
			l1.getWebElement("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties").click();
			Thread.sleep(2000);
			log.info("Display Block Hidden");
			sa.assertTrue(gVar.assertVisible("CLP_LeftNav_DisplayNone", "ShopNav\\CategoryLanding.properties", j),"Display block: "+j);

			//It will return all the assertions
			sa.assertAll();
		}

		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="125416")
	public void TC06_SearchResult_LeftNAV_Category_Section_Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(4000);
		
		int LeftNavCategory=l1.getWebElements("CLP_Category_Filter", "ShopNav\\CategoryLanding.properties").size();
		for(int j=0;j<LeftNavCategory;j++)
		{
			String CatName=l1.getWebElements("CLP_Category_Filter", "ShopNav\\CategoryLanding.properties").get(j).getText();
			log.info("Click on Left Nav filter: "+ CatName);
			l1.getWebElements("CLP_Category_Filter", "ShopNav\\CategoryLanding.properties").get(j).click();
			Thread.sleep(5000);
			
			//Breadcrumb 
			sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties"), CatName);
			//Search result page
			sa.assertTrue(gVar.assertVisible("CLP_Page_Content", "ShopNav\\CategoryLanding.properties"),"Search result content");
			Thread.sleep(2000);
			log.info("Search");
			s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
			Thread.sleep(4000);
		}

		//It will return all the assertions
		sa.assertAll();
	}
		
	@Test(groups="{Regression}",description="125412/125425")
	public void TC07_SearchResult_Page_Display_Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(3000);
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
	
	@Test(groups="{Regression}",description="125417")
	public void TC08_SearchResult_LeftNav_ColorFilter_Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(6000);
		List<WebElement> UnselectableSwatch=l1.getWebElements("CLP_Unselectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
		System.out.println("UnselectableSwatch: "+UnselectableSwatch);
		List<WebElement> SelectableSwatch=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
		System.out.println("SelectableSwatch: "+SelectableSwatch.get(0).getText());
		List<WebElement> SwatchColor=l1.getWebElements("CLP_Color_Swatches","ShopNav\\CategoryLanding.properties");
		int Swatches=l1.getWebElements("CLP_Color_Swatches","ShopNav\\CategoryLanding.properties").size();
		//System.out.println(Swatches.get(0).getText());
		
			//for(int k=0; k<Swatches; k++)
				for(int k=0; k<SelectableSwatch.size(); k++)
			{
//				if(UnselectableSwatch.indexOf(SwatchColor.get(k))>=0)
//					{
//					System.out.println("Swatch is unselectable: "+UnselectableSwatch.get(k) );	
//					//_assert(true, "Swatch is unselectable");
//					}
//				else
//					{
						log.info("Click on selectable swatch");
						//System.out.println("Swatch is unselectable: "+SelectableSwatch.get(k) );	
						String Color=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(k).getText();	
						l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(k).click();				    //clear link
						Thread.sleep(10000);
						sa.assertTrue(gVar.assertVisible("CLP_Color_Refinement_Clear_link", "ShopNav\\CategoryLanding.properties"));
						
						sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Color+" x");
						sa.assertTrue(gVar.assertVisible("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties"));
						log.info("Click on close icon");
						l1.getWebElement("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties").click();
						Thread.sleep(6000);
				//	}  
			}

				//It will return all the assertions
				sa.assertAll();
	}

	@Test(groups="{Regression}",description="125418")
	public void TC09_SearchResult_LeftNav_MultiFilter_Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(6000);
		
		List<WebElement> Filters=l1.getWebElements("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties");
		
		//var $FilterNames=_collectAttributes("_heading3","/toggle/","sahiText",_in($PLP_REFINEMENT));
		System.out.println(Filters.get(0).getText());
		List<String> ExpectedApplied=new ArrayList<>();
			
		for(int j=0;j<Filters.size() ;j++)
		{
			log.info("Loop: "+j+Filters.get(j).getText());
			//String FilterName=Filters.get(j).getText();
			//if(l1.getWebElements("CLP_LeftNav_Filter", "ShopNav\\CategoryLanding.properties").get(j).isDisplayed())
						
			if(Filters.get(j).getText().equals("CATEGORY"))
			{
				log.info("LoopCategory: "+j);
				List<WebElement> CategoryFilterNames=l1.getWebElements("CLP_Category_Filter","ShopNav\\CategoryLanding.properties");
				//CategoryFilterNames.get(0).click();
				l1.getWebElements("CLP_Category_Filter","ShopNav\\CategoryLanding.properties").get(0).click();
				Thread.sleep(3000);
				String AppliedBreadcrumb=l1.getWebElement("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties").getText();
				sa.assertEquals(CategoryFilterNames.get(0).getText(), AppliedBreadcrumb);
			}
			else if(Filters.get(j).getText().equals("COLOR"))
				{
					List<WebElement> ColorFilterNames=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties");
					//ColorFilterNames.get(0).click();
					l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(3000);
					//loading text of each element in to array all_elements_text
					ExpectedApplied.add(ColorFilterNames.get(0).getText()+" x");
					
				}
				else if(Filters.get(j).getText().equals("PRICE"))
				{
					List<WebElement> PriceFilterNames=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties");
					//PriceFilterNames.get(0).click();
					l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties").get(0).click();
					Thread.sleep(3000);
					//loading text of each element in to array all_elements_text
					ExpectedApplied.add(PriceFilterNames.get(0).getText()+" x");
				}
		    
		}
		String ActualApplied=l1.getWebElement("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties").getText();
		
		sa.assertEquals(ExpectedApplied, ActualApplied, "Filter Applied Verification");

		log.info("Click on Logo");
		l1.getWebElement("HomePage_Logo", "Profile\\login.properties").click();

		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="125418")
	public void TC10_SearchResult_LeftNav_MultiFilter_Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(6000);
		
		List<String> ExpectedApplied=new ArrayList<>();
		int SelectableSwatch=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").size();
		int Pricelinks=l1.getWebElements("CLP_Price_Refinement_link","ShopNav\\CategoryLanding.properties").size();
		
		if(l1.getWebElement("CLP_Color_Refinement", "ShopNav\\CategoryLanding.properties").isDisplayed())
		{
			log.info("Color Multi filter");
			for(int k=0; k<3; k++)
			{
			String Color=l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(k).getText();	
			l1.getWebElements("CLP_Selectable_Color_Refinement","ShopNav\\CategoryLanding.properties").get(k).click();
			Thread.sleep(10000);		
			//loading text of each element in to array all_elements_text
			ExpectedApplied.add(Color+" x");
			System.out.println("Fetching color:"+k);
			}
			String ActualApplied=l1.getWebElement("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties").getText();
			sa.assertEquals(ExpectedApplied, ActualApplied, "Filter Applied Verification");
			log.info("click on clear link");
			l1.getWebElement("CLP_Color_Refinement_Clear_link", "ShopNav\\CategoryLanding.properties").click();
			System.out.println("Done with Color");
			Thread.sleep(5000);
		}

		 if(l1.getWebElement("CLP_Price_Refinement", "ShopNav\\CategoryLanding.properties").isDisplayed())
		{
			log.info("Price Multi filter");
			for(int k=0; k<3; k++)
			{
			String Price=l1.getWebElements("CLP_Price_Refinement_link","ShopNav\\CategoryLanding.properties").get(k).getText();	
			l1.getWebElements("CLP_Price_Refinement_link","ShopNav\\CategoryLanding.properties").get(k).click();
			Thread.sleep(10000);		
			//loading text of each element in to array all_elements_text
			ExpectedApplied.add(Price+" x");
			}
			String ActualApplied=l1.getWebElement("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties").getText();
			sa.assertEquals(ExpectedApplied, ActualApplied, "Filter Applied Verification");
			log.info("click on clear link");
			l1.getWebElement("CLP_Price_Refinement_Clear_Link", "ShopNav\\CategoryLanding.properties").click();			
			System.out.println("Done with Price");
		}	

			//It will return all the assertions
			sa.assertAll();
	}

	@Test(groups="{Regression}",description="125422")
	public void TC10_SearchResult_ProductName_Image_Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(3000);
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
			//Product Name
			sa.assertEquals(gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"), Pname);
			//Product Price
			sa.assertEquals(gVar.assertEqual("PDP_Product_Price", "ShopNav\\PDP.properties"), price);
			log.info("Search");
			s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
			Thread.sleep(3000);
		}

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="124687/125424/125429")
	public void TC11_SearchNoResult__Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "InvailKeyword"));
		Thread.sleep(3000);
		//Search result title
		sa.assertTrue(gVar.assertVisible("SearchResult_Page_Title", "ShopNav\\SearchResults.properties"),"SearchResult_Page_Title display");
		//No search result text
		sa.assertEquals(gVar.assertEqual("NoSearchResult_Page_Text", "ShopNav\\SearchResults.properties"), "We're sorry, no products were found for your search: "+GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "InvailKeyword"));
		//Left Nav category
		sa.assertTrue(gVar.assertVisible("NoSearchResult_Page_LeftnavCategory",  "ShopNav\\SearchResults.properties"),"NoSearchResult_Page_LeftnavCategory display");
		//LeftNav Refine Search
		sa.assertTrue(gVar.assertVisible("NoSearchResult_Page_RefineSearchTitle",  "ShopNav\\SearchResults.properties"),"NoSearchResult_Page_RefineSearchTitle display");
		//Try New search
		sa.assertTrue(gVar.assertVisible("NoSearchResult_Page_TryNewSearch",  "ShopNav\\SearchResults.properties"),"NoSearchResult_Page_TryNewSearch display");
		//Try new search textbox
		sa.assertTrue(gVar.assertVisible("NoSearchResult_TryNewSearch_Textbox",  "ShopNav\\SearchResults.properties"),"NoSearchResult_TryNewSearch_Textbox display");
		//Go Button
		sa.assertTrue(gVar.assertVisible("NoSearchResult_Go_Button",  "ShopNav\\SearchResults.properties"),"NoSearchResult_Go_Button display");

		int LeftNavCategory=l1.getWebElements("NosearchResult_LeftNavCategory", "ShopNav\\CategoryLanding.properties").size();
		for(int j=0;j<LeftNavCategory;j++)
		{
			log.info("Loop: "+j);
			String CatName=l1.getWebElements("NosearchResult_LeftNavCategory", "ShopNav\\CategoryLanding.properties").get(j).getText();
			log.info("Click on Left Nav Category: "+ CatName);
			l1.getWebElements("CLP_Category_Filter", "ShopNav\\CategoryLanding.properties").get(j).click();
			Thread.sleep(5000);
			//Breadcrumb 
			sa.assertEquals(gVar.assertEqual("CLP_BreadcrumElement", "ShopNav\\CategoryLanding.properties"), CatName);
			//Search result page
			sa.assertTrue(gVar.assertVisible("CLP_Page_Content", "ShopNav\\CategoryLanding.properties"),"Search result content");
			sa.assertEquals(gVar.assertEqual("SearchResult_RefinmementHeader", "ShopNav\\CategoryLanding.properties"), "Shop "+CatName);
			log.info("Search");
			s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "InvailKeyword"));
			Thread.sleep(4000);
		}
	}
	
	@Test(groups="{Regression}",description="125427")
	public void TC12_Try_New_Search_InValidKeyword() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "InvailKeyword"));
		Thread.sleep(3000);
		log.info("Enter invalid keyword");
		l1.getWebElement("NoSearchResult_TryNewSearch_Textbox",  "ShopNav\\SearchResults.properties").sendKeys("Selenium");
		log.info("Click on Go button");
		l1.getWebElement("NoSearchResult_Go_Button",  "ShopNav\\SearchResults.properties").click();
		Thread.sleep(3000);
		//Search result title
		sa.assertTrue(gVar.assertVisible("SearchResult_Page_Title", "ShopNav\\SearchResults.properties"),"SearchResult_Page_Title display");
		//No search result text
		sa.assertEquals(gVar.assertEqual("NoSearchResult_Page_Text", "ShopNav\\SearchResults.properties"), "We're sorry, no products were found for your search: Selenium");

		//It will return all the assertions
		sa.assertAll();
	}

	@Test(groups="{Regression}",description="125426")
	public void TC13_Try_New_Search_ValidKeyword() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "InvailKeyword"));
		Thread.sleep(3000);
		log.info("Enter invalid keyword");
		l1.getWebElement("NoSearchResult_TryNewSearch_Textbox",  "ShopNav\\SearchResults.properties").sendKeys(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		log.info("Click on Go button");
		l1.getWebElement("NoSearchResult_Go_Button",  "ShopNav\\SearchResults.properties").click();
		Thread.sleep(3000);
		//Breadcrumb 
		sa.assertTrue(gVar.assertVisible("SearchResult_Breadcrumb_Element", "ShopNav\\SearchResults.properties"),"Search Result Breadcrumb");
		//Your Search Results for <Keyword> as a title
		sa.assertEquals(gVar.assertEqual("SearchResult_Breadcrum_Title", "ShopNav\\SearchResults.properties"), "tops");

		//It will return all the assertions
		sa.assertAll();
	}
	
	@Test(groups="{Regression}",description="125426")
	public void TC14_SearchResultPage_QuivkView__Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(3000);
		String Pname=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(0).getText();
		log.info("Before Mouse hover of 1st product in Search result page");
		sa.assertTrue(gVar.assertNotVisible("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties"));
		log.info("After Mouse hover of 1st product in Search result page");
		sa.assertTrue(gVar.assertVisible("CLP_QuickView_Button", "ShopNav\\CategoryLanding.properties"));
		gVar.MouseHover("CLP_ProductImage", "ShopNav\\CategoryLanding.properties");
		Thread.sleep(1000);
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
	
	
	@Test(groups="{Regression}",description="212404")
	public void TC15_SearchResultPage_LeftNav_Filter_MouseHover() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(3000);
		
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
	
	@Test(groups="{Regression}",description="125419")
	public void TC06_CLP_LeftNav_PriceFilter_Functionality() throws Exception
	{
		log.info("Search");
		s.Search(GetData.getDataFromProperties("\\POM\\ShopNav\\SearchResults.properties", "Keyword"));
		Thread.sleep(3000);
		
		List<WebElement> PriceFilterNames=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties");
				
		for(int k=0; k<PriceFilterNames.size(); k++)
		{		
			List<WebElement> PriceFilterNames1=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties");
			String Price=l1.getWebElements("CLP_LeftNav_Price_Refinement","ShopNav\\CategoryLanding.properties").get(k).getText();												
			log.info("Click on Price link: "+k);	
			PriceFilterNames1.get(k).click();
			Thread.sleep(8000);
			sa.assertTrue(gVar.assertVisible("CLP_Price_Refinement_Clear_Link", "ShopNav\\CategoryLanding.properties"),"Clear link displayed for Price filter");		
			sa.assertEquals(gVar.assertEqual("CLP_Breadcrumb_Refinement_Value", "ShopNav\\CategoryLanding.properties"),Price+" x");
			log.info("Price Verification: "+Price);
			s.priceCheck(Price);
			log.info("Click on close icon");
			l1.getWebElement("CLP_Breadcrumb_Close_Icon", "ShopNav\\CategoryLanding.properties").click();
			Thread.sleep(6000); 
		}

		//It will return all the assertions
		sa.assertAll();
	}
	
/*	@Test(groups="{Regression}",description="")
	public void TC07_SearchSuggestionPage_Navigation() throws Exception
	{
		
	}
	*/
}