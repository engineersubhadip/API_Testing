package Data_Driven_JSON;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class dataDrivenTesting {
	
	@Test(dataProvider="testData")
	public void testCase_PrintTestData(HashMap<String, Object> hashMap) {
		
		String firstName = (String)hashMap.get("firstname");
		String lastName = (String)hashMap.get("lastname");
		boolean status = (boolean)hashMap.get("status");
		
		System.out.println(firstName + " || "+lastName + " || "+status);
	}
	
	@DataProvider (name = "testData")
	public Object[] generateTestData () throws IOException {
		Object[] testData = null;
		
//		1. Read the Content of the JSON File in a String :-
		FileReader file = new FileReader("K:\\RestAssured-API Automation\\API_Automation_Testing\\src\\test\\java\\Data_Driven_JSON\\testDataJSON.json");
		String jsonData = IOUtils.toString(file);
		
//		2. Convert the jsonData to JSONArray :-
		JSONArray jsonArray = JsonPath.read(jsonData, "$");
		testData = new Object[jsonArray.size()];
		
		for (int i=0; i<jsonArray.size(); i++) {
			HashMap<String, Object> hashMap = (HashMap<String, Object>)jsonArray.get(i);
			testData[i] = hashMap;
		}
		
		return testData;
	}
}
