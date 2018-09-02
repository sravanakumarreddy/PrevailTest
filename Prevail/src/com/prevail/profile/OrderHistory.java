package com.prevail.profile;


import java.util.ArrayList;
import java.util.List;

















import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.projectspec.ProfileFunctions;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class OrderHistory extends BaseTest{
	
	String Zipcode;
	String orderEmail;
	String orderNumber;

	
@Test(groups="{Regression}",description="124797_124795")
public void TC00_OrderHistoryUI() throws Exception
{
	
	log.info("login to the application");
	p.loginToAppliction();
	log.info("click on order history in myaccount landing page");
	l1.getWebElement("OrderHistory_Link_AccountLandingPage","Profile\\OrderHistory.properties").click();
	log.info("Order History Heading");
	sa.assertTrue(l1.getWebElement("OrderHistory_Heading","Profile\\OrderHistory.properties").isDisplayed());
	log.info("Fetching Order History No orders heading");
	String NoOrders_Heading=l1.getWebElement("OrderHistory_NoOrdersText","Profile\\OrderHistory.properties").getText();
	log.info("Comparing order History heading with excel heading");
	sa.assertEquals(NoOrders_Heading,GetData.getDataFromExcel("\\data\\ProfileData.xls","Data",1,0));
	
	log.info("Verifying bread crumb");
	l1.getWebElements("OrderHistory_Breadcrumb_Elements","Profile\\OrderHistory.properties").get(1).click();
	log.info("link shiould not be clickable");
	if (l1.getWebElements("OrderHistory_Breadcrumb_Elements","Profile\\OrderHistory.properties").get(1).getAttribute("href")==null){
		log.info("OrderHistory breadcrumb is not a a link and it is static text");	
	}
	else{
		log.info("OrderHistory breadcrumb is a link and it is Not a static text");	
	}
	log.info("Verifying bread crumb My Account");
	l1.getWebElements("OrderHistory_Breadcrumb_Elements","Profile\\OrderHistory.properties").get(0).click();
	log.info("My account heading");
	sa.assertTrue(l1.getWebElement("orderHistory_MyAccount_Heading", "Profile\\OrderHistory.properties").isDisplayed());
	
}
	
@Test(groups="{Regression}",description="124797_124794")
public void TC01_PlacinganOrder() throws Exception
{
	//int rowNum=new Integer(xmlTest.getParameter("dynamicNum"));
	log.info("Calling Navigate to PDP function from shopnav functions");
	s.NavigateToPDP();
	//log.info("Calling select swatch function from shopnav functions");
	s.SelectSwatch();	
	log.info("click on add to cart button");
	l1.getWebElement("PDP_AddToCart","ShopNav\\PDP.properties").click();
	log.info("click on mini cart button");
	l1.getWebElement("PDP_MiniCartLink","ShopNav\\PDP.properties").click();
	log.info("Enter Shipping Address");
	checkout.ShippingAddress("\\data\\Checkout.xls","ShippingAddress",1);
	log.info("Click on Same as billing address checkbox");
	gVar.SelectCheckbox("ShippingPage_SameasBilling_Checkbox","Checkout\\ShippingPage.properties");
	log.info("Click on Continue Button");
	l1.getWebElement("Shipping_ContinueToBilling_Button","Checkout\\ShippingPage.properties");
	log.info("entering billing email address");
	l1.getWebElement("BillingPage_Emailaddress_TextBox","Checkout\\BillingPage.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",1,0));
	log.info("Fetching zip code and order email");
	Zipcode=l1.getWebElement("BillingPage_ZipCode_TextBox","Checkout\\BillingPage.properties").getText();
	orderEmail=l1.getWebElement("BillingPage_Emailaddress_TextBox","Checkout\\BillingPage.properties").getText();
	log.info("Entering Payment Details");
	checkout.PaymentDetails("\\data\\Checkout.xls","PaymentDetails",1);
	l1.getWebElement("Payment_PlaceOrderButton","Checkout\\Payment.properties").click();
	log.info("Click on place order in order review page");
	l1.getWebElement("OrderReview_placeOrderButton","Checkout\\OrderReview.properties").click();
	log.info("Order Confirmation Heading");
	sa.assertTrue(l1.getWebElement("OrderConfirmation_Heading", "Checkout\\OrderConfirmation.properties").isDisplayed());
	sa.assertTrue(l1.getWebElement("orderConfirmation_orderNumber", "Checkout\\OrderConfirmation.properties").isDisplayed());
	orderNumber=l1.getWebElement("orderConfirmation_orderNumber","Checkout\\OrderConfirmation.properties").getText();
	log.info("Click on MyAccount icon in header as logged in user");
	l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
	log.info("Click on MyAccount link in header as logged in user");
	l1.getWebElement("Header_MyAccount_Link","Profile\\MyAccountHome.properties").click();
	log.info("Click on orders link in my account page");
	l1.getWebElement("MyAccount_orders_link","Profile\\MyAccountHome.properties").click();
	log.info("order history heading");
	sa.assertTrue(l1.getWebElement("OrderHistory_Heading","Profile\\OrderHistory.properties").isDisplayed());
	log.info("Date ordered label");
	sa.assertTrue(l1.getWebElement("orderHistory_DateOrdered","Profile\\OrderHistory.properties").isDisplayed());
	log.info("Date ordered label");
	sa.assertTrue(l1.getWebElement("orderHistory_OrderNumberLabel","Profile\\OrderHistory.properties").isDisplayed());
	sa.assertTrue(l1.getWebElement("orderHistory_OrderDetailsButton","Profile\\OrderHistory.properties").isDisplayed());
	sa.assertTrue(l1.getWebElement("orderHisory_OrderShippedtoLabel","Profile\\OrderHistory.properties").isDisplayed());
	sa.assertTrue(l1.getWebElement("orderHisory_itemsLabel","Profile\\OrderHistory.properties").isDisplayed());
	sa.assertTrue(l1.getWebElement("orderHisory_orderTotalLabel","Profile\\OrderHistory.properties").isDisplayed());
	String OrderHistory_orderNumber=l1.getWebElement("orderHisory_orderNumber","Checkout\\OrderConfirmation.properties").getText();
	sa.assertEquals(OrderHistory_orderNumber, orderNumber);
	String OrderHistory_Item_Name=l1.getWebElement("orderHisory_Items_ProductName","Checkout\\OrderConfirmation.properties").getText();
	String OrderHistory_orderTotal=l1.getWebElement("orderHisory_OrderTotal","Checkout\\OrderConfirmation.properties").getText();
//	sa.assertEquals(OrderHistory_Item_Name, "Pagination need to verify");
//	sa.assertEquals(OrderHistory_orderTotal,"");
	
}

