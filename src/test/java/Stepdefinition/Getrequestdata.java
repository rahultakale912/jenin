package Stepdefinition;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Getrequestdata {
	
	static Logger log = Logger.getLogger(Getrequestdata.class);
	//public BaseExcel excel= new BaseExcel();
	
	 public String[][] requestData; //This is the 2D string array which will contain all the data 
	 //ValidaworksheetleResponse json;

     RequestSpecification request;  
     Response response=null;
     String filepath= "The Path of the input excel to be provided";  
     
     
	
	@Given("^I want to execute service (.+)$")
	public void i_want_to_execute_service_getClientDetails(String service) throws Throwable {
		
		 log.info("We are going to execute service"+service);
		 
		 
	  
	}

	@When("^I submit the GET request as per the data in Excel Worksheet (.+)$")
	
		public void whenIsubmitgetrequest(String st2) throws IOException {
            

            int no=Integer.parseInt(st2); //Converting the value of Excel worksheet to Integer

      //      requestData=excel.readExcel(filepath, no); //Capturing the input data from excel to 2D string array

             String baseURI=requestData[1][1]; //Capturing the value of baseURI from excel into variable

            int count=requestData.length; //Initialising the variable with array length

            String [] Qparam=new String[count];

            String [] Qvalue=new String[count];

            String SERVICE_ENDPOINT = null;

            int chk=0;

//Following loop will capture all the Query parameter name 

				for (int i=1;i<count;i++)
				
				{
				
				if(!(requestData[i][2].isEmpty()))
				
				{
				
				Qparam[i]=requestData[i][2];
				
				Qvalue[i]=requestData[i][3];
				
				chk++;
				
				}                                         
				
				}
				


    SERVICE_ENDPOINT =baseURI;

    String Query=null;

    if(chk==1)

    {

    SERVICE_ENDPOINT = baseURI+"?"+requestData[1][2]+"="+requestData[1][3];

    }

    if(chk>1)

    {

			SERVICE_ENDPOINT = baseURI+"?"+requestData[1][2]+"="+requestData[1][3];
			for(int i=1;i<chk;i++)
			
			{
			Query = Query.concat("&"+requestData[i+1][2]+"="+requestData[i+1][3]);
			
			SERVICE_ENDPOINT = SERVICE_ENDPOINT.concat(Query);
			
			}
			
			}               

             request = RestAssured.given();

             request.header("header1","User1"); //Passed the value of header parameter

             request.header("header2","User2");//Passed the value of header parameter

             response = request.when().get(SERVICE_ENDPOINT);//Submit the request

                        

					ResponseBody body = response.getBody();                            
					
		//			 excel.writeExcel(filepath, no, 10, 1, response.prettyPrint());//Print the service response in excel 
          

}

	  

	@When("^I validate status code$")
	public void i_validate_status_code() throws Throwable {
	 
		String status=requestData[1][5];
        //Capture the expected value of status code passed in input excel

       int statusCode = response.getStatusCode();
        //Capture the resulting status code after submitting the request

       int code=Integer.parseInt(status);

       Assert.assertEquals(code, statusCode);
	}

	@When("^I validate mandatory tag in response from Excel Worksheet (\\d+)$")
	public void i_validate_mandatory_tag_in_response_from_Excel_Worksheet(String st2) throws Throwable {
	  
		int no=Integer.parseInt(st2);

        int rowcount=requestData.length;

        ResponseBody body = response.getBody();

        String bodyAsString = body.asString();

        for(int i=1;i<rowcount;i++)

        {

			String Mandatoryfield=requestData[i][6];//Capture the mandatory tag names from input excel
			Boolean value=bodyAsString.contains(Mandatoryfield);
//To verify if mandatory tag is present in response.
		if(value)
		   {
		      //  excel.writeExcel(filepath, no, 7, i, "Mandatory Tag Present"); 
		       //This will write the result in excel.
		
		    }
		 else
		
		    {
		
		    // excel.writeExcel(filepath, no, 7, i, "Mandatory Tag Not Present"); 
		     //This will write the result in excel.
		
		    }
		
		        }
			}

	@When("^I validate response content$")
	public void i_validate_response_content() throws Throwable {
		
		String contentType = response.header("Content-Type");

        assertEquals(contentType, "application/json; charset=utf-8");
   //To verify if the response is coming in valid JSON format
	  
	}

	@When("^I validate tag values in response from Excel Worksheet (\\d+)$")
	public void i_validate_tag_values_in_response_from_Excel_Worksheet(String st2) throws Throwable {
		
		int no=Integer.parseInt(st2);

        int rowcount=requestData.length;

        for(int i=1;i<rowcount;i++)

        {

              String tagname=requestData[i][6];

        String val=response.path(requestData[1][4]+"."+tagname);
       //To capture the value of the tags provided in input excel

        String Exval=requestData[i][8];

      if(val.equals(Exval))

			 {
			
			// excel.writeExcel(filepath, no, 9, i, "Tag Value Matched"); 
			 //This will write the result in excel.
			
			 }
			 else
			
			 {
			  // excel.writeExcel(filepath, no, 9, i, "Tag Value Does Not Matched,Value obtained is "+val); 
			   //This will write the result in excel.
			
			 }

}
        
	  
	}

	@When("^I validate header parameter in response$")
	public void i_validate_header_parameter_in_response() throws Throwable {
		String journeyId = response.header("header1");

       // assertEquals(header1, "User1");//To validate the value of header in response.
	 
	}


}
