package Stepdefinition;

import static io.restassured.RestAssured.given;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAPI {
	
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
    private String url = "http://dummy.restapiexample.com/api/v1/create";
    String requestBody ="{\n" +
            "  \"name\": \"tammy\",\n" +
            "  \"salary\": \"5000\",\n" +
            "  \"age\": \"20\"\n" +
            "}";
    
	
	@Given("^:I Set POST employee service api endpoint$")
	public void i_Set_POST_employee_service_api_endpoint() throws Throwable {
		
		request = given().body(requestBody);
		
	}

	@When("^: I Set request HEADER$")
	public void i_Set_request_HEADER() throws Throwable {
	   
		response= request.when().post(url);
		
	}

	@When("^: Send a POST HTTP request$")
	public void send_a_POST_HTTP_request() throws Throwable {
    }

	@Then("^: I receive valid Response$")
	public void i_receive_valid_Response(int statusCode) throws Throwable {
	    
		
		json = response.then().statusCode(statusCode);
		System.out.println(response.getBody().asString());
	}

}
