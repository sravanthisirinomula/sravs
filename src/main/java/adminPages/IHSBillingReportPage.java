package adminPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.PTRAC_TestBase;

public class IHSBillingReportPage extends PTRAC_TestBase{

	public IHSBillingReportPage() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='content-main']/ul/li/a")
	WebElement btnAddAccLayer;	

	@FindBy(name="action")
	WebElement drpdwnAction;

	@FindBy(name="index")
	WebElement btnGo;

	@FindBy(name="_addanother")
	WebElement btnsSveAddAnother;

	@FindBy(name="_addanother")
	WebElement btnSaveContEdit;

	@FindBy(name="_addanother")
	WebElement btnSave;

	@FindBy(xpath=".//*[@id='accountlayer_form']/div/fieldset/div[1]/div/label")
	WebElement lblAccount;

	@FindBy(xpath=".//*[@id='accountlayer_form']/div/fieldset/div[2]/div/label")
	WebElement lblSubscriptionType;

	@FindBy(xpath=".//*[@id='accountlayer_form']/div/fieldset/div[3]/div/label")
	WebElement lblGSLayer;

	@FindBy(xpath=".//*[@id='id_subscription_type']")
	WebElement drpdwnSubscriptionType;

	@FindBy(xpath=".//*[@id='id_gs_layer']")
	WebElement drpdwnGSLayer;

	@FindBy(xpath=".//*[@id='id_account']")
	WebElement drpdwnAccount;
	
	@FindBy(xpath=".//*[@id='id_gs_layer']")
	WebElement lblSuccess;
	

	public WebElement getBtnAddAccLayer() {
		return btnAddAccLayer;
	}

	public WebElement getDrpdwnAction() {
		return drpdwnAction;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnsSveAddAnother() {
		return btnsSveAddAnother;
	}

	public WebElement getBtnSaveContEdit() {
		return btnSaveContEdit;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getLblAccount() {
		return lblAccount;
	}

	public WebElement getLblSubscriptionType() {
		return lblSubscriptionType;
	}

	public WebElement getLblGSLayer() {
		return lblGSLayer;
	}

	public WebElement getDrpdwnSubscriptionType() {
		return drpdwnSubscriptionType;
	}

	public WebElement getDrpdwnGSLayer() {
		return drpdwnGSLayer;
	}

	public WebElement getDrpdwnAccount() {
		return drpdwnAccount;
	}


}