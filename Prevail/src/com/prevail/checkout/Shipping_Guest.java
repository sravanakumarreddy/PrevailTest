package com.prevail.checkout;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.CheckoutIlpPOM;
import com.prevail.pom.OrderreviewPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.projectspec.ProfileFunctions;
import com.prevail.projectspec.ShopnavFunctions;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class Shipping_Guest extends BaseTest {
	
	String ProductNameinOrderSummarySection;
	String ProductNameinCartPage;
	String OS_Subtotal;
	String OS_ShippingValue;
	String OS_SalesTax;
	String ShippingBillingbutton;

@Test(groups="{Regression}",description="124470,289178")
public void TC00_Shippingpage() throws Exception
{
	
	log.info("Navigate to shipping page");
	//cart.navigateToCart();
	checkout.NavigateToShippingPage();
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_FN_TextBox),"Shipping First Name");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_LN_TextBox),"Shipping Last Name");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Address1_TextBox),"Shipping Address1 Name");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Address2_TextBox),"Shipping Address2 Name");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_City_TextBox),"City Name");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_ZipCode_TextBox),"Zipcode Textbox");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Country_Dropdown),"Country dropdown");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_State_Dropdown),"State dropdown");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Phone_TextBox),"phone textbox");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_SameasBilling_Checkbox),"checkbox shipping same as billing");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_AddtoAddressbook_Checkbox),"checkbox add to address book");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_Options),"gift options");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_FN_Label),"First Name Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_LN_Label),"Last Name Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Address1_Label),"Address1 Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Address2_Label),"Address2 Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_City_Label),"City Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_ZipCode_Label),"Zipcode Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Country_Label),"Country Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_State_Label),"State Label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Phone_Label),"State Label");
	
}	
	
@Test(groups="{Regression}",description="148951,148950,148900,289178")
public void TC01_ShippingpageBillingPrePopulate() throws Exception
{
	
	log.info("Order summary Section UI");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingpaymentAccordion),"shippingpaymentAccordion");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderReviewAccordion),"shippingOrderReviewAccordion");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingSigninAccordionGuest),"shippingSigninAccordionGuest");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryQuantity),"order summary quantity");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarysubtotalLabel),"order summary subtotal label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryEditLink),"order summary Edit link");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarysalestax),"order summary sales tax");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryOrderTotal),"order summary total price");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarOrderValue),"order summary total price");
	log.info("Enter shipping address");
	checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
	log.info("Click on sign in icon as a gues user");
	l1.getWebElement(ShippingPOM.shippingSigninAccordionGuest).click();
	log.info("Sign in section should get expanded");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingSigninAccordionGuestHeading));
	log.info("Checkout Guest button");
	sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_CheckoutasGuestButton));
	sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_entiresection));
	log.info("Returning customers section");
	sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_ReturningCustomersSection));
	log.info("Create account now button");
	sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_CreateAccountNowButton));
	log.info("Social Media section");
	sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_SocialMediaLinks));
	log.info("select shipping methods");
	boolean RadioSelected=l1.getWebElements(ShippingPOM.shippingMethodRadioButtons).get(1).isSelected();
	if (RadioSelected==true)
	{
		l1.getWebElements(ShippingPOM.shippingMethodRadioButtons).get(1).click();
	}
	log.info("fetching Order summary sub total");
	OS_Subtotal=l1.getWebElement(ShippingPOM.shippingOrderSummarysubtotalValue).getText().replace("$","");
	log.info("fetching Order summary shipping value");
	OS_ShippingValue=l1.getWebElement(ShippingPOM.shippingOrderSummaryshippingValue).getText().replace("$","");
	log.info("fetching Order summary sales tax");
	OS_SalesTax=l1.getWebElement(ShippingPOM.shippingOrderSummarySalestaxValue).getText().replace("$","");
	sa.assertEquals(gVar.assertEqual(CartPOM.cartProductPriceSalesPrice),OS_Subtotal,"Comparing price");
	log.info("Don't enter the address on shipping page");
	ShippingBillingbutton=l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).getAttribute("disabled");
	sa.assertEquals(ShippingBillingbutton,"disabled");
	log.info("Entering optional values in shipping fields");
	l1.getWebElement("ShippingPage_Address2_TextBox","Checkout\\ShippingPage.properties").sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,4));
	ShippingBillingbutton=l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).getAttribute("disabled");
	sa.assertEquals(ShippingBillingbutton,"disabled");
	checkout.Shippingfieldsclear();	
	
}


