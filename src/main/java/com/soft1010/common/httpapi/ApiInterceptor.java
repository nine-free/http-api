package com.soft1010.common.httpapi;

import org.apache.http.NameValuePair;

import java.lang.reflect.Method;

/**
 * @author
 * create time: 2016-06-24
 * Description: api的拦截器
 */
public interface ApiInterceptor extends Comparable<ApiInterceptor> {

    /**
     * http调用结束后调用的方法
     *
     * @param httpStatus
     * @param requestUrl
     * @param nameValuePairs
     * @param responseContent
     * @param replyTime
     */
    void afterCompletion(int httpStatus, Method method, String requestUrl, NameValuePair[] nameValuePairs,
                         String responseContent, Long replyTime);

    /**
     * 拦截器执行顺序
     *
     * @return
     */
    int getOrder();
}
