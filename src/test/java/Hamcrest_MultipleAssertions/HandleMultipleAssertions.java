package Hamcrest_MultipleAssertions;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class HandleMultipleAssertions {
	
//	@Test(priority=2)
	public void test_MultipleAssertions() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/1";
		
		String response =  given()
		.when()
			.get()
		.then()
			.body("firstname", Matchers.equalTo("Susan"))
			.body("lastname", Matchers.equalTo("Wilson"))
			.body("depositpaid", Matchers.equalTo(true))
			.extract().response().asString();
		
		System.out.println(response);
		
		// If any of the validations fail in between, immediately the test case will stop executing 
		// and it will
		// come out of the test run
		
	}

	@Test(priority=1)
	public void test_BestWayHandleMultipleAssertions() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/1";
		
		String response =  given()
		.when()
			.get()
		.then()
			.extract().response().asString();
		System.out.println(response);
		JsonPath jp = new JsonPath(response);
		
		String firstName = jp.getString("firstname");
		String lastName = jp.getString("lastname");
		boolean depositPaid = jp.getBoolean("depositpaid");
		int totalPrice = jp.getInt("totalprice");
		
		// Assertions :-
		SoftAssert sf = new SoftAssert();
		
		sf.assertEquals(firstName, "Sally","Matching the first name");
		sf.assertEquals(lastName, "Jackson","Matching the last name");
		sf.assertEquals(depositPaid, true,"Matching the deposit paid");
		sf.assertEquals(totalPrice, 500,"Matching the total price");
		sf.assertTrue(totalPrice > 500, "Check if total price is greater than 500");
		
		sf.assertAll();
	}
}
