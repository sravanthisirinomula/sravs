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

public class Screen_VerifyAddShipDialog extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	AddShipsPage addShipPage;
	CommonMethods cm;
	static int i=0;
	Robot robot;

	Screen_VerifyAddShipDialog(){
		super();
	}

	@Test
	public void VerifyAddShipsDialog() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
		loginPage=new LoginPage();
		homePage=new HomePage();
		cm=new CommonMethods();
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		homePage.clickAddShipLnk();
		addShipPage=new AddShipsPage();
		wait(3);

		if(addShipPage.getDlgAddShip().isDisplayed()) {
			capturePassStatus("Add Ship dialog is displayed");
		}else {
			captureFailStatus("Add Ship dialog is not displayed");
		}

		if (addShipPage.getLblShipName().getText().equalsIgnoreCase("Ship name / IMO:")) 

		{
			capturePassStatus("Ship Name/IMO label is displayed");
		}else
			captureFailStatus("Ship Name/IMO label is not displayed");

		if(addShipPage.getBtnNextShip().isDisplayed()) {
			capturePassStatus("Next Ship button is displayed in Add Ship dialog");
		}else {
			captureFailStatus("Next Ship button is not displayed in Add Ship dialog");
		}

		if(addShipPage.getBtnRegister().isDisplayed()) {
			capturePassStatus("Register button is displayed in Add Ship dialog");
		}else {
			captureFailStatus("Register button is not displayed in Add Ship dialog");
		}

		addShipPage.closeAddShipDialog();
		capturePassStatus("Add Ship dialog is closed");
	}
}
