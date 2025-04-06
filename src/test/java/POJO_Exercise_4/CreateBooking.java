package POJO_Exercise_4;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateBooking {

	@Test
	public void testCase01_CreateDummyUser() throws JsonProcessingException {

		BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
		Booking booking = new Booking("Jim", "Brown", 111, true, bookingDates, "Breakfast");

//		Serialize :- Conversion of Java object to JSON Payload as String.

		ObjectMapper objMap = new ObjectMapper();
		String requestPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(booking);

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

//		Reference JSON Schema to be compared against :-

		File refSchema = new File(System.getProperty("user.dir") + "./testData/referenceSchema.json");

		Response response = given().contentType(ContentType.JSON).body(requestPayload).when().post("/booking").then()
				.assertThat().statusCode(200).body(JsonSchemaValidator.matchesJsonSchema(refSchema)).extract()
				.response();

//		Deserialize :- Conversion to JSON Payload to Java Object

		BookingResponse bookingResponse = response.as(BookingResponse.class);

//		Check for values :-

		Assert.assertEquals(booking.getFirstname(), bookingResponse.getBooking().getFirstname());
		Assert.assertEquals(booking.getLastname(), bookingResponse.getBooking().getLastname());
		Assert.assertEquals(booking.getTotalprice(), bookingResponse.getBooking().getTotalprice());
		Assert.assertEquals(booking.getTotalprice(), bookingResponse.getBooking().getTotalprice());
	}
}
