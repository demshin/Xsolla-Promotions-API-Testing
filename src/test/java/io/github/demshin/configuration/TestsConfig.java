package io.github.demshin.configuration;

import io.github.demshin.configuration.properties.PropertiesLoader;
import io.github.demshin.configuration.properties.Property;
import io.github.demshin.configuration.properties.PropertyFile;

@PropertyFile("config.properties")
public class TestsConfig {
    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    @Property("server.base")
    private String base = "";

    @Property("server.host")
    private String host = "";

    @Property("merchant_id")
    private String merchantId = "";

    @Property("section")
    private String section = "";

    @Property("project_id")
    private String projectId = "";

    @Property("api_key")
    private String apiKey = "";

    public String getBase() {
        String baseForTests = base;
        if (baseForTests != null) {
            return baseForTests;
        } else {
            throw new IllegalStateException("Base is not valid");
        }
    }

    public String getHost() {
        String hostForTests = host;
        if (hostForTests != null) {
            return hostForTests;
        } else {
            throw new IllegalStateException("Host is not valid");
        }
    }

    public String getMerchantId() {
        String merchantForTests = merchantId;
        if (merchantForTests != null) {
            return merchantForTests;
        } else {
            throw new IllegalStateException("Merchant is not valid");
        }
    }

    public String getSection() {
        String sectionForTests = section;
        if (sectionForTests != null) {
            return sectionForTests;
        } else {
            throw new IllegalStateException("Section is not valid");
        }
    }

    public String getProjectId() {
        String projectIdForTests = projectId;
        if (projectIdForTests != null) {
            return projectIdForTests;
        } else {
            throw new IllegalStateException("ProjectID is not valid");
        }
    }

    public String getApiKey() {
        String apiKeyForTests = apiKey;
        if (apiKeyForTests != null) {
            return apiKeyForTests;
        } else {
            throw new IllegalStateException("ApiKey is not valid");
        }
    }


}
