package webPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.PTRAC_TestBase;

public class HomePage extends PTRAC_TestBase{
	public List<WebElement> list;

	@FindBy(xpath=".//a[contains(.,'Logout')]")
	WebElement logoutTxt;	

	public List<WebElement> getList() {
		return list;
	}


	@FindBy(xpath=".//*[@id='account']/img")
	WebElement imgProfile;	

	@FindBy(id="SCREEN")
	WebElement tabScreen;	

	@FindBy(partialLinkText="TRACK")
	WebElement tabTrack;	

	@FindBy(xpath="//*[contains(@id,'ptdashtradernav')]")
	WebElement tabDashboard;

	@FindBy(id="ARCHIVE")
	WebElement tabArchive;

	@FindBy(id="REPORTS")
	WebElement tabReports;

	@FindBy(xpath="//a[@class='logo ir']")
	WebElement txtHeader;

	@FindBy(xpath="//a[@class='logo ir']//sup")
	WebElement tmHeader;

	@FindBy(xpath="//*[@id='dowjones']")
	WebElement lblHeader;

	//@FindBy(xpath=".//*[@id='ptlink-1020']/span")
	@FindBy(xpath=".//*[@id='ptlink-1017']/span")
	WebElement lnkAddShip;

	@FindBy(xpath=".//*[contains(@id,'ptfooter')]/ul/li[3]")
	WebElement lblAppVersion;

	@FindBy(xpath=".//*[@id='privacy-policy']")
	WebElement lnkPrivacyPolicy;

	@FindBy(xpath=".//*[@id='terms-of-use']")
	WebElement lnkTermsOfUse;

	@FindBy(xpath="//div[@id='ptfooter-1014']")
	WebElement txtFooter;

	@FindBy(xpath="//*[@id='account']//img")
	WebElement logoCompany;

	@FindBy(xpath="//a[contains(.,'Map')]")
	WebElement lnkMap;

	@FindBy(xpath="//a[contains(.,'List')]")
	WebElement lnkList;

	@FindBy(xpath=".//*[contains(@id,'textfield') and contains(@id,'inputEl')]")
	WebElement txtSearchField;

	@FindBy(xpath=".//span[contains(.,'Privacy Policy')]")
	WebElement dlgPrivacyPolicy;

	@FindBy(xpath=".//span[contains(.,'Terms of Use')]")
	WebElement dlgTermsOfUse;

	public WebElement getLogoutTxt() {
		return logoutTxt;
	}

	public WebElement getImgProfile() {
		return imgProfile;
	}

	public WebElement getTabScreen() {
		return tabScreen;
	}

	public WebElement getTabTrack() {
		return tabTrack;
	}

	public WebElement getTabArchive() {
		return tabArchive;
	}

	public WebElement getTabReports() {
		return tabReports;
	}

	public WebElement getTxtHeader() {
		return txtHeader;
	}

	public WebElement getTmHeader() {
		return tmHeader;
	}

	public WebElement getLblHeader() {
		return lblHeader;
	}

	public WebElement getLnkAddShip() {
		List a=driver.findElements(By.xpath(".//a[contains(@id,'ptlink')]"));
		WebElement b = null;
		for (int i=0; i<a.size();i++) {
			b=(WebElement) a.get(i);
			if (b.getText().contains("ADD SHIP")) {
				break;
				
			}
			}
		return b;
		}
		
	public WebElement getLblAppVersion() {
		return lblAppVersion;
	}

	public WebElement getLnkPrivacyPolicy() {
		return lnkPrivacyPolicy;
	}

	public WebElement getLnkTermsOfUse() {
		return lnkTermsOfUse;
	}

	public WebElement getTxtFooter() {
		return txtFooter;
	}

	public WebElement getLogoCompany() {
		return logoCompany;
	}

	public WebElement getLnkMap() {
		return lnkMap;
	}

	public WebElement getLnkList() {
		return lnkList;
	}

	public WebElement getTxtSearchField() {
		return txtSearchField;
	}

	public WebElement getDlgPrivacyPolicy() {
		return dlgPrivacyPolicy;
	}

	public WebElement getDlgTermsOfUse() {
		return dlgTermsOfUse;
	}

	public HomePage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public LoginPage logout() throws IOException, InterruptedException {
		click("Profile dropdown", imgProfile);
		Thread.sleep(2000);
		click("Log Out button", logoutTxt);
		return new LoginPage();
	}

	public String getHeaderText() {
		String headerText=txtHeader.getText();
		return headerText.substring(0, 10);
	}


	public String getHeaderTm() {
		String headerTM=tmHeader.getText();
		return headerTM;
	}

	public String getHeaderInn() {
		String headerIn1=lblHeader.getText();
		return headerIn1;
	}

	public List getTabs() {
		list =driver.findElements(By.xpath("//*[contains(@id, 'ptdashtab')]"));
		return list;
	}

	public List getLinks() {
		list =driver.findElements(By.xpath("//*[contains(@id, 'ptlink')]"));
		return list;
	}

	public void clickAddShipLnk() throws IOException, AWTException {
		try {
			List a=driver.findElements(By.xpath(".//a[contains(@id,'ptlink')]"));
			for (int i=0; i<a.size();i++) {
				WebElement b=(WebElement) a.get(i);
				if (b.getText().contains("ADD SHIP")) {
					click("Add Ship Link", b);
					break;
				}
			}

		} catch (IOException e) {
			captureFailStatus("Add Ship Link not clicked");
		}
	}

	public TrackPage clickTrackTab() throws IOException {
		click("Track tab", tabTrack);
		return new TrackPage();
	}

	public void clickScreenTab() throws IOException {
		click("", tabDashboard);
		click("Screen tab", tabScreen);
	}

	public ArchivePage clickArchiveTab() throws IOException {
		click("Archive tab", tabArchive);
		return new ArchivePage();
	}

	public ReportsPage clickReportsTab() throws IOException {
		click("Reports tab", tabReports);
		return new ReportsPage();
	}
}