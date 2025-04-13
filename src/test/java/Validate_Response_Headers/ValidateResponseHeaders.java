package Validate_Response_Headers;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ValidateResponseHeaders {
	
	@Test(priority=1)
	public void testCase_PrintAllHeaders() {
		RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		
		// Way 1 :-
		Headers headers =  given()
		.when().get()
		.then().extract().response().headers();
		
		System.out.println("Total Headers Reurned : "+headers.size());
		
		for(Header header : headers) {
			System.out.println("Header Name : "+header.getName()+" || Header Value : "+header.getValue());
		}
		
		// Way 2 :-
		System.out.println("------------------------ Way 2 ------------------------------------");
		given().when().get().then().log().headers();
	}
	
	@Test(priority=2)
	public void testCase_PrintSpecificHeader() {
		
//		Way 1 :- I want to get only the server Information :-
		RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		
		Response response =  given().when().get().then().extract().response();
		
		String serverInfo = response.getHeader("Server");
		System.out.println("Server : "+serverInfo);
	}
	
	@Test(priority=3)
	public void testCase_ValidateResponseHeaders() {
//		I want to validate Content Type
		
		RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		
		Response response = given().when().get().then().extract().response();
		
		String contentType = response.getHeader("Content-Type");

		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
}
