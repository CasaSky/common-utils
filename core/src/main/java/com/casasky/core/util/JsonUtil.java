package com.casasky.core.util;

import com.casasky.core.jackson.JacksonMapperProvider;
import lombok.SneakyThrows;

public class JsonUtil {

    private JsonUtil() {
    }

    @SneakyThrows
    public static <T> String toJson(T object) {
        return JacksonMapperProvider.standardJacksonMapperBuilder().build().writeValueAsString(object);
    }
}
