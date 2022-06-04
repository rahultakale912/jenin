Feature: Login browser
  	
  // @SmokeTest

  @filetrack
  Scenario Outline: Verification of Login functionlity
    Given : Open the firefox
    When : enter the uname "<username>"
    And : Enter Password "<Password>"
    Then : Click login button

    Examples: 
      | username |  | Password   |
      | ranjitk  |  | ranjit7001 |

  @filetrackdate
  Scenario Outline: Verification date
    Given : Open the chrome
    When : passing username "<username1>"
    And : passing Password "<Password1>"
    Then : current date selected or not "<selectdate>" "<Month>" "<year>"
    
    #https://www.trivago.in/

    Examples: 
      | username1 |  | Password1  |  | selectdate | |Month| |year|
      | ranjitk  |  | ranjit7001 |  |         27 | |January| |2019|
      

      
       
