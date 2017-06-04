package io.github.demshin.tests;

import io.github.demshin.models.NewPromotionResponse;
import io.github.demshin.models.Promotion;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
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
        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("/" + promotion_id + "/review")
                .then().statusCode(200).extract().response();

        //проверяем размер ответа
        String jsonAsString = response.asString();
        ArrayList<Map<String, ?>> jsonAsArrayList = from(jsonAsString).get("");
        assertThat(jsonAsArrayList.size(), equalTo(6));

        //проверяем содержание поля "component" ответа
        List<String> errorsComponent = response.path("component");
        for (int i = 0; i < errorsComponent.size(); i++) {
            if (i != 0) {
                assertThat(errorsComponent.get(i), equalTo("periods"));
            } else {
                assertThat(errorsComponent.get(i), equalTo("rewards"));
            }
        }
    }
}
