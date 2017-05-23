package io.github.demshin.tests;

/*
import io.restassured.RestAssured;
import io.restassured.response.Response;
*/

import io.github.demshin.configuration.TestsConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    final static String merchantId = "22174";

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = TestsConfig.getConfig().getPort();
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = TestsConfig.getConfig().getBase();
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = TestsConfig.getConfig().getHost();
        }
        RestAssured.baseURI = baseHost;

        //mvn test -Dserver.port=80 -Dserver.host=https://api.xsolla.com - запуск из командной строки
    }
}
