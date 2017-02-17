package com.soft1010.common.httpapi.resolver;

import com.google.gson.*;
import com.soft1010.common.httpapi.ApiInvocation;
import com.soft1010.common.httpapi.ApiResultResolver;
import com.soft1010.common.httpapi.json.GsonDateAdapter;
import com.soft1010.common.httpapi.utils.ApiObjectUtils;
import com.soft1010.common.httpapi.utils.GenericUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author
 * create time: 2016-06-24
 * Description: 默认的result resolver
 */
public class ApiResultJsonResovler implements ApiResultResolver {

    // gson转换工具
    static final Gson GSON =
            new GsonBuilder().serializeNulls().disableHtmlEscaping().registerTypeAdapter(Date.class, new GsonDateAdapter())
                    .create();

    @Override
    public Object resolveResult(ApiInvocation apiInvocation, Object formatedResult, Class<?> requiredType) {

        JsonElement jsonElement = (JsonElement) formatedResult;

        // 如果是基础类型
        if (ApiObjectUtils.isRawType(requiredType)) {
            String result = jsonElement.getAsString();
            return ApiObjectUtils.convertArg(result, requiredType);
        }

        // 如果是jsonElement类型
        else if (JsonElement.class.equals(requiredType)) {
            return jsonElement;
        }
        // jsonObject类型
        else if (JsonObject.class.equals(requiredType)) {
            return jsonElement.getAsJsonObject();
        }
        // 如果是jsonArray
        else if (JsonArray.class.equals(requiredType)) {
            return jsonElement.getAsJsonArray();
        }

        Class<?>[] genericTypes = GenericUtils.getActualClass(apiInvocation.getGenericReturnType());

        // 非泛型
        if (genericTypes.length == 0 || Arrays.equals(genericTypes, GenericUtils.EMPTY_CLASSES)) {
            return GSON.fromJson(jsonElement, requiredType);
        } else {
            if (!apiInvocation.getMethod().getReturnType().isAssignableFrom(List.class)) {
                return GSON.fromJson(jsonElement, apiInvocation.getGenericReturnType());
            }
            return GSON.fromJson(jsonElement, requiredType);
        }
    }
}
