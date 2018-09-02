package com.prevail.projectspec;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.GetDriver;
import com.prevail.utilgeneric.GlobalVariables;
import com.prevail.utilgeneric.Locators;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlTest;

public class ProfileFunctions extends BaseTest {

	public String PDP_Pname;
	public String PDP_Psize;
	public String PDP_Pcolor;

	public void loginToAppliction(XmlTest xmlTest) throws Exception
	{
		
	//	int rowNum=new Integer(xmlTest.getParameter("dynamicNum"));
		int rowNum=new Integer("1");

		BaseTest.l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		BaseTest.l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
		BaseTest.l1.getWebElement("Login_Username","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,0));
		BaseTest.l1.getWebElement("Login_Password","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,1));
		BaseTest.l1.getWebElement("Login_Login_Button","Profile\\login.properties").click();
		
	}

//public void browser(XmlTest xmlTest)
//{
//		int rowNum=new Integer(xmlTest.getParameter("dynamicNum"));
//		String UN=GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",rowNum,0);
//		String PWD=GetData.getDataFromExcel("\\data\\ProfileData.xls","RegisterValidations",rowNum,0);
//}
//
//browser(XmlTest);
//login(UN,PWD);
	
public void loginToAppliction() throws Exception
{
	//BaseTest.driver.get("https://dev32.na.pfsweb.demandware.net/on/demandware.store/Sites-PREVAIL-Site/en_US/Login-Show?original=%2fs%2fPREVAIL%2fen_US%2faccount");
	Thread.sleep(3000);
	BaseTest.l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
	BaseTest.l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
	
	Thread.sleep(3000);
	BaseTest.l1.getWebElement("Login_Username","Profile\\login.properties").sendKeys("Vinaylanka@gmail.com");
	BaseTest.l1.getWebElement("Login_Password","Profile\\login.properties").sendKeys("Vin@74113");
	BaseTest.l1.getWebElement("Login_Login_Button","Profile\\login.properties").click();
	
/*	
	driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	driver.findElement(By.xpath("//span[starts-with(@id,'dwfrm_login_username')]")).sendKeys("Vinaylanka@gmail.com");
	driver.findElement(By.xpath("//input[starts-with(@id,'dwfrm_login_password')]")).sendKeys("Vin@74113");
	driver.findElement(By.name("dwfrm_login_login")).click();*/
	
	
}
	
public void Logout() throws Exception
{
	//My account Header
	BaseTest.l1.getWebElement("Header_Login_icon", "ShopNav\\HomePage.properties").click();
	//Logout link
	BaseTest.l1.getWebElement("Header_Logout", "ShopNav\\HomePage.properties").click();
	Thread.sleep(3000);
}

public void CreateAccount(String excelSheetName,String SubSheetName,int row) throws Exception
{
	//Create Account
	BaseTest.l1.getWebElement("Register_FirstName", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("Register_LastName", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,1));
	BaseTest.l1.getWebElement("Register_EmailID", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,2));
	BaseTest.l1.getWebElement("Register_ConfirmEmail", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,3));
	BaseTest.l1.getWebElements("Register_Password", "Profile\\Register.properties").get(0).sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,4));
	BaseTest.l1.getWebElement("Register_ConfirmPassword", "Profile\\Register.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,5));
}

public void ClearFieldsRegister() throws Exception
{
	BaseTest.l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
	BaseTest.l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
	BaseTest.l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
	BaseTest.l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
	BaseTest.l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
	BaseTest.l1.getWebElement("Register_FirstName", "Profile\\Register.properties").clear();
}

public void ClearWishlistLoginFields() throws Exception
{
	log.info("Enter FN, LN, Email");
	log.info("Enter Lastname:"+i);
	l1.getWebElement("Wishlist_Login_LastName", "Profile\\Wishlist.properties").clear();
	log.info("Enter Firstname:"+i);
	l1.getWebElement("Wishlist_Login_FirstName", "Profile\\Wishlist.properties").clear();
	log.info("Enter Email:"+i);
	l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").clear();
}

