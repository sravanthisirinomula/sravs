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

public class Screen_AddMultipleShips extends PTRAC_TestBase {
	HomePage homePage;
	LoginPage loginPage;
	AddShipsPage addShipPage;
	CommonMethods cm;
	static int i=0;
	Robot robot;

	Screen_AddMultipleShips(){
		super();
	}

	@Test(priority=1)
	//@Parameters({"userID", "password"})
	//public void searchAddShips_01(String userID, String password) throws InterruptedException, IOException {
	public void addMultipleShips_01() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
		loginPage=new LoginPage();
		homePage=new HomePage();
		cm=new CommonMethods();
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		//homePage.clickScreenTab();
		homePage.clickAddShipLnk();
		addShipPage=new AddShipsPage();
		Thread.sleep(1000);
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "AddMultipleShips");
		String s1=(String) data[0][0];
		addShipPage.enterShipNameIMO(s1);
		//	addShipPage.selectFirstShip();
		addInfoToReport("ship name/imo is entered as: "+s1);

		for (i=1;i<data.length;i++) {
			addShipPage.clickNxtShipBtn();
			String s2=(String) data[i][0];
			Thread.sleep(2000);
			addShipPage.enterShipNameIMO(s2,i);
			wait(2);
			addInfoToReport("Ship is selected: "+s1);
		}
	}

	@Test(priority=2,dependsOnMethods="addMultipleShips_01")
	public void addMultipleShips_02() throws IOException, InterruptedException, AWTException {
		robot=new Robot();
		addShipPage=new AddShipsPage();
		addShipPage.clickRegBtn();
		Thread.sleep(3000);
		WebElement preRegScreen=addShipPage.getDlgPreReg();
		if (preRegScreen!=null) {
			addInfoToReport("Pre-Registration Screening dialog is displayed");
			//addScreen("Pre Registration", driver);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}else
			addInfoToReport("Pre-Registration Screening dialog is not displayed");
		//addShipPage.clkOKBtn();
		addInfoToReport("OK button is clicked and Pre Registration dialog is closed");
	}
}

/*@DataProvider	
	public Object[][] getTestData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object data[][]=Utilities.getDatafromExcel(regTestDataFile, "S_addMultipleShips");
		return data;	
	}

	//@Test(priority=2, dependsOnMethods="searchAddShips_01")
	public void searchAddShips_02() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
		addShipPage=new AddShipsPage();
		robot=new Robot();
		Thread.sleep(1000);
		Object data[][]=Utilities.getDatafromExcel(regTestDataFile, "S_addMultipleShips");
		String s1=(String) data[0][0];
		addShipPage.enterShipNameIMO(s1);
		addShipPage.selectFirstShip();
		addInfoToReport("ship name/imo is entered as: "+s1);

		for (i=1;i<data.length;i++) {
			addShipPage.clickNxtShipBtn();
			String s2=(String) data[i][0];
			Thread.sleep(2000);
			addShipPage.enterShipNameIMO(s2,i);
			addShipPage.selectFirstShip();
			addInfoToReport("Ship is selected: "+s2);
		}
	}

	//@Test(priority=3,dataProvider="getTestData")
	public void searchAddShips_03(String s1) throws InterruptedException, IOException, AWTException {
		addShipPage=new AddShipsPage();
		robot=new Robot();
		Thread.sleep(1000);
		addShipPage.clickNxtShipBtn();
		Thread.sleep(2000);
		addShipPage.enterShipNameIMO(s1,i);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		//addShipPage.selectFirstShip();
		i=i+1;
		addInfoToReport("Ship is selected "+s1);
	}
 */
