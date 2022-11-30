package com.example.datastructre.utils;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

/**
 * JsonUtils, JSON parsing made easy. Simply pass the json object and the path to the key you want, and it will return value if available,
 * otherwise it will return null. Works well with simple JSONObject and Gson's JsonObject.
 */
public class JsonUtils {


    public static Object getJsonObjectForKey(JSONObject jsonObject, String key) {

        Iterator iterator = jsonObject.keys();

        while (iterator.hasNext()) {
            // get key
            String keyName = (String) iterator.next();
            // get value of that key
            try {
                Object object = jsonObject.get(keyName);
                if (key.contains(keyName)) {
                    if (key.contains(".")) {
                        String newKey = key.substring(key.indexOf(".") + 1);
                        if (object instanceof JSONObject) {
                            return getJsonObjectForKey((JSONObject) object, newKey);
                        }
                    } else {
                        return object;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
