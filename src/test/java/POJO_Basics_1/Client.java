package POJO_Basics_1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Client {
	public static void main(String[] args) throws JsonProcessingException {

		Employee emp1 = new Employee(); // emp1 is a POJO object

		emp1.setFirstName("Suresh");
		emp1.setLastName("Mehra");
		emp1.setAge(35);
		emp1.setSalary(10000.56);

//		Converting a POJO Object to JSON Payload as String -> Serialization

		ObjectMapper objMap = new ObjectMapper();
		String jsonPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

//		System.out.println(jsonPayload);
		
		RestAssured.baseURI = "https://httpbin.org";
		
		given()
			.contentType("application/json")
			.body(jsonPayload)
		.when()
			.post("post")
		.then()
			.assertThat()
			.statusCode(200)
			.log().body();
		
//		Converting a JSON Response Payload to Java Object -> Deserialization
		
		Employee emp2 = objMap.readValue(jsonPayload,Employee.class);
		System.out.println("Deserailzie : "+emp2.getFirstName());
		
		
	}
}
