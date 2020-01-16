package UtilityClasses;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HitUrl {

	public static Response hitUrl(String request, String Url, String data) {
		Response response = null;
		if (request.equalsIgnoreCase("GET")) {
			RestAssured.baseURI = Url;
			RequestSpecification requestOfUrl = RestAssured.given();
			response = requestOfUrl.get();
		}

		if (request.equalsIgnoreCase("POST")) {
			RestAssured.baseURI = Url;
			RequestSpecification requestOfUrl = RestAssured.given();
			requestOfUrl.body(data);
			response = requestOfUrl.post();
		}

		if (request.equalsIgnoreCase("DELETE")) {
			RestAssured.baseURI = Url;
			RequestSpecification requestOfUrl = RestAssured.given();
			response = requestOfUrl.delete();
		}
		
		if (request.equalsIgnoreCase("PUT")) {
			RestAssured.baseURI = Url;
			RequestSpecification requestOfUrl = RestAssured.given();
			requestOfUrl.body(data);
			response = requestOfUrl.put();
		}

		return response;
	}

}
