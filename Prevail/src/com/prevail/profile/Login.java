package com.prevail.profile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.Data;
import com.prevail.utilgeneric.GetData;
import com.prevail.utilgeneric.TestData;

public class Login extends BaseTest {


@Test(groups="{Regression}",description="124615")
public void TC01_logIn_UI_() throws Exception
{
		
	log.info("enteredin to method");

	driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	driver.findElement(By.xpath("//span[starts-with(@id,'dwfrm_login_username')]")).sendKeys("Vinaylanka@gmail.com");
	driver.findElement(By.xpath("//input[starts-with(@id,'dwfrm_login_password')]")).sendKeys("Vin@74113");
	driver.findElement(By.name("dwfrm_login_login")).click();
	log.info("Myaccount section page verificatrion");
	sa.assertTrue(l1.getWebElement("MyAccount_options","Profile\\MyAccountHome.properties").isDisplayed());
	log.info("Click on logout button");
	l1.getWebElement("MyAccount_LogoutLink", "Profile\\MyAccountHome.properties").click();
	
}
	
	@Test(groups="{Regression}",description="148631")
	
	public void TC02_logIn_ForgotPassword() throws Exception
	{
		log.info("Click on forgotpassword link");
		l1.getWebElement("Login_ForgotPasswrd", "Profile\\login.properties").click();
		log.info("Forgot password dialog");
        sa.assertTrue(l1.getWebElement("ForgotPassword_Dailog", "Profile\\ForgotPassword.properties").isDisplayed());
        log.info("Forgot password dialog Text Heading");
        sa.assertTrue(l1.getWebElement("ForgotPassword_DialogText", "Profile\\ForgotPassword.properties").isDisplayed());
        log.info("closing Forgot password dialog ");
        sa.assertTrue(l1.getWebElement("ForgotPassword_CloseButton", "Profile\\ForgotPassword.properties").isDisplayed());
        log.info("Closing the forgot password overlay");
        l1.getWebElement("ForgotPassword_CloseButton", "Profile\\ForgotPassword.properties").click();
        log.info("Create account Heading");
		sa.assertTrue(gVar.assertVisible("CreateAccount_Heading", "Profile\\CreateAccount.properties"),"CreateAccount Page Heading");
        
	}

	

	

}


