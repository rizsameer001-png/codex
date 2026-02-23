package com.automationexercise.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public final class TestDataReader {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private TestDataReader() {
    }

    public static JsonNode get(String path) {
        try (InputStream input = TestDataReader.class.getClassLoader().getResourceAsStream(path)) {
            if (input == null) {
                throw new IllegalArgumentException("Test data file not found: " + path);
            }
            return MAPPER.readTree(input);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to parse test data file: " + path, e);
        }
    }
}
