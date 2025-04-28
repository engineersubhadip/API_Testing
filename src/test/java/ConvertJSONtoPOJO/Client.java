package ConvertJSONtoPOJO;

import com.google.gson.Gson;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Client {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String response = given()
                .when().get("/booking/2")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        Gson gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(response, BookingResponse.class);

        System.out.println("Checkin Date : "+bookingResponse.getBookingdates().getCheckin());
    }
}
