package com.prevail.projectspec;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import com.prevail.pom.CartPOM;
import com.prevail.pom.MiniCartPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetDriver;

public class CartFunctions extends BaseTest {
	
	public String CartProductName;
	public String CartProductPrice;
	public String CartSubTotal;
	public String CartShippingTotal;
	public String CartSalesTax;
	public String CartExtimatedTotal;
	public String CartCheckoutbuttonTop;
	public String CartCheckoutbuttonBottom;

	public void navigateToCart() throws Exception
	{
		BaseTest.log.info("Add item to cart");
		BaseTest.s.AddtoCart();
		BaseTest.log.info("click on mini cart link");
		BaseTest.l1.getWebElement("MiniCartLink","ShopNav\\Minicart.properties").click();
		BaseTest.log.info("fetching Cart Product name");
		CartProductName=l1.getWebElement(CartPOM.cartProductName).getText();
		BaseTest.log.info("Cart Product name"+CartProductName);
		BaseTest.log.info("Fetching cart Price");
		try {
			
			CartProductPrice=BaseTest.l1.getWebElement(CartPOM.cartProductPriceSalesPrice).getText().replace("$","");
			BaseTest.log.info("Fetching sales price if available"+CartProductPrice);
			
		} catch (Exception e) {
			
			CartProductPrice=BaseTest.l1.getWebElement(CartPOM.cartProductPriceStandared).getText().replace("$","");
			BaseTest.log.info("Fetching standared price"+CartProductPrice);

			
		}
		
		CartSubTotal=l1.getWebElement(CartPOM.cartsubtotal).getText().replace("$","");
		BaseTest.log.info("Fetching standared price"+CartSubTotal);
		
		CartShippingTotal=l1.getWebElement(CartPOM.cartShippingTotal).getText().replace("$","");;
		BaseTest.log.info("Fetching standared price"+CartShippingTotal);
		
		CartSalesTax=l1.getWebElement(CartPOM.cartSalesTax).getText().replace("$","");;
		BaseTest.log.info("Fetching standared price"+CartShippingTotal);
		
		CartExtimatedTotal=l1.getWebElement(CartPOM.cartExtimatedTotal).getText().replace("$","");;
		BaseTest.log.info("Fetching standared price"+CartExtimatedTotal);
				
	}
	
	//Navigate to cart
	public void navigateToCart(String qty) throws Exception
	{
		//add item to cart
		BaseTest.log.info("Click on root category");
		BaseTest.l1.getWebElements("RootCategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		Thread.sleep(3000);
		BaseTest.log.info("Click on main category");
		BaseTest.l1.getWebElements("Category_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		BaseTest.log.info("Click on subcategory");
		Thread.sleep(3000);
		BaseTest.l1.getWebElements("Subcategory_Links","ShopNav\\CategoryLanding.properties").get(1).click();
		BaseTest.log.info("Fetching product name");
		//click on product Name to navigate to PDP
		String ProductName=BaseTest.l1.getWebElements("Category_NameLink","ShopNav\\CategoryLanding.properties").get(0).getText();
		System.out.println("ProductName"+ProductName);
		BaseTest.l1.getWebElements("Category_NameLink","ShopNav\\CategoryLanding.properties").get(0).click();
		log.info("click inside the quantity textbox");
		log.info("clear the quantity textbox");
		BaseTest.l1.getWebElement("PDP_Quantity_Textbox", "ShopNav\\PDP.properties").clear();
		log.info("set the quantity");
		Thread.sleep(3000);
		//Handling alert popup
		Alert alert = GetDriver.driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		BaseTest.l1.getWebElement("PDP_Quantity_Textbox", "ShopNav\\PDP.properties").sendKeys(qty);
		log.info("Select Swatch");
		s.SelectSwatch();
		BaseTest.log.info("PDP Add to cart button");
		BaseTest.l1.getWebElement("PDP_AddToCart","ShopNav\\PDP.properties").click(); 			
		//navigate to Cart page
		BaseTest.log.info("click on mini cart link");
		BaseTest.l1.getWebElement("MiniCartLink","ShopNav\\Minicart.properties").click();
		BaseTest.log.info("fetching Cart Product name");
		CartProductName=l1.getWebElement(CartPOM.cartProductName).getText();
		BaseTest.log.info("Cart Product name"+CartProductName);
		BaseTest.log.info("Fetching cart Price");
		try {
			
			CartProductPrice=BaseTest.l1.getWebElement(CartPOM.cartProductPriceSalesPrice).getText().replace("$","");
			BaseTest.log.info("Fetching sales price if available"+CartProductPrice);
			
		} catch (Exception e) {
			
			CartProductPrice=BaseTest.l1.getWebElement(CartPOM.cartProductPriceStandared).getText().replace("$","");
			BaseTest.log.info("Fetching standared price"+CartProductPrice);

			
		}
		
		CartSubTotal=l1.getWebElement(CartPOM.cartsubtotal).getText().replace("$","");
		BaseTest.log.info("Fetching standared price"+CartSubTotal);
		
		CartShippingTotal=l1.getWebElement(CartPOM.cartShippingTotal).getText().replace("$","");;
		BaseTest.log.info("Fetching standared price"+CartShippingTotal);
		
		CartSalesTax=l1.getWebElement(CartPOM.cartSalesTax).getText().replace("$","");;
		BaseTest.log.info("Fetching standared price"+CartShippingTotal);
		
		CartExtimatedTotal=l1.getWebElement(CartPOM.cartExtimatedTotal).getText().replace("$","");;
		BaseTest.log.info("Fetching standared price"+CartExtimatedTotal);
	}
	
	public void ClearCartItems() throws Exception
	{
		log.info("Click on MiniCart Link");
		l1.getWebElement(MiniCartPOM.MiniCartLink).click();
		Thread.sleep(3000);
		try {
			l1.getWebElement(CartPOM.Cart_LineItem_Remove_Link).click();
			Thread.sleep(5000);
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("No items in cart");
		}		
	}
	
}
