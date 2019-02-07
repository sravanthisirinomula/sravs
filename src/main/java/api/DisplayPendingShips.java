package api;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Library.PTRAC_API_TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;
import utilities.WebServices;


public class DisplayPendingShips extends PTRAC_API_TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	DisplayPendingShips() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(testDataFile, "PendingShips");
		String apiKey=(String) data[0][1];
		String user=(String) data[0][0];
		api=baseURL+"/api/v1/transaction/?"+"status__in=P&order_by=-creation_date&api_key="+apiKey+"&username="+user+"&limit="+limit;
		response=WebServices.Get(api);
		jsonPathEvaluator = response.jsonPath();
	}

	@Test
	void displayPendingShips() throws IOException {
		addInfoToReport("API: "+api);
		getResponseCode();
		getResponseTime();
		getShipIDs();
		getResponse();
	}
	//String total_count = jsonPathEvaluator.get("total_count");

	void getShipIDs() throws IOException {
		List shipName=jsonPathEvaluator.get("objects.ship.ship_name");
		List transactionID=jsonPathEvaluator.get("objects.id");
		List creationDate=jsonPathEvaluator.get("objects.creation_date");
		List IMO=jsonPathEvaluator.get("objects.registered_name");
		List overall_severity=jsonPathEvaluator.get("objects.overall_severity");
		List LastPositionLat=jsonPathEvaluator.get("objects.last_position.latitude");
		List LastPositionLon=jsonPathEvaluator.get("objects.last_position.longitude");
		addInfoToReport("Total Ship Count: "+transactionID.size());
		for (int i=0; i<transactionID.size();i++) {
			addInfoToReport("********************Ship Information**************");
			addInfoToReport("Pending Ship Name: "+shipName.get(i));
			addInfoToReport("Pending Ship IMO: "+IMO.get(i));
			addInfoToReport("Pending Ship Transaction ID: "+transactionID.get(i));
			addInfoToReport("Ship Created on: "+creationDate.get(i));
			addInfoToReport("OverAll Severity: "+overall_severity.get(i));

		}}

	//@Test
	void getResponseCode() throws IOException {
		int statusCode=response.getStatusCode();
		String statusCodes=""+statusCode;
		addInfoToReport("Response Code is: "+statusCode);
		Assert.assertTrue(statusCodes.startsWith("20"));
	}

	//@Test
	void getResponseTime() throws IOException {
		long resTime=response.getTime();
		String resTimes=""+resTime;
		addInfoToReport("Response Time is: "+resTimes+" milli seconds");
	}

	//@Test
	void getResponse() throws IOException {
		String responser=response.asString();
		addInfoToReport("Response"+responser);
	}
}