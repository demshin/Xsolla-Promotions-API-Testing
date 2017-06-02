package io.github.demshin.tests;

import io.github.demshin.models.NewPromotionResponce;
import io.github.demshin.models.Promotion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.demshin.configuration.TestsConfig.getConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertTrue;

public class PromotionTests extends BaseTest {
    private String merchantId;
    private String apiKey;
    private Promotion promotion;

    private NewPromotionResponce newPromotionResponce;

    private int id;

    public PromotionTests() {
        merchantId = getConfig().getMerchantId();
        apiKey = getConfig().getApiKey();
        promotion = Promotion.getRandomPromotion();
    }

    @Test(description = "Create a new promotion")
    @BeforeMethod
    public void createNewPromotion() {
        newPromotionResponce =
                given().auth().basic(merchantId, apiKey)
                        .contentType(ContentType.JSON).accept(ContentType.JSON).body(promotion)
                        .when().post("").as(NewPromotionResponce.class);

        assertTrue(newPromotionResponce.getId() > 0);
        id = newPromotionResponce.getId();
    }

    @Test(description = "Get the promotion by id")
    public void getThePromotion() {
        RestAssured.basePath = RestAssured.basePath + "/" + id;

        given().auth().basic(merchantId, apiKey)
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get()
                .then().statusCode(200).body("id", equalTo(id));
    }
}
