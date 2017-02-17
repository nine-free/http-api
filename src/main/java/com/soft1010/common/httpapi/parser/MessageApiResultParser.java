package com.soft1010.common.httpapi.parser;

import com.alibaba.fastjson.JSONObject;
import com.soft1010.common.httpapi.ApiInvocation;
import com.soft1010.common.httpapi.ApiResultParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author zhangjifu
 * @Create time: 2016/11/9 16:52
 * @Description:
 */
public class MessageApiResultParser implements ApiResultParser {

    private static final Logger logger = LogManager.getLogger(MessageApiResultParser.class);

    @Override
    public Object parse(ApiInvocation apiInvocation) {
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.parse(apiInvocation.getRawResult());
            if (jsonObject != null && jsonObject.getInteger("code") == 200 && "OK".equalsIgnoreCase(jsonObject.getString("message"))) {
                return true;
            }
            logger.error("消息发送失败 result={}", JSONObject.toJSONString(apiInvocation.getRawResult()));
        } catch (Exception e) {
            logger.error("rpc parse error data=" + apiInvocation.getRawResult(), e);
        }
        return false;
    }
}
