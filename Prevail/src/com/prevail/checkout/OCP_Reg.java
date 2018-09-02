package com.prevail.checkout;

import org.testng.annotations.Test;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.MultiShippingPOM;
import com.prevail.pom.OrderConfirmationPOM;
import com.prevail.pom.OrderreviewPOM;
import com.prevail.pom.PaymentPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class OCP_Reg extends BaseTest{
	
@Test(groups="{Regression}",description="125884,148937")
public void TC00_navigateToOrderConfirmationPOMPage() throws Exception
{

log.info("Login");
p.loginToAppliction();	
log.info("Navigate to order confirmation page");
checkout.NavigateToOrderConfirmationPage();
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_order_date_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_order_number_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_order_date));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_order_number));

}

@Test(groups="{Regression}",description="125907")
public void TC01_uiOfShipment1Section() throws Exception
{
	
log.info("Navigate to order confirmation page");
checkout.NavigateToOrderConfirmationPage();
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipment1_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_product_link));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_item_number_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_sku));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_sku_div));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_product_details_div));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_line_item_quantity));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_line_item_price));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_product_details_div));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_address));

//verifying address
sa.assertEquals(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,12), l1.getWebElement(OrderConfirmationPOM.order_confirmation_shipping_address).getText());

sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_return_to_shopping_link));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_status_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_status));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_method_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_method));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_div));


}

@Test(groups="{Regression}",description="148897")
public void TC02_detailsDisplayedInPaymentMethod() throws Exception
{
		
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_payment_div));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_payment_type));
sa.assertEquals("Credit Card",l1.getWebElement(OrderConfirmationPOM.order_confirmation_payment_type).getText());
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_payment_div));

}

@Test(groups="{Regression}",description="148897")
public void TC03_DisplayOfPaymentTotalbutton() throws Exception
{
	
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_payment_total_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_subtotal_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_charges_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_sales_tax));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_order_total));
sa.assertEquals(l1.getWebElement(OrderConfirmationPOM.order_confirmation_subtotalvalue).getText().replace("$",""),l1.getWebElement(ShippingPOM.shippingOrderSummarysubtotalValue).getText().replace("$",""),"Comparing price");
sa.assertEquals(l1.getWebElement(OrderConfirmationPOM.order_confirmation_sales_taxValue).getText().replace("$",""),l1.getWebElement(ShippingPOM.shippingOrderSummarySalestaxValue).getText().replace("$",""),"Comparing price");
sa.assertEquals(l1.getWebElement(OrderConfirmationPOM.order_confirmation_ordertotal_value).getText().replace("$",""),l1.getWebElement(ShippingPOM.shippingOrderSummarOrderValue).getText().replace("$",""),"Comparing price");

}


@Test(groups="{Regression}",description="148895")
public void TC04_ShippingAddressComparison() throws Exception
{
		
log.info("Comparing the shipping address");
sa.assertEquals(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,12), l1.getWebElement(OrderConfirmationPOM.order_confirmation_shipping_addressMain).getText());

}

@Test(groups="{Regression}",description="148896")
public void TC05_BillingAddressComparison() throws Exception
{
		
log.info("Comparing the shipping address");
sa.assertEquals(GetData.getDataFromExcel("//data//Checkout.xls","BillingAddress",1,12), l1.getWebElement(OrderConfirmationPOM.order_confirmation_billing_address).getText());

}

@Test(groups="{Regression}",description="148894")
public void TC06_ProductLineitemDetails() throws Exception
{

sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_product_link));
sa.assertEquals(p.PDP_Pname, l1.getWebElement(OrderConfirmationPOM.order_confirmation_product_link).getText());
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_sku));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_shipping_charges_heading));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_line_item_quantity));
sa.assertEquals(checkout.productQuantityinCart, l1.getWebElement(OrderConfirmationPOM.order_confirmation_line_item_quantity).getText());
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_line_item_price));
sa.assertEquals(cart.CartProductPrice, l1.getWebElement(OrderConfirmationPOM.order_confirmation_line_item_price).getText().replace("$",""));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_order_total));
sa.assertEquals(checkout.orderTotalInBillingPage, l1.getWebElement(OrderConfirmationPOM.order_confirmation_order_total).getText().replace("$",""));

}