public void DeleteAddress() throws Exception
{
	
try {
	int AddressCount=BaseTest.l1.getWebElements("Address_Delete_Buttons","Profile\\Addresses.properties").size();
	System.out.println(BaseTest.l1.getWebElements("Address_Delete_Buttons","Profile\\Addresses.properties"));
	for (int i=0;i<AddressCount;i++)
	{
		BaseTest.l1.getWebElements("Address_Delete_Buttons","Profile\\Addresses.properties").get(0).click();
		//Handling alert popup
		Alert alert = GetDriver.driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
	}
	
}
catch(Exception e){
	System.out.println("No Address displayed");
}
	
}

public void DeleteCreditCard() throws Exception
{
	
try {
	int CardCount=BaseTest.l1.getWebElements("PaymentSettings_DeleteCard_Link","Profile\\PaymentSettings.properties").size();
	System.out.println("Card Count"+CardCount);
	System.out.println(BaseTest.l1.getWebElements("PaymentSettings_DeleteCard_Link","Profile\\PaymentSettings.properties"));
	for (int i=0;i<CardCount;i++)
	{
		BaseTest.l1.getWebElements("PaymentSettings_DeleteCard_Link","Profile\\PaymentSettings.properties").get(i).click();
		//Handling alert popup
		Alert alert = GetDriver.driver.switchTo().alert();
		alert.accept();
	}
	
}
catch(Exception e){
}
	
}

public void ClearAddressFiles() throws Exception
	{
    	//Edit address
  		//log.info("Click on Edit Address");
  		//l1.getWebElement("Address_Edit_Link", "Profile\\Addresses.properties").click();
  		//Enter address
  		log.info("Enter Address name");
  		l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").clear();
  		log.info("Enter Firstname");
  		l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").clear();
  		log.info("Enter Lastname");
  		l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").clear();
  		log.info("Enter Address1");
  		l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").clear();
  		log.info("Enter Address2");
  		l1.getWebElement("Address_Address2", "Profile\\Addresses.properties").clear();
  		log.info("Enter City");
    	l1.getWebElement("Address_City", "Profile\\Addresses.properties").clear();
    	//log.info("Select state ");
    	//gVar.handlingDropdown_VisibleText("Address_State", "Profile\\Addresses.properties").clear();
    	log.info("Enter Postal");
    	l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").clear();
    	log.info("Enter Phone");
    	l1.getWebElement("Address_phone", "Profile\\Addresses.properties").clear();
	}

public void EnterAddressValues(String excelSheetName,String SubSheetName,int row) throws Exception
{
	log.info("Enter Address Name");
	BaseTest.l1.getWebElement("Address_AddressName", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	Thread.sleep(1000); 
	log.info("Enter Firstname");
	BaseTest.l1.getWebElement("Address_FirstName", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,1));
	Thread.sleep(1000); 
	log.info("Enter Lastname");
	BaseTest.l1.getWebElement("Address_LastName", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,2));
	Thread.sleep(1000); 
	log.info("Enter Address1");
	BaseTest.l1.getWebElement("Address_Address1", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,3));
	Thread.sleep(1000); 
	log.info("Enter Address2");
	BaseTest.l1.getWebElement("Address_Address2", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,4));
	Thread.sleep(1000); 
	//new Select(BaseTest.l1.getWebElement("Address_Country", "Profile\\Addresses.properties")).selectByVisibleText("United States");
	//BaseTest.l1.getWebElement("Address_Country", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,8));
	//new Select(BaseTest.l1.getWebElement("Address_State", "Profile\\Addresses.properties")).selectByVisibleText("Texas");
	log.info("Enter City");
	BaseTest.l1.getWebElement("Address_City", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,5));
	Thread.sleep(1000); 
	log.info("Select State");
	BaseTest.gVar.handlingDropdown("Address_State", "Profile\\Addresses.properties",GetData.getDataFromExcel(excelSheetName,SubSheetName,row,6));
	Thread.sleep(1000); 
	log.info("Enter Zipcode");
	BaseTest.l1.getWebElement("Address_Postal", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,7));
	Thread.sleep(1000);
	log.info("Enter country");
	//BaseTest.gVar.handlingDropdown_VisibleText("Address_Country", "Profile\\Addresses.properties",GetData.getDataFromExcel(excelSheetName,SubSheetName,row,8));
	Thread.sleep(1000);
	log.info("Enter Phone No");
	BaseTest.l1.getWebElement("Address_phone", "Profile\\Addresses.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,9));
	Thread.sleep(1000); 
}

