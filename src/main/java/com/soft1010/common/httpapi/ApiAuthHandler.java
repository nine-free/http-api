package com.soft1010.common.httpapi;


import org.apache.http.NameValuePair;

import java.util.List;

/**
 * @author
 * create time: 2016-06-24
 * Description: api鉴权功能
 */
public interface ApiAuthHandler {

    /**
     * 处理鉴权
     *
     * @param params
     */
    void handleSign(List<NameValuePair> params, List<NameValuePair> headers);
}
