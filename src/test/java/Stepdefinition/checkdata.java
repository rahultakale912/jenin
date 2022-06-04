package Stepdefinition;

import org.apache.http.HttpEntity;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class checkdata {
	
	
	Response response =null;
	@Given("^I want to execute endpionts$")
	public void excute_endpoints()
	{
		//RestAssured.basePath="https://reqres.in/api/users?name=\"raj\"";
		String addURI = "https://reqres.in/api/users?name=\\\"raj\\\"";
		 System.out.println("Add URL :"+addURI);
		
		
	}
	@When("^i submitthe POST request$")
	public void hit()
	{
		double name_id = Math.random();
		
		      String  emp_name = "zozo_"+name_id;//Just to avoid Duplicate Name entry
		
		      String requestBody = "{\n" +
			            "  \"name\": \"tammy\",\n" +
			            "  \"salary\": \"5000\",\n" +
			            "  \"age\": \"20\"\n" +
			            "}";
		
		        System.out.println("\n\n" + requestBody);

		        

	}
	
	@Then("^I should get 200 success Status code$")
	public void status()
	{
		
	}
	

}
