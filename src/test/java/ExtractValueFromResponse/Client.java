/*
 * You need to capture the ID from the response body
 */

package ExtractValueFromResponse;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import File.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Client {

	public static void main(String[] args) {
		String placeID = "";
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
//		Add place :-
		
		String response = given()
			.queryParam("key","qaclick123")
			.header("Content-Type","application/json")
			.body(Payload.addPlace())
		.when()
			.post("maps/api/place/add/json")
		.then()
			.assertThat()
			.statusCode(200)
			.header("Server", Matchers.equalTo("Apache/2.4.52 (Ubuntu)"))
			.body("status", Matchers.equalTo("OK"))
			.body("scope", Matchers.equalTo("APP"))
			.extract().response().asString();

//		Using JSONPath to convert String to JSON :-
		
		JsonPath js = new JsonPath(response);
		
		placeID = js.getString("place_id");
		
		System.out.println("Place ID : "+placeID);
	}

}
