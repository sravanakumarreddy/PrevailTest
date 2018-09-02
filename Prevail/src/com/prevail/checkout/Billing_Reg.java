package com.prevail.checkout;


import org.testng.annotations.Test;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.CheckoutIlpPOM;
import com.prevail.pom.OrderConfirmationPOM;
import com.prevail.pom.OrderreviewPOM;
import com.prevail.pom.PaymentPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class Billing_Reg extends BaseTest {
	
String ProductNameinOrderSummarySection;
String ProductNameinCartPage;
String OS_Subtotal;
String OS_ShippingValue;
String OS_SalesTax;
String ShippingBillingbutton;
	
@Test(groups="{Regression}",description="148873")
public void TC00_usethisaddressforBilling() throws Exception
{
	
	log.info("Login");
	p.loginToAppliction();
	log.info("Navigate to shipping page");
	checkout.NavigateToShippingPage();
	log.info("Entering shipping address");
	checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
	log.info("Entering shipping address");
	gVar.SelectCheckbox(ShippingPOM.ShippingPage_SameasBilling_Checkbox);
	log.info("Save address in profile");
	gVar.SelectCheckbox(ShippingPOM.ShippingPage_AddtoAddressbook_Checkbox);
	log.info("Click on continue button");
	l1.getWebElements(ShippingPOM.Shipping_ContinueToBilling_Button).get(0).click();
	log.info("Verifying the billing heading");
	l1.getWebElement(BillingPOM.billingPage_Heading).isDisplayed();
	log.info("Verifying shipping and billing values");
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_FN_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,1));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_LN_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,2));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_Address1_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,3));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_Address2_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,4));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_City_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,5));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_ZipCode_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,6));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_Country_Dropdown),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,7));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_State_Dropdown),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,8));
	sa.assertEquals(gVar.assertEqual(BillingPOM.billingPage_Phone_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,9));

}

@Test(groups="{Regression}",description="148974")
public void TC01_EditlinkOrderReviewpage() throws Exception
{
	
	log.info("Fetching product name in order summary section shipping page");
	ProductNameinOrderSummarySection=l1.getWebElement(ShippingPOM.Shipping_orderSummary_productName).getText();
	log.info("OCP Product Name"+ProductNameinOrderSummarySection);
	l1.getWebElement(BillingPOM.billingPage_ordersummary_editlink).click();
	log.info("Should navigate to cart page");
	ProductNameinCartPage=l1.getWebElement(CartPOM.cartProductName).getText();
	sa.assertEquals(ProductNameinOrderSummarySection, ProductNameinCartPage);
	log.info("navigate back to shipping page");
	l1.getWebElement(CartPOM.cartCheckoutbuttonTop).click();
try {
		
		log.info("Clicking on checkout as a guest button");
		l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
		log.info("Shipping page Heading");
		l1.getWebElement(ShippingPOM.ShippingPage_Heading).isDisplayed();
		
		
	} catch (Exception e) {
		
		log.info("Shipping page Heading");
		l1.getWebElement(ShippingPOM.ShippingPage_Heading).isDisplayed();
		
	}

log.info("Click on continue button in shipping");
l1.getWebElements(ShippingPOM.Shipping_ContinueToBilling_Button).get(0).click();
	

}
	
@Test(groups="{Regression}",description="128301")
public void TC00_navigatetoOrderReviewpage() throws Exception
{
	
	log.info("Enter email ID");
	l1.getWebElement(BillingPOM.billingPage_Email_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,10));
	log.info("Navigate to shipping page");
	checkout.PaymentDetails("//data//Checkout.xls","PaymentDetails",1);
	log.info("click on continue button ib billing page");
	l1.getWebElement(PaymentPOM.Payment_PlaceOrderButton).click();
	try {
		
		sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingaddressValidationDialogue));
		l1.getWebElement(ShippingPOM.shippingaddressValidationContinue).click();
		l1.getWebElement(OrderreviewPOM.OrderReview_placeOrderButton).isDisplayed();
		
	} catch (Exception e) {
		
		l1.getWebElement(OrderreviewPOM.OrderReview_placeOrderButton).isDisplayed();
		log.info("Navigated to billing page");
	}
	
	sa.assertAll();
	
}

