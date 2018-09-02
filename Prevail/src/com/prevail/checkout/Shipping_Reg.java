package com.prevail.checkout;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.CheckoutIlpPOM;
import com.prevail.pom.OrderreviewPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.projectspec.ProfileFunctions;
import com.prevail.projectspec.ShopnavFunctions;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class Shipping_Reg extends BaseTest {
	
	String ProductNameinOrderSummarySection;
	String ProductNameinPDPage;
	String OS_Subtotal;
	String OS_ShippingValue;
	String OS_SalesTax;

@Test(groups="{Regression}",description="124469,289202")
public void TC00_ShippingpageUI() throws Exception
{
	
	log.info("Login");
	p.loginToAppliction();
	log.info("Navigate to shipping page");
	cart.navigateToCart();
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

@Test(groups="{Regression}",description="124482,289202")
public void TC01_shippingpagegiftOptions() throws Exception
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
	
	log.info("click on payment accordion");
	l1.getWebElements(ShippingPOM.ShippingPage_isThisaGift_Options_YesNo).get(0).click();
	
	try {
		
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_MessageText),"messgae label");
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_MessageTextareafield),"messgae label");
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_CharcountText),"char count text");
	
	} catch (Exception e) {
		log.info("Gift option is no");
	}
	
	l1.getWebElements(ShippingPOM.ShippingPage_isThisaGift_Options_YesNo).get(1).click();
	
	try {
		
		log.info("Gift option is no");
		sa.assertTrue(gVar.assertNotVisible(ShippingPOM.ShippingPage_isThisaGift_MessageText),"messgae label");
		sa.assertTrue(gVar.assertNotVisible(ShippingPOM.ShippingPage_isThisaGift_MessageTextareafield),"messgae label");
		sa.assertTrue(gVar.assertNotVisible(ShippingPOM.ShippingPage_isThisaGift_CharcountText),"char count text");
	
	} catch (Exception e) {
		
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_MessageText),"messgae label");
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_MessageTextareafield),"messgae label");
		sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_isThisaGift_CharcountText),"char count text");
		
	}

}

@Test(groups="{Regression}",dataProvider="ShippingGiftoptionsValidations",description="148947,124484")
public void TC02_shippinggiftOptionsValidations(TestData t) throws Exception
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
	
@Test(groups="{Regression}",description="148868,148869,124486,289775,289691,124468,289663")
public void TC03_ShippingpageBillingPrePopulate() throws Exception
{
	
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingpaymentAccordion),"order summary quantity");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderReviewAccordion),"order summary quantity");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingLoggedinExpand),"order summary quantity");
	log.info("Order summary Section UI");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryQuantity),"order summary quantity");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarysubtotalLabel),"order summary subtotal label");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryEditLink),"order summary Edit link");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarysalestax),"order summary sales tax");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryOrderTotal),"order summary total price");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarOrderValue),"order summary total price");
	log.info("Enter shipping address");
	checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
	log.info("Click on logged in link expand");
	l1.getWebElement(ShippingPOM.shippingLoggedinExpand).click();
	log.info("logout link should visible");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippinglogoutbutton));
	log.info("Continue link should be visible");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingexpandcontinue));
	log.info("Shipping tab expand");
	l1.getWebElement(ShippingPOM.shippingTabexpand).click();
	log.info("Address should prepopulate");
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_FN_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,1));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_LN_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,2));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Address1_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,3));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Address2_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,4));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_City_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,5));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_ZipCode_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,6));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Country_Dropdown),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,7));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_State_Dropdown),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,8));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Phone_TextBox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,9));
	log.info("select shipping methods");
	l1.getWebElement(ShippingPOM.shippingMethodRadioButton).click();
	log.info("fetching Order summary sub total");
	OS_Subtotal=l1.getWebElement(ShippingPOM.shippingOrderSummarysubtotalValue).getText().replace("$","");
	log.info("fetching Order summary shipping value");
	OS_ShippingValue=l1.getWebElement(ShippingPOM.shippingOrderSummaryshippingValue).getText().replace("$","");
	log.info("fetching Order summary sales tax");
	OS_SalesTax=l1.getWebElement(ShippingPOM.shippingOrderSummarySalestaxValue).getText().replace("$","");
	sa.assertEquals(gVar.assertEqual(CartPOM.cartProductPriceSalesPrice),OS_Subtotal,"Comparing price");
	log.info("Don't enter the address on shipping page");
	gVar.disabled=l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).getAttribute("disabled");
	sa.assertEquals(gVar.disabled,"disabled");
	log.info("Entering optional values in shipping fields");
	l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,4));
	gVar.disabled=l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).getAttribute("disabled");
	sa.assertEquals(gVar.disabled,"disabled");
	checkout.Shippingfieldsclear();
	
}

