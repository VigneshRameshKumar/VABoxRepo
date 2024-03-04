package com.jetbrains.marco.photozclone.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelperClass {

    public String removeQuotes(String input) {
        // Replace all occurrences of double quotes with an empty string
        return input.replace("\"", "");
    }
}
