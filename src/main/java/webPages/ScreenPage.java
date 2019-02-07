package webPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Library.TestBase;


public class ScreenPage extends TestBase {
	String imo;

	@FindBy(id="SCREEN")
	WebElement screenTab;	

	@FindAll(value= {@FindBy(xpath="//*[contains(@id, 'ptdashtab')]")})
	List<WebElement> lnkTabs;	

	public List<WebElement> getLnkTabs() {
		return lnkTabs;
	}

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[1]/div")})
	List<WebElement> iconFlag;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[8]/img")})
	List<WebElement> imgShip;	

	@FindBy(xpath="//*[@id='total-number-text']//span")
	WebElement txtNoOfVessels;	
	
	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[1]/div")})
	List<WebElement> txtShipRowsName;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[1]/i")})
	List<WebElement> iconShipRows;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction-9651')]/div[2]/div[2]/div[1]/span")})
	List<WebElement> txtProcess;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[9]/a[1]")})
	List<WebElement> lnkViewFullShipDetails;	

	@FindBy(xpath=".//*[@class='x-tool-img x-tool-close']")
	WebElement dlgCloseFullShipDetails;	

	@FindBy(xpath=".//*[@class='x-tool-img x-tool-close']")
	WebElement viewMapViewShip;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[3]/div[2]/div[3]/a[1]")})
	List<WebElement> btnDecline;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[9]/a[2]")})
	List<WebElement> lnkNotes;

	@FindBy(xpath="//*[contains(@id,'transaction')]/div[1]/div[2]/div[9]/a[2]//span")
	WebElement txtNotesCount;
	
