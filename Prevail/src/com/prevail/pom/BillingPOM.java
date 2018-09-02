package com.prevail.pom;

import org.openqa.selenium.By;

public class BillingPOM {
	
	public static By billingPage_Heading=By.xpath("//legend[contains(text(),'Select or Enter Billing Address')]");
	public static By billingPage_FN_TextBox=By.id("dwfrm_billing_billingAddress_addressFields_firstName");
	public static By billingPage_LN_TextBox=By.id("dwfrm_billing_billingAddress_addressFields_lastName");
	public static By billingPage_Address1_TextBox=By.id("dwfrm_billing_billingAddress_addressFields_address1");
	public static By billingPage_Address2_TextBox=By.id("dwfrm_billing_billingAddress_addressFields_address2");
	public static By billingPage_City_TextBox=By.id("dwfrm_billing_billingAddress_addressFields_city");
	public static By billingPage_ZipCode_TextBox=By.id("dwfrm_billing_billingAddress_addressFields_postal");
	public static By billingPage_Country_Dropdown=By.id("dwfrm_billing_billingAddress_addressFields_country");
	public static By billingPage_State_Dropdown=By.id("dwfrm_billing_billingAddress_addressFields_states_state");
	public static By billingPage_Phone_TextBox=By.id("dwfrm_billing_billingAddress_addressFields_phone");
	public static By billingPage_Email_Textbox=By.id("dwfrm_billing_billingAddress_email_emailAddress");
	public static By billingPage_addToEmail_Checkbox=By.id("dwfrm_billing_billingAddress_addToEmailList");
	
	
	public static By billingPage_FN_Label=By.xpath("//span[contains(text(),'First Name')]");
	public static By billingPage_LN_Label=By.xpath("//span[contains(text(),'Last Name')]");
	public static By billingPage_Address1_Label=By.xpath("//span[contains(text(),'Address 1')]");
	public static By billingPage_Address2_Label=By.xpath("//span[contains(text(),'Address 2')]");
	public static By billingPage_City_Label=By.xpath("//span[contains(text(),'City')]");
	public static By billingPage_ZipCode_Label=By.xpath("//span[contains(text(),'ZIP Code')]");
	public static By billingPage_Country_Label=By.xpath("//span[contains(text(),'Country')]");
	public static By billingPage_State_Label=By.xpath("//span[contains(text(),'State')]");
	public static By billingPage_Phone_Label=By.xpath("//span[contains(text(),'Phone')]");
	
	
	public static By billingPage_shipping_button = By.xpath("//h2[contains(text(),'Shipping')]");
	public static By billingPage_continue_button= By.xpath("//button[@name='dwfrm_billing_save']");

	public static By billingPage_header= By.xpath("//div[@class='mini-billing-address order-component-block']/h3");
	public static By billingPage_heading= By.xpath("//legend[contains(text(),'Select or Enter Billing Address')]");
	public static By billingPage_required_indicator= By.xpath("//legend[contains(text(),'Select or Enter Billing Address')]//span[@class='required-indicator']");

	//billing address
	public static By billingPage_select_address_dropdown= By.xpath("//select[@id='dwfrm_billing_addressList']");
	public static By billingPage_apofpo_tooltip= By.xpath("//a[contains(text(),'APO/FPO')]");
	public static By billingPage_number_tooltip= By.xpath("//a[contains(text(),'Why is this required?')]");
	public static By billingPage_phonenumber_text= By.xpath("//div[contains(text(),'Example: 333-333-3333')]");
	public static By billingPage_payment_number_example= By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//div[contains(text(),'Example: 4111111111111111')]");
	public static By billingPage_addtoemaillist_checkbox= By.id("dwfrm_billing_billingAddress_addToEmailList");
	public static By billingPage_addtoaddress_checkbox= By.id("dwfrm_billing_billingAddress_addToAddressBook");

	//PAYMENT
	public static By billingPage_payment_header= By.xpath("//h2[Contains(text(),'Payment')]");
	public static By billingPage_payment_heading= By.xpath("//legend[contains(text(),'Select Payment Method')]");
	public static By billingPage_payment_details= By.xpath("//div[starts-with(@class,'mini-payment-instrument')]/div[@class='details']");
	public static By billingPage_paymenteditlink= By.xpath("//div[starts-with(@class,'mini-payment-instrument')]//a");

