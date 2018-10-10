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


public class RegisterShip extends PTRAC_TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	@Test
	void RegisterShips() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiSanTestDataFile, "Register");
		for(int i=0;i<data.length;i++) {
			String imo_name=(String) data[i][2];
			api=baseURL+"/api/v1/registration?"+"api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
			System.out.println(api);
			String stringJSON="{\"registered_name\":"+"\""+imo_name+"\""+"}";
			response=WebServices.Post(api, stringJSON);
			//addInfoToReport(stringJSON);
			jsonPathEvaluator = response.jsonPath();
			addInfoToReport("API: "+api);
			getResponseCode(response);
			getResponseTime(response);
			getShipIDs();
			getResponse(response);
		}
	}

	void getShipIDs() throws IOException {
		String transactionID=""+jsonPathEvaluator.get("transaction_id");
		addInfoToReport("Registered Ship Transaction ID: "+transactionID);
	}	
}