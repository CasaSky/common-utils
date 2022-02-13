package com.casasky.core.jackson;


import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.ZoneId;
import java.util.TimeZone;

public class JacksonMapperProvider {

    private JacksonMapperProvider() {
    }

    public static Jackson2ObjectMapperBuilder standardJacksonMapperBuilder() {

        return Jackson2ObjectMapperBuilder.json()
                .modules(new ParameterNamesModule(), new Jdk8Module(), new JavaTimeModule())
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .dateFormat(new StdDateFormat())
                .timeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Berlin")));

    }

}
