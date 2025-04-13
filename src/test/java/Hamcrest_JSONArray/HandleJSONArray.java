package Hamcrest_JSONArray;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import net.minidev.json.JSONArray;

public class HandleJSONArray {
	
	@Test
	public void test_HandleJSOnArray() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
		
		String response =  given().when().get()
		.then().extract().response().asString();
		
		JSONArray arr = JsonPath.read(response, "$");
		
		for (int i=0; i<arr.size(); i++) {
			Map<String, Integer> hashMap = (Map<String, Integer>) arr.get(i);
			int bookingID = hashMap.get("bookingid");
			System.out.println("Current Booking ID : "+bookingID);
		}
	}
}
