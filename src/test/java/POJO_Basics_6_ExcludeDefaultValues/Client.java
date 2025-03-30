package POJO_Basics_6_ExcludeDefaultValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {
		
//		How to ignore DEFAULT Value :-
		
		Employee emp1 = new Employee();

		emp1.setFirstName("Subhadip");
//		emp1.setLastName("Das");
		emp1.setGender("Male");
		emp1.setAge(31);
		emp1.setSalary(50000);
		emp1.setMarried(false);
		
//		System.out.println(emp1.isMarried());
//		Converting Pojo Object to JSON Payload as String
		
		ObjectMapper objMap = new ObjectMapper();
		String reqPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println("Request Payload 1 "+reqPayload);
		
//		How to ignore NULL Values :-
		
		Employee emp2 = new Employee();
		emp2.setFirstName("Aviskar");
		emp2.setGender("Male");
		emp2.setGender("Male");
		emp2.setSalary(222222);
		
		ObjectMapper objMap2 = new ObjectMapper();
		String reqPayload2 = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp2);
		System.out.println("Request Payload 2 "+reqPayload2);
		
//		How to ignore Empty Values :-
		Employee emp3 = new Employee();
		emp3.setFirstName("Hello");
		emp3.setLastName("World");
		emp3.setGender("Male");
		emp3.setAge(22);
		emp3.setSalary(22222222);
//		emp3.isMarried()
		emp3.setHobbies(new ArrayList<>());
		
		Map<String, String> hm = new HashMap<>();
		emp3.setFamilyMembers(hm);
		
		ObjectMapper objMap3 = new ObjectMapper();
		String reqPayload3 = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp3);
		System.out.println("Request Payload 3 "+reqPayload3);
	}

}
