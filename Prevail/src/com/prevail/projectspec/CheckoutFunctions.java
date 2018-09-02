package com.prevail.projectspec;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.CheckoutIlpPOM;
import com.prevail.pom.MultiShippingPOM;
import com.prevail.pom.OrderConfirmationPOM;
import com.prevail.pom.OrderreviewPOM;
import com.prevail.pom.PaymentPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class CheckoutFunctions extends BaseTest {

	public String productQuantityinCart;
	public String orderTotalInBillingPage;
	
public void NavigateToILPPage() throws Exception
{
	
	BaseTest.cart.navigateToCart();
	Thread.sleep(2000);
	productQuantityinCart=BaseTest.l1.getWebElement(CartPOM.cartQuantity).getAttribute("value");
	BaseTest.log.info("Click on checkout button top");
	BaseTest.l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	
}
	
public void NavigateToShippingPage() throws Exception
{
	BaseTest.cart.navigateToCart();
	Thread.sleep(2000);
	BaseTest.log.info("Click on checkout button top");
	BaseTest.l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	BaseTest.log.info("Verifying Shipping Page Heading");
	try {
		
		BaseTest.log.info("Clicking on checkout as a guest button");
		l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
		Thread.sleep(4000);
		BaseTest.log.info("Shipping page Heading1");
		//sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading),"Shipping page Heading");
		
		
	} catch (Exception e) {
		
		BaseTest.log.info("Shipping page Heading2");
		//sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
		
	}
	sa.assertAll();
	
}

public void NavigateToBillingPage() throws Exception
{
	BaseTest.cart.navigateToCart();
	Thread.sleep(2000);
	BaseTest.log.info("Click on checkout button top");
	BaseTest.l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	BaseTest.log.info("Verifying Shipping Page Heading");
	try {
		
		BaseTest.log.info("Clicking on checkout as a guest button");
		l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
		BaseTest.log.info("Shipping page Heading");
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
		
	} catch (Exception e) {
		
		BaseTest.log.info("Shipping page Heading");
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
		
	}
	
	log.info("Enter shipping address");
	checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
	
	log.info("Click on continue button");
	l1.getWebElements(ShippingPOM.Shipping_ContinueToBilling_Button).get(0).click();
	
	try {
		
		sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingaddressValidationDialogue));
		BaseTest.l1.getWebElement(ShippingPOM.shippingaddressValidationContinue).click();
		BaseTest.l1.getWebElement(BillingPOM.billingPage_Heading).isDisplayed();
		
	} catch (Exception e) {
		BaseTest.l1.getWebElement(BillingPOM.billingPage_Heading).isDisplayed();
		log.info("Navigated to billing page");
	}
	
	orderTotalInBillingPage=BaseTest.l1.getWebElement(BillingPOM.BillingPage_OrderTotal).getText().replace("$","");
	
	sa.assertAll();
	
	
}

public void NavigateToOrderConfirmationPage() throws Exception
{
	
	BaseTest.checkout.NavigateToBillingPage();
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
	sa.assertAll();
	
}

	
public void ShippingAddress(String Excel,String SheetName,int Row) throws Exception
{

	BaseTest.log.info("Enter shipping address First Name");
	BaseTest.l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,1));
	BaseTest.log.info("Enter shipping address Last Name");
	BaseTest.l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,2));
	BaseTest.log.info("Enter shipping address Address1 Name");
	BaseTest.l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,3));
	BaseTest.log.info("Enter shipping address Address2 Name");
	BaseTest.l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,4));
	BaseTest.log.info("Enter shipping address City Name");
	BaseTest.l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,5));
	BaseTest.log.info("Enter shipping address ZipCode Name");
	BaseTest.l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,6));
	BaseTest.log.info("Enter shipping address Country Name");
	BaseTest.gVar.handlingDropdown(ShippingPOM.ShippingPage_Country_Dropdown,GetData.getDataFromExcel(Excel,SheetName,Row,7));
	BaseTest.log.info("Enter shipping address State Name");
	BaseTest.gVar.handlingDropdown(ShippingPOM.ShippingPage_State_Dropdown,GetData.getDataFromExcel(Excel,SheetName,Row,8));
	BaseTest.log.info("Enter shipping address Phone");
	BaseTest.l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,9));

}

