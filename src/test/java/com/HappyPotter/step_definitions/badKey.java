package com.HappyPotter.step_definitions;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import com.HappyPotter.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class badKey {
    String token= ConfigurationReader.get("token");
    Response response;
    String url;


    @Given("WhenHeader Accept with value application\\/json, Query param key with value {string},Send a get request to \\/characters")
    public void whenheader_Accept_with_value_application_json_Query_param_key_with_value_Send_a_get_request_to_characters(String string) {
        String uri=ConfigurationReader.get("HappyApiUrl")+"characters";

        response=given().accept(ContentType.JSON).and()
            .queryParam("key",string).and()
            .get(uri);


     }


    @Then("Status code shoul be {int}")
    public void status_code_shoul_be(int int1) {


        assertEquals("message status code",int1,response.statusCode());


    }

    @Then("Response status line include message {string}")
    public void response_status_line_include_message(String string) {

        assertTrue("message line",response.statusLine().contains(string));

     }

    @Then("Response body says {string}: {string}")
    public void response_body_says(String string, String string2) {

        String expected="error\":\"API Key Not Found\"" ;
            //assertEquals("body check", "\"error\":\"API Key Not Found\"",response.body().asString());
        assertTrue("body check",response.body().asString().contains(expected));

     }




}
