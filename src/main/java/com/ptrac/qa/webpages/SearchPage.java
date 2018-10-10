package com.ptrac.qa.webpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ptrac.qa.baseclass.PTRAC_TestBase;
public class SearchPage extends PTRAC_TestBase{

@FindBy(xpath=".//input[contains(@id,'textfield') and contains(@id,'inputEl')]")
WebElement searchText;	
	
public void searchShips(String shipName) throws IOException, InterruptedException {
enterValue("Search Ship", searchText, shipName);
Thread.sleep(5000);
}	
}
