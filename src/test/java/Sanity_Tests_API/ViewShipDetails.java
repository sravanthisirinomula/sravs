package Sanity_Tests_API;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.ptrac.qa.utilities.Utilities;
import com.ptrac.qa.utilities.WebServices;

import baseClass.PTRAC_API_TestBase;
import baseClass.PTRAC_TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ViewShipDetails extends PTRAC_TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	ViewShipDetails() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiSanTestDataFile, "ShipDetails");
		String imo_name=(String) data[0][2];
		api=baseURL+"/api/v1/shipdetails?imo_number="+imo_name+"&api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		System.out.println(api);
		response=WebServices.Get(api);
	}

	@Test
	void viewShipDetails() throws IOException {
		addInfoToReport("API: "+api);
		getResponseCode(response);
		getResponseTime(response);
		getShipIDs();
		getResponse(response);
	}
	//String total_count = jsonPathEvaluator.get("total_count");

	void getShipIDs() throws IOException {
		//String totalCount=""+jsonPathEvaluator.get("meta.total_count");
		//addInfoToReport("Total Ship count: "+totalCount);
	}	
}