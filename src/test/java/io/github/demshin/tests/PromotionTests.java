package io.github.demshin.tests;

import io.github.demshin.configuration.TestsConfig;
import io.github.demshin.models.*;
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
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class PromotionTests extends BaseTest {
    private Promotion promotion;
    private int promotion_id;
    private String project_id;

    public PromotionTests() {
        promotion = Promotion.getRandomPromotion();
        project_id = TestsConfig.getConfig().getProjectId();
    }

    @Test(description = "Create a new promotion")
    @BeforeMethod
    public void createNewPromotion() {
        NewPromotionResponse newPromotionResponse = given().contentType(ContentType.JSON).body(promotion)
                .when().post("")
                .as(NewPromotionResponse.class);

        assertTrue(newPromotionResponse.getId() > 0);
        promotion_id = newPromotionResponse.getId();
        promotion.setId(newPromotionResponse.toString());
    }

    @Test(description = "Get the promotion by promotion_id")
    public void getPromotion() {
        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id)
                .then().statusCode(200).body("id", equalTo(promotion_id));
    }

    @Test(description = "Update a promotion")
    public void updatePromotion() {
        //обновляем акцию
        Promotion promotionForUpdate = Promotion.getRandomPromotion();
        given().contentType(ContentType.JSON).body(promotionForUpdate)
                .when().put("/" + promotion_id)
                .then().statusCode(204);

        //получаем обновленную акцию и проверяем, что она обновилась
        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id)
                .then().body("technical_name", equalTo(promotionForUpdate.getTechnical_name()));
    }

    @Test(description = "Review the promotion")
    public void reviewPromotion() {
        Response response = given().contentType(ContentType.JSON)
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

    @Test(description = "Toggle the promotion")
    public void togglePromotion() {

        given().contentType(ContentType.JSON)
                .when().put("/" + promotion_id + "/toggle")
                .then().statusCode(204);
        //
    }

    @Test(description = "Delete a promotion")
    public void deletePromotion() {
        //удаляем акцию
        given().contentType(ContentType.JSON)
                .when().delete("/" + promotion_id)
                .then().statusCode(204);

        //проверяем, что акция удалена (ошибка 404)
        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id)
                .then().statusCode(404);
    }

    @Test(description = "List all promotions")
    public void listAllPromotions() {
        given().contentType(ContentType.JSON)
                .when().get("")
                .then().statusCode(200);
    }

    @Test(description = "Get the subject of the promotion")
    public void getSubject() {
        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id + "/subject")
                .then().statusCode(200).body("purchase", equalTo(true))
                .body("items", equalTo(null))
                .body("packages", equalTo(null))
                .body("digital_contents", equalTo(null));
    }

    @Test(description = "Set the subject of the promotion")
    public void setSubject() {
        Subject subject = Subject.getRandomSubject();
        given().contentType(ContentType.JSON).body(subject)
                .when().put("/" + promotion_id + "/subject")
                .then().statusCode(204);

        /*тест падает, т.к. нет корректных данных:
        "Subscription plan with id = 1 is not found.",
        "Subscription product with id = 1 is not found."*/
    }

    @Test(description = "Get the payment systems of the promotion")
    public void getPaymentSystems() {
        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id + "/payment_systems")
                .then().statusCode(200).body("id", equalTo(promotion_id));
    }

    @Test(description = "Set the payment systems of the promotion")
    public void setPaymentSystems() {
        PaymentSystems paymentSystems = PaymentSystems.getRandomPaymentSystems();

        given().contentType(ContentType.JSON).body(paymentSystems)
                .when().put("/" + promotion_id + "/payment_systems")
                .then().statusCode(204);

        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id + "/payment_systems")
                .then().body("id", equalTo(promotion_id))
                .body("payment_systems.id", contains(26));
    }

    @Test(description = "Get the periods of the promotion")
    public void getPeriods() {
        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id + "/periods")
                .then().statusCode(200);
        //todo валидацию!
    }

    @Test(description = "Set the periods of the promotion")
    public void setPeriods() {
        Periods periods = Periods.getRandomPeriods();

        given().contentType(ContentType.JSON)
                .when().put("/" + promotion_id + "/periods")
                .then().statusCode(204);
        //todo валидацию!
    }

    @Test(description = "Get the rewards of the promotion")
    public void getRewards() {
        given().contentType(ContentType.JSON)
                .when().get("/" + promotion_id + "/rewards")
                .then().statusCode(200);
    }

    @Test(description = "Set the rewards to the promotion")
    public void setRewards() {
        Rewards rewards = Rewards.getRandomRewards();
        System.out.println(rewards.toString());

        given().contentType(ContentType.JSON).body(rewards)
                .when().put("/" + promotion_id + "/rewards")
                .then().statusCode(204);
        //тест составлен по документации, но он падает, т.к. не соотвествует
    }
}
