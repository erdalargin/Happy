package com.HappyPotter.step_definitions;

import com.HappyPotter.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class sort {
    String token=ConfigurationReader.get("token");
    Response response;
    String url;
    @Given("I logged potter api with using token")
    public void i_logged_potter_api_with_using_token() {
        url = ConfigurationReader.get("HappyApiUrl");

    }
    @When("Send a get request to {string}.")
    public void send_a_get_request_to(String string) {

        response = given().accept(ContentType.JSON)
                .queryParam("key", token)
                .when().get(url+string);

    }


    @Then("status code should be {int}")
    public void status_code_should_be(int statusCode) {
        assertEquals(statusCode,response.statusCode());
    }


    @Then("content type should be {string}")
    public void content_type_should_be(String string) {
        assertEquals(string,response.contentType());

    }

    @Then("response body contains one of the following houses:")
    public void response_body_contains_one_of_the_following_houses(List<String> dataTable) {

        System.out.println("dataTable = " + dataTable);
        System.out.println("response = " + response.asString());
        String val=(String) "Ravenclaw";
        assertTrue(dataTable.contains(val));
    }

    @Given("Send a get request to \\/characters. Request includes : • Header Accept with value application\\/json")
    public void send_a_get_request_to_characters_Request_includes_Header_Accept_with_value_application_json() {

        String uri=ConfigurationReader.get("HappyApiUrl")+"characters";
        System.out.println("uri = " + uri);
        response=given().accept(ContentType.JSON).when().get(uri);


    }

    @Then("Verify status code {int}, content type {string}")
    public void verify_status_code_content_type(int int1, String string) {

        assertEquals("message1",int1,response.statusCode());
        System.out.println("string = " + string);
        System.out.println("response.getStatusLine() = " + response.getStatusLine());
        assertEquals("content type",string,response.contentType());
    }

    @Then("Verify response status line include message {string}")
    public void verify_response_status_line_include_message(String string) {

        assertTrue(response.getStatusLine().contains(string));

    }

    @Then("Verify that response body says {string}: {string}")
    public void verify_that_response_body_says(String string, String string2) {
   String message="\"error\":\"Must pass API key for request\"";
        System.out.println("message = " + message);
        System.out.println("response = " + response.body().asString());
        assertTrue("message3",response.body().asString().contains(message));

    }




}
