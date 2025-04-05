package Authorization.DigestAuth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DigestAuthentication {
	
	@Test
	public void performDigestAuthentication () {
		
		RestAssured.baseURI = "http://httpbin.org";
		
		Response respBody = given()
		.when()
			.get("/digest-auth/undefined/prachi/prachi")
		.then()
			.log().all()
			.extract().response();
		
		System.out.println("Status Code : "+respBody.statusCode());
		System.out.println("Response Body : "+respBody.getBody().asString());
	}
}
