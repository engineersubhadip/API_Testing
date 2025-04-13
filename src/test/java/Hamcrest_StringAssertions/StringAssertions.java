package Hamcrest_StringAssertions;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import POJO_Exercise_4.CreateBooking;
import io.restassured.RestAssured;

public class StringAssertions {

	@Test
	public void test_StringAssertions() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/1";
		
		given()
		.when()
			.get()
		.then()
			.assertThat()
			.body("firstname", Matchers.equalTo("Eric"));
		
		System.out.println("Line 22 getting executed");
		
		given()
		.when()
			.get()
		.then()
			.assertThat()
			.body("firstname", Matchers.startsWith("Er"));
		
		System.out.println("Line 31 getting executed");
		
		given()
		.when()
			.get()
		.then()
			.assertThat()
			.body("firstname", Matchers.endsWith("ic"));
		
		System.out.println("Line 40 getting executed");
		
		given()
		.when()
			.get()
		.then()
			.assertThat()
			.body("firstname", Matchers.containsString("Eri"));
		
		System.out.println("Line 49 getting exeucted");
		
		given()
		.when()
			.get()
		.then()
			.assertThat()
			.body("firstname", Matchers.equalToIgnoringCase("ERIC"));
		
		System.out.println("Line 58 executed");
		
		given()
		.when()
			.get()
		.then()
			.assertThat()
			.body("firstname", Matchers.equalToCompressingWhiteSpace("Eric")); // if the response is <SPACE> E<Space>r<Space>ic<Space> -> It will be converted to Eric before comparaing with Eric as input value
		
		System.out.println("Line 68 getting executed");
	}
}
