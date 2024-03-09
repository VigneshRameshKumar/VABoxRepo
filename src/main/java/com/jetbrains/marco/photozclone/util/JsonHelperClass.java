package com.jetbrains.marco.photozclone.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelperClass {


    public String removeQuotes(String input) {
        // Replace all occurrences of double quotes with an empty string
        return input.replace("\"", "");
    }
    public static void delayInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Handle interruption if needed
        }
    }
}
