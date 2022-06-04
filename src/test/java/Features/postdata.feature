Feature: Post check salary check

  Scenario: User create recored
    Given a book exists with an isbn of
    |Body| {\n" + "  \"name\": \"tammy\",\n" +"  \"salary\": \"5000\",\n" +"  \"age\": \"20\"\n" + "}|
    
    When a user retrieves the book by isbn
    Then the status code is 200
    And response includes the following in any order
     | status | success|
     