@Test(groups="{Regression}",description="124446")
public void TC01_navigatetoOrderReviewpage() throws Exception
{
	
	log.info("Enter email ID in billing page");
	l1.getWebElement(BillingPOM.billingPage_Email_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,10));
	log.info("Entering payment details");
	checkout.PaymentDetails("//data//Checkout.xls","PaymentDetails",1);
	log.info("click on save card checkbox in payment page");
	gVar.SelectCheckbox(BillingPOM.billingPage_paymentSaveCardCheckbox);
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
	l1.getWebElement(OrderConfirmationPOM.orderconfirmation_Heading);
	log.info("Navigate to profile payment page click on my account icon");
	l1.getWebElement("MyAccountIcon","Profile\\MyAccountHome.properties").click();
	log.info("Click on payment icon in my account landing page");
	l1.getWebElements("PaymentSettings_Link_MyaccountLandingPage","Profile\\PaymentSettings.properties");
	log.info("Comparing card owners name");
	sa.assertEquals(l1.getWebElement("PaymentSettings_Ownername","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromExcel("//data//Checkout.xls","PaymentDetails",1,1),"Card owner name");
	sa.assertEquals(l1.getWebElement("PaymentSettings_CardType","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromExcel("//data//Checkout.xls","PaymentDetails",1,2),"Card type");
	sa.assertEquals(l1.getWebElement("PaymentSettings_CardNumber","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromExcel("//data//Checkout.xls","PaymentDetails",1,3),"Card Number");
	sa.assertEquals(l1.getWebElement("PaymentSettings_Expiredate","Profile\\PaymentSettings.properties").getText(),GetData.getDataFromExcel("//data//Checkout.xls","PaymentDetails",1,4),"Expiredate");
	sa.assertTrue(gVar.assertVisible("PaymentSettings_DeleteCard","Profile\\PaymentSettings.properties"));
	
	sa.assertAll();

}


@Test(groups="{Regression}",description="124437")
public void TC00_saveaddresstoaddressbook() throws Exception
{
	
	log.info("Navigate to profile payment page click on my account icon");
	l1.getWebElement("MyAccountIcon","Profile\\MyAccountHome.properties").click();
	log.info("Click on Address link");
	l1.getWebElement("Address_Link_AccountLandingPage","Profile\\Addresses.properties").click();
	log.info("Delete address");
	p.DeleteAddress();
	log.info("Navigate to shipping page");
	checkout.NavigateToBillingPage();
	log.info("Enter billing address");
	checkout.BillingAddress("//data//Checkout.xls","BillingAddress",1);
	log.info("click onAdd to address book");
	gVar.SelectCheckbox(BillingPOM.billingPage_addtoaddress_checkbox);
	log.info("Entering payment details");
	checkout.PaymentDetails("//data//Checkout.xls","PaymentDetails",1);
	log.info("click on continue button ib billing page");
	l1.getWebElement(PaymentPOM.Payment_PlaceOrderButton).click();
	log.info("click on place order button in order review page");
	l1.getWebElement(OrderreviewPOM.OrderReview_placeOrderButton).click();
	log.info("Order confirmation page heading");
	l1.getWebElement(OrderConfirmationPOM.orderconfirmation_Heading).click();
	log.info("Navigate to profile payment page click on my account icon");
	l1.getWebElement("MyAccountIcon","Profile\\MyAccountHome.properties").click();
	log.info("Click on Address link");
	l1.getWebElement("Address_Link_AccountLandingPage","Profile\\Addresses.properties").click();
	sa.assertEquals(gVar.assertEqual("Address_DefaultAddress", "Profile\\Addresses.properties").toString(), GetData.getDataFromExcel("\\data\\Checkout.xls","BillingAddress",1,12));
	
	sa.assertAll();
	
}


@Test(groups="{Regression}",description="148884")
public void TC00_Privacypolicylink() throws Exception
{
	
log.info("click on Privacy Policy Button");
l1.getWebElement(BillingPOM.billingPage_PrivacyPolicy).click();
log.info("Privacy Policy Overlay");
sa.assertTrue(l1.getWebElement(BillingPOM.billingPagePrivacyPolicy_Overlay).isDisplayed());
log.info("Privacy Policy heading");
sa.assertTrue(l1.getWebElement(BillingPOM.billingPage_PrivacyPolicy_heading).isDisplayed());
log.info("Register Privacy Policy overlay close button");
l1.getWebElement(BillingPOM.billingPage_PrivacyPolicy_CloseButton).click();
log.info("navigate back to billing page");
sa.assertAll();
	
}


@Test(groups="{Regression}",description="289867,289868")
public void TC00_ShippingAccordion() throws Exception
{
	
log.info("click on Shipping Accordion from billing page");
l1.getWebElement(BillingPOM.shippingAccordion).click();
log.info("Should Naviagte to shipping page");
sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_ordersummary_section));

}


@Test(groups="{Regression}",dataProvider="BillingValidations",description="124445,")
public void TC15_ShippingValidations(TestData t) throws Exception
{
	
	log.info("Validations for shipping page");
	checkout.NavigateToShippingPage();
	
	log.info("Clear fiels of billing page after every entry");
	l1.getWebElement(BillingPOM.billingPage_FN_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_LN_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_City_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).clear();
	l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).clear();
	
	log.info("Clear fiels of payment page after every entry");
	l1.getWebElement(BillingPOM.billingPage_paymentNameonCard).clear();
	l1.getWebElement(BillingPOM.billingPage_paymentCardnumber).clear();
	l1.getWebElement(BillingPOM.billingPage_paymentSecurityCode).clear();

	l1.getWebElement(BillingPOM.billingPage_FN_TextBox).sendKeys(t.get(0));
	l1.getWebElement(BillingPOM.billingPage_LN_TextBox).sendKeys(t.get(1));	
	l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).sendKeys(t.get(2));	
	l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).sendKeys(t.get(3));
	l1.getWebElement(BillingPOM.billingPage_City_TextBox).sendKeys(t.get(4));	
	l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).sendKeys(t.get(5));
	gVar.handlingDropdown(BillingPOM.billingPage_Country_Dropdown,t.get(6));
	gVar.handlingDropdown(BillingPOM.billingPage_State_Dropdown,t.get(7));
	l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).sendKeys(t.get(8));
	
	log.info("Entering payment details");
	checkout.PaymentDetails("//data//Checkout.xls","PaymentDetails",1);
	
	if (i==0){
	
	l1.getWebElement(BillingPOM.billingPage_continue_button).click();	
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_FN_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_LN_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_City_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));

	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_FN_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","billingPage_FN_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_LN_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","billingPage_LN_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","billingPage_Address1_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","billingPage_City_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_City_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","billingPage_State_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","billingPage_Zipcode_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","billingPage_Phone_Blank_ErrorMessage"));

	}
	
	else if (i==1){
		
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_FN_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_LN_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_City_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));

	}
	
	else if (i==2 || i==3 || i==4){
		
	l1.getWebElement(BillingPOM.billingPage_continue_button).click();
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","BillingPage_ValidZipcode_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","BillingPage_Phone_ErrorMessage"));
		
	}
	
	else
	{
		log.info("Entering shipping address");
		checkout.ShippingAddress("//data//Checkout.xls","BillingAddress",1);
		log.info("Click on billing continue button");
		l1.getWebElement(BillingPOM.billingPage_continue_button).click();	
		log.info("Verifying the billing heading");
		l1.getWebElement(BillingPOM.billingPage_Heading).isDisplayed();
	}
		

	
	}


}
