package com.prevail.checkout;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.CheckoutIlpPOM;
import com.prevail.pom.MiniCartPOM;
import com.prevail.pom.MultiShippingPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.GetDriver;
import com.prevail.utilgeneric.TestData;

public class SPC_MultiShippingGuest extends BaseTest {

	String ProductNameinOrderSummarySection;
	String ProductNameinCartPage;
	String OS_Subtotal;
	String OS_ShippingValue;
	String OS_SalesTax;
	Float CItemSalesPrice;
	
	
@Test(groups="{Regression}",description="128318/288381/288387/288396/288402/289676/289680")
public void TC01_MPCShipping_UI() throws Exception
{
	//navigate to shipping page
	log.info("Add 2 products to cart");
	cart.navigateToCart("2");
	log.info("Click on checkout button top");
	l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	Thread.sleep(6000);
	log.info("Clicking on checkout as a guest button");
	l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
	Thread.sleep(6000);
	log.info("Shipping page Heading");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
	//click on yes button 'Do you want multishipping' 
	log.info("click on yes button 'Do you want multishipping");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
	Thread.sleep(2000);
	log.info("To verify Shipping Address should not be displayed on Right Nav");
	sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_OrderSummary_FirstShippingAddress_Block),"Address block should not be displayed");
	//verify the UI
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Shipping_Single_Address_Text),"ship-to-single button displayed");
	int count=l1.getWebElements(MultiShippingPOM.Shipping_Multiple_CartRow).size();
	for(int i=0;i<count;i++)
		{
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_ProductName_Link, i),"Product name display");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_ProductPrice, i),"Product Price display");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_ProductColor_Attribute, i),"Product Color");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_ProductSize_Attribute, i),"Product Size");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_ProductSku, i), "Product SKU display");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_ProductQty, i),"Product Qty display");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link, i), "Edit Address link display");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_ProductImage, i), "Product Image display");
			sa.assertEquals(l1.getWebElements(MultiShippingPOM.MultiShipping_Address_Dropdown).get(i).getText(), MultiShippingPOM.ShippingAddressDropdownText);
		}
	//SHIPPING LOCATION
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Shipping_Multiple_Address_ShippingLocation_HeaderTab),"Shipping Location Header Tab");
	//continue to shipping button
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Shipping_Multiple_Address_Save_Button),"MultiShipping Continue button");

	//order summary section
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_Help_Section),"Order Summary Help Section");
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_Section),"Order Summary Section");
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_Products_Section),"OrderSummary_Products");
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_OrderTotal_Section),"OrderSummary_OrderTotal_Section");
	
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryQuantity),"Order Summary Quantity");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarysubtotalLabel),"Order Summary SubtotalLabel");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarysubtotalValue),"Order Summary Subtotal Value");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryshippingValue),"Order Summary Shipping Value");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarySalestaxValue),"Order Summary Sales Tax Value");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryEditLink),"Order Summary Edit link");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarysalestax),"Order Summary Sales Tax");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummaryOrderTotal),"Order Summary Order Total");
	sa.assertTrue(gVar.assertVisible(ShippingPOM.shippingOrderSummarOrderValue),"Order Summary Order Value");
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="128323/128324/289814/289838")
public void TC02_UI_Add_Edit_Address_Overlay() throws Exception
{
	int count=l1.getWebElements(MultiShippingPOM.Shipping_Multiple_CartRow).size();
	for(int i=0;i<count;i++)
		{

			l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(i).click();
			Thread.sleep(2000);
			//verify the navigation
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditOverlay_Div),"Add/Edit Address Overlay");
			//verify the UI
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Heading),"Overlaay Heading");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button),"Overlaay Close Button");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_SelectAddress_Label),"Overlaay SelectAddress_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_SelectAddress_Dropdown),"Overlaay SelectAddress_Dropdown");
			//first name	
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Label),"Overlaay FirstName_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox),"FirstName Textbox");
			//last name
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Label),"Overlaay LastName_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Textbox),"LastName Textbox");
			//address1
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Label),"Overlaay Address1_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox),"Address1 Textbox");
			//address2
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address2_Label),"Overlaay Address2_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address2_Textbox),"Address2 Textbox");
			//Country
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Country_Label),"Overlaay Country_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Country_Textbox),"Country Textbox");
			//State
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_State_Label),"Overlaay State_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_State_Textbox),"State Textbox");
			//City
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Label),"Overlaay City_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox),"City Textbox");
			//Zip Code
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Label),"Postal Textbox");  
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox),"Overlaay Postal_Label");
			//Phone
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Label),"Overlaay Phone_Label");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox),"Phone Textbox");

			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Save_Button),"Overlay Save Button");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Cancel_Button),"Overlay Cancel Button");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button),"Overlay Close Button");
			//APO/FPO
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_APO_FPO_Tooltip),"Overlay APO/FPO ToolTip");
			//Why This required
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_WhyThisRequired_Tooltip),"Why This required ToolTip");
			//Example: 333-333-3333
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_PhoneNo_Static_Text),"Example: 333-333-3333 display");
			
			//Click Outside the overlay
			log.info("Click Outside the Overlay");
			//Background color
	    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_FrontUI).getCssValue("background-color"),MultiShippingPOM.BackgroungColor);
			l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_FrontUI).click();
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_EditOverlay_Div),"Overlay should not be closed");	
			
			log.info("Click on cancel button");
			l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Cancel_Button).click();
			Thread.sleep(3000);
		}
	
	//It will return all the assertions
	sa.assertAll();
}


