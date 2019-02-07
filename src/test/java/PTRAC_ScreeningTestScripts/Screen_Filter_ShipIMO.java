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

import Library.TestBase;
import commonMethods.CommonMethods;
import utilities.Utilities;
import webPages.AddShipsPage;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.ScreenPage;
import webPages.SearchPage;

public class Screen_Filter_ShipIMO extends TestBase {
	CommonMethods cm;
	HomePage homePage;
	AddShipsPage addShipsPage;
	ScreenPage screenPage;

	Screen_Filter_ShipIMO(){
		super();
	}

	@Test()
	public void FilterShips() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		cm=new CommonMethods();
		homePage=new HomePage();
		addShipsPage=new AddShipsPage();
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "FilterShips");
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		String shipIMO=(String) data[0][1];
		screenPage=new ScreenPage();
		screenPage.searchShips(shipIMO);
		screenPage.selectLatestShip();
		wait(5);
		String latShipIMO=screenPage.getLatestShipIMONumber();

		if(latShipIMO.contains(shipIMO))
		{
			capturePassStatus("Searched Ship IMO is displayed");
		}
		else
		{
			captureFailStatus("Searched Ship is IMO is not available");
		}

	}
}