	public static By billingPage_paymentCVNtooltiplink= By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//a[contains(text(),'What is this?')]");
	public static By billingPage_privacypolicy= By.xpath("//a[@class='privacy-policy']");
	public static By billingPage_privacypolicyDialog= By.xpath("//div[@id='dialog-container']");
	public static By billingPage_privacypolicyDialog_container= By.id("ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable");
	public static By billingPage_privacypolicyDialog_header= By.xpath("//h1[@class='content-header privacy-policy']");
	public static By billingPage_privacypolicyClose_button= By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable']//button[@title='Close']");
	public static By billingPage_ordersummary_editlink= By.xpath("//h3[contains(text(),'Order Summary')]/a");
	//div[@class='checkout-mini-cart']//preceding-sibling::h3/a

	//Payment methods
	public static By billingPage_paymentAmazonRadioButton=By.id("is-PayWithAmazon");
	public static By billingPage_paymentAmexRadioButton=By.id("is-AMERICAN_EXPRESS");
	public static By billingPage_paymentmastercardradiobutton=By.id("is-MASTERCARD");
	public static By billingPage_paymentVisaRadioButton=By.id("is-VISA");
	public static By billingPage_paymentcreditcardRadioButton=By.id("is-CREDIT_CARD");
	public static By billingPage_paymentPaypalRadioButton=By.id("is-PayPal");
	public static By billingPage_paymentBillMelaterRadioButton=By.id("is-BML");

	public static By billingPage_paymentNameonCard= By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//span[contains(text(),'Name on Card')]");
	public static By billingPage_paymentcardtype= By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//span[contains(text(),'Type')]");
	public static By billingPage_paymentCardnumber= By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//span[contains(text(),'Number')]");
	public static By billingPage_paymentCardtypeDropdown= By.id("dwfrm_billing_paymentMethods_creditCard_type");
	public static By billingPage_paymentExpirationLabel= By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//span[contains(text(),'Expiration Date:')]");
	public static By billingPage_paymentSecurityCode= By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//span[contains(text(),'Security Code')]");
	public static By billingPage_paymentSaveCardCheckbox= By.id("dwfrm_billing_paymentMethods_creditCard_saveCard");

	public static By billingPage_PaymentExpireMonthtextbox= By.id("dwfrm_billing_paymentMethods_creditCard_expiration_month");
	public static By billingPage_paymentExpireYeartextbox= By.id("dwfrm_billing_paymentMethods_creditCard_expiration_year");
	public static By billingPage_paymentOwnerNameCheckbox= By.id("dwfrm_billing_paymentMethods_creditCard_owner");
	public static By billingPage_paymentCreditCardTextBox= By.xpath("//input[starts-with(@id,'dwfrm_billing_paymentMethods_creditCard_number')]");
	public static By billingPage_paymentCVVTextbox= By.xpath("//input[starts-with(@id,'dwfrm_billing_paymentMethods_creditCard_cvn')]");
	
	
	public static By billingPage_PrivacyPolicy = By.xpath("//a[@class='privacy-policy']");
	public static By billingPagePrivacyPolicy_Overlay= By.xpath("//div[@aria-labelledby='ui-id-1']");
	public static By billingPage_PrivacyPolicy_heading= By.xpath("//h1[contains(text(),'Privacy Policy - body')]");
	public static By billingPage_PrivacyPolicy_CloseButton= By.xpath("//button[@title='Close']");
	public static By shippingAccordion=By.xpath("//h2[contains(text(),'Shipping')]");
	public static By OrderReviewAccordion=By.xpath("//h2[contains(text(),'Order Review')]");
	public static By paymentAccordion=By.xpath("//h2[contains(text(),'Payment')]");
	public static By BillingPage_OrderTotal=By.xpath("//div[@class='checkout-order-totals']//tr[@class='order-total']//td//following-sibling::td");
	public static By BillingPage_PaymentSection_Tab_Opened=By.xpath("//div[@class='checkout-tab-head open']/h2[contains(text(),'Payment')]");

	


	
	


}
