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
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class OCP_Guest extends BaseTest {
	

	
@Test(groups="{Regression}",description="126735,149023,289059")
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

@Test(groups="{Regression}",description="289068")
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

@Test(groups="{Regression}",description="149021")
public void TC02_detailsDisplayedInPaymentMethod() throws Exception
{
		
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_payment_div));
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_payment_type));
sa.assertEquals("Credit Card",l1.getWebElement(OrderConfirmationPOM.order_confirmation_payment_type).getText());
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_payment_div));

}

@Test(groups="{Regression}",description="149022")
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


@Test(groups="{Regression}",description="149019")
public void TC04_ShippingAddressComparison() throws Exception
{
		
log.info("Comparing the shipping address");
sa.assertEquals(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,12), l1.getWebElement(OrderConfirmationPOM.order_confirmation_shipping_addressMain).getText());

}

@Test(groups="{Regression}",description="149020")
public void TC05_BillingAddressComparison() throws Exception
{
		
log.info("Comparing the shipping address");
sa.assertEquals(GetData.getDataFromExcel("//data//Checkout.xls","BillingAddress",1,12), l1.getWebElement(OrderConfirmationPOM.order_confirmation_billing_address).getText());

}

@Test(groups="{Regression}",description="149018")
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

@Test(groups="{Regression}",description="126738")
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


@Test(groups="{Regression}",description="288378")
public void TC06_CreateAccountSectioninOCPPage() throws Exception
{

log.info("Product link in ocp page");
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_heading),"OCP create account section");
sa.assertTrue(gVar.assertVisible(OrderConfirmationPOM.order_confirmation_create_account_heading),"OCP create account heading");
log.info("Register FN Label");
sa.assertTrue(l1.getWebElement("Register_FN_Label", "Profile\\Register.properties").isDisplayed());
log.info("Register LN Label");
sa.assertTrue(l1.getWebElement("Register_LN_Label", "Profile\\Register.properties").isDisplayed());
log.info("Register Email Label");
sa.assertTrue(l1.getWebElement("Register_Email_Label", "Profile\\Register.properties").isDisplayed());
log.info("Register ConfirmEmail Label");
sa.assertTrue(l1.getWebElement("Register_ConfirmEmail_Label", "Profile\\Register.properties").isDisplayed());
log.info("Register Password Label");
sa.assertTrue(l1.getWebElement("Register_Password_Label", "Profile\\Register.properties").isDisplayed());
log.info("Register ConfirmPassword Label");
sa.assertTrue(l1.getWebElement("Register_ConfirmPassword_Label", "Profile\\Register.properties").isDisplayed());
log.info("Register FirstName textbox");
sa.assertTrue(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").isDisplayed());
log.info("Register LastName textbox");
sa.assertTrue(l1.getWebElement("Register_LastName", "Profile\\Register.properties").isDisplayed());
log.info("Register EmailID textbox");
sa.assertTrue(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").isDisplayed());
log.info("Register RegisterConfirmEmail textbox");
sa.assertTrue(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").isDisplayed());
log.info("Register Register Password textbox");
sa.assertTrue(l1.getWebElement("Register_Password", "Profile\\Register.properties").isDisplayed());
log.info("Register Register ConfirmPassword textbox");
sa.assertTrue(l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").isDisplayed());
log.info("Register Register ApplyButton");
sa.assertTrue(l1.getWebElement("Register_ApplyButton", "Profile\\Register.properties").isDisplayed());

}

@Test(groups="{Regression}",description="126741_126743_149024_149025_126742_126740_126736",dataProvider="register",dataProviderClass=Data.class)
public void Register_Validations(TestData t) throws Exception
{
	
		log.info("Clear fielsd after every entry");
		p.ClearFieldsRegister();
		
		log.info("fetching data from data providers");
		l1.getWebElement("Register_FirstName", "Profile\\Register.properties").sendKeys(t.get(0));
		l1.getWebElement("Register_LastName", "Profile\\Register.properties").sendKeys(t.get(1));
		l1.getWebElement("Register_EmailID", "Profile\\Register.properties").sendKeys(t.get(2));
		l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").sendKeys(t.get(3));
		l1.getWebElement("Register_Password", "Profile\\Register.properties").sendKeys(t.get(4));
		l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").sendKeys(t.get(5));
		l1.getWebElement("Register_ApplyButton","Profile\\Register.properties").click();
		
		
		if (i==0){
			log.info("Blank Field Validation"+i);
			sa.assertEquals(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_LastName", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_Password", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			sa.assertEquals(l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,0));
			//Error Messages
			sa.assertEquals(l1.getWebElement("Register_FirstName_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","FN_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_LastName_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","LN_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_Email_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmEmail_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("Register_Password_Errormessage", "Profile\\Register.properties").get(0).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Password_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElements("Register_Password_Errormessage", "Profile\\Register.properties").get(1).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmPassword_BlankField_ErrorMessage"));
		}
		
		else if (i==1){
			log.info("length Validation"+i);
			sa.assertEquals(l1.getWebElement("Register_FirstName", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,1));
			sa.assertEquals(l1.getWebElement("Register_LastName", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,2));
			sa.assertEquals(l1.getWebElement("Register_EmailID", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,3));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,4));
			sa.assertEquals(l1.getWebElement("Register_Password", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,5));
			sa.assertEquals(l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").getText().length(),GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",1,6));
		}
		
		else if(i==2 || i==3 || i==4){
			log.info("Email and confirm email error fields"+i);
			sa.assertEquals(l1.getWebElement("Register_Email_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Email_BlankField_ErrorMessage"));
			sa.assertEquals(l1.getWebElement("Register_ConfirmEmail_Errormessage", "Profile\\Register.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ConfirmEmail_BlankField_ErrorMessage"));
		}
		else{
			
			log.info("Create account with valid data"+i);
			sa.assertTrue(l1.getWebElement("Register_LoginConfirmation", "Profile\\Register.properties").isDisplayed());
		}
	}


@Test(groups="{Regression}",description="126754")
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
sa.assertTrue(gVar.assertVisible("HomePage_Logo","ShopNav\\HomePage.properties"));

}

@Test(groups="{Regression}",description="289069")
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
