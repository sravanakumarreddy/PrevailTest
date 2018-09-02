package com.prevail.pom;

import org.openqa.selenium.By;

public class PDP_BundlePOM
{

	public static By BundleProd_TotalBundles=By.xpath("//div[@class='product-set-item product-bundle-item']");
	public static By BundleProd_TotalBundleProNames=By.xpath("//a[@class='item-name']");
	public static By BundleProd_ProductName=By.xpath("//div[@id='pdpMain']//h1");
	public static By Bundle_WishListLink=By.xpath("//a[@title='Add this product to wishlist']");
	public static By Bundle_AddToGiftregistry=By.xpath("//a[@title='Add this product to gift registry']");
	public static By Bundle_giftRegistry_Heading=By.xpath("//h1[contains(text(),'Gift Registry Login')]");
	public static By Bundle_GiftRegistryLoggedInHeading=By.xpath("//h1[contains(text(),'Gift Registry')]");
	public static By Bundle_CartProdName=By.xpath("//tr[@class='rowbundle']//td[@class='item-details']//div[@class='name']/a");
	public static By Standared_CartProdName=By.xpath("//td[@class='item-details']//div[@class='name']/a");
	public static By Bundle_MainBundleImage=By.xpath("//div[@class='product-primary-image']");
	public static By Bundle_AlternateImages=By.xpath("//div[@id='thumbnails']");
	public static By Bundle_MainProduct_ItemId=By.xpath("//span[@itemprop='productID']");
	public static By Bundle_ProductNumber=By.xpath("//div[@class='product-number']");
	public static By Bundle_BundleProdPrice=By.xpath("//div[@class='product-price']");
	public static By Bundle_BundleQty=By.xpath("//span[@class='label']");
	public static By Bundle_AvailabilityMsgLabel=By.xpath("//label[contains(text(),'Availability')]");
	public static By Bundle_ProdSetImages=By.xpath("//div[@class='product-set-image']/img");
	public static By Bundle_ShareIcons=By.xpath("//a[@class='share-icon']");
	public static By Bundle_SubCategory=By.xpath("//a[contains(text(),'Gaming')]");
	public static By Bundle_gamingConsoleFilter=By.xpath("//a[contains(text(),'Game Consoles')]");
	public static By Bundle_PreviousLink=By.xpath("//div[@class='product-previous divided']/a");
	public static By Bundle_NextLink=By.xpath("//div[@class='product-next']/a");
	public static By Bundle_BreadCrumbElements=By.xpath("//div[@class='breadcrumb']/a");
	public static By Standared_TotalSizes=By.xpath("//ul[@class='swatches size']//li");
	public static By Standared_TotalWidthCount=By.xpath("//ul[@class='swatches width']//li");
	public static By Standared_StrikeoutPrice=By.xpath("//span[@class='price-standard']");
	public static By Standared_ActualPrice=By.xpath("//span[@class='price-sales']");
	public static By Standared_SelecteStyleAvailability_Mes=By.xpath("//div[@class='availability-novariation']");
	public static By QuantityLabel=By.xpath("//label[@for='Quantity']");
	public static By Standared_QtyTextbox=By.xpath("//input[@id='Quantity']");
	public static By Standared_PDPTabSection=By.xpath("//div[@class='tab']");
	public static By Standared_RecommandationSection=By.xpath("//div[@class='recommendations cross-sell']");
	public static By Standared_ProdNameinRecommondationSection=By.xpath("//div[@class='recommendations cross-sell']//div[@class='product-name']/a");
    public static By Standared_RecommondationImage=By.xpath("//img[@class='desktop-only']");
    public static By Standared_CheckStoreAvailabilityLink=By.xpath("//span[@class='label set-preferred-store']/a");
    public static By StoreAvailability_ZipcodeTextbox=By.id("user-zip");
    public static By StoreAvailabilty_SearchButton=By.xpath("//div[@class='ui-dialog-buttonset']//span[contains(text(),'Search')]");
    public static By StoreAvailability_ChangeLocationButton=By.xpath("//span[contains(text(),'Change Location')]");
    public static By StoreAvailability_ContinueButton=By.xpath("  //span[contains(text(),'Continue')]");
    public static By StoreAvailabilitySelectstore_Dailog=By.xpath("//span[contains(text(),'Select Store')]");
    public static By StoreAvailabilityClose_link=By.xpath("//button[@title='Close']");
    public static By StoreAvailability_StoreAddress=By.xpath("//p[@class='store-address']");
    public static By StoreAvailability_StoreStatus=By.xpath("//p[@class='store-status']");
    public static By StoreAvailabilty_SelecteStoreButton=By.xpath("//button[@class='select-store-button']");
    public static By PDP_StoreAddress=By.xpath("//div[@class='store-address']");
    public static By Standared_AvailabilityCheck=By.xpath("//div[@class='availability-instore']");
    public static By Standared_Availabilityforpickup_Text=By.xpath("//label[contains(text(),'Available for Pickup')]");
    public static By Standared_Storesearchoverlay_Text=By.xpath("//span[contains(text(),'at a store near you')]");
    public static By Standared_youmightalsoLike_Text=By.xpath("//label[contains(text(),'You Might Like')]')]");
    public static By Standared_Discription_Text=By.xpath("//label[contains(text(),'Description')]");
    public static By Standared_ProductDetails_Text=By.xpath("//label[contains(text(),'Product Details')]");
    public static By Standared_Reviews_Text=By.xpath("//label[contains(text(),'Reviews')]");
    public static By StoreAvailability_PrefferedStoreButton=By.xpath("//button[contains(text(),'Preferred Store')]");
    public static By Standared_seeMorestoresLink=By.xpath("//a[@class='stores-toggle collapsed']");
    public static By Standared_Storelists=By.xpath("//ul[@class='store-list-pdp']");
    public static By Standared_seeFewstores=By.xpath("//a[@class='stores-toggle']");
    public static By Standared_RecommondationProNames=By.xpath("//div[@class='recommendations cross-sell']//div[@class='product-name']//a");
    public static By Standared_RecommondationPricevalues=By.xpath("//div[@class='recommendations cross-sell']//div[@class='product-price']//span");
    public static By Stnadred_AvailabilitySection=By.xpath("//div[@class='availability-web']");
    public static By Standared_Recommondation_LeftCourousal=By.xpath("//a[@class='jcarousel-nav jcarousel-next']/i");
    public static By Standared_Recommondation_RightCourousal=By.xpath("//a[@class='jcarousel-nav jcarousel-prev']/i");
    public static By Standared_categoryBanner=By.xpath("//div[@class='cat-banner']//h1");
    public static By Standared_ClothingRefinement=By.xpath("//li[@class='expandable fa fa-angle-right active fa-angle-down']/a");
    public static By Standared_PromotionTitke=By.xpath("//div[@class='promotion-title']");
    public static By Standared_PromotionCallout=By.xpath("  //div[@class='promotion-callout']");
    public static By Standared_DetailsTooltip=By.xpath("//a[@class='tooltip']");
    public static By Standare_PromotionSection=By.xpath("//div[@class='promotion']");
    
    
    public static By ProductSet_TotalSetCount=By.xpath("//div[@id='product-set-list']//div[@class='product-set-item product-bundle-item']");
    public static By Prodset_QtyBox=By.xpath("//input[@name='Quantity']");
    public static By ProdSet_AddAllToCart=By.xpath("//button[@id='add-all-to-cart']");
    public static By prodset_AddToCartButton=By.xpath("//button[starts-with(@class,'button-fancy-medium sub-product-item add-to-cart')]");
    public static By ProdSet_AddtoCartButton=By.xpath("//button[@value='Add to Cart']");
    public static By ProdSet_BuyAllText=By.xpath("//label[contains(text(),'Buy all for')]");
    public static By Prodset_SalePrice=By.className("salesprice");
    public static By ProdSet_SizeChart=By.xpath("//a[@title='View Size Chart']");
    public static By ProdSet_SizechartDialog=By.xpath("//div[@class='sizinginformation ui-tabs ui-widget ui-widget-content ui-corner-all']");
    public static By ProdSet_BonusProdHeading=By.xpath("//div[contains(text(),'You are eligible for a bonus product.')]");
    public static By Prodset_NoThanksBonusProd_Button=By.xpath("//span[contains(text(),'No, thanks')]");
    
    
}
