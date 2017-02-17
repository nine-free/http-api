package com.soft1010.common.httpapi.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.soft1010.common.httpapi.utils.GsonValueUtils;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author
 * @version gson对date进行特殊处理
 */
public class GsonDateAdapter implements JsonDeserializer<Date> {

    /**
     * @param json
     *            JsonElement
     * @param typeOfT
     *            Type
     * @param context
     *            JsonDeserializationContext
     * @throws JsonParseException
     *             Json解析异常(gson)
     * @return Date
     */
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if(json != null && !json.isJsonNull()){
            return GsonValueUtils.getAsDate(json.getAsString());
        }
        return null;
    }
}
