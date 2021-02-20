package apitestWithRestAssured;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TPConnectGET {

	@Test
	public void GETRequest() {

		String url = "https://reqres.in/api/users?page=2";

		Response response = RestAssured.get(url);

		Assert.assertEquals(response.getStatusCode(), 200, "Message - Response Missmatch Code");
		int total_pages = response.jsonPath().get("total_pages");
		Assert.assertEquals(total_pages, 2,  "Message - Total Pages Missmatch Code");

	}
	@Test
	public void POSTRequest() {

		String url = "https://reqres.in/api/users";
		String contentType = "application/json";
		String bodyData = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		Response response = RestAssured.
				given().
				contentType(contentType).
				body(bodyData).
				when().
				post(url).
				then().
				extract().response();
		Assert.assertEquals(response.getStatusCode(), 201, "Message - Response Missmatch Code");
		String name = response.jsonPath().get("name");
		Assert.assertEquals(name, "morpheus", "name missmatch");



	}
	@Test
	public void DELETERequest() {
		int empid = 15410;

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();	

		request.header("Content-Type", "application/json");	

		Response response = request.delete("/delete/"+ empid);		

		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);

		String jsonString =response.asString();
		Assert.assertEquals(jsonString.contains("Message - successfully! deleted Records"), false);
	}

	@Test
	public void PATCHRequest() {
		String url = "https://reqres.in/api/users/2";
		String contentType = "application/json";
		String bodyData = "{" +
				"\"first_name\" : \"Sunil\", " +
				"\"last_name\": \"TESTER\"" +
				"}";
		Response response = RestAssured.
				given().
				contentType(contentType).
				body(bodyData).
				when().
				patch(url).
				then().
				extract().response();
		Assert.assertEquals(response.getStatusCode(), 200, "Message - Details Updated");
		
	}
@Test
public void PUTRequest() {
	String url = "https://reqres.in/api/users/2";
	String contentType = "application/json";
	String bodyData = "{" +
			"\"first_name\" : \"Sunil\", " +
			//"\"last_name\": \"TESTER\"" +
			"}";
	Response response = RestAssured.
			given().
			contentType(contentType).
			body(bodyData).
			when().
			put(url).
			then().
			extract().response();
	Assert.assertEquals(response.getStatusCode(), 400, "Message - Details Updated");
}
}



