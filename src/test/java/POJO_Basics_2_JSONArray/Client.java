package POJO_Basics_2_JSONArray;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {

		Employee emp1 = new Employee();

		emp1.setFirstName("Suresh");
		emp1.setLastName("Mehra");
		emp1.setAge(35);
		emp1.setGender("Male");
		emp1.setSalary(10000.56);

		Employee emp2 = new Employee();

		emp2.setFirstName("Rama");
		emp2.setLastName("Singh");
		emp2.setAge(30);
		emp2.setGender("Male");
		emp2.setSalary(34000);

		Employee emp3 = new Employee();

		emp3.setFirstName("Sikha");
		emp3.setLastName("Gupta");
		emp3.setAge(32);
		emp3.setGender("Female");
		emp3.setSalary(39000);

//		Create List of Employees

		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

//		Convert empList to JSON Payload for Request :- Serialize

		ObjectMapper obj = new ObjectMapper();
		String requestPayload = obj.writerWithDefaultPrettyPrinter().writeValueAsString(empList);
		
		System.out.println(requestPayload);
		
//		Convert JSON Response to Java Object :-  De-Serialize
		
		List<Employee> responseList = obj.readValue(requestPayload, new TypeReference<List<Employee>>() {});
		System.out.println(responseList);
		
//		JSONArray arr = new JSONArray(requestPayload);
//		
//		for (int i=0; i<arr.length(); i++) {
//			String currObj = arr.get(i).toString();
//			Employee currEmp = obj.readValue(currObj, Employee.class);
//			System.out.println("FirstName : "+currEmp.getFirstName()+" ||  LastName : "+currEmp.getLastName());
//		}
	}

}
