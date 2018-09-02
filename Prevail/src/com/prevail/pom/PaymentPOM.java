package com.prevail.pom;

import org.openqa.selenium.By;

public class PaymentPOM {
	
	public static By Payment_NameOnCard_Textbox=By.id("dwfrm_billing_paymentMethods_creditCard_owner");
	public static By Payment_Type_Dropdown=By.id("wfrm_billing_paymentMethods_creditCard_type");
	public static By Payment_Number_Textbox=By.xpath("//input[contains(@id,'dwfrm_billing_paymentMethods_creditCard_number')]");
	public static By Payment_Expiration_Month_Dropdown=By.id("dwfrm_billing_paymentMethods_creditCard_expiration_mont");
	public static By Payment_Expiration_Year_Dropdown=By.id("dwfrm_billing_paymentMethods_creditCard_expiration_year");
	public static By Payment_Security_Textbox=By.xpath("//input[contains(@id,'dwfrm_billing_paymentMethods_creditCard_cvn')]");
	public static By Payment_WhyisThis_Tooltip=By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//a[@class='tooltip']");
	public static By Payment_PlaceOrderButton=By.xpath("//button[@name='dwfrm_billing_save']");
	
/*	public static By Payment_Number_Textbox=By.id("payment-cardnumber");
	public static By Payment_NameOnCard_Textbox=By.id("payment-cardholdername");
	public static By Payment_Expiration_Month_Dropdown=By.id("payment-expirydate-month");
	public static By Payment_Expiration_Year_Dropdown=By.id("payment-expirydate-year");
	public static By Payment_Security_Textbox=By.xpath("payment-cvc");
	public static By Payment_WhyisThis_Tooltip=By.xpath("//div[@id='PaymentMethod_CREDIT_CARD']//a[@class='tooltip']");
	public static By Payment_PlaceOrderButton=By.id("payment-submit");*/

}
