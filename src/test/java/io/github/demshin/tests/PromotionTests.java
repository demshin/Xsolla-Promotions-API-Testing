package io.github.demshin.tests;

import io.github.demshin.models.NewPromotionResponse;
import io.github.demshin.models.Promotion;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.demshin.configuration.TestsConfig.getConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class PromotionTests extends BaseTest {
    private String merchantId;
    private String apiKey;
    private Promotion promotion;

    private NewPromotionResponse newPromotionResponse;

    private int promotion_id;

    public PromotionTests() {
        merchantId = getConfig().getMerchantId();
        apiKey = getConfig().getApiKey();
        promotion = Promotion.getRandomPromotion();
    }

    @Test(description = "Create a new promotion")
    @BeforeMethod
    public void createNewPromotion() {
        newPromotionResponse =
                given().contentType(ContentType.JSON).accept(ContentType.JSON).body(promotion)
                        .when().post("")
          //              .then().assertThat().body(matchesJsonSchemaInClasspath("newPromotionResponse.json"));
                        .as(NewPromotionResponse.class);


        assertTrue(newPromotionResponse.getId() > 0);
        promotion_id = newPromotionResponse.getId();
    }

    @Test(description = "Get the promotion by promotion_id")
    public void getPromotion() {
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("/" + promotion_id)
                .then().statusCode(200).body("promotion_id", equalTo(promotion_id));
    }

    @Test(description = "Update a promotion")
    public void updatePromotion() {
        Promotion promotionForUpdate = Promotion.getRandomPromotion();

        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(promotionForUpdate)
                .when().put("/" + promotion_id)
                .then().statusCode(204);
        //TODO дописать на проверку апдейтнутого
    }

    @Test(description = "Review the promotion")
    public void reviewPromotion() {
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("/" + promotion_id + "/review")
                .then().statusCode(200).body("component", equalTo("[rewards, periods, periods, periods, periods, periods]"));
    }


}
