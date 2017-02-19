package com.guifa.goodnews.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * json解析工具类
 */
public class GsonUtil {

    /**
     * @param json json字符串
     * @param cls  要转成的list的类型
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> getListFromJson(String json, Class<T> cls) {
        Gson gson = new Gson();
        ArrayList<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }
}
