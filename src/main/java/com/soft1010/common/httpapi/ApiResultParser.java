package com.soft1010.common.httpapi;

/**
 * @author
 * create time: 2016-06-24
 * Description: api原始结果转换
 */
public interface ApiResultParser {

    /**
     * 原始结果转换
     *
     * @param apiInvocation
     * @return
     */
    Object parse(ApiInvocation apiInvocation);
}
