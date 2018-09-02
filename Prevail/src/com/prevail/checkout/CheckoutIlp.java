package com.prevail.checkout;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.prevail.pom.BillingPOM;
import com.prevail.pom.CartPOM;
import com.prevail.pom.CheckoutIlpPOM;
import com.prevail.pom.MiniCartPOM;
import com.prevail.pom.OrderreviewPOM;
import com.prevail.pom.ShippingPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class CheckoutIlp extends BaseTest {

@Test(groups="{Regression}",description="124962")
public void TC00_NavigatetoILP() throws Exception
{

log.info("Additem to cart");	
s.AddtoCart();
log.info("Click on go straight to checkot");
l1.getWebElement(MiniCartPOM.MiniCartGoStraightToCheckoutButton).click();
sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_CheckoutasGuestButton),"Checkout As a guest button");
sa.assertAll();

}

@Test(groups="{Regression}",description="124968")
public void TC01_ForgetPasswordLink() throws Exception
{

log.info("Click on forgotpassword link");
l1.getWebElement("Login_ForgotPasswrd", "Profile\\login.properties").click();
log.info("Forgot password dialog");
sa.assertTrue(gVar.assertVisible("ForgotPassword_Dailog", "Profile\\ForgotPassword.properties"),"Forgot password dialog box verification");
log.info("Enter the valid email id");
l1.getWebElement("ForgotPassword_EmailTextbox", "Profile\\ForgotPassword.properties").sendKeys("Vinaylanka@gmail.com");
log.info("Click on send button");
l1.getWebElement("ForgotPassword_SendButton", "Profile\\ForgotPassword.properties").click();
log.info("Forgot password confirmation dialog");
sa.assertTrue(gVar.assertVisible("ForgotPassword_PasswordchangeConfirmationtxt", "Profile\\ForgotPassword.properties"),"Forgot password Confirmation dialog box verification");
log.info("Click on close");
l1.getWebElement("ForgotPassword_CloseButton","Profile\\ForgotPassword.properties").click();
sa.assertAll();

}

@Test(groups="{Regression}",description="288128")
public void TC02_EditLinkOrderSummary() throws Exception
{

log.info("Edit link in order summary page");
sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_EditLink_OrderSummary),"Edit link in ordersummary page");
log.info("Click on order summary page");
l1.getWebElement(CheckoutIlpPOM.Ilp_EditLink_OrderSummary).click();
log.info("Navigate to Cart page");
sa.assertTrue(gVar.assertVisible(CartPOM.cartContinueshoppingHeading),"Checkout As a guest button");
Thread.sleep(3000);
log.info("Click on checkout button in cart");
l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
sa.assertAll();

}

@Test(groups="{Regression}",description="288130")
public void TC03_ProductNameLinkLinkOrderSummary() throws Exception
{

Thread.sleep(3000);	
log.info("Edit link in order summary page");
sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_ProductNameLink),"Edit link in ordersummary page");
log.info("Click on order summary product naem Link");
String ProductName=l1.getWebElement(CheckoutIlpPOM.Ilp_ProductNameLink).getText();
log.info("Click on order summary product naem Link click");
l1.getWebElement(CheckoutIlpPOM.Ilp_ProductNameLink).click();
log.info("Should navigate to PDP page");
sa.assertTrue(gVar.assertVisible("PDP_Product_Name","ShopNav\\PDP.properties"),"Edit link in ordersummary page");
log.info("Fetching heading P page");
String ProductNameinPDPage=l1.getWebElement("PDP_Product_Name","ShopNav\\PDP.properties").getText();
sa.assertEquals(ProductName,ProductNameinPDPage);
sa.assertAll();

}

@Test(groups="{Regression}",description="288131")
public void TC04_ProductImageinOrdersummary() throws Exception
{

log.info("Click on go straight to checkot");
act.moveToElement(l1.getWebElement(MiniCartPOM.MiniCartLink)).perform();
l1.getWebElement(MiniCartPOM.MiniCartGoStraightToCheckoutButton).click();	
log.info("Edit link in order summary page");
sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_ProductImage),"Edit link in ordersummary page");
log.info("Click on product image link");
l1.getWebElement(CheckoutIlpPOM.Ilp_ProductImage).click();
sa.assertTrue(gVar.assertVisible(CheckoutIlpPOM.Ilp_CheckoutasGuestButton),"Checkout As a guest button");


}

