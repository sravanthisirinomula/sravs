package PTRAC_GenericTestScripts;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.PTRAC_TestBase;
import commonMethods.CommonMethods;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.SortingPage;

public class Generic_VerifySystemStatus extends PTRAC_TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SortingPage sortPage;
	CommonMethods cm;
	Robot robot;

	@Test
	public void GenericVerifySystemStatus() throws InterruptedException, IOException, AWTException {
		loginPage=new LoginPage();
		cm=new CommonMethods();
		robot=new Robot();
		getBrowser();
		NavigateWebURL();
		cm.login(webUser, webPassword);
		wait(3);
		homePage=new HomePage();
		click("System Status Link", homePage.getLnkSystemStatus());
		homePage=new HomePage();
		wait(2);
		//for(int i=0;i<homePage.getLblSystemStatusComponent().size();i++) {
		System.out.println();
		if(homePage.getLblSystemStatusComponent().get(2).getText().contains("AIS - Secondary ship position source"))
		{
			capturePassStatus("expected system status component# AIS - Secondary ship position source"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(2).getText());
			if(homePage.getLblSystemStatus().get(0).isDisplayed()) {
				capturePassStatus("System status is OK for AIS - Secondary ship position source");
			}
			else 
			{
				captureFailStatus("System status is error for AIS - Secondary ship position source");
			}

		}
		else
		{
			captureFailStatus("expected system status component: AIS - Secondary ship position source"+" Actual System Status: "
					+homePage.getLblSystemStatusComponent().get(2).getText());
		}

		if(homePage.getLblSystemStatusComponent().get(4).getText().contains("Commservice - Primary ship position service"))
		{
			capturePassStatus("expected system status component# Commservice - Primary ship position service"+" Actual System Status: "
					+homePage.getLblSystemStatusComponent().get(4).getText());
			if(homePage.getLblSystemStatus().get(1).isDisplayed()) {
				capturePassStatus("System status is OK for Commservice - Primary ship position service");
			}
			else 
			{
				captureFailStatus("System status is error for Commservice - Primary ship position service");
			}
		}
		else
		{
			captureFailStatus("expected system status component# Commservice - Primary ship position service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(4).getText());
		}

		if(homePage.getLblSystemStatusComponent().get(6).getText().contains("Commservice API - Primary ship position subscription service"))
		{
			capturePassStatus("expected system status component# Commservice API - Primary ship position subscription service"
					+" Actual System Status# "+homePage.getLblSystemStatusComponent().get(6).getText());
			if(homePage.getLblSystemStatus().get(2).isDisplayed()) {
				capturePassStatus("System status is OK for Commservice API - Primary ship position subscription service");
			}
			else 
			{
				captureFailStatus("System status is error for Commservice API - Primary ship position subscription service");
			}
		}
		else
		{
			captureFailStatus("expected system status component# Commservice API - Primary ship position subscription service"
					+" Actual System Status# "+homePage.getLblSystemStatusComponent().get(6).getText());
		}

		if(homePage.getLblSystemStatusComponent().get(8).getText().contains("Dow Jones - Sanction & Compliance service"))
		{
			capturePassStatus("expected system status component# Dow Jones - Sanction & Compliance service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(8).getText());
			if(homePage.getLblSystemStatus().get(3).isDisplayed()) {
				capturePassStatus("System status is OK for Dow Jones - Sanction & Compliance service");
			}
			else 
			{
				captureFailStatus("System status is error for Dow Jones - Sanction & Compliance service");
			}
		}
		else
		{
			captureFailStatus("expected system status component# Dow Jones - Sanction & Compliance service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(8).getText());
		}

		if(homePage.getLblSystemStatusComponent().get(10).getText().contains("Geoserver - War and sanction zones service"))
		{
			capturePassStatus("expected system status component: Geoserver - War and sanction zones service"+" Actual System Status: "
					+homePage.getLblSystemStatusComponent().get(10).getText());
			if(homePage.getLblSystemStatus().get(4).isDisplayed()) {
				capturePassStatus("System status is OK for Geoserver - War and sanction zones service");
			}
			else 
			{
				captureFailStatus("System status is error for Geoserver - War and sanction zones service");
			}
		}
		else
		{
			captureFailStatus("expected system status component# Geoserver - War and sanction zones service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(10).getText());
		}

		if(homePage.getLblSystemStatusComponent().get(12).getText().contains("Purplefinder - Ship position service"))
		{
			capturePassStatus("expected system status component# Purplefinder - Ship position service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(12).getText());
			if(homePage.getLblSystemStatus().get(5).isDisplayed()) {
				capturePassStatus("System status is OK for Purplefinder - Ship position service");
			}
			else 
			{
				captureFailStatus("System status is error for Purplefinder - Ship position service");
			}
		}
		else
		{
			captureFailStatus("expected system status component# Purplefinder - Ship position service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(12).getText());
		}

		if(homePage.getLblSystemStatusComponent().get(14).getText().contains("IHS - Ship information service"))
		{
			capturePassStatus("expected system status component# IHS - Ship information service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(14).getText());
			if(homePage.getLblSystemStatus().get(6).isDisplayed()) {
				capturePassStatus("System status is OK for IHS - Ship information service");
			}
			else 
			{
				captureFailStatus("System status is error for IHS - Ship information service");
			}
		}
		else
		{
			captureFailStatus("expected system status component# IHS - Ship information service"+" Actual System Status# "
					+homePage.getLblSystemStatusComponent().get(14).getText());
		}
	}
}