@Test(groups="{Regression}",description="289682/128325/289678/289685/289686/156078")
public void TC03_MPCShipping_Continue_TO_ShippingMTD_Button_Functionality_And_UI() throws Exception
{
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
		   gVar.handlingDropdown(MultiShippingPOM.MultiShipping_Address_Dropdown, i, j);
		//_setSelected(_select("dwfrm_multishipping_addressSelection_quantityLineItems_i"+$i+"_addressList"),$j);
		j++;
		}
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).isEnabled();
	log.info("To verify Shipping Address should not be displayed on Right Nav");
	sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_OrderSummary_FirstShippingAddress_Block),"Address block should not be displayed");	
	log.info("navigation to Select shipping method");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
	Thread.sleep(3000);
	//verify the navigation to Select shipping method
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Shipping_Multiple_Address_SelectShippingMethod_Section),"Select Shipping Method dropdown");
	//verify the shipments
	int numOfShipments=l1.getWebElements(MultiShippingPOM.MultiShipping_SelectShippingMethod_Dropdown).size();
	sa.assertEquals(numOfShipments, 2, "No of Shipment methods should be 2");
	sa.assertEquals(l1.getWebElements(MultiShippingPOM.MultiShipping_OrderSummary_Product_LineItems).size(), 2, "No of Line items should be 2 in Order Summary");
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Multishipping_RightNav_Shipment1_StaticText),"Shipment1_StaticText");
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Multishipping_RightNav_Shipment2_StaticText),"Shipment2_StaticText");

	//Verify the UI
	for(int i=0;i<numOfShipments;i++)
	{
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_ShipmentPage_Address, i), GetData.getDataFromExcel("\\data\\Checkout.xls","ShippingAddress",i+1,17),"Address verification in Shipment page: "+i);
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_SelectShippingMethod_Dropdown,i),"Shipment Displayed");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_Product_DesktopImage,i),"Product Image display");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_ProductName,i),"Product Price display");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_ProductPrice,i),"Product Price display");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_ColorAttribute,i),"Product Color Display");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_SizeAttribute,i),"Product Size display");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_Qty_Label,i),"Product Qty label display");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_OrderSummary_Qty_Value,i),"Product Qty Value");
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_RightNav_ShippingBlock_Heading,i),"ShippingBlock_Heading:"+i);
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_RightNav_ShippingBlock_EditLink,i),"ShippingBlock_EditLink:"+i);
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_RightNav_ShippingAddress,i),"ShippingBlock_Address:"+i);
		
	for(int k=0; k<3;k++)
	{
		log.info("Verification of Shipments Methods display");
		String ShipmentMtd=driver.findElements(By.xpath("//select[@name='dwfrm_multishipping_shippingOptions_shipments_i"+i+"_shippingMethodID']/option")).get(k).getText();
		sa.assertEquals(ShipmentMtd, GetData.getDataFromExcel("\\data\\Checkout.xls", "ShippingAddress", k+1, 16));		
	}
	}
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="128328/128329")
public void TC04_MPCShipping_GiftMessage_Functionality() throws Exception
{
	int count=l1.getWebElements(MultiShippingPOM.MultiShipping_Shipment_Table).size();
	if(count>0)
		{
		for(int i=0;i<count;i++)
			{
			//verify the 'is this a gift' section 
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_Section, i),"GiftMessage_Section Display");
			//by default no should select
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_No_Radio_Button,i),"Gift Message No Radio Button");
			log.info("No Radio Button already selected");
			l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_No_Radio_Button).get(i).isSelected();
			//selecting yes button
			log.info("Click on Yes Radio Button");
			l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_Yes_Radio_Button).get(i).click();
			//verifying the message text field
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_TextLabel,i),"Gift Message static text");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_TextArea, i),"Gift Box TextArea");
			//selecting no radio button
			log.info("Click on No Radio Button");
			l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_No_Radio_Button).get(i).click();
			//verify the display of message box
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_TextBox_Hidden, i),"Gift Message Hidden: "+i);
			//message field validation
			log.info("Click on Yes Radio Button");
			l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_Yes_Radio_Button).get(i).click();
			//verifying the message text field
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_TextLabel,i),"Gift Message static text");
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_TextArea, i),"Gift Box TextArea");
			//enter more than 150 characters in textbox and verify the max length
			l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_TextArea).get(i).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,13));
			sa.assertEquals(l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_TextArea).get(i).getText().length(), GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",2,13));			
			sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_GiftMessage_Character_Count, i),"Gift Message Character count Div");
			sa.assertEquals(l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_Character_Count).get(i).getText(), GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,14));
			//selecting no radio button
			log.info("Click on No Radio Button");
			l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_No_Radio_Button).get(i).click();
			}	
		}
	else
		{
		sa.assertTrue(false,"False");
		}
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="156074")
public void TC05_MPCShipping_ShipmentPage_Continue_Button_Functionality() throws Exception
{
	//click on continue button
	l1.getWebElement(MultiShippingPOM.MultiShipping_Continue_To_Billing_Button).click();
	Thread.sleep(3000);
	//verify the navigation to billing page
	sa.assertTrue(gVar.assertVisible(BillingPOM.BillingPage_PaymentSection_Tab_Opened),"Payment Tab Opened");
	sa.assertTrue(gVar.assertVisible(BillingPOM.billingPage_Heading),"Billing Page Heading");
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="125971/289816/289818/288412")
public void TC06_EditAddress_Overlay_APO_FPO_Why_Is_This_Required() throws Exception
{
		//click on go strait to checkout link
		log.info("Mouse Hover Mini Cart Link");
		gVar.MouseHover(MiniCartPOM.MiniCartLink);
		log.info("Click on Micart Checkout");
		l1.getWebElement(MiniCartPOM.MiniCartGoStraightToCheckoutButton).click();
		Thread.sleep(3000);
		log.info("Clicking on checkout as a guest button");
		l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
		//click on yes button 'Do you want multishipping' 
		log.info("click on yes button 'Do you want multishipping");
		l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
		Thread.sleep(4000);
		int count=l1.getWebElements(MultiShippingPOM.Shipping_Multiple_CartRow).size();
		if(count>0)
			{	
			for(int i=0;i<count;i++)
				{
				log.info("Click on ADD/Edit Address Link: "+i);
				l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(i).click();
				Thread.sleep(2000);
				//verify the functionality
				//mouse hovering on why is this required tool tip
				log.info("mouse hovering on why is this required tool tip");
				gVar.MouseHover(MultiShippingPOM.MultiShipping_EditAddressOverlay_APO_FPO_Tooltip);

	         //verifying the display of tool tip
	         if(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_APO_FPO_Tooltip).getAttribute("aria-describedby")!=null)
	               {
	                      sa.assertTrue(true,"APO/FPO Tool Text Area is displayed");
	               }
	         else
	               {
	        	 		sa.assertTrue(false,"APO/FPO Tool Text Area is not displayed");
	               }
	         
	         log.info("click on APO tooltip");
	        l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_APO_FPO_Tooltip).click();
	        Thread.sleep(3000);
	         //verify navigation
	         sa.assertEquals(gVar.assertEqual(MultiShippingPOM.Page_Breadcrumb_Element),"APO FPO", "APO FPO breadcrumb display");
	        sa.assertTrue(gVar.assertVisible(MultiShippingPOM.APO_FPO_PageHeading),"APO_FPO_PageHeading display");

	        log.info("Mouse Hover Mini Cart Link");
			gVar.MouseHover(MiniCartPOM.MiniCartLink);
			log.info("Click on Micart Checkout");
			l1.getWebElement(MiniCartPOM.MiniCartGoStraightToCheckoutButton).click();
			Thread.sleep(3000);
			log.info("Clicking on checkout as a guest button");
			l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
			//click on yes button 'Do you want multishipping' 
			log.info("Click on Yes Radio Button");
			l1.getWebElements(MultiShippingPOM.MultiShipping_GiftMessage_Yes_Radio_Button).get(i).click();
				
			log.info("Click on ADD/Edit Address Link: "+i);
			l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(i).click();
				//verify the functionality
			//mouse hovering on why is this required tool tip
			log.info("Mouse hover on Why is this Required");
			gVar.MouseHover(MultiShippingPOM.MultiShipping_EditAddressOverlay_WhyThisRequired_Tooltip);
	         //verifying the display of tool tip
			 if(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_WhyThisRequired_Tooltip).getAttribute("aria-describedby")!=null)
             {
                    sa.assertTrue(true,"WhyThisRequired Tooltip Text Area is displayed");
             }
       else
             {
      	 		sa.assertTrue(false,"WhyThisRequired Tooltip Text Area is not displayed");
             }		
	         
	         
	         //click on 'why is this required' tooltip link
	         l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_WhyThisRequired_Tooltip).click();
	         Thread.sleep(3000);
	         //verify navigation
	         sa.assertEquals(gVar.assertEqual(MultiShippingPOM.Page_Breadcrumb_Element),"Phone", "Phone breadcrumb display");	         	      
				}
			}
		else
		{
			sa.assertTrue(false);
		}
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description=" 128321")
public void TC07_EditAddressOverlay_Save_Button_Functionality() throws Exception
{
	//click on go strait to checkout link
	log.info("Mouse Hover Mini Cart Link");
	gVar.MouseHover(MiniCartPOM.MiniCartLink);
	Thread.sleep(1000);
	log.info("Click on Minicart Checkout");
	l1.getWebElement(MiniCartPOM.MiniCartGoStraightToCheckoutButton).click();
	Thread.sleep(3000);
	log.info("Clicking on checkout as a guest button");
	l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
	//click on yes button 'Do you want multishipping' 
	log.info("click on yes button 'Do you want multishipping");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
	//click on add/edit link
	log.info("Click on ADD/Edit Address Link: "+i);
	l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(0).click();
	
	//enter the address
	log.info("Enter shipping address First Name");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,1));
	log.info("Enter shipping address Last Name");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,2));
	log.info("Enter shipping address Address1 Name");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,3));
	log.info("Enter shipping address Address2 Name");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address2_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,4));
	log.info("Enter shipping address City Name");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,5));
	log.info("Enter shipping address ZipCode Name");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,6));
	Thread.sleep(3000);
	log.info("Enter shipping address Country Name");
	gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_Country_Textbox,GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,7));
	Thread.sleep(3000);
	log.info("Enter shipping address State Name");
	gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_State_Textbox,GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,8));
	Thread.sleep(3000);
	log.info("Enter shipping address Phone");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,9));
	
	//click on save button
	log.info("Click on Save button");
	l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Save_Button).click();
	//verify the address prepopulation in dropdown
