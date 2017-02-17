package com.soft1010.common.httpapi.test;

import com.soft1010.common.httpapi.annotation.ApiInfo;
import com.soft1010.common.httpapi.annotation.ApiParam;
import com.soft1010.common.httpapi.parser.ContentType;
import com.soft1010.common.httpapi.parser.ReqMethod;

/**
 * @Author zhangjifu
 * @Create time: 2017/2/17 11:31
 * @Description:
 */
public interface DemoAPI2 {

    int retry = 2;
    int timeout = 6000;

    @ApiInfo(url = "/test", contentType = ContentType.URLENCODED,
            method = ReqMethod.GET, retryCount = retry, timeout = timeout)
    boolean test(@ApiParam(paramKey = "a") String tmp);
}
