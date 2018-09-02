package com.prevail.pom;

import org.openqa.selenium.By;

public class OrderConfirmationPOM {
	
	public static By orderconfirmation_Heading=By.xpath("//h1[contains(text(),'Thank you for your order.')]");
	public static By order_confirmation_heading=By.xpath("//h1[contains(text(),'Thank you for your order.')]");
	public static By order_confirmation_order_date_heading=By.xpath("//div[@class='order-date']//span[@class='label']");
	public static By order_confirmation_order_number_heading=By.xpath("//h1[@class='order-number']//span[@class='label']");
	public static By order_confirmation_order_number=By.xpath("//h1[@class='order-number']//span[@class='value']");
	public static By order_confirmation_order_date=By.xpath("//div[@class='order-date']//span[@class='value']");
	public static By order_confirmation_product_link=By.xpath("//div[@class='product-list-item']/div[@class='name']/a");
	public static By order_confirmation_shipment1_heading=By.xpath("//div[@class='order-shipments']//h2");
	public static By order_confirmation_item_number_heading=By.xpath("//div[@class='sku']/span[@class='label']");
	public static By order_confirmation_sku_div=By.xpath("//div[@class='sku']");
	public static By order_confirmation_sku=By.xpath("//div[@class='sku']/span[@class='value']");
	public static By order_confirmation_product_details_div=By.xpath("//div[@class='product-list-item']");
	public static By order_confirmation_line_item_price=By.xpath("//div[@class='line-item-price']");
	public static By order_confirmation_line_item_quantity=By.xpath("//div[@class='line-item-quantity']");
	public static By order_confirmation_line_item_price1=By.xpath("//div[@class='line-item-price']");
	public static By order_confirmation_line_item_quantity1=By.xpath("//div[@class='line-item-quantity']");
	public static By order_confirmation_shipping_address=By.xpath("//div[@class='order-shipment-address']");
	public static By order_confirmation_shipping_addressMain=By.xpath("//div[@class='order-shipment-address']//div[@class='address']");
	public static By order_confirmation_shipping_address1=By.xpath("//div[@class='order-shipment-address']");
	public static By order_confirmation_return_to_shopping_link=By.xpath("//a[@class='continue']");
	
	public static By order_confirmation_shipping_status_heading=By.xpath("//div[@class='shipping-status']/div[@class='label']");
	public static By order_confirmation_shipping_status=By.xpath("//div[@class='shipping-status']/div[@class='value']");
	public static By order_confirmation_shipping_method_heading=By.xpath("//div[@class='shipping-method']/div[@class='label']");
	public static By order_confirmation_shipping_method=By.xpath("//div[@class='shipping-method']/div[@class='value']");
	public static By order_confirmation_shipping_div=By.xpath("//div[@class='order-shipment-table']");
	public static By order_confirmation_billing_div=By.xpath("//div[@class='order-billing']");
	public static By order_confirmation_billing_address=By.xpath("//div[@class='order-billing']/div[@class='mini-address-location']");
	public static By order_confirmation_payment_div=By.xpath("//div[@class='order-payment-instruments']");
	public static By order_confirmation_payment_type=By.xpath("//div[@class='payment-type']");
	public static By order_confirmation_amount_heading=By.xpath("//div[@class='payment-amount']/span[@class='label']");
	public static By order_confirmation_amount=By.xpath("//div[@class='payment-amount']/span[@class='value']");
	public static By order_confirmation_order_total=By.xpath("//tr[@class='order-total']//td[@class='order-value']");
	public static By order_confirmation_payment_total_heading=By.xpath("//tr[@class='order-total']//td[@class='order-value']");

	public static By order_confirmation_subtotal_heading=By.xpath("//tr[@class='order-subtotal']/td[Contains(text(),'Subtotal')]");
	public static By order_confirmation_subtotalvalue=By.xpath("//tr[@class='order-subtotal']/td/following-sibling::td");
	public static By order_confirmation_shipping_charges_heading=By.xpath("//tr[@class='order-shipping']");
	public static By order_confirmation_sales_tax=By.xpath("//tr[@class='order-sales-tax']/td[contains(text(),'Sales Tax')]");
	public static By order_confirmation_sales_taxValue=By.xpath("//tr[@class='order-sales-tax']/td/following-sibling::td");
	public static By order_confirmation_order_totalHeading=By.xpath("//tr[@class='order-total']//td[contains(text(),'Order Total')]");
	public static By order_confirmation_ordertotal_value=By.xpath("//tr[@class='order-total']//td[@class='order-value']");

	

	public static By order_confirmation_create_account_heading=By.xpath("//h2[contains(text(),'Create Account')]");
	public static By order_confirmation_create_account_sub_heading=By.xpath("//div[@class='login-box-content clearfix']/p");
	
//	public static By order_confirmation_order_history_link_header= ;
//	public static By order_confirmation_order_history_order_number= ;


}
