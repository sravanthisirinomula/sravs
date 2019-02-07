package Sanity_Tests;
import static org.testng.Assert.assertTrue;

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
import webPages.LoginPage;
import webPages.ScreenPage;

public class Screen_ViewFullShipDetailsForShip extends TestBase{
LoginPage loginPage;
ScreenPage screenPage;
CommonMethods cm;

Screen_ViewFullShipDetailsForShip(){
super();
}

@Test(priority=1)
@Parameters({"userID", "password"})
//public void VerifyFullShipDetailsForShip(String userID, String password) throws InterruptedException, IOException {
public void VerifyFullShipDetailsForShip() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
Robot robot=new Robot();
loginPage=new LoginPage();
screenPage=new ScreenPage();

cm.login("vijay.bompally", "Password1");
//loginPage.login(userID, password);
//screenPage.scrollDown();
Thread.sleep(2000);
String testDataFile="src/main/java/com/ptrac/qa/testdata/testData.xlsx";
Object data[][]=Utilities.getDatafromExcel(testDataFile, "S_FullShipDetails");
String shipName=(String) data[0][0];
screenPage.selectaShip(shipName);
Thread.sleep(2000);
//screenPage.clkViewFullShipDetailsLnk();
robot.keyPress(KeyEvent.VK_TAB);
robot.keyRelease(KeyEvent.VK_TAB);
Thread.sleep(2000);
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);
addScreen("View Full Ship Details dialog", driver);
//Assert.assertNull(screenPage.clkViewLatestFullShipDetailsLnk());
//screenPage.closeViewFullShipDetailsDlg();
robot.keyPress(KeyEvent.VK_ESCAPE);
robot.keyRelease(KeyEvent.VK_ESCAPE);
}}
