Feature:

  Scenario:Verify bad key
    Given I logged potter api with using token
    And WhenHeader Accept with value application/json, Query param key with value "invalid",Send a get request to /characters
    Then Status code shoul be 401
    And Response status line include message "Unauthorized"
    And Response body says "error": "API Key Not Found"



