/**
 * 
 */
package PTRAC_DjangoAdminTestScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import adminPages.AdminHomePage;
import baseClass.PTRAC_TestBase;
import commonMethods.CommonMethods;

public class VerifyAllLinks extends PTRAC_TestBase{
	AdminHomePage adminHomePage;
	CommonMethods cm;

	@Test(priority=1)
	public void verifyDjangoAdminMenu() throws IOException, InterruptedException{
		cm=new CommonMethods();
		getBrowser();
		navigateDjangoAdminURL();
		cm.loginAdmin(staffUser,staffPassword);
		wait(2);		

		adminHomePage=new AdminHomePage();
		try {
			verifyElementDisplayed("Account Layers link", adminHomePage.getLnkAccountLayers());
			verifyElementDisplayed("Accounts link", adminHomePage.getLnkAccounts());
			verifyElementDisplayed("Ais Requests link", adminHomePage.getLnkAisRequests());
			verifyElementDisplayed("AIS Supplier link", adminHomePage.getLnkAISSupplierReport());
			verifyElementDisplayed("Automatic Management Reports link", adminHomePage.getLnkAutomaticManagementReports());
			verifyElementDisplayed("Bulk Screen link", adminHomePage.getLnkBulkScreen());
			verifyElementDisplayed("Client Billing Report link", adminHomePage.getLnkClientBillingReport());
			verifyElementDisplayed("Communicator Makes link", adminHomePage.getLnkCommunicatorMakes());
			verifyElementDisplayed("Compliance Sanctions link", adminHomePage.getLnkComplianceSanctions());
			verifyElementDisplayed("Countries link", adminHomePage.getLnkCountries());
			verifyElementDisplayed("Documents link", adminHomePage.getLnkDocuments());
			verifyElementDisplayed("Dow Jones Billing Report link", adminHomePage.getLnkDowJonesBillingReport());
			verifyElementDisplayed("Errors link", adminHomePage.getLnkErrors());
			verifyElementDisplayed("Exports link", adminHomePage.getLnkExports());
			verifyElementDisplayed("False Positives link", adminHomePage.getLnkFalsePositives());
			verifyElementDisplayed("Formats link", adminHomePage.getLnkFormats());
			verifyElementDisplayed("Geoserver Layer Billing Report link", adminHomePage.getLnkGeoserverLayerBillingReport());
			verifyElementDisplayed("Geoserver Layers link", adminHomePage.getLnkGeoserverLayers());
			verifyElementDisplayed("Groups link", adminHomePage.getLnkGroups());
			verifyElementDisplayed("IHS Billing Report link", adminHomePage.getLnkIHSBillingReport());
			verifyElementDisplayed("API keys link", adminHomePage.getLnkKeys());
			verifyElementDisplayed("Languages link", adminHomePage.getLnkLanguages());
			verifyElementDisplayed("Load Demo Data link", adminHomePage.getLnkLoadDemoData());
			verifyElementDisplayed("Magic Passwords link", adminHomePage.getLnkMagicPasswords());
			verifyElementDisplayed("Management Report Fields link", adminHomePage.getLnkManagementReportFields());
			verifyElementDisplayed("Management Reports link", adminHomePage.getLnkManagementReports());
			verifyElementDisplayed("Notification Events link", adminHomePage.getLnkNotificationEvents());
			verifyElementDisplayed("Notifications link", adminHomePage.getLnkNotifications());
			verifyElementDisplayed("Overdue Ships link", adminHomePage.getLnkOverdueShips());
			verifyElementDisplayed("Port Blacklists link", adminHomePage.getLnkPortBlacklists());
			verifyElementDisplayed("Ports link", adminHomePage.getLnkPorts());
			verifyElementDisplayed("Positions link", adminHomePage.getLnkPositions());
			verifyElementDisplayed("Ready To Track Ships link", adminHomePage.getLnkReadyToTrackShips());
			verifyElementDisplayed("Registrations link", adminHomePage.getLnkRegistrations());
			verifyElementDisplayed("Report Requests link", adminHomePage.getLnkReportRequests());
			verifyElementDisplayed("Sanctioned Countrys link", adminHomePage.getLnkSanctionedCountrys());
			verifyElementDisplayed("Ship Details link", adminHomePage.getLnkShipDetails());
			verifyElementDisplayed("Ships link", adminHomePage.getLnkShips());
			verifyElementDisplayed("SIS Mappings link", adminHomePage.getLnkSisMappings());
			verifyElementDisplayed("Transactions link", adminHomePage.getLnkTransactions());
			verifyElementDisplayed("Translation codes link", adminHomePage.getLnkTranslationCodes());
			verifyElementDisplayed("User Managers link", adminHomePage.getLnkUserManagers());
			verifyElementDisplayed("Users link", adminHomePage.getLnkUsers());
			verifyElementDisplayed("Voyages link", adminHomePage.getLnkVoyages());
			verifyElementDisplayed("Zone Historys link", adminHomePage.getLnkZoneHistorys());
		} catch (Exception e) {
			captureFailStatus("Some of the Links are not displayed");
		}
	}