@Test(groups="{Regression}",description="288132,288134")
public void TC05_ChangethevarianceandAddtocart() throws Exception
{

log.info("Click on order summary product naem Link click");
l1.getWebElement(CheckoutIlpPOM.Ilp_ProductNameLink).click();
log.info("Change the variance and add to cart");
String SelectedSize=l1.getWebElement("PDP_Product_Size","ShopNav\\PDP.properties").getText();
log.info("select the different swatch");
l1.getWebElement("Pdp_Size_Swatch_Selectable","ShopNav\\PDP.properties").click();
Thread.sleep(4000);
log.info("Fetch PDP product size");
String ChangedSelectedSize=l1.getWebElement("PDP_Product_Size","ShopNav\\PDP.properties").getText();
log.info("Comparing both the sizes");
sa.assertNotEquals(SelectedSize,ChangedSelectedSize);
log.info("fetching the quantity in PDP");
String PDPQuantity=l1.getWebElement("PDP_Quantity_Textbox","ShopNav\\PDP.properties").getText();
log.info("setting quantity as 2");
l1.getWebElement("PDP_Quantity_Textbox","ShopNav\\PDP.properties").clear();
Thread.sleep(4000);
l1.getWebElement("PDP_Quantity_Textbox","ShopNav\\PDP.properties").sendKeys("2");
log.info("Add to cart button");
l1.getWebElement("PDP_AddToCart","ShopNav\\PDP.properties").click();
log.info("click on mini cart link");
l1.getWebElement("MiniCartLink","ShopNav\\Minicart.properties").click();
log.info("Fetching cart quantity");
String CartQuantity=l1.getWebElement(CartPOM.cartQuantity).getText();
sa.assertEquals(CartQuantity,PDPQuantity);
String SizeInCart=l1.getWebElement(CartPOM.CartSizeAttribute).getText();
sa.assertEquals(SizeInCart,ChangedSelectedSize);

sa.assertAll();

}
	
