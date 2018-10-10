/**
 * 
 */
package PTRAC_DjangoAdmin_TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import adminPages.AccountLayersPage;
import adminPages.AdminHomePage;
import baseClass.PTRAC_TestBase;
import commonMethods.CommonMethods;

public class AccountLayers extends PTRAC_TestBase{
	AdminHomePage adminHomePage;
	CommonMethods cm;
	AccountLayersPage accountLayers;

	@Test
	public void AddAccountLayers() throws IOException, InterruptedException{
		cm=new CommonMethods();
		getBrowser();
		navigateDjangoAdminURL();
		cm.loginAdmin(staffUser,staffPassword);
		wait(2);		

		adminHomePage=new AdminHomePage();
		if(verifyElementDisplayed("Account Layers link",adminHomePage.getLnkAccountLayers())) 
		{
			click("Account layers link",adminHomePage.getLnkAccountLayers());

			accountLayers=new AccountLayersPage();
			verifyElementDisplayed("Add Accounts layer button", accountLayers.getBtnAddAccLayer());
			click("Add Accounts layer button", accountLayers.getBtnAddAccLayer());
			wait(3);
			accountLayers=new AccountLayersPage();
			verifyTextOfElement("Account field ", accountLayers.getLblAccount(), "Account:");
			verifyTextOfElement("Account field ", accountLayers.getLblSubscriptionType(), "Subscription type:");
			verifyTextOfElement("Account field ", accountLayers.getLblGSLayer(), "Gs layer:");

			if(verifyElementDisplayed("Add Account dropdown", accountLayers.getDrpdwnAccount())) 
			{
				selectFormDropDownListByIndex("Account value",accountLayers.getDrpdwnAccount(), 3);	
			}
			if(verifyElementDisplayed("Subscription Type dropdown", accountLayers.getDrpdwnSubscriptionType()))
			{
				selectFormDropDownListByIndex("Subscription Type value",accountLayers.getDrpdwnSubscriptionType(), 1);	
			}
			if(verifyElementDisplayed("GS Layer dropdown", accountLayers.getDrpdwnGSLayer())) 
			{
				selectFormDropDownListByIndex("GS Layer value",accountLayers.getDrpdwnGSLayer() , 1);	
			}
			wait(2);
			click("Save button in Account Layer", accountLayers.getBtnSave());
		}
	}
}
