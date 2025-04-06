package LoadExternalJSONFile;

import static io.restassured.RestAssured.given;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import utils.FileNameConstants;

public class HowToLoadExternalJSON {
	
	@Test
	public void testCase_LoadDataFormExternalFile () throws IOException {
		
//		1. Read the Content of the External JSON File :-
		
		FileReader fileReader = new FileReader(FileNameConstants.bookingData);
		
//		2. Convert the content fileReader object to String :-
		
		String requestBody = IOUtils.toString(fileReader);
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		given()
			.contentType(ContentType.JSON)
			.body(requestBody)
		.when()
			.post("booking")
		.then()
			.assertThat()
			.statusCode(200);
	}
}