//	int count=l1.getWebElements(MultiShippingPOM.Shipping_Multiple_CartRow).size();
//	for(int i=0;i<count;i++)
//		{
				//int length=_getText(_select("dwfrm_multishipping_addressSelection_quantityLineItems_i"+$i+"_addressList")).length;
//		var $savedAddress=_getText(_select("dwfrm_multishipping_addressSelection_quantityLineItems_i"+$i+"_addressList"))[$length-1].split(",");
//		//verifying the address
//		_assertEqual($addr_data2[0][1]+" "+$addr_data2[0][2],$savedAddress[0]);
//		_assertEqual($addr_data2[0][3],$savedAddress[1]);
//		_assertEqual($addr_data2[0][7],$savedAddress[2]);
//		_assertEqual($addr_data2[1][6],$savedAddress[3]);
//		_assertEqual($addr_data2[0][8],$savedAddress[4]);
		//_assertEqual($addr_data2[0][9],$savedAddress[5]);
//		}
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="128320/128322/289843")
public void TC08_Select_Button_AddOREdit_Address_Overlay() throws Exception
{
	//click on go strait to checkout link
	log.info("Mouse Hover Mini Cart Link");
	gVar.MouseHover(MiniCartPOM.MiniCartLink);
	Thread.sleep(1000);
	log.info("Click on Minicart Checkout");
	l1.getWebElement(MiniCartPOM.MiniCartGoStraightToCheckoutButton).click();
	Thread.sleep(3000);
	log.info("Clicking on checkout as a guest button");
	l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
	//click on yes button 'Do you want multishipping' 
	log.info("click on yes button 'Do you want multishipping");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
	
		log.info("Click on ADD/Edit Address Link: ");
		l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(0).click();
		//select the address from drop down
		gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_AddressDropdown_Options, " Fname Lname, 260 dennis st, Athens, TN, 37303 ");
		//click on select button
		//verify the address pre population
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,1));
		log.info("shipping address First Name");
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,1));
		log.info("shipping address Last Name");
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,2));
		log.info("shipping address Address1 Name");
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,3));
		log.info("shipping address Address2 Name");
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address2_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,4));
		log.info("shipping address City Name");
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,5));
		log.info("shipping address ZipCode Name");
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,6));
		Thread.sleep(3000);
		log.info("shipping address Country Name");
		//gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_Country_Textbox,GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,7));
		Thread.sleep(3000);
		log.info("shipping address State Name");
		//gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_State_Textbox,GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,8));
		Thread.sleep(3000);
		log.info("shipping address Phone");
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",4,9));
		//edit some fields
		
		//address1
		l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,15));
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",1,15));
		//city[2][15]
		l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox).sendKeys(GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",2,15));
		sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox),GetData.getDataFromExcel("//data//Checkout.xls","ShippingAddress",2,15));
		//click on cancel link
		log.info("click on cancel link");
		l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Cancel_Button).click();
		Thread.sleep(2000);
		//verify the functionality
		sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditOverlay_Div),"Dialop container not visible");
		sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Cancel_Button),"Cancel button not visible");
		sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button),"Close button not visible");
		//again click on add/edit address link
		log.info("Click on ADD/Edit Address Link: 1st link");
		l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(0).click();
		Thread.sleep(2000);
		log.info("click on close icon");
		l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button).click();
		Thread.sleep(2000);
		//verify the functionality
		sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditOverlay_Div),"Dialop container not visible");
		sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Cancel_Button),"Cancel button not visible");
		sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button),"Close button not visible");
	
		//It will return all the assertions
		sa.assertAll();
}

