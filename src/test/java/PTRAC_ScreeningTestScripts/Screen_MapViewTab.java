package PTRAC_ScreeningTestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ptrac.qa.utilities.Utilities;

import baseClass.PTRAC_TestBase;
import commonMethods.CommonMethods;
import webPages.AddShipsPage;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.MapViewPage;
import webPages.ScreenPage;

public class Screen_MapViewTab extends PTRAC_TestBase{
	ScreenPage screenPage;
	CommonMethods cm;
	MapViewPage mapViewPage;
	HomePage homePage;

	Screen_MapViewTab(){
		super();
	}

	@Test(priority=1)
	public void selectMapViewLink() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
		cm=new CommonMethods();
		homePage=new HomePage();
		Object data[][]=Utilities.getDatafromExcel(ScreeningTestDataFile, "FilterShips");
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		mapViewPage=new MapViewPage() ;
		screenPage=new ScreenPage();
		screenPage.ClkMapViewLnk();
		Thread.sleep(3000);
		if(mapViewPage.getLnkSanctionZones().isDisplayed()) 
		{
		capturePassStatus("Map View page is displayed");
	}
		else
		{
			capturePassStatus("Map View page is not displayed");
		}
	}
	
	@Test(priority=2, dependsOnMethods="selectMapViewLink")
	public void viewSanctionZones() throws IOException, InterruptedException 
	{
		uncheckAllCheckboxes();
		mapViewPage=new MapViewPage();
		mapViewPage.selectSanctionZonesChkbox();
		if(mapViewPage.isSanctionsLnksChkboxSelected()) 
		{
			capturePassStatus("Sanction Zones checkbox is selected");
		}
		else
		{
			captureFailStatus("Sanction Zones checkbox is not selected");
		}
	}

	@Test(priority=3, dependsOnMethods="selectMapViewLink")
	public void viewWarZones() throws IOException, InterruptedException {
		uncheckAllCheckboxes();
		mapViewPage=new MapViewPage();
		mapViewPage.selectWarZonesChkbox();;
		if(mapViewPage.isWarZonesLnksChkboxSelected()) 
		{
			capturePassStatus("War Zones checkbox is selected");
		}
		else
		{
			captureFailStatus("War Zones checkbox is not selected");
		}
	}

	@Test(priority=4, dependsOnMethods="selectMapViewLink")
	public void viewPorts() throws IOException {
		uncheckAllCheckboxes();
		mapViewPage=new MapViewPage();
		mapViewPage.selectPortChkbox();
		if(mapViewPage.isPortLnksChkboxSelected()) 
		{
			capturePassStatus("Port checkbox is selected");
		}
		else
		{
			captureFailStatus("Port checkbox is not selected");
		}
	}
	@Test(priority=5, dependsOnMethods="selectMapViewLink")
	public void viewAIS() throws IOException {
		uncheckAllCheckboxes();
		mapViewPage=new MapViewPage();
		mapViewPage.selectAISLnksChkbox();
		addInfoToReport("AIS checkbox is selected");
	}

	@Test(priority=6, dependsOnMethods="selectMapViewLink")
	public void viewMaRiskAlerts() throws IOException {
		uncheckAllCheckboxes();
		mapViewPage=new MapViewPage();
		mapViewPage.selectMaRiskAlertsLnkChkbox();
		addInfoToReport("MaRisk Alerts checkbox is selected");
	}

	@Test(priority=3)
	public void checkAllCheckboxes() throws IOException {
		mapViewPage=new MapViewPage();
		mapViewPage.selectAISLnksChkbox();
		mapViewPage.selectMaRiskAlertsLnkChkbox();
		mapViewPage.selectPortChkbox();
		mapViewPage.selectSanctionZonesChkbox();
		mapViewPage.selectWarZonesChkbox();
		addInfoToReport("All checkboxes are selected");
	}

	public void uncheckAllCheckboxes() throws IOException {
		mapViewPage=new MapViewPage();
		mapViewPage.deselectAISLnksChkbox();
		mapViewPage.deselectMaRiskAlertsLnkChkbox();
		mapViewPage.deselectPortChkbox();
		mapViewPage.deselectSanctionZonesChkbox();
		mapViewPage.deselectWarZonesChkbox();
		addInfoToReport("All checkboxes are unchecked");
	}
}
