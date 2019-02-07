package webPages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Library.TestBase;

public class SortingPage extends TestBase {
	@FindBy(xpath=".//*[contains(@id,'ptdashtab')]//following::input[1]")
	WebElement SortOptionsDrpdwn;	

	@FindAll(value= {@FindBy(xpath=".//*[contains(@id,'boundlist')]/ul/li")})
	List<WebElement> sortOptions;	

	public SortingPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public void selectSortOption(String option) 
	{
		for(int i=0;i<sortOptions.size();i++) 
		{
			if(sortOptions.get(i).getText().trim().equalsIgnoreCase(option)) 
			{
				sortOptions.get(i).click();
				break;
			}
		}
	}

	public WebElement getSortOptionsDrpdwn() {
		return SortOptionsDrpdwn;
	}

	public List<WebElement> getSortOptions() {
		return sortOptions;
	}
}
