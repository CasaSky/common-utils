package com.casasky.core.config;

import com.casasky.core.jackson.JacksonMapperProvider;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

@Configuration
public class JacksonMapperConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> JacksonMapperProvider.standardJacksonMapperBuilder();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(JacksonMapperProvider.standardJacksonMapperBuilder().build());
    }


    @Bean
    public MessageConverter jackson2MessageConverter(){
        var converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(JacksonMapperProvider.standardJacksonMapperBuilder().build());
        return converter;
    }
}
