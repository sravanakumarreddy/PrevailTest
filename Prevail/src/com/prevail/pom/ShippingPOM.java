package com.prevail.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

public class ShippingPOM {

	public static By ShippingPage_Heading=By.xpath("//fieldset/legend[contains(text(),'Select or Enter Shipping Address')]");
	public static By ShippingPage_FN_TextBox=By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName");
	public static By ShippingPage_LN_TextBox=By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName");
	public static By ShippingPage_Address1_TextBox=By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1");
	public static By ShippingPage_Address2_TextBox=By.id("dwfrm_singleshipping_shippingAddress_addressFields_address2");
	public static By ShippingPage_City_TextBox=By.id("dwfrm_singleshipping_shippingAddress_addressFields_city");
	public static By ShippingPage_ZipCode_TextBox=By.id("dwfrm_singleshipping_shippingAddress_addressFields_postal");
	public static By ShippingPage_Country_Dropdown=By.id("dwfrm_singleshipping_shippingAddress_addressFields_country");
	public static By ShippingPage_State_Dropdown=By.id("dwfrm_singleshipping_shippingAddress_addressFields_states_state");
	public static By ShippingPage_Phone_TextBox=By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone");
	public static By ShippingPage_SameasBilling_Checkbox=By.id("dwfrm_singleshipping_shippingAddress_useAsBillingAddress");
	public static By ShippingPage_AddtoAddressbook_Checkbox=By.id("dwfrm_singleshipping_shippingAddress_addToAddressBook");
	public static By ShippingPage_isThisaGift_Options=By.xpath("//span[contains(text(),'Is this a gift?')]");
	public static By ShippingPage_isThisaGift_Options_YesNo=By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_isGift']");
	public static By ShippingPage_isThisaGift_Options_Yes=By.xpath("//div[@class='form-row ']//input[@value='true']");
	public static By ShippingPage_isThisaGift_Options_No=By.xpath("//div[@class='form-row ']//input[@value='false']");
	public static By ShippingPage_RemainingCahrCount=By.xpath("//span[@class='char-remain-count']");
	public static By ShippingPage_MaximumCount=By.xpath("//span[@class='char-allowed-count']");
	public static By ShippingPage_Giftoptions_Textarea=By.xpath("//textarea[@id='dwfrm_singleshipping_shippingAddress_giftMessage']");
	public static By ShippingPage_isThisaGift_MessageText=By.xpath("//label[@for='dwfrm_singleshipping_shippingAddress_giftMessage']");
	public static By ShippingPage_isThisaGift_MessageTextareafield=By.xpath("//textarea[@id='dwfrm_singleshipping_shippingAddress_giftMessage']");
	public static By ShippingPage_isThisaGift_CharcountText=By.xpath("//div[@class='char-count']");
	public static By Shipping_ContinueToBilling_Button=By.xpath("//button[@name='dwfrm_singleshipping_shippingAddress_save']");
	public static By Shipping_orderSummary_productName=By.xpath("//div[@class='checkout-mini-cart']//div[@class='mini-cart-name']");
	public static By Shipping_apoTooltip=By.xpath("//a[contains(text(),'APO/FPO')]");
	public static By Shipping_WhyisThisRequiredTooltip=By.xpath("//a[contains(text(),'Why is this required?')]");
	public static By shippingTooltip=By.xpath("//a[@aria-describedby='ui-id-4']");
	public static By shippingOrderSummaryQuantity=By.xpath("//span[contains(text(),'Qty:')]");
	public static By shippingOrderSummarysubtotalLabel=By.xpath("//tr[@class='order-subtotal']//td[contains(text(),'Subtotal')]");
	public static By shippingOrderSummarysubtotalValue=By.xpath("//tr[@class='order-subtotal']//td[text()='Subtotal']/following-sibling::td");
	public static By shippingOrderSummaryshippingValue=By.xpath("//tr[starts-with(@class,'order-shipping')]//td/following-sibling::td");
	public static By shippingOrderSummarySalestaxValue=By.xpath("//tr[@class='order-sales-tax']//td[text()='Sales Tax']/following-sibling::td");
	public static By shippingOrderSummaryEditLink=By.xpath("//a[@title='Edit']");
	public static By shippingOrderSummarysalestax=By.xpath("//tr[@class='order-sales-tax']");
	public static By shippingOrderSummaryOrderTotal=By.xpath("//tr[@class='order-total']");
	public static By shippingOrderSummarOrderValue=By.xpath("//td[@class='order-value']");
	public static By shippingMethodRadioButton=By.xpath("//input[@id='shipping-method-001']");
	public static By shippingMethods=By.xpath("//div[@class='form-row form-indent label-inline']");
	public static By shippingMethodRadioButtons=By.xpath("//input[@class='input-radio']");
	public static By shippingMethodPrices=By.xpath("//div[@class='form-row form-indent label-inline']/label/span");
	public static By shippingMethodTooltips=By.xpath("//div[@class='form-row form-indent label-inline']//a[@class='tooltip']");
	public static By shippingMethodTooltipcontent=By.xpath("//div[@class='form-row form-indent label-inline']//div[@class='tooltip-content']");
	public static By shippingLoggedinExpand=By.xpath("//h2[contains(text(),'Logged-in')]");
	public static By shippinglogoutbutton=By.linkText("Logout");
	public static By shippingTabexpand=By.xpath("//h2[contains(text(),'Shipping')]");
	public static By shippingexpandcontinue=By.xpath("//button[contains(text(),'Continue')]");
	public static By shippingpaymentAccordion=By.xpath("//h2[contains(text(),'Payment')]");
	public static By shippingaddressValidationDialogue=By.xpath("//div[@id='address-validation-dialog']");
	public static By shippingaddressValidationContinue=By.xpath("//button[@id='ship-to-original-address']");
	public static By shippingOrderReviewAccordion=By.xpath("//h2[contains(text(),'Order Review')]");
	public static By shippingAccordion=By.xpath("//h2[contains(text(),'Shipping')]");
	public static By shippingMultiShippingOption=By.xpath("//div[@class='ship-to-multiple']");
	public static By shippingMultiShippingButton=By.name("dwfrm_singleshipping_shipToMultiple");
	public static By shippingShipToSingleoption=By.xpath("//div[@class='ship-to-single']");
	public static By shippingShipToSingleButton=By.xpath("//button[@name='dwfrm_multishipping_shipToSingle']");
	public static By shippingSigninAccordionGuest=By.xpath("//h2[contains(text(),'Sign In')]");
	public static By shippingSigninAccordionGuestHeading=By.xpath("//h2[contains(text(),'Guests or New Customers')]");
	public static By shippingAddresslistDropDown=By.id("dwfrm_singleshipping_addressList");
	public static By shippingAddressExampleText=By.id("//div[contains(text(),'Example: 333-333-3333')]");
	
