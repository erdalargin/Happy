
Feature:

  Scenario:sorting hat
    Given I logged potter api with using token
    When Send a get request to "sortingHat".
    Then status code should be 200
    And content type should be "application/json; charset=utf-8"
    And response body contains one of the following houses:
       |Gryffindor |Ravenclaw| Slytherin| Hufflepuff|


  Scenario: Verify no key

     And Send a get request to /characters. Request includes : • Header Accept with value application/json
      Then Verify status code 409, content type "application/json; charset=utf-8"
      And Verify response status line include message "Conflict"
      And Verify that response body says "error": "Must pass API key for request"