@Test(groups="{Regression}",description="128333")
public void TC02_shippingpagegiftOptions() throws Exception
{
	
	log.info("click on yes check box in gift message wrap");
	l1.getWebElement(ShippingPOM.ShippingPage_isThisaGift_Options_Yes).click();
	
	boolean RaidobuttonYes=l1.getWebElement(ShippingPOM.ShippingPage_isThisaGift_Options_Yes).isSelected();
	if (RaidobuttonYes==true)
	{
		log.info("true checkbox checked");
	}
	
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_MessageText),"messgae label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_MessageTextareafield),"messgae label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_CharcountText),"char count text");
	
	log.info("click on No check box in gift message wrap");
	l1.getWebElement(ShippingPOM.ShippingPage_isThisaGift_Options_No).click();
	
	boolean RaidobuttonNo=l1.getWebElement(ShippingPOM.ShippingPage_isThisaGift_Options_Yes).isSelected();
	if (RaidobuttonNo==false)
	{
		log.info("false checkbox checked");
	}
	
	log.info("Gift option is no");
	sa.assertTrue(gVar.assertNotVisible(ShippingPOM.ShippingPage_isThisaGift_MessageText),"messgae label");
	sa.assertTrue(gVar.assertNotVisible(ShippingPOM.ShippingPage_isThisaGift_MessageTextareafield),"messgae label");
	sa.assertTrue(gVar.assertNotVisible(ShippingPOM.ShippingPage_isThisaGift_CharcountText),"char count text");

}

@Test(groups="{Regression}",dataProvider="ShippingGiftoptionsValidations",description="148947")
public void TC03_shippinggiftOptionsValidations(TestData t) throws Exception
{
	
	log.info("click on yes check box in gift message wrap");
	l1.getWebElement(ShippingPOM.ShippingPage_isThisaGift_Options_Yes).click();
	log.info("enter values on textarea fields");
	l1.getWebElement(ShippingPOM.ShippingPage_Giftoptions_Textarea).sendKeys(t.get(0));
	float CharactersinTextBox=l1.getWebElement(ShippingPOM.ShippingPage_Giftoptions_Textarea).getText().length();
	log.info("remaining charecter count");
	String RemChar=l1.getWebElement(ShippingPOM.ShippingPage_RemainingCahrCount).getText();
	log.info("remaining charecter count"+RemChar);
	Float RemainingChar=new Float(RemChar);
	log.info("remaining charecter count"+RemainingChar);
	log.info("shipping count maximum count");
	String MaxCount=l1.getWebElement(ShippingPOM.ShippingPage_MaximumCount).getText();
	log.info("remaining charecter count"+MaxCount);
	Float MaximunChar=new Float(MaxCount);
	log.info("remaining charecter count"+MaximunChar);
	float RemcharSubraction=MaximunChar-CharactersinTextBox;
	sa.assertEquals(RemChar,RemcharSubraction);
	sa.assertAll();
	
}


@Test(groups="{Regression}",description="289784")
public void TC04_ShippingpagePaymentAccordion() throws Exception
{
	
	log.info("click on payment accordion");
	l1.getWebElement(ShippingPOM.shippingpaymentAccordion).click();
	sa.assertTrue(gVar.assertNotVisible(BillingPOM.billingPage_Heading));

}

