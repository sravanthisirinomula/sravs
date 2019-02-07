package PTRAC_ScreeningTestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Library.TestBase;
import commonMethods.CommonMethods;
import utilities.Utilities;
import webPages.AddShipsPage;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.ScreenPage;

public class Screen_DeclineShip extends TestBase{
	LoginPage loginPage;
	ScreenPage screenPage;
	AddShipsPage addShipPage;
	CommonMethods cm;
	Robot robot;
	HomePage homePage;
	int shipsBeforedecline=0;
	int shipsAfterdecline=0;

	Screen_DeclineShip(){
		super();
	}

	@Test
	public void screenDeclineStatus() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
		robot=new Robot();
		cm=new CommonMethods();
		homePage=new HomePage();
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "DeclineShip");
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		String shipName=(String) data[0][0];
		screenPage=new ScreenPage();
		shipsBeforedecline=screenPage.getVesselCount();
		addInfoToReport("Ships in Screening tab before declining a ship: "+shipsBeforedecline);
		screenPage.searchShips(shipName);
		screenPage.selectLatestShip();
		wait(5);
		screenPage.declineLatestShip();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.navigate().refresh();
		shipsAfterdecline=screenPage.getVesselCount();
		addInfoToReport("Ships in Screening tab after declining a ship: "+shipsAfterdecline);
		Assert.assertEquals(shipsBeforedecline-1, shipsAfterdecline);
	}}
