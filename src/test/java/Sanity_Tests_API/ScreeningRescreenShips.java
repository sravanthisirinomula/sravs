package Sanity_Tests_API;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptrac.qa.utilities.Utilities;
import com.ptrac.qa.utilities.WebServices;

import baseClass.PTRAC_API_TestBase;
import baseClass.PTRAC_TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ScreeningRescreenShips extends PTRAC_TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;
	String transactionId;

	@Test
	void RescreenShips() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiSanTestDataFile, "ReScreen");
		//String apiKey=(String) data[0][1];
		//String user=(String) data[0][0];
		//String[] transactionId1=transactionId.split("#");
		//transactionId=transactionId1[1];
		for(int i=0;i<data.length;i++) {
			transactionId=(String) data[i][2];
			api=baseURL+"/api/v1/transaction/"+transactionId+"/rescreen?"+"api_key="+apiKey+"&username="+apiUser;
			System.out.println(api);
			String stringJSON="{}";
			response=WebServices.Put(api, stringJSON);
			addInfoToReport("API: "+api);
			getResponseCode(response);
			getResponseTime(response);
			addInfoToReport("Ship Transaction ID: "+transactionId);
			getResponse(response);
		}
	}

	void getShipIDs() throws IOException {
		//String transactionID=""+jsonPathEvaluator.get("id");
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