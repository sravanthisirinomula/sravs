package adminPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseClass.PTRAC_TestBase;

public class AccountsPage extends PTRAC_TestBase{

	public AccountsPage() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='content-main']/ul/li/a")
	WebElement lnkAddAcc;	

	@FindBy(xpath="//input[@value='Search']")
	WebElement btnSearch;	

	@FindBy(id="searchbar")
	WebElement txtSearch;	

	@FindBy(name="action")
	WebElement drpdwnAction; 

	@FindBy(xpath="//a[contains(.,'Company name')]")
	WebElement colCompanyName;

	@FindBy(xpath="//a[contains(.,'Billing code')]")
	WebElement colBillingCode;

	@FindBy(xpath="//a[contains(.,'Purplefinder username')]")
	WebElement colPurplefinderUsername;

	@FindBy(xpath="//a[contains(.,'Currency code')]")
	WebElement colCurrencyCode;

	@FindBy(xpath="//a[contains(.,'Status')]")
	WebElement colStatus;

	@FindBy(xpath=".//*[@id='id_company_name']")
	WebElement txtCompName; 

	@FindBy(xpath=".//*[@id='id_billing_code']")
	WebElement txtBillingCode; 

	@FindBy(xpath=".//*[@id='id_purplefinder_username']")
	WebElement txtPurpleFinderUserName; 

	@FindBy(xpath=".//*[@id='id_currency_code']")
	WebElement txtCurrencyCode; 

	@FindBy(xpath=".//*[@id='id_postal_address_line_1']")
	WebElement txtPostalAddress; 

	@FindBy(xpath=".//*[@id='id_telephone']")
	WebElement txtTelephone; 

	@FindBy(xpath=".//*[@id='id_credit_balance']")
	WebElement txtCreditBalance; 

	@FindBy(xpath=".//*[@id='id_status']")
	WebElement txtStatus; 

	@FindBy(xpath=".//*[@id='id_status']")
	WebElement statusTxt; 

	@FindBy(xpath=".//*[@id='id_postal_address_line_1']")
	WebElement postalAddressLine1Txt; 

	@FindBy(xpath=".//*[@id='id_telephone']")
	WebElement telephoneTxt; 

	@FindBy(xpath=".//*[@id='id_credit_balance']")
	WebElement creditBalTxt; 

	@FindBy(xpath=".//*[@id='id_company_check_default_severity']")
	WebElement compCheckDefServerityDrpDwn; 

	@FindBy(xpath=".//*[@id='account_form']/div/div/input[2]")
	WebElement btnSaveAddAnother; 

	@FindBy(xpath=".//*[@id='account_form']/div/div/input[3]")
	WebElement btnSaveContinueEdit; 

	@FindBy(xpath=".//*[@id='account_form']/div/div/input[1]")
	WebElement btnSave; 

	@FindBy(xpath=".//button[contains(.,'Go')]")
	WebElement goBtn; 
}
