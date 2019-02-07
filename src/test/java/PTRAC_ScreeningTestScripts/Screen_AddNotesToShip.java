package PTRAC_ScreeningTestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.TestBase;
import commonMethods.CommonMethods;
import utilities.Utilities;
import webPages.AddShipsPage;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.ScreenPage;

public class Screen_AddNotesToShip extends TestBase {
	CommonMethods cm;
	HomePage homePage;
	AddShipsPage addShipsPage;
	ScreenPage screenPage;
	Robot robot;

	Screen_AddNotesToShip(){
		super();
	}

	@Test
	public void Screen_AddNotesToShip_1() throws IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException {
		cm=new CommonMethods();
		homePage=new HomePage();
		addShipsPage=new AddShipsPage();
		robot=new Robot();
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "AddNotesToShip");
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		screenPage=new ScreenPage();
		String shipIMO=(String) data[0][0];

		screenPage.searchShips(shipIMO);
		screenPage.selectLatestShip();
		wait(5);
		String latShipIMO=screenPage.getLatestShipIMONumber();
		String notesCount=screenPage.getTxtNotesCount().getText();
		int notesCountVal=Integer.valueOf(notesCount);
		System.out.println(notesCountVal);
		click("Notes Link", screenPage.getLnkNotes().get(0));
		for(int i=0;i<data.length;i++) {
			System.out.println(data.length);
			System.out.println("i"+i);
			String notes=(String) data[i][1];
			click("Add Note link",screenPage.getLnkAddNote());
			enterValue("Note text", screenPage.getTxtNote(), notes);
			wait(2);
			click("Save Button", screenPage.getBtnSave());
			wait(2);
		}
		click("Close Add Notes dialog",screenPage.getBtnClose());
		wait(2);
		click("Screen Tab",screenPage.getLnkTabs().get(0));
		notesCount=screenPage.getTxtNotesCount().getText();
		int notesCountVal2=Integer.valueOf(notesCount);
		wait(3);
		if(notesCountVal!=notesCountVal2) {
			capturePassStatus("Notes text is added");
		}
		else
		{
			captureFailStatus("Notes text is not added");
		}
	}
}