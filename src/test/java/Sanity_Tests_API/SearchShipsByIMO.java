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

public class SearchShipsByIMO extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	@Test
	void SearchShipsByIMO() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "SearchShipsByIMO");
		int recordNum=1;
		for(int i=0;i<data.length;i++) {
			//apiKey=(String) data[i][0];
			//apiUser=(String) data[i][1];
			String imo_name=(String) data[i][2];
			response=getSearchShipsByIMOResponse(apiKey, apiUser, imo_name);
			jsonPathEvaluator = response.jsonPath();
			getResponseCode(response);
			getResponseTime(response);
			getShipInformation();
			addInfoToReport("**************************************************");
			//getResponse(response);
			printToNotepad(api,response,"SearchShipsByIMO",recordNum++);
		}
		verifyResponseContents();	
	}

	private void verifyResponseContents() {
		// TODO Auto-generated method stub
	}

	public Response getSearchShipsByIMOResponse(String apiKey,String apiUser,String imo_name ) throws IOException {
		api=baseURL+"/api/v1/sisship?"+"imo_number__startswith="+imo_name+"&api_key="+apiKey+"&username="+apiUser+"&limit="+limit;
		System.out.println(api);
		addInfoToReport("API: "+api);
		response=WebServices.Get(api);
		return response;
	}


	void getShipInformation() throws IOException {
		String totalCount=""+jsonPathEvaluator.get("meta.total_count");
		addInfoToReport("Total Ship count: "+totalCount);
		int count=Integer.parseInt(totalCount);
		System.out.println(count+1);
		List flag_alpha_2=jsonPathEvaluator.get("objects.flag_alpha_2");
		List flag_code=jsonPathEvaluator.get("objects.flag_code");
		List image=jsonPathEvaluator.get("objects.image");
		List imo_number=jsonPathEvaluator.get("objects.imo_number");
		List mmsi=jsonPathEvaluator.get("objects.mmsi");
		List ship_name=jsonPathEvaluator.get("objects.ship_name");
		List ship_status=jsonPathEvaluator.get("objects.ship_status");
		List ship_type=jsonPathEvaluator.get("objects.ship_type");
	
		for(int i=0;i<count;i++) {
			try {
				addInfoToReport("Ship Number: "+(i+1));
				
				addInfoToReport("Flag: "+flag_alpha_2.get(i));
				addInfoToReport("Flag Code: "+flag_code.get(i));
				addInfoToReport("Ship image path"+image.get(i));
				addInfoToReport("Ship imo_number: "+imo_number.get(i));
				addInfoToReport("Ship mmsi: "+mmsi.get(i));
				addInfoToReport("Ship Name: "+ship_name.get(i));
				addInfoToReport("Ship Status: "+ship_status.get(i));
				addInfoToReport("Ship Type: "+ship_type.get(i));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}