	@Test(priority=2)
	public void verifyAccountlayers() throws IOException {

		try {
			if(verifyElementDisplayed("Account Layers link",adminHomePage.getLnkAccountLayers())) {
				click("Account Layers link",adminHomePage.getLnkAccountLayers());
			}
		} catch (IOException e) {
			captureFailStatus("Account Layers link not available");
		}

		try {
			if(verifyElementDisplayed("Account Layers page",adminHomePage.getLnkHome())) {
				capturePassStatus("Account Layers page is available");
				click("Home Link",adminHomePage.getLnkHome());
			}
			else
			{
				captureFailStatus("Account Layers page is not available");
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Account Layers page is not available");
		} 
	}

	@Test(priority=3)
	public void verifyAccounts() throws IOException {

		try {
			if(verifyElementDisplayed("Accounts link",adminHomePage.getLnkAccounts())) {
				click("Accounts link",adminHomePage.getLnkAccounts());
			}
		} catch (IOException e) {
			captureFailStatus("Accounts link not available");
		}

		try {
			if(verifyElementDisplayed("Accounts page",adminHomePage.getLnkHome())) {
				capturePassStatus("Accounts page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Accounts page is not available");
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Accounts page is not available");
		} 
	}

	@Test(priority=4)
	public void verifyAisRequests() throws IOException {

		try {
			if(verifyElementDisplayed("Ais Requests link",adminHomePage.getLnkAisRequests())) {
				click("Ais Requests link",adminHomePage.getLnkAisRequests());
			}
		} catch (IOException e) {
			captureFailStatus("Ais Requests not available");
		}

		try {
			if(verifyElementDisplayed("Ais Requests page",adminHomePage.getLnkHome())) {
				capturePassStatus("Ais Requests page is available");
				click("Home Link",adminHomePage.getLnkHome());
			}
			else
			{
				captureFailStatus("Ais Requests page is not available");
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Ais Requests page is not available");
		} 
	}

	@Test(priority=5)
	public void verifyAISSupplierReport() throws IOException {

		try {
			if(verifyElementDisplayed("AIS Supplier Report link",adminHomePage.getLnkAISSupplierReport())) {
				click("AIS Supplier Report link",adminHomePage.getLnkAISSupplierReport());
			}
		} catch (IOException e) {
			captureFailStatus("AIS Supplier Report link not available");
		}

		try {
			if(verifyElementDisplayed("AIS Supplier Report page",adminHomePage.getLnkHome())) {
				capturePassStatus("AIS Supplier Report page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("AIS Supplier Report page is not available");
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("AIS Supplier Report page is not available");
		} 
	}

	@Test(priority=6)
	public void verifyAPIKeys() throws IOException {

		try {
			if(verifyElementDisplayed("API Keys link",adminHomePage.getLnkKeys())) {
				click("API Keys link",adminHomePage.getLnkKeys());
			}
		} catch (IOException e) {
			captureFailStatus("API Keys not available");
		}

		try {
			if(verifyElementDisplayed("API Keys page",adminHomePage.getLnkHome())) {
				capturePassStatus("API Keys page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("API Keys page is not available");  
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("API Keys page is not available");
		} 
	}

	@Test(priority=7)
	public void verifyAutomaticManagementReports() throws IOException {

		try {
			if(verifyElementDisplayed("Automatic Management Reports link",adminHomePage.getLnkAutomaticManagementReports())) {
				click("Automatic Management Reports link",adminHomePage.getLnkAutomaticManagementReports());
			}
		} catch (IOException e) {
			captureFailStatus("Automatic Management Reports not available");
		}

		try {
			if(verifyElementDisplayed("Automatic Management Reports page",adminHomePage.getLnkHome())) {
				capturePassStatus("Automatic Management Reports page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Automatic Management Reports page is not available");  
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Automatic Management Reports page is not available");
		} 
	}

	@Test(priority=8)
	public void verifyBulkScreen() throws IOException {

		try {
			if(verifyElementDisplayed("Bulk Screen link",adminHomePage.getLnkBulkScreen())) {
				click("Bulk Screen link",adminHomePage.getLnkBulkScreen());
			}
		} catch (IOException e) {
			captureFailStatus(" BulkScreen not available");
		}

		try {
			if(verifyElementDisplayed("Bulk Screen page",adminHomePage.getLnkHome())) {
				capturePassStatus("Bulk Screen page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Bulk Screen page is not available");  
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Bulk Screen page is not available");
		} 
	}

	@Test(priority=9)
	public void verifyClientBillingReport() throws IOException {

		try {
			if(verifyElementDisplayed("Client Billing Report link",adminHomePage.getLnkClientBillingReport())) {
				click("Client Billing Report link",adminHomePage.getLnkClientBillingReport());
			}
		} catch (IOException e) {
			captureFailStatus("Client Billing Report not available");
		}

		try {
			if(verifyElementDisplayed("Client Billing Report page",adminHomePage.getLnkHome())) {
				capturePassStatus("Client Billing Report page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Client Billing Report page is not available");  
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Client Billing Report page is not available");
		} 
	}

	@Test(priority=10)
	public void verifyCommunicatorMakes() throws IOException {

		try {
			if(verifyElementDisplayed("Communicator Makes link",adminHomePage.getLnkCommunicatorMakes())) {
				click("Communicator Makes link",adminHomePage.getLnkCommunicatorMakes());
			}
		} catch (IOException e) {
			captureFailStatus("Communicator Makes not available");
		}

		try {
			if(verifyElementDisplayed("Communicator Makes page",adminHomePage.getLnkHome())) {
				capturePassStatus("Communicator Makes page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Communicator Makes page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Communicator Makes page is not available");
		} 
	}

	@Test(priority=11)
	public void verifyComplianceSanctions() throws IOException {

		try {
			if(verifyElementDisplayed("Compliance Sanctions link",adminHomePage.getLnkComplianceSanctions())) {
				click("Compliance Sanctions link",adminHomePage.getLnkComplianceSanctions());
			}
		} catch (IOException e) {
			captureFailStatus("Compliance Sanctions not available");
		}

		try {
			if(verifyElementDisplayed("Compliance Sanctions page",adminHomePage.getLnkHome())) {
				capturePassStatus("Compliance Sanctions page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Compliance Sanctions page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Compliance Sanctions page is not available");
		} 
	}

	@Test(priority=12)
	public void verifyCountries() throws IOException {

		try {
			if(verifyElementDisplayed("Countries link",adminHomePage.getLnkCountries())) {
				click("Countries link",adminHomePage.getLnkCountries());
			}
		} catch (IOException e) {
			captureFailStatus("Countries not available");
		}

		try {
			if(verifyElementDisplayed("Countries page",adminHomePage.getLnkHome())) {
				capturePassStatus("Countries page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Countries page is not available");  
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Countries page is not available");
		} 
	}

	@Test(priority=13)
	public void verifyDocuments() throws IOException {

		try {
			if(verifyElementDisplayed("Documents link",adminHomePage.getLnkDocuments())) {
				click("Documents link",adminHomePage.getLnkDocuments());
			}
		} catch (IOException e) {
			captureFailStatus("Documents not available");
		}

		try {
			if(verifyElementDisplayed("Documents page",adminHomePage.getLnkHome())) {
				capturePassStatus("Documents page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Documents page is not available");  
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Documents page is not available");
		} 
	}

	@Test(priority=14)
	public void verifyDowJonesBillingReport() throws IOException {

		try {
			if(verifyElementDisplayed("DowJones Billing Report link",adminHomePage.getLnkDowJonesBillingReport())) {
				click("DowJones Billing Report link link",adminHomePage.getLnkDowJonesBillingReport());
			}
		} catch (IOException e) {
			captureFailStatus("DowJones Billing Report link not available");
		}

		try {
			if(verifyElementDisplayed("DowJones Billing Report link page",adminHomePage.getLnkHome())) {
				capturePassStatus("DowJones Billing Report link page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("DowJones Billing Report link page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("DowJones Billing Report link page is not available");
		} 
	}

	@Test(priority=15)
	public void verifyErrors() throws IOException {

		try {
			if(verifyElementDisplayed("Errors link",adminHomePage.getLnkErrors())) {
				click("Errors link",adminHomePage.getLnkErrors());
			}
		} catch (IOException e) {
			captureFailStatus("Errors not available");
		}

		try {
			if(verifyElementDisplayed("Errors page",adminHomePage.getLnkHome())) {
				capturePassStatus("Errors page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Errors page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Errors page is not available");
		} 
	}

	@Test(priority=16)
	public void verifyExports() throws IOException {

		try {
			if(verifyElementDisplayed("Exports link",adminHomePage.getLnkExports())) {
				click("Exports link",adminHomePage.getLnkExports());
			}
		} catch (IOException e) {
			captureFailStatus("Exports not available");
		}

		try {
			if(verifyElementDisplayed("Exports page",adminHomePage.getLnkHome())) {
				capturePassStatus("Exports page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Exports page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Exports page is not available");
		} 
	}

	@Test(priority=17)
	public void verifyFalsePositives() throws IOException {

		try {
			if(verifyElementDisplayed("False Positives link",adminHomePage.getLnkFalsePositives())) {
				click("False Positives link",adminHomePage.getLnkFalsePositives());
			}
		} catch (IOException e) {
			captureFailStatus("False Positives not available");
		}

		try {
			if(verifyElementDisplayed("False Positives page",adminHomePage.getLnkHome())) {
				capturePassStatus("False Positives page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("False Positives page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("False Positives page is not available");
		} 
	}

	@Test(priority=18)
	public void verifyFormats() throws IOException {

		try {
			if(verifyElementDisplayed("Formats link",adminHomePage.getLnkFormats())) {
				click("Formats link",adminHomePage.getLnkFormats());
			}
		} catch (IOException e) {
			captureFailStatus("Formats not available");
		}

		try {
			if(verifyElementDisplayed("Formats page",adminHomePage.getLnkHome())) {
				capturePassStatus("Formats page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Formats page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Formats page is not available");
		} 
	}

	@Test(priority=19)
	public void verifyGeoserverLayer() throws IOException {

		try {
			if(verifyElementDisplayed("Geoserver Layer link",adminHomePage.getLnkGeoserverLayers())) {
				click("Geoserver Layer link",adminHomePage.getLnkGeoserverLayers());
			}
		} catch (IOException e) {
			captureFailStatus("GeoserverLayer not available");
		}

		try {
			if(verifyElementDisplayed("GeoserverLayer page",adminHomePage.getLnkHome())) {
				capturePassStatus("GeoserverLayer page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("GeoserverLayer page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("GeoserverLayer page is not available");
		} 
	}

	@Test(priority=20)
	public void verifyGeoserverLayerBillingReport() throws IOException {

		try {
			if(verifyElementDisplayed("Geoserver Layer Billing Report link",adminHomePage.getLnkGeoserverLayerBillingReport())) {
				click("Geoserver Layer Billing Report link",adminHomePage.getLnkGeoserverLayerBillingReport());
			}
		} catch (IOException e) {
			captureFailStatus("Geoserver Layer Billing Report not available");
		}

		try {
			if(verifyElementDisplayed("Geoserver Layer Billing Report page",adminHomePage.getLnkHome())) {
				capturePassStatus("Geoserver Layer Billing Report page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Geoserver Layer Billing Report page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Geoserver Layer Billing Report page is not available");
		} 
	}

	@Test(priority=21)
	public void verifyGroups() throws IOException {

		try {
			if(verifyElementDisplayed("Groups link",adminHomePage.getLnkGroups())) {
				click("Groups link",adminHomePage.getLnkGroups());
			}
		} catch (IOException e) {
			captureFailStatus("Groups not available");
		}

		try {
			if(verifyElementDisplayed("Groups page",adminHomePage.getLnkHome())) {
				capturePassStatus("Groups page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Groups page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Groups page is not available");
		} 
	}

	@Test(priority=22)
	public void verifyIHSBillingReport() throws IOException {

		try {
			if(verifyElementDisplayed("IHS Billing Report link",adminHomePage.getLnkIHSBillingReport())) {
				click("IHS Billing Report link",adminHomePage.getLnkIHSBillingReport());
			}
		} catch (IOException e) {
			captureFailStatus("IHS Billing Report not available");
		}

		try {
			if(verifyElementDisplayed("IHS Billing Report page",adminHomePage.getLnkHome())) {
				capturePassStatus("IHS Billing Report page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("IHS Billing Report page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("IHS Billing Report page is not available");
		} 
	}

	@Test(priority=23)
	public void verifyLanguages() throws IOException {

		try {
			if(verifyElementDisplayed("Languages link",adminHomePage.getLnkLanguages())) {
				click("Languages link",adminHomePage.getLnkLanguages());
			}
		} catch (IOException e) {
			captureFailStatus("Languages not available");
		}

		try {
			if(verifyElementDisplayed("Languages page",adminHomePage.getLnkHome())) {
				capturePassStatus("Languages page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Languages page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Languages page is not available");
		} 
	}

	@Test(priority=24)
	public void verifyLoadDemoData() throws IOException {

		try {
			if(verifyElementDisplayed("Load Demo Data link",adminHomePage.getLnkLoadDemoData())) {
				click("Load Demo Data link",adminHomePage.getLnkLoadDemoData());
			}
		} catch (IOException e) {
			captureFailStatus("Load Demo Data not available");
		}

		try {
			if(verifyElementDisplayed("Load Demo Data page",adminHomePage.getLnkHome())) {
				capturePassStatus("Load Demo Data page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Load Demo Data page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Load Demo Data page is not available");
		} 
	}

	@Test(priority=25)
	public void verifyMagicPasswords() throws IOException {

		try {
			if(verifyElementDisplayed("MagicPasswords link",adminHomePage.getLnkMagicPasswords())) {
				click("Magic Passwords link",adminHomePage.getLnkMagicPasswords());
			}
		} catch (IOException e) {
			captureFailStatus("Magic Passwords not available");
		}

		try {
			if(verifyElementDisplayed("Magic Passwords page",adminHomePage.getLnkHome())) {
				capturePassStatus("Magic Passwords page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Magic Passwords page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Magic Passwords page is not available");
		} 
	}

	@Test(priority=26)
	public void verifyManagementReportFields() throws IOException {

		try {
			if(verifyElementDisplayed("Management Report Fields link",adminHomePage.getLnkManagementReportFields())) {
				click("Management Report Fields link",adminHomePage.getLnkManagementReportFields());
			}
		} catch (IOException e) {
			captureFailStatus("Management Report Fields not available");
		}

		try {
			if(verifyElementDisplayed("Management Report Fields page",adminHomePage.getLnkHome())) {
				capturePassStatus("Management Report Fields page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Management Report Fields page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Management Report Fields page is not available");
		} 
	}

	@Test(priority=27)
	public void verifyManagementReports() throws IOException {

		try {
			if(verifyElementDisplayed("Management Reports link",adminHomePage.getLnkManagementReports())) {
				click("Management Reports link",adminHomePage.getLnkManagementReports());
			}
		} catch (IOException e) {
			captureFailStatus("Management Reports not available");
		}

		try {
			if(verifyElementDisplayed("Management Reports page",adminHomePage.getLnkHome())) {
				capturePassStatus("Management Reports page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Management Reports page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Management Reports page is not available");
		} 
	}

	@Test(priority=28)
	public void verifyNotificationEvents() throws IOException {

		try {
			if(verifyElementDisplayed("Notification Events link",adminHomePage.getLnkNotificationEvents())) {
				click("Notification Events link",adminHomePage.getLnkNotificationEvents());
			}
		} catch (IOException e) {
			captureFailStatus("Notification Events not available");
		}

		try {
			if(verifyElementDisplayed("Notification Events page",adminHomePage.getLnkHome())) {
				capturePassStatus("Notification Events page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Notification Events page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Notification Events page is not available");
		} 
	}

	@Test(priority=29)
	public void verifyNotifications() throws IOException {

		try {
			if(verifyElementDisplayed("Notifications link",adminHomePage.getLnkNotifications())) {
				click("Notifications link",adminHomePage.getLnkNotifications());
			}
		} catch (IOException e) {
			captureFailStatus("Notifications not available");
		}

		try {
			if(verifyElementDisplayed("Notifications page",adminHomePage.getLnkHome())) {
				capturePassStatus("Notifications page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Notifications page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Notifications page is not available");
		} 
	}

	@Test(priority=30)
	public void verifyOverdueShips() throws IOException {

		try {
			if(verifyElementDisplayed("OverdueShips link",adminHomePage.getLnkOverdueShips())) {
				click("OverdueShips link",adminHomePage.getLnkOverdueShips());
			}
		} catch (IOException e) {
			captureFailStatus("OverdueShips not available");
		}

		try {
			if(verifyElementDisplayed("OverdueShips page",adminHomePage.getLnkHome())) {
				capturePassStatus("OverdueShips page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("OverdueShips page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("OverdueShips page is not available");
		} 
	}

	@Test(priority=31)
	public void verifyReadyToTrackShips() throws IOException {

		try {
			if(verifyElementDisplayed("Ready To Track Ships link",adminHomePage.getLnkReadyToTrackShips())) {
				click("Ready To Track Ships link",adminHomePage.getLnkReadyToTrackShips());
			}
		} catch (IOException e) {
			captureFailStatus("Ready To Track Ships not available");
		}

		try {
			if(verifyElementDisplayed("Ready To Track Ships page",adminHomePage.getLnkHome())) {
				capturePassStatus("Ready To Track Ships page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Ready To Track Ships page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Ready To Track Ships page is not available");
		} 
	}

	@Test(priority=32)
	public void verifyRegistrations() throws IOException {

		try {
			if(verifyElementDisplayed("Registrations link",adminHomePage.getLnkRegistrations())) {
				click("Registrations link",adminHomePage.getLnkRegistrations());
			}
		} catch (IOException e) {
			captureFailStatus("Registrations not available");
		}

		try {
			if(verifyElementDisplayed("Registrations page",adminHomePage.getLnkHome())) {
				capturePassStatus("Registrations page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Registrations page is not available");  
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Registrations page is not available");
		} 
	}

	@Test(priority=33)
	public void verifyReportRequests() throws IOException {

		try {
			if(verifyElementDisplayed("Report Requests link",adminHomePage.getLnkReportRequests())) {
				click("Report Requests link",adminHomePage.getLnkReportRequests());
			}
		} catch (IOException e) {
			captureFailStatus("Report Requests link not available");
		}

		try {
			if(verifyElementDisplayed("Report Requests page",adminHomePage.getLnkHome())) {
				capturePassStatus("Report Requests page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Report Requests page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Report Requests page is not available");
		} 
	}

	@Test(priority=34)
	public void verifySanctionedCountrys() throws IOException {

		try {
			if(verifyElementDisplayed("Sanctioned Countrys link",adminHomePage.getLnkSanctionedCountrys())) {
				click("Sanctioned Countrys link",adminHomePage.getLnkSanctionedCountrys());
			}
		} catch (IOException e) {
			captureFailStatus("Sanctioned Countrys not available");
		}

		try {
			if(verifyElementDisplayed("Sanctioned Countrys page",adminHomePage.getLnkHome())) {
				capturePassStatus("Sanctioned Countrys page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Sanctioned Countrys page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Sanctioned Countrys page is not available");
		} 
	}

	@Test(priority=35)
	public void verifyShipDetails() throws IOException {

		try {
			if(verifyElementDisplayed("Ship Details link",adminHomePage.getLnkShipDetails())) {
				click("Ship Details link",adminHomePage.getLnkShipDetails());
			}
		} catch (IOException e) {
			captureFailStatus("Ship Details link not available");
		}

		try {
			if(verifyElementDisplayed("Ship Details page",adminHomePage.getLnkHome())) {
				capturePassStatus("Ship Details page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Ship Details page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Ship Details page is not available");
		} 
	}

	@Test(priority=36)
	public void verifyShips() throws IOException {

		try {
			if(verifyElementDisplayed("Ships link",adminHomePage.getLnkShips())) {
				click("Ships link",adminHomePage.getLnkShips());
			}
		} catch (IOException e) {
			captureFailStatus("Ships link not available");
		}

		try {
			if(verifyElementDisplayed("Ships page",adminHomePage.getLnkHome())) {
				capturePassStatus("Ships page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Ships page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Ships page is not available");
		} 
	}

	@Test(priority=37)
	public void verifySISMappings() throws IOException {

		try {
			if(verifyElementDisplayed("SIS Mappings link",adminHomePage.getLnkSisMappings())) {
				click("SIS Mappings link",adminHomePage.getLnkSisMappings());
			}
		} catch (IOException e) {
			captureFailStatus("SIS Mappings not available");
		}

		try {
			if(verifyElementDisplayed("SIS Mappings link page",adminHomePage.getLnkHome())) {
				capturePassStatus("SIS Mappings page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("SIS Mappings page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("SIS Mappings page is not available");
		} 
	}

	@Test(priority=38)
	public void verifyTransactions() throws IOException {

		try {
			if(verifyElementDisplayed("Transactions link",adminHomePage.getLnkTransactions())) {
				click("Transactions link",adminHomePage.getLnkTransactions());
			}
		} catch (IOException e) {
			captureFailStatus("Transactions link not available");
		}

		try {
			if(verifyElementDisplayed("Transactions page",adminHomePage.getLnkHome())) {
				capturePassStatus("Transactions page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Transactions page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Transactions page is not available");
		} 
	}

	@Test(priority=39)
	public void verifyTranslationCodes() throws IOException {

		try {
			if(verifyElementDisplayed("Translation Codes link",adminHomePage.getLnkTranslationCodes())) {
				click("Translation Codes link",adminHomePage.getLnkTranslationCodes());
			}
		} catch (IOException e) {
			captureFailStatus("Translation Codes link not available");
		}

		try {
			if(verifyElementDisplayed("Translation Codes page",adminHomePage.getLnkHome())) {
				capturePassStatus("Translation Codes page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Translation Codes page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Translation Codes page is not available");
		} 
	}

	@Test(priority=40)
	public void verifyUserManagers() throws IOException {

		try {
			if(verifyElementDisplayed("User Managers link",adminHomePage.getLnkUserManagers())) {
				click("User Managers link",adminHomePage.getLnkUserManagers());
			}
		} catch (IOException e) {
			captureFailStatus("User Managers not available");
		}

		try {
			if(verifyElementDisplayed("User Managers page",adminHomePage.getLnkHome())) {
				capturePassStatus("User Managers page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("User Managers page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("User Managers page is not available");
		} 
	}

	@Test(priority=41)
	public void verifyUsers() throws IOException {

		try {
			if(verifyElementDisplayed("Users link",adminHomePage.getLnkUsers())) {
				click("Users link",adminHomePage.getLnkUsers());
			}
		} catch (IOException e) {
			captureFailStatus("Users links not available");
		}

		try {
			if(verifyElementDisplayed("Users page",adminHomePage.getLnkHome())) {
				capturePassStatus("Users page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Users page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Users page is not available");
		} 
	}

	@Test(priority=42)
	public void verifyVoyages() throws IOException {

		try {
			if(verifyElementDisplayed("Voyages link",adminHomePage.getLnkVoyages())) {
				click("Voyages link",adminHomePage.getLnkVoyages());
			}
		} catch (IOException e) {
			captureFailStatus("Voyages not available");
		}

		try {
			if(verifyElementDisplayed("Voyages page",adminHomePage.getLnkHome())) {
				capturePassStatus("Voyages page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Voyages page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Voyages page is not available");
		} 
	}

	@Test(priority=43)
	public void verifyZoneHistorys() throws IOException {

		try {
			if(verifyElementDisplayed("Zone Historys link",adminHomePage.getLnkZoneHistorys())) {
				click("Zone Historys link",adminHomePage.getLnkZoneHistorys());
			}
		} catch (IOException e) {
			captureFailStatus("Zone Historys link not available");
		}

		try {
			if(verifyElementDisplayed("Zone Historys page",adminHomePage.getLnkHome())) {
				capturePassStatus("Zone Historys page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Zone Historys page is not available");  driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Zone Historys page is not available");
		} 
	}

	@Test(priority=44)
	public void verifyPortBlacklists() throws IOException {

		try {
			if(verifyElementDisplayed("Port Blacklists link",adminHomePage.getLnkPortBlacklists())) {
				click("Port Blacklists link",adminHomePage.getLnkPortBlacklists());
			}
		} catch (IOException e) {
			captureFailStatus("Port Blacklists link not available");
		}

		try {
			if(verifyElementDisplayed("Port Blacklists page",adminHomePage.getLnkHome())) {
				capturePassStatus("PortBlacklists page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Port Blacklists page is not available"); 
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Port Blacklists page is not available");
		} 
	}

	@Test(priority=45)
	public void verifyPorts() throws IOException {

		try {
			if(verifyElementDisplayed("Ports link",adminHomePage.getLnkPorts())) {
				click("Ports link",adminHomePage.getLnkPorts());
			}
		} catch (IOException e) {
			captureFailStatus("Ports not available");
		}

		try {
			if(verifyElementDisplayed("Ports page",adminHomePage.getLnkHome())) {
				capturePassStatus("Ports page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Ports page is not available"); 
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Ports page is not available");
		} 
	}

	@Test(priority=45)
	public void verifyPositions() throws IOException {

		try {
			if(verifyElementDisplayed("Positions link",adminHomePage.getLnkPositions())) {
				click("Positions link",adminHomePage.getLnkPositions());
			}
		} catch (IOException e) {
			captureFailStatus("Positions not available");
		}

		try {
			if(verifyElementDisplayed("Positions page",adminHomePage.getLnkHome())) {
				capturePassStatus("Positions page is available");
				click("Home Link",adminHomePage.getLnkHome() );
			}
			else
			{
				captureFailStatus("Positions page is not available"); 
				driver.navigate().back();
			}
		} catch (IOException e) {
			captureFailStatus("Positions page is not available");
		} 
	}
}

/*List<WebElement> urllist=driver.findElements(By.tagName("a"));
System.out.println(urllist.size());
for(int i=0;i<urllist.size();i++){
	WebElement element=urllist.get(i);
	System.out.println("innertext "+element.getAttribute("innerText"));
	String name=element.getText();
	System.out.println("get text " +name);
	String url1=element.getAttribute("href");
	try {
		URL url2=new URL(url1);
		HttpURLConnection http1=(HttpURLConnection) url2.openConnection();
		//http1.setConnectTimeout(5);
		http1.connect();
		System.out.println("URL value is :"+url1);
		System.out.println("Response code is: "+http1.getResponseCode());
		System.out.println("Response Message is: "+http1.getResponseMessage());
	} catch (Exception e) {
		System.out.println(e);
	}}*/