@Test(groups="{Regression}",description="125783")
public void TC06_ProductNameLinkinOCPPage() throws Exception
{

log.info("Product link in ocp page");
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_product_link));
log.info("get text of Product link in ocp page");
String ProductName=l1.getWebElement(OrderConfirmationPOM.order_confirmation_product_link).getText();
log.info("click on Product link in ocp page");
l1.getWebElement(OrderConfirmationPOM.order_confirmation_product_link).click();
log.info("PDP Product link in ocp page");
sa.assertTrue(gVar.assertVisible("PDP_Product_Name", "ShopNav\\PDP.properties"));
log.info("get Text of Product link in ocp page");
String ProdNameInPDP=l1.getWebElement("PDP_Product_Name", "ShopNav\\PDP.properties").getText();
sa.assertEquals(ProductName, ProdNameInPDP);

}

@Test(groups="{Regression}",description="125905,148899")
public void TC06_Returntoshoppingbutton() throws Exception
{

log.info("Navigate to order confirmation page");
checkout.NavigateToOrderConfirmationPage();
log.info("Fetch order confirmation number");
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_order_number));  
String orderNumber=l1.getWebElement(OrderConfirmationPOM.order_confirmation_order_number).getText();
log.info("Fetch order confirmation number"+orderNumber);
l1.getWebElement(OrderConfirmationPOM.order_confirmation_return_to_shopping_link).click();
log.info("Navigate to home page");
sa.assertTrue(gVar.assertVisible("HomePage_Logo","ShopNav\\HomePage.properties"),"Home page");

}

@Test(groups="{Regression}",description="125925")
public void TC06_MultiShippinginOCPpage() throws Exception
{

cart.ClearCartItems();
log.info("Navigate to Address Page");
p.NavigateToAddressPage();
Thread.sleep(2000);
p.DeleteAddress();
//navigate to shipping page
log.info("Add 2 products to cart");
cart.navigateToCart("2");
log.info("Click on checkout button top");
l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
Thread.sleep(2000);
log.info("Shipping page Heading");
sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
//click on yes button 'Do you want multishipping' 
log.info("click on yes button 'Do you want multishipping");
l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
Thread.sleep(2000);
log.info("To verify Shipping Address should not be displayed on Right Nav");
sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_OrderSummary_FirstShippingAddress_Block),"Address block should not be displayed");
sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Shipping_Single_Address_Text),"ship-to-single button displayed");
log.info("Multi shipping address entering");
int addrCount=0;
//adding addresses
for(int i=0;i<2;i++)
{
	log.info("Click on ADD/Edit Address Link: "+i);
	l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(i).click();
	
	log.info("Entering shipping address");
	checkout.MPC_ShippingAddress("//data//Checkout.xls","ShippingAddress",i+1);
	addrCount++;
}
//select addresses from drop down 
int dropDowns=l1.getWebElements(MultiShippingPOM.MultiShipping_Address_Dropdown).size();
int c1=1;
int j=1;

for(int i=0;i<dropDowns;i++)
	{
	   if(c1>addrCount)
	    {
	      c1=1;
	    }
	   gVar.handlingDropdown(MultiShippingPOM.MultiShipping_Address_Dropdown,i,j);
	//_setselected(_select("dwfrm_multishipping_addressSelection_quantityLineItems_i"+$i+"_addressList"),$j);
	j++;
	}



log.info("multi shipping save button");
l1.getWebElement(MultiShippingPOM.MultiShipping_Continue_To_Billing_Button).click();

log.info("Enter Billing address");
checkout.BillingAddress("//data//Checkout.xls","BillingAddress",1);
log.info("Enter email ID in billing page");
l1.getWebElement(BillingPOM.billingPage_Email_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","BillingAddress",1,10));
log.info("Entering payment details");
checkout.PaymentDetails("//data//Checkout.xls","PaymentDetails",1);
log.info("click on continue button ib billing page");
l1.getWebElement(PaymentPOM.Payment_PlaceOrderButton).click();

try {
	
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingaddressValidationDialogue));
	l1.getWebElement(ShippingPOM.shippingaddressValidationContinue).click();
	l1.getWebElement(OrderreviewPOM.OrderReview_placeOrderButton).isDisplayed();
	
} catch (Exception e) {
	
	log.info("Navigated to billing page");
	l1.getWebElement(OrderreviewPOM.OrderReview_placeOrderButton).isDisplayed();
	
}

log.info("click on place order button");
l1.getWebElement(OrderreviewPOM.OrderReview_placeOrderButton).click();

log.info("Order confirmation heading");
l1.getWebElement(OrderConfirmationPOM.order_confirmation_heading);


}



}
