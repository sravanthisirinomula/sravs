/**
 * 
 */
package PTRAC_DjangoAdminTestScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.TestBase;
import adminPages.AccountLayersPage;
import adminPages.AdminHomePage;
import adminPages.UsersPage;
import commonMethods.CommonMethods;
import utilities.Utilities;

public class Users extends TestBase{
	AdminHomePage adminHomePage;
	CommonMethods cm;
	AccountLayersPage accountLayers;
	UsersPage userPage;

	@Test
	public void verifyUsers() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException{
		cm=new CommonMethods();
		getBrowser();
		navigateDjangoAdminURL();
		cm.loginAdmin(staffUser,staffPassword);
		wait(2);		

		adminHomePage=new AdminHomePage();
		try {
			if(verifyElementDisplayed("Users link",adminHomePage.getLnkUsers())) {
				click("Users link",adminHomePage.getLnkUsers());
			}
		} catch (IOException e) {
			captureFailStatus("Users links not available");
		}
		wait(3);
		userPage=new UsersPage();
		Object data[][]=Utilities.getDatafromExcel(AdminTestDataFile, "AddUsers");
		String s1=(String) data[0][0];
		for (int i = 0; i < data.length; i++) {
			click("Add User", userPage.getBtnAddUser());
			enterValue("User Name", userPage.getTxtUserName(), (String)data[i][0]);
			enterValue("First Name", userPage.getTxtFirstName(), (String)data[i][1]);
			enterValue("Last Name", userPage.getTxtLastName(), (String)data[i][2]);
			enterValue("email", userPage.getTxtEmail(), (String)data[i][3]);
			selectFormDropDownListByVisibleText("Account dropdown", userPage.getDrpdwnAccount(), (String)data[i][4]);
			selectFormDropDownListByVisibleText("Role dropdown", userPage.getDrpdwnRole(), (String)data[i][5]);
			click("Save Button", userPage.getBtnSave());
			click("Users Link", userPage.getLnkNavUsers());
		}
		
		
	}
}
