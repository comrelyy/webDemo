package com.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-28
 */


    public class JsonUtil {
        private static final ObjectMapper objectMapper = new ObjectMapper();


        static {
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        private JsonUtil() {
        }

        public static <T> String toJson(T obj) {
            String json = "";
            try {
                json = objectMapper.writeValueAsString(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }

        public static <T> T toObject(String json, Class<T> clazz) {
            T t = null;
            try {
                t = objectMapper.readValue(json, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }
    }

