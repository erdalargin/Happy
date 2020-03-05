Feature:


  Scenario:Verify number of characters

    When I logged potter api characters by Request includes : Header Accept with value application/json, Query param key with value apiKey
    Then Verify character status code 200, content type "application/json; charset=utf-8"
    And Verify response contains 195 characters


    Scenario: Verify number of character id and house
      Given I logged potter api characters by Request includes : Header Accept with value application/json, Query param key with value apiKey
      Then Verify character status code 200, content type "application/json; charset=utf-8"
      Then  Verify all characters in the response have id field which is not empty
      And Verify that value type of the field dumbledoresArmy is a boolean in all characters in the response
      And Verify value of the house in all characters in the response is one of the following:
          |Gryffindor| Ravenclaw| Slytherin | Hufflepuff|

    Scenario:Verify all character information
      Given I logged potter api characters by Request includes : Header Accept with value application/json, Query param key with value apiKey
      Then Verify character status code 200, content type "application/json; charset=utf-8"
      When Select name of any random character
      And  Send a get request to /characters. Request includes: Header Accept with value application/json • Query param key with value {{apiKey}}, Query param name with value from step 3
      Then  Verify that response contains the same character information from step 3. Compare all fields.

  Scenario:Verify name search
    Given Send a get request to /characters. Request includes : • Header Accept with value application/json, Query param key with value {{apiKey}}, Query param name with value "Harry Potter"
    Then Verify character status code 200, content type "application/json; charset=utf-8"
    And  Verify name "Harry Potter"


  Scenario:Verify name search 2
    When Send a get request to /characters. Request includes : • Header Accept with value application/json, Query param key with value {{apiKey}}, Query param name with value as "Marry Potter"
    Then Verify character status code 200, content type "application/json; charset=utf-8"
    And Verify response body is empty








