package PTRAC_GenericScripts;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.ptrac.qa.baseclass.PTRAC_TestBase;
import com.ptrac.qa.commonMethods.CommonMethods;
import com.ptrac.qa.webpages.HomePage;
import com.ptrac.qa.webpages.LoginPage;
import com.ptrac.qa.webpages.SortingPage;

public class Generic_VerifyPurpleTRACHomeScreen extends PTRAC_TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SortingPage sortPage;
	CommonMethods cm;
	Robot robot;

	@Test
	public void Generic_VerifyPurpleTRAC_HomeScreen() throws InterruptedException, IOException, AWTException {
		loginPage=new LoginPage();
		cm=new CommonMethods();
		robot=new Robot();
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		homePage=new HomePage();
		verifyHeaders();
		verifyheadIn();
		verifyTabs();
		verifyAddShipLnk();
		verifyFooter();
		VerifytermsOfUse();
		verifyVersion();
		verifyPrivacyPolicy();
		verifyCompLogo();
		verifySearchField();
		verifySortDrop();
		verifyMapLink();
		verifyListLink();
	}


	private void verifyListLink() throws IOException {
		verifyElementDisplayed("List Link",homePage.getLnkList());
	}

	private void verifyMapLink() throws IOException {
		verifyElementDisplayed("Map Link",homePage.getLnkMap());

	}

	private void verifySortDrop() throws IOException {
		sortPage=new SortingPage();
		if(sortPage.getSortDrpDwn().isEnabled()&& sortPage.getSortDrpDwn().isDisplayed()) {
			capturePassStatus("Sort dropdown field is enabled and displayed");
		}else{
			captureFailStatus("Sort dropdown is not enabled or displayed");
		}}

	private void verifySearchField() throws IOException {
		if(homePage.getTxtSearchField().isEnabled()&& homePage.getTxtSearchField().isDisplayed()) {
			capturePassStatus("Search Text field is enabled and displayed");
		}else{
			captureFailStatus("Search Text field is not enabled or displayed");
		}}

	private void verifyCompLogo() throws IOException {
		WebElement img=homePage.getLogoCompany();
		verifyElementDisplayed("Company Logo", img);
	}

	private void verifyheadIn() throws IOException {
		homePage.getHeaderInn();
		if((homePage.getHeaderInn().contains("Incorporating data from"))&&(homePage.getHeaderInn().contains("Dow Jones"))&&(homePage.getHeaderInn().contains("Risk & Compliance")))
		{					
			capturePassStatus("Header inner text is present: "+homePage.getHeaderInn());
		}else {
			captureFailStatus("Header inner text is present: "+homePage.getHeaderInn());
		}		
	}

	private void verifyHeaders() throws InterruptedException, IOException {
		addInfoToReport("Expected header: PurpleTRAC, Actual Header: "+homePage.getHeaderText());
		if(homePage.getHeaderText().equals("PurpleTRAC")) {
			capturePassStatus("Verified Header information");
		}else {
			captureFailStatus("Header information mismatch");
		}
		if(homePage.getHeaderTm().equals("TM")) {
			capturePassStatus("Verified Header Trademark");
		}else {
			captureFailStatus("Header TradeMark mismatch");
		}				
	}

	private void verifyPrivacyPolicy() throws IOException, AWTException {

		WebElement PP=homePage.getLnkPrivacyPolicy();				
		click("Privacy policy link", PP);
		if(verifyElementDisplayed("Privacy Policy Dialog", homePage.getDlgPrivacyPolicy())) {
			robot =new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);		
		}}

	private void verifyVersion() throws IOException {
		WebElement vv=homePage.getLblAppVersion();
		if(verifyElementDisplayed("PurpleTRAC Version", vv)) {
			if(vv.getText().equals(prpt.getProperty("AppVersion"))){
				capturePassStatus("PurpleTRAC Version is verified: "+vv.getText());
			}else {
				captureFailStatus("PurpleTRAC Version mismatch: "+vv.getText());
			}}}

	private void VerifytermsOfUse() throws IOException, AWTException {

		WebElement tu=homePage.getLnkTermsOfUse();
		click("Terms of Use link", tu);
		if(verifyElementDisplayed("Terms of Use Dialog", homePage.getDlgTermsOfUse())) {
			robot=new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);			
		}}

	private void verifyFooter() throws IOException {
		WebElement vf=homePage.getTxtFooter();
		if(vf.getText().contains("Pole Star Space Applications")) {
			capturePassStatus("Footer message is present"+vf.getText());
		}else {
			captureFailStatus("Footer message is not present");
		}
	}

	void verifyAddShipLnk() throws IOException {
		WebElement AddShips=homePage.getLnkAddShip();
		verifyElementDisplayed("Add Ship link", AddShips);
	}

	public void verifyTabs() throws InterruptedException, IOException {
		homePage.getTabs();
		Iterator itr=(Iterator) homePage.getTabs().iterator();
		while(itr.hasNext()){
			WebElement a=(WebElement) itr.next();
			if((a.getText().contains("SCREEN"))){
				capturePassStatus("SCREEN tab is present");
			}else if((a.getText().contains("TRACK"))){
				capturePassStatus("TRACK tab is present");
			}else if((a.getText().contains("ARCHIVE"))){
				capturePassStatus("ARCHIVE tab is present");
			}else if((a.getText().contains("REPORTS"))){
				capturePassStatus("REPORTS tab is present");
			}else {
				capturePassStatus("One of the tab in homescreen is missing");
			}	

		}}}
