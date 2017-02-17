package com.soft1010.common.httpapi.auth;


import com.soft1010.common.httpapi.ApiAuthHandler;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * @author
 * @version api鉴权handler，不做任何处理
 */
public class ApiVoidAuthHandler implements ApiAuthHandler {
    @Override
    public void handleSign(List<NameValuePair> params, List<NameValuePair> headers) {}
}
