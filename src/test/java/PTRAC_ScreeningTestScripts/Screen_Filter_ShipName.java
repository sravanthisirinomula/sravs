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
import com.ptrac.qa.webpages.ScreenPage;
import com.ptrac.qa.webpages.SearchPage;

public class Screen_Filter_ShipName extends PTRAC_TestBase {
	CommonMethods cm;
	Robot robot;
	HomePage homePage;
	AddShipsPage addShipsPage;
	ScreenPage screenPage;

	Screen_Filter_ShipName(){
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
		String shipName=(String) data[0][0];
		screenPage=new ScreenPage();
		screenPage.searchShips(shipName);
		screenPage.selectLatestShip();
		wait(5);
		String latShipName=screenPage.getLatestShipName();
		if(latShipName.contains(shipName))
		{
			capturePassStatus("Searched Ship Name is displayed");
		}
		else
		{
			captureFailStatus("Searched Ship is Name is not available");
		}

	}
}