@Test(groups="{Regression}",description="124800,124805,124814,124820,288884")
public void TC02_OrderDetailsButtonandUI() throws Exception
{

	log.info("click on order details button");
	l1.getWebElement("orderHistory_OrderDetailsButton","Profile\\OrderHistory.properties").click();
	log.info("Should navigate to order details page");
	sa.assertTrue(l1.getWebElement("orderDetails_Heading","Profile\\OrderHistory.properties").isDisplayed());
	sa.assertTrue(gVar.assertVisible("orderDetails_Breadcrumb","Profile\\OrderHistory.properties"),"Order Details bread crumb");
	sa.assertTrue(gVar.assertVisible("orderDetails_LeftNav","Profile\\OrderHistory.properties"),"Order Details left nav");
	sa.assertTrue(gVar.assertVisible("orderDetails_OrderStatusLabel","Profile\\OrderHistory.properties"),"Order Details Status label");
	sa.assertTrue(gVar.assertVisible("orderDetails_OrderPlacedLabel","Profile\\OrderHistory.properties"),"Order Details orderplaced label");
	sa.assertTrue(gVar.assertVisible("orderDetails_PaymentMethod_Heading","Profile\\OrderHistory.properties"),"Payment method heading");
	sa.assertTrue(gVar.assertVisible("orderDetails_PaymentInstrumentsHeading","Profile\\OrderHistory.properties"),"Payment method heading");
	sa.assertTrue(gVar.assertVisible("orderDetails_BillingAddress_Heading","Profile\\OrderHistory.properties"),"Billing address heading");
	sa.assertTrue(gVar.assertVisible("orderDetails_BillingAddress_section","Profile\\OrderHistory.properties"),"Billing address section");
	sa.assertTrue(gVar.assertVisible("orderDetails_Shipping_section","Profile\\OrderHistory.properties"),"Shipping address section");
	sa.assertTrue(gVar.assertVisible("orderDetails_Shipping_Heading","Profile\\OrderHistory.properties"),"Shipping address heading");
	
	log.info("Order Number should not be a link");
	if (l1.getWebElements("OrderHistory_Breadcrumb_Elements","Profile\\OrderHistory.properties").get(2).getAttribute("href")==null){
		log.info("OrderHistory breadcrumb is not a a link and it is static text");	
	}
	else{
		log.info("OrderHistory breadcrumb is a link and it is Not a static text");	
	}
	log.info("Navigate to order history page");
	l1.getWebElement("orderDetails_orderHistory_Breadcrumb","Profile\\OrderHistory.properties").click();
	log.info("Order History Heading");
	sa.assertTrue(l1.getWebElement("OrderHistory_Heading","Profile\\OrderHistory.properties").isDisplayed());
	
}

