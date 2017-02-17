package com.soft1010.common.httpapi;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.soft1010.common.httpapi.parser.ContentType;
import com.soft1010.common.httpapi.parser.ReqMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author
 *         create time: 2016-06-24
 *         Description:  http method 简单工厂
 */
public final class HttpMethodFactory {

    /**
     * 不能实例化
     */
    private HttpMethodFactory() {
    }

    /**
     * 根据string获取http method
     *
     * @param method
     * @return
     */
    public static HttpUriRequest createHttpMethod(ReqMethod method, String url, RequestConfig requestConfig,
                                                  List<NameValuePair> headers, NameValuePair[] nameValuePairs,
                                                  String rawData, ContentType contentType,
                                                  Map<String, Object> jsonParams) throws UnsupportedEncodingException {

        // 验证参数
        if (null == method) {
            throw new IllegalArgumentException("[http api]cann't create method,missing method name");
        }
        if (contentType != null && contentType == ContentType.URLENCODED) {
            return createHttpMethod(method, url, requestConfig, headers, nameValuePairs, rawData);
        }
        RequestBuilder requestBuilder;
        requestBuilder = RequestBuilder.post();
        requestBuilder.setUri(url).setConfig(requestConfig);
        StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(jsonParams),"utf-8");
        stringEntity.setContentType(ContentType.JSON.getValue());
        requestBuilder.setEntity(stringEntity);

        if (!StringUtils.isEmpty(rawData)) {
            requestBuilder.setEntity(new StringEntity(rawData));
        }
        // http的header
        if (null != headers) {
            for (NameValuePair header : headers) {
                requestBuilder.addHeader(header.getName(), header.getValue());
            }
        }
        return requestBuilder.build();
    }

    public static HttpUriRequest createHttpMethod(ReqMethod method, String url, RequestConfig requestConfig,
                                                  List<NameValuePair> headers, NameValuePair[] nameValuePairs,
                                                  String rawData) throws UnsupportedEncodingException {

        RequestBuilder requestBuilder;

        if (method == ReqMethod.GET) {
            requestBuilder = RequestBuilder.get();
            requestBuilder.setUri(url).addParameters(nameValuePairs).setConfig(requestConfig);

        } else if (method == ReqMethod.POST) {
            requestBuilder = RequestBuilder.post();
            requestBuilder.setUri(url).setConfig(requestConfig);
            requestBuilder.setEntity(new UrlEncodedFormEntity(Lists.newArrayList(nameValuePairs), HTTP.UTF_8));
        } else {
            // 未知http方法
            throw new IllegalArgumentException("[http api]cann't create method,unrecognized method name,method:" +
                    method);
        }

        if (!StringUtils.isEmpty(rawData)) {
            requestBuilder.setEntity(new StringEntity(rawData));
        }
        // http的header
        if (null != headers) {
            for (NameValuePair header : headers) {
                requestBuilder.addHeader(header.getName(), header.getValue());
            }
        }
        return requestBuilder.build();
    }


}
