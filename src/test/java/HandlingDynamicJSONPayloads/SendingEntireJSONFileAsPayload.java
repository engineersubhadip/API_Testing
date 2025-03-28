package HandlingDynamicJSONPayloads;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import File.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SendingEntireJSONFileAsPayload {
	
	String placeID;
	
	@Test
	public void sendFilePayload() throws IOException {
//		Convert the Content of the JSON file into String :-
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given()
			.queryParam("key", "qaclick123")
			.header("Content-Type","application/json")
			.body(new String(Files.readAllBytes(Paths.get("K:\\RestAssured-API Automation\\API_Automation_Testing\\testData\\Place.json"))))
		.when()
			.post("/maps/api/place/add/json")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.header("Server",Matchers.equalTo("Apache/2.4.52 (Ubuntu)"))
			.body("status", Matchers.equalTo("OK"))
			.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		placeID = js.getString("place_id");
		
		System.out.println("Generated Place ID : "+placeID);
	}

	@AfterMethod
	public void deleteRecord() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given()
			.queryParam("key","qaclick123")
			.header("Content-Type","application/json")
			.body(Payload.deletePlace(placeID))
		.when()
			.delete("/maps/api/place/delete/json")
		.then()
			.assertThat()
			.statusCode(200)
			.body("status", Matchers.equalTo("OK"));
	}
}
