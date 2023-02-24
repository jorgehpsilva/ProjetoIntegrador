package com.example.RentCars.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RentCarsUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String asJsonString(final Object obj) {
        try{
            return mapper.writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException();
        }
    }

    public static <T> T objectFromString(Class<T> aClass, String value) {
        try {
            return mapper.readValue(value, aClass);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
