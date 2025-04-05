package POJO_Exercise_3;

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

public class SerializeAndDeserialize {
	
	@Test
	public void testCase01_SerializeDeserialize () throws JsonProcessingException {
		
		BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
		Booking booking = new Booking(bookingDates, "Jim", "Brown", 111, true, "Breakfast");
		
//		Conversion of POJO to JSON Payload as String :-
		
		ObjectMapper objMap = new ObjectMapper();
		String requestPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
		
		File refSchema = new File(System.getProperty("user.dir")+"./testData/BookingRef.json");
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Response responseBody = given()
			.contentType(ContentType.JSON)
			.body(requestPayload)
		.when()
			.post("/booking")
		.then()
			.assertThat() 
			.statusCode(200) // validating status code
			.body(JsonSchemaValidator.matchesJsonSchema(refSchema)) // validating the JSON schema
			.extract().response();
		
		// Performing Deserialization on the JSON Response Payload :-
		
		BookingResponse bookingResponse = responseBody.as(BookingResponse.class);
		
//		Assertions :-
		Assert.assertEquals(booking.getFirstname(), bookingResponse.getBooking().getFirstname(),"Check for First Name");
		Assert.assertEquals(booking.getLastname(), bookingResponse.getBooking().getLastname(),"Check for Last Name");
		Assert.assertEquals(booking.getBookingdates().getCheckin(), bookingResponse.getBooking().getBookingdates().getCheckin(),"Check for Check-In Date");
	}
}
