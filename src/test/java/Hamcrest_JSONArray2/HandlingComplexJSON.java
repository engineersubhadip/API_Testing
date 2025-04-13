package Hamcrest_JSONArray2;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class HandlingComplexJSON {
	
	@Test
	public void testCase_HandleComplexJSON() {
		
		String response = SampleJSON.getResponse();
		
		JsonPath jp = new JsonPath(response);
		
		int userSize = jp.getInt("users.size()");
		
		for (int i=0; i<userSize; i++) {
			int zipCode = jp.getInt("users["+i+"].address.permanent.zip");
			System.out.println(zipCode);
		}
	}
}
