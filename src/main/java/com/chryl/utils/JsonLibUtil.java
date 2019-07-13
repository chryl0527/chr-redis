package com.chryl.utils;

import net.sf.json.JSONObject;

/**
 * Json Lib
 * <p>
 * Created By Chr on 2019/6/28.
 */

public class JsonLibUtil {
    /**
     * bean->jsonStr
     *
     * @param obj
     * @return
     */
    public static String bean2Json(Object obj) {
        JSONObject jsonObject = JSONObject.fromObject(obj);
        return jsonObject.toString();
    }

    /**
     * jsonStr->bean
     *
     * @param jsonStr
     * @param objClass
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return (T) JSONObject.toBean(JSONObject.fromObject(jsonStr), objClass);
    }
}