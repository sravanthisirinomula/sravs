package Sanity_Tests_API;

import java.io.IOException;

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
public class ScreeningDeRegisterShip extends TestBase{
	static String api;
	Response response;
	JsonPath jsonPathEvaluator;

	@Test
	void ScreenDeRegisterShip() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object data[][]=Utilities.getDatafromExcel(apiTestDataFile, "DeRegister");
		/*String apiKey=(String) data[0][1];
		String user=(String) data[0][0];
		 */
		for(int i=0;i<data.length;i++) {
			String transactionId=(String) data[i][2];
			api=baseURL+"/api/v1/transaction/"+transactionId+"?"+"api_key="+apiKey+"&username="+apiUser;
			System.out.println(api);
			String stringJSON="{\"status\":\"D\"}";
			response=WebServices.Put(api, stringJSON);
			jsonPathEvaluator = response.jsonPath();
			addInfoToReport("API: "+api);
			getResponseCode(response);
			getResponseTime(response);
			getShipIDs();
			getResponse(response);
		}}


	//String total_count = jsonPathEvaluator.get("total_count");
	void getShipIDs() throws IOException {
		String status=jsonPathEvaluator.get("status");
		addInfoToReport("deRegistered Ship status: "+status);
		String transId=""+jsonPathEvaluator.get("id");
		addInfoToReport("deRegistered Ship ID: "+transId);
	}
}