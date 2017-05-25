package io.github.demshin.tests;

import io.github.demshin.configuration.TestsConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            port = TestsConfig.getConfig().getPort();
        }
        RestAssured.port = Integer.valueOf(TestsConfig.getConfig().getPort());

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = TestsConfig.getConfig().getBase() + TestsConfig.getConfig().getMerchant() + "/" +
                    TestsConfig.getConfig().getSection() + "/";
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
