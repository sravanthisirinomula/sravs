package com.ptrac.qa.webpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ptrac.qa.baseclass.PTRAC_TestBase;

public class LoginPage extends PTRAC_TestBase{

	@FindBy(name="username")
	WebElement txtUserName;	

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(xpath=".//*[@id='button-1012']")
	WebElement btnLogin;

	@FindBy(id="forgot-password-link")
	WebElement lnkForgotPwd;

	@FindBy(xpath=".//*[@id='terms-and-conditions']/a")
	WebElement lnkTermsConditions;
	
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getLnkForgotPwd() {
		return lnkForgotPwd;
	}

	public WebElement getLnkTermsConditions() {
		return lnkTermsConditions;
	}

	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public RequestPasswordChange clickForgotPwdLnk() {
		lnkForgotPwd.click();
		return new RequestPasswordChange();
	}
}
