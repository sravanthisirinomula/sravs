package Sanity_Tests_API;

import java.io.IOException;
import java.util.List;

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


public class DisplayShipsBasesOnStatus extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;


	DisplayShipsBasesOnStatus() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "ShipStatus");
		//String apiKey=(String) data[0][1];
		//String user=(String) data[0][0];
		String status=(String) data[0][2];
		api=baseURL+"/api/v1/transaction/?"+"status__in="+status+"&order_by=-creation_date&api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		response=WebServices.Get(api);
		jsonPathEvaluator = response.jsonPath();
	}

	@Test
	void displayShipsBasesOnStatus() throws IOException {
		addInfoToReport("API: "+api);
		getResponseCode(response);
		getResponseTime(response);
		getShipIDs();
		getResponse(response);
	}

	void getShipIDs() throws IOException {
		List<String> shipName=jsonPathEvaluator.get("objects.ship.ship_name");
		List<Integer> transactionID=jsonPathEvaluator.get("objects.id");
		List<String> creationDate=jsonPathEvaluator.get("objects.creation_date");
		List<String> IMO=jsonPathEvaluator.get("objects.registered_name");
		List<String> overall_severity=jsonPathEvaluator.get("objects.overall_severity");
		List<String> LastPositionLat=jsonPathEvaluator.get("objects.last_position.latitude");
		List<String> LastPositionLon=jsonPathEvaluator.get("objects.last_position.longitude");
		addInfoToReport("Total Ship Count: "+transactionID.size());
		for (int i=0; i<transactionID.size();i++) {
			addInfoToReport("********************Ship Information**************");
			addInfoToReport("Ship Name: "+shipName.get(i));
			addInfoToReport("Ship IMO: "+IMO.get(i));
			addInfoToReport("Ship Trabnsaction ID: "+transactionID.get(i));
			addInfoToReport("Ship Created on: "+creationDate.get(i));
			addInfoToReport("OverAll Severity: "+overall_severity.get(i));
		}}}