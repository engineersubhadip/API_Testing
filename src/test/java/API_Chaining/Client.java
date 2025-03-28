/*
 * I want to add a place
 * Use that place ID to update the place
 * Use that place ID to get the details of it
 * And verify if the returned value is same as the one you updated with
 */

package API_Chaining;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import File.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Client {

	public static void main(String[] args) {
		String placeID = "";
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
//		Add Place :-
		String addPlaceResponse = given()
			.queryParam("key", "qaclick123")
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
		
		JsonPath js1 = new JsonPath(addPlaceResponse);
		placeID = js1.getString("place_id");
		
//		Update Place
		given()
			.queryParam("key","qaclick123")
			.header("content-type","application/json")
			.body(Payload.updatePlace(placeID))
		.when()
			.put("maps/api/place/update/json")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.header("Server", Matchers.equalTo("Apache/2.4.52 (Ubuntu)"))
			.body("msg", Matchers.equalTo("Address successfully updated"));
	}

}
