$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/house.feature");
formatter.feature({
  "name": "",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify house members",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Send a get request to /houses. Request includes : Header Accept with value application/json, Query param key with value {{apiKey}}",
  "keyword": "When "
});
formatter.match({
  "location": "house.send_a_get_request_to_houses_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify status code 200, content type application/json; charset\u003dutf-8",
  "keyword": "Then "
});
formatter.match({
  "location": "house.verify_status_code_content_type_application_json_charset_utf(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Capture the id of the Gryffindor house",
  "keyword": "And "
});
formatter.match({
  "location": "house.capture_the_id_of_the_Gryffindor_house()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Capture the ids of the all members of the Gryffindor house",
  "keyword": "And "
});
formatter.match({
  "location": "house.capture_the_ids_of_the_all_members_of_the_Gryffindor_house()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send a get request to /houses/:id. Request includes : Header Accept with value application/json,  Query param key with value {{apiKey}}, Path param id with value from step 3",
  "keyword": "When "
});
formatter.match({
  "location": "house.send_a_get_request_to_houses_id_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value_Path_param_id_with_value_from_step(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify that response contains the same member ids as the step 4",
  "keyword": "Then "
});
formatter.match({
  "location": "house.verify_that_response_contains_the_same_member_ids_as_the_step(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});