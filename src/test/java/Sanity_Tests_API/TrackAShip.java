package Sanity_Tests_API;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import Library.PTRAC_API_TestBase;
import Library.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;
import utilities.WebServices;

public class TrackAShip extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	@Test
	void trackAShip() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "TrackShip");
		for(int i=0;i<data.length;i++) {
			String transactionId=(String) data[i][2];
			api=baseURL+"/api/v1/transaction/"+transactionId+"/track?"+"api_key="+apiKey+"&username="+apiUser;
			System.out.println(api);
			String stringJSON="{\"client_reference\":\"\",\"departure_port\":\"\",\"departure_date\":\"\",\"interim_ports\":\"\",\"destination_port\":\"\",\"arrival_date\":\"\"}";
			response=WebServices.Put(api, stringJSON);
			getResponseCode(response);
			getResponseTime(response);
			getResponse(response);
			addInfoToReport("API: "+api);
			addInfoToReport("API: "+api);
			getResponseCode(response);
			getResponseTime(response);
			getResponse(response);
		}
	}
	
	void getShipIDs() throws IOException {
		String transactionID=""+jsonPathEvaluator.get("id");
		String creationDate=jsonPathEvaluator.get(".creation_date");
		String IMO=""+jsonPathEvaluator.get("registered_name");
		String shipStatus=jsonPathEvaluator.get("status");
		addInfoToReport("********************Ship Information**************");
		addInfoToReport("Ship IMO: "+IMO);
		//addInfoToReport("Ship Transaction ID: "+transactionID);
		addInfoToReport("Ship Created on: "+creationDate);
		addInfoToReport("Ship Status: "+shipStatus);
	}	
}