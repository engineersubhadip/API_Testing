package ComplexJSONParse;

import org.testng.Assert;

import File.Payload;
import io.restassured.path.json.JsonPath;

public class Client {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.getCoursePrice());
		
//		1. Get number of Courses :-
		int courseCount = js.getInt("courses.size()");
		System.out.println("Course Count : " + courseCount);
		
//		2. Print Purchase Amount :-
		long purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount : "+purchaseAmount);
		
//		3. Print Title for the 1st course :-
		String firstBookTitle = js.getString("courses[0].title");
		System.out.println("Title of the first book : "+firstBookTitle);
		
//		4. Print all course title and their respective prices :-
		for (int i=0; i<courseCount; i++) {
			String courseTitle = js.getString("courses["+i+"].title");
			int coursePrice = js.getInt("courses["+i+"].price");
			
			System.out.println("Course Title : "+courseTitle+" || Course Price : "+coursePrice);
		}
		
//		5. Print number of copies sold by RPA Course :-
		for (int i=0; i<courseCount; i++) {
			String courseTitle = js.getString("courses["+i+"].title");
			if (courseTitle.equals("RPA")) {
				int coursesSold = js.getInt("courses["+i+"].price");
				System.out.println("RPA Courses sold : "+coursesSold);
				break;
			}
		}
		
//		6. Verify if sum of all course prices matches with purchase amount :-
		long courseTotalPrice = 0L;
		
		for (int i=0; i<courseCount; i++) {
			int currentCoursePrice = js.getInt("courses["+i+"].price");
			int copiesSold = js.getInt("courses["+i+"].copies");
			long runProfit = currentCoursePrice * copiesSold;
			courseTotalPrice += runProfit;
		}
		
		System.out.println("Course Total Price : "+courseTotalPrice);
		Assert.assertEquals(courseTotalPrice, purchaseAmount);
	}

}