@Test(groups="{Regression}",description="124808")
public void TC03_ReturnToOrderHistoryLink() throws Exception
{
	
	log.info("click on order details button");
	l1.getWebElement("orderHistory_OrderDetailsButton","Profile\\OrderHistory.properties").click();
	log.info("return to order history link");
	sa.assertTrue(gVar.assertVisible("orderDetails_ReturntoOrderHistory","Profile\\OrderHistory.properties"),"Order Details return to order history");
	l1.getWebElement("orderDetails_ReturntoOrderHistory","Profile\\OrderHistory.properties").click();
	log.info("Order History Heading");
	sa.assertTrue(gVar.assertVisible("OrderHistory_Heading","Profile\\OrderHistory.properties"),"Order history heading");

}

@Test(groups="{Regression}",description="124810,124815")
public void TC04_ReturnToShoppingLink() throws Exception
{
	
	log.info("click on order details button");
	l1.getWebElement("orderHistory_OrderDetailsButton","Profile\\OrderHistory.properties").click();
	log.info("return to order history link");
	sa.assertTrue(gVar.assertVisible("orderDetails_ReturntoShopping","Profile\\OrderHistory.properties"),"Order Details return to shopping");
	l1.getWebElement("orderDetails_ReturntoShopping","Profile\\OrderHistory.properties").click();
	log.info("Order History Heading");
	sa.assertTrue(gVar.assertVisible("Homepage_Slides","ShopNav\\HomePage.properties"),"Home page");

}

@Test(groups="{Regression}",description="128536")
public void TC05_ProductNamelinkOrderDetailPage() throws Exception
{
	
	log.info("Click on MyAccount link in header as logged in user");
	l1.getWebElement("Header_MyAccount_Link","Profile\\MyAccountHome.properties").click();
	log.info("Click on orders link in my account page");
	l1.getWebElement("MyAccount_orders_link","Profile\\MyAccountHome.properties").click();
	log.info("click on order details button");
	l1.getWebElement("orderHistory_OrderDetailsButton","Profile\\OrderHistory.properties").click();
	log.info("click on product name link");
	String ProductNameinODPage=l1.getWebElement("orderDetails_ProductName","Profile\\OrderHistory.properties").getText();
	l1.getWebElement("orderDetails_ProductName","Profile\\OrderHistory.properties").click();
	log.info("Should navigate to PDP page");
	String ProductNameinPDPPage=l1.getWebElement("PDP_Product_Name","ShopNav\\PDP.properties").getText();
	sa.assertEquals(ProductNameinODPage, ProductNameinPDPPage);

}

