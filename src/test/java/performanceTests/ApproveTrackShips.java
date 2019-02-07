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

public class ApproveTrackShips extends TestBase{
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
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "ApproveTrackShips");
		startTime = System.currentTimeMillis();
		addInfoToReport("Starting Tracking Approval for "+data.length+" ships");
		int recordNum=1;
		for(int i=0;i<data.length;i++) {
			apiUser=(String) data[i][0];
			apiKey=(String) data[i][1];
			list1.add(apiUser);
			list2.add(apiKey);
			String transID=(String) data[i][2];
			response=getTrackingApprovalResponse(apiKey,apiUser,transID);
			System.out.println(response.asString());
			list3.add(transID);			
		}
		for(int i=0;i<list3.size();i++) {
			api=baseURL+"/api/v1/transaction/"+list3.get(i).toString()+"?"+"api_key="+list2.get(i).toString()+"&username="+list1.get(i).toString()+"&limit="+limit;
			response=WebServices.Get(api);
			jsonPathEvaluator = response.jsonPath();
			ShipStatus=jsonPathEvaluator.get("status");
			System.out.println(ShipStatus);
//			while(ShipStatus.equalsIgnoreCase("R"))
//			{
//				//	Thread.sleep(5000);
//				response=WebServices.Get(api);
//				jsonPathEvaluator = response.jsonPath();
//				ShipStatus=jsonPathEvaluator.get("status");
//			}
			end = System.currentTimeMillis();
			int j=i+1;
			addInfoToReport("Tracking Approval completed for "+j+" ships");
			addInfoToReport("Time taken to Approve"+j+" ships is: " + formatter.format((end - startTime) / 1000d) + " seconds");
			printToNotepad("ApproveTrackShips",formatter.format((end - startTime) / 1000d));
		}
		end = System.currentTimeMillis();
		addInfoToReport("Tracking completed for "+data.length+" ships");
		addInfoToReport("Time taken to Track "+data.length+" ships is: " + formatter.format((end - startTime) / 1000d) + " seconds");
	}


	public Response getTrackingApprovalResponse(String apiKey,String apiUser,String transID ) throws IOException {
		api=baseURL+"/api/v1/transaction/"+transID+"?api_key="+apiKey+"&username="+apiUser;
//		String stringJSON="{\"status\": \"A\",\"only_tracking_by_ais\": true}";

		String stringJSON="{\"status\": \"A\",\"only_tracking_by_ais\": true,\"tracking_date\": \"2019-01-28T21:53:00Z\"}";
		response=WebServices.Put(api, stringJSON);
		return response;
	}	
}