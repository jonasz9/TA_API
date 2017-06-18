package com.test.restAssured;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.mapper.ObjectMapperDeserializationContext;
import com.jayway.restassured.mapper.ObjectMapperSerializationContext;
import com.jayway.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Janek on 2017-06-16.
 */
public class testWithGET {

    Response responseGET;
    String responseBody;


    @Test
    public void testGET() throws URISyntaxException {

        baseURI = ("http://jsonplaceholder.typicode.com");

        responseGET=
                given().contentType(ContentType.JSON).
                        when().get("/comments").
                        then().statusCode(200).
                        and().body("size()", Matchers.greaterThan(0)).
                        and().body("email", Matchers.hasItem("Jayne_Kuhic@sydney.com")).
                        extract().
                        response();

        responseBody = responseGET.asString();
//        System.out.println(responseBody);

    }

//    ArrayList<Comment> commentList = deserialize

}
