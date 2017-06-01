package io.github.demshin.tests;

import io.github.demshin.configuration.TestsConfig;
import io.github.demshin.models.NewPromotionResponce;
import io.github.demshin.models.Promotion;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class PromotionTests extends BaseTest {

    @Test(description = "Create a new promotion")
    public void createNewPromotion() {
        String merchantId = TestsConfig.getConfig().getMerchantId();
        String apiKey = TestsConfig.getConfig().getApiKey();

        Promotion promotion = Promotion.getRandomPromotion();

        NewPromotionResponce newPromotionResponce =
                given().auth().basic(merchantId, apiKey)
                        .contentType(ContentType.JSON).accept(ContentType.JSON).body(promotion)
                        .when().post("").as(NewPromotionResponce.class);

        assertTrue(newPromotionResponce.getId() > 0);
    }

    @Test
    public void getThePromotion() {

    }
}
