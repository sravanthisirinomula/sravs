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

public class SearchShipsByShipName extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	SearchShipsByShipName() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "ShipName");
		String ship_name=(String) data[0][2];
		api=baseURL+"/api/v1/sisship?"+"ship_name__istartswith=="+ship_name+"&api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		System.out.println(api);
		response=WebServices.Get(api);
		jsonPathEvaluator = response.jsonPath();
	}

	@Test
	void SearchShipsByShipName() throws IOException {
		addInfoToReport("API: "+api);
		getResponseCode(response);
		getResponseTime(response);
		getShipIDs();
		getResponse(response);
	}

	void getShipIDs() throws IOException {
		String totalCount=""+jsonPathEvaluator.get("meta.total_count");
		addInfoToReport("Total Ship count: "+totalCount);
	}	
}