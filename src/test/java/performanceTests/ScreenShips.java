package performanceTests;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Library.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Utilities;
import utilities.WebServices;

public class ScreenShips extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;
	String imo_name;
	int i;
	String transID;
	String ShipStatus;
	long startTime;
	long end;
	ArrayList<String> list1=new ArrayList<String>();
	ArrayList<String> list2=new ArrayList<String>();
	ArrayList<String> list3=new ArrayList<String>();
	NumberFormat formatter = new DecimalFormat("#0.00");

	@Test
	void RegisterShips() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "ScreenShips");
		startTime = System.currentTimeMillis();
		addInfoToReport("Starting Screening for "+data.length+" ships");
		int recordNum=1;
		for(int i=0;i<data.length;i++) {
			apiUser=(String) data[i][0];
			apiKey=(String) data[i][1];
			list1.add(apiUser);
			list2.add(apiKey);
			String imo_name=(String) data[i][2];
			response=getRegisterShipsResponse(apiKey,apiUser,imo_name);
			jsonPathEvaluator = response.jsonPath();
			transID=getRegisteredShipTransactionIDs();
			list3.add(transID);
			addInfoToReport("Transaction ID of screened ship with IMO: '"+imo_name+"' is: '"+transID+"'."+"Status Code is: '"+response.getStatusCode()+"'");
			printToNotepad("Imo Numbers",imo_name);
			printToNotepad("TransID",transID);
			printToNotepad("apiuser",apiUser);
			printToNotepad("apiKey",apiKey);
			Thread.sleep(2000);
			//addInfoToReport("Transaction Status of screened ship with IMO: "+imo_name+" is: "+response.getStatusCode());						
			
		}
		//		api=baseURL+"/api/v1/transaction/"+transID+"?"+"api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		//
		//		response=WebServices.Get(api);
		//		jsonPathEvaluator = response.jsonPath();
		//		ShipStatus=jsonPathEvaluator.get("status");
		for(int i=0;i<list3.size();i++) {
		api=baseURL+"/api/v1/transaction/"+list3.get(i).toString()+"?"+"api_key="+list2.get(i).toString()+"&username="+list1.get(i).toString()+"&limit="+limit;
		System.out.println(api);
		response=WebServices.Get(api);
		System.out.println("123$$"+response.asString());
		jsonPathEvaluator = response.jsonPath();
		Thread.sleep(2000);
		ShipStatus=jsonPathEvaluator.get("status");
		System.out.println(ShipStatus);
		while(ShipStatus.equalsIgnoreCase("P"))
		{
			//	Thread.sleep(5000);
			response=WebServices.Get(api);
			jsonPathEvaluator = response.jsonPath();
			ShipStatus=jsonPathEvaluator.get("status");
				}
		end = System.currentTimeMillis();
		int j=i+1;
		addInfoToReport("Screening completed for "+j+" ships");
		addInfoToReport("Time taken to screen "+j+" ships is: " + formatter.format((end - startTime) / 1000d) + " seconds");
		printToNotepad("ScreenShips",formatter.format((end - startTime) / 1000d));
		}
		end = System.currentTimeMillis();
		addInfoToReport("Screening completed for "+data.length+" ships");
		addInfoToReport("Time taken to screen "+data.length+" ships is: " + formatter.format((end - startTime) / 1000d) + " seconds");
			}
	

	public Response getRegisterShipsResponse(String apiKey,String apiUser,String imo_name ) throws IOException {
		api=baseURL+"/api/v1/registration?"+"api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		//addInfoToReport("API: "+api);
//		String stringJSON="{\"registered_name\":"+"\""+imo_name+"\""+"}";
		String stringJSON="{\"registered_name\": \""+imo_name+"\", \"registered_date\":\"2019-01-28T21:53:00Z\"}";
				
		System.out.println(api);
		response=WebServices.Post(api, stringJSON);
//		System.out.println(response.asString());
		return response;
	}

	public String getRegisteredShipTransactionIDs() throws IOException {
		String transactionID=""+jsonPathEvaluator.get("transaction_id");
		return transactionID;
	}	
}