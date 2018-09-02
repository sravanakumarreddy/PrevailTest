package com.prevail.pom;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;

public class MultiShippingPOM {

//Static Text
public static String ShippingAddressDropdownText="No address available for selection";
public static String BackgroungColor="rgb(51,51,51)";	
public static String GroundShipment="Ground: $5.99 (Order received within 7-10 business days)"; 
public static String TwoDayShipment="2-Day Express: $9.99 (Order received in 2 business days)"; 
public static String OvernightShipment="Overnight: $15.99 (Order received the next business day)"; 
public static String Product1="25697151";
public static String Product2="25697378";

//MultiShipping generic objects
public static By Shipping_Single_Address_Text=By.xpath("//div[@class='ship-to-single']");
public static By Shipping_Single_Address_Button=By.xpath("//button[@name='dwfrm_multishipping_shipToSingle']");
public static By Shipping_Multiple_Address=By.xpath("//div[@class='ship-to-multiple']");
public static By Shipping_Multiple_Address_Button=By.xpath("//button[@name='dwfrm_singleshipping_shipToMultiple']");
public static By MultiShipping_Line_Item_First=By.xpath("//div[@class='checkoutmultishipping']//tr[contains(@class,' first')]");
public static By MultiShipping_Line_Item_First_Image=By.xpath("//div[@class='checkoutmultishipping']//tr[contains(@class,' first')]//img");
public static By MultiShipping_Line_Item_Second=By.xpath("//div[@class='checkoutmultishipping']//tr[@class='cart-row ']");
public static By Checkout_MultiShip=By.xpath("//div[@class='checkoutmultishipping']");
public static By MultiShipping_Add_OR_EditAddress_Link=By.xpath("//span[@class='edit']");
public static By Shipping_MultiShipping_Text=By.xpath("//div[contains(text(),'Do you want to ship to multiple addresses?')]");
public static By Shipping_Multiple_Address_Save_Button=By.xpath("//button[@name='dwfrm_multishipping_addressSelection_save']");
public static By Shipping_Multiple_Address_SelectShippingMethod_Section=By.xpath("//div[@class='checkoutmultishipping']//b[contains(text(),'Select Shipping Method:')]");
public static By Shipping_Multiple_Address_ShippingLocation_HeaderTab=By.xpath("//th[contains(text(),'Shipping Location')]");
public static By Shipping_Multiple_CartRow=By.xpath("//div[@class='checkoutmultishipping']//tr[starts-with(@class,'cart-row')]");

public static By MultiShipping_ProductName_Link=By.xpath("//div[@class='name']/a[@href]");
public static By MultiShipping_ProductImage=By.xpath("//div[@class='checkoutmultishipping']//td[@class='item-image']/img");
public static By MultiShipping_ProductPrice=By.xpath("//span[@class='price-sales']");
public static By MultiShipping_ProductColor_Attribute=By.xpath("//div[@class='checkoutmultishipping']//div[@data-attribute='color']");
public static By MultiShipping_ProductSize_Attribute=By.xpath("//div[@class='checkoutmultishipping']//div[@data-attribute='size']");
public static By MultiShipping_ProductSku=By.xpath("//div[@class='checkoutmultishipping']//div[@class='sku']");
public static By MultiShipping_ProductQty=By.xpath("//div[@class='checkoutmultishipping']//td[@class='quantitycolumn']");
public static By MultiShipping_Address_Dropdown=By.xpath("//select[starts-with(@name,'dwfrm_multishipping_addressSelection_quantityLineItems')]");
public static By MultiShipping_Address_Dropdown_SelectedAddress=By.xpath("//select[starts-with(@name,'dwfrm_multishipping_addressSelection_quantityLineItems')]/option[@selected]");
public static By MultiShipping_OrderSummary_Help_Section=By.xpath("//h3[contains(text(),'Help?')]/span");
public static By MultiShipping_OrderSummary_Section=By.xpath("//div[@id='secondary']");
public static By MultiShipping_OrderSummary_Products_Section=By.xpath("//div[@id='secondary']//div[@class='checkout-mini-cart']");
public static By MultiShipping_OrderSummary_Product_LineItems=By.xpath("//div[@id='secondary']//div[@class='mini-cart-product']");
public static By MultiShipping_OrderSummary_OrderTotal_Section=By.xpath("//div[@id='secondary']//div[@class='checkout-order-totals']");
public static By MultiShipping_OrderSummary_Product_DesktopImage=By.xpath("//div[@class='checkout-mini-cart']//div[@class='mini-cart-image']/img[@class='desktop-only']");
public static By MultiShipping_OrderSummary_ProductName=By.xpath("//div[@class='checkout-mini-cart']//div[@class='mini-cart-name']/a");
public static By MultiShipping_OrderSummary_Edit_Link=By.xpath("//div[@id='secondary']//a[@class='section-header-note']");
public static By MultiShipping_OrderSummary_FirstShippingAddress_Block=By.xpath("//div[@id='secondary']/div[contains(@class,' first')]");
public static By MultiShipping_OrderSummary_ColorAttribute=By.xpath("//div[@id='secondary']//div[@data-attribute='color']");
public static By MultiShipping_OrderSummary_SizeAttribute=By.xpath("//div[@id='secondary']//div[@data-attribute='color']");
public static By MultiShipping_OrderSummary_ProductPrice=By.xpath("//div[@id='secondary']//span[@class='mini-cart-price']");
public static By MultiShipping_OrderSummary_Qty_Label=By.xpath("//div[@id='secondary']//div[@class='mini-cart-pricing']/span[@class='label']");
public static By MultiShipping_OrderSummary_Qty_Value=By.xpath("//div[@id='secondary']//div[@class='mini-cart-pricing']/span[@class='value']");


//Shipment method page 
public static By MultiShipping_SelectShippingMethod_Dropdown=By.xpath("//select[starts-with(@name,'dwfrm_multishipping_shippingOptions_shipments')]");
public static By MultiShipping_Shipment_Table=By.xpath("//div[@class='checkoutmultishipping']//table");
public static By MultiShipping_GiftMessage_Section=By.xpath("//div[@class='form-row ']/label[contains(@for,'isGift')]");
public static By MultiShipping_GiftMessage_No_Radio_Button=By.xpath("//div[@class='form-row ']//input[@value='false']");
public static By MultiShipping_GiftMessage_Yes_Radio_Button=By.xpath("//div[@class='form-row ']//input[@value='true']");
public static By MultiShipping_GiftMessage_TextLabel=By.xpath("//label[contains(@for,'giftMessage')]/span[contains(text(),'Message')]");
public static By MultiShipping_GiftMessage_TextArea=By.xpath("//textarea[contains(@id,'giftMessage')]");
public static By MultiShipping_GiftMessage_TextBox_Hidden=By.xpath("//table[@class='item-list']//div[@class='form-row gift-message-text hidden']");
public static By MultiShipping_GiftMessage_Character_Count=By.xpath("//div[@class='char-count']");
public static By MultiShipping_GiftMessage_Character_RemainCount=By.xpath("//span[@class='char-remain-count']");
public static By MultiShipping_Continue_To_Billing_Button=By.xpath("//button[@class='button-fancy-large spc-multi-shipping-btn']");
public static By MultiShipping_RightNav_FirstShipping_EditLink=By.xpath("//div[@id='secondary']/div[contains(@class,' first')]//a");
public static By MultiShipping_ShipmentPage_FirstAddress_EditLink=By.xpath("//tr[@class='cart-row']/td[@rowspan='2']//a");
public static By Multishipping_RightNav_Shipment1_StaticText=By.xpath("//div[@id='secondary']//div[contains(text(),'Shipment No. 1')]");
public static By Multishipping_RightNav_Shipment2_StaticText=By.xpath("//div[@id='secondary']//div[contains(text(),'Shipment No. 2')]");
public static By MultiShipping_RightNav_ShippingBlock_Heading=By.xpath("//div[starts-with(@class,'mini-shipment order-component-block')]/h3");
public static By MultiShipping_RightNav_ShippingBlock_EditLink=By.xpath("//div[starts-with(@class,'mini-shipment order-component-block')]//a[contains(text(),'Edit')]");
public static By MultiShipping_RightNav_ShippingAddress=By.xpath("//div[starts-with(@class,'mini-shipment order-component-block')]//div[@class='address']");
public static By MultiShipping_ShipmentPage_Address=By.xpath("//td[@class='item-shipping-address']");
public static By MultiShipping_RightNav_ShipmentMethod=By.xpath("//div[starts-with(@class,'mini-shipment order-component-block')]//div[@class='minishipments-method']");

//Multishipping add overlay objects
public static By MultiShipping_EditOverlay_Div=By.xpath("//div[@id='dialog-container']");
public static By MultiShipping_EditAddressOverlay_SelectAddress_Dropdown=By.xpath("//select[@name='dwfrm_multishipping_editAddress_addressList']");
public static By MultiShipping_EditAddressOverlay_SelectedAddress_Dropdown=By.xpath("//select[@name='dwfrm_multishipping_editAddress_addressList']/option[@selected]");
public static By MultiShipping_EditAddressOverlay_AddressName_Textbox=By.id("dwfrm_profile_address_addressid");
public static By MultiShipping_EditAddressOverlay_FirstName_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_firstName");
public static By MultiShipping_EditAddressOverlay_LastName_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_lastName");
public static By MultiShipping_EditAddressOverlay_APO_FPO_Tooltip=By.xpath("//div[@class='form-field-tooltip']/a[contains(text(),'APO/FPO')]");
public static By MultiShipping_EditAddressOverlay_Address1_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_address1");
public static By MultiShipping_EditAddressOverlay_Address2_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_address2");
public static By MultiShipping_EditAddressOverlay_Country_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_country");
public static By MultiShipping_EditAddressOverlay_State_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_states_state");
public static By MultiShipping_EditAddressOverlay_City_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_city");
public static By MultiShipping_EditAddressOverlay_Postal_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_postal");
public static By MultiShipping_EditAddressOverlay_Phone_Textbox=By.id("dwfrm_multishipping_editAddress_addressFields_phone");
public static By MultiShipping_EditAddressOverlay_WhyThisRequired_Tooltip=By.xpath("//div[@class='form-field-tooltip']/a[contains(text(),'Why is this required?')]");
public static By MultiShipping_EditAddressOverlay_PhoneNo_Static_Text=By.xpath("//div[contains(text(),'Example: 333-333-3333')]");

public static By MultiShipping_EditAddressOverlay_AddToAddress_Checkbox=By.id("dwfrm_multishipping_editAddress_addToAddressBook");
public static By MultiShipping_EditAddressOverlay_Save_Button=By.xpath("//button[@name='dwfrm_multishipping_editAddress_save']");
public static By MultiShipping_EditAddressOverlay_Cancel_Button=By.xpath("//button[@name='dwfrm_multishipping_editAddress_cancel']");
public static By MultiShipping_EditAddressOverlay_Heading=By.xpath("//h1[contains(text(),'Add or Edit Addresses')]");

//public static By MultiShipping_EditAddressOverlay_ERROR_MESSAGE_PHONE=By.xpath("")$AddressES_ERROR_MESSAGE_PHONE;
//public static By MultiShipping_EditAddressOverlay_ERROR_MESSAGE=By.xpath(" ")$AddressES_ERROR_MESSAGE_EXISTING;

public static By MultiShipping_EditAddressOverlay_Close_Button=By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']");
public static By MultiShipping_EditAddressOverlay_SelectAddress_Label=By.xpath("//label[contains(text(),'Select an Address:')]");
public static By MultiShipping_EditAddressOverlay_FirstName_Label=By.xpath("//span[contains(text(),'First Name')]");
public static By MultiShipping_EditAddressOverlay_LastName_Label=By.xpath("//span[contains(text(),'Last Name')]");
public static By MultiShipping_EditAddressOverlay_Address1_Label=By.xpath("//span[contains(text(),'Address 1')]");
public static By MultiShipping_EditAddressOverlay_Address2_Label=By.xpath("//span[contains(text(),'Address 2')]");
public static By MultiShipping_EditAddressOverlay_Country_Label=By.xpath("//span[contains(text(),'Country')]");
public static By MultiShipping_EditAddressOverlay_State_Label=By.xpath("//span[contains(text(),'State')]");
public static By MultiShipping_EditAddressOverlay_City_Label=By.xpath("//span[contains(text(),'City')]");
public static By MultiShipping_EditAddressOverlay_Postal_Label=By.xpath("//span[contains(text(),'ZIP Code')]");
public static By MultiShipping_EditAddressOverlay_Phone_Label=By.xpath("//span[contains(text(),'Phone')]");
public static By MultiShipping_EditAddressOverlay_Address_Tooltip=By.xpath("//a[contains(text(),'APO/FPO')]");
public static By MultiShipping_EditAddressOveorlay_Phone_Tooltip=By.xpath("//a[contains(text(),'Why is this required?')]");
public static By MultiShipping_EditAddressOverlay_AddressDropdown_Options=By.xpath("//select[@name='dwfrm_multishipping_editAddress_addressList']/option");
public static By MultiShipping_EditAddressOverlay_FrontUI=By.xpath("//div[@class='ui-widget-overlay ui-front']");

//Multi-Shipping
public static By MultiShipping_EditAddress_FN_error=By.id("dwfrm_multishipping_editAddress_addressFields_firstName-error");
public static By MultiShipping_EditAddress_LN_error=By.id("dwfrm_multishipping_editAddress_addressFields_lastName-error");
public static By MultiShipping_EditAddress_Address1_error=By.id("dwfrm_multishipping_editAddress_addressFields_address1-error");
public static By MultiShipping_EditAddress_City_error=By.id("dwfrm_multishipping_editAddress_addressFields_city-error");
public static By MultiShipping_EditAddress_State_error=By.id("dwfrm_multishipping_editAddress_addressFields_states_state-error");
public static By MultiShipping_EditAddress_Zipcode_error=By.id("dwfrm_multishipping_editAddress_addressFields_postal-error");
public static By MultiShipping_EditAddress_Phone_error=By.id("dwfrm_multishipping_editAddress_addressFields_phone-error");

//Static
public static By MultiShipping_Dropdown_Saved_Address=By.xpath("//select//option[contains(text(),'Shashidhar Marihal, 261 dennis st, Athens, TN, 37302')]");

//Breadcrumb
public static By Page_Breadcrumb_Element=By.xpath("//div[@class='breadcrumb']/a[@class='breadcrumb-element']");
public static By APO_FPO_PageHeading=By.xpath("//p[contains(text(),'Using An APO/FPO Address')]");


}