@Test(groups="{Regression}",description="288929,288919")
public void TC05_LeftNavRegister() throws Exception
{

	   //left nav links     
		log.info("Take Count of left nav links");
	     int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
	     
	     for(int i=0;i<LeftNavLinksCount;i++)
	     {
	    		log.info("click on my account link");
	    		l1.getWebElement("MyAccountIcon","Profile\\MyAccountHome.properties").click();
	    		l1.getWebElement("MyAccount_Link","Profile\\MyAccountHome.properties").click();	
	    		log.info("click on order history in myaccount landing page");
	    		l1.getWebElement("OrderHistory_Link_AccountLandingPage","Profile\\OrderHistory.properties").click();
	            //click on left nav links 
	            log.info("Click on left nav link: "+i);
	            l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
	            
	            String Expected_LeftnavHeading = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 6);
	            String Expected_LeftnavBreadcrumb = GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", i+1, 7);
	            //verify the navigation
	            sa.assertEquals(gVar.assertEqual("PageHeadings", "Profile\\Wishlist.properties"), Expected_LeftnavHeading);
	            sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), Expected_LeftnavBreadcrumb);
	     }
 		log.info("click on my account link");
		l1.getWebElement("MyAccountIcon","Profile\\MyAccountHome.properties").click();
		l1.getWebElement("MyAccount_Link","Profile\\MyAccountHome.properties").click();	
		log.info("click on order history in myaccount landing page");
		l1.getWebElement("OrderHistory_Link_AccountLandingPage","Profile\\OrderHistory.properties").click();
	     log.info("Contact-US link");
	     l1.getWebElement("Wishlist_ContactUS_link", "Profile\\Wishlist.properties").click();
	     sa.assertEquals(gVar.assertEqual("Wishlist_ContactUS_Heading", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 6));
	     sa.assertEquals(gVar.assertEqual("PageBreadcrumb", "Profile\\Wishlist.properties"), GetData.getDataFromExcel("\\data\\ProfileData.xls", "WishList", 4, 7));
	     //It will return all the assertions
	     sa.assertAll();
		
}


