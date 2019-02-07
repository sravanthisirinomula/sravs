package Sanity_Tests_API;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Library.PTRAC_API_TestBase;
import Library.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;
import utilities.WebServices;


public class DisplayApprovedShips extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	DisplayApprovedShips() throws EncryptedDocumentException, InvalidFormatException, IOException {
		//Object data[][]=Utilities.getDatafromExcel(apiSanTestDataFile, "ApprovedShips");
		//String apiKey=(String) data[0][1];
		//String user=(String) data[0][0];
		api=baseURL+"/api/v1/transaction/?"+"status__in=A&order_by=-creation_date&api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		response=WebServices.Get(api);
		jsonPathEvaluator = response.jsonPath();
	}

	@Test
	void displayApprovedShips() throws IOException {
		addInfoToReport("API: "+api);
		getResponseCode(response);
		getResponseTime(response);
		getResponse(response);
		getShipIDs();
	}

	void getShipIDs() throws IOException {
		List<String> shipName=jsonPathEvaluator.get("objects.ship.ship_name");
		List<Integer> transactionID=jsonPathEvaluator.get("objects.id");
		List<String> creationDate=jsonPathEvaluator.get("objects.creation_date");
		List<String> IMO=jsonPathEvaluator.get("objects.registered_name");
		List<String> overall_severity=jsonPathEvaluator.get("objects.overall_severity");
		List<String> LastPositionLat=jsonPathEvaluator.get("objects.last_position.latitude");
		List<String> LastPositionLon=jsonPathEvaluator.get("objects.last_position.longitude");
		try {
			addInfoToReport("Total Ship Count: "+transactionID.size());
		} catch (IOException e) {
		captureApiFailStatus("Total Ship count not captured");
		}
		
		for (int i=0; i<transactionID.size();i++) {
			addInfoToReport("********************Ship Information**************");
			addInfoToReport("Approved Ship Name: "+shipName.get(i));
			addInfoToReport("Approved Ship IMO: "+IMO.get(i));
			addInfoToReport("Approved Ship transaction ID: "+transactionID.get(i));
			addInfoToReport("Ship Created on: "+creationDate.get(i));
			addInfoToReport("OverAll Severity: "+overall_severity.get(i));
		}}}