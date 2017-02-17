package com.soft1010.common.httpapi;

/**
 * @author
 * create time: 2016-06-24
 * Description: api函数返回结果
 */
public interface ApiResultResolver {

    /**
     * api函数返回结果处理
     *
     * @return
     */
    Object resolveResult(ApiInvocation apiInvocation, Object formatedResult, Class<?> requiredType);
}
