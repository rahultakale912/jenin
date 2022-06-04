package Stepdefinition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification; 

public class PostrestAPI {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
    private String url = "http://dummy.restapiexample.com/api/v1/create";

	@Given("^a book exists with an isbn of$")
	public void a_book_exists_with_an_isbn_of(DataTable table) throws Throwable {
		
		List<List<String>> data = table.raw();
		request = given().body(data.get(0).get(1));
	
	}

	@When("^a user retrieves the book by isbn$")
	public void a_user_retrieves_the_book_by_isbn() throws Throwable {
	   
		response= request.when().post(url);
		System.out.println(response.getBody().asString());
	}
	
	@Then("^the status code is (\\d+)$")
	public void the_status_code_is(int Statuscode) throws Throwable {
		
		json = response.then().statusCode(Statuscode);
	}
	@Then("^response includes the following in any order$")
	public void response_includes_the_following_in_any_order(Map<String,String> responseFields) throws Throwable {

		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
		
	   
	}


	
}
