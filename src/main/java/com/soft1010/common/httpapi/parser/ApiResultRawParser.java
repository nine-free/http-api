package com.soft1010.common.httpapi.parser;

import com.soft1010.common.httpapi.ApiInvocation;
import com.soft1010.common.httpapi.utils.ApiObjectUtils;

/**
 * @author
 * create time: 2016-06-24
 * Description: 基本类型转换器
 */
public class ApiResultRawParser extends AbstractApiResultParser {
    @Override
    public Object parseRawObject(ApiInvocation apiInvocation) {
        return apiInvocation.getRawResult();
    }

    @Override
    public Object resolveResult(ApiInvocation apiInvocation, Object result) {
        return ApiObjectUtils.convertArg(result.toString(), apiInvocation.getMethod().getReturnType());
    }

    @Override
    public Boolean validateResult(ApiInvocation apiInvocation, Object rawObject) {
        return Boolean.TRUE;
    }
}
