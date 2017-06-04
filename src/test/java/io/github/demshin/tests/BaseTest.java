package io.github.demshin.tests;

import io.github.demshin.configuration.TestsConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.basic;

public class BaseTest {

    @BeforeClass
    public static void setup() {
        //базовый путь
        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = TestsConfig.getConfig().getBase() + TestsConfig.getConfig().getMerchantId() +
                    TestsConfig.getConfig().getSection();
        }
        RestAssured.basePath = basePath;

        //базовый узел
        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = TestsConfig.getConfig().getHost();
        }
        RestAssured.baseURI = baseHost;

        //аутентификация в каждом запросе
        String username = TestsConfig.getConfig().getMerchantId();
        String password = TestsConfig.getConfig().getApiKey();
        RestAssured.authentication = basic(username, password);
    }
}
