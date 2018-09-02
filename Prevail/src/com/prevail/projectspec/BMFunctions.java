package com.prevail.projectspec;

import org.testng.xml.XmlTest;

import com.prevail.pom.BusinessManagerPOM;
import com.prevail.utilgeneric.BaseTest;
import com.prevail.utilgeneric.GetData;

public class BMFunctions extends BaseTest {
	
public void deleteUser(String emailID,XmlTest xmlTest) throws Exception
{
		
gVar.navigateToBM(xmlTest);
BaseTest.l1.getWebElement(BusinessManagerPOM.bmUserName).sendKeys(GetData.getDataFromProperties("\\data\\sitedata.properties","BMUserName"));
BaseTest.l1.getWebElement(BusinessManagerPOM.bmPassword).sendKeys(GetData.getDataFromProperties("\\data\\sitedata.properties","BMUserName"));
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.loginButton).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.selectaSite).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.merchantToolsLink).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.selectCustomersLink).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.selectSecondCustomers).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.advanceLink).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.advanceEmailLink).sendKeys(emailID);
BaseTest.l1.getWebElement(BusinessManagerPOM.advanceFindButton);
Thread.sleep(3000);
BaseTest.l1.getWebElements(BusinessManagerPOM.emailID).get(0).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.userDeletebutton).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.OkButton).click();
Thread.sleep(3000);
BaseTest.l1.getWebElement(BusinessManagerPOM.LogoutButton).click();
		
}

}
