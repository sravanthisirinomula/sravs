/**
 * 
 */
package PTRAC_DjangoAdminTestScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.TestBase;
import adminPages.AccountLayersPage;
import adminPages.AdminHomePage;
import commonMethods.CommonMethods;

public class ManagementReports extends TestBase{
	AdminHomePage adminHomePage;
	CommonMethods cm;
	AccountLayersPage accountLayers;

	@Test
	public void verifyManagementReports() throws IOException, InterruptedException{
		cm=new CommonMethods();
		getBrowser();
		navigateDjangoAdminURL();
		cm.loginAdmin(staffUser,staffPassword);
		wait(2);		

		adminHomePage=new AdminHomePage();
		try {
			if(verifyElementDisplayed("Management Reports link",adminHomePage.getLnkManagementReports())) {
				click("Management Reports link",adminHomePage.getLnkManagementReports());
			}
		} catch (IOException e) {
			captureFailStatus("Management Reports not available");
		}
	}
}
