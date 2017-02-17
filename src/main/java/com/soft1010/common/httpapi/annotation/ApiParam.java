package com.soft1010.common.httpapi.annotation;

import java.lang.annotation.*;

/**
 * @author
 * create time: 2016-06-24
 * Description: api参数
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiParam {

    /**
     * 请求参数key
     *
     * @return
     */
    String paramKey() default "";

    /**
     * 当参数为null是，是否需要拼接到http参数中
     *
     * @return
     */
    boolean serializeNull() default false;

    /**
     * 是否必须，默认为非必须
     *
     * @return
     */
    boolean required() default false;
}
