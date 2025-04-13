package Hamcrest_HasKey;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CheckKey {
	
	@Test
	public void test_CheckForKey() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/1";
		
		String response =  given().when().get().then()
		.body("bookingdates", Matchers.hasKey("checkout"))
		.extract().response().asString();
		
		JsonPath jp = new JsonPath(response);
		
		Map<String, String> bookingDates = jp.getMap("bookingdates");
		
		System.out.println("Size of bookingDates : "+bookingDates.keySet().size());
	}

}
