package adminPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Library.TestBase;

public class UsersPage extends TestBase{

	public UsersPage() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='content-main']/ul/li/a")
	WebElement btnAddUser;	

	public WebElement getBtnAddUser() {
		return btnAddUser;
	}

	@FindBy(xpath=".//*[@id='id_username']")
	WebElement txtUserName;
	
	@FindBy(xpath=".//*[@id='id_first_name']")
	WebElement txtFirstName;
	
	@FindBy(xpath=".//*[@id='id_last_name']")
	WebElement txtLastName;
	
	@FindBy(xpath=".//*[@id='id_email']")
	WebElement txtEmail;
	
	@FindBy(xpath=".//*[@id='id_userprofile-0-account']")
	WebElement drpdwnAccount;
	
	@FindBy(xpath=".//*[@id='id_userprofile-0-role']")
	WebElement drpdwnRole;
	
	@FindBy(xpath=".//*[@id='user_form']/div/div[2]/input[1]")
	WebElement btnSave;

	@FindBy(xpath=".//*[@id='user_form']/div/div[2]/input[1]")
	WebElement lnkUsers;
	
	@FindBy(xpath="//a[contains(.,'Users')]")
	WebElement lnkNavUsers;

	public WebElement getLnkNavUsers() {
		return lnkNavUsers;
	}

	public void setLnkNavUsers(WebElement lnkNavUsers) {
		this.lnkNavUsers = lnkNavUsers;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getDrpdwnRole() {
		return drpdwnRole;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getDrpdwnAccount() {
		return drpdwnAccount;
	}


}