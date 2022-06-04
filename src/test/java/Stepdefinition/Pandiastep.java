package Stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Pandiastep {
	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private static final String USERNAME = "TOOLSQA-Test";
	private static final String PASSWORD = "Test@@123";
	private static final String BASE_URL = "https://gorest.co.in/public/v1/users";

	private static String token;
	private static Response response;
	private static String jsonString;
	private static String bookId;
	private ValidatableResponse validatableResponse;
	
	
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I am given");
		Getrequestwithoutparam();
	   
	}

	private void Getrequestwithoutparam() {
		// TODO Auto-generated method stub
		validatableResponse = given().contentType(ContentType.JSON)
                .when().get(BASE_URL).then(); 
		System.out.println("Response :"+validatableResponse.extract().asString());
	}

	@When("^user get data from APII$")
	public void user_get_data_from_APII() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I am When");
		
	}

	@Then("^check responnse$")
	public void check_responnse() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I am Then");
		//System.out.println(validatableResponse.toString().));
		
		validatableResponse.assertThat().statusCode(200);
	}



}
