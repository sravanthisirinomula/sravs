package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Library.TestBase;

public class AdminHomePage extends TestBase{

	@FindBy(linkText="Accounts")
	WebElement lnkAccounts;	

	@FindBy(partialLinkText="Magic passwords")
	WebElement lnkMagicPasswords;	

	@FindBy(partialLinkText="User managers")
	WebElement lnkUserManagers;	

	@FindBy(partialLinkText="Groups")
	WebElement lnkGroups;

	@FindBy(partialLinkText="Users")
	WebElement lnkUsers;	

	@FindBy(partialLinkText="Errors")
	WebElement lnkErrors;	

	@FindBy(partialLinkText="Ais requests")
	WebElement lnkAisRequests;	

	@FindBy(partialLinkText="Communicator makes")
	WebElement lnkCommunicatorMakes;	

	@FindBy(partialLinkText="Documents")
	WebElement lnkDocuments;	

	@FindBy(partialLinkText="Notification events")
	WebElement lnkNotificationEvents;	

	@FindBy(partialLinkText="Notifications")
	WebElement lnkNotifications;	

	@FindBy(partialLinkText="Port blacklists")
	WebElement lnkPortBlacklists;	

	@FindBy(partialLinkText="Positions")
	WebElement lnkPositions;	

	@FindBy(partialLinkText="Registrations")
	WebElement lnkRegistrations;	

	@FindBy(partialLinkText="Report requests")
	WebElement lnkReportRequests;	

	@FindBy(partialLinkText="Ships")
	WebElement lnkShips;	

	@FindBy(partialLinkText="Transactions")
	WebElement lnkTransactions;	

	@FindBy(partialLinkText="Zone historys")
	WebElement lnkZoneHistorys;	

	@FindBy(partialLinkText="Languages")
	WebElement lnkLanguages;	

	@FindBy(partialLinkText="Translation codes")
	WebElement lnkTranslationCodes;	

	@FindBy(partialLinkText="Api keys")
	WebElement lnkKeys;	

	@FindBy(partialLinkText="Countries")
	WebElement lnkCountries;	

	@FindBy(partialLinkText="Ports")
	WebElement lnkPorts;	

	@FindBy(partialLinkText="Voyages")
	WebElement lnkVoyages;	

	@FindBy(partialLinkText="AIS Supplier Report")
	WebElement lnkAISSupplierReport;	

	@FindBy(partialLinkText="Bulk Screen")
	WebElement lnkBulkScreen;	

	@FindBy(partialLinkText="Client Billing Report")
	WebElement lnkClientBillingReport;	

	@FindBy(partialLinkText="Dow Jones Billing Report")
	WebElement lnkDowJonesBillingReport;

	@FindBy(partialLinkText="Geoserver Layer Billing Report")
	WebElement lnkGeoserverLayerBillingReport;	

	@FindBy(partialLinkText="IHS Billing Report")
	WebElement lnkIHSBillingReport;	

	@FindBy(partialLinkText="Load Demo Data")
	WebElement lnkLoadDemoData;	

	@FindBy(partialLinkText="Overdue Ships")
	WebElement lnkOverdueShips;	

	@FindBy(partialLinkText="Ready To Track Ships")
	WebElement lnkReadyToTrackShips;	

	@FindBy(partialLinkText="Automatic management reports")
	WebElement lnkAutomaticManagementReports;	

	@FindBy(partialLinkText="False positives")
	WebElement lnkFalsePositives;	

	@FindBy(partialLinkText="Management report fields")
	WebElement lnkManagementReportFields;	

	@FindBy(partialLinkText="Management reports")
	WebElement lnkManagementReports;	

	@FindBy(partialLinkText="Sanctioned countrys")
	WebElement lnkSanctionedCountrys;	

	@FindBy(partialLinkText="Ship Details")
	WebElement lnkShipDetails;	

	@FindBy(partialLinkText="Sis mappings")
	WebElement lnkSisMappings;	

	@FindBy(partialLinkText="Account layers")
	WebElement lnkAccountLayers;	

	@FindBy(partialLinkText="Geoserver layers")
	WebElement lnkGeoserverLayers;	

	@FindBy(partialLinkText="Compliance sanctions")
	WebElement lnkComplianceSanctions;	

