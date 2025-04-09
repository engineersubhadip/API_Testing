package Pojo_Via_Builder;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {
		BookingDates bookingDates = BookingDates.getBuilder()
									.setCheckin("2018-01-01").setCheckout("2019-01-01").build();
		Booking booking = Booking.getBuilder().setFirstname("Jim")
							.setLastname("Brown").setTotalprice(111)
							.setDepositpaid(true)
							.setBookingdates(bookingDates)
							.setAdditionalneeds("Breakfast").build();
		
		// Serialize :-
		ObjectMapper objMap = new ObjectMapper();
		String requestBody = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
		
		System.out.println("Request : "+requestBody);
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Response response = given()
			.contentType(ContentType.JSON)
			.body(requestBody)
		.when()
			.post("booking")
		.then()
			.assertThat()
			.statusCode(200)
			.extract().response();
		
		BookingResponse bookingResponse = response.as(BookingResponse.class);
		
		String responseBodyActual = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(bookingResponse);
		System.out.println("Response : "+responseBodyActual);
		
		Assert.assertEquals(bookingResponse.getBooking().getFirstname(), booking.getFirstname(),"We are validating the first Name");
	}

}