@Test(groups="{Regression}",description="124969")
public void TC06_LoginEmailPasswordErrorMessages() throws Exception
{
	
log.info("Click on checkout button in cart");
l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
Thread.sleep(3000);
l1.getWebElement("Login_Username","Profile\\login.properties").sendKeys(" ");
l1.getWebElement("Login_Password","Profile\\login.properties").sendKeys(" ");
log.info("Click on login button with out entering values");	
l1.getWebElement("Login_Login_Button","Profile\\login.properties").click();
log.info("Error messages should display");
sa.assertEquals(gVar.assertEqual(CheckoutIlpPOM.Ilp_EmailPassword_ErrorMessaages,0), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ILPEmailAddress_Blank_ErrorMessage"));
sa.assertEquals(gVar.assertEqual(CheckoutIlpPOM.Ilp_EmailPassword_ErrorMessaages,1), GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","ILPPassword_Blank_ErrorMessage"));
sa.assertAll();

}

@Test(groups="{Regression}",description="124970")
public void TC07_LoginFromILPPage(XmlTest xmlTest) throws Exception
{

int rowNum=new Integer(xmlTest.getParameter("dynamicNum"));	
l1.getWebElement("Login_Username","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,0));
l1.getWebElement("Login_Password","Profile\\login.properties").sendKeys(GetData.getDataFromExcel("\\data\\GenericData.xls","LoginCredentials",rowNum,1));
l1.getWebElement("Login_Login_Button","Profile\\login.properties").click();
log.info("Shipping page Heading");
sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
log.info("Click on home page logo");
l1.getWebElement("HomePage_Logo","ShopNav\\HomePage.properties").click();
log.info("Logout function");
p.Logout();
sa.assertAll();

}

@Test(groups="{Regression}",description="288127")
public void TC08_CheckoutAsaguestButton() throws Exception
{

log.info("Navigating to ILP page");	
checkout.NavigateToILPPage();
log.info("Clicking on checkout as a guest button");
l1.getWebElement(CheckoutIlpPOM.Ilp_CheckoutasGuestButton).click();
log.info("Shipping page Heading");
sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
sa.assertAll();

}

@Test(groups="{Regression}",description="126800")
public void TC09_CreateAccountinILP() throws Exception
{

log.info("Click on home page logo");
l1.getWebElement("HomePage_Logo","ShopNav\\HomePage.properties").click();
log.info("click on mini cart link");
l1.getWebElement("MiniCartLink","ShopNav\\Minicart.properties").click();
log.info("Click on checkout button top");
l1.getWebElements(CartPOM.cartCheckoutbuttons).get(0).click();
log.info("Click on create account button in ILP");
l1.getWebElement(CheckoutIlpPOM.Ilp_CreateAccountNowButton).click();
log.info("Create Account function");
p.CreateAccount("\\data\\GenericData.xls","CreateAccount",1);
log.info("click on create account button");
l1.getWebElement("Register_ApplyButton","Profile\\Register.properties").click();
log.info("Shipping page Heading");
sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
log.info("Click on logged in link expand");
l1.getWebElement(ShippingPOM.shippingLoggedinExpand).click();
log.info("logout link should visible");
sa.assertTrue(gVar.assertVisible(ShippingPOM.shippinglogoutbutton),"Shipping login button");
log.info("Shipping tab expand");
l1.getWebElement(ShippingPOM.shippingTabexpand).click();
log.info("Navigated back to shipping page");
sa.assertTrue(gVar.assertVisible(ShippingPOM.ShippingPage_Heading));
sa.assertAll();
	
}

@Test(groups="{Regression}",description="287480,287481,287482,287485")
public void TC10_ClickingonAllAccordion() throws Exception
{

log.info("click on payment accordion");
l1.getWebElement(ShippingPOM.shippingTabexpand).click();
sa.assertTrue(gVar.assertNotVisible(ShippingPOM.ShippingPage_Heading));
log.info("click on payment accordion");
l1.getWebElement(ShippingPOM.shippingpaymentAccordion).click();
sa.assertTrue(gVar.assertNotVisible(BillingPOM.billingPage_Heading));
log.info("click on orderReview accordion");
l1.getWebElement(ShippingPOM.shippingOrderReviewAccordion).click();
sa.assertTrue(gVar.assertNotVisible(OrderreviewPOM.OrderReview_placeOrderButton));
log.info("click on sign in accordion");
l1.getWebElement(ShippingPOM.shippingSigninAccordionGuest).click();
sa.assertTrue(gVar.assertNotVisible(ShippingPOM.shippingSigninAccordionGuestHeading));

}

@Test(groups="{Regression}",description="124971",dataProvider="LoginEmailValidation",dataProviderClass=Data.class)
public void TC11_logIn_EmailIdvalidation(TestData L) throws Exception
{
	p.ClearEmailId();
	log.info("fetching data from data providers");
	l1.getWebElement("Login_Username", "Profile\\login.properties").sendKeys(L.get(0));
	l1.getWebElement("Login_Password", "Profile\\login.properties").sendKeys("Vin@74113");
	log.info("click on login button");
	l1.getWebElement("Login_Login_Button", "Profile\\login.properties").click();

	
	
	if(i==0 || i==1 || i==2)
	{
		
		//Error Messages
		sa.assertEquals(l1.getWebElement("Login_Username_ErrorMsg", "Profile\\login.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","EmailId_Errormessage"));
		
	}

	else if(i==3)
	{
		//Error Messages
		sa.assertEquals(l1.getWebElement("Login_Username_ErrorMsg", "Profile\\login.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","EmailId_RequiredErrorMessage"));
	}
	

	else if(i==4 || i==5 || i==6 || i==7 || i==8)
		{
		//Error Messages
		sa.assertEquals(GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","EmailId_Errormessage"),l1.getWebElement("Login_Username_ErrorMsg", "Profile\\login.properties").getText());
	}
	
	else if(i==9 || i==10)
	{
		log.info("length Validation"+i);
		sa.assertEquals(GetData.getDataFromExcel("\\data\\ProfileData.xls","EmailValidation",1,1),l1.getWebElement("Login_Username", "Profile\\login.properties").getText().length());
		//Error Messages
		sa.assertEquals(l1.getWebElement("Login_Username_ErrorMsg", "Profile\\login.properties").getText(),GetData.getDataFromProperties("\\POM\\ErrorMessages\\ErrorMessages.properties","EmailId_Errormessage"));
	}
	
	else
	{
		log.info("Myaccount section page verificatrion");
		sa.assertTrue(l1.getWebElement("MyAccount_options","Profile\\MyAccountHome.properties").isDisplayed());
	}

	sa.assertAll();
}
	

@Test(groups="{Regression}",description="125619",dataProvider="LoginEmailValidation",dataProviderClass=Data.class)
public void TC12_logIn_Passwordvalidation(TestData l) throws Exception
{
	
	log.info("fetching data from data providers");
	l1.getWebElement("Login_Username", "Profile\\login.properties").sendKeys("Vinaylanka@gmail.com");
	l1.getWebElement("Login_Password", "Profile\\login.properties").sendKeys(l.get(0));
	log.info("click on login button");
	l1.getWebElement("Login_Login_Button", "Profile\\login.properties").click();
	l1.getWebElement("Login_Password", "Profile\\login.properties").clear();
	
	if(i==0 || i==1)
	{
		sa.assertEquals(GetData.getDataFromExcel("\\data\\ProfileData.xls","Passwordvalidation",1,0),l1.getWebElement("Login_Username", "Profile\\login.properties").getCssValue("background-color"));
		//Error Messages
		sa.assertEquals(GetData.getDataFromProperties("POM\\ErrorMessages\\ErrorMessages.properties","EmailId_Errormessage"),l1.getWebElement("Login_Password", "Profile\\login.properties").getText());
		
	}
	
	if(i==2)
	{
		//Error Messages
		sa.assertEquals(GetData.getDataFromProperties("POM\\ErrorMessages\\ErrorMessages.properties","Password_EmptyErrormessage"),l1.getWebElement("Login_Password", "Profile\\login.properties").getText());
	}
	
	if(i==3)
	{
		sa.assertEquals(GetData.getDataFromExcel("\\data\\ProfileData.xls","OrderIdValidation",1,1),l1.getWebElement("Login_Password", "Profile\\login.properties").getText().length());
	}
	else
	{
		log.info("Myaccount section page verificatrion");
		sa.assertTrue(l1.getWebElement("MyAccount_options","Profile\\MyAccountHome.properties").isDisplayed());
	}
}


}