public void CreateCreditCard(String excelSheetName,String SubSheetName,int row) throws Exception
{
	
	BaseTest.l1.getWebElement("PaymentSettings_NameOnCard", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_type", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_Number", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_ExpiresMonth", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_ExpiresYear", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_FirstName", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_LastName", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_Address1", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_Address2", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_Country", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_State", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_City", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_Zipcode", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_Phone", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
	BaseTest.l1.getWebElement("PaymentSettings_Email", "Profile\\PaymentSettings.properties").sendKeys(GetData.getDataFromExcel(excelSheetName,SubSheetName,row,0));
}

public void AddItemsToWishlist() throws Exception
{
	s.NavigateToPDP();
	log.info("select swatches");
	s.SelectSwatch();
	BaseTest.l1.getWebElement("PDP_AddToWishList", "ShopNav\\PDP.properties").click();
	//click on make this as public if it is not having public visibility
	try
	{
		BaseTest.l1.getWebElement("Make_Wishlist_Public", "Profile\\Wishlist.properties").click();		
	} 
	catch (Exception e) 
	{
		// TODO: handle exception
		System.out.println("Wishlist is already public");
	}
}

public void AdditemsToWishListAccount(XmlTest XmlTest) throws Exception
{
	//Login to application
	loginToAppliction(XmlTest);
	log.info("Add Items to wishlist");
	AddItemsToWishlist();
	//Logout from application
	Logout();
}

	public void NavigateToAddressPage() throws Exception
	{
		log.info("Click on header MyAccount icon");
		BaseTest.l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("Click on My account page");
		BaseTest.l1.getWebElement("Header_MyAccount_link", "ShopNav\\HomePage.properties").click();
		log.info("Click on Address link");
		BaseTest.l1.getWebElement("MyAccount_Addresses_link", "Profile\\MyAccountHome.properties").click();
	}
	
	public void NavigateToFindSomeOneWishlist() throws Exception
	{
		int rowNum=new Integer(BaseTest.xmlTest.getParameter("dynamicNum"));
		//navigate to wish list page
		BaseTest.l1.getWebElement("Footer_Wishlist", "ShopNav\\HomePage.properties").click();
		//Enter Keys
		BaseTest.l1.getWebElement("Wishlist_Login_Email", "Profile\\Wishlist.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","Register",rowNum,2));
		//click on find button
		BaseTest.l1.getWebElement("Wishlist_login_Find", "Profile\\Wishlist.properties").click();
	}

	public void clearWishList() throws Exception
	{
		//if (_isVisible($WISHLIST_SHIPPINGADDRESS_DROPDOWN))
		//{
		//	_setSelected($WISHLIST_SHIPPINGADDRESS_DROPDOWN,0);	 
		//}
		try 
		{			
			BaseTest.l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
			BaseTest.l1.getWebElement("Header_Wishlist_link", "ShopNav\\HomePage.properties").click();
			while(BaseTest.l1.getWebElement("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties").isDisplayed())
			{
				BaseTest.l1.getWebElement("Wishlist_DetailPage_Remove", "Profile\\Wishlist.properties").click();
			}
		} 
		catch (Exception e)
		{
			System.out.println("No products in wishlist");
		}		 
	}
	
	public void deleteAddeditemsFromWishlistAccount(XmlTest XmlTest) throws Exception
	{
		//login to the application
		//BaseTest.l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		//Thread.sleep(2000);
		//login to application for which account we have added item
		loginToAppliction(XmlTest);
		//clearing items from wishlist
		clearWishList();
		//logout from application
		Logout();
	}
	public void ClearEmailId() throws Exception
	{
		
		BaseTest.l1.getWebElement("Login_Username", "Profile\\login.properties").clear();
		BaseTest.l1.getWebElement("Login_Password", "Profile\\login.properties").clear();
	}
}
