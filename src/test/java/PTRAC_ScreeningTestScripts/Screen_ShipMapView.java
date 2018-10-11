package PTRAC_ScreeningTestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ptrac.qa.utilities.Utilities;

import baseClass.PTRAC_TestBase;
import commonMethods.CommonMethods;
import webPages.AddShipsPage;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.ScreenPage;

public class Screen_ShipMapView extends PTRAC_TestBase{
	LoginPage loginPage;
	ScreenPage screenPage;
	AddShipsPage addShipPage;
	HomePage homePage;
	CommonMethods cm;

	Screen_ShipMapView(){
		super();
	}

	@Test(priority=1)
	public void verifyShipMapView() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
		cm=new CommonMethods();
		homePage=new HomePage();
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "ShipMapView");
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		String Ship=(String) data[0][0];
		homePage.clickAddShipLnk();
		screenPage=new ScreenPage();
		addShipPage=new AddShipsPage();
		addShipPage.enterShipNameIMO(Ship);
		wait(5);
		addShipPage.selectFirstShip();
		capturePassStatus("ship name/imo is entered as: "+Ship);
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
		wait(30);
		driver.navigate().refresh();
		screenPage.ClickLatestShipMap();
		wait(2);
		if(screenPage.getMapViewFirstShipInfo()>0) {
			capturePassStatus("Navigated to Map view for a ship");
		}else {
			captureFailStatus("Map view is not displayed");
		}
		Assert.assertTrue(screenPage.getMapViewFirstShipInfo()>0); 
	}}

