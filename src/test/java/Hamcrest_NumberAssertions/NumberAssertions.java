package Hamcrest_NumberAssertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NumberAssertions {
	
	@Test
	public void test_NumberAssertions () {
		String endPoint = "https://restful-booker.herokuapp.com/booking/1";
		
		RestAssured.given()
		.when().get(endPoint)
		.then().assertThat().body("totalprice", Matchers.equalTo(178));
		
		RestAssured.given()
		.when().get(endPoint)
		.then().assertThat().body("totalprice", Matchers.greaterThan(100));
		
		RestAssured.given()
		.when().get(endPoint)
		.then().assertThat().body("totalprice", Matchers.lessThan(1000));
		
		RestAssured.given()
		.when().get(endPoint)
		.then().assertThat().body("totalprice", Matchers.greaterThanOrEqualTo(50));
		
		RestAssured.given()
		.when().get(endPoint)
		.then().assertThat().body("totalprice", Matchers.lessThanOrEqualTo(1000));
	}
}
