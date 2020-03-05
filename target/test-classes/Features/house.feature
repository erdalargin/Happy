Feature:
  @wip
  Scenario:Verify house members
     When Send a get request to /houses. Request includes : Header Accept with value application/json, Query param key with value {{apiKey}}
    Then Verify status code 200, content type application/json; charset=utf-8
    And Capture the id of the Gryffindor house
    And Capture the ids of the all members of the Gryffindor house
    When Send a get request to /houses/:id. Request includes : Header Accept with value application/json,  Query param key with value {{apiKey}}, Path param id with value from step 3
    Then Verify that response contains the same member ids as the step 4

