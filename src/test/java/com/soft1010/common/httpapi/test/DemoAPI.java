package com.soft1010.common.httpapi.test;

import com.soft1010.common.httpapi.annotation.ApiInfo;
import com.soft1010.common.httpapi.annotation.ApiParam;
import com.soft1010.common.httpapi.parser.ContentType;
import com.soft1010.common.httpapi.parser.ReqMethod;

/**
 * @Author zhangjifu
 * @Create time: 2017/2/17 10:57
 * @Description:
 */
public interface DemoAPI {

    int retry = 2;
    int timeout = 2000;

    @ApiInfo(url = "/summaryMessage/send", contentType = ContentType.JSON,
            method = ReqMethod.POST,
            retryCount = retry, timeout = timeout)
    boolean sendMail(@ApiParam(paramKey = "code") String code,
                     @ApiParam(paramKey = "nodeCode") String nodeCode,
                     @ApiParam(paramKey = "token") String token,
                     @ApiParam(paramKey = "mailMessageRequestDto") MailMessageRequestDto mailMessageRequestDto);





}
