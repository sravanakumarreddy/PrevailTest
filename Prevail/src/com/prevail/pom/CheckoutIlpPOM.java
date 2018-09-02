package com.prevail.pom;

import org.openqa.selenium.By;

public class CheckoutIlpPOM {
	
	public static By Ilp_CheckoutasGuestButton=By.xpath("//button[@name='dwfrm_login_unregistered']");
	public static By Ilp_entiresection=By.xpath("//div[@class='checkoutlogin']");
	public static By Ilp_ReturningCustomersSection=By.xpath("//div[@class='login-box login-account']");
	public static By Ilp_CreateAccountNowButton=By.xpath("//button[@name='dwfrm_login_register']");
	public static By Ilp_SocialMediaLinks=By.xpath("//form[@id='dwfrm_oauthlogin']");
	public static By Ilp_EmailPassword_ErrorMessaages=By.xpath("//span[@class='error']");
	public static By Ilp_EditLink_OrderSummary=By.linkText("Edit");
	public static By Ilp_ProductNameLink=By.xpath("//div[@id='secondary']//div[@class='mini-cart-name']");
	public static By Ilp_ProductImage=By.xpath("//div[@id='secondary']//div[@class='mini-cart-image']/img[@class='desktop-only']");
	
	

}
