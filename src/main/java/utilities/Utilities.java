package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import Library.TestBase;

public class Utilities extends TestBase{
public Utilities() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
public static long pageLoadTimeOut=30;
public static long implicitWaitTime=30;
static Workbook book;
static Sheet sheet;
//private static ExtentReports reports;
//private static ExtentTest testInfo;
//private static ExtentHtmlReporter htmlReporter;
static String image;

public static Object[][] getDatafromExcel(String testDataPath, String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
FileInputStream file=null; 
file=new FileInputStream(testDataPath);
System.out.println(testDataPath);
book=WorkbookFactory.create(file);
sheet=book.getSheet(sheetName); //get sheet name

Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
for (int r=0;r<sheet.getLastRowNum();r++) {
for(int c=0; c<sheet.getRow(0).getLastCellNum();c++) {
data[r][c]=sheet.getRow(r+1).getCell(c).toString();
}}
return data;
}

public static String screenshot(WebDriver driver) throws IOException {
File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String screendir=System.getProperty("user.dir");
long s2=System.currentTimeMillis();
String image=screendir+"\\screenshots\\"+s2+".png";
FileUtils.copyFile(srcFile, new File(image));
return image;
}

//public  ExtentTest register1(Method method) {
//String methodName=method.getName();
//testInfo=reports.createTest(methodName);
//return testInfo;


}