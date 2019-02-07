package webPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Library.TestBase;

public class MapViewPage extends TestBase {
	Robot robot;
	@FindBy(xpath=".//a[contains(.,'Sanction zones')]")
	WebElement lnkSanctionZones;	

	@FindBy(xpath=".//a[contains(.,'War zones')]")
	WebElement lnkWarZones;	

	@FindBy(xpath=".//a[contains(.,'Port')]")
	WebElement lnkPort;	

	@FindBy(xpath=".//a[contains(.,'AIS')]")
	WebElement lnkAIS;	

	@FindBy(xpath=".//a[contains(.,'MaRisk Alerts')]")
	WebElement lnkMaRiskAlerts;	

	@FindBy(xpath=".//a[contains(.,'Port')]//following::a[1]")
	WebElement lnkSearchShips;	

	@FindBy(xpath=".//a[contains(.,'List')]")
	WebElement lnkListView;	


	//@FindBy(xpath=".//*[@id='combobox-1331-inputEl']")
	@FindBy(xpath=".//a[contains(.,'Port')]//following::td[2]")
	WebElement txtSearchShips;	

	@FindBy(xpath=".//*[contains(@id,'boundlist') and contains(@id,'listEl')]")
	WebElement searchShipsRes;	

	public Robot getRobot() {
		return robot;
	}

	@FindBy(xpath="//*[contains(@class,'btn-register-mini')]//span[contains(.,'Add Ship')]")
	WebElement lnkAddShip;	

	public WebElement getLnkSanctionZones() {
		return lnkSanctionZones;
	}

	public WebElement getLnkWarZones() {
		return lnkWarZones;
	}

	public WebElement getLnkPort() {
		return lnkPort;
	}

	public WebElement getLnkAIS() {
		return lnkAIS;
	}

	public WebElement getLnkMaRiskAlerts() {
		return lnkMaRiskAlerts;
	}

	public WebElement getLnkSearchShips() {
		return lnkSearchShips;
	}

	public WebElement getLnkListView() {
		return lnkListView;
	}

	public WebElement getTxtSearchShips() {
		return txtSearchShips;
	}

	public WebElement getSearchShipsRes() {
		return searchShipsRes;
	}

	public WebElement getLnkAddShip() {
		return lnkAddShip;
	}

	public MapViewPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public void selectWarZonesChkbox(){
		if(getLnkWarZones().getAttribute("class").contains("empty")) {
			getLnkWarZones().click();}
	}

	public void selectPortChkbox(){
		if(getLnkPort().getAttribute("class").contains("empty")) {
			getLnkPort().click();}
	}

	public boolean isAISLnksChkboxSelected(){
		if(getLnkAIS().getAttribute("class").contains("empty")) 
		{
			return false;
		}else
			return true;
	}

	public boolean isPortLnksChkboxSelected(){
		if(getLnkPort().getAttribute("class").contains("empty")) 
		{
			return false;
		}else
			return true;
	}

	public boolean isWarZonesLnksChkboxSelected(){
		if(getLnkWarZones().getAttribute("class").contains("empty")) 
		{
			return false;
		}else
			return true;
	}

	public boolean isSanctionsLnksChkboxSelected(){
		if(getLnkSanctionZones().getAttribute("class").contains("empty")) 
		{
			return false;
		}else
			return true;
	}

	public boolean isMaRiskLnksChkboxSelected(){
		if(getLnkMaRiskAlerts().getAttribute("class").contains("empty")) 
		{
			return false;
		}else
			return true;
	}


	public void selectAISLnksChkbox(){
		if(getLnkAIS().getAttribute("class").contains("empty")) {
			getLnkAIS().click();}
	}

	public void selectMaRiskAlertsLnkChkbox(){
		if(getLnkMaRiskAlerts().getAttribute("class").contains("empty")) {
			getLnkMaRiskAlerts().click();}
	}

	public void selectSanctionZonesChkbox(){
		if(getLnkSanctionZones().getAttribute("class").contains("empty")) {
			getLnkSanctionZones().click();}
	}
	public void deselectWarZonesChkbox(){
		if(!getLnkWarZones().getAttribute("class").contains("empty")) {
			getLnkWarZones().click();}
	}

	public void deselectPortChkbox(){
		if(!getLnkPort().getAttribute("class").contains("empty")) {
			getLnkPort().click();}
	}

	public void deselectAISLnksChkbox(){
		if(!getLnkAIS().getAttribute("class").contains("empty")) {
			getLnkAIS().click();
		}
	}

	public void deselectMaRiskAlertsLnkChkbox(){
		if(!getLnkMaRiskAlerts().getAttribute("class").contains("empty")) {
			getLnkMaRiskAlerts().click();}
	}

	public void deselectSanctionZonesChkbox(){
		if(!getLnkSanctionZones().getAttribute("class").contains("empty")) {
			getLnkSanctionZones().click();}
	}

	public void addShipMapView(String ship) throws InterruptedException, AWTException {
		Actions actions = new Actions(driver);
		robot=new Robot();
		Thread.sleep(3000);
		getLnkSearchShips().click();
		wait(2);
		actions.moveToElement(txtSearchShips);	
		actions.click();
		actions.sendKeys(ship);
		actions.build().perform();
		Thread.sleep(6000);
		actions.moveToElement(searchShipsRes);
		actions.click();
		actions.build().perform();
		//searchShipsTxt.click();
		//searchShipsTxt.sendKeys(ship);
		//searchShipsRes.click();
		wait(2);
		actions.moveToElement(getLnkAddShip());
		actions.click();
		actions.build().perform();
		//addShipLink.click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public ScreenPage clkListViewLnk() throws IOException {
		click("List View Link", getLnkListView());
		return new ScreenPage();
	}
}