	@FindBy(xpath="	.//*[contains(@id,'toolEl')]")
	WebElement btnClose;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[3]/div[2]/div[3]/a[2]")})
	List<WebElement> btnTrack;

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[2]/div[2]/div/span")})
	List<WebElement> txtProcessStatus;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[2]/div[2]/a/img")})
	List<WebElement> lnkViewMap;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'OpenLayers_Layer_Vector_RootContainer') and contains(@id,'svgRoot')]")})
	List<WebElement> txtViewMapShip;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'transaction')]/div[1]/div[2]/div[3]")})
	List<WebElement> txtImoNumber;	

	@FindBy(xpath=".//a[contains(.,'Map')]")
	WebElement lnkMapView;

	@FindBy(xpath=".//*[contains(@id,'textfield') and contains(@id,'inputEl')]")
	WebElement txtSearch;

	@FindAll(value= {@FindBy(xpath=".//span[contains(.,'Found Duplicate Transaction')]")})
	List<WebElement> dlgDupTransaction;

	@FindBy(xpath=".//span[contains(.,'Add note')]//following::a")
	WebElement lnkAddNote;

	@FindBy(xpath=".//textarea[@name='note']")
	WebElement txtNote;

	public WebElement getBtnClose() {
		return btnClose;
	}

	public WebElement getTxtNotesCount() {
		return txtNotesCount;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	@FindBy(xpath=".//textarea[@name='note']//following::span[1]")
	WebElement btnSave;
		
	public WebElement getTxtNote() {
		return txtNote;
	}

	public WebElement getLnkAddNote() {
		return lnkAddNote;
	}

	public String getImo() {
		return imo;
	}

	public WebElement getScreenTab() {
		return screenTab;
	}

	public List<WebElement> getIconFlag() {
		return iconFlag;
	}

	public List<WebElement> getImgShip() {
		return imgShip;
	}

	public WebElement getTxtNoOfVessels() {
		return txtNoOfVessels;
	}

	public List<WebElement> getTxtShipRowsName() {
		return txtShipRowsName;
	}

	public List<WebElement> getIconShipRows() {
		return iconShipRows;
	}

	public List<WebElement> getTxtProcess() {
		return txtProcess;
	}

	public List<WebElement> getLnkViewFullShipDetails() {
		return lnkViewFullShipDetails;
	}

	public WebElement getDlgCloseFullShipDetails() {
		return dlgCloseFullShipDetails;
	}

	public WebElement getViewMapViewShip() {
		return viewMapViewShip;
	}

	public List<WebElement> getBtnDecline() {
		return btnDecline;
	}

	public List<WebElement> getLnkNotes() {
		return lnkNotes;
	}

	public List<WebElement> getBtnTrack() {
		return btnTrack;
	}

	public List<WebElement> getTxtProcessStatus() {
		return txtProcessStatus;
	}

	public List<WebElement> getLnkViewMap() {
		return lnkViewMap;
	}

	public List<WebElement> getTxtViewMapShip() {
		return txtViewMapShip;
	}

	public List<WebElement> getTxtImoNumber() {
		return txtImoNumber;
	}

	public WebElement getLnkMapView() {
		return lnkMapView;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public List<WebElement> getDlgDupTransaction() {
		return dlgDupTransaction;
	}

	public int getI() {
		return i;
	}

	public ScreenPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public void searchShips(String shipName) throws IOException, InterruptedException {
		enterValue("Ship details", getTxtSearch(), shipName);
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
		String vesselCountString=getTxtNoOfVessels().getAttribute("data-count");
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
		return getIconShipRows().size();
	}

	public void declineShip(String shipName) {
		for(int i=0;i<getTxtShipRowsName().size();i++) {
			if(getTxtShipRowsName().get(i).getText().trim().equals(shipName)) {
				getBtnDecline().get(i).click();
				break;
			}}}

	public TrackShipInfo clickTrackShip(String shipName) throws IOException {
		for(int i=0;i<getTxtShipRowsName().size();i++) {
			if(getTxtShipRowsName().get(i).getText().trim().equals(shipName)) {
				getBtnTrack().get(i).click();
				break;
			}}
		return new TrackShipInfo();
	}

	public TrackShipInfo clickTrackLatestShip() throws IOException {
		click("click first ship Track button",getBtnTrack().get(0) );
		return new TrackShipInfo();
	}

	public String getIMONumber(String shipName) {
		for(int i=0;i<getTxtShipRowsName().size();i++) {
			if(getTxtShipRowsName().get(i).getText().trim().equals(shipName)) {
				imo=getTxtImoNumber().get(i).getAttribute("innerText").substring(5);
				break;
			}}
		return imo;
	}

	public String getLatestShipIMONumber() {
		imo=getTxtImoNumber().get(0).getAttribute("innerText").substring(5);
		return imo;
	}

	public void declineLatestShip() throws InterruptedException, IOException {
		Thread.sleep(1000);
		try {
			click("Decline first ship in the list", getBtnDecline().get(0));
		} catch (IOException e) {
			captureFailStatus("Ship decline not successfull");
		}
		Thread.sleep(2000);
	}

	public void selectLatestShip() throws IOException {
		if(getIconShipRows().get(0).getAttribute("class").trim().contains("btn-open")) {
			//shipRowsIcon.get(0).click();
			click("Select latest Ship", getIconShipRows().get(0));
		}}

	public void selectaShip(String shipName) throws IOException {
		for(int i=0;i<getTxtShipRowsName().size();i++) {
			if(getTxtShipRowsName().get(i).getText().trim().equals(shipName)) {
				if(getIconShipRows().get(i).getAttribute("class").trim().contains("btn-open")) {
					click("clicked on ship name: "+shipName, getIconShipRows().get(i));
				}
				break;
			}}}

	public void ClickLatestShipMap() throws IOException {
		try {
			click("First Ship in the list", getLnkViewMap().get(0));
		} catch (IOException e) {
			captureFailStatus("First Ship not selected");
		}
	}

	public String getLatestProcessStatus() {
		String processStatus=getTxtProcessStatus().get(0).getText();
		return processStatus;
	}

	public int getMapViewFirstShipInfo() {
		return getTxtViewMapShip().size();
	}

	public void clkViewFullShipDetailsLnk(String shipName) throws IOException {
		for(int i=0;i<getTxtShipRowsName().size();i++) {
			if(getTxtShipRowsName().get(i).getText().trim().equals(shipName)) {
				click("View full Ship Details link", getLnkViewFullShipDetails().get(i));
				break;
			}}}

	public void clkViewLatestFullShipDetailsLnk() throws IOException {
		click("Latest added ship", getLnkViewFullShipDetails().get(0));
	}

	public void closeViewFullShipDetailsDlg() throws IOException {
		try {
			click("Close Full Ship Details dialog", getDlgCloseFullShipDetails());
		} catch (IOException e) {
		captureFailStatus("Close Full Ship Details dialog is not closed");
		}
	}

	public MapViewPage ClkMapViewLnk() throws IOException {
		click("Map View Link",getLnkMapView());
		return new MapViewPage();
	}

	public WebElement getLatestShipFlag() {
		return getIconFlag().get(0);
	}

	public WebElement getLatestShipImage() {
		return getImgShip().get(0);
	}

	int i;
	public WebElement getShipFlag(String shipName) {
		for(int i=0;i<getTxtShipRowsName().size();i++) {
			if(getTxtShipRowsName().get(i).getText().trim().equals(shipName)) {
				break;
			}}
		return getIconFlag().get(i);
	}

	public WebElement getShipImage(String shipName) {
		for(int i=0;i<getTxtShipRowsName().size();i++) {
			if(getTxtShipRowsName().get(i).getText().trim().equals(shipName)) {
				break;
			}}
		return getImgShip().get(i);
	}

	public String getLatestShipName() {
		return getTxtShipRowsName().get(0).getAttribute("innerText");
	}

	public boolean isDuplicateTransaction() {
		int a=getDlgDupTransaction().size();
		if (a>0) {
			return true;
		}else
			return false;

	}
}
