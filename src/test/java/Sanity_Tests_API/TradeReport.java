package Sanity_Tests_API;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Library.PTRAC_API_TestBase;
import Library.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;
import utilities.WebServices;

public class TradeReport extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	TradeReport() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "TradeReport");
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