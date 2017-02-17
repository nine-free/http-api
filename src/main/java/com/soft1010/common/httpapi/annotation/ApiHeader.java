package com.soft1010.common.httpapi.annotation;

import java.lang.annotation.*;

/**
 * @author
 * create time: 2016-06-24
 * Description: http api的request header
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiHeader {

    /**
     * header名称
     *
     * @return
     */
    String headerKey() default "";
}
