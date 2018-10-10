package PTRAC_ScreeningTestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ptrac.qa.baseclass.PTRAC_TestBase;
import com.ptrac.qa.commonMethods.CommonMethods;
import com.ptrac.qa.utilities.Utilities;
import com.ptrac.qa.webpages.AddShipsPage;
import com.ptrac.qa.webpages.HomePage;
import com.ptrac.qa.webpages.LoginPage;

public class Screen_SearchAndRegisterShips extends PTRAC_TestBase {
	HomePage homePage;
	LoginPage loginPage;
	AddShipsPage addShipPage;
	CommonMethods cm;
	static int i=0;
	Robot robot;

	Screen_SearchAndRegisterShips(){
		super();
	}

	@Test
	public void searchAndAddShip() throws IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException {
		loginPage=new LoginPage();
		homePage=new HomePage();
		cm=new CommonMethods();
		robot=new Robot();
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		homePage.clickAddShipLnk();
		addShipPage=new AddShipsPage();
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "SearchAndRegisterShips");
		for (i=0;i<data.length;i++) {
			homePage.clickAddShipLnk();
			String ship=(String) data[i][0];
			addShipPage.enterShipNameIMO(ship);
			wait(5);
			addShipPage.selectFirstShip();
			addInfoToReport("ship name/imo is entered as: "+ship);
			wait(2);
			addShipPage.clickRegBtn();
			wait(2);
			WebElement preRegScreen=addShipPage.getDlgPreReg();
			if (preRegScreen!=null) {
				addInfoToReport("Pre-Registration Screening dialog is displayed");
				click("Ok Button on Pre Registration Screening dialog", addShipPage.getBtnOK());
			}else {
				addInfoToReport("Pre-Registration Screening dialog is not displayed");
			}
			addInfoToReport("Pre Registration dialog is closed");
		}
	}
}