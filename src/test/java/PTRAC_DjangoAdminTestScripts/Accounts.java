/**
 * 
 */
package PTRAC_DjangoAdminTestScripts;

import java.io.IOException;
import org.testng.annotations.Test;

import Library.TestBase;
import adminPages.AccountLayersPage;
import adminPages.AdminHomePage;
import commonMethods.CommonMethods;

public class Accounts extends TestBase{
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
		try {
			if(verifyElementDisplayed("Accounts link",adminHomePage.getLnkAccounts())) {
				click("Account Layers link",adminHomePage.getLnkAccounts());
			}
		} catch (IOException e) {
			captureFailStatus("Account link not available");
		}

	}
}
