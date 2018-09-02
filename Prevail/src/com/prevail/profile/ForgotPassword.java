package com.prevail.profile;

import org.testng.annotations.Test;

import com.prevail.utilgeneric.BaseTest;

public class ForgotPassword extends BaseTest
{

	@Test(groups="{Regression}",description="124624")
	public void TC00_ForgotPassword_sendbutton() throws Exception
	{
		log.info("Click on User account icon");
		l1.getWebElement("MyAccountIcon","Profile\\Register.properties").click();
		log.info("click on login link");
		l1.getWebElement("Login_Icon","Profile\\Register.properties").click();
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
        sa.assertAll();
     }
	
	
	@Test(groups="{Regression}",description="288482")

	public void TC01_ForgotPassword_Closebutton() throws Exception
	{
		
		log.info("Click on close");
		l1.getWebElement("ForgotPassword_CloseButton","Profile\\ForgotPassword.properties").click();
		log.info("Forgot password overlay should close");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_PasswordchangeConfirmationtxt", "Profile\\ForgotPassword.properties"),"Forgot password dialog box is closed");
        sa.assertAll();
	}
	
	
	@Test(groups="{Regression}",description="288481")
	public void TC02_ForgotPassword_OverlayUI() throws Exception
	{
		log.info("Click on forgotpassword link");
		l1.getWebElement("Login_ForgotPasswrd", "Profile\\login.properties").click();
		log.info("Forgot password dialog");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_Dailog","Profile\\ForgotPassword.properties"),"Forgot password dialog box Verification");

        
        log.info("close button");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_CloseButton","Profile\\ForgotPassword.properties"),"Forgot password close link verification");

		log.info("Dialog text");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_DialogText",  "Profile\\ForgotPassword.properties"),"Forgot password dialog box Text");

		log.info("Header message");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_HeaderMsg",  "Profile\\ForgotPassword.properties"),"Forgot password Header message");

	
		log.info("Email Label");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_EmailLabel",  "Profile\\ForgotPassword.properties"),"Forgot password Email label");

		log.info("Email TextBox");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_EmailTextbox",  "Profile\\ForgotPassword.properties"),"Forgot password dialog Email Textbox");

		log.info("Send button");
        sa.assertTrue(gVar.assertVisible("ForgotPassword_SendButton",  "Profile\\ForgotPassword.properties"),"Forgot password dialog Send button");

		sa.assertAll();
	}
	
	
	
	/*@Test(groups="{Regression}",description="288478")
	public void TC_03ForgotPassword_Validation() throws Exception
	{
		
		
		
		
	}*/
	
	
}