	public static By ShippingPage_FN_Label=By.xpath("//span[contains(text(),'First Name')]");
	public static By ShippingPage_LN_Label=By.xpath("//span[contains(text(),'Last Name')]");
	public static By ShippingPage_Address1_Label=By.xpath("//span[contains(text(),'Address 1')]");
	public static By ShippingPage_Address2_Label=By.xpath("//span[contains(text(),'Address 2')]");
	public static By ShippingPage_City_Label=By.xpath("//span[contains(text(),'City')]");
	public static By ShippingPage_ZipCode_Label=By.xpath("//span[contains(text(),'ZIP Code')]");
	public static By ShippingPage_Country_Label=By.xpath("//span[contains(text(),'Country')]");
	public static By ShippingPage_State_Label=By.xpath("//span[contains(text(),'State')]");
	public static By ShippingPage_Phone_Label=By.xpath("//span[contains(text(),'Phone')]");
	public static By ShippingPage_ordersummary_section=By.xpath("//div[@id='secondary']");
	
	
	
	public static By ShippingPage_FN_error=By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName-error");
	public static By ShippingPage_LN_error=By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName-error");
	public static By ShippingPage_Address1_error=By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1-error");
	public static By ShippingPage_city_error=By.id("dwfrm_singleshipping_shippingAddress_addressFields_city-error");
	public static By ShippingPage_state_error=By.id("dwfrm_singleshipping_shippingAddress_addressFields_states_state-error");
	public static By ShippingPage_zipcode_error=By.id("dwfrm_singleshipping_shippingAddress_addressFields_postal-error");
	public static By ShippingPage_phone_error=By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone-error");
	
	public static By Shipping_RightNav_Qty_Value=By.xpath("//div[@class='checkout-mini-cart']//div[@class='mini-cart-pricing']/span[@class='value']");
	public static By Shipping_RightNav_Price=By.xpath("//div[@class='checkout-mini-cart']//div[@class='mini-cart-pricing']/span[@class='mini-cart-price']");
		
}