public void MPC_ShippingAddress(String Excel,String SheetName,int Row) throws Exception
{

	BaseTest.log.info("Enter shipping address First Name");
	BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,1));
	BaseTest.log.info("Enter shipping address Last Name");
	BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Textbox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,2));
	BaseTest.log.info("Enter shipping address Address1 Name");
	BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,3));
	BaseTest.log.info("Enter shipping address Address2 Name");
	BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address2_Textbox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,4));
	BaseTest.log.info("Enter shipping address City Name");
	BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,5));
	BaseTest.log.info("Enter shipping address ZipCode Name");
	BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,6));
	Thread.sleep(3000);
	BaseTest.log.info("Enter shipping address Country Name");
	BaseTest.gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_Country_Textbox,GetData.getDataFromExcel(Excel,SheetName,Row,7));
	Thread.sleep(3000);
	BaseTest.log.info("Enter shipping address State Name");
	BaseTest.gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_State_Textbox,GetData.getDataFromExcel(Excel,SheetName,Row,8));
	Thread.sleep(3000);
	BaseTest.log.info("Enter shipping address Phone");
	BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,9));

	try {
		l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_AddToAddress_Checkbox).isDisplayed();
		l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_AddToAddress_Checkbox).click();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Add to Address checkbox not displayed : Guest User");
	}
	BaseTest.log.info("Click on Save button");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Save_Button).click();
	Thread.sleep(4000);
}

public void BillingAddress(String Excel,String SheetName,int Row) throws Exception
{
	
	BaseTest.log.info("Enter billing address First Name");
	BaseTest.l1.getWebElement(BillingPOM.billingPage_FN_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,1));
	BaseTest.log.info("Enter billing address Last Name");
	BaseTest.l1.getWebElement(BillingPOM.billingPage_LN_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,2));
	BaseTest.log.info("Enter billing address Address1 Name");
	BaseTest.l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,3));
	BaseTest.log.info("Enter billing address Address2 Name");
	BaseTest.l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,4));
	BaseTest.log.info("Enter billing address City Name");
	BaseTest.l1.getWebElement(BillingPOM.billingPage_City_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,5));
	BaseTest.log.info("Enter billing address ZipCode Name");
	BaseTest.l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,6));
	BaseTest.log.info("Enter billing address Country Name");
	BaseTest.gVar.handlingDropdown(BillingPOM.billingPage_Country_Dropdown,GetData.getDataFromExcel(Excel,SheetName,Row,7));
	BaseTest.log.info("Enter billing address State Name");
	BaseTest.gVar.handlingDropdown(BillingPOM.billingPage_State_Dropdown,GetData.getDataFromExcel(Excel,SheetName,Row,8));
	BaseTest.log.info("Enter billing address Phone");
	BaseTest.l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,9));

}

public void PaymentDetails(String Excel,String SheetName,int Row) throws Exception
{
	BaseTest.l1.getWebElement("Payment_NameOnCard_Textbox","Checkout\\Payment.properties").sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,1));
	BaseTest.gVar.handlingDropdown("Payment_Type_Dropdown","Checkout\\Payment.properties",GetData.getDataFromExcel(Excel,SheetName,Row,2));
	BaseTest.l1.getWebElement("Payment_Number_Textbox","Checkout\\Payment.properties").sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,3));
	BaseTest.gVar.handlingDropdown("Payment_Expiration_Month_Dropdown","Checkout\\Payment.properties",GetData.getDataFromExcel(Excel,SheetName,Row,4));
	BaseTest.gVar.handlingDropdown("Payment_Expiration_Year_Dropdown","Checkout\\Payment.properties",GetData.getDataFromExcel(Excel,SheetName,Row,5));
	BaseTest.l1.getWebElement("Payment_Security_Textbox","Checkout\\Payment.properties").sendKeys(GetData.getDataFromExcel(Excel,SheetName,Row,6));

}

public void Shippingfieldsclear() throws Exception
{
	l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).clear();
}

public void Billingfieldsclear() throws Exception
{
	l1.getWebElement(BillingPOM.billingPage_FN_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_LN_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_City_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).clear();
}


}
