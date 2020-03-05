package com.HappyPotter.step_definitions;

import com.HappyPotter.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class characters {

    Response response;
    Response  response1;
    String uri=ConfigurationReader.get("HappyApiUrl")+"characters";
    private Object List;
    String CharName;
    String CharId;
    String Charhouse;
    String CharSchool;
    boolean ChardeathEater;


    @When("I logged potter api characters by Request includes : Header Accept with value application\\/json, Query param key with value apiKey")
    public void i_logged_potter_api_characters_by_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value_apiKey() {

        response = given().accept(ContentType.JSON)
                .queryParam("key", ConfigurationReader.get("token"))
                .when().get(uri);
    }

    @Then("Verify character status code {int}, content type {string}")
    public void verify_character_status_code_content_type(int int1, String string) {

   assertEquals("status",int1,response.statusCode());
   assertEquals("content type", string, response.contentType());
    }
    @Then("Verify response contains {int} characters")
    public void verify_response_contains_characters(int int1) {

        List<Map<String,Object>> characters = response.body().as(List.class);

        System.out.println("characters.size() = " + characters.size());
        assertEquals("size",int1,characters.size());

     }

    @Then("Verify all characters in the response have id field which is not empty")
    public void verify_all_characters_in_the_response_have_id_field_which_is_not_empty() {

        List<Map<String, Object>> characters = response.body().as(List.class);

        System.out.println("characters.size() = " + characters.size());
        System.out.println(characters.get(1));
        System.out.println(characters.get(2));
        System.out.println(characters.get(22));
        System.out.println(characters.get(194));

        for (Map<String, Object> character : characters) {
            assertTrue("key id", character.containsKey("_id"));
            assertTrue("null id", character.get("_id") != null);

        }}

    @Then("Verify that value type of the field dumbledoresArmy is a boolean in all characters in the response")
    public void verify_that_value_type_of_the_field_dumbledoresArmy_is_a_boolean_in_all_characters_in_the_response() {
        List<Map<String, Object>> characters = response.body().as(List.class);

        System.out.println("characters.size() = " + characters.size());

        for (Map<String, Object> character : characters) {
            assertTrue("key id", character.containsKey("dumbledoresArmy"));
            assertTrue("boolean", character.get("dumbledoresArmy").equals(true)||character.get("dumbledoresArmy").equals(false));

        }}

    @Then("Verify value of the house in all characters in the response is one of the following:")
    public void verify_value_of_the_house_in_all_characters_in_the_response_is_one_of_the_following(List<String> dataTable) {

        List<Map<String, Object>> characters = response.body().as(List.class);

        System.out.println("characters.size() = " + characters.size());

        for (Map<String, Object> character : characters) {
        if(character.containsKey("house")){
            assertTrue("house",dataTable.contains(character.get("house")));
        } }
    }

    @When("Select name of any random character")
    public void select_name_of_any_random_character() {
        List<Map<String, Object>> characters = response.body().as(List.class);
        Random rn= new Random();
        int RC= rn.nextInt(195);

        CharName=(String)characters.get(RC).get("name");
        System.out.println("RC = " + RC);
        System.out.println("CharName = " + CharName);
        CharId=(String)characters.get(RC).get("_id");
        System.out.println("CharId = " + CharId);
        Charhouse=(String)characters.get(RC).get("house");
        System.out.println("Charhouse = " + Charhouse);
        CharSchool = (String)characters.get(RC).get("school");
        System.out.println("CharSchool = " + CharSchool);
        ChardeathEater=(boolean)characters.get(RC).get("deathEater");
        System.out.println("ChardeathEater = " + ChardeathEater);


    }

    @When("Send a get request to \\/characters. Request includes: Header Accept with value application\\/json • Query param key with value \\{\\{apiKey}}, Query param name with value from step {int}")
    public void send_a_get_request_to_characters_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value_Query_param_name_with_value_from_step(Integer int1) {

       response1=given().accept(ContentType.JSON).and().queryParam("key",ConfigurationReader.get("token")).and().queryParam("name",CharName).get(uri);


    }

    @Then("Verify that response contains the same character information from step {int}. Compare all fields.")
    public void verify_that_response_contains_the_same_character_information_from_step_Compare_all_fields(Integer int1) {

        List<Map<String, Object>> characters = response1.body().as(List.class);
        for (Map<String, Object> character : characters) {
            System.out.println("character = " + character);
        }


        System.out.println(characters.get(0).get("_id"));
        Assert.assertEquals("CharId2",CharId,(String) characters.get(0).get("_id"));

        System.out.println(characters.get(0).get("house"));
        Assert.assertEquals("Charhouse2",Charhouse,(String) characters.get(0).get("house"));

        System.out.println(characters.get(0).get("school"));
        Assert.assertEquals("CharSchool2",CharSchool,(String) characters.get(0).get("school"));

        System.out.println(characters.get(0).get("deathEater"));
        Assert.assertEquals("ChardeathEater2",ChardeathEater,(boolean)characters.get(0).get("deathEater"));


    }

    @Given("Send a get request to \\/characters. Request includes : • Header Accept with value application\\/json, Query param key with value \\{\\{apiKey}}, Query param name with value {string}")
    public void send_a_get_request_to_characters_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value_Query_param_name_with_value(String string) {

        response=given().accept(ContentType.JSON).queryParam("name","Harry Potter").queryParam("key",ConfigurationReader.get("token")).and().get(uri);
    }

    @Then("Verify name {string}")
    public void verify_name(String string) {

        String expectedName=string;
        System.out.println("expectedName = " + expectedName);

        List<Map<String, Object>> characters = response.body().as(List.class);
        for (Map<String, Object> character : characters) {
            System.out.println("character = " + character);
        }

        System.out.println(characters.get(0).get("name"));
        Assert.assertEquals("name Harry Pottrer",string,(String)characters.get(0).get("name"));

    }
    @When("Send a get request to \\/characters. Request includes : • Header Accept with value application\\/json, Query param key with value \\{\\{apiKey}}, Query param name with value as {string}")
    public void send_a_get_request_to_characters_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value_Query_param_name_with_value_as(String string) {
        response=given().accept(ContentType.JSON).queryParam("name","Marry Potter").queryParam("key",ConfigurationReader.get("token")).and().get(uri);

    }

    @Then("Verify response body is empty")
    public void verify_response_body_is_empty() {

        List<Map<String, Object>> characters = response.body().as(List.class);
        for (Map<String, Object> character : characters) {
            System.out.println("character = " + character);
        }
        int size = characters.size();
        System.out.println("size = " + size);
        assertEquals("size",0, characters.size());

    }



}
