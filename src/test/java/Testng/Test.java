package Testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import UtilityClasses.HitUrl;
import UtilityClasses.ReadFromExcel;
import io.restassured.response.Response;

public class Test {

	String excelUrl;
	int rowStart;
	int rowEnd;
	String[] requests = new String[1000];
	String[] Url = new String[1000];
	int expectedresponseCode[] = new int[100];
	String[] responses = new String[1000];
	String[] data = new String[1000];

	@BeforeClass
	public void beforeClass() {
		ReadFromExcel read = new ReadFromExcel();
		rowStart = read.getRowStart();
		rowEnd = read.getRowEnd();
		requests = read.getRequests();
		Url = read.getUrls();
		expectedresponseCode = read.getExpectedResponseCodes();
		responses = read.getResponses();
		data = read.getData();
	}

	@org.testng.annotations.Test
	public void verifyReponseCodes() {

		for (int i = rowStart + 1; i <= rowEnd; i++) {
			Response actualresponse = HitUrl.hitUrl(requests[i], Url[i], data[i]);
			int actual = actualresponse.getStatusCode();
			int expected = expectedresponseCode[i];
			Assert.assertEquals(actual, expected);
		}
	}

	@org.testng.annotations.Test
	public void verifyResponseBody() {

		for (int i = rowStart + 1; i <= rowEnd; i++) {
			Response actualresponse = HitUrl.hitUrl(requests[i], Url[i], data[i]);
			String actual = actualresponse.body().asString();
			String expected = responses[i];
			Assert.assertEquals(actual, expected);
		}

	}

}
