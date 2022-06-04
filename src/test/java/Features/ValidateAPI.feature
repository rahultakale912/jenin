Feature: Create emp record
  	

Scenario: Add Employee record 
   
    Given :I Set POST employee service api endpoint
    When : I Set request HEADER
    And : Send a POST HTTP request 
   Then : I receive valid Response