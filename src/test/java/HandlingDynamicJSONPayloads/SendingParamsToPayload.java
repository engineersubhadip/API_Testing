/*
 * How to send random parameters to Payload to generate books
 * **Note**
 * We cannot use the same AISLE and ISBN combo generate more than one book.
 * If we try to do so we will get "Book already exists"
 */

package HandlingDynamicJSONPayloads;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import File.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SendingParamsToPayload {
	
	String bookID;

	@Test(priority = 1)
	public void addBook() {

		RestAssured.baseURI = "http://216.10.245.166";

		String addBookResponse = given().header("Content-Type", "application/json")
				.body(Payload.addBook("gaffer", "2134")).when().post("Library/Addbook.php").then().assertThat()
				.statusCode(200).header("server", Matchers.equalTo("Apache"))
				.body("Msg", Matchers.equalTo("successfully added")).log().body().extract().response().asString();

		JsonPath js = new JsonPath(addBookResponse);
		bookID = js.getString("ID");

		System.out.println("Generated Book ID : " + bookID);
	}
	
	@AfterMethod
	public void deleteRecord() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		given()
			.header("Content-Type","application/json")
			.body(Payload.deleteBook(bookID))
		.when()
			.delete("/Library/DeleteBook.php")
		.then()
			.assertThat()
			.statusCode(200)
			.body("msg", Matchers.equalTo("book is successfully deleted"));
			
	}
}