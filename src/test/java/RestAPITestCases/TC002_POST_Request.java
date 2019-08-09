package RestAPITestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_POST_Request {
	
	@Test
	void postCustomerRegistration() {
		
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName", "JohnFNghjkjS");
		requestParams.put("LastName", "JohnLfhjNhgjks");
		requestParams.put("UserName", "JohnfjhkUNs");
		requestParams.put("Password", "JohfjjhnPs");
		requestParams.put("Email", "JfhjohnEs@test.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		
		//Response object
		Response response=httpRequest.request(Method.POST,"/register");
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is :"+statusCode);
		Assert.assertEquals(201, statusCode);
		
		String successCode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals("OPERATION_SUCCESS", successCode);
	}

}
