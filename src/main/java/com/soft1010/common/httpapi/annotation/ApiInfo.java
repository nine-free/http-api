package com.soft1010.common.httpapi.annotation;


import com.soft1010.common.httpapi.parser.ContentType;
import com.soft1010.common.httpapi.parser.ReqMethod;

import java.lang.annotation.*;

/**
 * @author
 *         create time: 2016-06-24
 *         Description: http api调用基本方法
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiInfo {
    /**
     * api相对路径url
     *
     * @return
     */
    String url() default "";

    /**
     * api方法
     *
     * @return
     */
    ReqMethod method() default ReqMethod.POST;

    /**
     * 数据字段路径
     *
     * @return
     */
    String resultPath() default "";

    /**
     * 验证字段路径
     *
     * @return
     */
    String validatePath() default "";

    /**
     * 验证规则，正则表达式
     *
     * @return
     */
    String validateRule() default "^0$";

    /**
     * 重试次数，默认不重试
     *
     * @return
     */
    int retryCount() default 0;

    /**
     * 超时时间
     *
     * @return
     */
    int timeout() default -1;

    ContentType contentType() default ContentType.URLENCODED;
}
