package com.zuehlke;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;



/**
 * Created by urzy on 10.05.2017.
 */
// Feign RestClientFactory
public class RestClientFactory {

    public static <T> T createClientWithFallback(String url, Class<T> clazz, T fallback) {
        return createClient().target(clazz, url, fallback);
    }

    public static <T> T createClientWithoutFallback(String url, Class<T> clazz) {
        return createClient().target(clazz, url);
    }

    public static <T> HystrixFeign.Builder createClient() {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);


        return HystrixFeign.builder()
                .decoder(new JacksonDecoder(mapper))
                .logger(new Slf4jLogger(RestClientFactory.class))
                .logLevel(Logger.Level.FULL);
    }
}