	@FindBy(partialLinkText="Exports")
	WebElement lnkExports;	

	@FindBy(partialLinkText="Formats")
	WebElement lnkFormats;	

	@FindBy(xpath="//a[contains(.,'Home')]")
	WebElement lnkHome;

	public AdminHomePage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLnkAccounts() {
		return lnkAccounts;
	}

	public WebElement getLnkMagicPasswords() {
		return lnkMagicPasswords;
	}

	public WebElement getLnkUserManagers() {
		return lnkUserManagers;
	}

	public WebElement getLnkGroups() {
		return lnkGroups;
	}

	public WebElement getLnkUsers() {
		return lnkUsers;
	}

	public WebElement getLnkErrors() {
		return lnkErrors;
	}

	public WebElement getLnkAisRequests() {
		return lnkAisRequests;
	}

	public WebElement getLnkCommunicatorMakes() {
		return lnkCommunicatorMakes;
	}

	public WebElement getLnkDocuments() {
		return lnkDocuments;
	}

	public WebElement getLnkNotificationEvents() {
		return lnkNotificationEvents;
	}

	public WebElement getLnkNotifications() {
		return lnkNotifications;
	}

	public WebElement getLnkPortBlacklists() {
		return lnkPortBlacklists;
	}

	public WebElement getLnkPositions() {
		return lnkPositions;
	}

	public WebElement getLnkRegistrations() {
		return lnkRegistrations;
	}

	public WebElement getLnkReportRequests() {
		return lnkReportRequests;
	}

	public WebElement getLnkShips() {
		return lnkShips;
	}

	public WebElement getLnkTransactions() {
		return lnkTransactions;
	}

	public WebElement getLnkZoneHistorys() {
		return lnkZoneHistorys;
	}

	public WebElement getLnkLanguages() {
		return lnkLanguages;
	}

	public WebElement getLnkTranslationCodes() {
		return lnkTranslationCodes;
	}

	public WebElement getLnkKeys() {
		return lnkKeys;
	}

	public WebElement getLnkCountries() {
		return lnkCountries;
	}

	public WebElement getLnkPorts() {
		return lnkPorts;
	}

	public WebElement getLnkVoyages() {
		return lnkVoyages;
	}

	public WebElement getLnkAISSupplierReport() {
		return lnkAISSupplierReport;
	}

	public WebElement getLnkBulkScreen() {
		return lnkBulkScreen;
	}

	public WebElement getLnkClientBillingReport() {
		return lnkClientBillingReport;
	}

	public WebElement getLnkDowJonesBillingReport() {
		return lnkDowJonesBillingReport;
	}

	public WebElement getLnkGeoserverLayerBillingReport() {
		return lnkGeoserverLayerBillingReport;
	}

	public WebElement getLnkIHSBillingReport() {
		return lnkIHSBillingReport;
	}

	public WebElement getLnkLoadDemoData() {
		return lnkLoadDemoData;
	}

	public WebElement getLnkOverdueShips() {
		return lnkOverdueShips;
	}

	public WebElement getLnkReadyToTrackShips() {
		return lnkReadyToTrackShips;
	}

	public WebElement getLnkAutomaticManagementReports() {
		return lnkAutomaticManagementReports;
	}

	public WebElement getLnkFalsePositives() {
		return lnkFalsePositives;
	}

	public WebElement getLnkManagementReportFields() {
		return lnkManagementReportFields;
	}

	public WebElement getLnkManagementReports() {
		return lnkManagementReports;
	}

	public WebElement getLnkSanctionedCountrys() {
		return lnkSanctionedCountrys;
	}

	public WebElement getLnkShipDetails() {
		return lnkShipDetails;
	}

	public WebElement getLnkSisMappings() {
		return lnkSisMappings;
	}

	public WebElement getLnkAccountLayers() {
		System.out.println(lnkAccountLayers);
		return lnkAccountLayers;
	}

	public WebElement getLnkGeoserverLayers() {
		return lnkGeoserverLayers;
	}

	public WebElement getLnkComplianceSanctions() {
		return lnkComplianceSanctions;
	}

	public WebElement getLnkExports() {
		return lnkExports;
	}

	public WebElement getLnkFormats() {
		return lnkFormats;
	}

	public WebElement getLnkHome() {
		return lnkHome;
	}
}
