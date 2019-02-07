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

public class Formats extends TestBase{
	AdminHomePage adminHomePage;
	CommonMethods cm;
	AccountLayersPage accountLayers;

	@Test
	public void verifyFormats() throws IOException, InterruptedException{
		cm=new CommonMethods();
		getBrowser();
		navigateDjangoAdminURL();
		cm.loginAdmin(staffUser,staffPassword);
		wait(2);		

		adminHomePage=new AdminHomePage();
		try {
			if(verifyElementDisplayed("Formats link",adminHomePage.getLnkFormats())) {
				click("Formats link",adminHomePage.getLnkFormats());
			}
		} catch (IOException e) {
			captureFailStatus("Formats not available");
		}
	}
}