@Test(groups="{Regression}",description="128326")
public void TC09_OrderSummary_EditLink_Functionality() throws Exception
{
		//navigating to shipping page
		String productName=l1.getWebElements(MultiShippingPOM.MultiShipping_OrderSummary_ProductName).get(0).getText();
		//clicking on edit link present in the order Summary section
		log.info("Click on Edit Link");
		l1.getWebElement(MultiShippingPOM.MultiShipping_OrderSummary_Edit_Link).click();
		//cart navigation verification
		sa.assertTrue(gVar.assertVisible(CartPOM.CartTable),"Cart Table display");
		sa.assertTrue(gVar.assertVisible(CartPOM.Cart_Action_Bar));
		sa.assertTrue(gVar.assertVisible(CartPOM.cartProductName));
		sa.assertEquals(l1.getWebElements(CartPOM.cartProductName).get(0).getText(), productName);

		//fetch the price in cart
		if(l1.getWebElement(CartPOM.Cart_LineItemPrice).isDisplayed())
		{
			
			CItemSalesPrice=Float.parseFloat(l1.getWebElement(CartPOM.Cart_LineItem_SalesPrice).getText().replace("$", ""));
		}
//		
//		else if(_isVisible($CART_LINEITEM_DISCOUNT_PRICE))
//		{
//			CItemSalesPrice=_extract(_getText($CART_LINEITEM_DISCOUNT_PRICE),"/[$](.*)/",true).toString();
//		}
		//updating the quantity
		l1.getWebElements(CartPOM.cartQuantity).get(0).clear();
		l1.getWebElements(CartPOM.cartQuantity).get(0).sendKeys("5");
		//Handling alert popup
		Alert alert = GetDriver.driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		log.info("Enter Quantity 5");
		l1.getWebElements(CartPOM.cartQuantity).get(0).sendKeys("5");
		//click on update cart
		log.info("Click on Update Cart Button");
		l1.getWebElement(CartPOM.Cart_UpdateCart_Button).click();
		Thread.sleep(4000);
		//navigate to IL page
		log.info("Click on Cart Checkout Button");
		l1.getWebElement(CartPOM.cartCheckoutbuttonTop).click();
		Thread.sleep(2000);
		log.info("Clicking on checkout as a guest button");
		l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
		Thread.sleep(3000);
		//verify the cart updation
		//quantity
		sa.assertEquals(gVar.assertEqual(ShippingPOM.Shipping_RightNav_Qty_Value), 5, "Qty updated as in cart ");		
		//price
		Float ExpPrice=5*CItemSalesPrice;
		//Price in the order summary section
		sa.assertEquals(ExpPrice, l1.getWebElement(ShippingPOM.Shipping_RightNav_Price).getText().replace("$", ""), "Prime equal");
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="156076")
public void TC10_ShipmentPage_ProductName_Click_Functionality() throws Exception
{
	log.info("Clear cart items");
	cart.ClearCartItems();
	//navigate to shipping page
	log.info("Add 2 products to cart");
	cart.navigateToCart("2");
	log.info("Click on checkout button top");
	l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	Thread.sleep(2000);
	log.info("Click on minicart checkout link");
	log.info("Clicking on checkout as a guest button");
	l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
	Thread.sleep(2000);
	log.info("click on yes button 'Do you want multishipping'"); 
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
	
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
		   gVar.handlingDropdown(MultiShippingPOM.MultiShipping_Address_Dropdown, i, j);
		//_setSelected(_select("dwfrm_multishipping_addressSelection_quantityLineItems_i"+$i+"_addressList"),$j);
		j++;
		}
	log.info("Click on Shipping_Multiple_Address_Save_Button");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
	
	//click on name link
	String pName=l1.getWebElements(MultiShippingPOM.MultiShipping_ProductName_Link).get(0).getText();
	log.info("Click on 1st product link");
	l1.getWebElements(MultiShippingPOM.MultiShipping_ProductName_Link).get(0).click();
	//verify the navigation
	sa.assertEquals(l1.getWebElement("PDP_ProductName_Breadcrumb", "ShopNav\\PDP.properties").getText(), pName);
	sa.assertTrue(gVar.assertVisible("PDP_ProductName", "ShopNav\\PDP.properties"),"PDP product name display");
	sa.assertEquals(l1.getWebElement("PDP_ProductName", "ShopNav\\PDP.properties").getText(), pName);
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="156079")
public void TC11_ShipmentPage_RightNav_ShippingAddress_EditLink() throws Exception
{
	log.info("Clear cart items");
	cart.ClearCartItems();
	//navigate to shipping page
	log.info("Add 2 products to cart");
	cart.navigateToCart("2");
	log.info("Click on checkout button top");
	l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	Thread.sleep(2000);
	log.info("Click on minicart checkout link");
	log.info("Clicking on checkout as a guest button");
	l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
	Thread.sleep(2000);
	log.info("click on yes button 'Do you want multishipping");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
	
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
		   gVar.handlingDropdown(MultiShippingPOM.MultiShipping_Address_Dropdown, i, j);
		//_setSelected(_select("dwfrm_multishipping_addressSelection_quantityLineItems_i"+$i+"_addressList"),$j);
		j++;
		}
	log.info("Click on Shipping_Multiple_Address_Save_Button");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
	
	log.info("Click on Right Nav 1st Shipping Address Edit link");
	l1.getWebElement(MultiShippingPOM.MultiShipping_ShipmentPage_FirstAddress_EditLink).click();
	Thread.sleep(3000);
	
	String Address=l1.getWebElements(MultiShippingPOM.MultiShipping_Address_Dropdown_SelectedAddress).get(0).getText();
	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link),"Add/Edit Address Link");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).isEnabled();
	
	log.info("Clear cart items");
	cart.ClearCartItems();
	//navigate to shipping page
	log.info("Add 2 products to cart");
	cart.navigateToCart("2");
	log.info("Click on checkout button top");
	l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	Thread.sleep(2000);
	log.info("Clicking on checkout as a guest button");
	l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
	Thread.sleep(2000);
	log.info("click on yes button 'Do you want multishipping'"); 
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
	i=0;
	//It will return all the assertions
	sa.assertAll();
	
}
@Test(groups="{Regression}",dataProvider="MPCShippingValidations",dataProviderClass=Data.class, description="289820/289821/289824/289826/289830/289832/289834/289836")
public void TC12_EditAddress_Overlay_Validation(TestData t) throws Exception
{
		log.info("Loop: "+i);
		log.info("Click on ADD/Edit Address Link: "+i);
		l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(0).click();
		Thread.sleep(5000);
		 if(l1.getWebElement(MultiShippingPOM.MultiShipping_EditOverlay_Div).isDisplayed())
			 {
			 	BaseTest.log.info("Enter shipping address First Name");
				BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox).sendKeys(t.get(0));
				BaseTest.log.info("Enter shipping address Last Name");
				BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Textbox).sendKeys(t.get(1));
				BaseTest.log.info("Enter shipping address Address1 Name");
				BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox).sendKeys(t.get(2));
				BaseTest.log.info("Enter shipping address Address2 Name");
				BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address2_Textbox).sendKeys(t.get(3));
				BaseTest.log.info("Enter shipping address City Name");
				BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox).sendKeys(t.get(4));
				BaseTest.log.info("Enter shipping address State Name");
				gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_State_Textbox,t.get(5));
				Thread.sleep(3000);
				BaseTest.log.info("Enter shipping address ZipCode Name");
				BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox).sendKeys(t.get(6));
				Thread.sleep(3000);
				//BaseTest.log.info("Enter shipping address Country Name");
				//BaseTest.gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_Country_Textbox,GetData.getDataFromExcel(Excel,SheetName,Row,7));
				//Thread.sleep(3000);
				BaseTest.log.info("Enter shipping address Phone");
				BaseTest.l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox).sendKeys(t.get(7));
				
				 //blank field validation
				 if(i==0)
					 {
					 	log.info("Click on Shipping_Multiple_Address_Save_Button");
						l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
						
						//FNError message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_FN_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","FirstName_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_FN_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
				        
				    	//LNError message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_LN_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","LastName_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_LN_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
				        
				    	//Address1 Error message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_Address1_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Address1_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_Address1_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
				    	
				    	//City Error message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_City_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","City_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_City_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
				    	
				    	//State Error message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_State_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","State_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_State_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_State_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
				    	
				    	//Zipcode Error message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_Zipcode_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Zipcode_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_Zipcode_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
				    	
				    	//Phone Error message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_Phone_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Phone_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_Phone_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
		
				    	log.info("Click on Close icon");
				        l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button).click();
					 }
				 //cancel functionality without entering values
				 else if(i==1)
					 {
					 	
					 	log.info("Click on Shipping_Multiple_Address_Cancel_Button");
						l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Cancel_Button).click();
						
					 	sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditOverlay_Div),"Overlay should not be displayed");
					 	sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_AddressDropdown_Options),"Address Drop down should not be displayed");
					 }
				 //Special characters, Phone number invalid format and alphanumeric value
				 else if(i==2 || i==3 ||i==4)
					 {
					
					 	log.info("Click on Shipping_Multiple_Address_Save_Button");
						l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
						
						//Zip-code Error message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_Zipcode_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Zipcode_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_Zipcode_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
					 	
				    	//Phone Error message
				    	sa.assertEquals(gVar.assertEqual(MultiShippingPOM.MultiShipping_EditAddress_Phone_error), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","Phone_ErrorMessage"));
				    	//Text color FN
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddress_Phone_error).getCssValue("color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,0));
				    	//Box color
				    	sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox).getCssValue("background-color"),GetData.getDataFromExcel("\\data\\ProfileData.xls","Color",1,1));
								 						 	
				    	log.info("Click on Close icon");
				        l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button).click();
					 }
				 //Max characters
				 else if(i==5)
					 {
					 log.info("Max characters");
		        	 	
		        	 	log.info("Firstname");
		        		sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_FirstName_Textbox).getAttribute("maxlength"),50);
		        		log.info("Lastname");
		        		sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_LastName_Textbox).getAttribute("maxlength"),50);
		        		log.info("Address1");
		        		sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address1_Textbox).getAttribute("maxlength"),50);
		        		log.info("Address2");
		        		sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Address2_Textbox).getAttribute("maxlength"),50);
		        		log.info("City");
		        		sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_City_Textbox).getAttribute("maxlength"),50);
		        		log.info("Zipcode");
		        		sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Postal_Textbox).getAttribute("maxlength"),10);
		        		log.info("Phone");
		        		sa.assertEquals(l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Phone_Textbox).getAttribute("maxlength"),20);    
		        		
					 		 
				    	log.info("Click on Close icon");
				        l1.getWebElement(MultiShippingPOM.MultiShipping_EditAddressOverlay_Close_Button).click();
				        Thread.sleep(3000);
				        sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditOverlay_Div),"Overlay should not be displayed");
					 	sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_AddressDropdown_Options),"Address Drop down should not be displayed");					 		
					 }
				//cancel functionality after entering valid values
				 else if(i==6)
				 {
				   //Click on ESC key
				 	log.info("Hit ESC key");
				 	Actions action = new Actions(driver);
				 	action.sendKeys(Keys.ESCAPE);
				 	Thread.sleep(2000);
				 	sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditOverlay_Div),"Overlay should not be displayed");
				 	sa.assertTrue(gVar.assertNotVisible(MultiShippingPOM.MultiShipping_EditAddressOverlay_AddressDropdown_Options),"Address Drop down should not be displayed");					 												 
				 }
				 
				 else if(i==7)
					 {
					   //verify the saved address
					 	log.info("Click on Shipping_Multiple_Address_Save_Button");
						l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
					 	sa.assertTrue(gVar.assertVisible(MultiShippingPOM.MultiShipping_Dropdown_Saved_Address),"Saved address display");										 
					 }					 
			 }
		 else
			 {
			 	sa.assertTrue(false,"Add address Overlay is not displaying"); 
			 }			
	
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="288521")
public void TC13_MultiShipping_ProductImage_Click_Functionality() throws Exception
{
	try {
		log.info("click on Product image");
		l1.getWebElements(MultiShippingPOM.MultiShipping_ProductImage).get(0).click();
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Checkout_MultiShip),"MultiShipping page should be displayed");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Product image not clickable");
	}
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="288524/288527")
public void TC14_MultiShipping_OrderSummary_ProductImage_Name_Click_Functionality() throws Exception
{
	try {
		log.info("click on Product image");
		l1.getWebElements(MultiShippingPOM.MultiShipping_OrderSummary_Product_DesktopImage).get(0).click();
		sa.assertTrue(gVar.assertVisible(MultiShippingPOM.Checkout_MultiShip),"MultiShipping page should be displayed");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Product image not clickable");
	}
	String ProductName=l1.getWebElement(MultiShippingPOM.MultiShipping_OrderSummary_ProductName).getText();
	log.info("Click on Product name");
	l1.getWebElement(MultiShippingPOM.MultiShipping_OrderSummary_ProductName).click();
	Thread.sleep(2000);
	//verify the navigation
	sa.assertEquals(l1.getWebElement("PDP_ProductName_Breadcrumb", "ShopNav\\PDP.properties").getText(), ProductName);
	sa.assertTrue(gVar.assertVisible("PDP_ProductName", "ShopNav\\PDP.properties"),"PDP product name display");
	sa.assertEquals(l1.getWebElement("PDP_ProductName", "ShopNav\\PDP.properties").getText(), ProductName);
	
	log.info("Clear cart items");
	cart.ClearCartItems();
	//It will return all the assertions
	sa.assertAll();
}

