@all
Feature: Phase End project
	
  Scenario: Star health home page test
    Given User open the chrome browser and starhealth application
    Then validates the Star Health home page title using a JUnit assertion
    Then clicks on the Buy Now button
    And User enters following details
      | Name     | PhoneNo    | PIN    |
      | Admin    | 4893973912 | 600012 |
      | StarUser | 9673636268 | 600034 |
    And User clicks on the Star Health logo
    And Close all the browsers
    
    
