package com.prevail.shopnav;

import java.lang.reflect.Executable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.pom.PDP_BundlePOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class PDP_StandaredProduct extends BaseTest
{
	
/*	@Test(groups="{Regression}",description="124737")
	public void TC00_PDPStandared_SelectSize() throws Exception
	{
		
		s.NavigateToStandaredProduct();
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
		
		sa.assertAll();
}
	
		@Test(groups="{Regression}",description="124736")
	public void TC00_PDPStandared_SelectColor() throws Exception
	{
		
		s.NavigateToStandaredProduct();

		int Colors=l1.getWebElements("pdp_ColorSwatch_Selected", "ShopNav\\PDP.properties").size();
		System.out.println(Colors);
		if(Colors==1)
		{
			System.out.println("came Here"+Colors);
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
          sa.assertAll();
	}
	
	
	*/
	
	@Test(groups="{Regression}",description="124749")
	public void TC00_PDPStandared_AddToCart() throws Exception
	{
		s.NavigateToStandaredProduct();
		log.info("fetrching product name in PDP");
		String ProdNameInPDP=l1.getWebElement("PDP_Product_Name", "ShopNav\\PDP.properties").getText();
		System.out.println("Didplaying product name in PDP"+ProdNameInPDP);
		log.info("Select the swatches if available");
		s.SelectSwatch();
		log.info("Click on add to cart");
		l1.getWebElement("PDP_AddToCart", "ShopNav\\PDP.properties").click();
		log.info("CLick on view cart link in the Minicart");
		l1.getWebElement("MiniCart_ViewCart", "ShopNav\\Minicart.properties").click();
		sa.assertEquals(ProdNameInPDP, gVar.assertEqual(PDP_BundlePOM.Bundle_CartProdName));
		
		
	}
	
	@Test(groups="{Regression}",description="124753")
	public void TC00_PDPStandared_AddToCartButtonState() throws Exception
	{
		s.NavigateToStandaredProduct();
		log.info("Add to cart button State");
		if(l1.getWebElement("PDP_AddToCart", "ShopNav\\PDP.properties").getAttribute("disabled").equals("disabled"))
		{
			System.out.println("Add to cart button is disabled");
		}
		
	    s.SelectSwatch();
		log.info("Add to cart button Enabled State");

	    l1.getWebElement("PDP_AddToCart", "ShopNav\\PDP.properties").isEnabled();
		
	}
	
	
	@Test(groups="{Regression}",description=" 124731,287921")
	public void TC05_PDPStandared_UI() throws Exception
	{
	   sa.assertTrue(gVar.assertVisible("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties"),"PDP BreadCrumb Element verification");
	   sa.assertTrue(gVar.assertVisible("PDP_Product_Name", "ShopNav\\PDP.properties"),"Product name");	
	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ProductNumber),"Product Number");
	   try
	   {
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_StrikeoutPrice),"Strike out price");
  
	   }
	   catch(Exception e)
	   {
		   System.out.println("No Srtike out price is displaying");
	   }
	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_ActualPrice),"Actual Price of the product");
	   sa.assertTrue(gVar.assertVisible("pdp_Color_Label", "ShopNav\\PDP.properties"),"Select color label");
	   sa.assertTrue(gVar.assertVisible("pdp_Color_Swatches", "ShopNav\\PDP.properties"),"Colour swatches section");
	   sa.assertTrue(gVar.assertVisible("pdp_Size_Label", "ShopNav\\PDP.properties"),"select size label");
	   sa.assertTrue(gVar.assertVisible("pdp_Size_Swatches", "ShopNav\\PDP.properties"),"size swatches section");
	   sa.assertTrue(gVar.assertVisible("pdp_Width_Label", "ShopNav\\PDP.properties"),"select width label");
	   sa.assertTrue(gVar.assertVisible("pdp_Width_Swatches", "ShopNav\\PDP.properties"),"width swatches section");
       sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AvailabilityMsgLabel),"Product Availabilty message");
       sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_SelecteStyleAvailability_Mes),"slect style availabilty message");
	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_QtyTextbox),"Aty TextBox");
       sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.QuantityLabel),"Qty label");
       sa.assertTrue(gVar.assertVisible("PDP_AddToCart", "ShopNav\\PDP.properties"),"Add to cart button");
       int SocialIcons=l1.getWebElements(PDP_BundlePOM.Bundle_ShareIcons).size();
       for(i=0; i<SocialIcons; i++)
       {
    	   System.out.println(i);
    	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ShareIcons, i),"Share icons");
    	   
       }
	   int ProductTabs=l1.getWebElements(PDP_BundlePOM.Standared_PDPTabSection).size();
	   for(i=0; i<ProductTabs; i++)
	   {
		   System.out.println(i);
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PDPTabSection, i),"product tabs");
	   }
	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_RecommandationSection),"Recommondation section");
	   s.SelectSwatch();
	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AddToGiftregistry),"Add to gift registry button");
	   sa.assertTrue(gVar.assertVisible("PDP_AddToWishList","ShopNav\\PDP.properties"),"Add to gift registry button");
       try
       {
    	  sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_PreviousLink),"Previous link"); 
       }
       catch(Exception e)
       {
    	   System.out.println("previous link is not present as we selected first product from the PLP page");
       }
 	  sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_NextLink),"Next link"); 

	   sa.assertAll();
	   
	}
	
	/*@Test(groups="{Regression}",description="124789")
	public void TC00_PDPStandared_RecommondationProducts_Name() throws Exception
	{

		int RecommondationProdName=l1.getWebElements(PDP_BundlePOM.Standared_ProdNameinRecommondationSection).size();
		for(i=0; i<RecommondationProdName; i++)
		{
			
			String ProdName=l1.getWebElements(PDP_BundlePOM.Standared_ProdNameinRecommondationSection).get(i).getText();
			log.info("Click on Product name");
			l1.getWebElements(PDP_BundlePOM.Standared_ProdNameinRecommondationSection).get(i).click();
			log.info("Product name verification");
			sa.assertEquals(ProdName, gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"));
			
		}
}
	
	@Test(groups="{Regression}",description="124789")
	public void TC00_PDPStandared_RecommondationProducts_Image() throws Exception
	{
			s.NavigateToStandaredProduct();

		int RecommondationProdImages=l1.getWebElements(PDP_BundlePOM.Standared_RecommondationImage).size();
		for(i=0; i<RecommondationProdImages; i++)
		{
			
			String ProdName=l1.getWebElements(PDP_BundlePOM.Standared_RecommondationImage).get(i).getText();
			log.info("Click on Product name");
			l1.getWebElements(PDP_BundlePOM.Standared_RecommondationImage).get(i).click();
			log.info("Product name verification");
			sa.assertEquals(ProdName, gVar.assertEqual("PDP_Product_Name", "ShopNav\\PDP.properties"));
			s.NavigateToStandaredProduct();
			
		}
}
	
	@Test(groups="{Regression}",description="290028,289994")
	public void TC00_PDPStandared_selectstoreoverlay_UI() throws Exception
	{
		log.info("Search for Store availability product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct", 1, 0));
		log.info("CLick on check store availability link");
		l1.getWebElement(PDP_BundlePOM.Standared_CheckStoreAvailabilityLink).click();
		log.info("Zipcode textbox verificaion");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox),"ZipCode textbox verification");
		log.info("Enter the zipcode in zipcode textbox");
		l1.getWebElement(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox).sendKeys("10014");
		log.info("CLick on search Button");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilty_SearchButton).click();
		log.info("UI verification of Store Availability");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilityClose_link),"Store Availabilityclose link");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilitySelectstore_Dailog),"Select Store text");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_StoreStatus),"Select Store Availability text");
        int SelectStorebuttons=l1.getWebElements(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton).size();
        for(i=0; i<SelectStorebuttons; i++)
        {
        	System.out.println(i);
        	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_StoreAddress,i));
        	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_StoreStatus,i));
        	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton,i));

        }
        sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_ChangeLocationButton),"Change Location button");
        sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_ContinueButton),"Change Location button");

	}
	
	
	@Test(groups="{Regression}",description="290028")
	public void TC00_PDPStandared_selectstoreoverlay_StoreAvailability() throws Exception
	{
		
		
		log.info("Search for Store availability product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct", 1, 0));
		log.info("CLick on check store availability link");
		l1.getWebElement(PDP_BundlePOM.Standared_CheckStoreAvailabilityLink).click();
		log.info("Zipcode textbox verificaion");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox),"ZipCode textbox verification");
		log.info("Enter the zipcode in zipcode textbox");
		l1.getWebElement(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox).sendKeys("10014");
		log.info("CLick on search Button");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilty_SearchButton).click();
		
		log.info("Store Availability");
		
		
		try
		{
			log.info("Print Maadi");
			System.out.println("print :"+l1.getWebElements(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton).get(0).getAttribute("disabled"));
			//boolean buttonstate=l1.getWebElements(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton).get(0).getAttribute("disabled");
			//if(buttonstate==true)
			//{
			//	System.out.println("select store button is disabled");
			//}
		}
		catch(Exception e)
		{
			System.out.println("Select store button is enabled");
		}
		
	}
	
	/*
	
	@Test(groups="{Regression}",description="290028")
	public void TC10_PDPStandared_selectstoreoverlay_ContinueButton() throws Exception
	{
		try
		{
			if(l1.getWebElements(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton).get(0).getAttribute("disabled").equals("disabled"))
			{
				System.out.println("select store button is disabled");
				
			}
			String StoreAddress=l1.getWebElements(PDP_BundlePOM.StoreAvailability_StoreAddress).get(1).getText();
			log.info("Select 2 store address");
			l1.getWebElements(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton).get(1).click();
			log.info("Click on continue button");
			l1.getWebElement(PDP_BundlePOM.StoreAvailability_ContinueButton).click();
			log.info("Store address selected verification");
			sa.assertEquals(StoreAddress, l1.getWebElement(PDP_BundlePOM.PDP_StoreAddress));
			
		}
		catch(Exception e)
		{
			String StoreAddress=l1.getWebElements(PDP_BundlePOM.StoreAvailability_StoreAddress).get(0).getText();
			log.info("Select 2 store address");
			l1.getWebElements(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton).get(0).click();
			log.info("Click on continue button");
			l1.getWebElement(PDP_BundlePOM.StoreAvailability_ContinueButton).click();
			log.info("Store address selected verification");
			sa.assertEquals(StoreAddress, l1.getWebElement(PDP_BundlePOM.PDP_StoreAddress));
			
		}
		
	}
	
	@Test(groups="{Regression}",description="290022")
	public void TC11_PDPStandared_UIofavailabilitysection() throws Exception
	{
		
		log.info("Search for Store availability product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct", 1, 0));
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_AvailabilityCheck),"Availability for pickup section");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Availabilityforpickup_Text),"Availability for pickup section text");
        sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_CheckStoreAvailabilityLink),"Check availability store link");
		
		
	}
	
	@Test(groups="{Regression}",description="290022")
	public void TC12_PDPStandared_UIofstoresearchoverlay () throws Exception
	{
		log.info("click on check availability pickup link");
		l1.getWebElement(PDP_BundlePOM.Standared_CheckStoreAvailabilityLink).click();
		log.info("UI of Store search Overlay");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Storesearchoverlay_Text),"Store search overlay text");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilityClose_link),"Close link in store search overaly");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox),"Zipcode textbox in store search overaly");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilty_SearchButton),"Search button in store search overaly");
		String PlaceHolderText=l1.getWebElement(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox).getAttribute("placeholder");
        log.info("Place Holder text verification");
        sa.assertEquals(PlaceHolderText, GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct", 1, 1));
        log.info("Close the search overaly");
        l1.getWebElement(PDP_BundlePOM.StoreAvailabilityClose_link).click();
	}
	
	
	@Test(groups="{Regression}",description="124791")
	public void TC13_PDPStandared_productTabs() throws Exception
	{
		
		log.info("UI of PDP tabs verification");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_youmightalsoLike_Text),"youmightalsoLike tab");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Discription_Text),"Discription tab");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_ProductDetails_Text),"ProductDetails tab");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Reviews_Text),"Reviews tab");
	}
	
	@Test(groups="{Regression}",description="124793")
	public void TC14_PDPStandared_productTabsFunctionality() throws Exception
	{
		
		int PDPTabs=l1.getWebElements(PDP_BundlePOM.Standared_PDPTabSection).size();
		for(i=0; i<PDPTabs; i++)
		{
			l1.getWebElements(PDP_BundlePOM.Standared_PDPTabSection).get(i).click();
			sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_RecommandationSection, i));
		}
	}	
	
	@Test(groups="{Regression}",description="289979")
	public void TC15_PDPStandared_Changelocationbutton () throws Exception
	{
		log.info("click on check availability pickup link");
		l1.getWebElement(PDP_BundlePOM.Standared_CheckStoreAvailabilityLink).click();
		log.info(" Store search Overlay");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Storesearchoverlay_Text),"Store search overlay text");
		log.info("Enter Valid zipcode");
		l1.getWebElement(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox).sendKeys("01801");
		log.info("Click on saerch button");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilty_SearchButton).click();
		log.info("Select store overlay verificarion");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilitySelectstore_Dailog),"Select store dialog text");
		log.info("Click on change location");
		l1.getWebElement(PDP_BundlePOM.StoreAvailability_ChangeLocationButton).click();
		log.info("Store search overlay verificatrion");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Storesearchoverlay_Text),"store search overlay text");
		
	}
	
	@Test(groups="{Regression}",description="290026")
	public void TC16_PDPStandared_closeiconinstoresearchoverlay() throws Exception
	{
		log.info("Click on close button in store availability overlay");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilityClose_link).click();
		log.info("Store availability link should get closed");
		sa.assertTrue(gVar.assertNotVisible(PDP_BundlePOM.Standared_Storesearchoverlay_Text),"store search overlay text");
	}
	
	@Test(groups="{Regression}",description="290029")
	public void TC17_PDPStandared_Closeiconinselectstoreoverlay() throws Exception
	{
		log.info("click on check availability pickup link");
		l1.getWebElement(PDP_BundlePOM.Standared_CheckStoreAvailabilityLink).click();
		log.info(" Store search Overlay");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Storesearchoverlay_Text),"Store search overlay text");
		log.info("Enter Valid zipcode");
		l1.getWebElement(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox).sendKeys("01801");
		log.info("Click on saerch button");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilty_SearchButton).click();
		log.info("Select store overlay verificarion");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilitySelectstore_Dailog),"Select store dialog text");
		log.info("Click on close button in store availability overlay");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilityClose_link).click();
		
		
	}
	
	
	@Test(groups="{Regression}",description="290036,290030,290035 ")
	public void TC18_PDPStandared_seemorestoreslink() throws Exception
	{
		
		log.info("Search for Store availability product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct", 1, 0));
		log.info("Click on store availability link in PDP");
		l1.getWebElement(PDP_BundlePOM.Standared_CheckStoreAvailabilityLink).click();
		log.info("Enter zip code");
		l1.getWebElement(PDP_BundlePOM.StoreAvailability_ZipcodeTextbox).sendKeys("01801");
		log.info("Click on saerch button");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilty_SearchButton).click();
		log.info("Select store overlay verificarion");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailabilitySelectstore_Dailog),"Select store dialog text");
		log.info("Click on select store");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilty_SelecteStoreButton).click();
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.StoreAvailability_PrefferedStoreButton),"Preffered store button verification");
		log.info("Click on continue button");
		l1.getWebElement(PDP_BundlePOM.StoreAvailability_ContinueButton).click();
		log.info("Click on see more stores link");
		l1.getWebElement(PDP_BundlePOM.Standared_seeMorestoresLink).click();
		log.info("Store list");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Storelists),"Store lists");
		log.info("Click on see few stores link");
		l1.getWebElement(PDP_BundlePOM.Standared_seeFewstores).click();
		log.info("Store lists should not be visible");
		sa.assertFalse(gVar.assertNotVisible(PDP_BundlePOM.Standared_Storelists),"Store lists are not visible");
		
	}
	
	@Test(groups="{Regression}",description="290036,290030 ")
	public void TC19_PDPStandared_RecommonadationSection_UI() throws Exception
	{
		
		log.info("you might also like text");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_youmightalsoLike_Text),"you might also like text");
		log.info("UI verification of recommondation section");
		
		int recommondationsectionprodcount=l1.getWebElements(PDP_BundlePOM.Standared_RecommondationImage).size();
		for(i=0; i<recommondationsectionprodcount; i++)
		{
			sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_RecommondationImage, i),"Recommondation section images");
			sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_RecommondationProNames, i),"Recommondation section images");
			sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_RecommondationPricevalues, i),"Recommondation section images");

		}
		
		
		
	}
	
	
	@Test(groups="{Regression}",description="290036,290030 ")
	public void TC20_PDPStandared_AddToWishList() throws Exception
	{
		
		log.info("Search for Store availability product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct", 1, 2));
		log.info("click on add to wishlist link");
		l1.getWebElement(PDP_BundlePOM.Bundle_WishListLink).click();
		log.info("Login Page");
		sa.assertTrue(gVar.assertVisible("Login_Heading", "Profile\\login.properties"),"login heading");
		
	}
	
	@Test(groups="{Regression}",description="290036,290030 ")
	public void TC21_PDPStandared_AddToGiftRegistry() throws Exception
	{
		log.info("Search for Store availability product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct", 1, 2));
		log.info("click on add to Gift Registry link");
		l1.getWebElement(PDP_BundlePOM.Bundle_AddToGiftregistry).click();
		log.info("Gift registry page heading");
		sa.assertEquals(gVar.assertEqual(PDP_BundlePOM.Bundle_giftRegistry_Heading),GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 5));
	}
	
	@Test(groups="{Regression}",description="148598 ")
	public void TC22_PDPStandared_Standardproduct_UI() throws Exception
	{
		
		log.info("Search for Store availability product");
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_StandaredProduct",2, 2));
		log.info("UI of standared Product");
		
		   sa.assertTrue(gVar.assertVisible("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties"),"PDP BreadCrumb Element verification");
		   sa.assertTrue(gVar.assertVisible("PDP_Product_Name", "ShopNav\\PDP.properties"),"Product name");	
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ProductNumber),"Product Number");
		   try
		   {
			   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_StrikeoutPrice),"Strike out price");
	  
		   }
		   catch(Exception e)
		   {
			   System.out.println("No Srtike out price is displaying");
		   }
		   try
	       {
	    	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Stnadred_AvailabilitySection),"Product availability section");

	       }
	       catch(Exception e)
	       {
	    	   System.out.println("Availability message is not displayed");
	       }
		   try
	       {
	    	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_AvailabilityCheck),"Product Store availability section");


	       }
	       catch(Exception e)
	       {
	    	   System.out.println("Store availability is not present for this product");
	       }
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_ActualPrice),"Actual Price of the product");
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_QtyTextbox),"Aty TextBox");
	       sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.QuantityLabel),"Qty label");
	       sa.assertTrue(gVar.assertVisible("PDP_AddToCart", "ShopNav\\PDP.properties"),"Add to cart button");
	       int SocialIcons=l1.getWebElements(PDP_BundlePOM.Bundle_ShareIcons).size();
	       for(i=0; i<SocialIcons; i++)
	       {
	    	   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_ShareIcons, i),"Share icons");
	       }
		   int ProductTabs=l1.getWebElements(PDP_BundlePOM.Standared_PDPTabSection).size();
		   for(i=0; i<ProductTabs; i++)
		   {
			   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PDPTabSection, i),"product tabs");
		   }
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_RecommandationSection),"Recommondation section");
		   s.SelectSwatch();
		   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_AddToGiftregistry),"Add to gift registry button");
		   sa.assertTrue(gVar.assertVisible("PDP_AddToWishList","ShopNav\\PDP.properties"),"Add to gift registry button");
	       try
	       {
	    	  sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_PreviousLink),"Previous link"); 
	       }
	       catch(Exception e)
	       {
	    	   System.out.println("previous link is not present as we selected first product from the PLP page");
	       }
	       try
	       {
	 	 	  sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Bundle_NextLink),"Next link"); 

	       }
	       catch(Exception e)
	       {
	    	   System.out.println("Next link is not present as we selected first product from the PLP page");

	       }
	       
		   sa.assertAll();
		
	}
	
	@Test(groups="{Regression}",description="287840")
	public void TC23_PDPStandared_AddToWishList_LoggedIn(XmlTest xmlTest) throws Exception
	{
		log.info("Login to the application");
	    p.loginToAppliction(xmlTest);
		log.info("remove the products if any are in wishlist");
        p.clearWishList();
		log.info("navigate to Standared Product");
		s.NavigateToStandaredProduct();
		log.info("Select all the variances");
		s.SelectSwatch();

		log.info("Product Name");
		String VariationProdName=l1.getWebElement(PDP_BundlePOM.BundleProd_ProductName).getText();
		
		log.info("CLick on add to wish list link");
		l1.getWebElement(PDP_BundlePOM.Bundle_WishListLink).click();
		
       sa.assertTrue(gVar.assertVisible("Wishlist_ContactUS_Heading", "Profile\\Wishlist.properties"),"Wish List Heading");
		
		String WishListProdName=l1.getWebElement("Wishlist_ProductName", "Profile\\Wishlist.properties").getText();
		log.info("Bundle Product name verification");
		sa.assertEquals(VariationProdName, WishListProdName);
	}
	
	
	@Test(groups="{Regression}",description="287842")
	public void TC24_PDPStandared_AddToGiftregistry_LoggedIn() throws Exception
	{
		
		log.info("navigate to Standared Product");
		s.NavigateToStandaredProduct();
		log.info("Select all the variances");
		s.SelectSwatch();
		log.info("Click on Add to Gift Regisrty link");
		l1.getWebElement(PDP_BundlePOM.Bundle_AddToGiftregistry).click();

		log.info("Gift registry page heading");
		sa.assertEquals(gVar.assertEqual(PDP_BundlePOM.Bundle_giftRegistry_Heading),GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 5));
		log.info("Logout from the application");
	   p.Logout();
	}
	
	@Test(groups="{Regression}",description="287838,287837")
	public void TC25_PDPStandared_LeftAndRight_Courosals() throws Exception
	{
		
		int ProdCount=l1.getWebElements(PDP_BundlePOM.Standared_RecommondationProNames).size();
		try
		{
		
			if(ProdCount>3)
			{
				l1.getWebElement(PDP_BundlePOM.Standared_Recommondation_LeftCourousal).click();
				sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_Recommondation_RightCourousal),"Right courousal is present");
				l1.getWebElement(PDP_BundlePOM.Standared_Recommondation_RightCourousal).click();
				sa.assertTrue(gVar.assertNotVisible(PDP_BundlePOM.Standared_Recommondation_LeftCourousal),"Left courousal is present");

			}
			
		}
		catch(Exception e)
		{
			System.out.println("Recommondation section contains less than 3 products hence courosals are not present");
		}
	}
	
	
	@Test(groups="{Regression}",description="287838,287837")
	public void TC26_PDPStandared_Breadcrumb() throws Exception
	{
		s.NavigateToStandaredProduct();
		sa.assertEquals(l1.getWebElements("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties").get(3).getAttribute("href"), null);
		l1.getWebElements("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties").get(2).click();
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_categoryBanner),"Suits category PLP is displaying");
		l1.getWebElements("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties").get(1).click();
        sa.assertEquals(l1.getWebElement(PDP_BundlePOM.Standared_ClothingRefinement).getText(), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 3));
		l1.getWebElements("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties").get(0).click();
        sa.assertEquals(l1.getWebElement("Category_Refinement_Header", "ShopNav\\CategoryLanding.properties").getText(), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 2, 3));
	}
	
	
	
	@Test(groups="{Regression}",description="287894")
	public void TC27_PDPStandared_PromotionDetails() throws Exception
	{
		
		s.NavigateToStandaredProduct();
		try
		{
			if(l1.getWebElement(PDP_BundlePOM.Standare_PromotionSection).isDisplayed())
			{
			sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PromotionTitke),"Promotion title");
			sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PromotionCallout),"Promotion Callout message");
	        int detailsCount=l1.getWebElements(PDP_BundlePOM.Standared_DetailsTooltip).size();
	        for(i=0; i<detailsCount; i++)
	        {
	        	sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_DetailsTooltip, i),"details tooltop");
	        }
		}
		}
		catch(Exception e)
		{
			System.out.println("promotion section is not displayed as this product doesnt contains any promotion");
		}
	}*/
	
	/*@Test(groups="{Regression}",description="287894")
	public void TC28_PDPStandared_QTYValidation() throws Exception
	{
		
		
		
		
	}
	
	
	
	
	
	@Test(groups="{Regression}",description="290027")
	public void TC28_PDPStandared_Breadcrumb() throws Exception
	{
		
		
		
	}
	
	@Test(groups="{Regression}",description="290025")
	public void TC29_PDPStandared_StoreZipCode_validation() throws Exception
	{
		
		
		
		
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