@Test(groups="{Regression}",description="156077")
public void TC13_Product_With_2Qty_SameAddress_ShipmentPage() throws Exception
{
	log.info("Clear cart");
	cart.ClearCartItems();
	log.info("Delete Address fronm Profile");
	p.DeleteAddress();
	log.info("Add 2 products to cart");
	cart.navigateToCart("2");
	log.info("Click on checkout button top");
	l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
	log.info("Clicking on checkout as a guest button");
	l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
	Thread.sleep(2000);
	log.info("click on yes button 'Do you want multishipping");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Button).click();
	
	for(int i=0;i<2;i++)
	{
		log.info("Click on ADD/Edit Address Link: "+i);
		l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(i).click();
		
		log.info("Entering same shipping address");
		checkout.MPC_ShippingAddress("//data//Checkout.xls","ShippingAddress",1);		
	}
	log.info("navigation to Select shipping method");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
	Thread.sleep(3000);
	sa.assertEquals(l1.getWebElements(MultiShippingPOM.MultiShipping_OrderSummary_Product_LineItems).size(), 1,"Single line item display");
	sa.assertEquals(l1.getWebElements(MultiShippingPOM.MultiShipping_OrderSummary_Qty_Value).get(0).getText(), "2","Item with Qty 2");
	log.info("Navigate back to Shipping Page");
	l1.getWebElement(MultiShippingPOM.MultiShipping_RightNav_FirstShipping_EditLink).click();
	Thread.sleep(3000);
	l1.getWebElements(MultiShippingPOM.MultiShipping_Add_OR_EditAddress_Link).get(1).click();
	log.info("Select Add New Address from Drop down");
	gVar.handlingDropdown(MultiShippingPOM.MultiShipping_EditAddressOverlay_SelectAddress_Dropdown, "Add New Address");
	log.info("Entering same shipping address");
	checkout.MPC_ShippingAddress("//data//Checkout.xls","ShippingAddress",2);
	log.info("navigation to Select shipping method");
	l1.getWebElement(MultiShippingPOM.Shipping_Multiple_Address_Save_Button).click();
	Thread.sleep(3000);
	//verify the shipments
	int numOfShipments=l1.getWebElements(MultiShippingPOM.MultiShipping_SelectShippingMethod_Dropdown).size();
	sa.assertEquals(numOfShipments, 2, "No of Shipment methods should be 2 in Shipment page");
	sa.assertEquals(l1.getWebElements(MultiShippingPOM.MultiShipping_OrderSummary_Product_LineItems).size(), 2, "No of Line items should be 2 in Order Summary");
	//It will return all the assertions
	sa.assertAll();
	
}

}