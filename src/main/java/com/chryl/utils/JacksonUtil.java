package com.chryl.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Jackson
 * <p>
 * Created By Chr on 2019/6/28.
 */
public class JacksonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * bean->jsonStr
     *
     * @param obj
     * @return
     */
    public static String bean2Json(Object obj) {
        try {
            //对象转化为Json
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * jsonStr->bean
     *
     * @param jsonStr
     * @param objClass
     * @param <T>
     * @return
     */
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        try {
            //Json映射为对象
            return mapper.readValue(jsonStr, objClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
