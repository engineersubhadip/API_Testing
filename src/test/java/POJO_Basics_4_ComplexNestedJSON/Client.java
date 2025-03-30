package POJO_Basics_4_ComplexNestedJSON;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {

		Employee_Pojo emp1 = new Employee_Pojo();

		emp1.setCompanyName("XYZ Ltd.");
		emp1.setStreet("Africa Avenue");
		emp1.setCity("RK Puram Delhi");
		emp1.setPincode(110066);
		emp1.setBankAccounts(new ArrayList<>(Arrays.asList("HDFC", "SBI", "BOI", "ICICI")));

		Employee empp1 = new Employee();
		empp1.setFirstName("Suresh");
		empp1.setLastName("Mehra");
		empp1.setAge(35);
		empp1.setSalary(10000.56);

		Address add1 = new Address();
		add1.setState("Park Avenue");
		add1.setCity("Vijaywada");
		add1.setState("Andhra Pradesh");
		add1.setPincode(530012);

		empp1.setAddress(add1);
		emp1.setEmployees(new ArrayList<>(Arrays.asList(empp1)));

//		Convert the Pojo Object (emp1) to JSON Request Payload as String -> Serialization

		ObjectMapper objMap = new ObjectMapper();
		String reqPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
//		System.out.println(reqPayload);
		
		RestAssured.baseURI = "https://httpbin.org";
		
		String responsePayload = given()
			.contentType(ContentType.JSON)
			.body(emp1)
		.when()
			.post("/post")
		.then()
			.assertThat()
			.statusCode(200)
			.extract().response().asString();
		
		System.out.println("Response Payload : "+responsePayload);
	}

}
