package com.PZ.AnkietBud.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ShortDateObjectMapper extends ObjectMapper {

    public ShortDateObjectMapper() {
        super();
//        setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        registerModule(new JavaTimeModule());
    }
}