@Test(groups="{Regression}",description="289783,289783")
public void TC04_ShippingpagePaymentAccordion() throws Exception
{
	
	log.info("click on payment accordion");
	l1.getWebElement(ShippingPOM.shippingpaymentAccordion).click();
	sa.assertTrue(gVar.assertNotVisible(BillingPOM.billingPage_Heading));

}

@Test(groups="{Regression}",description="289787")
public void TC05_ShippingpageOrderreviewAccordion() throws Exception
{
	
	log.info("click on orderReview accordion");
	l1.getWebElement(ShippingPOM.shippingOrderReviewAccordion).click();
	sa.assertTrue(gVar.assertNotVisible(OrderreviewPOM.OrderReview_placeOrderButton));
	
}

@Test(groups="{Regression}",description="124635,124632")
public void TC06_EditLinkOCPPage() throws Exception
{
	
	log.info("Fetching product name in order summary section shipping page");
	ProductNameinOrderSummarySection=l1.getWebElement(ShippingPOM.Shipping_orderSummary_productName).getText();
	log.info("OCP Product Name"+ProductNameinOrderSummarySection);
	l1.getWebElement(ShippingPOM.Shipping_orderSummary_productName).click();
	log.info("Should navigate to PDP page");
	sa.assertTrue(gVar.assertVisible("PDP_ProductName","ShopNav\\PDP.properties"),"Edit link in ordersummary page");
	log.info("Fetching heading in Order summary page");
	ProductNameinPDPage=l1.getWebElement("PDP_Product_Name","ShopNav\\PDP.properties").getText();
	assertEquals(ProductNameinOrderSummarySection, ProductNameinPDPage);
	log.info("navigate back to shipping page");
	log.info("click on mini cart link");
	l1.getWebElement("MiniCartLink","ShopNav\\Minicart.properties").click();
	log.info("click on checkout button");
	l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
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

@Test(groups="{Regression}",description="128342,124637")
public void TC07_ShippingpageApoTooltip() throws Exception
{
	
	log.info("mouse hover on tooltip");
	act.moveToElement(l1.getWebElement(ShippingPOM.Shipping_apoTooltip)).perform();
	sa.assertTrue(gVar.assertVisible(ShippingPOM.Shipping_apoTooltip));
	
}

@Test(groups="{Regression}",description="289219")
public void TC08_ShippingpageWhyisThisRequiredTooltip() throws Exception
{
	
	log.info("mouse hover on tooltip");
	act.moveToElement(l1.getWebElement(ShippingPOM.Shipping_WhyisThisRequiredTooltip)).perform();
	sa.assertTrue(gVar.assertVisible(ShippingPOM.Shipping_WhyisThisRequiredTooltip));
	
}

@Test(groups="{Regression}",description="148867,148869")
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

@Test(groups="{Regression}",description="124475,124474,124472,124473")
public void TC10_MultiShippingOption() throws Exception
{
	
	log.info("Click on home page logo");
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

@Test(groups="{Regression}",description="124485,128331")
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

@Test(groups="{Regression}",description="124478")
public void TC12_AddtoAddressbookCheckbox() throws Exception
{

	log.info("clear all shipping address values");
	checkout.Shippingfieldsclear();
	log.info("Enter shipping address");
	checkout.ShippingAddress("//data//Checkout.xls","ShippingAddress",1);
	log.info("Enter shipping address");
	l1.getWebElement(ShippingPOM.ShippingPage_AddtoAddressbook_Checkbox).click();
	log.info("Entering shipping address");
	gVar.SelectCheckbox(ShippingPOM.ShippingPage_SameasBilling_Checkbox);
	log.info("entering billing email address");
	l1.getWebElement("BillingPage_Emailaddress_TextBox","Checkout\\BillingPage.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",1,0));
	log.info("Entering Payment Details");
	checkout.PaymentDetails("\\data\\Checkout.xls","PaymentDetails",1);
	log.info("click on place order button");
	l1.getWebElement("Payment_PlaceOrderButton","Checkout\\Payment.properties").click();
	log.info("Click on place order in order review page");
	l1.getWebElement("OrderReview_placeOrderButton","Checkout\\OrderReview.properties").click();
	log.info("Order Confirmation Heading");
	sa.assertTrue(l1.getWebElement("OrderConfirmation_Heading", "Checkout\\OrderConfirmation.properties").isDisplayed());
	sa.assertTrue(l1.getWebElement("orderConfirmation_orderNumber", "Checkout\\OrderConfirmation.properties").isDisplayed());
	log.info("Click on MyAccount icon in header as logged in user");
	l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
	//Navigate to Address page
	log.info("Click on Address link");
	l1.getWebElement("Address_Link_AccountLandingPage","Profile\\Addresses.properties").click();
	//Default Address heading
	sa.assertTrue(gVar.assertVisible("Address_DefaultAddress_Heading", "Profile\\Addresses.properties"),"Address_DefaultAddress_Heading");
	//Address Title
	sa.assertEquals(gVar.assertEqual("Addsress_Default_Title", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\Checkout.xls","ShippingAddress",2,10));
	//FN LN
	sa.assertEquals(gVar.assertEqual("Addsress_Fname_Lname", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\Checkout.xls","ShippingAddress",2,11));
	//Mini-address
	sa.assertEquals(gVar.assertEqual("Address_DefaultAddress", "Profile\\Addresses.properties"), GetData.getDataFromExcel("\\data\\Checkout.xls","ShippingAddress",2,12));
	//Delete link
	sa.assertTrue(gVar.assertVisible("Address_Delete_Link", "Profile\\Addresses.properties"),"Address_Delete_Link");
	//Edit link
	sa.assertTrue(gVar.assertVisible("Address_Edit_Link", "Profile\\Addresses.properties"),"Address_Edit_Link");
	
}

@Test(groups="{Regression}",description="124471")
public void TC13_SelectanAddressDropDown() throws Exception
{
	
	log.info("Delete address");
	p.DeleteAddress();
	//Create New Address
	log.info("Click Create Address");
	l1.getWebElement("Address_CreateNew_Button","Profile\\Addresses.properties").click();
	Thread.sleep(2000);
	log.info("Enter address1");
	p.EnterAddressValues("\\data\\ProfileData.xls","Address",1);
	log.info("Click on Apply button");
	l1.getWebElement("Address_ApplyButton","Profile\\Addresses.properties").click();
	log.info("Navigate to shipping page");
	checkout.NavigateToShippingPage();
	log.info("Select Address from dropdown");
	gVar.handlingDropdown(ShippingPOM.shippingAddresslistDropDown,1);
	log.info("Address should prepopulate");
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_FN_TextBox),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,1));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_LN_TextBox),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,2));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Address1_TextBox),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,3));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Address2_TextBox),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,4));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_City_TextBox),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,5));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_ZipCode_TextBox),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,6));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Country_Dropdown),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,7));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_State_Dropdown),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,8));
	sa.assertEquals(gVar.assertEqual(ShippingPOM.ShippingPage_Phone_TextBox),GetData.getDataFromExcel("//data//ProfileData.xls","Address",1,9));
	
}