@Test(groups="{Regression}",description="289786")
public void TC05_ShippingpageOrderreviewAccordion() throws Exception
{
	
	log.info("click on orderReview accordion");
	l1.getWebElement(ShippingPOM.shippingOrderReviewAccordion).click();
	sa.assertTrue(gVar.assertNotVisible(OrderreviewPOM.OrderReview_placeOrderButton));
	
}

@Test(groups="{Regression}",description="128340,128341")
public void TC06_EditLinkOCPPage() throws Exception
{
	
	log.info("Fetching product name in order summary section shipping page");
	ProductNameinOrderSummarySection=l1.getWebElement(ShippingPOM.Shipping_orderSummary_productName).getText();
	log.info("OCP Product Name"+ProductNameinOrderSummarySection);
	l1.getWebElement(ShippingPOM.Shipping_orderSummary_productName).click();
	log.info("Should navigate to cart page");
	ProductNameinCartPage=l1.getWebElement(CartPOM.cartProductName).getText();
	assertEquals(ProductNameinOrderSummarySection, ProductNameinCartPage);
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

}

@Test(groups="{Regression}",description="128342,289218,128338")
public void TC07_ShippingpageApoTooltip() throws Exception
{
	
	log.info("mouse hover on tooltip");
	act.moveToElement(l1.getWebElement(ShippingPOM.Shipping_apoTooltip)).perform();
	sa.assertTrue(gVar.assertVisible(ShippingPOM.Shipping_apoTooltip));
	
}

@Test(groups="{Regression}",description="289220")
public void TC08_ShippingpageWhyisThisRequiredTooltip() throws Exception
{
	
	log.info("mouse hover on tooltip");
	act.moveToElement(l1.getWebElement(ShippingPOM.Shipping_WhyisThisRequiredTooltip)).perform();
	sa.assertTrue(gVar.assertVisible(ShippingPOM.Shipping_WhyisThisRequiredTooltip));
	
}


@Test(groups="{Regression}",description="148946,148950")
public void TC09_UseThisAddressForBillingCheckbox() throws Exception
{
	
	log.info("Entering shipping address");
	checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
	log.info("Entering shipping address");
	gVar.SelectCheckbox(ShippingPOM.ShippingPage_SameasBilling_Checkbox);
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

@Test(groups="{Regression}",description="128336,289690,128337,128338,289217")
public void TC10_MultiShippingOption() throws Exception
{
	
	//HomePage_Logo
	l1.getWebElement("HomePage_Logo","ShopNav\\HomePage.properties").click();
	log.info("Navigate to shipping page");
	checkout.NavigateToShippingPage();
	log.info("Navigated back to shipping page");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
	log.info("Multi shipping option");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingMultiShippingOption));
	log.info("Multi shipping button");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingMultiShippingButton));
	log.info("click on Multi shipping button");
	l1.getWebElement(ShippingPOM.shippingMultiShippingButton).click();
	log.info("Single shipping option");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingShipToSingleoption));
	log.info("click on single shipping button");
	l1.getWebElement(ShippingPOM.shippingShipToSingleButton).click();
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
	
}

@Test(groups="{Regression}",description="128343,148948")
public void TC11_ShippingMethodSelection() throws Exception
{
	int ShippingMethodSize=l1.getWebElements(ShippingPOM.shippingMethods).size();
	
	for (int i=0;i<ShippingMethodSize;i++)
	{
		l1.getWebElements(ShippingPOM.shippingMethodRadioButtons).get(i).click();
		String ShippingMethodPrice=l1.getWebElements(ShippingPOM.shippingMethodPrices).get(0).getText().replace("$","");
		OS_ShippingValue=l1.getWebElement(ShippingPOM.shippingOrderSummaryshippingValue).getText().replace("$","");
		sa.assertEquals(ShippingMethodPrice,OS_ShippingValue);
		
		WebElement ShippingMethodTooltips=l1.getWebElements(ShippingPOM.shippingMethodTooltips).get(i);		
		log.info("mouse hover on tooltips");
		act.moveToElement(ShippingMethodTooltips).perform();
		sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingMethodTooltipcontent, i));
	}
	
	
}

