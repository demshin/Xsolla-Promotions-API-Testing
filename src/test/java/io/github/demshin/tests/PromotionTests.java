package io.github.demshin.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PromotionTests extends BaseTest{

    @Test
    public void simplePing() {
        given().when().get("").then().statusCode(404);
    }


    @Test(description = "Create a new promotion")
    public void createNewPromotion() {

        /*given().
                contentType("applivation/json").
                body("{\"technical_name\": \"Sample Promotion\",\n" +
                        "        \"label\": {\n" +
                        "            \"en\": \"30% SAVE\"\n" +
                        "        },\n" +
                        "        \"name\": {\n" +
                        "            \"en\": \"30% PayPal Discount\"\n" +
                        "        },\n" +
                        "        \"description\": {\n" +
                        "            \"en\": \"30% PayPal Discount Sample\"\n" +
                        "        },\n" +
                        "        \"project_id\": 1} ").
        when().
                post("https://api.xsolla.com/merchant/merchants/" + merchantId + "/promotions").
        then().
                statusCode(200).
                extract().response();*/
    }

   /* @Test
    public void getThePromotion() {
        Response response = RestAssured.get("");

    }*/
}