@Test(groups="{Regression}",description="288838,288837,288927,288924,125909,GestUser")
public void TC05_OrderHistoryUIBreadcrumb() throws Exception
{
	log.info("log out from the application");
	p.Logout();
	log.info("click on check order in footer");
	l1.getWebElement("Footer_CheckOrder","ShopNav\\HomePage.properties").click();
	
	l1.getWebElement("orderDetails_OrderNum","Profile\\OrderHistory.properties").sendKeys(orderNumber);
	l1.getWebElement("orderDetails_OrderEmail","Profile\\OrderHistory.properties").sendKeys(orderEmail);
	l1.getWebElement("orderDetails_OrderPostal","Profile\\OrderHistory.properties").sendKeys(Zipcode);
	l1.getWebElement("orderDetails_CheckOrder_Button","Profile\\OrderHistory.properties").click();
	
	sa.assertTrue(gVar.assertVisible("orderDetails_ReturntoShopping","Profile\\OrderHistory.properties"),"Order Details return to shopping");
	sa.assertTrue(gVar.assertVisible("orderDetails_ReturntoOrderHistory","Profile\\OrderHistory.properties"),"Order Details return to order history");
	
	sa.assertTrue(gVar.assertVisible("orderDetails_Breadcrumb","Profile\\OrderHistory.properties"),"Order Details bread crumb");
	sa.assertTrue(gVar.assertVisible("orderDetails_LeftNav","Profile\\OrderHistory.properties"),"Order Details left nav");
	sa.assertTrue(gVar.assertVisible("orderDetails_OrderStatusLabel","Profile\\OrderHistory.properties"),"Order Details Status label");
	sa.assertTrue(gVar.assertVisible("orderDetails_OrderPlacedLabel","Profile\\OrderHistory.properties"),"Order Details orderplaced label");
	sa.assertTrue(gVar.assertVisible("orderDetails_PaymentMethod_Heading","Profile\\OrderHistory.properties"),"Payment method heading");
	sa.assertTrue(gVar.assertVisible("orderDetails_PaymentInstrumentsHeading","Profile\\OrderHistory.properties"),"Payment method heading");
	sa.assertTrue(gVar.assertVisible("orderDetails_BillingAddress_Heading","Profile\\OrderHistory.properties"),"Billing address heading");
	sa.assertTrue(gVar.assertVisible("orderDetails_BillingAddress_section","Profile\\OrderHistory.properties"),"Billing address section");
	sa.assertTrue(gVar.assertVisible("orderDetails_Shipping_section","Profile\\OrderHistory.properties"),"Shipping address section");
	sa.assertTrue(gVar.assertVisible("orderDetails_Shipping_Heading","Profile\\OrderHistory.properties"),"Shipping address heading");
	
	log.info("click on order details button");
	l1.getWebElement("orderHistory_OrderDetailsButton","Profile\\OrderHistory.properties").click();
	log.info("click on product name link");
	String ProductNameinODPage=l1.getWebElement("orderDetails_ProductName","Profile\\OrderHistory.properties").getText();
	l1.getWebElement("orderDetails_ProductName","Profile\\OrderHistory.properties").click();
	log.info("Should navigate to PDP page");
	String ProductNameinPDPPage=l1.getWebElement("PDP_Product_Name","ShopNav\\PDP.properties").getText();
	sa.assertEquals(ProductNameinODPage, ProductNameinPDPPage);
}

@Test(groups="{Regression}",description="288838,288837,288927,288924,GestUser")
public void TC03_OrderHistoryLeftNavGuest() throws Exception
{

	log.info("click on check order in footer");
	l1.getWebElement("Footer_CheckOrder","ShopNav\\HomePage.properties").click();

	log.info("Fectching all LeftNav Links");
	int LeftNavLinksCount=l1.getWebElements("LeftNav_Links","Profile\\login.properties").size();
	for (int i=0;i<LeftNavLinksCount;i++)
	{
		log.info("Displaying LeftNav Links");
		sa.assertTrue(l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).isDisplayed());
		log.info("Fetching LeftNav Links");
		//String leftNavLinks=l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).getText();
		log.info("Comparing LeftNav Links");
		//sa.assertEquals(leftNavLinks,(GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i,0)).toString());
		log.info("Clicking all LeftNav Links");
		l1.getWebElements("LeftNav_Links","Profile\\login.properties").get(i).click();
		log.info("Comparing Navigation headings");
		sa.assertEquals(l1.getWebElement("LeftNav_Headings","Profile\\Register.properties"),GetData.getDataFromExcel("\\data\\ProfileData.xls","LeftNav",i,0));
		log.info("Click on home page logo");
		l1.getWebElement("HomePage_Logo","Profile\\login.properties").click();
		log.info("click on check order in footer");
		l1.getWebElement("Footer_CheckOrder","ShopNav\\HomePage.properties").click();
	}
	
	log.info("Fetching all LeftNav Headings");
	int LeftNavHeadings=l1.getWebElements("LeftNav_Headings","Profile\\login.properties").size();
	for (int i=0;i<LeftNavHeadings;i++)
	{
		log.info("Display of LeftNav Headings");
		l1.getWebElements("LeftNav_Headings","Profile\\login.properties").get(i).click();
	}
	
	log.info("Left Nav Help Text");
	sa.assertTrue(l1.getWebElement("LeftNav_Needhelp_Text","Profile\\Register.properties").isDisplayed());
	log.info("assert all");
	sa.assertAll();
	
}

//288884,288902

}