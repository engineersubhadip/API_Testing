package Serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {

		Location location = new Location(-38.383494, 33.427362);

		Place place = new Place(location, 50, "Frontline house", "(+91) 983 893 3937", "29, side layout, cohen 09",
				new ArrayList<>(Arrays.asList("shoe park", "shop")), "http://google.com", "French-IN");
		
//		Convert the Place Pojo object to JSON Payload as String
		
		ObjectMapper objMap = new ObjectMapper();
		String reqPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(place);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response response = given()
			.contentType(ContentType.JSON)
			.body(reqPayload)
			.queryParam("key", "qaclick123")
		.when()
			.post("/maps/api/place/add/json")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.extract().response();
	}

}
