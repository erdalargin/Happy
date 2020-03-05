package com.HappyPotter.step_definitions;

import com.HappyPotter.utilities.ConfigurationReader;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class house {

    Response response;
    String uri=ConfigurationReader.get("HappyApiUrl")+"houses";
    String idGr;
    List<Map<String, Object>> houses;
    List<Map<String, Object>> house;
    int map;
    Object members;


    @When("Send a get request to \\/houses. Request includes : Header Accept with value application\\/json, Query param key with value \\{\\{apiKey}}")
    public void send_a_get_request_to_houses_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value() {

        response= given().accept(ContentType.JSON).and().queryParam("key",ConfigurationReader.get("token")).get(uri);
    }

    @Then("Verify status code {int}, content type application\\/json; charset=utf{int}")
    public void verify_status_code_content_type_application_json_charset_utf(int int1, int int2) {
       assertEquals("status code",int1,response.statusCode());
       assertEquals("content type","application/json; charset=utf-8",response.contentType());
     }

    @Then("Capture the id of the Gryffindor house")
    public void capture_the_id_of_the_Gryffindor_house() {

        houses= response.body().as(List.class);
        System.out.println("size: "+houses.size());
        System.out.println("houses = " + houses);

        for(int i=0;i<houses.size();i++){
            if(houses.get(i).get("name").equals("Gryffindor") ){
                idGr=(String) houses.get(i).get("_id");
                map=i;
            }

        }
        System.out.println("idGr = " + idGr);

    }

    @Then("Capture the ids of the all members of the Gryffindor house")
    public void capture_the_ids_of_the_all_members_of_the_Gryffindor_house() {

        members = houses.get(map).get("members");
        System.out.println("members = " + members);

        response=given().accept(ContentType.JSON).pathParam("_id","5a05e2b252f721a3cf2ea33f").queryParam("key",ConfigurationReader.get("token")).and().when().get(uri+"/{_id}");

        System.out.println("idGr = " + idGr);




    }

    @When("Send a get request to \\/houses\\/:id. Request includes : Header Accept with value application\\/json,  Query param key with value \\{\\{apiKey}}, Path param id with value from step {int}")
    public void send_a_get_request_to_houses_id_Request_includes_Header_Accept_with_value_application_json_Query_param_key_with_value_Path_param_id_with_value_from_step(Integer int1) {

        response=given().accept(ContentType.JSON).pathParam("_id","5a05e2b252f721a3cf2ea33f").queryParam("key",ConfigurationReader.get("token")).and().when().get(uri+"/{_id}");
        house= response.body().as(List.class);
        String idGr2=(String)house.get(0).get("_id");
        System.out.println("idGr = " + idGr);
        assertEquals("id",idGr,idGr2);

    }

    @Then("Verify that response contains the same member ids as the step {int}")
    public void verify_that_response_contains_the_same_member_ids_as_the_step(Integer int1) {

        response=given().accept(ContentType.JSON).pathParam("_id","5a05e2b252f721a3cf2ea33f").queryParam("key",ConfigurationReader.get("token")).and().when().get(uri+"/{_id}");
        house= response.body().as(List.class);
        System.out.println(house.get(0).get("members"));



    }

}
