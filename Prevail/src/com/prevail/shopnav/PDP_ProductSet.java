package com.prevail.shopnav;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.prevail.pom.PDP_BundlePOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class PDP_ProductSet extends BaseTest
{
	
  @Test(groups="{Regression}",description="287972")
	public void TC00_Set_AddAllToCart() throws Exception
	{
	   
		s.NavigateToSetProduct();
		int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();
		 int totalQty = 0;
		 int k=1;
		 	
	
		//fetch the quantity present in the all boxes in set 
		for(i=0;i<totalProductsInSet;i++)
		  {		
			System.out.println("Entering loop"+i);
			totalQty=totalQty+ Integer.parseInt(driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//input[@name='Quantity']")).getAttribute("size"));
			System.out.println(totalQty);

		  }
		//fetch quantity from mini cart before clicking
		int expCartQuantity = totalQty;
		
		System.out.println(expCartQuantity);
		
		//click on add all to cart
       l1.getWebElement(PDP_BundlePOM.ProdSet_AddAllToCart).click();		
       int actCartQuantity=Integer.parseInt(l1.getWebElement("MiniCart_QtyValue", "ShopNav\\Minicart.properties").getText());
       
       System.out.println(actCartQuantity);
       
		//verify the cart quantity
		sa.assertEquals(expCartQuantity, actCartQuantity);
		sa.assertAll();
	}

	
		@Test(groups="{Regression}",description="124813")
	public void TC01_Set_AddToCartIndividualProduct() throws Exception
	{
		
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 3, 1));
		int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();
		int cartQuantity=0;
		int k=1;
		for(int i=0;i<totalProductsInSet;i++)
		  {	
			
			
			System.out.println("ENtering the loop"+i);
			//s.SelectSwatch();
			
			log.info("Clear quantity box values");
			driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//input[@name='Quantity']")).clear();
			log.info("accept the alret popup");
			driver.switchTo().alert().accept();
			log.info("enter value in quantity box");
         	driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//input[@name='Quantity']")).sendKeys(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 2));
         	log.info("verify the entered value");
            sa.assertEquals(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 2), driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//input[@name='Quantity']")).getText());
			log.info("click on add to cart");
			driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//button[starts-with(@class,'button-fancy-medium sub-product-item add-to-cart')]")).click();
			try
			{
				
				if(l1.getWebElement(PDP_BundlePOM.ProdSet_BonusProdHeading).isDisplayed())	
				{
					log.info("CLick on No Thanks");
					l1.getWebElement(PDP_BundlePOM.Prodset_NoThanksBonusProd_Button).click();
				}
				
			}
			catch(Exception e)
			{
				log.info("This Product doesnt contains any bonus product");
			}
			
			//verify the mini cart fly out
			
			 cartQuantity=cartQuantity+Integer.parseInt(driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//input[@name='Quantity']")).getAttribute("value"));
			 
			 System.out.println(cartQuantity);
			k++;
			
			
		  }
		//verify the total added quantity
		int expQuantity=cartQuantity;
		
		System.out.println(expQuantity);
		
		sa.assertEquals(cartQuantity,expQuantity);
		
		
		
		
		
		
	}

	
		@Test(groups="{Regression}",description="287896")
	public void TC02_Set_UIofpromotionssection() throws Exception
	{
		
		s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 1));
		int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();
		for(int i=0;i<totalProductsInSet;i++)
		  {	
			
		  
		   try
		   {
			   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standare_PromotionSection, i));
			   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PromotionTitke, i));
			   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_PromotionCallout, i));  
			   sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_DetailsTooltip, i),"details tooltop");
		   }
		  
		   catch(Exception e)
		   {
			   System.out.println("Details tooltip is not dispalying");
		   }

		  
		
				   sa.assertAll();

		
	}
	}
	
			
	@Test(groups="{Regression}",description="287896")
	public void TC03_Set_UIofProductSet() throws Exception
	{
				
				s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 1));

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
		   sa.assertAll();

	}
	
	
		@Test(groups="{Regression}",description="287896")
		public void TC04_Set_SizeChart() throws Exception
	{
			s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 3, 1));

		log.info("Click on size chart");
		l1.getWebElements(PDP_BundlePOM.ProdSet_SizeChart).get(0).click();
		log.info("Size chart Dialog");
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.ProdSet_SizechartDialog),"Size chart Dialog");
		log.info("Click on close link");
		l1.getWebElement(PDP_BundlePOM.StoreAvailabilityClose_link).click();
		sa.assertTrue(gVar.assertNotVisible(PDP_BundlePOM.ProdSet_SizechartDialog),"Size chart Dialog");
		sa.assertAll();
	}
	
			
	@Test(groups="{Regression}",description="287896")
	public void TC05_Set_roductnameofanindividualproduct() throws Exception
	{
    	s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 1));

		
		int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();

        for(i=0; i<totalProductsInSet;i++)
        {
        	String PDPItemName=l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundleProNames).get(i).getText();
        	log.info("Click on Item Name");
        	l1.getWebElements(PDP_BundlePOM.BundleProd_TotalBundleProNames).get(i).click();
        	log.info("Product Name Verification");
        	sa.assertEquals(l1.getWebElement("PDP_Product_Name", "ShopNav\\PDP.properties").getText(), PDPItemName);
        	log.info("Saerch for product set ");
        	s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 1));
        }
		sa.assertAll();
		
	}
	
	@Test(groups="{Regression}",description="287820 ")
	public void TC06_Set_breadcrumbsonproductdetailpage() throws Exception
	{
    	s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 1));
		int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();

	//	sa.assertEquals(l1.getWebElements("orderDetails_Breadcrumb", "Profile\\OrderHistory.properties").get(3).getAttribute("href"), null);
		l1.getWebElements("Address_breadcrumb", "Profile\\Addresses.properties").get(2).click();
		sa.assertTrue(gVar.assertVisible(PDP_BundlePOM.Standared_categoryBanner),"Suits category PLP is displaying");
		l1.getWebElements("Address_breadcrumb", "Profile\\Addresses.properties").get(1).click();
        sa.assertEquals(l1.getWebElement(PDP_BundlePOM.Standared_ClothingRefinement).getText(), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 1, 3));
		l1.getWebElements("Address_breadcrumb", "Profile\\Addresses.properties").get(0).click();
        sa.assertEquals(l1.getWebElement("Category_Refinement_Header", "ShopNav\\CategoryLanding.properties").getText(), GetData.getDataFromExcel("//data//ShopNavData.xls","Header", 2, 3));
		
		
		
		
		
		
	}
		
	@Test(groups="{Regression}",description="124802")
	public void TC07_Set_selectingacolorvariant() throws Exception
	{
		
    	s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 1, 1));

    	
		int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();
	     int k=1;
		for(i=0; i<totalProductsInSet;i++)
		{
			
			
			
			int colorCount=driver.findElements(By.xpath("(//ul[@class='swatches color'])["+k+"]")).size();
			
            System.out.println(colorCount);
			if(l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).get(i).isDisplayed())
						
		  {	
			//only one swatchanchor is there
			if(colorCount==1)
			{
				System.out.println("Came inside loop");
				if(l1.getWebElement("pdp_ColorSwatch_Selected", "ShopNav\\PDP.properties").isDisplayed())
					  {
					  String[] Title=driver.findElement(By.xpath("(//ul[@class='swatches color'])["+k+"]//a[@class='swatchanchor']")).getAttribute("title").split(" ");
					  System.out.println(Title[2].toUpperCase());
					  //verify whether selected value is displaying or not
					  sa.assertEquals(Title[2].toUpperCase(),driver.findElement(By.xpath("(//ul[@class='swatches color'])["+k+"]/li[@class='selected-value']")).getText());
					  
				}
				
				else
				  {
					System.out.println("Comini here");
				  //click on swatch anchor
					driver.findElement(By.xpath("(//ul[@class='swatches color'])["+k+"]/li[1]")).click();
					String[] Title=driver.findElement(By.xpath("(//ul[@class='swatches color'])["+k+"]/li")).getAttribute("title").split(" ");
					System.out.println(Title[2]);
				  //verify whether selected value is displaying or not
			
				  sa.assertEquals(Title[2],driver.findElement(By.xpath("(//ul[@class='swatches color'])["+k+"]/li[@class='selected-value']")).getText());
				  }
				
			}
			}
			else
			{
				
				for(int j=0; j<colorCount; j++)
				{
					System.out.println("Came inside looping");
					System.out.println(i);
					driver.findElements(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//ul[@class='swatches color']/li")).get(i).click();
					Thread.sleep(4000);
					String SelectedWidth=driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//ul[@class='swatches color'])//li[@class='selectable selected']")).getText();
					System.out.println(SelectedWidth);
					log.info("selected width verification");
					sa.assertEquals(SelectedWidth, driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//ul[@class='swatches color']/li[@class='selected-value']")).getText());
			}
			
}
			k++;

		}
		sa.assertAll();
	}
		

	
	
	

		@Test(groups="{Regression}",description="124802")
	public void TC08_Set_selectingasizevairant() throws Exception
	{
	    	s.Search(GetData.getDataFromExcel("//data//ShopNavData.xls","PDP_ProductSet", 2, 1));


		int totalProductsInSet=l1.getWebElements(PDP_BundlePOM.ProductSet_TotalSetCount).size();
		System.out.println(totalProductsInSet);
		int k=1;
        for(int i=0; i<totalProductsInSet;i++)
        {		
        	System.out.println("Coming here"+i);
        	

        	log.info("number of sizes in first set of the product");
        	System.out.println("value of k is"+k);
        	int Size=driver.findElements(By.xpath("(//ul[@class='swatches size'])["+k+"]/li")).size();
        	System.out.println("Size of the sie"+Size);
    		if(Size==1)
    		{
    			System.out.println(Size==1);
    			if(l1.getWebElement("pdp_SizeSwatch_Selected", "ShopNav\\PDP.properties").isDisplayed())
    			{
    				  String[] Title=driver.findElement(By.xpath("(//ul[@class='swatches size'])["+k+"]//li[@class='selectable selected']")).getAttribute("title").split(" ");
    				  System.out.println(Title[2]);
    				  //verify whether selected value is displaying or not
    				 sa.assertTrue(gVar.assertVisible("PDP_Product_Size", "ShopNav\\PDP.properties"),"Color selected value");
    				  sa.assertEquals(Title,driver.findElement(By.xpath("//ul[@class='swatches size']/li[@class='selected-value']")).getText());
    				  
    			}
    			
    			else
    			  {
    			  //click on swatch anchor
    				driver.findElement(By.xpath("(//ul[@class='swatches size'])["+k+"]//li[@class='selectable selected']")).click();
    				String[] Title=driver.findElement(By.xpath("(//ul[@class='swatches size'])["+k+"]//li[@class='selectable selected']")).getAttribute("title").split(" ");
    				
    				System.out.println(Title[2]);
    				
    			  //verify whether selected value is displaying or not
    				 sa.assertTrue(gVar.assertVisible("PDP_Product_Size", "ShopNav\\PDP.properties"),"Color selected value");
    				 
    			  sa.assertEquals(Title,driver.findElement(By.xpath("(//ul[@class='swatches size'])["+k+"]/li[@class='selected-value']")).getText());
    		
    			  }
    			
    		}
    		else
    		{
    			
    			for(int j=0; j<Size; j++)
    			{
    				
    	        	System.out.println("Coming here selection operation"+j);

    				log.info("Click on all the sizes of first set product");
    				driver.findElements(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//ul[@class='swatches size']//li")).get(j).click();	
    				Thread.sleep(4000);
    				String SelectedSize=driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//ul[@class='swatches size']//li[@class='selectable selected']/a")).getText();
    				System.out.println(SelectedSize);
    				sa.assertEquals(driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//ul[@class='swatches size']/li[@class='selected-value']")).getText(),SelectedSize);
    	            System.out.println(driver.findElement(By.xpath("(//div[@class='product-set-item product-bundle-item'])["+k+"]//ul[@class='swatches size']/li[@class='selected-value']")).getText());
    	            //j++;
    	            System.out.println("Domne with the iteration"+j);
    		}
    	}
    		
        	k++;
        	
        }
		
		
		sa.assertAll();
	}
	
	

}
