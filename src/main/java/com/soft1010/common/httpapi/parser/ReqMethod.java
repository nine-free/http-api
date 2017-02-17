package com.soft1010.common.httpapi.parser;

/**
 * @author
 * create time: 2016-06-24
 * Description: http请求方法枚举，目前暂时只支持GET和POST
 */
public enum ReqMethod {

    // enums
    GET, POST;

    public static ReqMethod parse(String method) {
        if ("GET".equalsIgnoreCase(method)) {
            return GET;
        }
        if ("POST".equalsIgnoreCase(method)) {
            return POST;
        }
        return null;
    }
}