package PTRAC_GenericTestScripts;

import commonMethods.CommonMethods;
import org.testng.annotations.Test;

import Library.TestBase;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.SettingsPage;
import webPages.SortingPage;

import java.awt.*;
import java.io.IOException;

public class Generic_Settings extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SortingPage sortPage;
	CommonMethods cm;
	Robot robot;
	SettingsPage settingsPage;

	@Test
	public void Generic_Settings() throws InterruptedException, IOException, AWTException {
		loginPage = new LoginPage();
		cm = new CommonMethods();
		robot = new Robot();
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		homePage = new HomePage();
		moveToElement("Profile Dropdown ", homePage.getDrpdwnProfile());
		click("Settings link", homePage.getLnkSettings());
		settingsPage = new SettingsPage();
		if (settingsPage.verifyElementDisplayed("Settings dialog", settingsPage.getDlgSettings())) {
			capturePassStatus("Settings dialog is displayed");
		} else {
			captureFailStatus("Settings dialog is not displayed");
		}
	}
}