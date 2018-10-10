package webPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.PTRAC_TestBase;


public class ScreenPage extends PTRAC_TestBase {
	String imo;

	@FindBy(id="SCREEN")
	WebElement screenTab;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[1]/div")})
	List<WebElement> flagIcon;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[8]/img")})
	List<WebElement> shipImage;	

	@FindBy(xpath="//*[@id='total-number-text']//span")
	WebElement noOfVesselsVal;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[1]/div")})
	List<WebElement> shipRowsName;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[1]/i")})
	List<WebElement> shipRowsIcon;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction-9651')]/div[2]/div[2]/div[1]/span")})
	List<WebElement> processTxt;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[9]/a[1]")})
	List<WebElement> viewFullShipDetailsLnk;	

	@FindBy(xpath=".//*[@class='x-tool-img x-tool-close']")
	WebElement closeFullShipDetailsDlg;	

	@FindBy(xpath=".//*[@class='x-tool-img x-tool-close']")
	WebElement viewMapViewShip;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[3]/div[2]/div[3]/a[1]")})
	List<WebElement> declineBtn;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[3]/div[2]/div[3]/a[2]")})
	List<WebElement> trackBtn;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[2]/div[2]/div/span")})
	List<WebElement> processStatusTxt;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[2]/div[2]/a/img")})
	List<WebElement> ViewMapLnk;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'OpenLayers_Layer_Vector_RootContainer') and contains(@id,'svgRoot')]")})
	List<WebElement> ViewMapShipInfo;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[3]")})
	List<WebElement> imoNumber;	

	@FindBy(xpath=".//a[contains(.,'Map')]")
	WebElement mapViewLnk;

	@FindBy(xpath=".//*[contains(@id,'textfield') and contains(@id,'inputEl')]")
	WebElement searchText;

	@FindAll(value= {@FindBy(xpath=".//span[contains(.,'Found Duplicate Transaction')]")})
	List<WebElement> dupTransactionDlg;

	public ScreenPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public void searchShips(String shipName) throws IOException, InterruptedException {
	enterValue("Ship details", searchText, shipName);
		Thread.sleep(5000);
	}

	public int getShipCount() {
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click();", screenTab);
		String shipCountString=screenTab.getAttribute("data-count");
		Integer shipCount=Integer.valueOf(shipCountString);
		return shipCount;
	}

	public int getVesselCount() {
		String vesselCountString=noOfVesselsVal.getAttribute("data-count");
		Integer vesselCount=Integer.valueOf(vesselCountString);
		return vesselCount;
	}

	public void scrollDown() throws InterruptedException {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
	}

	public int getShipRows() {
		return shipRowsIcon.size();
	}

	public void declineShip(String shipName) {
		for(int i=0;i<shipRowsName.size();i++) {
			if(shipRowsName.get(i).getText().trim().equals(shipName)) {
				declineBtn.get(i).click();
				break;
			}}}

	public TrackShipInfo clickTrackShip(String shipName) throws IOException {
		for(int i=0;i<shipRowsName.size();i++) {
			if(shipRowsName.get(i).getText().trim().equals(shipName)) {
				trackBtn.get(i).click();
				break;
			}}
		return new TrackShipInfo();
	}

	public TrackShipInfo clickTrackLatestShip() throws IOException {
		click("click first ship",trackBtn.get(0) );
		return new TrackShipInfo();
	}

	public String getIMONumber(String shipName) {
		for(int i=0;i<shipRowsName.size();i++) {
			if(shipRowsName.get(i).getText().trim().equals(shipName)) {
				imo=imoNumber.get(i).getAttribute("innerText").substring(5);
				break;
			}}
		return imo;
	}

	public String getLatestShipIMONumber() {
		imo=imoNumber.get(0).getAttribute("innerText").substring(5);
		return imo;
	}

	public void declineLatestShip() throws InterruptedException, IOException {
		Thread.sleep(1000);
		try {
			click("Decline first ship in the list", declineBtn.get(0));
		} catch (IOException e) {
			captureFailStatus("Ship decline not successfull");
		}
		Thread.sleep(2000);
	}

	public void selectLatestShip() throws IOException {
		if(shipRowsIcon.get(0).getAttribute("class").trim().contains("btn-open")) {
			//shipRowsIcon.get(0).click();
			click("Select latest Ship", shipRowsIcon.get(0));
		}}

	public void selectaShip(String shipName) throws IOException {
		for(int i=0;i<shipRowsName.size();i++) {
			if(shipRowsName.get(i).getText().trim().equals(shipName)) {
				if(shipRowsIcon.get(i).getAttribute("class").trim().contains("btn-open")) {
					click("clicked on ship name: "+shipName, shipRowsIcon.get(i));
				}
				break;
			}}}

	public void ClickLatestShipMap() throws IOException {
		try {
			click("First Ship in the list", ViewMapLnk.get(0));
		} catch (IOException e) {
			captureFailStatus("First Ship not selected");
		}
	}

	public String getLatestProcessStatus() {
		String processStatus=processStatusTxt.get(0).getText();
		return processStatus;
	}

	public int getMapViewFirstShipInfo() {
		return ViewMapShipInfo.size();
	}

	public void clkViewFullShipDetailsLnk(String shipName) throws IOException {
		for(int i=0;i<shipRowsName.size();i++) {
			if(shipRowsName.get(i).getText().trim().equals(shipName)) {
				click("View full Ship Details link", viewFullShipDetailsLnk.get(i));
				break;
			}}}

	public void clkViewLatestFullShipDetailsLnk() throws IOException {
		click("Latest added ship", viewFullShipDetailsLnk.get(0));
	}

	public void closeViewFullShipDetailsDlg() {
		closeFullShipDetailsDlg.click();
	}

	public MapViewPage ClkMapViewLnk() throws IOException {
		mapViewLnk.click();
		return new MapViewPage();
	}

	public WebElement getLatestShipFlag() {
		return flagIcon.get(0);
	}

	public WebElement getLatestShipImage() {
		return shipImage.get(0);
	}

	int i;
	public WebElement getShipFlag(String shipName) {
		for(int i=0;i<shipRowsName.size();i++) {
			if(shipRowsName.get(i).getText().trim().equals(shipName)) {
				break;
			}}
		return flagIcon.get(i);
	}

	public WebElement getShipImage(String shipName) {
		for(int i=0;i<shipRowsName.size();i++) {
			if(shipRowsName.get(i).getText().trim().equals(shipName)) {
				break;
			}}
		return shipImage.get(i);
	}

	public String getLatestShipName() {
		return shipRowsName.get(0).getAttribute("innerText");
	}

	public boolean isDuplicateTransaction() {
		int a=dupTransactionDlg.size();
		if (a>0) {
			return true;
		}else
			return false;

	}
}
