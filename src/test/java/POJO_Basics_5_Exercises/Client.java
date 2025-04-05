package POJO_Basics_5_Exercises;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.path.json.JsonPath;

public class Client {

	public static void main(String[] args) throws JsonProcessingException {
//		RestAssured.baseURI = 
		String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
		
		String response = 	given()
			.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
			.formParams("grant_type","client_credentials")
			.formParams("scope","trust")
			.when().log().all()
			.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
		
		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		/*
//		Creation of Pojo Object :-
		Pojo_Class pObj = new Pojo_Class();
		
		pObj.setInstructor("Subhadip Das");
		pObj.setUrl("www.adobe.co.in");
		pObj.setServices("Automation Support");
		pObj.setExpertise("SDET Automation");
		
		WebAutomation webAuto1 = new WebAutomation();
		webAuto1.setCourseTitle("Selenium Webdriver Java");
		webAuto1.setPrice(50);
		
		WebAutomation webAuto2 = new WebAutomation();
		webAuto2.setCourseTitle("Cypress");
		webAuto2.setPrice(40);
		
		WebAutomation webAuto3 = new WebAutomation();
		webAuto3.setCourseTitle("Protractor");
		webAuto3.setPrice(40);
		
		API api1 = new API();
		api1.setCourseTitle("Rest Assured Automation using Java");
		api1.setPrice(50);
		
		API api2 = new API();
		api2.setCourseTitle("SoapUI Webservices testing");
		api2.setPrice(50);
		
		Mobile mobile = new Mobile();
		mobile.setCourseTitle("Appium-Mobile Automation using Java");
		mobile.setPrice(50);
		
		
		Courses courses = new Courses();
		courses.setWebAutomation(new ArrayList<>(Arrays.asList(webAuto1, webAuto2, webAuto3)));
		courses.setApi(new ArrayList<>(Arrays.asList(api1, api2)));
		courses.setMobile(new ArrayList<>(Arrays.asList(mobile)));
		
		pObj.setCourses(courses);
		pObj.setLinkedIn("https://www.subhadipdas95.com/");
		
//		Converting the Pojo Object to JSON Payload as String
		
		ObjectMapper objMap = new ObjectMapper();
		String reqPayload = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(pObj);
		
		System.out.println("Input Request Payload : "+reqPayload);
		*/
	}

}
