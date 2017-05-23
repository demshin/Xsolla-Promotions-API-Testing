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

    @Property("server.port")
    private String port = "";

    @Property("server.base")
    private String base = "";

    @Property("server.host")
    private String host = "";

    public Integer getPort() {
        String portForTests = port;
        if (portForTests != null) {
            return Integer.valueOf(portForTests);
        } else {
            throw new IllegalStateException("Port '" + port + "' is not valid");
        }
    }

    public String getBase() {
        String baseForTests = base;
        if (baseForTests != null) {
            return baseForTests;
        } else {
            throw new IllegalStateException("Base '" + base + "' is not valid");
        }
    }

    public String getHost() {
        String hostForTests = host;
        if (hostForTests != null) {
            return hostForTests;
        } else {
            throw new IllegalStateException(("Host '" + host + "' is not valid"));
        }
    }
}
