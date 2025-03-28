package HandlingDynamicJSONPayloads;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import File.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ParameterizationAPITest {
	
	String id;
	
	@Test(dataProvider= "isbnAisleGen")
	public void createBook(String ISBN, String AISLE) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given()
			.header("Content-Type","application/json")
			.body(Payload.addBook(ISBN, AISLE))
		.when()
			.post("/Library/Addbook.php")
		.then()
			.log().body()
			.assertThat()
			.statusCode(200)
			.header("Content-Type", "application/json;charset=UTF-8")
			.body("Msg",Matchers.equalTo("successfully added"))
			.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		id = js.getString("ID");
	}
	
	@AfterMethod
	public void deleteRecord() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		given()
			.header("Content-Type","application/json")
			.body(Payload.deleteBook(id))
		.when()
			.delete("/Library/DeleteBook.php")
		.then()
			.log().body()
			.assertThat()
			.statusCode(200)
			.body("msg", Matchers.equalTo("book is successfully deleted"));
	}
	
	@DataProvider(name="isbnAisleGen")
	public Object[][] createData() {
		Object[][] data = new Object[][] {{"oops","737"}, {"qemc","452"}};
		return data;
	}
}
