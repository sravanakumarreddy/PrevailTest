package com.prevail.checkout;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.CheckoutIlpPOM;
import com.prevail.pom.OrderreviewPOM;
import com.prevail.pom.PaymentPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class Billing_Guest extends BaseTest{
	
	
String ProductNameinOrderSummarySection;
String ProductNameinCartPage;
String OS_Subtotal;
String OS_ShippingValue;
String OS_SalesTax;
String ShippingBillingbutton;
	
@Test(groups="{Regression}",description="128299")
public void TC00_usethisaddressforBilling() throws Exception
{

	log.info("Navigate to shipping page");
	checkout.NavigateToShippingPage();
	log.info("Entering shipping address");
	checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
	log.info("Entering shipping address");
	gVar.SelectCheckbox(ShippingPOM.ShippingPage_SameasBilling_Checkbox);
	Thread.sleep(5000);
	log.info("Click on continue button");
	l1.getWebElements(ShippingPOM.Shipping_ContinueToBilling_Button).get(0).click();
	log.info("Verifying the billing heading");
	l1.getWebElement(BillingPOM.billingPage_Heading).isDisplayed();
	Thread.sleep(5000);
	log.info("Verifying shipping and billing values");
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_FN_TextBox).getAttribute("value"),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,1),"FirstName Comparison");
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_LN_TextBox).getAttribute("value"),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,2),"Last Comparison");
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address1_TextBox).getAttribute("value").toLowerCase(),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,3),"Address1 comparison");
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Address2_TextBox).getAttribute("value"),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,4),"Address2 Comparison");
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_City_TextBox).getAttribute("value").toLowerCase(),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,5),"City Comparison");
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_ZipCode_TextBox).getAttribute("value"),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,6),"Zipcode Comparison");
	sa.assertEquals(gVar.fetchingOptionfromDropdown(BillingPOM.billingPage_Country_Dropdown),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,7),"Country comparison");
	sa.assertEquals(gVar.fetchingOptionfromDropdown(BillingPOM.billingPage_State_Dropdown),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,8),"State comparison");
	sa.assertEquals(l1.getWebElement(BillingPOM.billingPage_Phone_TextBox).getAttribute("value"),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,9),"phone comparison");

	sa.assertAll();
	
}


@Test(groups="{Regression}",description="148973")
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
public void TC02_navigatetoOrderReviewpage() throws Exception
{
	
	log.info("Enter email ID");
	l1.getWebElement(BillingPOM.billingPage_Email_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","BillingAddress",1,10));
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
