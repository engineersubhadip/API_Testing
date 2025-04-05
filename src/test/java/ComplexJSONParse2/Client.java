package ComplexJSONParse2;

import io.restassured.path.json.JsonPath;

public class Client {

	public static void main(String[] args) {
		
		String response = Payload.getCourse();
		
		JsonPath jsonPath = new JsonPath(response);
		
//		1. Print number of Courses returned by the API :-
		
		int courseCount = jsonPath.getInt("courses.size()");
		System.out.println("Total Course Count : "+courseCount);
//		2. Print the Purchase Amount :-
		
		int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
		System.out.println("Total Purchase Amount : "+purchaseAmount);
//		3. Print title of the first course :-
		
		String firstBookTitle = jsonPath.getString("courses[0].title");
		System.out.println("First Book title : "+firstBookTitle);
//		4. Print all course titles and their respective prices :-
		
		for (int i=0; i<courseCount; i++) {
			String currBookTitle = jsonPath.getString("courses["+i+"].title");
			int currBookPrice = jsonPath.getInt("courses["+i+"].price");
			
			System.out.println("Current Book Title : "+currBookTitle+" || Current Book Price : "+currBookPrice);
		}
		
//		5. Print number of copies sold by RPA Course :-
		
		for (int i=0; i<courseCount; i++) {
			String currBookTitle = jsonPath.getString("courses["+i+"].title");
			if (currBookTitle.equals("RPA")) {
				int currBookCopies = jsonPath.getInt("courses["+i+"].copies");
				System.out.println("Number of copies sold : "+currBookCopies);
				break;
			}
		}
	}

}
