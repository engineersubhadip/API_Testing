package File;

public class Payload {
	public static String addPlace() {
		return "{\r\n" + "    \"location\": {\r\n" + "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n" + "    },\r\n" + "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Rahul Shetty Academy\",\r\n" + "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 09\",\r\n" + "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n" + "        \"shop\"\r\n" + "    ],\r\n"
				+ "    \"website\": \"http://rahulshettyacademy.com\",\r\n" + "    \"language\": \"French-IN\"\r\n"
				+ "}";
	}

	public static String updatePlace(String placeID) {
		return "{\r\n" + "    \"place_id\": \"" + placeID + "\",\r\n" + "    \"address\": \"64 Narasingha Avenue\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n" + "}";
	}

	public static String getCoursePrice() {
		return "{\r\n" + "  \"dashboard\": {\r\n" + "    \"purchaseAmount\": 1489,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n" + "  },\r\n" + "  \"courses\": [\r\n" + "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n" + "      \"price\": 50,\r\n" + "      \"copies\": 6\r\n"
				+ "    },\r\n" + "    {\r\n" + "      \"title\": \"Cypress\",\r\n" + "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n" + "    },\r\n" + "    {\r\n" + "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n" + "      \"copies\": 10\r\n" + "    },\r\n" + "    {\r\n"
				+ "      \"title\": \"Java\",\r\n" + "      \"price\": 19,\r\n" + "      \"copies\": 12\r\n"
				+ "    },\r\n" + "    {\r\n" + "      \"title\": \"HLD\",\r\n" + "      \"price\": 27,\r\n"
				+ "      \"copies\": 13\r\n" + "    }\r\n" + "  ]\r\n" + "}";
	}

	public static String addBook(String isbnNum, String isleNum) {
		return "{\r\n" + "    \"name\": \"Core Java and LLD\",\r\n" + "    \"isbn\": \""+isbnNum+"\",\r\n"
				+ "    \"aisle\": \""+isleNum+"\",\r\n" + "    \"author\": \"Subhadip Das\"\r\n" + "}";
	}
	
	public static String deleteBook(String bookID) {
		return "{\r\n"
				+ "    \"ID\": \""+bookID+"\"\r\n"
				+ "}";
	}
	
	public static String deletePlace(String placeID) {
		return "{\r\n"
				+ "    \"place_id\":\""+placeID+"\"\r\n"
				+ "}";
	}
}