@Test(groups="{Regression}",description="289690")
public void TC12_SigninSectionExpanded() throws Exception
{
	
	log.info("Click on logged in link expand");
	l1.getWebElement(ShippingPOM.shippingSigninAccordionGuest).click();	
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingSigninAccordionGuestHeading));
	log.info("Shipping tab expand");
	l1.getWebElement(ShippingPOM.shippingTabexpand).sendKeys(Keys.TAB);
	log.info("Navigated back to shipping page");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
	
}
	
@Test
public void TC00_navigatetopage() throws Exception
{
	log.info("Validations for shipping page");
	checkout.NavigateToShippingPage();
}

@Test(groups="{Regression}",dataProvider="ShippingValidations",dataProviderClass=Data.class,description="148938,148939,148940,148941,148942,148943,148944,148945,128335")
public void TC13_ShippingValidations(TestData t) throws Exception
{
	
	log.info("Clear fielsd after every entry");
	log.info("Clear Fname");
	l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).clear();
	log.info("Clear LName");
	l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).clear();
	log.info("Clear Address1");
	l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).clear();
	log.info("Clear Address2");
	l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).clear();
	log.info("Clear City");
	l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).clear();
	log.info("Clear Zipcode");
	l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).clear();
	log.info("Clear Phone");
	l1.getWebElement(ShippingPOM.ShippingPage_Phone_TextBox).clear();

	log.info("iteration"+i);
	log.info("FN textbox entering");
	l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).sendKeys(t.get(0));
	log.info("LN textbox entering");
	l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).sendKeys(t.get(1));
	log.info("Address1 textbox entering");
	l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).sendKeys(t.get(2));
	log.info("Address2 textbox entering");
	l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).sendKeys(t.get(3));
	log.info("City textbox entering");
	l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).sendKeys(t.get(4));
	log.info("Zipcode textbox entering");
	l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).sendKeys(t.get(5));
	log.info("Country textbox entering");
	gVar.handlingDropdown(ShippingPOM.ShippingPage_Country_Dropdown,t.get(6));
	log.info("State textbox entering");
	gVar.handlingDropdown(ShippingPOM.ShippingPage_State_Dropdown,t.get(7));
	log.info("Phone textbox entering");
	l1.getWebElement(ShippingPOM.ShippingPage_Phone_TextBox).sendKeys(t.get(8));
	
	if (i==0){
	
	log.info("Validations Loop"+i);
	log.info("Click on continue to biling button");
	l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).click();
	log.info("fetching FN background message");
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	log.info("fetching LN background message");
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	log.info("fetching Address1 background message");
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	log.info("fetching Address2 background message");
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	log.info("fetching City background message");
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	log.info("fetching Zipcode background message");
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	log.info("fetching Zipcode Phone message");
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Phone_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));

	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_FN_error).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_FN_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_LN_error).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_LN_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address1_error).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_Address1_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_city_error).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_City_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_state_error).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_State_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_zipcode_error).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_Zipcode_Blank_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_phone_error).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_Phone_Blank_ErrorMessage"));

	}
	
	else if (i==1){
	
	log.info("Validations Loop"+i);	
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Phone_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));

	}
	
	else if (i==2 || i==3 || i==4){
	
	log.info("Validations Loop"+i);		
	l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).click();
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_ValidZipcode_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_phone_error ).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_Phone_ErrorMessage"));
		
	}
	
	else
	{
		
		log.info("Validations Loop"+i);	
		log.info("Entering shipping address");
		checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
		log.info("Entering shipping address");
		gVar.SelectCheckbox(ShippingPOM.ShippingPage_SameasBilling_Checkbox);
		log.info("Click on continue button");
		l1.getWebElements(ShippingPOM.Shipping_ContinueToBilling_Button).get(0).click();
		log.info("Verifying the billing heading");
		l1.getWebElement(BillingPOM.billingPage_Heading).isDisplayed();
		
	}
		

	
	}

}
