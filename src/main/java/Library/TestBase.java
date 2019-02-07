package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jfree.util.Log;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.response.Response;

public class TestBase {
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties prpt;
	public static String baseURL=null;
	public static File file;
	public static FileInputStream ipfile;
	public static ITestResult result;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public String image;
	public static String TrackingTestDataFile;
	public static String ScreeningTestDataFile;
	public static String apiTestDataFile;
	public static String apiRegTestDataFile;
	public static String AdminTestDataFile;
	static String driverPath = "";
	public static WebDriverWait wait;
	static int waitTIme = 10;
	public static String URL=null;
	public static int pageLoadTime=0;
	public static int implicitWaitTime=0;
	public static SimpleDateFormat format=null;
	public static String reportName=null;
	public static Calendar cal=null;
	public static Response response;
	public static String environment=null;
	public static String limit=null;
	public static String apiUser=null;
	public static String apiKey=null;
	public static String staffUser=null;
	public static String staffPassword=null;
	public static String webUser=null;
	public static String webPassword=null;

	/**********************************************************
	 * Function Name :- Static 
	 * Purpose of The Function :- To Load properties file, to configure results path 
	 * Input :- Results path, Add values in configuration.properties file 
	 * Output :- Reads configuration properties
	 **********************************************************/

	static {
		try {
			loadPropertiesFile();
			cal = Calendar.getInstance();
			format = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
			ScreeningTestDataFile = System.getProperty("user.dir") + "/TestData/ScreeningTestData.xlsx";
			TrackingTestDataFile = System.getProperty("user.dir") + "/TestData/TrackingTestData.xlsx";
			apiTestDataFile = System.getProperty("user.dir") + "/TestData/apiTestData.xlsx";
			apiRegTestDataFile = System.getProperty("user.dir") + "/TestData/apiRegTestData.xlsx";
			AdminTestDataFile = System.getProperty("user.dir") + "/TestData/AdminTestData.xlsx";
			initialiseBaseURL();
			initialiseUsers();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("POLESTAR GLOBAL");
		logger.info("PurpleTRAC Automation Testing");
	}

	/**********************************************************
	 * Function Name :- reportSetup() Purpose of The Function :- To Load properties file, to configure results path 
	 * Input :- Results path, Add values in
	 * configuration.properties file Output :- Reads configuration properties
	 **********************************************************/
	@BeforeSuite
	public void reportSetup() {
		environment=prpt.getProperty("environment");
		reports = new ExtentReports();
		SimpleDateFormat formatt = new SimpleDateFormat("dd_MMM_HH_mm");

		reportName=System.getProperty("user.dir") + "/Reports/" + prpt.getProperty("reportName")+"_"+formatt.format(cal.getTime())+".html";
		htmlReporter = new ExtentHtmlReporter(new File(reportName));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/ReportConfiguration.xml"));
		reports.setSystemInfo("Environment", environment);
		reports.attachReporter(htmlReporter);
		htmlReporter.setAppendExisting(true);
	}

	public void wait(int waitTime) throws InterruptedException {
		Thread.sleep(waitTime*1000);
	}

	@BeforeMethod
	public void register(ITestResult result, Method method) {
		String methodName = method.getName();
		test = reports.createTest(methodName);
		test.log(Status.INFO, "Starting Test Name: " + method.getName());
		logger.info("Starting Test Name: " + method.getName());
	}

	@AfterMethod
	public void captureStatus(ITestResult result) throws IOException, InterruptedException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			// String screen=getScreenshot("Pass");
			// test.log(Status.PASS,"The test method named as: "+result.getName()+"("+
			// getClass().getName()+") is passed" );
			wait(1);
			/*test.log(Status.PASS,
					"The test method named as: " + result.getName() + "(" + getClass().getName() + ") is passed",
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Pass")).build());
			 */
			//test.log(Status.PASS,
			//	"The test method named as: '" + result.getName() + "' is passed");
			//logger.info("The test method named as: '" + result.getName() + "' is passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			// String screen=getScreenshot("Fail");
			// test.log(Status.FAIL, "The test method named as: "+result.getName()+"("+
			// getClass().getName()+") is failed");
			// addScreen(driver);
			// String base64Screenshot1 =
			// "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			// test.addScreenCaptureFromPath(base64Screenshot1);

			if(driver!=null) {
				test.log(Status.FAIL,
						"The test method named as: '" + result.getName() + "' is Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Fail")).build());
				logger.info("The test method named as: '" + result.getName() + "' is Failed");
			}else {
				test.log(Status.FAIL,
						"The test method named as: '" + result.getName() + "' is Failed");
				logger.info("The test method named as: '" + result.getName() + "' is Failed");
			}} else 
				if (result.getStatus() == ITestResult.STARTED) {
					test.log(Status.INFO, "The test name: '" + result.getName() + "' started");
					logger.info("The test name: '" + result.getName() + "' started");
				}

				else if (result.getStatus() == ITestResult.SKIP) {
					test.log(Status.SKIP, "The test name: " + result.getName() + " is skipped");
					logger.info("The test name: " + result.getName() + " is skipped");
				}
	}

	public static void captureFailStatus(String message) throws IOException {
		test.log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Fail")).build());
		logger.error(message);
	}

	public static void captureApiFailStatus(String message) throws IOException {
		test.log(Status.FAIL, message);
		logger.error(message);
	}

	public void capturePassStatus(String message) throws IOException {
		test.log(Status.PASS, message);
		logger.info(message);
	}

	public static void addInfoToReport(String s) throws IOException {
		logger.info(s);
		test.log(Status.INFO, s);
	}

	public void addScreen(String s, WebDriver driver) throws IOException {
		//String base64Screenshot1 = "data:image/png;base64,"
		//	+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		// test.addScreenCaptureFromPath(base64Screenshot1);
		test.info(s, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("info")).build());
	}

	@AfterSuite
	public void cleanUp() {
		reports.flush();
	}

	//@AfterClass
	public void closeBrowser() {
		closeDriver();
		test.log(Status.INFO, "Browser Closed");
		logger.info("Browser Closed");
	}

	@BeforeClass
	public synchronized void launchBrowser() throws IOException {
		//getBrowser();
	}

	// Method to read properties file
	public static void loadPropertiesFile() throws IOException {
		try {
			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			prpt = new Properties();
			file = new File(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			ipfile = new FileInputStream(file);
			prpt.load(ipfile);
			pageLoadTime=Integer.parseInt(prpt.getProperty("pageLoadTime"));
			implicitWaitTime=Integer.parseInt(prpt.getProperty("implicitWaitTime"));
		} catch (NumberFormatException e) {
			logger.error("properties loading not successful",e);
		}		
	}

	public void printToNotepad(String api,Response response, String file, int recordNum) {
		PrintWriter out = null;
		try {
			DateTime date=new DateTime();
			//out = new PrintWriter(new FileWriter("C:\\test\\response.txt", true));
			out = new PrintWriter(new FileWriter(System.getProperty("user.dir")+"/Response/"+file+date.getDayOfYear()+".txt", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.append(	"record No: "+recordNum++);
		out.append('\n');
		out.append("Request: "+api);
		out.append('\n');
		out.append("Response:");
		out.append('\n');
		out.append(response.prettyPrint());
		out.append('\n');
		out.append("**************************************************");
		out.append('\n');
		out.close();
	}

	public void printToNotepad(String file, String tim) {
		PrintWriter out = null;
		try {
			DateTime date=new DateTime();
			//out = new PrintWriter(new FileWriter("C:\\test\\response.txt", true));
			out = new PrintWriter(new FileWriter(System.getProperty("user.dir")+"/Response/"+file+date.getDayOfYear()+".txt", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.append(tim);
		out.append('\n');
		out.close();
	}

	public static void initialiseBaseURL(){
		if(prpt.getProperty("environment").equalsIgnoreCase("demo")){
			baseURL=prpt.getProperty("demoBaseURL");
		}
		else if(prpt.getProperty("environment").equalsIgnoreCase("test")){
			baseURL=prpt.getProperty("testBaseURL");
		}
		else if(prpt.getProperty("environment").equalsIgnoreCase("stage")){
			baseURL=prpt.getProperty("stageBaseURL");
		}
		else if(prpt.getProperty("environment").equalsIgnoreCase("prod")){
			baseURL=prpt.getProperty("prodBaseURL");
		}}

	public static void initialiseUsers() {
		apiUser=prpt.getProperty("apiUser");
		apiKey=prpt.getProperty("apiKey");
		staffUser=prpt.getProperty("staffUser");
		staffPassword=prpt.getProperty("staffPassword");
		webUser=prpt.getProperty("webUser");
		webPassword=prpt.getProperty("webPassword");
		limit=prpt.getProperty("limit");
	}

	protected void getResponseCode(Response response) throws IOException {
		try {
			int statusCode=response.getStatusCode();
			String statusCodes=""+statusCode;
			System.out.println(statusCodes);
			addInfoToReport("Response Code is: "+statusCode);
			Assert.assertTrue(statusCodes.startsWith("20"));
			if(statusCodes.startsWith("20")) {
				capturePassStatus("Response is received");
			}
			else if (statusCodes.startsWith("4")) {
				captureApiFailStatus("Client side error");
			}
			else if(statusCodes.startsWith("5")) {
				captureApiFailStatus("Server side error");
			}
		} catch (Exception e) {
			captureApiFailStatus("Response not captured");
		}			
	}

	protected void getResponseTime(Response response) throws IOException {
		try {
			long resTime=response.getTime();
			String resTimes=""+resTime;
			addInfoToReport("Response Time is: "+resTimes+" milli seconds");
		} catch (Exception e) {
			captureApiFailStatus("Response not captured");
		}
	}

	protected void getResponse(Response response) throws IOException {
		try {
			String responser=response.asString();
			addInfoToReport("Response"+responser);
			System.out.println(responser);
		} catch (Exception e) {
			captureApiFailStatus("Response not captured");
		}
	}

	// Method to get Browser
	public void getBrowser() throws IOException {
		String browser = prpt.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome Browser started");
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/lib/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("firefox Browser started");
		}

		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/lib/ie.exe");
			driver = new InternetExplorerDriver();
			logger.info("IE Browser started");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
	}

	public void NavigateWebURL() throws IOException {		
		try {
			NavigateToURL(baseURL);
			capturePassStatus("PurpleTRAC Application launched with URL: "+baseURL);
		} catch (Exception e) {
			captureFailStatus("PurpleTRAC Application is not launched with URL: "+baseURL);
		}

	}

	public void navigateDjangoAdminURL() throws IOException {
		try {
			URL=baseURL+"/admin";
			NavigateToURL(URL);
			capturePassStatus("Django Admin Application launched with URL: "+URL);
		} catch (Exception e) {
			captureFailStatus("Django Admin Application is not launched with URL: "+URL);
		}
	}

	public static String getScreenshot(String screenshotName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screendir = System.getProperty("user.dir") + "/screenshots/";
		SimpleDateFormat formatt = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		String image = screendir + screenshotName + "_" + formatt.format(cal.getTime()) + ".png";
		FileUtils.copyFile(srcFile, new File(image));
		return image;
	}


	public void closeDriver(){
		//	driver.quit();
	}

	public boolean verifyElementDisplayed(String objNameStr, WebElement objName) throws IOException {

		try {
			objName.isDisplayed();
			capturePassStatus(objNameStr + " is displayed");
			return true;
		} catch (Exception e) {
			captureFailStatus(objNameStr + " is not displayed");
			return false;
		}

	}

	public void click(String objNameStr, WebElement objName) throws IOException {
		try {
			//isClickable(objName, 10);
			objName.click();
			capturePassStatus(objNameStr + " is clicked");

		} catch (Exception e) {
			clickJavaScript(objNameStr, objName);
		}
	}

	public void clickJavaScript(String objNameStr, WebElement objName) throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			executor.executeScript("arguments[0].click();", objName);
			capturePassStatus("JS: Clicked on " + objNameStr);

		} catch (Exception ex) {
			scrollintoview(objName);
			executor.executeScript("arguments[0].click();", objName);
			captureFailStatus("Unable to click on " + objNameStr);
		}
	}

	public void scrollintoview(WebElement e) throws IOException {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", e);
		} catch (Exception ex) {
			addInfoToReport("Failed in Scroll to View: " + e.toString());
		}
	}

	public void enterValue(String objNameStr, WebElement objName, String valueToEnter) throws IOException{
		try {
			(new WebDriverWait(driver,4)).until(ExpectedConditions.elementToBeClickable(objName));
			objName.clear();
			objName.sendKeys(valueToEnter);
			capturePassStatus("Entering value '" + valueToEnter + "' in '" + objNameStr + " is successfull");

		} catch (Exception e) {
			captureFailStatus("Entering value '" + valueToEnter + "' in '" + objNameStr + " Failed" + e);
			enterValueByJavaScript(objNameStr, objName, valueToEnter);
		}
	}

	// To Check application object is available for until certain seconds 
	public static boolean isAvailable(WebElement selector,int timeinseconds) throws InterruptedException{
		Boolean blnavailable=false;
		try{
			(new WebDriverWait(driver,timeinseconds)).until(ExpectedConditions.visibilityOf(selector));
			blnavailable =true;
			logger.info("Element available: "+selector);
		}catch(Exception e){
			blnavailable = false;
			logger.error("Element not available: "+selector);
		}
		return blnavailable;  	    
	}


	//Wait for Element
	public static void waitforElement(WebElement selector,int timeinseconds) throws InterruptedException, IOException{
		try{
			(new WebDriverWait(driver,timeinseconds)).until(ExpectedConditions.visibilityOf(selector));
		}catch(Exception e){
			captureFailStatus("waitforElement Failed." + e);			
		}
	}

	public static void isClickable(WebElement selector,int timeinseconds) throws InterruptedException, IOException{
		try{
			(new WebDriverWait(driver,timeinseconds)).until(ExpectedConditions.elementToBeClickable(selector));
			logger.info("Element clickable "+selector);
		}catch(Exception e){
			captureFailStatus("Element not clickable " + selector);
		}
	}

	public void enterValueByJavaScript(String objNameStr, WebElement objName, String valueToEnter) throws IOException{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			executor.executeScript("arguments[0].value='" + valueToEnter + "';", objName);
			capturePassStatus("Entering value '" + valueToEnter + "' in '" + objNameStr + " is successfull");	
		} catch (Exception ex) {
			scrollintoview(objName);
			executor.executeScript("arguments[0].value='" + valueToEnter + "';", objName);
			captureFailStatus("Entering value '" + valueToEnter + "' in '" + objNameStr + " is successfull");	
		}
	}

	public void selectFormDropDownList(String objNameStr, WebElement objName, String valueToSelect) throws IOException{
		try{
			Thread.sleep(2000);
			Select dropDown = new Select(objName);
			String selected = dropDown.getFirstSelectedOption().getText();
			if(!selected.equalsIgnoreCase(valueToSelect)) {//do stuff already selected}
				List<WebElement> Options = dropDown.getOptions();
				for(WebElement option:Options){
					if(option.getText().equalsIgnoreCase(valueToSelect)){
						System.out.println("Option Selected -> " + option.getText());
						option.click();
						break;
					}
				}
			}

			capturePassStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' is successful");

		}catch (Exception e){
			captureFailStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' Failed" + e);
		}
	}

	public void selectFormDropDownListByIndex(String objNameStr, WebElement objName, int valueToSelect) throws IOException{
		try{			
			Select dropDown = new Select(objName);
			//dropDown.deselectAll();
			dropDown.selectByIndex(valueToSelect);
			capturePassStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' is successful");
		}catch (Exception e){
			captureFailStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' Failed" + e);

		}
	}

	public void selectFormDropDownListByValue(String objNameStr, WebElement objName, String valueToSelect) throws IOException{
		try{			
			Select dropDown = new Select(objName);
			//dropDown.deselectAll();
			dropDown.selectByValue(valueToSelect);
			capturePassStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' is successful");
		}catch (Exception e){
			captureFailStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' Failed" + e);

		}
	}

	public void selectFormDropDownListByVisibleText(String objNameStr, WebElement objName, String valueToSelect) throws IOException{
		try{			
			Select dropDown = new Select(objName);
			//dropDown.deselectAll();
			dropDown.selectByVisibleText(valueToSelect);
			capturePassStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' is successful");
		}catch (Exception e){
			captureFailStatus("Selecting Value '" + valueToSelect + "' from dropdown list '" + objNameStr + "' Failed" + e);

		}
	}

	public void setCheckBox(String objNameStr, WebElement objName, String option) throws IOException{
		try{
			if(option.equalsIgnoreCase("ON")){
				if(!objName.isSelected()){
					objName.click();
				}
			}else{
				if(objName.isSelected()){
					objName.click();
				}
			}
			capturePassStatus("Setting Value '" + option + "' in checkbox '" + objNameStr + "' is successful");			
		}catch(Exception e){
			captureFailStatus("Setting Value '" + option + "' in checkbox '" + objNameStr + "' Failed" + e);
		}
	}

	public void switchWindow(String windowOption){
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		System.out.println("Parent URL -> " + driver.getCurrentUrl());
		for(String windowHandle  : handles){
			if(windowOption.equalsIgnoreCase("Child")){
				if(!windowHandle.equals(parentWindow)){
					driver.switchTo().window(windowHandle);
					System.out.println("Child URL -> " + driver.getCurrentUrl());
					break;
				}
			}else if(windowOption.equalsIgnoreCase("Parent")){
				driver.switchTo().window(parentWindow); //cntrl to parent window
			}
		}
	}


	public void moveToElement(String objNameStr, WebElement objName) throws IOException{

		try{
			Actions oAction = new Actions(driver);
			oAction.moveToElement(objName).build().perform();
			capturePassStatus("Moved to element: " +objNameStr);

		}catch(Exception e){
			captureFailStatus("Move to element failed"+e);
		}

	}

	public void rightClickAndSelectOption(String objNameStr, WebElement objName, String optionToClick) throws IOException{

		try{
			Actions oAction = new Actions(driver);
			oAction.moveToElement(objName);
			oAction.contextClick(objName).build().perform();
			WebElement element = driver.findElement(By.linkText(optionToClick));		
			Thread.sleep(2000);
			click(optionToClick, element);

		}catch(Exception e){
			captureFailStatus("Function Right ClickAndSelectOption failed"+e);
		}

	}

	public String getURL(){
		return driver.getCurrentUrl();
	}

	public void refreshBroswer(WebDriver driver) {
		try{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}catch(Exception e){
			System.out.println("Refresh Failed -> " + e);
		}
	}

	public String getPageName(String URL){
		String str = URL.trim();
		String[] str1 = str.split("/");
		return str1[(str1.length-1)];
	}

	public void NavigateToURL(String URL) throws IOException{
		try{
			driver.navigate().to(URL.trim());
			capturePassStatus("Navigated to URL: " + URL );
		}catch(Exception e){
			captureFailStatus("Navigate to URL: " + URL + "' Failed" + e);
		}
	}

	public void CompareStrings(String loginfo,String Expected, String Actual) throws IOException{
		try{
			if (Expected.equalsIgnoreCase(Actual)) {
				capturePassStatus(loginfo + ":" + "Expected :" + Expected +" Actual:  "+Actual+" "+"Expected and Actual tests are same");
			}else{
				captureFailStatus(loginfo + ":" + "Expected :" + Expected +" Actual:  "+Actual+" "+"Expected and Actual tests are not same");
			}
		}catch(Exception e){
			captureFailStatus("String Comparision:" +loginfo +" Failed" + e);

			logger.error("String Comparision:" +loginfo +" Failed" + e);
		}
	}

	public void verifyTextOfElement(String objNameStr, WebElement objName, String textToVerify) throws IOException{
		try{
			String expectedText = textToVerify.trim();
			String actualText = objName.getText().replaceAll("\\r\\n|\\r|\\n", " ");
			System.out.println(actualText);
			if (textToVerify.equalsIgnoreCase(objNameStr)) {
				capturePassStatus("Text Verification for " + objNameStr + " is successful");
			}else{
				captureFailStatus("Expected Text : " + expectedText + " Actual:"+ actualText);
			}
		}catch(Exception e){
			captureFailStatus("Verify Text of Element" + objNameStr + "' Failed" + e);
		}
	}
	protected void getResponseCode() throws IOException {
		int statusCode=response.getStatusCode();
		String statusCodes=""+statusCode;
		if(statusCodes.startsWith("20")) {
			capturePassStatus("Response Code is: "+statusCode);
		}else {
			captureFailStatus("Response Code is: "+statusCode);
		}

	}

	protected void getResponseTime() throws IOException {
		long resTime=response.getTime();
		String resTimes=""+resTime;
		addInfoToReport("Response Time is: "+resTimes+" milli seconds");
	}

	//@Test
	protected void getResponse() throws IOException {
		String responser=response.asString();
		addInfoToReport("Response"+responser);
	}
	protected boolean isSortAsc(List<String> list1) {
		String prev = null;
		for( String elem : list1 ) {
			if( prev != null && prev.compareTo(elem) > 0 ) {
				return false;
			}
			prev = elem;
		}
		return true;
	}
	public static <T extends Comparable> boolean isSorted(List<T> listOfT) {
		T previous = null;
		for (T t: listOfT) {
			if (previous != null && t.compareTo(previous) < 0) return false;
			previous = t;
		}
		return true;
	}

	protected boolean isSortDes(List<String> list1) {
		String prev = null;
		for( String elem : list1 ) {
			if( prev != null && prev.compareTo(elem) < 0 ) {
				return false;
			}
			prev = elem;
		}
		return true;
	}
}

/*
 * @BeforeMethod() public void beforeMethod(ITestResult result) throws
 * IOException{ test=extent.startTest(result.getName());
 * test.log(LogStatus.INFO, result.getName() + " test Started"); }
 * 
 * @AfterMethod public void getResult(ITestResult result) throws IOException{
 * if(result.getStatus()==ITestResult.SUCCESS) { String
 * screen=getScreenshot("Pass"); test.log(LogStatus.PASS,
 * "The test method named as: "+result.getName()+" is passed");
 * test.log(LogStatus.PASS, test.addScreenCapture(screen)); } else
 * if(result.getStatus()==ITestResult.FAILURE) { String
 * screen=getScreenshot("Fail"); test.log(LogStatus.FAIL,
 * "The test method named as: "+result.getName()+" is Failed"+result.
 * getThrowable()); test.log(LogStatus.FAIL, test.addScreenCapture(screen)); }
 * else if(result.getStatus()==ITestResult.STARTED) { test.log(LogStatus.INFO,
 * "The test method named as: "+result.getName()+" is started");
 * 
 * } else if (result.getStatus()==ITestResult.SKIP) { test.log(LogStatus.SKIP,
 * "The test method named as: "+result.getName()+" is skipped"); } }
 * 
 * 
 * //public void afterMethod(ITestResult result) throws IOException{
 * //getResult(result); //}
 * 
 * //@BeforeMethod() public void beforeMethod() throws IOException{
 * System.out.println(); }
 * 
 * @AfterClass public void endTest() { extent.flush(); driver.quit(); } //@Test
 * public void test1() throws IOException { PTRACBase p1=new PTRACBase();
 * p1.loadPropertiesFile(); System.out.println(p1.prpt.getProperty("URL"));
 * System.out.println(p1.prpt.getProperty("URL2")); p1.getBrowser();
 * p1.getScreenshot("my"); }
 */
