package com.prevail.projectspec;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.bcel.generic.BASTORE;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.prevail.pom.CategoryLandingPOM;
import com.prevail.pom.PDP_BundlePOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GlobalVariables;
import com.prevail.utilgeneric.Locators;

public class ShopnavFunctions extends BaseTest{

	public String CatName;
	public String RootCat;
	public String CatName1;
	public String RootCat1;
	public String SubCatName;
	public String PDP_Pname;
	public int pages;
	
public String NavigateToCategoryPage() throws Exception{
		
		RootCat=BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).getText();
		BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		CatName=BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(1).getText();
		BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		Thread.sleep(3000);
		
		return  CatName;
	}

public String NavigateToCategoryPage(int i) throws Exception{
	
	RootCat1=BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).getText();
	BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
	CatName1=BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(i).getText();
	BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(i).click();
	Thread.sleep(3000);
	
	return  CatName1;
}	

public String NavigateToSubcategory() throws Exception{
	RootCat=BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).getText();
	BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
	CatName=BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(1).getText();
	BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(1).click();
	SubCatName=BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(1).getText();
	BaseTest.l1.getWebElements("Subcategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
	Thread.sleep(5000);	
	
	return SubCatName;
}

public void NavigateToPDP() throws Exception{
	
	BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
	Thread.sleep(300);
	BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(1).click();
	BaseTest.l1.getWebElements("Subcategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
	//click on product Name to navigate to PDP
	String ProductName=BaseTest.l1.getWebElements("Category_NameLink","ShopNav\\CategoryLanding.properties").get(0).getText();
	System.out.println("ProductName"+ProductName);
	BaseTest.l1.getWebElements("Category_NameLink","ShopNav\\CategoryLanding.properties").get(0).click();
	
	}

public void SearchSuggestion(String product) throws Exception{
	
	BaseTest.l1.getWebElement("Search_TextBox","ShopNav\\SearchResults.properties").sendKeys(product);
	Thread.sleep(4000);
}

public void Search(String product) throws Exception{
	BaseTest.l1.getWebElement("Search_TextBox","ShopNav\\SearchResults.properties").click();
	//BaseTest.l1.getWebElement("Search_TextBox","ShopNav\\SearchResults.properties").clear();
	BaseTest.l1.getWebElement("Search_TextBox","ShopNav\\SearchResults.properties").sendKeys(product);
	Thread.sleep(4000);
	BaseTest.l1.getWebElement("Search_Find_Icon","ShopNav\\SearchResults.properties").click();
	Thread.sleep(4000);
}

public String SelectSwatch() throws Exception{
	

	
	try {
		if ((BaseTest.l1.getWebElement("pdp_Color_Label","ShopNav\\PDP.properties").isDisplayed())) {
			boolean ColorSwatchSelected=(BaseTest.l1.getWebElement("pdp_ColorSwatch_Selected","ShopNav\\PDP.properties")).isDisplayed();
			System.out.println(ColorSwatchSelected);
			if (ColorSwatchSelected==false)
			BaseTest.l1.getWebElements("Pdp_Color_swatch_Selectable","ShopNav\\PDP.properties").get(0).click();
			//p.PDP_Pcolor=BaseTest.l1.getWebElement("PDP_Product_Color", "ShopNav\\PDP.properties").getText();
		}
	} catch (Exception e) {
		BaseTest.log.info("Color swatch is not present");
	}
	
	Thread.sleep(2000);

	
	try {
		if (BaseTest.l1.getWebElement("pdp_Size_Label","ShopNav\\PDP.properties").isDisplayed()){
			Thread.sleep(3000);
			boolean SizeSwatchSelected=(BaseTest.l1.getWebElement("pdp_SizeSwatch_Selected","ShopNav\\PDP.properties")).isDisplayed();
			System.out.println(SizeSwatchSelected);
			log.info(SizeSwatchSelected+"Colorswatch");
			if (SizeSwatchSelected==false)
				log.info("Click on Size swatch");
				BaseTest.l1.getWebElements("Pdp_Size_Swatch_Selectable","ShopNav\\PDP.properties").get(0).click();
			Thread.sleep(3000);
			//p.PDP_Psize=BaseTest.l1.getWebElement("PDP_Product_Size", "ShopNav\\PDP.properties").getText();
		}
	} catch (Exception e) {
		BaseTest.log.info("PDP size is not present");
	}
	
try{
		
		if(BaseTest.l1.getWebElement("pdp_Width_Label","ShopNav\\PDP.properties").isDisplayed())
		{
			Thread.sleep(3000);
			boolean WidthSwatchSelected=(BaseTest.l1.getWebElement("pdp_WidthSwatch_Selected","ShopNav\\PDP.properties")).isDisplayed();
			System.out.println(WidthSwatchSelected);
			log.info(WidthSwatchSelected+"Widthswatch");
			if (WidthSwatchSelected==false)
				log.info("Click on Width swatch");
				BaseTest.l1.getWebElements("Pdp_Width_swatch_Selectable","ShopNav\\PDP.properties").get(0).click();
			Thread.sleep(3000);
			p.PDP_Psize=BaseTest.l1.getWebElement("PDP_Product_Width", "ShopNav\\PDP.properties").getText();
		}
		
	}
	catch(Exception e)
	{
		BaseTest.log.info("PDP Width is not present");

	}
	PDP_Pname=BaseTest.l1.getWebElement("PDP_Product_Name", "ShopNav\\PDP.properties").getText();
	Thread.sleep(3000);
		return PDP_Pname;
	}

public void AddtoCart() throws Exception{
	
	//Navigate to PDP
	NavigateToPDP();
	//Select Swatch
	SelectSwatch();
	BaseTest.log.info("PDP Add to cart button");
	BaseTest.l1.getWebElement("PDP_AddToCart","ShopNav\\PDP.properties").click();
		
	try {
		
		BaseTest.sa.assertTrue(gVar.assertVisible("PDP_bonus_product","ShopNav\\PDP.properties"),"PDP bonus product popup");
		BaseTest.l1.getWebElement("PDP_bonus_Nothanksbutton","ShopNav\\PDP.properties").click();
		
	} catch (Exception e) {
		
		BaseTest.log.info("POP up is not visible");
	}


}

public void Pagination() throws Exception{
	
	String Str1=l1.getWebElement("CLP_Pagination_Div", "ShopNav\\CategoryLanding.properties").getText();
	String Str2=l1.getWebElement("CLP_ResultsHit", "ShopNav\\CategoryLanding.properties").getText();
	
	if(Str1.equals(Str2))
		{
			System.out.println("Single page is displayed");		
		}
	else
		{
			if(l1.getWebElement("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties").isDisplayed() && l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
				{	
					BaseTest.sa.assertTrue(gVar.assertVisible("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties"), "CLP_Pagination_PageNext display");
					BaseTest.sa.assertTrue(gVar.assertVisible("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties"), "CLP_Pagination_PageNext display");
					BaseTest.sa.assertTrue(gVar.assertNotVisible("CLP_Pagination_Page_Previous", "ShopNav\\CategoryLanding.properties"),"Page Previous link should not display");
					BaseTest.sa.assertTrue(gVar.assertNotVisible("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties"),"Page First link should not display");
					
					if(l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
						{
						log.info("Click on Last page");
						l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").click();
						Thread.sleep(8000);
						}
					
					BaseTest.sa.assertTrue(gVar.assertVisible("CLP_Pagination_Page_Previous", "ShopNav\\CategoryLanding.properties"),"Page Previous link should not display");
					BaseTest.sa.assertTrue(gVar.assertVisible("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties"),"Page First link should not display");
					BaseTest.sa.assertTrue(gVar.assertNotVisible("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties"), "CLP_Pagination_PageNext display");
					BaseTest.sa.assertTrue(gVar.assertNotVisible("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties"), "CLP_Pagination_PageNext display");
					
					String pages= l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText();
					int Pages=Integer.parseInt(pages);
					if(l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").isDisplayed())
						{
						log.info("Click on First page");
						l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").click();
						Thread.sleep(8000);
						}				
					
					for(int j=1;j<=Pages;j++)
						{
							if(j==1)
								{
									log.info("Click on Page No: "+j);
									int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
						  	    	BaseTest.sa.assertEquals(curTop,j);
						  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
						  	    	BaseTest.sa.assertEquals(curBottom,j);
								}
							else if(j>1)
								{
									log.info("Click on Page No: "+j);
									l1.getWebElement("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties").click();
									Thread.sleep(8000);
									int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
									BaseTest.sa.assertEquals(curTop,j);
						  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
						  	    	BaseTest.sa.assertEquals(curBottom,j);					
								}				
						}
					for(int j=Pages;j>=1;j--)
						{
							if(j==Pages)
								{
								log.info("Page No: "+j);
								int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
								BaseTest.sa.assertEquals(curTop,j);
					  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
					  	    	BaseTest.sa.assertEquals(curBottom,j);
								}
							else if(j>1)
								{
								log.info("Click on Page No: "+j);
								l1.getWebElement("CLP_Pagination_Page_Previous", "ShopNav\\CategoryLanding.properties").click();
								Thread.sleep(8000);
								int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
								BaseTest.sa.assertEquals(curTop,j);
					  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
					  	    	BaseTest.sa.assertEquals(curBottom,j);
					  	    	
								}				
						}
					for(int j=1;j<=Pages;j++)
						{
							if(j==1)
								{
								log.info("Page No: "+j);
								int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
								BaseTest.sa.assertEquals(curTop,j);
					  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
					  	    	BaseTest.sa.assertEquals(curBottom,j);
								}
							else if(j>1)
								{
									log.info("Click on Page No: "+j);
									l1.getWebElements("CLP_Pagination_PageNo_Link", "ShopNav\\CategoryLanding.properties").get(j).click();
									Thread.sleep(8000);
									int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
									BaseTest.sa.assertEquals(curTop,j);
						  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
						  	    	BaseTest.sa.assertEquals(curBottom,j);							
								}				
						}
				 }
			else
				 {
					int pageDisp=l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties").size();
					for(int j=1;j<=pageDisp;j++)
						{
							if(j==1)
								{
								log.info("Page No: "+j);
								int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
								BaseTest.sa.assertEquals(j,curTop);
					  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
					  	    	BaseTest.sa.assertEquals(j,curBottom);
								}
							else
								{
								log.info("Click on Page No: "+j);
								l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties").get(j).click();
								Thread.sleep(5000);
								int curTop=l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText().length();
								BaseTest.sa.assertEquals(j,curTop);
					  	    	int curBottom= l1.getWebElement("CLP_Pagination_CurrentPageFooter", "ShopNav\\CategoryLanding.properties").getText().length();
					  	    	BaseTest.sa.assertEquals(j,curBottom);
					  	    	
								}				
						}				
				 }
			}
		}

	public void ItemsperPage(int itemsExpected) throws Exception
	{																															
		String[] pagination=l1.getWebElement("Category_PaginationHeading_Header", "ShopNav\\CategoryLanding.properties").getText().replace(" Results", "").split("of ");
		System.out.println("No of products displayed:|"+pagination[1]+"|");
		int ActTotalItems=Integer.parseInt(pagination[1]);
		int ExpTotalItems=0;
		int itemsDisplayed=0;
		
		String Str1=l1.getWebElement("CLP_Pagination_Div", "ShopNav\\CategoryLanding.properties").getText();
		String Str2=l1.getWebElement("CLP_ResultsHit", "ShopNav\\CategoryLanding.properties").getText();
		
		if(Str1.equals(Str2))
			{	
			itemsDisplayed=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();		
			System.out.println("Single page is displayed");	
			sa.assertEquals(itemsDisplayed, ActTotalItems,"Single Page is displayed");
			}
		else
			{
			if(l1.getWebElement("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties").isDisplayed() && l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
				{	
				
				if(l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
				{
				log.info("Click on Last page");
				l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").click();
				Thread.sleep(10000);
				}
				
				String Pages= l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText();
				int pages=Integer.parseInt(Pages);
				
				//	var $pages=_getText(_listItem("current-page"));
					
					if(l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").isDisplayed())
					{
					log.info("Click on First page");
					l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").click();
					Thread.sleep(10000);
					}	
					
					System.out.println("Total no of pages: "+pages);
					for(int j=1;j<=pages;j++)
						{	
							if(j==1)
								{
									itemsDisplayed=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();		
									log.info("Products displayed per page:"+itemsDisplayed);
									sa.assertEquals(itemsDisplayed, itemsExpected,"Single Page is displayed");
								}
							else if(j==pages)
								{
									log.info("Click on Page No: "+j);
									l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties").get(j).click();
									Thread.sleep(8000);
									itemsDisplayed=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();
									log.info("Products displayed per page: "+itemsDisplayed);
									int LastPageItems=ActTotalItems%itemsExpected;	
									sa.assertEquals(itemsDisplayed, LastPageItems);
								}
							else 
								{
									log.info("Click on Page No: "+j);
									l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties").get(j).click();
									Thread.sleep(8000);
									itemsDisplayed=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();
									log.info("Products displayed per page:"+itemsDisplayed);
									sa.assertEquals(itemsDisplayed, itemsExpected);
								}
							ExpTotalItems=ExpTotalItems+itemsDisplayed;
						}				
					}
				else
					{
					int pageDisp=l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties").size();
					
						for(int j=1;j<=pageDisp;j++)
						{
							if(j==1)
								{
								itemsDisplayed=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();
								log.info("Products displayed per page: "+itemsDisplayed);
								sa.assertEquals(itemsDisplayed, itemsExpected);
							}
						else if(j==pageDisp)
							{
								log.info("Click on Page No: "+j);
								l1.getWebElements("CLP_Pagination_PageNo_Link", "ShopNav\\CategoryLanding.properties").get(j).click();
								Thread.sleep(8000);
								itemsDisplayed=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();
								log.info("Products displayed per page: "+itemsDisplayed);
								int LastPageItems=ActTotalItems%itemsExpected;						
								sa.assertEquals(itemsDisplayed, LastPageItems);
							}
						else 
							{
								log.info("Click on Page No: "+j);
								l1.getWebElements("CLP_Pagination_PageNo_Link", "ShopNav\\CategoryLanding.properties").get(j).click();
								Thread.sleep(8000);
								itemsDisplayed=l1.getWebElements("CLP_ProductImage", "ShopNav\\CategoryLanding.properties").size();
								log.info("Products displayed per page: "+itemsDisplayed);
								sa.assertEquals(itemsDisplayed, itemsExpected);
							}
						ExpTotalItems=ExpTotalItems+itemsDisplayed;
					 }				
				}
			sa.assertEquals(ActTotalItems, ExpTotalItems);
		}
}


//Price filter
public void priceCheck(String Range) throws Exception{

	//$0 - $19.99
	String[] priceBounds = Range.replace("$", "").split("-");
	System.out.println("priceBounds:"+priceBounds[0].replace(" ", "")+"|"+priceBounds[1].replace(" ", "")+"|");
	//String priceBounds = _extract(_getText(Range), "/[$](.*) - [$](.*)/",true).toString().split(",");
	//int minPrice = Integer.parseInt(priceBounds[0].replace(" ", ""));
	//int maxPrice = Integer.parseInt(priceBounds[1].replace(" ", ""));
	
/*	try {
		priceBounds[0].replace(" ", "")
	} catch (Exception e) {
		// TODO: handle exception
	}*/
	String test1=priceBounds[0].replace(" ", "");
	String test2=priceBounds[1].replace(" ", "");
	log.info("came here");
	Float minPrice = new Float(test1);
	log.info("came here1");
	Float maxPrice = new Float(test2);
   
	log.info("minPrice = " + minPrice);
	log.info("maxPrice = " + maxPrice);
	String PLP_RESULTHITS_TOP=l1.getWebElement("CLP_ResultsHit","ShopNav\\CategoryLanding.properties").getText();
	String PLP_PAGINATION_TOP=l1.getWebElement("CLP_Pagination_Header","ShopNav\\CategoryLanding.properties").getText();

	if((PLP_RESULTHITS_TOP).equals(PLP_PAGINATION_TOP))
	
	{
		System.out.println("No pagination");
		List<WebElement> prices = l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
		for (int k=0; k<prices.size(); k++) 
			{
				String prodPrice=prices.get(k).getText();
//				if(prodPrice.contains("-")) {
//					
//				} else {
					//int price = Integer.parseInt(prodPrice.replace("$",""));				
					Float price = new Float(prodPrice.replace("$",""));
					log.info("$price = " + price);	
					if (price < minPrice && price > maxPrice) 
					{
						sa.assertFalse(true, "Price:" + price + " is lesser than min price:" + minPrice);
					} else {
						sa.assertFalse(true,"price is exceeded");
					}
				//}
			}		
	}
	else
	{

		//int pages;
		try {
			
			if(l1.getWebElement("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties").isDisplayed() && l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
			{
			System.out.println("Pagination displayed");
				if(l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
					{
					l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").click();
					}
				
				String Pages= l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText();
				 pages=Integer.parseInt(Pages);
			
				if(l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").isDisplayed())
					{
					l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").click();
					}
			}
		} catch (Exception e) {
			System.out.println("5 Pages");
			// TODO: handle exception
			pages=l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties").size();
		}

//		else
//			 {
//				pages=l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties").size();
//			 }
		
		for(int j=1;j<=pages;j++)
			{
				if(j!=1)
					{
					l1.getWebElement("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties").click();			
					}
				List<WebElement> prices = l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
				for (int k=0; k < prices.size(); k++) 
					{
//					if()
//					{
//						Contains("-")-----> for Range prices need to write code
//					}
//					else if()
//					{
//						
//					}
					//int price = Integer.parseInt(prices.get(k).getText().replace("$",""));
					Float price = new Float(prices.get(k).getText().replace("$",""));
						log.info("$price = " + price);				
						if (price < minPrice) 
						{
							sa.assertFalse(true, "Price " + price + " is lesser than min price " + minPrice);
						} 
						else if (price > maxPrice) 
						{
							sa.assertFalse(true, "Price " + price + " is greater than max price " + maxPrice);
						}					
					}
			}
	}
}

//--------Sort By function--------------
public void sortBy(String opt) throws Exception{
	
	/////////////////////
	log.info("Click on any color filter to make less product counts");
	l1.getWebElement("Temp", "ShopNav\\CategoryLanding.properties").click();
	Thread.sleep(8000);
	/////////////////////
	String Str1=l1.getWebElement("CLP_Pagination_Div", "ShopNav\\CategoryLanding.properties").getText();
	String Str2=l1.getWebElement("CLP_ResultsHit", "ShopNav\\CategoryLanding.properties").getText();
	
	List<WebElement> prodNames;
	ArrayList<String> prodNamesStrings=new ArrayList<>();
	if((opt).equals("Product Name Z - A") || (opt).equals("Product Name A - Z"))
	{
		//Fetch the Product names on 1st page load
		prodNames= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
	}
	else if((opt).equals("Price High to Low") || (opt).equals("Price Low To High"))
	{
		//Fetch the Product names on 1st page load
		prodNames= l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
	}
	log.info("To check Pagination for single page or multi-page");
	if((Str1).equals(Str2))
	{
		if((opt).equals("Product Name Z - A") || (opt).equals("Product Name A - Z"))
		{
			log.info("Single page is displayed");
			//Fetch the Product names on 1st page load
			prodNames= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
			for(WebElement ele:prodNames) {
				prodNamesStrings.add(ele.getText());
			}
		}
		else if((opt).equals("Price High to Low") || (opt).equals("Price Low To High"))
		{
			log.info("Single page is displayed");
			//Fetch the Product names on 1st page load
			prodNames= l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
			for(WebElement ele:prodNames) {
				prodNamesStrings.add(ele.getText());
			}
		}
		
		log.info("Checking for assertValues");
		assertValues(opt,prodNamesStrings);	
	}
	else
	{
		log.info("Multiple pages are displayed");
		int pages;
		if(l1.getWebElement("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties").isDisplayed() && l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
		{	
			
			if(l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").isDisplayed())
				{
				l1.getWebElement("CLP_Pagination_PageLast", "ShopNav\\CategoryLanding.properties").click();
				Thread.sleep(8000);
				}
			
			String Pages= l1.getWebElement("CLP_Pagination_CurrentPage", "ShopNav\\CategoryLanding.properties").getText();
			 pages=Integer.parseInt(Pages);
			
				if(l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").isDisplayed())
				{
				l1.getWebElement("CLP_Pagination_Page_First", "ShopNav\\CategoryLanding.properties").click();
				Thread.sleep(9000);
				}
				
				for(int i=1;i<=pages;i++)
					{
						if(i==1)
							{
							
							if((opt).equals("Product Name Z - A") || (opt).equals("Product Name A - Z"))
							{
								log.info("Single page is displayed");
								//Fetch the Product names on 1st page load
								prodNames= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
								for(WebElement ele:prodNames) {
									prodNamesStrings.add(ele.getText());
								}
							}
							else if((opt).equals("Price High to Low") || (opt).equals("Price Low To High"))
							{
								log.info("Single page is displayed");
								//Fetch the Product names on 1st page load
								prodNames= l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
								for(WebElement ele:prodNames) {
									prodNamesStrings.add(ele.getText());
								}
							}																
							}
						else if(i>1)
							{
								//_click(_link("page-"+$i));
								l1.getWebElement("CLP_Pagination_PageNext", "ShopNav\\CategoryLanding.properties").click();
								Thread.sleep(10000);
								
								if((opt).equals("Product Name Z - A") || (opt).equals("Product Name A - Z"))
								{
									log.info("Single page is displayed");
									//Fetch the Product names on 1st page load
									prodNames= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
									for(WebElement ele:prodNames) {
										prodNamesStrings.add(ele.getText());
									}
								}
								else if((opt).equals("Price High to Low") || (opt).equals("Price Low To High"))
								{
									log.info("Single page is displayed");
									//Fetch the Product names on 1st page load
									prodNames= l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
									for(WebElement ele:prodNames) {
										prodNamesStrings.add(ele.getText());
									}
								}																	
							}
					}
				assertValues(opt,prodNamesStrings);	
			}
		else
			{
			List<WebElement> pageDisp=l1.getWebElements("CLP_Pagination_PageNo_Display_Link", "ShopNav\\CategoryLanding.properties");

				for(int i=1;i<=pageDisp.size();i++)
					{
						if(i==1)
							{
							if((opt).equals("Product Name Z - A") || (opt).equals("Product Name A - Z"))
							{
								log.info("Single page is displayed");
								//Fetch the Product names on 1st page load
								prodNames= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
								for(WebElement ele:prodNames) {
									prodNamesStrings.add(ele.getText());
								}
							}
							else if((opt).equals("Price High to Low") || (opt).equals("Price Low To High"))
							{
								log.info("Single page is displayed");
								//Fetch the Product names on 1st page load
								prodNames= l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
								for(WebElement ele:prodNames) {
									prodNamesStrings.add(ele.getText());
								}
							}										
														
							}
						else
							{
							pageDisp.get(i).click();
							
							if((opt).equals("Product Name Z - A") || (opt).equals("Product Name A - Z"))
							{
								log.info("Single page is displayed");
								//Fetch the Product names on 1st page load
								prodNames= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
								for(WebElement ele:prodNames) {
									prodNamesStrings.add(ele.getText());
								}
							}
							else if((opt).equals("Price High to Low") || (opt).equals("Price Low To High"))
							{
								log.info("Single page is displayed");
								//Fetch the Product names on 1st page load
								prodNames= l1.getWebElements(CategoryLandingPOM.CLP_SalesPrice);
								for(WebElement ele:prodNames) {
									prodNamesStrings.add(ele.getText());
								}
							}
							
/*								prodNames= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
								for(WebElement ele:prodNames) 
								{
									prodNamesStrings.add(ele.getText());
								}*/											
																								
							}				
					}
				assertValues(opt,prodNamesStrings);	
			}
	}
}

public void assertValues(String opt,ArrayList<String> prodNamesStrings) throws Exception
{
	if((opt).equals("Product Name Z - A") || (opt).equals("Price High to Low"))
	{
		log.info(opt);
		Collections.sort(prodNamesStrings);
		Collections.reverse(prodNamesStrings);
	}
	else if((opt).equals("Product Name A - Z") || (opt).equals("Price Low To High"))
	{
		log.info(opt);
		Collections.sort(prodNamesStrings);
	}
	log.info("Click on Dropdown");
	gVar.handlingDropdown("Category_SortHeader","ShopNav\\CategoryLanding.properties", opt);
	Thread.sleep(8000);
	List<WebElement> prodNamesAfter= l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties");
	
	ArrayList<String> prodNamesDisplayed=new ArrayList<>();
	for(WebElement ele:prodNamesAfter) {
		prodNamesDisplayed.add(ele.getText());
	}
	System.out.println("prodNamesStrings after sorting: "+prodNamesStrings);
	System.out.println("prodNamesDisplayed in application: "+prodNamesDisplayed);
	sa.assertEquals(prodNamesDisplayed, prodNamesStrings);
	System.out.println("End");
	sa.assertAll();
}

public void NavigateToBundleProduct() throws Exception
{
	
	log.info("CLick on Electronics Category");
	act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(2)).perform();
	log.info("Click on Gaming Sub sub category");
	BaseTest.l1.getWebElement(PDP_BundlePOM.Bundle_SubCategory).click();
	BaseTest.l1.getWebElement(PDP_BundlePOM.Bundle_gamingConsoleFilter).click();
	log.info("Total Product count in CLP");
	int totalProdCount=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").size();
    BaseTest.l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(3).click();
	
}


public void NavigateToStandaredProduct() throws Exception
{
	
	log.info("Mouse Hover on Mens category");
	log.info("CLick on Electronics Category");
	act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(3)).perform();
	log.info("Click on suits sub sub category");
	BaseTest.l1.getWebElement("Category_SuitsSubCategoryText", "ShopNav\\CategoryLanding.properties").click();
	Thread.sleep(1000);
	int totalProdCount=l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").size();
	log.info("Product Count"+totalProdCount);
	log.info("Click on Product Name");
	BaseTest.l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(1).click();
}

public void NavigateToVariationSubCategory() throws Exception
{
	
		
		log.info("Mouse Hover on Mens category");
		log.info("CLick on Electronics Category");
		act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(3)).perform();
		log.info("Click on suits sub sub category");
		BaseTest.l1.getWebElement("Category_SuitsSubCategoryText", "ShopNav\\CategoryLanding.properties").click();
}


public void NavigateToSetProduct() throws Exception
{
	log.info("Mouse Hover on Mens category");
	log.info("CLick on Electronics Category");
	act.moveToElement(l1.getWebElements("Header_Category_Links", "ShopNav\\HomePage.properties").get(1)).perform();
	log.info("Click on outfites sub sub category");
	BaseTest.l1.getWebElement("Category_OutfitsCategoryText", "ShopNav\\CategoryLanding.properties").click();
	log.info("Click on Product Name");
	BaseTest.l1.getWebElements("CLP_ProductName", "ShopNav\\CategoryLanding.properties").get(1).click();
}

}

