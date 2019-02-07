package webPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Library.TestBase;
public class SearchPage extends TestBase{

@FindBy(xpath=".//input[contains(@id,'textfield') and contains(@id,'inputEl')]")
WebElement searchText;	
	
public void searchShips(String shipName) throws IOException, InterruptedException {
enterValue("Search Ship", searchText, shipName);
Thread.sleep(5000);
}	
}
