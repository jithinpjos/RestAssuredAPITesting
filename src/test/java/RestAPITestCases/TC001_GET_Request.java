package RestAPITestCases;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_Request {
	
	@Test
	void getweatherDetails() {
		
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is :"+statusCode);
		Assert.assertEquals(200, statusCode);
		
		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println("Status Line is : "+statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
		
		
	}

}
