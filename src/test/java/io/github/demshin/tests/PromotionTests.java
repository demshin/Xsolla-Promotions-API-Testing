package io.github.demshin.tests;

import io.github.demshin.models.NewPromotionResponse;
import io.github.demshin.models.Promotion;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class PromotionTests extends BaseTest {
    private Promotion promotion;
    private NewPromotionResponse newPromotionResponse;
    private int promotion_id;

    public PromotionTests() {
        promotion = Promotion.getRandomPromotion();
    }

    @Test(description = "Create a new promotion")
    @BeforeMethod
    public void createNewPromotion() {
        newPromotionResponse =
                given().contentType(ContentType.JSON).accept(ContentType.JSON).body(promotion)
                        .when().post("")
                        .as(NewPromotionResponse.class);

        assertTrue(newPromotionResponse.getId() > 0);
        promotion_id = newPromotionResponse.getId();
        promotion.setId(newPromotionResponse.toString());
    }

    @Test(description = "Get the promotion by promotion_id")
    public void getPromotion() {
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("/" + promotion_id)
                .then().statusCode(200).body("id", equalTo(promotion_id));
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
                .then().statusCode(200).assertThat().body(matchesJsonSchemaInClasspath("reviewPromotionResponse.json"));
    }


}
