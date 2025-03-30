package POJO_Basics_3_NestedJSONObject;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {
		
		Employee emp1 = new Employee();
		emp1.setFirstName("Suresh");
		emp1.setLastName("Mehra");
		emp1.setGender("Male");
		emp1.setSalary(10000.56);
		
		Address adrs1 = new Address();
		adrs1.setStreet("Park Avenue");
		adrs1.setCity("Vijaywada");
		adrs1.setState("Andhra Pradesh");
		adrs1.setPincode(530012);
		
		emp1.setAddress(adrs1);
		
//		Convert the Pojo Object to JSON Payload as String :-
		
		ObjectMapper objMap = new ObjectMapper();
		String reqPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
//		System.out.println("Request Payload to be sent : "+reqPayload);
		
		RestAssured.baseURI = "https://httpbin.org";
		
		String responsePayload = given()
			.contentType(ContentType.JSON)
			.body(reqPayload)
		.when()
			.post("post")
		.then()
			.assertThat()
			.statusCode(200)
			.extract().response().asString();
		
		System.out.println("Response Payload : "+responsePayload);
		
		JsonPath jp = new JsonPath(responsePayload);
		String jsonNode = jp.getJsonObject("json").toString();
		JsonPath jp2 = new JsonPath(jsonNode);
		
		System.out.println("Age of User : "+jp.getInt("json.age"));
		System.out.println("JSON Object : "+jsonNode);
	}

}
