package adminPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.PTRAC_TestBase;

public class ReadyToTrackShips extends PTRAC_TestBase{
public List<WebElement> list;
int i;

@FindBy(xpath=".//button[@id='approve-sel-btn']")
WebElement saveApproveBtn;	

@FindBy(xpath=".//button[@id='approve-all-btn']")
WebElement saveApproveAllBtn;	

@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'approved')]")})
List<WebElement> shipChkBox;

@FindAll(value= {@FindBy(xpath=".//*[@id='track-form']/table/tbody/tr/td[2]/a")})
List<WebElement> shipNamesLnk;

@FindAll(value= {@FindBy(xpath=".//*[@id='track-form']/table/tbody/tr/td[3]/a")})
List<WebElement> transactionLnk;

@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'communicator_make')]")})
List<WebElement> commMakeDrpDwn;

@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'communicator_model')]")})
List<WebElement> commModelDrpDwn;

@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'communicator_serial')]")})
List<WebElement> commSerialDrpDwn;

@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'shipborne_equipment_id')]")})
List<WebElement> shipborneEquipIdTxt;

@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'only-ais')]")})
List<WebElement> trackViaAIS;

public ReadyToTrackShips() throws IOException{
PageFactory.initElements(driver, this);
}

public void selectApproveShipViaAIS(String shipName) throws IOException, InterruptedException {
for(i=0;i<shipNamesLnk.size()-1;i++) {
if(shipNamesLnk.get(i).getText().trim().contains(shipName.toUpperCase())) {
System.out.println(shipNamesLnk.get(i).getText());
//System.out.println(shipChkBox.get(i).getAttribute("id"));
shipChkBox.get(i).click();
//System.out.println(shipNamesLnk.get(i).getText());
Thread.sleep(2000);
trackViaAIS.get(i).click();
Thread.sleep(2000);
addInfoToReport("Selected ship to approve: "+shipName);
addScreen("Ship selected", driver);
break;}}
}	

public void ClksaveApprovedBtn() throws InterruptedException {
saveApproveBtn.click();
Thread.sleep(2000);
}
}
