package com.automationexercise.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class FrameworkConfig {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = FrameworkConfig.class.getClassLoader().getResourceAsStream("framework.properties")) {
            if (input != null) {
                PROPERTIES.load(input);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load framework.properties", e);
        }
    }

    private FrameworkConfig() {
    }

    public static String get(String key, String defaultValue) {
        return System.getProperty(key, PROPERTIES.getProperty(key, defaultValue));
    }
}