@Test(groups="{Regression}",description="289671")
public void TC14_SigninSectionExpanded() throws Exception
{
	
	log.info("Click on logged in link expand");
	l1.getWebElement(ShippingPOM.shippingLoggedinExpand).click();
	log.info("logout link should visible");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippinglogoutbutton),"Shipping login button");
	log.info("Shipping tab expand");
	l1.getWebElement(ShippingPOM.shippingTabexpand).sendKeys(Keys.TAB);
	log.info("Navigated back to shipping page");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
}

@Test(groups="{Regression}",description="289768")
public void TC14_SigninSectionLogoutLink() throws Exception
{
	
	log.info("Click on logged in link expand");
	l1.getWebElement(ShippingPOM.shippingLoggedinExpand).click();
	log.info("logout link should visible");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippinglogoutbutton));
	l1.getWebElement(ShippingPOM.shippinglogoutbutton).click();
	log.info("should navigate to my account login page");
	l1.getWebElement("Login_Heading","Profile\\login.properties");
	l1.getWebElement("Login_ReturningCustomer_Heading","Profile\\login.properties");
	
}

@Test(groups="{Regression}",dataProvider="ShippingValidations",description="148866,148860,148861,148862,148863,148864,148865,124625,128330")
public void TC15_ShippingValidations(TestData t) throws Exception
{
	
	log.info("Validations for shipping page");
	checkout.NavigateToShippingPage();
	
	log.info("Clear fielsd after every entry");
	l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).clear();
	l1.getWebElement(ShippingPOM.ShippingPage_Phone_TextBox).clear();

	l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).sendKeys(t.get(0));
	l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).sendKeys(t.get(1));	
	l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).sendKeys(t.get(2));	
	l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).sendKeys(t.get(3));
	l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).sendKeys(t.get(4));	
	l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).sendKeys(t.get(5));
	gVar.handlingDropdown(ShippingPOM.ShippingPage_Country_Dropdown,t.get(6));
	gVar.handlingDropdown(ShippingPOM.ShippingPage_State_Dropdown,t.get(7));
	l1.getWebElement(ShippingPOM.ShippingPage_Phone_TextBox).sendKeys(t.get(8));
	
	if (i==0){
	
	l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).click();	
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,8));
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
		
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_FN_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_LN_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address1_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Address2_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_City_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_Phone_TextBox).getAttribute("maxlength"),GetData.getDataFromExcel("\\data\\Checkout.xls","CheckoutData",1,1));

	}
	
	else if (i==2 || i==3 || i==4){
		
	l1.getWebElement(ShippingPOM.Shipping_ContinueToBilling_Button).click();
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_ZipCode_TextBox).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_ValidZipcode_ErrorMessage"));
	sa.assertEquals(l1.getWebElement(ShippingPOM.ShippingPage_phone_error ).getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ShippingPage_Phone_ErrorMessage"));
		
	}
	
	else
	{
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
