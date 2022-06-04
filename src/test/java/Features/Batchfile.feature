@FullBatchfile
Feature: Home Page

  # Background: User is on login page
  @loginscenrio
  Scenario Outline: Verification of Login functionlity
    Given : Open the firefox1
    When : enter the uname1 "<username>"
    And : Enter Password1 "<Password>"
    Then : Click login button1

    Examples: 
      | username  |  | Password   |
      | ranjitk@@ |  | ranjit7001 |

  @shital
  Scenario Outline: Verfication for table data
    Given : User enter username and password "<username>" and "<Password>"
    When : User click on button
    Then : Verify the data in table

    Examples: 
      | username |  | Password   |
      | ranjitk  |  | ranjit7001 |

  @dateverify
  
  Scenario Outline: Date
    Given :Is on main page
    When :Click current date
    Then :Selected date current date or not
    
    Examples:
    | datetime     |
    | 2 march 2019 |

