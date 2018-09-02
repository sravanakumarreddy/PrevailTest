package com.prevail.pom;

import org.openqa.selenium.By;

public class BusinessManagerPOM {
	
	public static By bmUserName=By.xpath("//input[@name='LoginForm_Login']");
	public static By bmPassword=By.xpath("//input[@name='LoginForm_Password']");
	public static By loginButton=By.xpath("//button[@name='login']");
	public static By selectaSite=By.xpath("//span[@class='sod_label']");
	public static By selectaSitePrevail=By.xpath("//span[@title='PREVAIL']");
	public static By merchantToolsLink=By.xpath("//a[@class='merchant-tools-link']//span[@class='menu-overview-link-icon']");
	public static By selectCustomersLink=By.xpath("//div[@class='menu_items_bm']//a[contains(text(),'Customers')]");
	public static By selectSecondCustomers=By.xpath("//td[@class='overview_subtitle']//a[contains(text(),'Customers')]");
	public static By advanceLink=By.xpath("//a[contains(text(),'Advanced')]");
	public static By advanceEmailLink=By.xpath("//input[@name='WFCustomerAdvancedSearch_Email']");
	public static By advanceFindButton=By.xpath("//div[@id='D']//button[@name='parametricSearch']");
	public static By emailID=By.xpath("(//a[@class='table_detail_link'])[2]");
	public static By userDeletebutton=By.xpath("//button[@name='confirmDelete']");
	public static By emailCheckbox=By.xpath("//input[@name='DeleteCustomer']");
	public static By DeleteButton=By.xpath("//button[@name='confirmDelete']");
	public static By OkButton=By.xpath("//button[@name='delete']");
	public static By LogoutButton=By.xpath("//a[@title='Log off.']");
	public static By simpleCustomerSearch=By.xpath("//input[contains(@name,'WFCustomerSimpleSearch_SearchTerm')]");
	public static By findButton=By.xpath("//button[@id='searchFocus']");

}
