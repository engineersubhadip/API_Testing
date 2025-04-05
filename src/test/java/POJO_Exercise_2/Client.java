package POJO_Exercise_2;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {
		
		BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
		Booking booking = new Booking(bookingDates,"Subhadip","Brown",111,true,"Breakfast");
		
//		Convert the Booking Object to JSON Payload as String :-
		
		ObjectMapper objMap = new ObjectMapper();
		String requestBody = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
		
		File refSchema = new File(System.getProperty("user.dir")+"./testData/SampleSchema.json");
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Response response = given()
			.contentType(ContentType.JSON)
			.body(requestBody)
		.when()
			.post("/booking")
		.then()
			.assertThat()
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchema(refSchema))
			.extract().response();
		
		int id = response.getBody().path("bookingid");
		System.out.println("Booking ID : "+id);
		BookingReponsePOJO bookingResponsePojo = response.as(BookingReponsePOJO.class);
		
//		Assert.assertEquals(booking2.getBookingdates().getCheckin(), "2018-01-01", "Checking Checkin Date");
		Assert.assertEquals("Subhadip", bookingResponsePojo.getBooking().getFirstname(), "Checking First Name Match in Response");
	}

}
