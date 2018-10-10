package Sanity_Tests_API;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptrac.qa.baseclass.PTRAC_API_TestBase;
import com.ptrac.qa.baseclass.PTRAC_TestBase;
import com.ptrac.qa.utilities.Utilities;
import com.ptrac.qa.utilities.WebServices;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TradeReport extends PTRAC_TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	TradeReport() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiSanTestDataFile, "TradeReport");
		String transactionId=(String) data[0][2];
		api=baseURL+"/reports/trade_report/?transaction_id="+transactionId+"&api_key="+apiKey+"&username="+apiUser;
		System.out.println(api);
		response=WebServices.Get(api);
		jsonPathEvaluator = response.jsonPath();
	}

	@Test
	void tradeReport() throws IOException {
		addInfoToReport("API: "+api);
		getResponseCode(response);
		getResponseTime(response);
	}	
}