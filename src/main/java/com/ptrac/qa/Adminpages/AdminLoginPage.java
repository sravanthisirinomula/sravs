package com.ptrac.qa.Adminpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ptrac.qa.baseclass.PTRAC_TestBase;

public class AdminLoginPage extends PTRAC_TestBase{

	public AdminLoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath=".//*[@id='id_username']")
WebElement userNameTxt;	

@FindBy(xpath=".//*[@id='id_password']")
WebElement passwordTxt;

@FindBy(xpath=".//*[@id='login-form']/div[3]/input")
WebElement loginBtn;

public AdminHomePage login(String userName, String password) throws IOException, InterruptedException {
//driver.findElement(By.xpath(".//*[@id='id_username']"))
userNameTxt.sendKeys(userName);
enterValue("User Name Text", userNameTxt, userName);
enterValue("Password Text", passwordTxt, password);
click("Admin Login button", loginBtn);
return new AdminHomePage();
}

public WebElement getUserNameTxt() {
	return userNameTxt;
}

public void setUserNameTxt(WebElement userNameTxt) {
	this.userNameTxt = userNameTxt;
}

public WebElement getPasswordTxt() {
	return passwordTxt;
}

public void setPasswordTxt(WebElement passwordTxt) {
	this.passwordTxt = passwordTxt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

public void setLoginBtn(WebElement loginBtn) {
	this.loginBtn = loginBtn;
}
}
