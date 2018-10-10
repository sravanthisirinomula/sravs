package com.ptrac.qa.webpages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptrac.qa.baseclass.PTRAC_TestBase;

public class AddShipsPage extends PTRAC_TestBase {

	public AddShipsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='registered_name']")
	WebElement txtShipNameIMO;	

	//@FindBy(xpath="//*[contains(@id,'boundlist')]//li[1]")
	@FindBy(xpath="//*[contains(@id,'boundlist')]/ul/li[1]/div/div[1]/div[1]")
	WebElement lstFirstSearchItem;	

	@FindBy(xpath="//input[@name='registered_name']//following::a[1]")
	WebElement btnNextShip;

	@FindBy(xpath="//input[@name='registered_name']//following::a[2]")
	WebElement btnRegister;

	@FindBy(xpath=".//*[@id='ext-comp-1434_header']")
	WebElement dlgPreReg;

	@FindBy(xpath=".//*[contains(@id,'button') and contains(@id,'btnIconEl')]")
	WebElement btnOK;

	@FindBy(xpath="//*[@class='x-header-text x-window-header-text']")
	WebElement dlgAddShip;
	
	@FindBy(xpath="//*[@class='x-header-text x-window-header-text']//following::img")
	WebElement dlgCloseAddShip;
	
	public WebElement getDlgCloseAddShip() {
		return dlgCloseAddShip;
	}

	public WebElement getLblShipName() {
		return lblShipName;
	}

	@FindBy(xpath="//*[@id='register-button-btnIconEl']//preceding::label[1]")
	WebElement lblShipName;

	public WebElement getDlgAddShip() {
		return dlgAddShip;
	}

	public WebElement getTxtShipNameIMO() {
		return txtShipNameIMO;
	}

	public WebElement getLstFirstSearchItem() {
		return lstFirstSearchItem;
	}

	public WebElement getBtnNextShip() {
		return btnNextShip;
	}

	public WebElement getBtnRegister() {
		return btnRegister;
	}

	public WebElement getDlgPreReg() {
		return dlgPreReg;
	}

	public WebElement getBtnOK() {
		return btnOK;
	}

	public void clickNxtShipBtn() throws IOException {
		click("Next ship Button",btnNextShip );
	}	

	public void clickRegBtn() throws IOException, InterruptedException {
		click("Registration Button", btnRegister);
		wait(2);
	}

	public void closeAddShipDialog() throws IOException, AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		//click("Close Add ship dialog",getDlgAddShip());
	}	

	
	public void enterShipNameIMO(String ship) throws InterruptedException, IOException {
		enterValue("Ship IMO Number",txtShipNameIMO , ship);
		Thread.sleep(2000);
	}
	public void enterShipNameIMO(String ship, int i) throws InterruptedException, IOException {
		String xpath1="//input[@name='registered_name']//following::input["+i+"]";
		WebElement ShipNameIMOTxt1=driver.findElement(By.xpath(xpath1));
		enterValue("Ship IMO Number",ShipNameIMOTxt1 , ship);
		System.out.println("xpath: "+xpath1+" "+ShipNameIMOTxt1);
		//	selectFirstShip();
	}

	private WebElement FindElement(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectFirstShip() throws InterruptedException, IOException {
		try {
			wait(5);
			Actions action=new Actions(driver);
			action.moveToElement(lstFirstSearchItem).click().perform();
			click("Search Item", lstFirstSearchItem);
		} catch (IOException e) {
		}
	}

	public void EnterShipNameIMO(int i, String ship) throws InterruptedException {
		Thread.sleep(3000);
		//String txtfield="html/body/div[8]/div[2]/span/div/div/div[1]/span/div/table["+i+"]/tbody/tr/td[2]/table/tbody/tr/td[1]/input";
		String txtfield="html/body/div[8]/div[2]/span/div/div/div[1]/span/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/input";
		WebElement a=driver.findElement(By.xpath(txtfield));
		Thread.sleep(1000);
		a.sendKeys(ship);
		Thread.sleep(1000);
	}

	public void clkOKBtn() throws IOException {
		click("Ok button",btnOK );
	}
}
