package Authorization.BasicAuth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuthorization {
	
	@Test
	public void PerformBasicAPIAuth () {
		
		RestAssured.baseURI = "https://postman-echo.com";
		
//		Non Preemptive :- 
		Response responsePay = given()
			.auth()
			.basic("postman", "password")
		.when()
			.get("/basic-auth")
		.then()
			.extract().response();
		
		System.out.println("Status Code : "+responsePay.statusCode());
		responsePay.getBody().prettyPrint();
		
//		Preemptive :-
		
		Response responsePay1 = given()
				.auth()
				.preemptive()
				.basic("postman", "password")
			.when()
				.get("/basic-auth")
			.then()
				.extract().response();
		System.out.println("Status Code 1 : "+responsePay1.statusCode());
		responsePay1.getBody().prettyPrint();
	}
}
