package com.prevail.pom;

import org.openqa.selenium.By;

public class CartPOM {
	
	public static By cartContinueshoppingHeading=By.name("dwfrm_cart_continueShopping");
	public static By cartProductName=By.xpath("//div[@class='name']");
	public static By cartProductPriceStandared=By.xpath("//span[@class='price-standard']");
	public static By cartProductPriceSalesPrice=By.xpath("//span[@class='price-sales']");
	public static By cartsubtotal=By.xpath("//tr[@class='order-subtotal']//td[2]");
	public static By cartShippingTotal=By.xpath("//tr[@class='order-shipping']//td[2]");
	public static By cartSalesTax=By.xpath("//tr[@class='order-sales-tax']//td[2]");
	public static By cartExtimatedTotal=By.xpath("//tr[@class='order-total']//td[2]");
	public static By cartCheckoutbuttons=By.xpath("//button[@name='dwfrm_cart_checkoutCart']");
	public static By cartCheckoutbuttonTop=By.xpath("(//button[@name='dwfrm_cart_checkoutCart'])[1]");
	public static By cartCheckoutbuttonBottom=By.xpath("(//button[@name='dwfrm_cart_checkoutCart'])[2]");
	public static By cartQuantity=By.xpath("//input[@class='input-text']");
	public static By CartSizeAttribute=By.xpath("//tr[@class='cart-row']//div[@data-attribute='size']//span[@class='label']/following-sibling::span");
	public static By Cart_LineItem_Remove_Link=By.xpath("//button[@name='dwfrm_cart_shipments_i0_items_i0_deleteProduct']");
	
	//Shashidhar
	public static By CartTable=By.xpath("//table[@id='cart-table']");
	public static By Cart_Action_Bar=By.xpath("//div[@class='cart-actions cart-actions-top']");		
	public static By Cart_LineItemPrice=By.xpath("//span[@class='price-total']");
	public static By Cart_LineItem_SalesPrice=By.xpath("//span[@class='price-sales']");
	public static By Cart_UpdateCart_Button=By.xpath("//button[@id='update-cart']");
			
}
