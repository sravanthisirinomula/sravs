package baseClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.response.Response;

public class PTRAC_API_TestBase {
	public static WebDriver driver;
	public static Properties prpt;
	public static File file;
	public static FileInputStream ipfile;
	public static ITestResult result;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static String baseURL;
	public static String limit;
	public static String testDataFile;
	public static Response response;
	public  static int  totalTestCases=0;
	public  static int  totalPassed=0;
	public  static int  totalFailed=0;
	public  static int  totalSkipped=0;
	public static LinkedHashMap<String, String> Testdata =	new LinkedHashMap<String, String>();
	public static ExecutorService Currentlogservice = Executors.newFixedThreadPool(1);
	public static ExecutorService ObjectsData = Executors.newFixedThreadPool(1);
	public static ExecutorService executorService = Executors.newFixedThreadPool(1);
	public static ConcurrentHashMap<String, Integer> testexecutions = new ConcurrentHashMap<String, Integer>();

	static {
		try {
			loadPropertiesFile();
			testDataFile=System.getProperty("user.dir")+"/testdata/apiTestData.xlsx";
		} catch (IOException e) {
			e.printStackTrace();
		}}

	@BeforeSuite
	public void reportSetup() {
		reports=new ExtentReports();
		htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/apiReports/"+prpt.getProperty("ReportName")));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/apiReportConfiguration.xml"));
		reports.setSystemInfo("Environment", "QA");
		reports.attachReporter(htmlReporter);
		htmlReporter.setAppendExisting(true);
	}

	@BeforeMethod
	public void register(ITestResult result, Method method) {
		String methodName=method.getName();
		test=reports.createTest(methodName);
		//test.log(Status.INFO,"Starting Test Name: "+getClass().getName()+" & Method Name: "+method.getName());
		test.log(Status.INFO,"Starting Test: "+method.getName());
	}

	@AfterMethod
	public void captureStatus(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,"The test name: "+result.getName()+" is passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"The test name: "+result.getName()+" is Failed");
		}
	}

	public static void addInfoToReport(String s) throws IOException {
		test.log(Status.INFO, s);	
	}

	@AfterSuite
	public void cleanUp() {
		reports.flush();
	}

	public static void loadPropertiesFile() throws IOException{
		prpt=new Properties();
		file=new File(System.getProperty("user.dir")+"/src/main/java/com/ptrac/qa/config/apiconfig.properties");
		ipfile=new FileInputStream(file);
		prpt.load(ipfile);
		limit=prpt.getProperty("limit");
		if(prpt.getProperty("environment").equalsIgnoreCase("demo")){
			baseURL=prpt.getProperty("demoBaseURL");
		}
		else if(prpt.getProperty("environment").equalsIgnoreCase("QA")){
			baseURL=prpt.getProperty("qaBaseURL");
		}}

	protected void getResponseCode(Response response) throws IOException {
		try {
			int statusCode=response.getStatusCode();
			String statusCodes=""+statusCode;
			addInfoToReport("Response Code is: "+statusCode);
			Assert.assertTrue(statusCodes.startsWith("20"));
		} catch (Exception e) {
			addInfoToReport("Response code not captured");
		}			
	}

	//@Test
	protected void getResponseTime(Response response) throws IOException {
		try {
			long resTime=response.getTime();
			String resTimes=""+resTime;
			addInfoToReport("Response Time is: "+resTimes+" milli seconds");
		} catch (Exception e) {
			addInfoToReport("Response Time is not captured");
		}
	}
	public static String  TestData(String strKey) {
		String testdata="";
		if (Testdata.containsKey(strKey)) {
			testdata=Testdata.get(strKey);
		}
		return testdata;
	}

	//Usage : to set Test Case Name
	public static void setTestCaseName(String name){
		Thread.currentThread().setName(name);
	}

	//Usage : to get Test Case Name
	public static String getTestCaseName(){
		return Thread.currentThread().getName();
	}

	public static void UpdateTestExecutionMatrix() throws IOException{
		try{
			FileInputStream inp = new FileInputStream(new File("").getAbsolutePath().toString() +  "\\runtime.properties");
			Properties props = new Properties();
			props.load(inp);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone utc = TimeZone.getTimeZone("UTC");
			format.setTimeZone(utc);

			totalTestCases = Integer.parseInt(props.getProperty("totaltestcases"));
			FileOutputStream out = new FileOutputStream(new File("").getAbsolutePath().toString() +  "\\runtime.properties");
			props.setProperty("totaltestcases",  String.valueOf(totalTestCases));
			props.setProperty("totalPassed",  String.valueOf(totalPassed));
			props.setProperty("endTime",format.format(new Date()).toString());
			props.store(out, null);
			out.close();
		}catch(Exception e){
			addInfoToReport("Unable to read no of test cases executing currently");
		}
	}

	//@Test
	protected void getResponse(Response response) throws IOException {
		try {
			String responser=response.asString();
			addInfoToReport("Response"+responser);
		} catch (Exception e) {
			addInfoToReport("Response is not captured");
		}
	}
}