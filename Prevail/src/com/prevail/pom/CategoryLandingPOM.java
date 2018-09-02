package com.prevail.pom;

import org.openqa.selenium.By;

public class CategoryLandingPOM {
	
	static String div="//div[@class='compare-items']";

	public static By CLP_Refinement_Active_Link=By.xpath("//li[@class='expandable fa fa-angle-right active fa-angle-down']/a[contains(@class,'active')]");
	public static By CLP_LeftNav_Category_Link=By.xpath("//ul[@id='category-level-1']/li[@class='expandable fa fa-angle-right']/a");
	public static By CLP_LeftNav_SubCategory_Link=By.xpath("//ul[@id='category-level-2']//a[@class='refinement-link ']");
	public static By CLP_LeftNav_SizeRefinement=By.xpath("//div[@class='refinement size']//li/a");
	public static By CLP_LeftNav_TypeRefinement=By.xpath("//div[@class='refinement batteryType']//li/a");
	public static By CLP_SizeRefinement_ClearLink=By.xpath("//div[@class='refinement size']/div[@class='clear-refinement']/a");
	public static By CLP_LeftNav_Link_Tile=By.xpath("//div[@id='secondary']//li/a");
	public static By CLP_SalesPrice=By.xpath("//span[@class='product-sales-price']");
	public static By CLP_SortBy_Options=By.xpath("//select[@id='grid-sort-header']/option");
	public static By CLP_SortBy_Top_SelectedValue=By.xpath("//select[@id='grid-sort-header']/option[@selected]");
	public static By CLP_SortBy_Bottom_SelectedValue=By.xpath("//select[@id='grid-sort-footer']/option[@selected]");
	public static By CLP_ItemsPerPage_TopDropdown_Options=By.xpath("//select[@id='grid-paging-header']/option");
	public static By CLP_ItemsPerPage_TopDropdown=By.xpath("//select[@id='grid-paging-header']");
	public static By CLP_ItemsPerPage_TopDropdown_Selected=By.xpath("//select[@id='grid-paging-header']/option[@selected='selected']");
	public static By CLP_ItemsPerPage_BottomDropdown_Options=By.xpath("//select[@id='grid-paging-footer']/option");
	public static By CLP_ItemsPerPage_BottomDropdown_Selected=By.xpath("//select[@id='grid-paging-footer']/option[@selected='selected']");
	public static By RootCategory_ShopLinks=By.xpath("//ul[@id='category-level-1']/li/a");
	public static By RootCategory_Slots=By.xpath("//div[@class='category-slot']//a");
	
	//Compare related Web-Elements
	//CLP compare bar
	public static By CLP_Compare_Checkbox=By.xpath("//div[@class='product-compare label-inline']//input[@class='compare-check']");
	public static By CLP_CompareItems_Div=By.xpath(div);
	public static By CLP_CompareItemsDiv_ActiveProduct=By.xpath("//div[@class='compare-item active']/img");
	public static By Compare_Item_Button=By.xpath("//button[@id='compare-items-button']");
	public static By CLP_CompareClearButton=By.xpath("//button[@id='clear-compared-items']");
	public static By Compare_Items_Static_Text=By.xpath(div+"/h2[contains(text(),'Compare up to 6 products:')]");
	public static By Compare_Widget_Boxes=By.xpath("//div[@class='compare-items-panel']/div[starts-with(@class,'compare-item')]");
	public static By Comapre_Active_Items=By.xpath("//div[@class='compare-item active']");
	public static By Compare_Items_RemoveLink=By.xpath("//div[@class='compare-item active']/a[@class='compare-item-remove']");
	public static By Compare_Items_Images=By.xpath("//div[@class='compare-item active']/img");
	
	//Compare Page
	public static By ComparePage_Heading=By.xpath("//h1[contains(text(),'Compare')]");
	public static By ComparePage_BackToResults_link=By.xpath("//a[@class='back']");
	public static By ComparePage_Remove_link=By.xpath("//a[@class='remove-link']");
	public static By ComparePage_Product_Image=By.xpath("//a[@class='thumb-link']");
	public static By ComparePage_Product_Name=By.xpath("//a[@class='name-link']");
	public static By ComparePage_Product_Price=By.xpath("//div[@class='product-pricing']/span[@class='product-sales-price']");
	public static By ComparePage_Product_rating=By.xpath("//div[@class='product-review']");
	public static By ComparePage_AddToCart_Button=By.xpath("//button[@class='open-quick-view button-fancy-small']");
	public static By ComparePage_AddToWishlist_Button=By.xpath("//a[contains(text(),'Add to Wishlist')]");
	public static By ComparePage_AddToGiftRegister_Button=By.xpath("//a[contains(text(),'Add to gift registry')]");
	public static By ComparePage_OtherItems_StaticText=By.xpath("//label[contains(text(),'Other Compare Items')]");
	public static By ComparePage_Categorylist_Dropdown=By.xpath("//select[@id='compare-category-list']");
	public static By ComparePage_QuickView_Button=By.xpath("//a[@id='quickviewbutton']");
	public static By ComparePage_Quickview_Dialog=By.xpath("//div[@id='QuickViewDialog']");
	public static By ComparePage_Quickview_Dialog_Productname=By.xpath("//h1[@class='product-name']");
	public static By ComparePage_Quickview_CloseButton=By.xpath("//button/span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']"); 
	
	//Gift Registry
	public static By GiftRegistry_Heading=By.xpath("//div[@id='primary']/h1[contains(text(),'Gift Registry')]");

	
	
}





