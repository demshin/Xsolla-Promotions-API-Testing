package io.github.demshin.tests;

import io.github.demshin.configuration.TestsConfig;
import io.github.demshin.models.Promotion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PromotionTests extends BaseTest {
    private int id = 15861;

    @Test(description = "Create a new promotion")
    public void createNewPromotion() {

        String id = TestsConfig.getConfig().getProjectId();
        String merchantId = TestsConfig.getConfig().getMerchantId();
        String apiKey = TestsConfig.getConfig().getApiKey();

       /* Map<String, String> promotion = new HashMap<String, String>();
        promotion.put("technical_name", "Test Promotion");
        promotion.put("label", "{\"en\": \"10% save\"}");
        promotion.put("name", "{\"en\": \"10% save\"}");
        promotion.put("description", "{\"en\": \"10% save\"}");
        promotion.put("project_id", id);*/

        Promotion promotion = Promotion.getRandomPromotion();
        System.out.println("merchant_id = " + merchantId);
        System.out.println("api_key = " + apiKey);
        System.out.println(RestAssured.baseURI + RestAssured.basePath);

        given().auth().basic(merchantId, apiKey)
                .contentType(ContentType.JSON).accept(ContentType.JSON).body(promotion)
                .when().post("")
                .then().statusCode(201).contentType(ContentType.JSON).extract();
    }

   /* @Test
    public void getThePromotion() {
        Response response = RestAssured.get("");

    }*/
}
