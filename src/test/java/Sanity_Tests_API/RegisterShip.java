package Sanity_Tests_API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Library.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;
import utilities.WebServices;

public class RegisterShip extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;
	String imo_name;
	int i;
	ArrayList<String> list=new ArrayList<String>();


	@SuppressWarnings("resource")
	@Test
	void RegisterShips() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "RegisterShips");
		int recordNum=1;
		for(int i=0;i<data.length;i++) {
			//apiKey=(String) data[i][0];
			//apiUser=(String) data[i][1];
			String imo_name=(String) data[i][2];
			response=getRegisterShipsResponse(apiKey,apiUser,imo_name);
			//addInfoToReport(stringJSON);
			jsonPathEvaluator = response.jsonPath();
			getResponseCode(response);
			getResponseTime(response);
			getRegisteredShipTransactionIDs(imo_name);
			addInfoToReport("**************************************************");
			//getResponse(response);
			printToNotepad(api,response,"RegisterShips",recordNum++);
		}
		verifyResponseContents();			
	}
	//		list=getRegisteredShipTransactionIDs();
	//		for(int i=0;i<list.size();i++) {
	//			System.out.println("transaction ids"+list.get(i));
	//		}

	private void verifyResponseContents() throws IOException {
		String checkTransactionId=""+jsonPathEvaluator.get("");

		if(checkTransactionId.contains("transaction_id")) {
			capturePassStatus("transaction_id is present in response");
		} else {
			captureFailStatus("transaction_id is not available");
		}
		if(checkTransactionId.contains("client_reference")) {
			capturePassStatus("client_reference is present in response");
		} else {
			captureFailStatus("client_reference is not available");
		}
		if(checkTransactionId.contains("registered_name")) {
			capturePassStatus("registered_name is present in response");
		} else {
			captureFailStatus("registered_name is not available");
		}
		if(checkTransactionId.contains("resource_uri")) {
			capturePassStatus("resource_uri is present in response");
		} else {
			captureFailStatus("resource_uri is not available");
		}		
	}


	public Response getRegisterShipsResponse(String apiKey,String apiUser,String imo_name ) throws IOException {
		api=baseURL+"/api/v1/registration?"+"api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		System.out.println(api);
		addInfoToReport("API: "+api);
		String stringJSON="{\"registered_name\":"+"\""+imo_name+"\""+"}";
		response=WebServices.Post(api, stringJSON);
		return response;
	}

	public  ArrayList<String> getRegisteredShipTransactionIDs() throws IOException {
		ArrayList<String> transactionIDs=new ArrayList<String>();
		String transactionID=""+jsonPathEvaluator.get("transaction_id");
		try {
			capturePassStatus("Ship is registered and Transaction ID: "+transactionID);
		} catch (Exception e) {
			captureFailStatus("Ship Transaction ID not available");
		}
		transactionIDs.add(transactionID);
		return transactionIDs;
	}	

	public  void getRegisteredShipTransactionIDs(String imo) throws IOException {
		String transactionID=""+jsonPathEvaluator.get("transaction_id").toString();
		try {
			capturePassStatus("Ship with IMO Number: "+imo+" is registered and Transaction ID: "+transactionID);
		} catch (Exception e) {
			captureFailStatus("Ship Transaction ID not available");
		}

	}	
}