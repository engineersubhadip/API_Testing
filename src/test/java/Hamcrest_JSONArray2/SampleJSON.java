package Hamcrest_JSONArray2;

public class SampleJSON {

	public static String getResponse() {
		return "{\r\n" + "  \"users\": [\r\n" + "    {\r\n" + "      \"id\": 101,\r\n" + "      \"name\": {\r\n"
				+ "        \"first\": \"Alice\",\r\n" + "        \"last\": \"Johnson\"\r\n" + "      },\r\n"
				+ "      \"email\": \"alice.johnson@example.com\",\r\n"
				+ "      \"roles\": [\"admin\", \"editor\"],\r\n" + "      \"address\": {\r\n"
				+ "        \"permanent\": {\r\n" + "          \"street\": \"123 Main St\",\r\n"
				+ "          \"city\": \"New York\",\r\n" + "          \"zip\": \"10001\"\r\n" + "        },\r\n"
				+ "        \"temporary\": {\r\n" + "          \"street\": \"456 Elm St\",\r\n"
				+ "          \"city\": \"Brooklyn\",\r\n" + "          \"zip\": \"11201\"\r\n" + "        }\r\n"
				+ "      },\r\n" + "      \"contacts\": {\r\n" + "        \"phone\": {\r\n"
				+ "          \"home\": \"212-555-1234\",\r\n" + "          \"work\": \"646-555-5678\"\r\n"
				+ "        },\r\n" + "        \"social\": {\r\n" + "          \"twitter\": \"@aliceJ\",\r\n"
				+ "          \"linkedin\": \"linkedin.com/in/alicejohnson\"\r\n" + "        }\r\n" + "      },\r\n"
				+ "      \"loginHistory\": [\r\n" + "        {\r\n"
				+ "          \"timestamp\": \"2025-04-10T14:22:00Z\",\r\n" + "          \"ip\": \"192.168.1.10\",\r\n"
				+ "          \"location\": {\r\n" + "            \"city\": \"New York\",\r\n"
				+ "            \"country\": \"USA\"\r\n" + "          }\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"timestamp\": \"2025-04-11T09:15:30Z\",\r\n" + "          \"ip\": \"192.168.1.20\",\r\n"
				+ "          \"location\": {\r\n" + "            \"city\": \"Chicago\",\r\n"
				+ "            \"country\": \"USA\"\r\n" + "          }\r\n" + "        }\r\n" + "      ]\r\n"
				+ "    },\r\n" + "    {\r\n" + "      \"id\": 102,\r\n" + "      \"name\": {\r\n"
				+ "        \"first\": \"Bob\",\r\n" + "        \"last\": \"Smith\"\r\n" + "      },\r\n"
				+ "      \"email\": \"bob.smith@example.com\",\r\n" + "      \"roles\": [\"viewer\"],\r\n"
				+ "      \"address\": {\r\n" + "        \"permanent\": {\r\n"
				+ "          \"street\": \"789 Maple Ave\",\r\n" + "          \"city\": \"San Francisco\",\r\n"
				+ "          \"zip\": \"94107\"\r\n" + "        },\r\n" + "        \"temporary\": null\r\n"
				+ "      },\r\n" + "      \"contacts\": {\r\n" + "        \"phone\": {\r\n"
				+ "          \"home\": \"415-555-7890\",\r\n" + "          \"work\": null\r\n" + "        },\r\n"
				+ "        \"social\": {\r\n" + "          \"twitter\": null,\r\n"
				+ "          \"linkedin\": \"linkedin.com/in/bsmith\"\r\n" + "        }\r\n" + "      },\r\n"
				+ "      \"loginHistory\": []\r\n" + "    }\r\n" + "  ]\r\n" + "}\r\n" + "";
	}
}
